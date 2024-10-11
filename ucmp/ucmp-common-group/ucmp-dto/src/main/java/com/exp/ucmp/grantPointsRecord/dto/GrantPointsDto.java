package com.exp.ucmp.grantPointsRecord.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GrantPointsDto", description = "积分发放类")
public class GrantPointsDto {
	
	@ApiModelProperty(value = "记录ID")
	private Long recordId;
	
	@ApiModelProperty(value = "置换ID")
    private Long reservationId;
	
	@ApiModelProperty(value = "积分值")
    private Integer pointsValue;
	
	@ApiModelProperty(value = "发放事务ID")
    private String traceId;
	
	@ApiModelProperty(value = "发放结果")
    private String result;
	
	@ApiModelProperty(value = "结果描述")
    private String stateDesc;
	
	@ApiModelProperty(value = "创建人ID")
    private Long createdBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "创建人ID")
    private Date createdDate;
	
	@ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@ApiModelProperty(value = "更新时间")
    private Date updatedDate;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Integer getPointsValue() {
		return pointsValue;
	}

	public void setPointsValue(Integer pointsValue) {
		this.pointsValue = pointsValue;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
