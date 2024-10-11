package com.exp.ucmp.pertner.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysPartnerDetailsDto", description = "合作商详情信息")
public class SysPartnerDetailsDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 主键/合作商标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键/合作商标识")
    private Long partnerId;


    /**
     * 合作商编码
     */
    @ApiModelProperty(value = "合作商编码")
    private String partnerCode;

    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    private String partnerChargePerson;

    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    private String chargePersonIphone;

    /**
     * 合作商名称
     */
    @ApiModelProperty(value = "合作商名称")
    private String partnerName;

    /**
     * 参与权限： 0100置换 0200转售
     */
    @ApiModelProperty(value = "参与权限： 0100置换 0200转售")
    private String partnerJoinRole;

    /**
     * 合作商状态 00：关闭 01：开启
     */
    @ApiModelProperty(value = "合作商状态 00：关闭 01：开启")
    private String partnerStatus;

    /**
     * 合作商地址
     */
    @ApiModelProperty(value = "合作商地址")
    private String partnerAddress;


    /**
     * 合作商管辖门店
     */
    @ApiModelProperty(value = "合作商管辖门店")
    private String orgNames;


    /**
     * 合作商简称
     */
    @ApiModelProperty(value = "合作商简称")
    private String partnerAbbreviation;

    /**
     * 所占分值
     */
    @ApiModelProperty(value = "所占分值")
    private Double partnerOrder;

    /**
     * 排名
     */
    @ApiModelProperty(value = "排名")
    private Integer partnerSort;

    public SysPartnerDetailsDto() {
    }

    public SysPartnerDetailsDto(Long partnerId) {
        this.partnerId = partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
    public Long getPartnerId() {
        return this.partnerId;
    }
    

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }
    public String getPartnerCode() {
        return this.partnerCode;
    }
    
    public void setPartnerChargePerson(String partnerChargePerson) {
        this.partnerChargePerson = partnerChargePerson;
    }
    public String getPartnerChargePerson() {
        return this.partnerChargePerson;
    }
    
    public void setChargePersonIphone(String chargePersonIphone) {
        this.chargePersonIphone = chargePersonIphone;
    }
    public String getChargePersonIphone() {
        return this.chargePersonIphone;
    }
    
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
    public String getPartnerName() {
        return this.partnerName;
    }
    
    public void setPartnerJoinRole(String partnerJoinRole) {
        this.partnerJoinRole = partnerJoinRole;
    }
    public String getPartnerJoinRole() {
        return this.partnerJoinRole;
    }
    
    public void setPartnerStatus(String partnerStatus) {
        this.partnerStatus = partnerStatus;
    }
    public String getPartnerStatus() {
        return this.partnerStatus;
    }
    
    public void setPartnerAddress(String partnerAddress) {
        this.partnerAddress = partnerAddress;
    }
    public String getPartnerAddress() {
        return this.partnerAddress;
    }

    public String getOrgNames() {
        return orgNames;
    }

    public Double getPartnerOrder() {
        return partnerOrder;
    }

    public void setPartnerOrder(Double partnerOrder) {
        this.partnerOrder = partnerOrder;
    }

    public Integer getPartnerSort() {
        return partnerSort;
    }

    public void setPartnerSort(Integer partnerSort) {
        this.partnerSort = partnerSort;
    }

    public void setOrgNames(String orgNames) {
        this.orgNames = orgNames;
    }

    public String getPartnerAbbreviation() {
        return partnerAbbreviation;
    }

    public void setPartnerAbbreviation(String partnerAbbreviation) {
        this.partnerAbbreviation = partnerAbbreviation;
    }
}
