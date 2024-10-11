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

@ApiModel(value = "PsiCreateOrderAccountInfoEntity", description = "预约单创建人信息")
@GroupSequence({PsiCreateOrderAccountInfoEntity.class, PsiCreateOrderAccountInfoEntity.PsiCreateOrderAccountInfoEntityValidGroup.class,PsiCreateOrderAccountInfoEntity.InfoIdValidGroup.class,PsiCreateOrderAccountInfoEntity.IdmAccountNameValidGroup.class,PsiCreateOrderAccountInfoEntity.UserIdValidGroup.class,PsiCreateOrderAccountInfoEntity.UserNameValidGroup.class,PsiCreateOrderAccountInfoEntity.OrganizationIdValidGroup.class,PsiCreateOrderAccountInfoEntity.PhoneNumberValidGroup.class,PsiCreateOrderAccountInfoEntity.RoleCodeValidGroup.class,PsiCreateOrderAccountInfoEntity.RoleNameValidGroup.class,PsiCreateOrderAccountInfoEntity.DepartmentIdValidGroup.class,PsiCreateOrderAccountInfoEntity.SuperiorIdmAccountNameValidGroup.class,PsiCreateOrderAccountInfoEntity.SuperiorUserIdValidGroup.class,PsiCreateOrderAccountInfoEntity.SuperiorOrganizationIdValidGroup.class,PsiCreateOrderAccountInfoEntity.SuperiorNameValidGroup.class,PsiCreateOrderAccountInfoEntity.SuperiorPhoneNumberValidGroup.class,PsiCreateOrderAccountInfoEntity.SuperiorRoleCodeValidGroup.class,PsiCreateOrderAccountInfoEntity.SuperiorRoleNameValidGroup.class,PsiCreateOrderAccountInfoEntity.CreatedByValidGroup.class,PsiCreateOrderAccountInfoEntity.CreatedDateValidGroup.class,PsiCreateOrderAccountInfoEntity.UpdatedByValidGroup.class,PsiCreateOrderAccountInfoEntity.UpdatedDateValidGroup.class}) 
public class PsiCreateOrderAccountInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 创建预约单顾问信息标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "创建预约单顾问信息标识 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, InfoIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建预约单顾问信息标识 数字精度必须符合(19,0)", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, InfoIdValidGroup.class})
    @ApiModelProperty(value = "创建预约单顾问信息标识")
    private Long infoId;
    
    
    /**
     * 用户登录名
     */
    @NotNull(message = "用户登录名 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, IdmAccountNameValidGroup.class})
    @Size(min=0, max=20, message="用户登录名 字符长度必须小于等于20", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, IdmAccountNameValidGroup.class})
    @ApiModelProperty(value = "用户登录名")
    private String idmAccountName;
    
    /**
     * 用户id
     */
    @NotNull(message = "用户id 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, UserIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="用户id 数字精度必须符合(10,0)", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, UserIdValidGroup.class})
    @ApiModelProperty(value = "用户id")
    private Long userId;
    
    /**
     * 用户姓名
     */
    @NotNull(message = "用户姓名 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, UserNameValidGroup.class})
    @Size(min=0, max=50, message="用户姓名 字符长度必须小于等于50", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, UserNameValidGroup.class})
    @ApiModelProperty(value = "用户姓名")
    private String userName;
    
    /**
     * 组织id
     */
    @NotNull(message = "组织id 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, OrganizationIdValidGroup.class})
    @Digits(integer=10, fraction=0, message="组织id 数字精度必须符合(10,0)", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, OrganizationIdValidGroup.class})
    @ApiModelProperty(value = "组织id")
    private Integer organizationId;
    
    /**
     * 用户手机号
     */
    @NotNull(message = "用户手机号 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, PhoneNumberValidGroup.class})
    @Size(min=0, max=20, message="用户手机号 字符长度必须小于等于20", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, PhoneNumberValidGroup.class})
    @ApiModelProperty(value = "用户手机号")
    private String phoneNumber;
    
    /**
     * 角色code
     */
    @NotNull(message = "角色code 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, RoleCodeValidGroup.class})
    @Size(min=0, max=10, message="角色code 字符长度必须小于等于10", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, RoleCodeValidGroup.class})
    @ApiModelProperty(value = "角色code")
    private String roleCode;
    
    /**
     * 角色名称
     */
    @NotNull(message = "角色名称 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, RoleNameValidGroup.class})
    @Size(min=0, max=50, message="角色名称 字符长度必须小于等于50", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, RoleNameValidGroup.class})
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    
    /**
     * 用户所属门店smp-code
     */
    @NotNull(message = "用户所属门店smp-code 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, DepartmentIdValidGroup.class})
    @Size(min=0, max=20, message="用户所属门店smp-code 字符长度必须小于等于20", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, DepartmentIdValidGroup.class})
    @ApiModelProperty(value = "用户所属门店smp-code")
    private String departmentId;
    
    /**
     * 用户所属门店smp-code
     */
    @Size(min=0, max=20, message="用户所属门店smp-code 字符长度必须小于等于20", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, SuperiorIdmAccountNameValidGroup.class})
    @ApiModelProperty(value = "用户所属门店smp-code")
    private String superiorIdmAccountName;
    
    /**
     * 上级用户id
     */
    @Digits(integer=10, fraction=0, message="上级用户id 数字精度必须符合(10,0)", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, SuperiorUserIdValidGroup.class})
    @ApiModelProperty(value = "上级用户id")
    private Integer superiorUserId;
    
    /**
     * 上级组织id
     */
    @Digits(integer=10, fraction=0, message="上级组织id 数字精度必须符合(10,0)", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, SuperiorOrganizationIdValidGroup.class})
    @ApiModelProperty(value = "上级组织id")
    private Integer superiorOrganizationId;
    
    /**
     * 上级用户名
     */
    @Size(min=0, max=50, message="上级用户名 字符长度必须小于等于50", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, SuperiorNameValidGroup.class})
    @ApiModelProperty(value = "上级用户名")
    private String superiorName;
    
    /**
     * 上级用户手机号
     */
    @Size(min=0, max=20, message="上级用户手机号 字符长度必须小于等于20", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, SuperiorPhoneNumberValidGroup.class})
    @ApiModelProperty(value = "上级用户手机号")
    private String superiorPhoneNumber;
    
    /**
     * 上级用户角色code
     */
    @Size(min=0, max=10, message="上级用户角色code 字符长度必须小于等于10", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, SuperiorRoleCodeValidGroup.class})
    @ApiModelProperty(value = "上级用户角色code")
    private String superiorRoleCode;
    
    /**
     * 上级用户角色名称
     */
    @Size(min=0, max=50, message="上级用户角色名称 字符长度必须小于等于50", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, SuperiorRoleNameValidGroup.class})
    @ApiModelProperty(value = "上级用户角色名称")
    private String superiorRoleName;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCreateOrderAccountInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PsiCreateOrderAccountInfoEntity() {
    }
    
    public PsiCreateOrderAccountInfoEntity(Long infoId) {
        this.infoId = infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }
    public Long getInfoId() {
        return this.infoId;
    }
    

    public void setIdmAccountName(String idmAccountName) {
        this.idmAccountName = idmAccountName;
    }
    public String getIdmAccountName() {
        return this.idmAccountName;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }
    public Integer getOrganizationId() {
        return this.organizationId;
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
    
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentId() {
        return this.departmentId;
    }
    
    public void setSuperiorIdmAccountName(String superiorIdmAccountName) {
        this.superiorIdmAccountName = superiorIdmAccountName;
    }
    public String getSuperiorIdmAccountName() {
        return this.superiorIdmAccountName;
    }
    
    public void setSuperiorUserId(Integer superiorUserId) {
        this.superiorUserId = superiorUserId;
    }
    public Integer getSuperiorUserId() {
        return this.superiorUserId;
    }
    
    public void setSuperiorOrganizationId(Integer superiorOrganizationId) {
        this.superiorOrganizationId = superiorOrganizationId;
    }
    public Integer getSuperiorOrganizationId() {
        return this.superiorOrganizationId;
    }
    
    public void setSuperiorName(String superiorName) {
        this.superiorName = superiorName;
    }
    public String getSuperiorName() {
        return this.superiorName;
    }
    
    public void setSuperiorPhoneNumber(String superiorPhoneNumber) {
        this.superiorPhoneNumber = superiorPhoneNumber;
    }
    public String getSuperiorPhoneNumber() {
        return this.superiorPhoneNumber;
    }
    
    public void setSuperiorRoleCode(String superiorRoleCode) {
        this.superiorRoleCode = superiorRoleCode;
    }
    public String getSuperiorRoleCode() {
        return this.superiorRoleCode;
    }
    
    public void setSuperiorRoleName(String superiorRoleName) {
        this.superiorRoleName = superiorRoleName;
    }
    public String getSuperiorRoleName() {
        return this.superiorRoleName;
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
              (infoId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                infoId = RandomIDGennerator.get().generate();
    }

    public interface PsiCreateOrderAccountInfoEntityValidGroup {}
    public interface InfoIdValidGroup {}
    public interface IdmAccountNameValidGroup {}
    public interface UserIdValidGroup {}
    public interface UserNameValidGroup {}
    public interface OrganizationIdValidGroup {}
    public interface PhoneNumberValidGroup {}
    public interface RoleCodeValidGroup {}
    public interface RoleNameValidGroup {}
    public interface DepartmentIdValidGroup {}
    public interface SuperiorIdmAccountNameValidGroup {}
    public interface SuperiorUserIdValidGroup {}
    public interface SuperiorOrganizationIdValidGroup {}
    public interface SuperiorNameValidGroup {}
    public interface SuperiorPhoneNumberValidGroup {}
    public interface SuperiorRoleCodeValidGroup {}
    public interface SuperiorRoleNameValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            InfoIdValidGroup.class
            , IdmAccountNameValidGroup.class
            , UserIdValidGroup.class
            , UserNameValidGroup.class
            , OrganizationIdValidGroup.class
            , PhoneNumberValidGroup.class
            , RoleCodeValidGroup.class
            , RoleNameValidGroup.class
            , DepartmentIdValidGroup.class
            , SuperiorIdmAccountNameValidGroup.class
            , SuperiorUserIdValidGroup.class
            , SuperiorOrganizationIdValidGroup.class
            , SuperiorNameValidGroup.class
            , SuperiorPhoneNumberValidGroup.class
            , SuperiorRoleCodeValidGroup.class
            , SuperiorRoleNameValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
