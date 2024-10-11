package com.exp.ucmp.role.service.impl;

import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.role.dao.SysRoleDao;
import com.exp.ucmp.role.dto.ResourceContentDto;
import com.exp.ucmp.role.dto.ResourceInfoDto;
import com.exp.ucmp.role.dto.RolePermissionRelaDto;
import com.exp.ucmp.role.dto.SysRoleDetailsDto;
import com.exp.ucmp.role.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * @author zhouchengwei
 * @date 2022年08月11日
 */

@Service
public class SysRoleServiceImpl implements SysRoleService {


    @Autowired
    private SysRoleDao sysRoleDao;



    @Autowired
    private IPartyRoleRelaDao partyRoleRelaDao;


    @Autowired
    private IRoleInfoDao iRoleInfoDao;

    @Autowired
    private ISysRoleDetailsDao iSysRoleDetailsDao;


    @Autowired
    private IRolePermissionRelaDao iRolePermissionRelaDao;


    @Autowired
    private IPermissionInfoDao iPermissionInfoDao;

    /**
     * Description: 根据条件查询集合实体(角色信息)
     *
     * @param sysRoleDetailsDto 查询条件
     * @return 实体集合
     */
    @Override
    public PageInfo<SysRoleDetailsDto> queryRoleMsg(SysRoleDetailsDto sysRoleDetailsDto) {

        PageHelper.startPage(sysRoleDetailsDto.getPageNum(), sysRoleDetailsDto.getPageSize());
        List<SysRoleDetailsDto> sysRoleInfoList = sysRoleDao.selectRoleMsg(sysRoleDetailsDto);
        PageInfo<SysRoleDetailsDto> page = new PageInfo<SysRoleDetailsDto>(sysRoleInfoList);
        return page;
    }

