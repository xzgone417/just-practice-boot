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

@ApiModel(value = "SysPartnerStaffInfoEntity", description = "合作商人员信息表")
@GroupSequence({SysPartnerStaffInfoEntity.class, SysPartnerStaffInfoEntity.SysPartnerStaffInfoEntityValidGroup.class,SysPartnerStaffInfoEntity.PartyIdValidGroup.class,SysPartnerStaffInfoEntity.PartnerStaffNameValidGroup.class,SysPartnerStaffInfoEntity.PartnerStaffIphoneValidGroup.class,SysPartnerStaffInfoEntity.PartnerStaffSexValidGroup.class,SysPartnerStaffInfoEntity.PartnerStaffEmailValidGroup.class,SysPartnerStaffInfoEntity.IsDeleteValidGroup.class,SysPartnerStaffInfoEntity.CreatedByValidGroup.class,SysPartnerStaffInfoEntity.CreatedDateValidGroup.class,SysPartnerStaffInfoEntity.UpdatedByValidGroup.class,SysPartnerStaffInfoEntity.UpdatedDateValidGroup.class}) 
public class SysPartnerStaffInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键 不能是Null", groups = {SysPartnerStaffInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键 数字精度必须符合(19,0)", groups = {SysPartnerStaffInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "主键")
    private Long partyId;
    
    
    /**
     * 车商指定人姓名
     */
    @Size(min=0, max=50, message="车商指定人姓名 字符长度必须小于等于50", groups = {SysPartnerStaffInfoEntityValidGroup.class, PartnerStaffNameValidGroup.class})
    @ApiModelProperty(value = "车商指定人姓名")
    private String partnerStaffName;
    
    /**
     * 车上指定人手机
     */
    @Size(min=0, max=20, message="车上指定人手机 字符长度必须小于等于20", groups = {SysPartnerStaffInfoEntityValidGroup.class, PartnerStaffIphoneValidGroup.class})
    @ApiModelProperty(value = "车上指定人手机")
    private String partnerStaffIphone;
    
    /**
     * 性别
     */
    @Size(min=0, max=4, message="性别 字符长度必须小于等于4", groups = {SysPartnerStaffInfoEntityValidGroup.class, PartnerStaffSexValidGroup.class})
    @ApiModelProperty(value = "性别")
    private String partnerStaffSex;
    
    /**
     * 邮箱
     */
    @Size(min=0, max=100, message="邮箱 字符长度必须小于等于100", groups = {SysPartnerStaffInfoEntityValidGroup.class, PartnerStaffEmailValidGroup.class})
    @ApiModelProperty(value = "邮箱")
    private String partnerStaffEmail;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {SysPartnerStaffInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {SysPartnerStaffInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysPartnerStaffInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysPartnerStaffInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysPartnerStaffInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysPartnerStaffInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysPartnerStaffInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysPartnerStaffInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysPartnerStaffInfoEntity() {
    }
    
    public SysPartnerStaffInfoEntity(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    

    public void setPartnerStaffName(String partnerStaffName) {
        this.partnerStaffName = partnerStaffName;
    }
    public String getPartnerStaffName() {
        return this.partnerStaffName;
    }
    
    public void setPartnerStaffIphone(String partnerStaffIphone) {
        this.partnerStaffIphone = partnerStaffIphone;
    }
    public String getPartnerStaffIphone() {
        return this.partnerStaffIphone;
    }
    
    public void setPartnerStaffSex(String partnerStaffSex) {
        this.partnerStaffSex = partnerStaffSex;
    }
    public String getPartnerStaffSex() {
        return this.partnerStaffSex;
    }
    
    public void setPartnerStaffEmail(String partnerStaffEmail) {
        this.partnerStaffEmail = partnerStaffEmail;
    }
    public String getPartnerStaffEmail() {
        return this.partnerStaffEmail;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
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

    public interface SysPartnerStaffInfoEntityValidGroup {}
    public interface PartyIdValidGroup {}
    public interface PartnerStaffNameValidGroup {}
    public interface PartnerStaffIphoneValidGroup {}
    public interface PartnerStaffSexValidGroup {}
    public interface PartnerStaffEmailValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PartyIdValidGroup.class
            , PartnerStaffNameValidGroup.class
            , PartnerStaffIphoneValidGroup.class
            , PartnerStaffSexValidGroup.class
            , PartnerStaffEmailValidGroup.class
            , IsDeleteValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
