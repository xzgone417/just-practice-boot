package com.exp.ucmp.storeApp.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OneselfCarPicDto", description = "本品车辆图片列表")
public class OneselfCarPicDto {
	
    @ApiModelProperty(value = "材料ID")
    private Long materialId;
    
    @ApiModelProperty(value = "次序")
    private Integer materialOrder;
    
    @ApiModelProperty(value = "缩略图")
    private String thumbnail;
    
    @ApiModelProperty(value = "材料类型 1 车辆图片-9009:左前方45度,9010:其他;"
    		+ "检测报告-9011:检测报告;"
    		+ "合同材料-9007:合同;"
    		+ "车辆材料-9701:交接单,9702:登记证,9703:行驶证,9704:交强险保单,9705:其它;"
    		+ "车辆照片-9801:左前方45度,9802:右后方45度,9803:主驾驶,9804:二排,9805:其它;"
    		+ "随车附件-9901:钥匙,9902:充电接头,9903:医疗包,9904:其它;"
    		+ "登记证照片-9002:登记证(一、二页),9003:登记证(三、四页),9004:登记证(其他),9012:登记证(其他),9013:登记证(其他),9014:登记证(其他);"
    		+ "二手车销售发票-9005:二手车销售发票;"
    		+ "付款凭证-9006:付款凭证。")
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
