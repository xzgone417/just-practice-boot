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

@ApiModel(value = "SysStaffDetailsEntity", description = "人员信息详情表")
@GroupSequence({SysStaffDetailsEntity.class, SysStaffDetailsEntity.SysStaffDetailsEntityValidGroup.class,SysStaffDetailsEntity.PartyIdValidGroup.class,SysStaffDetailsEntity.StaffCodeValidGroup.class,SysStaffDetailsEntity.StaffNameValidGroup.class,SysStaffDetailsEntity.StaffEmailValidGroup.class,SysStaffDetailsEntity.StaffSexValidGroup.class,SysStaffDetailsEntity.StaffIphoneValidGroup.class,SysStaffDetailsEntity.StaffStatusValidGroup.class,SysStaffDetailsEntity.StaffTypeValidGroup.class,SysStaffDetailsEntity.CreatedByValidGroup.class,SysStaffDetailsEntity.CreatedDateValidGroup.class,SysStaffDetailsEntity.UpdatedByValidGroup.class,SysStaffDetailsEntity.UpdatedDateValidGroup.class,SysStaffDetailsEntity.IsDeleteValidGroup.class}) 
public class SysStaffDetailsEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "员工ID 不能是Null", groups = {SysStaffDetailsEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="员工ID 数字精度必须符合(19,0)", groups = {SysStaffDetailsEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "员工ID")
    private Long partyId;
    
    
    /**
     * 人员编号
     */
    @NotNull(message = "人员编号 不能是Null", groups = {SysStaffDetailsEntityValidGroup.class, StaffCodeValidGroup.class})
    @Size(min=0, max=20, message="人员编号 字符长度必须小于等于20", groups = {SysStaffDetailsEntityValidGroup.class, StaffCodeValidGroup.class})
    @ApiModelProperty(value = "人员编号")
    private String staffCode;
    
    /**
     * 人员姓名
     */
    @NotNull(message = "人员姓名 不能是Null", groups = {SysStaffDetailsEntityValidGroup.class, StaffNameValidGroup.class})
    @Size(min=0, max=50, message="人员姓名 字符长度必须小于等于50", groups = {SysStaffDetailsEntityValidGroup.class, StaffNameValidGroup.class})
    @ApiModelProperty(value = "人员姓名")
    private String staffName;
    
    /**
     * 人员邮箱
     */
    @Size(min=0, max=100, message="人员邮箱 字符长度必须小于等于100", groups = {SysStaffDetailsEntityValidGroup.class, StaffEmailValidGroup.class})
    @ApiModelProperty(value = "人员邮箱")
    private String staffEmail;
    
    /**
     * 人员性别
     */
    @Size(min=0, max=4, message="人员性别 字符长度必须小于等于4", groups = {SysStaffDetailsEntityValidGroup.class, StaffSexValidGroup.class})
    @ApiModelProperty(value = "人员性别")
    private String staffSex;
    
    /**
     * 人员手机号
     */
    @Size(min=0, max=20, message="人员手机号 字符长度必须小于等于20", groups = {SysStaffDetailsEntityValidGroup.class, StaffIphoneValidGroup.class})
    @ApiModelProperty(value = "人员手机号")
    private String staffIphone;
    
    /**
     * 人员状态:启用01/禁用00
     */
    @NotNull(message = "人员状态:启用01/禁用00 不能是Null", groups = {SysStaffDetailsEntityValidGroup.class, StaffStatusValidGroup.class})
    @Size(min=0, max=2, message="人员状态:启用01/禁用00 字符长度必须小于等于2", groups = {SysStaffDetailsEntityValidGroup.class, StaffStatusValidGroup.class})
    @ApiModelProperty(value = "人员状态:启用01/禁用00")
    private String staffStatus;
    
    /**
     * 人员类型(0010总部,0020门店,0030车商.....)
     */
    @NotNull(message = "人员类型(0010总部,0020门店,0030车商.....) 不能是Null", groups = {SysStaffDetailsEntityValidGroup.class, StaffTypeValidGroup.class})
    @Size(min=0, max=4, message="人员类型(0010总部,0020门店,0030车商.....) 字符长度必须小于等于4", groups = {SysStaffDetailsEntityValidGroup.class, StaffTypeValidGroup.class})
    @ApiModelProperty(value = "人员类型(0010总部,0020门店,0030车商.....)")
    private String staffType;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysStaffDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysStaffDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysStaffDetailsEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysStaffDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysStaffDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysStaffDetailsEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否已删除(0：未删除/1：已删除)
     */
    @NotNull(message = "是否已删除(0：未删除/1：已删除) 不能是Null", groups = {SysStaffDetailsEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(0：未删除/1：已删除)")
    private String isDelete;
    
    public SysStaffDetailsEntity() {
    }
    
    public SysStaffDetailsEntity(Long partyId) {
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

    public interface SysStaffDetailsEntityValidGroup {}
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
            SysStaffDetailsEntity.PartyIdValidGroup.class
            , SysStaffDetailsEntity.StaffCodeValidGroup.class
            , SysStaffDetailsEntity.StaffNameValidGroup.class
            , SysStaffDetailsEntity.StaffEmailValidGroup.class
            , SysStaffDetailsEntity.StaffSexValidGroup.class
            , SysStaffDetailsEntity.StaffIphoneValidGroup.class
            , SysStaffDetailsEntity.StaffStatusValidGroup.class
            , SysStaffDetailsEntity.StaffTypeValidGroup.class
            , SysStaffDetailsEntity.CreatedByValidGroup.class
            , SysStaffDetailsEntity.CreatedDateValidGroup.class
            , SysStaffDetailsEntity.UpdatedByValidGroup.class
            , SysStaffDetailsEntity.UpdatedDateValidGroup.class
            , SysStaffDetailsEntity.IsDeleteValidGroup.class
        };
    }
}
