package com.exp.ucmp.rightset.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


/**
 * @author hailele
 * @Description: 参与人数列表Dto
 * @date 2022/11/21 14:19
 */
@ApiModel(value = "DistributeDetailsPageDto", description = "参与人数列表Dto")
public class DistributeDetailsPageDto extends PageDto {


    /**
     * 发放明细主键ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "发放明细主键ID")
    private Long distributeDetailId;


    /**
     * 权益包编号
     */
    @ApiModelProperty(value = "权益包编号")
    private Long rightPackId;

    /**
     * 权益发放编号
     */
    @ApiModelProperty(value = "权益发放编号")
    private Long rightGrantId;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    /**
     * 客户手机号
     */
    @ApiModelProperty(value = "客户手机号")
    private String customerIphone;

    /**
     * 发放时间
     */
    @ApiModelProperty(value = "发放时间")
    private Date distributeDate;

    /**
     * 权益名称
     */
    @ApiModelProperty(value = "权益名称")
    private String campaignName;

    public Long getDistributeDetailId() {
        return distributeDetailId;
    }

    public void setDistributeDetailId(Long distributeDetailId) {
        this.distributeDetailId = distributeDetailId;
    }

    public Long getRightPackId() {
        return rightPackId;
    }

    public void setRightPackId(Long rightPackId) {
        this.rightPackId = rightPackId;
    }

    public Long getRightGrantId() {
        return rightGrantId;
    }

    public void setRightGrantId(Long rightGrantId) {
        this.rightGrantId = rightGrantId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIphone() {
        return customerIphone;
    }

    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }

    public Date getDistributeDate() {
        return distributeDate;
    }

    public void setDistributeDate(Date distributeDate) {
        this.distributeDate = distributeDate;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
}
