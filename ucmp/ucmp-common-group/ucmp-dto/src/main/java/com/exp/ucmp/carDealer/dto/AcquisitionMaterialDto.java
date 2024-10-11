package com.exp.ucmp.carDealer.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AcquisitionMaterialDto", description = "收购材料")
public class AcquisitionMaterialDto{

	@ApiModelProperty(value = "预约ID")
	private Long reservationId;
	
	@ApiModelProperty(value = "材料ID")
	private Long materialId;
	
	@ApiModelProperty(value = "材料类型")
	private String materialType;
	
	@ApiModelProperty(value = "材料文件id")
	private String materialFileId;
	
	@ApiModelProperty(value = "次序")
	private Integer materialOrder;
	
	@ApiModelProperty(value = "缩略图")
	private String thumbnail;
	
	@ApiModelProperty(value = "文件名")
	private String fileName;
	
	@ApiModelProperty(value = "文件路径")
	private String filePath;
	
	@ApiModelProperty(value = "文件类型")
	private String fileType;
	
	@ApiModelProperty(value = "文件状态")
	private String fileStatuss;

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getMaterialFileId() {
		return materialFileId;
	}

	public void setMaterialFileId(String materialFileId) {
		this.materialFileId = materialFileId;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileStatuss() {
		return fileStatuss;
	}

	public void setFileStatuss(String fileStatuss) {
		this.fileStatuss = fileStatuss;
	}
	
}

