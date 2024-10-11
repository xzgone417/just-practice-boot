package com.exp.ucmp.carDealer.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AcquisitionQueryParamDto", description = "收购查询对象")
public class AcquisitionQueryParamDto extends PageDto {

	private static final long serialVersionUID = 6437836749108288882L;

	@ApiModelProperty(value = "业务编号")
	private String businessOrderNo;

	public AcquisitionQueryParamDto() {
	}

	public AcquisitionQueryParamDto(String businessOrderNo, String acquisitionQueryType) {
		this.businessOrderNo = businessOrderNo;
		this.acquisitionQueryType = acquisitionQueryType;
	}

	/**
	 * 获取
	 * @return businessOrderNo
	 */
	public String getBusinessOrderNo() {
		return businessOrderNo;
	}

	/**
	 * 设置
	 * @param businessOrderNo
	 */
	public void setBusinessOrderNo(String businessOrderNo) {
		this.businessOrderNo = businessOrderNo;
	}

	/**
	 * 获取
	 * @return acquisitionQueryType
	 */
	public String getAcquisitionQueryType() {
		return acquisitionQueryType;
	}

	/**
	 * 设置
	 * @param acquisitionQueryType
	 */
	public void setAcquisitionQueryType(String acquisitionQueryType) {
		this.acquisitionQueryType = acquisitionQueryType;
	}

	public String toString() {
		return "AcquisitionQueryParamDto{businessOrderNo = " + businessOrderNo + ", acquisitionQueryType = " + acquisitionQueryType + "}";
	}

	public enum AcquisitionQueryTypeEnum {
		acquisitionUnAcquired, acquisitionUnNegotiated, acquisitionAcquired,
		acquisitionNotAcquired,unTransfer,completed,reported,rejected,closedOrInvalid;
	}
	
	/**
     * 查询类型
     */
    @ApiModelProperty(value = "查询类型: acquisitionUnAcquired(待收购),acquisitionUnNegotiated(待议价),acquisitionAcquired(已收购),acquisitionNotAcquired(未收购)" +
			"unTransfer(待过户),completed(已完成),reported(已上报),rejected(驳回处理),closedOrInvalid(关闭/失效)",required = true)
    private String acquisitionQueryType;
    
}
