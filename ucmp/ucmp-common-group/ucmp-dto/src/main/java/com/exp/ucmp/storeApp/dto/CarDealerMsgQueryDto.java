package com.exp.ucmp.storeApp.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarDealerMsgQueryDto", description = "车商查询传入参数")
public class CarDealerMsgQueryDto extends BaseModel {
    private static final long serialVersionUID = 1L;




    /**
     * 当前登录用户名
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当前登录用户名/分配车商传入参数")
    private String idmAccountName;


    /**
     * 预约id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约id/参与,签到,分配车商传入参数")
    private Long reservationId;


    /**
     * 登录人id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "登录人id/不需要传")
    private Long partyId;

    /**
     * 门店ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店ID")
    private Long storeId;

    /**
     * 询价单状态：0901待接单   0902已接单   0909放弃接单   0911待报价  0912已报价  0918逾期未报价  0919放弃报价
     */
    @ApiModelProperty(value = "询价单状态：0901待接单   0902已接单   0909放弃接单   0911待报价  0912已报价  0918逾期未报价  0919放弃报价/车商签到传入参数()")
    private String inquiryStatus;
    
    @ApiModelProperty(value = "合作商简称")
    private String partnerAbbreviation;

    public String getInquiryStatus() {
        return inquiryStatus;
    }

    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getIdmAccountName() {
        return idmAccountName;
    }

    public void setIdmAccountName(String idmAccountName) {
        this.idmAccountName = idmAccountName;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

	public String getPartnerAbbreviation() {
		return partnerAbbreviation;
	}

	public void setPartnerAbbreviation(String partnerAbbreviation) {
		this.partnerAbbreviation = partnerAbbreviation;
	}
    
}
