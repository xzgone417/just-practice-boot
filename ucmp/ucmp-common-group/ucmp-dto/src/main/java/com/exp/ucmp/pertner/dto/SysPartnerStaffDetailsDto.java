package com.exp.ucmp.pertner.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SysPartnerStaffDetailsDto", description = "合作商下人员详情信息")
public class SysPartnerStaffDetailsDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 主键/合作商标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键/合作商标识")
    private Long partnerId;

    /**
     * 门店id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店id")
    private Long storeId;

    /**
     * 登录标识

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "登录标识")
    private Long loginId;
*/

    /**
     * 人员标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "人员标识")
    private Long partyId;

    /**
     * 人员姓名
     */
    @ApiModelProperty(value = "人员姓名")
    private String partyName;

    /**
     * 人员手机号
     */
    @ApiModelProperty(value = "人员手机号")
    private String partyIphone;

    /**
     * 人员性别
     */
    @ApiModelProperty(value = "人员性别")
    private String partySex;

    /**
     * 人员邮箱
     */
    @ApiModelProperty(value = "人员邮箱")
    private String partyEmail;



    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称")
    private String orgName;



    /**
     * 人员管辖门店id集合
     */
    @ApiModelProperty(value = "人员管辖门店id集合")
    private String storeIds;


    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyIphone() {
        return partyIphone;
    }

    public void setPartyIphone(String partyIphone) {
        this.partyIphone = partyIphone;
    }

    public String getPartySex() {
        return partySex;
    }

    public void setPartySex(String partySex) {
        this.partySex = partySex;
    }

    public String getPartyEmail() {
        return partyEmail;
    }

    public void setPartyEmail(String partyEmail) {
        this.partyEmail = partyEmail;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(String storeIds) {
        this.storeIds = storeIds;
    }
}
