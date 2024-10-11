package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AnnexDto", description = "附件")
public class AnnexDto {
	
	@ApiModelProperty(value = "订单对应的业务类型")
	private String linkOrderType;
	
	@ApiModelProperty(value = "对应业务类型的场景")
    private String sceneCode;
	
	@ApiModelProperty(value = "附件完整路径")
    private String annexPath;
	
	@ApiModelProperty(value = "生成的附件名称")
    private String annexFilename;
	
	@ApiModelProperty(value = "附件后缀")
    private String annexSuffix;
	
	@ApiModelProperty(value = "附件大小")
    private String annexSize;
	
	@ApiModelProperty(value = "附件上传名称")
    private String annexUploadFilename;

	public String getLinkOrderType() {
		return linkOrderType;
	}

	public void setLinkOrderType(String linkOrderType) {
		this.linkOrderType = linkOrderType;
	}

	public String getSceneCode() {
		return sceneCode;
	}

	public void setSceneCode(String sceneCode) {
		this.sceneCode = sceneCode;
	}

	public String getAnnexPath() {
		return annexPath;
	}

	public void setAnnexPath(String annexPath) {
		this.annexPath = annexPath;
	}

	public String getAnnexFilename() {
		return annexFilename;
	}

	public void setAnnexFilename(String annexFilename) {
		this.annexFilename = annexFilename;
	}

	public String getAnnexSuffix() {
		return annexSuffix;
	}

	public void setAnnexSuffix(String annexSuffix) {
		this.annexSuffix = annexSuffix;
	}

	public String getAnnexSize() {
		return annexSize;
	}

	public void setAnnexSize(String annexSize) {
		this.annexSize = annexSize;
	}

	public String getAnnexUploadFilename() {
		return annexUploadFilename;
	}

	public void setAnnexUploadFilename(String annexUploadFilename) {
		this.annexUploadFilename = annexUploadFilename;
	}
	
}
