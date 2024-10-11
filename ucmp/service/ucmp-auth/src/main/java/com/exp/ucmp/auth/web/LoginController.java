package com.exp.ucmp.auth.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.cache.jedis.cache.RedisCache;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.copiers.mapper.MapperCopier;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.shiro.model.User;
import com.egrid.core.util.ExceptionUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.egrid.shiro.authc.PasswordFreeToken;
import com.egrid.shiro.authc.UsernamePasswordJwtToken;
import com.egrid.shiro.authc.VerificationCodeJwtToken;
import com.egrid.shiro.authc.VerificationCodeToken;
import com.egrid.shiro.constants.ShiroConstants;
import com.egrid.shiro.model.JwtPrincipal;
import com.egrid.shiro.model.UserPrincipal;
import com.exp.ucmp.auth.dto.StaffDto;
import com.exp.ucmp.auth.service.AuthService;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.model.LoginDto;
import com.exp.ucmp.model.LoginResult;
import com.exp.ucmp.model.Person;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 
 * 用户服务接口
 * 
 * @author Yiyongfei
 *
 */
@Api(value = "Login.API", tags = "用户登录接口")
@RefreshScope
@Controller
public class LoginController {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AuthService authService;

    @Autowired
    private RedisCache shiroRedisCache;

    @Value("${auth.userKey:x-auth-user}")
    private String userKey;

