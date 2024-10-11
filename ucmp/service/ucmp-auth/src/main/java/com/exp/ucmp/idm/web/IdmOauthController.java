package com.exp.ucmp.idm.web;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.nacos.shaded.io.grpc.netty.shaded.io.netty.util.internal.StringUtil;
import com.egrid.cache.jedis.cache.RedisCache;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.copiers.mapper.MapperCopier;
import com.egrid.core.json.body.JsonBody;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.shiro.model.User;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.Md5Util;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.egrid.shiro.authc.PasswordFreeToken;
import com.egrid.shiro.constants.ShiroConstants;
import com.egrid.shiro.model.JwtPrincipal;
import com.egrid.shiro.model.UserPrincipal;
import com.exp.ucmp.auth.dto.IdmUserDto;
import com.exp.ucmp.auth.dto.IdmUserInfoDto;
import com.exp.ucmp.auth.dto.StaffDto;
import com.exp.ucmp.auth.service.AuthService;
import com.exp.ucmp.auth.web.LoginController;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.idm.service.IdmOauthService;
import com.exp.ucmp.model.LoginResult;
import com.exp.ucmp.model.Person;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.para.esc.web.common.IdmOauthApi;
import com.para.esc.web.common.MD5Util;
import com.para.esc.web.entity.IdmAccessTokenDto;
import com.para.esc.web.entity.IdmUserAppDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * idm auth api
 * 
 * @author xiongneng
 *
 */
@Api(value = "Idm.API", tags = "idm用户登录相关接口")
@RefreshScope
@Controller
public class IdmOauthController{
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private IdmOauthService idmOauthService;
	
	@Autowired
    private AuthService authService;
	
	@Autowired
    private RedisCache shiroRedisCache;
	
	@Value("${auth.userKey:x-auth-user}")
    private String userKey;
	
	public static void main(String[] args) {
		try {
			String url = IdmOauthApi.SSORequest("e9Yypmn7lO",
					"https://isp-user-uat.human-horizons.com/isp/sso/idm/callback", "https://baidu.com");
			LOGGER.info("=====请求IDM Code地址URL:"+url);
		} catch (Exception e) {
			LOGGER.error("===========请求IDM Code地址异常:",e);
		} 
	}
	
	
	
	/**
     * <p>
     * Description: 请求IDM Code地址
     * </p>
     * 
     * @param loginDto   用户登录信息
     * @param request  请求对象
     * @param response 响应对象
     * @return 查询结果
     */
	@ApiOperationSupport(order = 1)
    @ApiOperation(value = "浏览器获取idm登录code", notes = "登入信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/idm/login", method = RequestMethod.GET)
    public void send(HttpServletResponse response) {
    	try {
			String url = this.idmOauthService.buildIdmUrl();
			LOGGER.info("=====请求IDM Code地址URL:"+url);
			if(!StringUtil.isNullOrEmpty(url)){
				LOGGER.info("重定向");
				response.sendRedirect(url);
			}
		} catch (Exception e) {
			LOGGER.error("===========请求IDM Code地址异常:",e);
		} 
    }
    
