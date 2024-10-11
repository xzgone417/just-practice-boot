package com.exp.ucmp.car.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DeliveryOrderPicDto", description = "销售交付订单材料")
public class ChangePriceProofDto {
	
    @ApiModelProperty(value = "材料ID")
    private Long materialId;
    
    @ApiModelProperty(value = "次序")
    private Integer materialOrder;
    
    @ApiModelProperty(value = "缩略图")
    private String thumbnail;
    
    @ApiModelProperty(value = "材料类型 3301 改价凭证 ")
    private String materialType;
    
    @ApiModelProperty(value = "材料类型名称")
    private String materialTypeName;
    
    @ApiModelProperty(value = "文件链接")
    private String fileUrl;
    
    @ApiModelProperty(value = "改价记录ID,不用传")
    private Long recordId;
    
    @ApiModelProperty("操作人，不用传")
    private Long partyId;

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public Integer getMaterialOrder() {
		return materialOrder;
	}

	public void setMaterialOrder(Integer materialOrder) {
		this.materialOrder = materialOrder;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialTypeName() {
		return materialTypeName;
	}

	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}
	
}
