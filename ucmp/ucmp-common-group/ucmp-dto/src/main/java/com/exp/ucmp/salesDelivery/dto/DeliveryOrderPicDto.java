package com.exp.ucmp.salesDelivery.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DeliveryOrderPicDto", description = "销售交付订单材料")
public class DeliveryOrderPicDto {
	
    @ApiModelProperty(value = "材料ID")
    private Long materialId;
    
    @ApiModelProperty(value = "次序")
    private Integer materialOrder;
    
    @ApiModelProperty(value = "缩略图")
    private String thumbnail;
    
    @ApiModelProperty(value = "材料类型 1 合同-7101;"
    		+ "交付确认-7001:登记证(一、二页),7002:登记证(三、四页),7003:登记证(其它),7004:行驶证图片,7005:交付确认书,7006:二手车交易发票,7007:增值税发票（邮件申请开票）;"
    		+ "PDI-6901:PDI检测报告,6902:维修历史,6903:瑕疵图片;"
    		+ "金融凭证-6601,大定凭证-6602,尾款凭证-6603,其他款项凭证-6604")
    private String materialType;
    
    @ApiModelProperty(value = "材料类型名称")
    private String materialTypeName;
    
    @ApiModelProperty(value = "文件链接")
    private String fileUrl;

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
	
}
