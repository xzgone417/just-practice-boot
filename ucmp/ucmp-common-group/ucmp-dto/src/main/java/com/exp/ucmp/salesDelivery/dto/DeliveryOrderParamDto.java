package com.exp.ucmp.salesDelivery.dto;


import javax.validation.constraints.NotNull;

import com.exp.ucmp.PageDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DeliveryOrderParamDto", description = "二手车销售交付列表参数类")
public class DeliveryOrderParamDto  extends PageDto{
	
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
	
	@ApiModelProperty(value = "订单状态 不必传:7403 已转交付待全款,7404 已全款待交付 ,7406 已交付,7409 已转交付待分配")
	private String status;
	
	@ApiModelProperty(value = "搜索字段 手机号精确匹配，其它模糊 不必传")
	private String searchWord;
	
	@ApiModelProperty(value = "客户手机号 不用传")
	private String customerIphone;
	
	@ApiModelProperty(value = "是否查交付中心所有销售交付订单 1 是 2 不是 不必传")
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
