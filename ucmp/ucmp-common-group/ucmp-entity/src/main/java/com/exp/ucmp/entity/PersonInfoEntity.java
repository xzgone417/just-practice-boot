package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "PersonInfoEntity", description = "人员信息")
@GroupSequence({PersonInfoEntity.class, PersonInfoEntity.PersonInfoEntityValidGroup.class,PersonInfoEntity.PartyIdValidGroup.class,PersonInfoEntity.PersonNameValidGroup.class,PersonInfoEntity.SexTypeCodeValidGroup.class,PersonInfoEntity.MaritalTypeCodeValidGroup.class,PersonInfoEntity.PersonMemoValidGroup.class,PersonInfoEntity.CreatedByValidGroup.class,PersonInfoEntity.CreatedDateValidGroup.class,PersonInfoEntity.UpdatedByValidGroup.class,PersonInfoEntity.UpdatedDateValidGroup.class}) 
public class PersonInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 当事人标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "当事人标识 不能是Null", groups = {PersonInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="当事人标识 数字精度必须符合(19,0)", groups = {PersonInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;
    
    
    /**
     * 姓名
     */
    @NotNull(message = "姓名 不能是Null", groups = {PersonInfoEntityValidGroup.class, PersonNameValidGroup.class})
    @Size(min=0, max=50, message="姓名 字符长度必须小于等于50", groups = {PersonInfoEntityValidGroup.class, PersonNameValidGroup.class})
    @ApiModelProperty(value = "姓名")
    private String personName;
    
    /**
     * 性别
     */
    @Size(min=0, max=10, message="性别 字符长度必须小于等于10", groups = {PersonInfoEntityValidGroup.class, SexTypeCodeValidGroup.class})
    @ApiModelProperty(value = "性别")
    private String sexTypeCode;
    
    /**
     * 出生日期
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "出生日期")
    private Date birthDate;
    
    /**
     * 婚姻状况
     */
    @Size(min=0, max=10, message="婚姻状况 字符长度必须小于等于10", groups = {PersonInfoEntityValidGroup.class, MaritalTypeCodeValidGroup.class})
    @ApiModelProperty(value = "婚姻状况")
    private String maritalTypeCode;
    
    /**
     * 备注
     */
    @Size(min=0, max=500, message="备注 字符长度必须小于等于500", groups = {PersonInfoEntityValidGroup.class, PersonMemoValidGroup.class})
    @ApiModelProperty(value = "备注")
    private String personMemo;



    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PersonInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PersonInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PersonInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PersonInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PersonInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PersonInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PersonInfoEntity() {
    }
    
    public PersonInfoEntity(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    

    public void setPersonName(String personName) {
        this.personName = personName;
    }
    public String getPersonName() {
        return this.personName;
    }
    
    public void setSexTypeCode(String sexTypeCode) {
        this.sexTypeCode = sexTypeCode;
    }
    public String getSexTypeCode() {
        return this.sexTypeCode;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public void setMaritalTypeCode(String maritalTypeCode) {
        this.maritalTypeCode = maritalTypeCode;
    }
    public String getMaritalTypeCode() {
        return this.maritalTypeCode;
    }
    
    public void setPersonMemo(String personMemo) {
        this.personMemo = personMemo;
    }
    public String getPersonMemo() {
        return this.personMemo;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Long getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (partyId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                partyId = RandomIDGennerator.get().generate();
    }

    public interface PersonInfoEntityValidGroup {}
    public interface PartyIdValidGroup {}
    public interface PersonNameValidGroup {}
    public interface SexTypeCodeValidGroup {}
    public interface MaritalTypeCodeValidGroup {}
    public interface PersonMemoValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PersonInfoEntity.PartyIdValidGroup.class
            , PersonInfoEntity.PersonNameValidGroup.class
            , PersonInfoEntity.SexTypeCodeValidGroup.class
            , PersonInfoEntity.MaritalTypeCodeValidGroup.class
            , PersonInfoEntity.PersonMemoValidGroup.class
            , PersonInfoEntity.CreatedByValidGroup.class
            , PersonInfoEntity.CreatedDateValidGroup.class
            , PersonInfoEntity.UpdatedByValidGroup.class
            , PersonInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
