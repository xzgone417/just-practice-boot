/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.auth.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.egrid.cache.jedis.cache.RedisCache;
import com.egrid.core.base.model.BaseModel;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.egrid.shiro.constants.ShiroConstants;
import com.egrid.shiro.model.Menu;
import com.egrid.shiro.model.SystemMenu;
import com.exp.ucmp.auth.dao.AuthDao;
import com.exp.ucmp.auth.dto.PermissionIdentifierDto;
import com.exp.ucmp.auth.dto.StaffDto;
import com.exp.ucmp.auth.dto.SystemMenuDto;
import com.exp.ucmp.auth.service.AuthService;
import com.exp.ucmp.auth.web.MenuController;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.entity.SysMenuExtendedInfoEntity;
import com.exp.ucmp.model.Person;


//import jodd.util.StringUtil;

/**
 * @author Yiyongfei
 */
@Service
public class AuthServiceImpl implements AuthService {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private AuthDao authDao;

    @Autowired
    private RedisCache shiroRedisCache;
    
    /**
     * 获取自然人信息
     * 
     * @param partyId 自然人
     * @return
     */
    @Override
    public Person loadPersonById(String loginName) {
    	List<Person> listUser = authDao.selectPersonByloginname(loginName);
    	if (listUser != null && listUser.size() > 0) {
    		Person person = null;
    		for (Person user : listUser) {
    			person = user;
    			if (hrytPartyId.equals(person.getOrganId())) {
    				/*如果查到的人员组织中有华人运通的，机构先设置为华人运通*/
    				break;
    			}
    		}
    		return person;
    	} else {
    		return null;
    	}
    }
    /**
     * 获取某用户所属角色所有权限
     * @param partyId 自然人
     * @return
     */
	@Override
	public List<PermissionIdentifierDto> listRolePermissionByLoginid(Long partyId, Long roleId) {
		return authDao.listRolePermissionByLoginid(partyId, roleId);
	}
    /**
     * 获取某用户所属角色所有权限
     * @param partyId 自然人
     * @return
     */
	@Override
	public SystemMenu listMenuByLoginid(Long partyId, Long roleId) {
		InnerMenu _menu = new InnerMenu(authDao);
		return _menu.menu(partyId, roleId);
	}
    /**
     * 处理菜单的扩展信息
     * @param systemMenu 菜单
     * @return
     */
	@Override
	public SystemMenu handleMenuExtendedInfo(SystemMenu systemMenu) {
		List<SysMenuExtendedInfoEntity> listMenuExtended = authDao.selectMenuExtendedInfo(new SysMenuExtendedInfoEntity());
		if (listMenuExtended.size() > 0) {
			Map<Long, String> mapMenuExtended = new HashMap<>();
			for(SysMenuExtendedInfoEntity entity : listMenuExtended) {
				mapMenuExtended.put(entity.getMenuId(), entity.getMenuPath());
			}
			Set<Menu> menus = systemMenu.getMenus();
			for (Menu menu : menus) {
				handleMenuExtendedInfo(mapMenuExtended, menu);
			}
		}
		
		return systemMenu;
	}
	
	private void handleMenuExtendedInfo(Map<Long, String> mapMenuExtended, Menu menu) {
		if (StringUtil.isEmpty(menu.getMenuPath()) || menu.getMenuPath().equals("#")) {
			if (mapMenuExtended.containsKey(menu.getMenuId())) {
				menu.setMenuPath(mapMenuExtended.get(menu.getMenuId()));
			}
		}
		
		Set<Menu> childMenus = menu.getChildMenu();
		for (Menu childMenu : childMenus) {
			handleMenuExtendedInfo(mapMenuExtended, childMenu);
		}
	}