    /**
     * Description: 根据条件查询集合实体(角色授权信息菜单)
     *
     * @param resourceInfoDto 查询条件
     * @return 实体集合
     */
    @Override
    public List<ResourceInfoDto> queryRoleMenuList(ResourceInfoDto resourceInfoDto) {
    	//查询角色是总部角色还是门店角色
    	String roleType=sysRoleDao.getRoleType(resourceInfoDto.getRoleId());
    	int type;
    	if(Constants.RoleType.headquarters.value().equals(roleType)){
    		type = 1;
    	}else if(Constants.RoleType.store.value().equals(roleType)){
    		type= 2;
    	}else{
    		type= 3;
    	}
    	
        /**
         * 查询所有资源信息resourceContent(用来查询资源菜单列表无序集合的)
         */
        List<ResourceContentDto> resourceContentDtos = sysRoleDao.selectOpeMag(null,type);
        /**
         * 用来存放拼接后的资源信息
         */
        List<String> resourceInfoDtoList = new ArrayList<>();
        /**
         * 返回给前端的权限列表树(集合)
         */
        List<ResourceInfoDto> result = new ArrayList<>();
        List<Map> list = new ArrayList<>();
        /**
         * 循环遍历查询出来的资源信息resourceContent,分割，组装;
         * 因为查询出来的资源信息是类似于：
         *     UCMP二手车平台:系统管理:人员管理:角色配置:页面
         *     UCMP二手车平台:系统管理:角色管理:角色维护:页面
         * 需要组装成：
         *    'UCMP二手车平台:系统管理:人员管理:角色配置:页面',
         *    'UCMP二手车平台:系统管理:角色管理:角色维护:页面',
         *    'UCMP二手车平台:系统管理:角色管理:权限配置:页面',
         *    'UCMP二手车平台:系统管理:人员管理:人员维护',
         *    'UCMP二手车平台:系统管理:人员管理:角色配置',
         *    'UCMP二手车平台:系统管理:角色管理:角色维护',
         *    'UCMP二手车平台:系统管理:角色管理:权限配置',
         *    'UCMP二手车平台:系统管理:人员管理',
         *    'UCMP二手车平台:系统管理:角色管理',
         *    'UCMP二手车平台:系统管理',
         *    'UCMP二手车平台'
         * 之后添加到resourceInfoDtoList中去，作为参数查询资源的详细信息
         */
        for (int i = 0; i < resourceContentDtos.size(); i++) {
            String resourceContent = resourceContentDtos.get(i).getResourceContent();
            String[] resourceContentSplit = resourceContent.split(":");
            StringBuffer contentBuffer = new StringBuffer("");
            int length = resourceContentSplit.length;
            for (int j = 0; j < resourceContentSplit.length; j++) {
                if (j == 0 || j == length) {
                    contentBuffer = contentBuffer.append(resourceContentSplit[j]);
                } else {
                    contentBuffer = contentBuffer.append(":").append(resourceContentSplit[j]);
                }
                resourceInfoDtoList.add(contentBuffer.toString());
            }
        }
        resourceInfoDto.setResourceContentList(resourceInfoDtoList);
        /**
         * 查询资源详情
         */
        List<ResourceInfoDto> resourceInfoDtoTreeList = sysRoleDao.selectOpeTree(resourceInfoDto);
        /**
         * 获取下级级资源详情信息
         */
        List<ResourceInfoDto> collects =
                resourceInfoDtoTreeList.stream().filter(a -> a.getParentResourceId() ==null).collect(Collectors.toList());
        /**
         * 循环下级资源内容,添加到结果集result
         */
        for (int i = 0; i < collects.size(); i++) {
            ResourceInfoDto resourceInfo = new ResourceInfoDto();
            /**
             * 获取当前级的资源详情
             */
            resourceInfo.setResourceContent(collects.get(i).getResourceContent());
            resourceInfo.setResourceId(collects.get(i).getResourceId());
            resourceInfo.setResourceName(collects.get(i).getResourceName());
            resourceInfo.setApplicationId(collects.get(i).getApplicationId());
            resourceInfo.setResourceDesc(collects.get(i).getResourceDesc());
            resourceInfo.setParentResourceId(collects.get(i).getParentResourceId());
            Long resourceId = collects.get(i).getResourceId();
            /**
             * 判断当前角色是否存在该资源权限
             */
            List<RolePermissionRelaDto> rolePermissionRelaDtos
                    = sysRoleDao.selectRolePerRel(resourceInfoDto.getRoleId());
            for (int j = 0; j < rolePermissionRelaDtos.size(); j++) {
                if (rolePermissionRelaDtos.get(j).getPermissionId()==null&&
                        (!StringUtil.isEmpty(rolePermissionRelaDtos.get(j).getPermissionWildcards()))) {
                    String permissionWildcards = rolePermissionRelaDtos.get(j).getPermissionWildcards();
                    String perWilSubstring = permissionWildcards.substring(0, permissionWildcards.lastIndexOf(":"));
                    if (collects.get(i).getResourceContent().equals(perWilSubstring)) {
                        collects.get(i).setTickFlag(true);
                        resourceInfo.setTickFlag(collects.get(i).getTickFlag());
                    }
                }
            }
            /**
             * 获取下级资源
             */
            List<ResourceInfoDto> collect = resourceInfoDtoTreeList.stream().filter(b ->
                    b.getParentResourceId()!=null&&
                            b.getParentResourceId().equals(resourceId)).collect(Collectors.toList());
            /**
             * 如果不存在下级资源就添加操作信息(增删改查，导入,导出.......)
             */
            if (CollectionUtils.isEmpty(collect)) {
                List<ResourceContentDto> opeRoleLists = sysRoleDao.selectOpeMag(collects.get(i).getResourceId(), type);
                for (int j = 0; j < opeRoleLists.size(); j++) {
                    String[] split = opeRoleLists.get(j).getOperPermission().split(",");
                    for (int k = 0; k < split.length; k++) {
                        String[] split1 = split[j].split(":");
                        HashMap map = new HashMap();
                        map.put("operationId", split1[0]);
                        map.put("operationName", split1[1]);
                        map.put("permissionId", split1[2]);
                        /**
                         * 判断当前角色是否存在该操作权限
                         */
                        for (int l = 0; l < rolePermissionRelaDtos.size(); l++) {

                            if (!(rolePermissionRelaDtos.get(l).getPermissionId()== null)  &&
                                    (StringUtil.isEmpty(rolePermissionRelaDtos.get(l).getPermissionWildcards().trim()))) {
                                if (String.valueOf(rolePermissionRelaDtos.get(l).getPermissionId()).equals(String.valueOf(map.get("operationId")))) {
                                    map.put("tickFlag", true);
                                }
                            }
                        }

                        list.add(map);
                        resourceInfo.setRoleOpeList(list);
                    }
                }
                resourceInfo.setResourceList(new ArrayList<>());
            } else {
                /**
                 * 如果存在下级,就继续遍历以上操作
                 */
                List<ResourceInfoDto> twoTreeList = getTwoTreeInfo(collect, resourceInfoDtoTreeList, resourceInfoDto,type);
                resourceInfo.setResourceList(twoTreeList);
            }
            /**
             * 把所有分类好的信息组装成树田间到result中
             */
            result.add(resourceInfo);
        }
        return result;
    }
    /**
     * 获取下级菜单信息公共方法
     * @param type 
     */
    public List<ResourceInfoDto> getTwoTreeInfo(List<ResourceInfoDto> collect, List<ResourceInfoDto> resourceInfoDtoTreeList, ResourceInfoDto resourceInfoDto, int type) {
        List<ResourceInfoDto> result = new ArrayList<>();

        for (int i = 0; i < collect.size(); i++) {
            List<Map> list = new ArrayList<>();
            ResourceInfoDto resourceInfo = new ResourceInfoDto();
            resourceInfo.setResourceContent(collect.get(i).getResourceContent());
            resourceInfo.setResourceId(collect.get(i).getResourceId());
            resourceInfo.setResourceName(collect.get(i).getResourceName());
            resourceInfo.setApplicationId(collect.get(i).getApplicationId());
            resourceInfo.setResourceDesc(collect.get(i).getResourceDesc());
            resourceInfo.setParentResourceId(collect.get(i).getParentResourceId());
            Long resourceId = collect.get(i).getResourceId();

            List<RolePermissionRelaDto> rolePermissionRelaDtos
                    = sysRoleDao.selectRolePerRel(resourceInfoDto.getRoleId());
            for (int j = 0; j < rolePermissionRelaDtos.size(); j++) {
                if (rolePermissionRelaDtos.get(j).getPermissionId() == null &&
                        !StringUtil.isEmpty(rolePermissionRelaDtos.get(j).getPermissionWildcards())) {
                    String permissionWildcards = rolePermissionRelaDtos.get(j).getPermissionWildcards();
                    String perWilSubstring = permissionWildcards.substring(0, permissionWildcards.lastIndexOf(":"));
                    if (collect.get(i).getResourceContent().equals(perWilSubstring)) {
                        collect.get(i).setTickFlag(true);
                        resourceInfo.setTickFlag(collect.get(i).getTickFlag());
                    }

                }
            }


            List<ResourceInfoDto> threeInfoList = resourceInfoDtoTreeList.stream().filter(b ->
                    b.getParentResourceId()!=null &&
                            b.getParentResourceId().equals(resourceId)).collect(Collectors.toList());
            if (CollectionUtils.isEmpty(threeInfoList)) {
                List<ResourceContentDto> opeRoleLists = sysRoleDao.selectOpeMag(collect.get(i).getResourceId(), type);

                for (int j = 0; j < opeRoleLists.size(); j++) {
                    String[] split = opeRoleLists.get(j).getOperPermission().split(",");
                    for (int k = 0; k < split.length; k++) {
                        String[] split1 = split[k].split(":");
                        HashMap map = new HashMap();
                        map.put("operationId", split1[0]);
                        map.put("operationName", split1[1]);
                        map.put("permissionId", split1[2]);
                        for (int l = 0; l < rolePermissionRelaDtos.size(); l++) {
                            if (rolePermissionRelaDtos.get(l).getPermissionId()!=null &&
                                    (StringUtil.isEmpty(rolePermissionRelaDtos.get(l).getPermissionWildcards()))) {
                                Long permissionId = rolePermissionRelaDtos.get(l).getPermissionId();
                                if (String.valueOf(permissionId).equals(String.valueOf(map.get("permissionId")))) {
                                    map.put("tickFlag", true);
                                }
                            }
                        }

                        list.add(map);
                        resourceInfo.setRoleOpeList(list);


                    }
                }
                resourceInfo.setResourceList(new ArrayList<>());
            } else {
                List<ResourceInfoDto> threeTreeList = getTwoTreeInfo(threeInfoList, resourceInfoDtoTreeList, resourceInfoDto, type);
                resourceInfo.setResourceList(threeTreeList);
            }
            result.add(resourceInfo);
        }

        return result;
    }

