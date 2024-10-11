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

@ApiModel(value = "SysRoleDetailsEntity", description = "角色信息详情表")
@GroupSequence({SysRoleDetailsEntity.class, SysRoleDetailsEntity.SysRoleDetailsEntityValidGroup.class,SysRoleDetailsEntity.RoleIdValidGroup.class,SysRoleDetailsEntity.RoleCodeValidGroup.class,SysRoleDetailsEntity.RoleDetailsTypeValidGroup.class,SysRoleDetailsEntity.RoleDetailsNameValidGroup.class,SysRoleDetailsEntity.CreatedByValidGroup.class,SysRoleDetailsEntity.CreatedDateValidGroup.class,SysRoleDetailsEntity.UpdatedByValidGroup.class,SysRoleDetailsEntity.UpdatedDateValidGroup.class}) 
public class SysRoleDetailsEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 角色标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "角色标识 不能是Null", groups = {SysRoleDetailsEntityValidGroup.class, RoleIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="角色标识 数字精度必须符合(19,0)", groups = {SysRoleDetailsEntityValidGroup.class, RoleIdValidGroup.class})
    @ApiModelProperty(value = "角色标识")
    private Long roleId;
    
    
    /**
     * 角色编码
     */
    @NotNull(message = "角色编码 不能是Null", groups = {SysRoleDetailsEntityValidGroup.class, RoleCodeValidGroup.class})
    @Size(min=0, max=20, message="角色编码 字符长度必须小于等于20", groups = {SysRoleDetailsEntityValidGroup.class, RoleCodeValidGroup.class})
    @ApiModelProperty(value = "角色编码")
    private String roleCode;
    
    /**
     * 角色类型（门店0020、总部0010.......）
     */
    @NotNull(message = "角色类型（门店0020、总部0010.......） 不能是Null", groups = {SysRoleDetailsEntityValidGroup.class, RoleDetailsTypeValidGroup.class})
    @Size(min=0, max=4, message="角色类型（门店0020、总部0010.......） 字符长度必须小于等于4", groups = {SysRoleDetailsEntityValidGroup.class, RoleDetailsTypeValidGroup.class})
    @ApiModelProperty(value = "角色类型（门店0020、总部0010.......）")
    private String roleDetailsType;
    
    /**
     * 角色名称
     */
    @NotNull(message = "角色名称 不能是Null", groups = {SysRoleDetailsEntityValidGroup.class, RoleDetailsNameValidGroup.class})
    @Size(min=0, max=30, message="角色名称 字符长度必须小于等于30", groups = {SysRoleDetailsEntityValidGroup.class, RoleDetailsNameValidGroup.class})
    @ApiModelProperty(value = "角色名称")
    private String roleDetailsName;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysRoleDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysRoleDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysRoleDetailsEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysRoleDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysRoleDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysRoleDetailsEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysRoleDetailsEntity() {
    }
    
    public SysRoleDetailsEntity(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getRoleId() {
        return this.roleId;
    }
    

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    public String getRoleCode() {
        return this.roleCode;
    }
    
    public void setRoleDetailsType(String roleDetailsType) {
        this.roleDetailsType = roleDetailsType;
    }
    public String getRoleDetailsType() {
        return this.roleDetailsType;
    }
    
    public void setRoleDetailsName(String roleDetailsName) {
        this.roleDetailsName = roleDetailsName;
    }
    public String getRoleDetailsName() {
        return this.roleDetailsName;
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

    public interface SysRoleDetailsEntityValidGroup {}
    public interface RoleIdValidGroup {}
    public interface RoleCodeValidGroup {}
    public interface RoleDetailsTypeValidGroup {}
    public interface RoleDetailsNameValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RoleIdValidGroup.class
            , RoleCodeValidGroup.class
            , RoleDetailsTypeValidGroup.class
            , RoleDetailsNameValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
