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

@ApiModel(value = "SysStoreStaffInfoEntity", description = "门店人员信息表")
@GroupSequence({SysStoreStaffInfoEntity.class, SysStoreStaffInfoEntity.SysStoreStaffInfoEntityValidGroup.class,SysStoreStaffInfoEntity.StoreStaffIdValidGroup.class,SysStoreStaffInfoEntity.PartyIdValidGroup.class,SysStoreStaffInfoEntity.UserIdValidGroup.class,SysStoreStaffInfoEntity.StoreIdValidGroup.class,SysStoreStaffInfoEntity.IdmAccountNameValidGroup.class,SysStoreStaffInfoEntity.UserNameValidGroup.class,SysStoreStaffInfoEntity.PhoneNumberValidGroup.class,SysStoreStaffInfoEntity.RoleCodeValidGroup.class,SysStoreStaffInfoEntity.RoleNameValidGroup.class,SysStoreStaffInfoEntity.CreatedByValidGroup.class,SysStoreStaffInfoEntity.CreatedDateValidGroup.class,SysStoreStaffInfoEntity.UpdatedByValidGroup.class,SysStoreStaffInfoEntity.UpdatedDateValidGroup.class}) 
public class SysStoreStaffInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键 不能是Null", groups = {SysStoreStaffInfoEntityValidGroup.class, StoreStaffIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键 数字精度必须符合(19,0)", groups = {SysStoreStaffInfoEntityValidGroup.class, StoreStaffIdValidGroup.class})
    @ApiModelProperty(value = "主键")
    private Long storeStaffId;
    
    
    /**
     * 系统用户id
     */
    @NotNull(message = "系统用户id 不能是Null", groups = {SysStoreStaffInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="系统用户id 数字精度必须符合(19,0)", groups = {SysStoreStaffInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "系统用户id")
    private Long partyId;
    
    /**
     * 用户id
     */
    @Digits(integer=19, fraction=0, message="用户id 数字精度必须符合(19,0)", groups = {SysStoreStaffInfoEntityValidGroup.class, UserIdValidGroup.class})
    @ApiModelProperty(value = "用户id")
    private Long userId;
    
    /**
     * 门店id
     */
    @Digits(integer=19, fraction=0, message="门店id 数字精度必须符合(19,0)", groups = {SysStoreStaffInfoEntityValidGroup.class, StoreIdValidGroup.class})
    @ApiModelProperty(value = "门店id")
    private Long storeId;
    
    /**
     * 当前登录用户名
     */
    @Size(min=0, max=20, message="当前登录用户名 字符长度必须小于等于20", groups = {SysStoreStaffInfoEntityValidGroup.class, IdmAccountNameValidGroup.class})
    @ApiModelProperty(value = "当前登录用户名")
    private String idmAccountName;
    
    /**
     * 用户姓名
     */
    @Size(min=0, max=50, message="用户姓名 字符长度必须小于等于50", groups = {SysStoreStaffInfoEntityValidGroup.class, UserNameValidGroup.class})
    @ApiModelProperty(value = "用户姓名")
    private String userName;
    
    /**
     * 用户手机
     */
    @Size(min=0, max=20, message="用户手机 字符长度必须小于等于20", groups = {SysStoreStaffInfoEntityValidGroup.class, PhoneNumberValidGroup.class})
    @ApiModelProperty(value = "用户手机")
    private String phoneNumber;
    
    /**
     * 用户角色编码
     */
    @Size(min=0, max=20, message="用户角色编码 字符长度必须小于等于20", groups = {SysStoreStaffInfoEntityValidGroup.class, RoleCodeValidGroup.class})
    @ApiModelProperty(value = "用户角色编码")
    private String roleCode;
    
    /**
     * 用户角色名称
     */
    @Size(min=0, max=50, message="用户角色名称 字符长度必须小于等于50", groups = {SysStoreStaffInfoEntityValidGroup.class, RoleNameValidGroup.class})
    @ApiModelProperty(value = "用户角色名称")
    private String roleName;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysStoreStaffInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysStoreStaffInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysStoreStaffInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysStoreStaffInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysStoreStaffInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysStoreStaffInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysStoreStaffInfoEntity() {
    }
    
    public SysStoreStaffInfoEntity(Long storeStaffId) {
        this.storeStaffId = storeStaffId;
    }

    public void setStoreStaffId(Long storeStaffId) {
        this.storeStaffId = storeStaffId;
    }
    public Long getStoreStaffId() {
        return this.storeStaffId;
    }
    

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getUserId() {
        return this.userId;
    }
    
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    
    public void setIdmAccountName(String idmAccountName) {
        this.idmAccountName = idmAccountName;
    }
    public String getIdmAccountName() {
        return this.idmAccountName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    public String getRoleCode() {
        return this.roleCode;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleName() {
        return this.roleName;
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
              (storeStaffId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                storeStaffId = RandomIDGennerator.get().generate();
    }

    public interface SysStoreStaffInfoEntityValidGroup {}
    public interface StoreStaffIdValidGroup {}
    public interface PartyIdValidGroup {}
    public interface UserIdValidGroup {}
    public interface StoreIdValidGroup {}
    public interface IdmAccountNameValidGroup {}
    public interface UserNameValidGroup {}
    public interface PhoneNumberValidGroup {}
    public interface RoleCodeValidGroup {}
    public interface RoleNameValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            StoreStaffIdValidGroup.class
            , PartyIdValidGroup.class
            , UserIdValidGroup.class
            , StoreIdValidGroup.class
            , IdmAccountNameValidGroup.class
            , UserNameValidGroup.class
            , PhoneNumberValidGroup.class
            , RoleCodeValidGroup.class
            , RoleNameValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
