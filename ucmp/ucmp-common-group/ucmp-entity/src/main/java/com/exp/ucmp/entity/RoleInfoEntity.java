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

@ApiModel(value = "RoleInfoEntity", description = "角色信息")
@GroupSequence({RoleInfoEntity.class, RoleInfoEntity.RoleInfoEntityValidGroup.class,RoleInfoEntity.RoleIdValidGroup.class,RoleInfoEntity.RoleTypeValidGroup.class,RoleInfoEntity.RoleNameValidGroup.class,RoleInfoEntity.RoleDescValidGroup.class,RoleInfoEntity.IsValidValidGroup.class,RoleInfoEntity.IsDeleteValidGroup.class,RoleInfoEntity.CreatedByValidGroup.class,RoleInfoEntity.CreatedDateValidGroup.class,RoleInfoEntity.UpdatedByValidGroup.class,RoleInfoEntity.UpdatedDateValidGroup.class}) 
public class RoleInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 角色标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "角色标识 不能是Null", groups = {RoleInfoEntityValidGroup.class, RoleIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="角色标识 数字精度必须符合(19,0)", groups = {RoleInfoEntityValidGroup.class, RoleIdValidGroup.class})
    @ApiModelProperty(value = "角色标识")
    private Long roleId;
    
    
    /**
     * 角色类型：0100、人员角色；0200、组织角色
     */
    @NotNull(message = "角色类型：0100、人员角色；0200、组织角色 不能是Null", groups = {RoleInfoEntityValidGroup.class, RoleTypeValidGroup.class})
    @Size(min=0, max=4, message="角色类型：0100、人员角色；0200、组织角色 字符长度必须小于等于4", groups = {RoleInfoEntityValidGroup.class, RoleTypeValidGroup.class})
    @ApiModelProperty(value = "角色类型：0100、人员角色；0200、组织角色")
    private String roleType;
    
    /**
     * 角色名称
     */
    @NotNull(message = "角色名称 不能是Null", groups = {RoleInfoEntityValidGroup.class, RoleNameValidGroup.class})
    @Size(min=0, max=30, message="角色名称 字符长度必须小于等于30", groups = {RoleInfoEntityValidGroup.class, RoleNameValidGroup.class})
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    
    /**
     * 角色描述
     */
    @Size(min=0, max=500, message="角色描述 字符长度必须小于等于500", groups = {RoleInfoEntityValidGroup.class, RoleDescValidGroup.class})
    @ApiModelProperty(value = "角色描述")
    private String roleDesc;
    
    /**
     * 是否有效：01、有效，09、无效
     */
    @NotNull(message = "是否有效：01、有效，09、无效 不能是Null", groups = {RoleInfoEntityValidGroup.class, IsValidValidGroup.class})
    @Size(min=0, max=2, message="是否有效：01、有效，09、无效 字符长度必须小于等于2", groups = {RoleInfoEntityValidGroup.class, IsValidValidGroup.class})
    @ApiModelProperty(value = "是否有效：01、有效，09、无效")
    private String isValid;
    
    /**
     * 是否被删除：00、删除，01、未删除
     */
    @NotNull(message = "是否被删除：00、删除，01、未删除 不能是Null", groups = {RoleInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、删除，01、未删除 字符长度必须小于等于2", groups = {RoleInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {RoleInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {RoleInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {RoleInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {RoleInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {RoleInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {RoleInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public RoleInfoEntity() {
    }
    
    public RoleInfoEntity(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getRoleId() {
        return this.roleId;
    }
    

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
    public String getRoleType() {
        return this.roleType;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
    public String getRoleDesc() {
        return this.roleDesc;
    }
    
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }
    public String getIsValid() {
        return this.isValid;
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
              (roleId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                roleId = RandomIDGennerator.get().generate();
    }

    public interface RoleInfoEntityValidGroup {}
    public interface RoleIdValidGroup {}
    public interface RoleTypeValidGroup {}
    public interface RoleNameValidGroup {}
    public interface RoleDescValidGroup {}
    public interface IsValidValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RoleInfoEntity.RoleIdValidGroup.class
            , RoleInfoEntity.RoleTypeValidGroup.class
            , RoleInfoEntity.RoleNameValidGroup.class
            , RoleInfoEntity.RoleDescValidGroup.class
            , RoleInfoEntity.IsValidValidGroup.class
            , RoleInfoEntity.IsDeleteValidGroup.class
            , RoleInfoEntity.CreatedByValidGroup.class
            , RoleInfoEntity.CreatedDateValidGroup.class
            , RoleInfoEntity.UpdatedByValidGroup.class
            , RoleInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