    /**
     * 获取员工信息
     * 
     * @param partyId 自然人
     * @return
     */
    @Override
	public StaffDto loadStaffById(Long partyId, String orgId, Constants.StaffType staffType) {
		List<Map<String, Object>> listMap = authDao.selectStaffById(partyId);
		if (listMap.size() == 0) {
			return null;
		} else if (listMap.size() == 1) {
			Map<String, Object> map = listMap.get(0);
			if (map != null && !map.isEmpty()) {
				StaffDto staffDto = new StaffDto();
				staffDto.setStaffType((String) map.get("staff_type"));
				staffDto.setStaffStatus((String) map.get("staff_status"));
				staffDto.setStaffIsDelete(String.valueOf(map.get("staff_is_delete")));
				if (staffType == null || !staffType.equals(Constants.StaffType.headquarters)) {
					/*登录员工是总部登录时，不设置门店或合作商*/
					if (map.get("store_name") != null && map.get("store_name").toString().trim().length() > 0) {
						staffDto.setOrgId(String.valueOf(map.get("store_id")));
						staffDto.setOrgName(String.valueOf(map.get("store_name")));
						staffDto.setOrgType(String.valueOf(map.get("store_type")));
						staffDto.setOrgStatus(String.valueOf(map.get("store_status")));
					} else if (map.get("partner_name") != null && map.get("partner_name").toString().trim().length() > 0) {
						staffDto.setOrgId(String.valueOf(map.get("partner_id")));
						staffDto.setOrgName(String.valueOf(map.get("partner_name")));
						staffDto.setOrgType(String.valueOf(map.get("partner_type")));
						staffDto.setOrgStatus(String.valueOf(map.get("partner_status")));
						staffDto.setOrgIsDelete(String.valueOf(map.get("partner_is_delete")));
					}
				}
				return staffDto;
			} else {
				return null;
			}
		} else {
			StaffDto staffDto = new StaffDto();
			for (Map<String, Object> map : listMap) {
				if (staffType != null) {
					if (!staffType.value().equals((String) map.get("staff_type"))) {
						continue;
					}
				}
				staffDto.setStaffType((String) map.get("staff_type"));
				staffDto.setStaffStatus((String) map.get("staff_status"));
				staffDto.setStaffIsDelete(String.valueOf(map.get("staff_is_delete")));
				if (staffType == null || !staffType.equals(Constants.StaffType.headquarters)) {
					/*登录员工是总部登录时，不设置门店或合作商*/
					if (map.get("partner_name") != null && map.get("partner_name").toString().trim().length() > 0) {
						staffDto.setOrgId(String.valueOf(map.get("partner_id")));
						staffDto.setOrgName(String.valueOf(map.get("partner_name")));
						staffDto.setOrgType(String.valueOf(map.get("partner_type")));
						staffDto.setOrgStatus(String.valueOf(map.get("partner_status")));
						staffDto.setOrgIsDelete(String.valueOf(map.get("partner_is_delete")));
					} else if (map.get("store_name") != null && map.get("store_name").toString().trim().length() > 0) {
						if (StringUtil.isEmpty(orgId)) {
							/*不指定门店ID时，取最后一家门店*/
							staffDto.setOrgId(String.valueOf(map.get("store_id")));
							staffDto.setOrgName(String.valueOf(map.get("store_name")));
							staffDto.setOrgType(String.valueOf(map.get("store_type")));
							staffDto.setOrgStatus(String.valueOf(map.get("store_status")));
						} else {
							/*指定门店ID时，当符合的门店拿到后，结束循环*/
							staffDto.setOrgId(String.valueOf(map.get("store_id")));
							staffDto.setOrgName(String.valueOf(map.get("store_name")));
							staffDto.setOrgType(String.valueOf(map.get("store_type")));
							staffDto.setOrgStatus(String.valueOf(map.get("store_status")));
							if (orgId.equals(String.valueOf(map.get("store_orgid")))) {
								break;
							}
						}
					}
				}
			}
			return staffDto;
		}
	}
    
    /**
     * 给用户发送验证码，并返回验证码
     * 
     * @param loginName 用户
     * @return 验证码
     */
	@Override
	public String sendVerificationCode(String receiver) {
		String verificationCode = generateVerificationCode();
		shiroRedisCache.put(getVerificationCodeCacheKey(receiver), verificationCode);
		sendVerificationCode(receiver, verificationCode);
		return verificationCode;
	}
	