    /**
     * Description: 新增角色信息
     *
     * @param sysRoleDetailsDto 新增内容
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRoleMsg(SysRoleDetailsDto sysRoleDetailsDto) {
        SysRoleDetailsEntity sysRoleDetailsEntity = new SysRoleDetailsEntity();
        sysRoleDetailsEntity.setRoleDetailsType(sysRoleDetailsDto.getRoleDetailsType());
        sysRoleDetailsEntity.setRoleDetailsName(sysRoleDetailsDto.getRoleDetailsName());
        int roleCount = iSysRoleDetailsDao.selectBySelectiveCount(sysRoleDetailsEntity);
        try {
            if (roleCount > 0) {
                throw new IllegalParameterException("角色(" + sysRoleDetailsDto.getRoleDetailsName() + ")已存在，不能新增!");
            } else {
                sysRoleDetailsEntity =
                        Copiers.beanToBean(sysRoleDetailsDto, SysRoleDetailsDto.class, SysRoleDetailsEntity.class);
                sysRoleDetailsEntity.generatePk();
                sysRoleDetailsEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                sysRoleDetailsEntity.setUpdatedBy(sysRoleDetailsEntity.getCreatedBy());

                iSysRoleDetailsDao.insertSelective(sysRoleDetailsEntity);

                RoleInfoEntity roleInfoEntity = new RoleInfoEntity();
                roleInfoEntity.setRoleId(sysRoleDetailsEntity.getRoleId());
                roleInfoEntity.setRoleName(sysRoleDetailsEntity.getRoleDetailsName());
                roleInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                roleInfoEntity.setUpdatedBy(roleInfoEntity.getCreatedBy());
                roleInfoEntity.setIsDelete(Constants.DeleteRemak.UN_DELETE.value());
                roleInfoEntity.setIsValid(Constants.RoleIfAvailable.effective.value());
                roleInfoEntity.setRoleType(Constants.RoleType.headquarters.value());
                iRoleInfoDao.insertSelective(roleInfoEntity);
            }
        } finally {
            sysRoleDetailsEntity = null;
        }

    }

    /**
     * Description: 修改角色信息
     *
     * @param sysRoleDetailsDto 修改内容
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyRoleMsg(SysRoleDetailsDto sysRoleDetailsDto) {
        SysRoleDetailsEntity sysRoleDetailsEntity = new SysRoleDetailsEntity();
        sysRoleDetailsEntity.setRoleCode(sysRoleDetailsDto.getRoleCode());
        int roleCount = iSysRoleDetailsDao.selectBySelectiveCount(sysRoleDetailsEntity);
        try {
            if (roleCount <= 0) {
                throw new IllegalParameterException("角色编码不能修改!");
            } else {
                sysRoleDetailsEntity =
                        Copiers.beanToBean(sysRoleDetailsDto, SysRoleDetailsDto.class, SysRoleDetailsEntity.class);

                sysRoleDetailsEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                iSysRoleDetailsDao.updateSelective(sysRoleDetailsEntity);
                RoleInfoEntity roleInfoEntity = new RoleInfoEntity();
                roleInfoEntity.setRoleId(sysRoleDetailsDto.getRoleId());
                List<RoleInfoEntity> roleInfoEntities = iRoleInfoDao.selectBySelective(roleInfoEntity);
                for (int i = 0; i < roleInfoEntities.size(); i++) {
                    if (Constants.IsDelete.NO.value().equals(roleInfoEntities.get(i).getIsDelete())) {
                        roleInfoEntity.setRoleName(sysRoleDetailsDto.getRoleDetailsName());
                        roleInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                        iRoleInfoDao.updateSelective(roleInfoEntity);
                    }
                }

            }
        } finally {
            sysRoleDetailsEntity = null;
        }
    }

    @Override
    public void modifyRolePower(RolePermissionRelaDto rolePermissionRelaDto) {
        List<RolePermissionRelaDto> rolePermissionRelaList = rolePermissionRelaDto.getRolePermissionRelaList();
        List<RolePermissionRelaEntity> rolePermissionRelaEntitieList = new ArrayList<>();
        RolePermissionRelaEntity delRolePermissionRelaEntity = new RolePermissionRelaEntity();
        delRolePermissionRelaEntity.setRoleId(rolePermissionRelaDto.getRoleId());
        iRolePermissionRelaDao.deleteBySelective(delRolePermissionRelaEntity);
        if (rolePermissionRelaList.size()>0){
            for (int i = 0; i < rolePermissionRelaList.size(); i++) {

                //permission_id，只有t_permission_info里有的permission_id，才加到t_role_permission_rela里
                PermissionInfoEntity permissionInfoEntity = new PermissionInfoEntity();
                permissionInfoEntity.setPermissionId(rolePermissionRelaList.get(i).getPermissionId());
                int permissionCount = iPermissionInfoDao.selectBySelectiveCount(permissionInfoEntity);
                if (permissionCount>0){
                    RolePermissionRelaEntity rolePermissionRelaEntity = new RolePermissionRelaEntity();
                    RolePermissionRelaDto rolePermissionRelaDtos = rolePermissionRelaList.get(i);
                    rolePermissionRelaEntity =
                            Copiers.beanToBean(rolePermissionRelaDtos, RolePermissionRelaDto.class, RolePermissionRelaEntity.class);
                    rolePermissionRelaEntity.generatePk();
                    rolePermissionRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                    rolePermissionRelaEntity.setUpdatedBy(rolePermissionRelaEntity.getCreatedBy());
                    rolePermissionRelaEntitieList.add(rolePermissionRelaEntity);
                }

            }
            if (rolePermissionRelaEntitieList.size()>0){
                iRolePermissionRelaDao.batchInsert(rolePermissionRelaEntitieList);
            }

        }

    }

    /**
     * Description: 删除角色信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delRoleMsg(SysRoleDetailsDto sysRoleDetailsDto) {
        SysRoleDetailsEntity sysRoleDetailsEntity = new SysRoleDetailsEntity();
        try {

            sysRoleDetailsEntity.setRoleId(sysRoleDetailsDto.getRoleId());
            PartyRoleRelaEntity partyRoleRelaEntity = new PartyRoleRelaEntity();
            partyRoleRelaEntity.setRoleId(sysRoleDetailsDto.getRoleId());
            int partyCount = partyRoleRelaDao.selectBySelectiveCount(partyRoleRelaEntity);
            if (partyCount > 0) {
                throw new IllegalParameterException("角色" + sysRoleDetailsDto.getRoleDetailsName() + ":存在人员，不能删除");
            } else {
                iSysRoleDetailsDao.deleteBySelective(sysRoleDetailsEntity);
                RoleInfoEntity roleInfoEntity = new RoleInfoEntity();
                roleInfoEntity.setIsDelete(String.valueOf(Constants.IsDelete.YES.value()));
                roleInfoEntity.setRoleId(sysRoleDetailsDto.getRoleId());
                roleInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                iRoleInfoDao.updateSelective(roleInfoEntity);
            }


        } finally {
            sysRoleDetailsEntity = null;
        }
    }


    /**
     * Description: 查询角色类型
     *
     * @return 角色类型（门店0020、总部0010.......）
     */
    @Override
    public List<String> QueryRoleType() {
        return sysRoleDao.selectRoleType();
    }

    @Override
    public List<SysRoleDetailsDto> findSelectRoleType() {
        List<SysRoleDetailsEntity> sysRoleDetailsEntities = iSysRoleDetailsDao.selectBySelective(new SysRoleDetailsEntity());
        List<SysRoleDetailsDto> sysRoleDetailsDtos = Copiers.beansToBeans(sysRoleDetailsEntities, SysRoleDetailsEntity.class, SysRoleDetailsDto.class);
        return sysRoleDetailsDtos;
    }
}
