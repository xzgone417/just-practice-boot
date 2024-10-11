package com.exp.ucmp.storeApp.dto;


import javax.validation.constraints.NotNull;

import com.exp.ucmp.PageDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OneselfAcquisitionParamDto", description = "本品收购列表参数类")
public class OneselfAcquisitionParamDto  extends PageDto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@ApiModelProperty(value = "用户ID")
	private Long partyId;
	
	@NotNull
	@ApiModelProperty(value = "用户角色code")
	private String roleCode;

	@NotNull
	@ApiModelProperty(value = "门店ID")
	private Long storeId;
	
	@ApiModelProperty(value = "订单状态:1106-待分配车辆支持,1101-待收购,1303-待审批,1305-审批驳回,1309-审批关闭,1104-待入库,1105-已入库待过户,0923-收购完成")
	private String status;
	
	@ApiModelProperty(value = "搜索字段 精确匹配")
	private String searchWord;
	
	@ApiModelProperty(value = "客户手机号")
	private String customerIphone;
	
	@ApiModelProperty(value = "是否查交付中心所有本品收购订单 1 是 2 不是")
	private Integer isAll;

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getCustomerIphone() {
		return customerIphone;
	}

	public void setCustomerIphone(String customerIphone) {
		this.customerIphone = customerIphone;
	}

	public Integer getIsAll() {
		return isAll;
	}

	public void setIsAll(Integer isAll) {
		this.isAll = isAll;
	}
	
}
