package com.exp.ucmp.auth.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
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
import com.egrid.core.util.StringUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.auth.dto.PermissionIdentifierDto;
import com.exp.ucmp.auth.service.AuthService;
import com.exp.ucmp.model.LoginResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 权限服务接口
 * @author yiyongfei
 *
 */
@Api(value = "Permission.API", tags = "鉴权接口")
@RefreshScope
@Controller
public class PermissionController {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private AuthService authService;
    
    /**
     * <p>
     * Description: 校验当前请求是否登陆认证
     * </p>
     * 
     * @param request 请求
     * @return 结果
     */
    @ApiOperation(value = "用户鉴权", notes = "用户鉴权", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({ @ApiImplicitParam(paramType = "header", dataType = "String", name = "authorizedUrl", value = "待鉴权URL", required = true) })
    @RequestMapping(value = "/api/auth/isPermitted", method = RequestMethod.GET)
    @JsonPropFilter(type = LoginResult.class)
    @SuppressWarnings({"unchecked", "rawtypes"})
    public RestResponse<LoginResult> isPermitted() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user;
        try {
            //如果认证未通过
            if (subject.isAuthenticated() || subject.isRemembered()) {
                user = (User)session.getAttribute(session.getId());
            } else {
                user = new User();
            }
            LoginResult result = new LoginResult(subject.getSession().getId().toString(), user,null);
            return new RestResponse<>(result);
        } catch (InvalidSessionException e) {
            LOGGER.error("校验当前请求是否登陆认证: {}, {}", RestStatusCode.SESSION_TIMEOUT,
                    ExceptionUtil.getStackTraceAsString(e));
            return new RestResponse<>(RestStatusCode.SESSION_TIMEOUT, e);
        } catch (Exception ex) {
            LOGGER.error("校验当前请求是否登陆认证出现异常:{}", ExceptionUtil.getStackTraceAsString(ex));
            return new RestResponse(RestStatusCode.SERVER_UNKNOWN_ERROR, ex);
        }
    }
    
    /**
     * <p>
     * Description: 校验当前请求是否登陆认证
     * </p>
     * 
     * @param request 请求
     * @return 结果
     */
    @ApiOperation(value = "用户被授予的权限", notes = "用户被授予的权限", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/auth/permissions", method = RequestMethod.GET)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "roleId", value = "角色ID", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = PermissionIdentifierDto.class)
    @SuppressWarnings({"unchecked", "rawtypes"})
    public RestResponse<List<PermissionIdentifierDto>> permissions(@RequestParam(value="roleId", required=false) String roleId) {
    	Long _roleId = null;
    	try {
        	if (!StringUtil.isEmpty(roleId)) {
        		_roleId = Long.valueOf(roleId);
        	}
    	} catch (Exception ex) {
    		//如果roleId不是有效的数字，按Null进行处理
    	}
    	
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        List<PermissionIdentifierDto> listRolePermissions = null;
        try {
            //如果认证未通过
            if (subject.isAuthenticated() || subject.isRemembered()) {
                User user = (User)session.getAttribute(session.getId());
                listRolePermissions = authService.listRolePermissionByLoginid(user.getPartyId(), _roleId);
            } else {
            	listRolePermissions = new ArrayList<>();
            }
            return new RestResponse<>(listRolePermissions);
        } catch (InvalidSessionException e) {
            LOGGER.error("校验当前请求是否登陆认证: {}, {}", RestStatusCode.SESSION_TIMEOUT,
                    ExceptionUtil.getStackTraceAsString(e));
            return new RestResponse<>(RestStatusCode.SESSION_TIMEOUT, e);
        } catch (Exception ex) {
            LOGGER.error("校验当前请求是否登陆认证出现异常:{}", ExceptionUtil.getStackTraceAsString(ex));
            return new RestResponse(RestStatusCode.SERVER_UNKNOWN_ERROR, ex);
        }
    }
}