    /**
     * <p>
     * Description: 手机验证码发送
     * </p>
     * 
     * @param loginDto   用户登录信息
     * @param request  请求对象
     * @param response 响应对象
     * @return 查询结果
     */
    @ApiOperation(value = "用户手机验证发送", notes = "用户手机验证发送", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(includeParameters = {"loginDto.username"})
    @RequestMapping(value = "/api/mobile/send", method = RequestMethod.POST)
    @JsonPropFilter(type = LoginResult.class)
    public RestResponse<String> send(
            @ApiParam(name = "loginDto", value = "用户登录请求信息", required = true) @RequestBody LoginDto loginDto,
            HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Send VerificationCode request: {}", JsonBeanUtil.beanToJson(loginDto));
        String smsCode = authService.sendVerificationCode(loginDto.getUsername());
        return new RestResponse(smsCode);
    }

    /**
     * <p>
     * Description: 手机验证码登录
     * </p>
     * 
     * @param loginDto   用户登录信息
     * @param request  请求对象
     * @param response 响应对象
     * @return 查询结果
     */
    @ApiOperation(value = "用户手机验证登录", notes = "用户手机验证登录", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(ignoreParameters = {"loginDto.userParameters"})
    @RequestMapping(value = "/api/mobile/verify", method = RequestMethod.POST)
    @JsonPropFilter(type = LoginResult.class)
	public RestResponse<LoginResult> verify(
			@ApiParam(name = "loginDto", value = "用户登录请求信息", required = true) @RequestBody LoginDto loginDto,
			HttpServletRequest request, HttpServletResponse response) {
		LOGGER.info("Login request: {}", JsonBeanUtil.beanToJson(loginDto));
		AuthenticationToken token = null;
		if (ShiroConstants.shiroProperties.getJwtSwitch()) {
			token = new VerificationCodeJwtToken();
		} else {
			token = new VerificationCodeToken();
		}
		((VerificationCodeToken) token).setUsername(loginDto.getUsername());
		((VerificationCodeToken) token).setVerificationCode(loginDto.getPassword());

		return login(token, null, null);
	}
    
    /**
     * <p>
     * Description: 查询
     * </p>
     * 
     * @param loginDto   用户登录信息
     * @param request  请求对象
     * @param response 响应对象
     * @return 查询结果
     */
    @ApiOperation(value = "用户登录", notes = "用户登录", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(ignoreParameters = {"loginDto.userParameters"})
    @RequestMapping(value = "/api/auth/login", method = RequestMethod.POST)
    @JsonPropFilter(type = LoginResult.class)
    public RestResponse<LoginResult> login(
            @ApiParam(name = "loginDto", value = "用户登录请求信息", required = true) @RequestBody LoginDto loginDto,
            HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Login request: {}", JsonBeanUtil.beanToJson(loginDto));
        AuthenticationToken token;
        if (StringUtil.isEmpty(loginDto.getPassword())) {
            token = new PasswordFreeToken();
            ((PasswordFreeToken) token).setUsername(loginDto.getUsername());
        } else {
            if (ShiroConstants.shiroProperties.getJwtSwitch()) {
                token = new UsernamePasswordJwtToken();
            } else {
                token = new UsernamePasswordToken();
            }
            ((UsernamePasswordToken) token).setUsername(loginDto.getUsername());
            ((UsernamePasswordToken) token).setPassword(loginDto.getPassword().toCharArray());
        }
        
        String loginStore = null;
        if (loginDto.getUserParameters() != null && loginDto.getUserParameters().get("loginStore") != null) {
        	loginStore = loginDto.getUserParameters().get("loginStore");
        }
        if (StringUtil.isEmpty(loginStore)) {
        	return login(token, loginStore, null);
        } else {
        	/*前端告知登录门店的前提下，登录人员为门店人员*/
        	return login(token, loginStore, Constants.StaffType.store);
        }
    }
    
    /**
     * 
     * @param token
     * @param orgId
     * @param staffType
     * @return
     */
    private RestResponse<LoginResult> login(AuthenticationToken token, String orgId, Constants.StaffType staffType) {
        User user;
        try {
            Subject userSubject = SecurityUtils.getSubject();

            if (!userSubject.isAuthenticated()) {
                // 使用shiro来验证
                userSubject.login(token);
                Session session = userSubject.getSession();

                if (ShiroConstants.shiroProperties.getJwtSwitch()) {
                    JwtPrincipal userPrincipal = (JwtPrincipal) SecurityUtils.getSubject().getPrincipal();
                    user = authService.loadPersonById(userPrincipal.getLoginName());
                	MapperCopier<JwtPrincipal, Person> copier = Copiers.createMapper(JwtPrincipal.class,
                            Person.class);
                    /* 排除这二个字段的映射 */
                    copier.skip("partyId", "personName", "roles", "permissions");
                    copier.register().copy(userPrincipal, (Person) user);
                } else {
                    UserPrincipal userPrincipal = (UserPrincipal) SecurityUtils.getSubject().getPrincipal();
                    user = authService.loadPersonById(userPrincipal.getLoginName());
                    MapperCopier<UserPrincipal, Person> copier = Copiers.createMapper(UserPrincipal.class,
                            Person.class);
                    /* 排除这二个字段的映射 */
                    copier.skip("partyId", "personName");
                    copier.register().copy(userPrincipal, (Person) user);
                }

                session.setAttribute(session.getId(), user);
            } else {
                Session session = userSubject.getSession();
                user = (Person) session.getAttribute(session.getId().toString());
            }
            
            if (authService.hrytPartyId.equals(user.getOrganId()) && staffType == null) {
            	/*当不知道登录人员类型，并且登录用户所属组织是华人运通时，登录人员类型设置为总部人员*/
            	staffType = Constants.StaffType.headquarters;
            }
            
            StaffDto staffDto = authService.loadStaffById(user.getPartyId(), orgId, staffType);
            if (staffDto != null && !StringUtil.isEmpty(staffDto.getOrgId())) {
            	/*如果是门店或车商登录，重设人员的机构*/
            	((Person)user).setOrganId(Long.parseLong(staffDto.getOrgId()));
            	((Person)user).setOrganName(staffDto.getOrgName());
            }
        	((Person)user).setExtendInfo(staffDto);
        	
        	shiroRedisCache.put(userKey + ":" + userSubject.getSession().getId().toString(), JsonBeanUtil.beanToJson(user));
        	String isControls =this.authService.checkIsControls();
        	String isSales=this.authService.checkStroe(staffDto.getOrgId());
        	//开启灰度控制
        	if("01".equals(isControls)){
        		if(StringUtil.isEmpty(isSales)){
        			//没有权限
        			isSales="02";
        		}else{
        			//有权限
        			isSales="01";
        		}
        	}else{
        		//未开启灰度控制
        		isSales="00";
        	}
        	LoginResult result = new LoginResult(userSubject.getSession().getId().toString(), user,isSales);
            return new RestResponse<>(result);
        } catch (UnknownAccountException uae) {
            LOGGER.error("" + RestStatusCode.UNKNOWN_ACCOUNT.code(), uae);
            return new RestResponse<>(RestStatusCode.UNKNOWN_ACCOUNT, uae);
        } catch (IncorrectCredentialsException ice) {
            LOGGER.error("" + RestStatusCode.INCORRECT_CREDENTIALS.code(), ice);
            return new RestResponse<>(RestStatusCode.INCORRECT_CREDENTIALS, ice);
        } catch (LockedAccountException lae) {
            LOGGER.error("" + RestStatusCode.LOCKED_ACCOUNT.code(), lae);
            return new RestResponse<>(RestStatusCode.LOCKED_ACCOUNT, lae);
        } catch (ExcessiveAttemptsException eae) {
            LOGGER.error("" + RestStatusCode.EXCESSIVE_ATTEMPTS.code(), eae);
            return new RestResponse<>(RestStatusCode.EXCESSIVE_ATTEMPTS, eae);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.AUTHENTICED_FAILURE.message(), e);
            return new RestResponse<>(RestStatusCode.AUTHENTICED_FAILURE, e);
        }
    }
    
    /**
     * <p>
     * Description: 退出登录
     * </p>
     * 
     * @return 查询结果
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @ApiOperation(value = "退出登录", notes = "退出登录", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/auth/logout", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> logout() {
        try {
            Subject userSubject = SecurityUtils.getSubject();
            String sessionId = userSubject.getSession().getId().toString();
            userSubject.logout();
            shiroRedisCache.remove(userKey + ":" + sessionId);
            return new RestResponse();
        } catch (Exception e) { // 如果清除session失败，则返回错误代码和信息
            LOGGER.error("用户注销异常: {}", ExceptionUtil.getStackTraceAsString(e));
            return new RestResponse(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }

    }
}
