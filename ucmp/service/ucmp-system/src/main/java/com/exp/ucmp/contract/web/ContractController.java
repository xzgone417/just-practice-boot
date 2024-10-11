package com.exp.ucmp.contract.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.contract.dto.CompanyDto;
import com.exp.ucmp.contract.dto.RetailSaleContractDto;
import com.exp.ucmp.contract.dto.WholesaleContractDto;
import com.exp.ucmp.contract.service.ContractService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.obs.services.exception.ObsException;

import cn.hutool.core.io.IoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author xiongneng
 * @date 2023年11月27日
 */
@Api(value = "合同", tags = "生成合同模板")
@RefreshScope
@Controller
public class ContractController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractController.class);
    
    @Autowired
    private ContractService contractService;
    
    @ApiOperation(value = "生成零售合同", notes = "生成零售合同")
    @RequestMapping(value = "/api/v1/retail/sale/contract", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsDto", value = "生成零售合同", required = true, paramType ="body", dataType = "RetailSaleContractDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> retailSaleContract(HttpServletRequest request, HttpServletResponse response ,@RequestBody RetailSaleContractDto paramsDto){
    	/*try{
    		String result = contractService.retailSaleContract(paramsDto,request,response);
    		return new RestResponse<>(RestStatusCode.OK,result);
    	}catch (Exception e) {
    		LOGGER.error("===生成零售合同===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}*/
    	try{
    		File fileNew = contractService.retailSaleContract(paramsDto,request,response);
    		this.downloadFileTwo(fileNew,request,response);
    		return new RestResponse<>(RestStatusCode.OK);
    	}catch (Exception e) {
    		LOGGER.error("===生成零售合同===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
    }
    
    @ApiOperation(value = "查询甲方公司列表", notes = "查询甲方公司列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/sale/company", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({})
    @JsonPropFilter(type = CompanyDto.class)
    public RestResponse<List<CompanyDto>> querySaleCompany() {
    	try{
    		List<CompanyDto> result = contractService.querySaleCompany();
    		return new RestResponse<>(RestStatusCode.OK,result);
    	}catch (Exception e) {
    		LOGGER.error("===查询甲方公司列表===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
    }
    
    @ApiOperation(value = "生成批售合同", notes = "生成批售合同")
    @RequestMapping(value = "/api/v1/wholesale/contract", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsDto", value = "生成批售合同", required = true, paramType ="body", dataType = "WholesaleContractDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> wholesaleContract(HttpServletRequest request, HttpServletResponse response,@RequestBody WholesaleContractDto paramsDto){
    	try{
	    	File fileNew = contractService.wholesaleContract(paramsDto,request,response);
			this.downloadFileTwo(fileNew,request,response);
			return new RestResponse<>(RestStatusCode.OK);
	    }catch (Exception e) {
			LOGGER.error("===生成零售合同===",e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
    }
    
    private void downloadFile(File fileNew, HttpServletRequest request, HttpServletResponse response) {
		String objKey = fileNew.getName();
        try (InputStream inputStream = new FileInputStream(fileNew);
                BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())){
               // 为防止 文件名出现乱码
               final String userAgent = request.getHeader("USER-AGENT");
               // IE浏览器
               if (StringUtils.contains(userAgent, "MSIE")) {
                   objKey = URLEncoder.encode(objKey, "UTF-8");
               } else {
                   // google,火狐浏览器
                   if (StringUtils.contains(userAgent, "Mozilla")) {
                       objKey = new String(objKey.getBytes(), "ISO8859-1");
                   } else {
                       // 其他浏览器
                       objKey = URLEncoder.encode(objKey, "UTF-8");
                   }
               }
               IoUtil.copy(inputStream, outputStream);
           } catch (ObsException | IOException e) {
               LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
               new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
           }
	}
    
    private void downloadFileTwo(File fileNew, HttpServletRequest request, HttpServletResponse response) throws IOException {
		OutputStream outputStream = response.getOutputStream();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/x-download");  
		String userAgent = request.getHeader("User-Agent"); 
		String fileName = fileNew.getName();
	    byte[] byteName = userAgent.contains("MSIE") ? fileName.getBytes() : fileName.getBytes("UTF-8");//name.getBytes("UTF-8")处理safari的乱码问题
	    fileName = new String(byteName, "ISO-8859-1"); // 各浏览器基本都支持ISO编码  
	    response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", fileName+".docx"));//文件名外的双引号处理firefox的空格截断问题
	    InputStream inputStream = new FileInputStream(fileNew);
		byte[] buff = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(buff)) != -1) {
            outputStream.write(buff, 0, len);
		}
		inputStream.close();
        outputStream.close();
        fileNew.delete();
	}
    
}
