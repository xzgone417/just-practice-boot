package com.exp.ucmp.storeApp.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserInfoInsertDto", description = "新增用户信息所需参数")
public class UserInfoInsertDto {
    private static final long serialVersionUID = 1L;
    /**
     * 当事人标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;


    /**
     * 当事人类型：0100、人员，0200、组织，0300、职位
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当事人类型：0100、人员，0200、组织，0300、职位")
    private String partyType;

    /**
     * 姓名
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "姓名")
    private String personName;

    /**
     * 性别 M:男，F:女
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "性别 M:男，F:女")
    private String sexTypeCode;

    /**
     * 账户名称
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "账户名称")
    private String idmAccountName;

    /**
     * 账号有效标记：00、已失效，01、有效，09、暂时失效
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "账号有效标记：00、已失效，01、有效，09、暂时失效")
    private String validMark;

    public UserInfoInsertDto(){}
    public UserInfoInsertDto(Long partyId,String partyType,String personName,String sexTypeCode,String idmAccountName,String validMark){
            setPartyId(partyId);
            setPartyType(partyType);
            setPersonName(personName);
            setSexTypeCode(sexTypeCode);
            setIdmAccountName(idmAccountName);
            setValidMark(validMark);
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

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getValidMark() {
        return validMark;
    }

    public void setValidMark(String validMark) {
        this.validMark = validMark;
    }

    public String getSexTypeCode() {
        return sexTypeCode;
    }

    public void setSexTypeCode(String sexTypeCode) {
        this.sexTypeCode = sexTypeCode;
    }
}
