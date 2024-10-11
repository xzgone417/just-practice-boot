package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AcquisitionFollowDto", description = "收购数量统计对象")
public class AcquisitionFollowDto extends BaseModel {

	private static final long serialVersionUID = -6687032919961518520L;

	@ApiModelProperty("待收购数")
	private Integer pendingAcquisitions;
	
	@ApiModelProperty("收购数")
	private Integer myAcquisitions;
	
	@ApiModelProperty("带议价数")
	private Integer negotiations;

	@ApiModelProperty(value = "待重新上传审核材料的数量")
	private Integer rejected;

	public AcquisitionFollowDto() {
	}

	public AcquisitionFollowDto(Integer pendingAcquisitions, Integer myAcquisitions, Integer negotiations, Integer rejected) {
		this.pendingAcquisitions = pendingAcquisitions;
		this.myAcquisitions = myAcquisitions;
		this.negotiations = negotiations;
		this.rejected = rejected;
	}

	/**
	 * 获取
	 * @return pendingAcquisitions
	 */
	public Integer getPendingAcquisitions() {
		return pendingAcquisitions;
	}

	/**
	 * 设置
	 * @param pendingAcquisitions
	 */
	public void setPendingAcquisitions(Integer pendingAcquisitions) {
		this.pendingAcquisitions = pendingAcquisitions;
	}

	/**
	 * 获取
	 * @return myAcquisitions
	 */
	public Integer getMyAcquisitions() {
		return myAcquisitions;
	}

	/**
	 * 设置
	 * @param myAcquisitions
	 */
	public void setMyAcquisitions(Integer myAcquisitions) {
		this.myAcquisitions = myAcquisitions;
	}

	/**
	 * 获取
	 * @return negotiations
	 */
	public Integer getNegotiations() {
		return negotiations;
	}

	/**
	 * 设置
	 * @param negotiations
	 */
	public void setNegotiations(Integer negotiations) {
		this.negotiations = negotiations;
	}

	/**
	 * 获取
	 * @return rejected
	 */
	public Integer getRejected() {
		return rejected;
	}

	/**
	 * 设置
	 * @param rejected
	 */
	public void setRejected(Integer rejected) {
		this.rejected = rejected;
	}

	public String toString() {
		return "AcquisitionFollowDto{pendingAcquisitions = " + pendingAcquisitions + ", myAcquisitions = " + myAcquisitions + ", negotiations = " + negotiations + ", rejected = " + rejected + "}";
	}
}