	private void sendVerificationCode(String receiver, String verificationCode) {
		
	}
	/**
	 * 生成6位随机数字
	 * 
	 * @return 6位随机数字
	 */
	private String generateVerificationCode() {
		String chars = "0123456789";
		char[] rands = new char[6];
		for (int i = 0; i < 6; i++) {
			int rand = (int) (Math.random() * 10);
			rands[i] = chars.charAt(rand);
		}
		return new String(rands);
	}
	
	/**
	 * 验证码在redis的存放Key
	 * 
	 * @param key
	 * @return
	 */
    private String getVerificationCodeCacheKey(String key) {
        return ShiroConstants.CacheKeys.CACHE_VERIFICATION_CODE_KEY.endsWith(":") ? ShiroConstants.CacheKeys.CACHE_VERIFICATION_CODE_KEY : (ShiroConstants.CacheKeys.CACHE_VERIFICATION_CODE_KEY + ":") + key;
    }
    
    static class InnerMenu {
		private Set<Menu> topMenu = new TreeSet<Menu>(new MemuComparator<Menu>());
		private Map<Long, Menu> mapMenu = new HashMap<Long, Menu>();
		private AuthDao authDao;
		private InnerMenu(AuthDao authDao) {
			this.authDao = authDao;
		}
		
		public SystemMenu menu(Long partyId, Long roleId) throws AuthenticationException {
	    	List<Menu> listMenu = null;
			try {
				//查询人员的角色类型
				List<String> roleTypeList = this.authDao.getRoleType(partyId);
				LOGGER.info("====roleTypeList====="+JsonBeanUtil.beanToJson(roleTypeList));
				String roleType=null;
				if(!CollectionUtils.isEmpty(roleTypeList)){
					if(roleTypeList.contains("0010")){
						//存在总部端角色，默认展示总部菜单
						roleType="0010";
					}else{
						roleType=roleTypeList.get(0);
					}
				}
				listMenu = authDao.permissionMenuQuery(partyId, roleId,roleType);
				LOGGER.info("==listMenu1=="+JsonBeanUtil.beanToJson(listMenu));
				disposeMenu(listMenu, new ArrayList<>());
				LOGGER.info("==listMenu2=="+JsonBeanUtil.beanToJson(listMenu));
			} catch (Throwable e) {
	            final String message = "获取用户[" + partyId + "]时发生了远程获取用户菜单信息失败！";
	            throw new AuthenticationException(message, e);
	        } finally {
	            mapMenu.clear();
	        }
			
			SystemMenu sysMenu = new SystemMenu();
			sysMenu.setMenus(topMenu);
			return sysMenu;
		}
		
		private void disposeMenu(List<Menu> listMenu, List<Menu> childMenu) {
		    List<Menu> tmpMenu = new ArrayList<Menu>();
		    List<Menu> list = new ArrayList<>();
		    for(Menu menu : listMenu) {
                if (mapMenu.containsKey(menu.getMenuId())) {
                    continue;
                } else {
                    list.add(menu);
                }
                if(StringUtil.isEmpty(menu.getMenuPath())) {
                    menu.setMenuPath("#");
                }
                menu.setChildMenu(new TreeSet<Menu>(new MemuComparator<Menu>()));
                if(menu.getParentMenuId() == null) {
                    mapMenu.put(menu.getMenuId(), menu);
                    topMenu.add(menu);
                } else {
                    mapMenu.put(menu.getMenuId(), menu);
                    tmpMenu.add(menu);
                }
            }
		    
		    for(Menu menu : childMenu) {
                if(mapMenu.containsKey(menu.getParentMenuId())) {
                    mapMenu.get(menu.getParentMenuId()).getChildMenu().add(menu);
                }
            }
		    
		    if(tmpMenu.size() > 0) {
	            List<Menu> parentMenu = null;
	            try {
	                parentMenu = authDao.parentMenuQuery(tmpMenu);
	            } catch (Throwable e) {
	                final String message = "获取用户时发生了远程获取用户菜单信息失败！";
	                throw new AuthenticationException(message, e);
	            }
		        disposeMenu(parentMenu, list);
            }
		}
	}
    
