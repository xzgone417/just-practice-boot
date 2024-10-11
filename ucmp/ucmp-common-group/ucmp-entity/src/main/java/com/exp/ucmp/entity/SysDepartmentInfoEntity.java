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

@ApiModel(value = "SysDepartmentInfoEntity", description = "部门信息表")
@GroupSequence({SysDepartmentInfoEntity.class, SysDepartmentInfoEntity.SysDepartmentInfoEntityValidGroup.class,SysDepartmentInfoEntity.DepartmentIdValidGroup.class,SysDepartmentInfoEntity.DepartmentCodeValidGroup.class,SysDepartmentInfoEntity.DepartmentNameValidGroup.class,SysDepartmentInfoEntity.DepartmentTypeValidGroup.class,SysDepartmentInfoEntity.IsDeleteValidGroup.class,SysDepartmentInfoEntity.CreatedByValidGroup.class,SysDepartmentInfoEntity.CreatedDateValidGroup.class,SysDepartmentInfoEntity.UpdatedByValidGroup.class,SysDepartmentInfoEntity.UpdatedDateValidGroup.class}) 
public class SysDepartmentInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 部门标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "部门标识 不能是Null", groups = {SysDepartmentInfoEntityValidGroup.class, DepartmentIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="部门标识 数字精度必须符合(19,0)", groups = {SysDepartmentInfoEntityValidGroup.class, DepartmentIdValidGroup.class})
    @ApiModelProperty(value = "部门标识")
    private Long departmentId;
    
    
    /**
     * 部门代码
     */
    @NotNull(message = "部门代码 不能是Null", groups = {SysDepartmentInfoEntityValidGroup.class, DepartmentCodeValidGroup.class})
    @Size(min=0, max=20, message="部门代码 字符长度必须小于等于20", groups = {SysDepartmentInfoEntityValidGroup.class, DepartmentCodeValidGroup.class})
    @ApiModelProperty(value = "部门代码")
    private String departmentCode;
    
    /**
     * 部门名称
     */
    @NotNull(message = "部门名称 不能是Null", groups = {SysDepartmentInfoEntityValidGroup.class, DepartmentNameValidGroup.class})
    @Size(min=0, max=50, message="部门名称 字符长度必须小于等于50", groups = {SysDepartmentInfoEntityValidGroup.class, DepartmentNameValidGroup.class})
    @ApiModelProperty(value = "部门名称")
    private String departmentName;
    
    /**
     * 部门类型(0010总部,0020门店.....)
     */
    @NotNull(message = "部门类型(0010总部,0020门店.....) 不能是Null", groups = {SysDepartmentInfoEntityValidGroup.class, DepartmentTypeValidGroup.class})
    @Size(min=0, max=4, message="部门类型(0010总部,0020门店.....) 字符长度必须小于等于4", groups = {SysDepartmentInfoEntityValidGroup.class, DepartmentTypeValidGroup.class})
    @ApiModelProperty(value = "部门类型(0010总部,0020门店.....)")
    private String departmentType;
    
    /**
     * 是否被删除：00、删除，01、未删除
     */
    @NotNull(message = "是否被删除：00、删除，01、未删除 不能是Null", groups = {SysDepartmentInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、删除，01、未删除 字符长度必须小于等于2", groups = {SysDepartmentInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysDepartmentInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysDepartmentInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysDepartmentInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysDepartmentInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysDepartmentInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysDepartmentInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysDepartmentInfoEntity() {
    }
    
    public SysDepartmentInfoEntity(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    public Long getDepartmentId() {
        return this.departmentId;
    }
    

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    public String getDepartmentCode() {
        return this.departmentCode;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }
    public String getDepartmentType() {
        return this.departmentType;
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
              (departmentId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                departmentId = RandomIDGennerator.get().generate();
    }

    public interface SysDepartmentInfoEntityValidGroup {}
    public interface DepartmentIdValidGroup {}
    public interface DepartmentCodeValidGroup {}
    public interface DepartmentNameValidGroup {}
    public interface DepartmentTypeValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            DepartmentIdValidGroup.class
            , DepartmentCodeValidGroup.class
            , DepartmentNameValidGroup.class
            , DepartmentTypeValidGroup.class
            , IsDeleteValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
