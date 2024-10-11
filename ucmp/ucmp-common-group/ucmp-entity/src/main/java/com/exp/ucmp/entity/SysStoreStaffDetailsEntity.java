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

@ApiModel(value = "SysStoreStaffDetailsEntity", description = "门店人员信息详情表")
@GroupSequence({SysStoreStaffDetailsEntity.class, SysStoreStaffDetailsEntity.SysStoreStaffDetailsEntityValidGroup.class,SysStoreStaffDetailsEntity.PartyIdValidGroup.class,SysStoreStaffDetailsEntity.StaffCodeValidGroup.class,SysStoreStaffDetailsEntity.StaffNameValidGroup.class,SysStoreStaffDetailsEntity.StaffEmailValidGroup.class,SysStoreStaffDetailsEntity.StaffSexValidGroup.class,SysStoreStaffDetailsEntity.StaffIphoneValidGroup.class,SysStoreStaffDetailsEntity.StaffStatusValidGroup.class,SysStoreStaffDetailsEntity.StaffTypeValidGroup.class,SysStoreStaffDetailsEntity.CreatedByValidGroup.class,SysStoreStaffDetailsEntity.CreatedDateValidGroup.class,SysStoreStaffDetailsEntity.UpdatedByValidGroup.class,SysStoreStaffDetailsEntity.UpdatedDateValidGroup.class,SysStoreStaffDetailsEntity.IsDeleteValidGroup.class}) 
public class SysStoreStaffDetailsEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "员工ID 不能是Null", groups = {SysStoreStaffDetailsEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="员工ID 数字精度必须符合(19,0)", groups = {SysStoreStaffDetailsEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "员工ID")
    private Long partyId;
    
    
    /**
     * 人员编号
     */
    @NotNull(message = "人员编号 不能是Null", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffCodeValidGroup.class})
    @Size(min=0, max=20, message="人员编号 字符长度必须小于等于20", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffCodeValidGroup.class})
    @ApiModelProperty(value = "人员编号")
    private String staffCode;
    
    /**
     * 人员姓名
     */
    @NotNull(message = "人员姓名 不能是Null", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffNameValidGroup.class})
    @Size(min=0, max=50, message="人员姓名 字符长度必须小于等于50", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffNameValidGroup.class})
    @ApiModelProperty(value = "人员姓名")
    private String staffName;
    
    /**
     * 人员邮箱
     */
    @Size(min=0, max=100, message="人员邮箱 字符长度必须小于等于100", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffEmailValidGroup.class})
    @ApiModelProperty(value = "人员邮箱")
    private String staffEmail;
    
    /**
     * 人员性别
     */
    @Size(min=0, max=4, message="人员性别 字符长度必须小于等于4", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffSexValidGroup.class})
    @ApiModelProperty(value = "人员性别")
    private String staffSex;
    
    /**
     * 人员手机号
     */
    @Size(min=0, max=20, message="人员手机号 字符长度必须小于等于20", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffIphoneValidGroup.class})
    @ApiModelProperty(value = "人员手机号")
    private String staffIphone;
    
    /**
     * 人员状态:启用01/禁用00
     */
    @NotNull(message = "人员状态:启用01/禁用00 不能是Null", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffStatusValidGroup.class})
    @Size(min=0, max=2, message="人员状态:启用01/禁用00 字符长度必须小于等于2", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffStatusValidGroup.class})
    @ApiModelProperty(value = "人员状态:启用01/禁用00")
    private String staffStatus;
    
    /**
     * 人员类型(0020门店)
     */
    @NotNull(message = "人员类型(0020门店) 不能是Null", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffTypeValidGroup.class})
    @Size(min=0, max=4, message="人员类型(0020门店) 字符长度必须小于等于4", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffTypeValidGroup.class})
    @ApiModelProperty(value = "人员类型(0020门店)")
    private String staffType;

    /**
     * 官二资质状态（启用01/禁用00）
     */
    @Size(min=0, max=1, message="官二资质状态(00:禁用/01:启用)", groups = {SysStoreStaffDetailsEntityValidGroup.class, StaffTypeValidGroup.class})
    @ApiModelProperty(value = "官二资质状态（启用01/禁用00）")
    private String qualificationStatus;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysStoreStaffDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysStoreStaffDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysStoreStaffDetailsEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysStoreStaffDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysStoreStaffDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysStoreStaffDetailsEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否被删除：00、删除，01、未删除
     */
    @NotNull(message = "是否被删除：00、删除，01、未删除 不能是Null", groups = {SysStoreStaffDetailsEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、删除，01、未删除 字符长度必须小于等于2", groups = {SysStoreStaffDetailsEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;
    
    public SysStoreStaffDetailsEntity() {
    }
    
    public SysStoreStaffDetailsEntity(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }
    public String getStaffCode() {
        return this.staffCode;
    }
    
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public String getStaffName() {
        return this.staffName;
    }
    
    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }
    public String getStaffEmail() {
        return this.staffEmail;
    }
    
    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }
    public String getStaffSex() {
        return this.staffSex;
    }
    
    public void setStaffIphone(String staffIphone) {
        this.staffIphone = staffIphone;
    }
    public String getStaffIphone() {
        return this.staffIphone;
    }
    
    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }
    public String getStaffStatus() {
        return this.staffStatus;
    }
    
    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }
    public String getStaffType() {
        return this.staffType;
    }

    public String getQualificationStatus() {
        return qualificationStatus;
    }

    public void setQualificationStatus(String qualificationStatus) {
        this.qualificationStatus = qualificationStatus;
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
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
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

    public interface SysStoreStaffDetailsEntityValidGroup {}
    public interface PartyIdValidGroup {}
    public interface StaffCodeValidGroup {}
    public interface StaffNameValidGroup {}
    public interface StaffEmailValidGroup {}
    public interface StaffSexValidGroup {}
    public interface StaffIphoneValidGroup {}
    public interface StaffStatusValidGroup {}
    public interface StaffTypeValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PartyIdValidGroup.class
            , StaffCodeValidGroup.class
            , StaffNameValidGroup.class
            , StaffEmailValidGroup.class
            , StaffSexValidGroup.class
            , StaffIphoneValidGroup.class
            , StaffStatusValidGroup.class
            , StaffTypeValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