    static class MemuComparator<Menu> extends BaseModel implements Comparator<Menu>{
    	private static final long serialVersionUID = 1L;

    	public int compare(Menu menu1, Menu menu2) {
    		if (((com.egrid.shiro.model.Menu) menu1).getMenuSequence() == null) {
    			return -1;
    		} else if (((com.egrid.shiro.model.Menu) menu2).getMenuSequence() == null) {
    			return 1;
    		} else if (((com.egrid.shiro.model.Menu) menu1).getMenuSequence() > ((com.egrid.shiro.model.Menu) menu2)
    				.getMenuSequence()) {
    			return 1;
    		} else {
    			return -1;
    		}
    	}
    }
    
	@Override
	public List<SystemMenuDto> transform(SystemMenu systemMenu) {
		//获取一级菜单
		List<SystemMenuDto> oneMenuDtoList=new ArrayList<>();
		systemMenu.getMenus().forEach(menu ->{
			menu.getChildMenu().forEach(one ->{
				SystemMenuDto oneMenuDto=new SystemMenuDto();
				oneMenuDto.setMenuName(one.getMenuName());
				oneMenuDto.setMenuPath(one.getMenuPath());
				oneMenuDto.setMenuSequence(one.getMenuSequence());
				/*if(!"库存管理".equals(one.getMenuName())){
					//获取二级菜单
					List<SystemMenuDto> twoMenuDtoList=new ArrayList<>();
					SystemMenuDto twoMenuDto=new SystemMenuDto();
					twoMenuDto.setMenuName(one.getMenuName());
					twoMenuDto.setMenuPath(one.getMenuPath());
					twoMenuDto.setMenuSequence(one.getMenuSequence());
					//获取三级级菜单
					List<SystemMenuDto> threeMenuDtoList=new ArrayList<>();
					one.getChildMenu().forEach(three ->{
						SystemMenuDto threeMenuDto=new SystemMenuDto();
						threeMenuDto.setMenuName(three.getMenuName());
						threeMenuDto.setMenuPath(three.getMenuPath());
						threeMenuDto.setMenuSequence(three.getMenuSequence());
						threeMenuDtoList.add(threeMenuDto);
					});
					twoMenuDto.setChildMenu(threeMenuDtoList);
					twoMenuDtoList.add(twoMenuDto);
					oneMenuDto.setChildMenu(twoMenuDtoList);
				}else{*/
//					oneMenuDto.setMenuPath("/storeManage");
					List<SystemMenuDto> twoMenuDtoList=new ArrayList<>();
					//获取二级菜单
					one.getChildMenu().forEach(two ->{
						SystemMenuDto twoMenuDto=new SystemMenuDto();
						twoMenuDto.setMenuName(two.getMenuName());
						twoMenuDto.setMenuPath(two.getMenuPath());
						twoMenuDto.setMenuSequence(two.getMenuSequence());
						//获取三级级菜单
						List<SystemMenuDto> threeMenuDtoList=new ArrayList<>();
						two.getChildMenu().forEach(three ->{
							SystemMenuDto threeMenuDto=new SystemMenuDto();
							threeMenuDto.setMenuName(three.getMenuName());
							threeMenuDto.setMenuPath(three.getMenuPath());
							threeMenuDto.setMenuSequence(three.getMenuSequence());
							threeMenuDtoList.add(threeMenuDto);
						});
						twoMenuDto.setChildMenu(threeMenuDtoList);
						twoMenuDtoList.add(twoMenuDto);
					});
					oneMenuDto.setChildMenu(twoMenuDtoList);
//				}
				oneMenuDtoList.add(oneMenuDto);
			});
		});
		return oneMenuDtoList;
		
	}
	@Override
	public String checkStroe(String orgId) {
		return this.authDao.checkStroe(orgId);
	}
	@Override
	public String checkIsControls() {
		return this.authDao.checkIsControls();
	}
}
