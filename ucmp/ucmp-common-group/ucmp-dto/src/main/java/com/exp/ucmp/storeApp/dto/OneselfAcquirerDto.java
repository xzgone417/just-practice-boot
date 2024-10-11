package com.exp.ucmp.storeApp.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OneselfAcquisitionDto", description = "本品收购列表数据")
public class OneselfAcquirerDto {
	
	@ApiModelProperty(value = "顾问id")
	private Long partyId;
	
	@ApiModelProperty(value = "交付中心id")
	private Long storeId;
	
	@ApiModelProperty(value = "顾问姓名")
	private String consultant;
	
	@ApiModelProperty(value = "顾问电话")
	private String consultantTel;
	
	@ApiModelProperty(value = "未完成订单数")
	private Integer undone;
	
	@ApiModelProperty(value = "idmAccountName")
	private String idmAccountName;

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getConsultant() {
		return consultant;
	}

	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}

	public String getConsultantTel() {
		return consultantTel;
	}

	public void setConsultantTel(String consultantTel) {
		this.consultantTel = consultantTel;
	}

	public Integer getUndone() {
		return undone;
	}

	public void setUndone(Integer undone) {
		this.undone = undone;
	}

	public String getIdmAccountName() {
		return idmAccountName;
	}

	public void setIdmAccountName(String idmAccountName) {
		this.idmAccountName = idmAccountName;
	}
	
}
