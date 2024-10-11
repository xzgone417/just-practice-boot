package com.exp.ucmp.urm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UrmRteurnDto", description = "urm返回类")
public class UrmRteurnDto {

	@ApiModelProperty(value = "事务ID")
	private String traceId;
	
	@ApiModelProperty(value = "响应时间")
    private String respTime;
	
	@ApiModelProperty(value = "调用结果")
    private boolean success;
	
	@ApiModelProperty(value = "状态code")
    private int stateCode;
	
	@ApiModelProperty(value = "响应数据")
    private UrmDataDto data;
	
    private String stateDesc;
    private String stateDetail;
    private String inner;
	public String getTraceId() {
		return traceId;
	}
	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}
	public String getRespTime() {
		return respTime;
	}
	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	public UrmDataDto getData() {
		return data;
	}
	public void setData(UrmDataDto data) {
		this.data = data;
	}
	public String getStateDesc() {
		return stateDesc;
	}
	public void setStateDesc(String stateDesc) {
		this.stateDesc = stateDesc;
	}
	public String getStateDetail() {
		return stateDetail;
	}
	public void setStateDetail(String stateDetail) {
		this.stateDetail = stateDetail;
	}
	public String getInner() {
		return inner;
	}
	public void setInner(String inner) {
		this.inner = inner;
	}
}