    /**
     * <p>
     * Description: IDM callBack回调 跳转目标页面
     * </p>
     * 
     * @param code   idm code
     * @param target_uri 目标页面
     * @param response 响应对象
     * @return 查询结果
     */
	@ApiOperationSupport(order = 2)
    @ApiOperation(value = "IDM callBack回调", notes = "跳转目标页面", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/idm/callback", method = RequestMethod.GET)
    public void callBack(HttpServletResponse response,HttpServletRequest request,@RequestParam(value="code",required=false) String code,
    		@RequestParam(value="target_uri",required=false) String target_uri,@RequestParam(value="access_token",required=false)String access_token) {
    	try {
			this.idmOauthService.callback(response,request,code,target_uri,access_token);
		} catch (IOException e) {
			LOGGER.error("===========IDM callBack回调异常:",e);
		}
    }
    
    /**
     * <p>
     * Description: IDM 获取token信息
     * </p>
     * 
     * @param code   idm code
     * @return 查询结果
     */
    @ApiOperation(value = "IDM 获取token信息POST", notes = "获取token信息 P", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/idm/token", method = RequestMethod.GET)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "idm code", required = true, paramType ="query", dataType = "String")})
    @JsonPropFilter(type = String.class)
    public RestResponse<String> getToken(@RequestParam("code") String code) {
    	try {
			String result= this.idmOauthService.getToken(code);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error("==========", e);
		}
		return null;
    }
    
    /**
     * <p>
     * Description: IDM 获取token信息
     * </p>
     * 
     * @param code   idm code
     * @return 查询结果
     */
    @ApiOperation(value = "IDM 获取token信息GET", notes = "获取token信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/idm/token/info", method = RequestMethod.GET)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({@ApiImplicitParam(name = "code", value = "idm code", required = true, paramType ="query", dataType = "String")})
    @JsonBody(filters={@JsonPropFilter(type=IdmAccessTokenDto.class,include="status,msg,accessToken")})
    public RestResponse<Map<String, String>> getTokenInfo(@RequestParam("code") String code) {
    	LOGGER.info("code --> " + code);
    	try {
    		String result = this.idmOauthService.getTokenInfo(code);
    		Map<String,String> tokenMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
			LOGGER.info("===token:" + tokenMap);
			return new RestResponse<>(RestStatusCode.OK,tokenMap);
		} catch (Exception e) {
			LOGGER.error("===获取idm token异常:",e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
		}
    }
    
    
    /**
     * <p>
     * Description: IDM 获取用户信息
     * </p>
     * 
     * @param code   idm code
     * @return 查询结果
     */
    @ApiOperation(value = "IDM 获取浏览器端用户信息", notes = "获取浏览器端用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/idm/user/info", method = RequestMethod.GET)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({@ApiImplicitParam(name = "accessToken", value = "idm access_token", required = true, paramType ="query", dataType = "String")})
    @JsonPropFilter(type=String.class)
    public RestResponse<IdmUserDto> getUserInfo(@RequestParam("accessToken") String accessToken) {
    	LOGGER.info("accessToken --> " + accessToken);

    	IdmUserDto userInfo;
		try {
			userInfo = this.idmOauthService.getUserInfo(accessToken);
			LOGGER.info("===userInfo:" + userInfo);
		} catch (Exception e) {
			LOGGER.error("===获取idm 用户信息异常:",e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
		}
        return new RestResponse<>(RestStatusCode.OK,userInfo);
    }
    
    
    
    /**
     * 发送手机短信
     *
     * @param mobile
     * @return
     */
    @ApiOperation(value = "IDM 移动端发送手机短信", notes = "移动端发送手机短信", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/idm/sendSecurityCodeDto", method = RequestMethod.GET)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({@ApiImplicitParam(name = "mobile", value = "车商手机号", required = true, paramType ="query", dataType = "String")})
    @JsonPropFilter(type=String.class)
    public RestResponse<String> sendSecurityCodeDto(@RequestParam("mobile") String mobile) {
    	LOGGER.info("mobile --> " + mobile);
		try {
			Map<String, String> result = this.idmOauthService.sendSecurityCodeDto(mobile);
			if("E2000100".equals(result.get("code"))){
				return new RestResponse<>(RestStatusCode.OK);
			}else{
				throw new Exception(result.get("msg"));
			}
		} catch (Exception e) {
			LOGGER.error("=====发送手机短信失败=====",e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
		}
    }
    
    /**
     * 发送短信验证码获取token
     *
     * @param mobile
     * @return
     */
    @ApiOperation(value = "IDM 移动端验证码获取Token信息", notes = "移动端验证码获取Token信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/idm/getAccessTokenBySMS", method = RequestMethod.GET)
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams(
    		{@ApiImplicitParam(name = "uid", value = "车商手机号", required = true, paramType ="query", dataType = "String"),
		@ApiImplicitParam(name = "pwd", value = "验证码", required = true, paramType ="query", dataType = "String")})
    @JsonPropFilter(type=String.class)
    public RestResponse<LoginResult> getAccessTokenBySMS(@RequestParam("uid") String uid,@RequestParam("pwd") String pwd,
            HttpServletRequest request, HttpServletResponse response) {
    	LOGGER.info("uid --> " + uid);
    	LOGGER.info("pwd --> " + pwd);
		try {
			Map<String, Object> result = this.idmOauthService.getAccessTokenBySMS(uid,pwd);
			if("E2000100".equals(result.get("code"))){
				//免密登录
				AuthenticationToken token = new PasswordFreeToken();
	            ((PasswordFreeToken) token).setUsername(Md5Util.getMD5String(uid));
				return login(token, null, null);
			}else{
				throw new Exception(result.get("msg").toString());
			}
		} catch (Exception e) {
			LOGGER.error("=====发送手机短信失败=====",e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
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
            if (staffDto != null && !StringUtil.isNullOrEmpty(staffDto.getOrgId())) {
            	/*如果是门店或车商登录，重设人员的机构*/
            	((Person)user).setOrganId(Long.parseLong(staffDto.getOrgId()));
            	((Person)user).setOrganName(staffDto.getOrgName());
            }
        	((Person)user).setExtendInfo(staffDto);
        	
        	shiroRedisCache.put(userKey + ":" + userSubject.getSession().getId().toString(), JsonBeanUtil.beanToJson(user));
        	
        	LoginResult result = new LoginResult(userSubject.getSession().getId().toString(), user,null);
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
     * 发送手机短信
     *
     * @param mobile
     * @return
     */
    @ApiOperation(value = "IDM 移动端密码获取Token信息", notes = "移动端密码获取Token信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/idm/getTokenByPwd", method = RequestMethod.GET)
    @ApiOperationSupport(order = 8)
    @ApiImplicitParams(
    		{@ApiImplicitParam(name = "uid", value = "车商手机号", required = true, paramType ="query", dataType = "String"),
		@ApiImplicitParam(name = "pwd", value = "验证码", required = true, paramType ="query", dataType = "String")})
    @JsonPropFilter(type=String.class)
    public RestResponse<Map<String, String>> getTokenByPwd(@RequestParam("uid") String uid,@RequestParam("pwd") String pwd) {
    	LOGGER.info("uid --> " + uid);
    	LOGGER.info("pwd --> " + pwd);
    	Map<String,String> resultMap=new HashMap<>();
		try {
			Map<String, String> result = this.idmOauthService.getTokenByPwd(uid,pwd);
			if("E2000100".equals(result.get("code"))){
				resultMap.put("token", result.get("access_token"));
				resultMap.put("uidMd5", Md5Util.getMD5String(uid));
				return new RestResponse<>(RestStatusCode.OK,resultMap);
			}else{
				throw new Exception(result.get("msg"));
			}
		} catch (Exception e) {
			LOGGER.error("=====发送手机短信失败=====",e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
		}
    }
    
    /**
     * <p>
     * Description: IDM 获取用户信息
     * </p>
     * 
     * @param code   idm code
     * @return 查询结果
     */
    @ApiOperation(value = "IDM 获取移动端用户信息", notes = "获取移动端用户信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/idm/user", method = RequestMethod.GET)
    @ApiOperationSupport(order = 9)
    @ApiImplicitParams({@ApiImplicitParam(name = "accessToken", value = "idm access_token", required = true, paramType ="query", dataType = "String")})
    @JsonBody(filters={@JsonPropFilter(type=IdmUserDto.class,include="status,msg,id")})
    public RestResponse<IdmUserInfoDto> getUser(@RequestParam("accessToken") String accessToken) {
    	LOGGER.info("accessToken --> " + accessToken);

    	String user;
    	IdmUserAppDto appDto=new IdmUserAppDto();
    	
		//开发测试假数据
		IdmUserInfoDto dto=new IdmUserInfoDto();
		dto.setUid("fengdy666");
		dto.setAccountEmail("fengdy@paraview.cn");
		dto.setAppCode("UCMP");
		dto.setExpire("7200");
		dto.setUserName("冯德阳");
		dto.setUsertypecode("SP-NTC");
		dto.setAccess_token("PAT-9j1J0tR7-41f5fb17fe620877c564a4e295748b3f5217d8189a270f33e25eddf724f784e1");
		dto.setUidMd5(MD5Util.md5s(dto.getUid()));
		dto.setOrgCode("HQ0001");
		dto.setOrgId("3775320210223320354");
		dto.setRole("MC");
		dto.setSuperior("MO");
		dto.setOrgName("成都交付中心");
        return new RestResponse<>(RestStatusCode.OK,dto);
    }
}
