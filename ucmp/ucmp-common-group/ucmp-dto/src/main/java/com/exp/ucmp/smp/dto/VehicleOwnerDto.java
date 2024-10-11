package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VehicleOwnerDto", description = "车辆信息返回类")
public class VehicleOwnerDto {

	@ApiModelProperty(value = "姓名")
	private String name;
	
	@ApiModelProperty(value = "证件类型 1.身份证,2:护照,3:军官证,4:港澳居民来往内地通行证,5:台胞证,6:统一社会信用代码")
    private String certificateType;
	
	@ApiModelProperty(value = "证件号码")
    private String certificateNo;
	
	@ApiModelProperty(value = "手机号")
    private String mobile;
	
	@ApiModelProperty(value = "地址")
    private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
