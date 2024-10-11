package com.exp.ucmp.emdm.dto;

import java.util.List;

import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EmdmDeptReturnDto", description = "Emdm返回类")
public class EmdmDeptReturnDto extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "服务器返回调用状态")
	private String status;
	
	@ApiModelProperty(value = "服务器返回消息")
    private String message;
    
	@ApiModelProperty(value = "数据")
    private List<DeptDto> data;
    
	@ApiModelProperty(value = "code")
    private String code;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<DeptDto> getData() {
		return data;
	}

	public void setData(List<DeptDto> data) {
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
