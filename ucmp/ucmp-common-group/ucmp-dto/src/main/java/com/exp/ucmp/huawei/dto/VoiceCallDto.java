package com.exp.ucmp.huawei.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VoiceCallinDto", description = "语音参数")
public class VoiceCallDto {
	
	@ApiModelProperty(value = "唯一指定一条通话链路的标识ID")
	private String sessionId;
	
	@ApiModelProperty(value = "该呼叫事件发生时隐私保护通话平台的UNIX时间戳")
    private String timestamp;
	
	@ApiModelProperty(value = "主叫号码")
    private String caller;
	
	@ApiModelProperty(value = "被叫号码，呼入事件的被叫号码为X号码")
    private String called;
	
	@ApiModelProperty(value = "绑定ID")
    private String subscriptionId;
	
	@ApiModelProperty(value = "通话挂机的原因值，仅当eventType为disconnect时携带")
	private Integer stateCode;
	
	@ApiModelProperty(value = "通话挂机的原因值的描述，仅当eventType为disconnect时携带")
	private String stateDesc;
	
	@ApiModelProperty(value = "指定X号码查询该号码上所有绑定关系")
	private String relationNum;
	
	@ApiModelProperty(value = "用户附属信息")
	private String userData;
	
	@ApiModelProperty(value = "查询的分页索引，从1开始编号")
	private Integer pageIndex;
	
	@ApiModelProperty(value = "查询的分页大小，即每次查询返回多少条数据 取值范围：10~100,默认50")
	private Integer pageSize;
	
	@ApiModelProperty(value = "顾问所属门店id")
	private String departmentId;
	
	@ApiModelProperty(value = "车商人员的partyId")
	private Long partnerStaffPartyId;
	
	@ApiModelProperty(value = "预约id")
	private Long reservationId;
	
	@Max(3)
	@Min(1)
	@ApiModelProperty(value = "被叫人类型 1 门店员工 2 车商 3 客户")
	private Integer calledType;
	
	@ApiModelProperty(value = "主叫是否加密 0 未加密 1已加密")
	private int callerIsEn;
	
	@ApiModelProperty(value = "记录id")
	private Long recordId;
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getCaller() {
		return caller;
	}

	public void setCaller(String caller) {
		this.caller = caller;
	}

	public String getCalled() {
		return called;
	}

	public void setCalled(String called) {
		this.called = called;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateDesc() {
		return stateDesc;
	}

	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}

	public String getRelationNum() {
		return relationNum;
	}

	public void setRelationNum(String relationNum) {
		this.relationNum = relationNum;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public Long getPartnerStaffPartyId() {
		return partnerStaffPartyId;
	}

	public void setPartnerStaffPartyId(Long partnerStaffPartyId) {
		this.partnerStaffPartyId = partnerStaffPartyId;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Integer getCalledType() {
		return calledType;
	}

	public void setCalledType(Integer calledType) {
		this.calledType = calledType;
	}

	public int getCallerIsEn() {
		return callerIsEn;
	}

	public void setCallerIsEn(int callerIsEn) {
		this.callerIsEn = callerIsEn;
	}

	public String getUserData() {
		return userData;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}
	
}
