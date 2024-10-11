package com.exp.ucmp.file.dto;

import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

public class MaterialParamDto extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1641470333725504316L;

	/**
     * 预约ID
     */
    private Long reservationId;
    
	/**
     * 材料类型
     */
    private String materialType;

    /**
     * 缩略图
     */
    private String thumbnailFile;
    
	/**
     * 材料序号
     */
    private Integer materialOrder;

    private String originalFilename;

    private String contentType;

    private String objKey;

	public MaterialParamDto() {
	}

	public MaterialParamDto(long serialVersionUID, Long reservationId, String materialType, String thumbnailFile, Integer materialOrder, String originalFilename, String contentType, String objKey) {
		this.reservationId = reservationId;
		this.materialType = materialType;
		this.thumbnailFile = thumbnailFile;
		this.materialOrder = materialOrder;
		this.originalFilename = originalFilename;
		this.contentType = contentType;
		this.objKey = objKey;
	}

	/**
	 * 获取
	 * @return reservationId
	 */
	public Long getReservationId() {
		return reservationId;
	}

	/**
	 * 设置
	 * @param reservationId
	 */
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * 获取
	 * @return materialType
	 */
	public String getMaterialType() {
		return materialType;
	}

	/**
	 * 设置
	 * @param materialType
	 */
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	/**
	 * 获取
	 * @return thumbnailFile
	 */
	public String getThumbnailFile() {
		return thumbnailFile;
	}

	/**
	 * 设置
	 * @param thumbnailFile
	 */
	public void setThumbnailFile(String thumbnailFile) {
		this.thumbnailFile = thumbnailFile;
	}

	/**
	 * 获取
	 * @return materialOrder
	 */
	public Integer getMaterialOrder() {
		return materialOrder;
	}

	/**
	 * 设置
	 * @param materialOrder
	 */
	public void setMaterialOrder(Integer materialOrder) {
		this.materialOrder = materialOrder;
	}

	/**
	 * 获取
	 * @return originalFilename
	 */
	public String getOriginalFilename() {
		return originalFilename;
	}

	/**
	 * 设置
	 * @param originalFilename
	 */
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	/**
	 * 获取
	 * @return contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * 设置
	 * @param contentType
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * 获取
	 * @return objKey
	 */
	public String getObjKey() {
		return objKey;
	}

	/**
	 * 设置
	 * @param objKey
	 */
	public void setObjKey(String objKey) {
		this.objKey = objKey;
	}

	public String toString() {
		return "MaterialParamDto{serialVersionUID = " + serialVersionUID + ", reservationId = " + reservationId + ", materialType = " + materialType + ", thumbnailFile = " + thumbnailFile + ", materialOrder = " + materialOrder + ", originalFilename = " + originalFilename + ", contentType = " + contentType + ", objKey = " + objKey + "}";
	}
}
