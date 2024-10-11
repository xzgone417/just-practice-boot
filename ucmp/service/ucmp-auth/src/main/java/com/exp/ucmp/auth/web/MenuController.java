package com.exp.ucmp.auth.web;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.shiro.model.User;
import com.egrid.core.util.ExceptionUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.RestResponseUtil;
import com.egrid.core.util.StringUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.shiro.constants.ShiroConstants;
import com.egrid.shiro.model.SystemMenu;
import com.exp.ucmp.auth.dto.SystemMenuDto;
import com.exp.ucmp.auth.service.AuthService;
import com.exp.ucmp.util.SignUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Yiyongfei
 * @date 2018年8月17日
 */
@Api(value = "Menu.API", tags = "菜单接口")
@RefreshScope
@Controller
public class MenuController {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private AuthService authService;

    /**
     * <p>
     * Description: 用户登录验证
     * </p>
     * 
     * @return 查询结果
     */
    @ApiOperation(value = "用户菜单", notes = "用户菜单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/menu/list", method = RequestMethod.GET)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "roleId", value = "角色ID", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = SystemMenu.class)
    public RestResponse<SystemMenu> listMenu(@RequestParam(value="roleId", required=false) String roleId) {
    	Long _roleId = null;
    	try {
        	if (!StringUtil.isEmpty(roleId)) {
        		_roleId = Long.valueOf(roleId);
        	}
    	} catch (Exception ex) {
    		//如果roleId不是有效的数字，按Null进行处理
    	}
        try {
            Subject currentUser = SecurityUtils.getSubject();
            if (currentUser.isAuthenticated()) {
                SystemMenu systemMenu = null;
                if (_roleId == null) {
                	systemMenu = (SystemMenu)currentUser.getSession().getAttribute(ShiroConstants.SYSTEM_MENU);
                } else {
                	Session session = currentUser.getSession();
                	User user = (User)session.getAttribute(session.getId());
                	systemMenu = authService.listMenuByLoginid(user.getPartyId(), _roleId);
                }
                
                systemMenu = authService.handleMenuExtendedInfo(systemMenu);
                return new RestResponse<SystemMenu>(systemMenu);
            } else {
                /*未登录用户，默认菜单，暂未实现*/
                return new RestResponse<SystemMenu>(new SystemMenu());
            }
        } catch (Exception e) {
            LOGGER.error("获取菜单出现异常: {}", ExceptionUtil.getStackTraceAsString(e));
            return RestResponseUtil.restProcessException(e);
        }
    }
    
    
    @ApiOperation(value = "用户菜单", notes = "用户菜单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v2/menu/list", method = RequestMethod.GET)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "roleId", value = "角色ID", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = MenuDto.class)
    public RestResponse<MenuDto> listMenuV2(@RequestParam(value="roleId", required=false) String roleId) {
    	Long _roleId = null;
    	try {
        	if (!StringUtil.isEmpty(roleId)) {
        		_roleId = Long.valueOf(roleId);
        	}
    	} catch (Exception ex) {
    		//如果roleId不是有效的数字，按Null进行处理
    	}
        try {
            Subject currentUser = SecurityUtils.getSubject();
            if (currentUser.isAuthenticated()) {
            	Session session = currentUser.getSession();
            	User user = (User)session.getAttribute(session.getId());
                SystemMenu systemMenu ;
                LOGGER.info("=====_roleId==="+_roleId);
               /* if (_roleId == null) {
                	systemMenu = (SystemMenu)currentUser.getSession().getAttribute(ShiroConstants.SYSTEM_MENU);
                	LOGGER.info("=====systemMenu11====="+JsonBeanUtil.beanToJson(systemMenu));
                } else {*/
                	systemMenu = authService.listMenuByLoginid(user.getPartyId(), _roleId);
                	LOGGER.info("=====systemMenu12====="+JsonBeanUtil.beanToJson(systemMenu));
//                }
                systemMenu = authService.handleMenuExtendedInfo(systemMenu);
                LOGGER.info("=====systemMenu2====="+JsonBeanUtil.beanToJson(systemMenu));
//                //数据结构转换
                List<SystemMenuDto> systemMenuDto = authService.transform(systemMenu);
                String jsonMenu = JsonBeanUtil.beanToJson(systemMenuDto);
                String sign = SignUtils.encryptUpper(String.valueOf(user.getPartyId()) + jsonMenu);
                return new RestResponse<MenuDto>(new MenuDto(sign, jsonMenu));
            } else {
                /*未登录用户，默认菜单，暂未实现*/
                return new RestResponse<MenuDto>(new MenuDto("", JsonBeanUtil.beanToJson(new SystemMenu())));
            }
        } catch (Exception e) {
            LOGGER.error("获取菜单出现异常: {}", ExceptionUtil.getStackTraceAsString(e));
            return RestResponseUtil.restProcessException(e);
        }
    }
    
    public static class MenuDto {
    	String sign;
    	String menu;
    	MenuDto(String sign, String menu) {
    		this.sign = sign;
    		this.menu = menu;
    	}
		public String getSign() {
			return sign;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
		public String getMenu() {
			return menu;
		}
		public void setMenu(String menu) {
			this.menu = menu;
		}
    }
}
