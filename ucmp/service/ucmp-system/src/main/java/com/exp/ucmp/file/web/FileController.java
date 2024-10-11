package com.exp.ucmp.file.web;

import java.awt.Image;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.config.HwOBSConfig;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.file.dto.MaterialParamDto;
import com.exp.ucmp.file.service.FileService;
import com.exp.ucmp.file.service.HwObsService;
import com.exp.ucmp.file.utils.FileUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.obs.services.exception.ObsException;

import cn.hutool.core.io.IoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "FileController.API", tags = "文件相关的接口")
@Controller
public class FileController {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
    private HwObsService hwObsService;
	
	@Autowired
    private FileService fileService;
	
	@Autowired
    private UcmpAesConfig ucmpAesConfig;

	@ApiOperation(value = "原始凭证上传", notes = "原始凭证上传", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/file/original/upload", method = RequestMethod.POST)
	@ApiOperationSupport(order = 1)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "paramDto", value = "材料参数", required = true, paramType ="body", dataType = "MaterialParamDto")
    })
    @JsonPropFilter(type = String.class)
	public RestResponse<String> originalUpload(@RequestParam("originalFile") MultipartFile originalFile, @RequestBody MaterialParamDto paramDto){
    	System.out.println(originalFile.getOriginalFilename() + " " + originalFile.getName() + " " + originalFile.getContentType() + " " + originalFile.getSize());
        return new RestResponse<>(RestStatusCode.OK);
    }

	@ApiOperation(value = "缩略图上传", notes = "缩略图上传", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/file/thumbnail/upload", method = RequestMethod.POST)
	@ApiOperationSupport(order = 2)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "paramDto", value = "材料参数", required = true, paramType ="body", dataType = "MaterialParamDto")
    })
    @JsonPropFilter(type = String.class)
	public RestResponse<String> thumbnailUpload(@RequestParam("thumbnailFile") MultipartFile thumbnailFile, @RequestBody MaterialParamDto paramDto){
    	System.out.println(thumbnailFile.getOriginalFilename() + " " + thumbnailFile.getName() + " " + thumbnailFile.getContentType() + " " + thumbnailFile.getSize());
        return new RestResponse<>(RestStatusCode.OK);
    }
	
	@ApiOperation(value = "文件上传公共接口", notes = "文件上传", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/file/upload", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @JsonPropFilter(type = Object.class)
    public RestResponse<Object> thumbnailUpload( @RequestParam("file") MultipartFile file, @RequestParam("materialType") String materialType,
    		@RequestParam("materialOrder") Integer materialOrder ) throws IOException {
        try {
        	String objKey = HwOBSConfig.getObjectKey() +UUID.randomUUID()+"-"+file.getOriginalFilename();
            //存入华为obs
            String fileUrl = hwObsService.fileUpload(file,objKey);
            String compressToBASE64=null;
            
            Boolean flag = this.checkImage(file);
            LOGGER.info("=====是否是图片======"+flag);
            if(flag){
            	//压缩并转base64
            	compressToBASE64 = FileUtil.compressToBASE64(file);
            }else{
            	return new RestResponse<>(RestStatusCode.BAD_REQUEST,"上传的文件不正确");
            }

            MaterialParamDto paramDto = new MaterialParamDto();
            paramDto.setMaterialType(materialType);
            paramDto.setMaterialOrder(materialOrder);
            paramDto.setThumbnailFile(compressToBASE64);
            paramDto.setOriginalFilename(file.getOriginalFilename());
            paramDto.setContentType(file.getContentType());
            paramDto.setObjKey(objKey);
            Long fileId = fileService.savaMaterials(paramDto);
            
            Map<String,Object> resultMap=new HashMap<>();
            resultMap.put("materialId", fileId);
            resultMap.put("fileUrl", fileUrl);
            resultMap.put("thumbnailFile", compressToBASE64);
            resultMap.put("materialType", materialType);
            return new RestResponse<>(resultMap);
		} catch (Exception e) {
			return new RestResponse<>(RestStatusCode.BAD_REQUEST,e);
		}
		
    }
	
	private boolean checkImage(MultipartFile file) {
		File fileNew = new File(ucmpAesConfig.getFilePath()); 
		try {
		    FileUtils.copyInputStreamToFile(file.getInputStream(), fileNew);
			Image image=ImageIO.read(fileNew);
			return image != null;
		} catch (IOException e) {
			LOGGER.info("======checkImage异常======",e);
			return false;
		}finally {
			Boolean f=true;
			int i = 0;
			while(f){
				f = !fileNew.delete();
				i++;
				if(i>10){
					f=false;
				}
			}
		}
	}

	@ApiOperation(value = "文件下载", notes = "文件下载", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/file/download", method = RequestMethod.GET)
    @ApiOperationSupport(order = 4)
    @JsonPropFilter(type = Long.class)
    public RestResponse<Long> fileDownload(HttpServletRequest request, HttpServletResponse response,
                                               @RequestParam("fileId") Long fileId){
        String objKey = fileService.getObjKey(fileId);
        if(StringUtils.isNotEmpty(objKey)){
        	try (
        			InputStream inputStream = hwObsService.fileDownload(objKey);
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
        		return null;
        	} catch (ObsException | IOException e) {
        		LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
        		new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        	}
        }
        return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
    }
	
	@ApiOperation(value = "车辆配置亮点顶部图上传接口", notes = "车辆配置亮点顶部图上传接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/config/top/pic/file/upload", method = RequestMethod.POST)
    @ApiOperationSupport(order = 5)
    @JsonPropFilter(type = Object.class)
    public RestResponse<Object> configTopPicUpload( @RequestParam("file") MultipartFile file, @RequestParam("carSeriesCode") String carSeriesCode) throws IOException {
        try {
        	String objKey = HwOBSConfig.getObjectKey() +UUID.randomUUID()+"-"+file.getOriginalFilename();
            //存入华为obs
            String fileUrl = hwObsService.fileUpload(file,objKey);
            String compressToBASE64;
            
            Boolean flag = this.checkImage(file);
            LOGGER.info("=====是否是图片======"+flag);
            if(flag){
            	//压缩并转base64
            	compressToBASE64 = FileUtil.compressToBASE64(file);
            }else{
            	return new RestResponse<>(RestStatusCode.BAD_REQUEST,"上传的文件不正确");
            }

            MaterialParamDto paramDto = new MaterialParamDto();
            paramDto.setThumbnailFile(compressToBASE64);
            paramDto.setOriginalFilename(file.getOriginalFilename());
            paramDto.setContentType(file.getContentType());
            paramDto.setObjKey(objKey);
            Long fileId = fileService.configTopPicUpload(paramDto,carSeriesCode);
            
            Map<String,Object> resultMap=new HashMap<>();
            resultMap.put("carSeriesCode", carSeriesCode);
            resultMap.put("fileId", fileId);
            resultMap.put("fileUrl", fileUrl);
            return new RestResponse<>(resultMap);
		} catch (Exception e) {
			return new RestResponse<>(RestStatusCode.BAD_REQUEST,e);
		}
		
    }
}
