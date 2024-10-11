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

@ApiModel(value = "SysDeptInfoEntity", description = "部门信息")
@GroupSequence({SysDeptInfoEntity.class, SysDeptInfoEntity.SysDeptInfoEntityValidGroup.class,SysDeptInfoEntity.DeptInfoIdValidGroup.class,SysDeptInfoEntity.HhrDeptCodeValidGroup.class,SysDeptInfoEntity.HhrStatusValidGroup.class,SysDeptInfoEntity.HhrDeptZhNameValidGroup.class,SysDeptInfoEntity.HhrDeptZhShortNameValidGroup.class,SysDeptInfoEntity.HhrDeptEnNameValidGroup.class,SysDeptInfoEntity.HhrDeptEnShortNameValidGroup.class,SysDeptInfoEntity.HhrDeptLevelValidGroup.class,SysDeptInfoEntity.HhrDeptHigherDeptValidGroup.class,SysDeptInfoEntity.HhrOrgDeptAttr02ValidGroup.class,SysDeptInfoEntity.HhrPartDeptValidGroup.class,SysDeptInfoEntity.HhrOrgDeptAttr09ValidGroup.class,SysDeptInfoEntity.HhrOrgDeptAttr06ValidGroup.class,SysDeptInfoEntity.HhrOrgDeptAttr05ValidGroup.class,SysDeptInfoEntity.HhrOrgDeptAttr08ValidGroup.class,SysDeptInfoEntity.HhrOrgDeptAttr07ValidGroup.class,SysDeptInfoEntity.HhrOrgDeptAttr10ValidGroup.class,SysDeptInfoEntity.HhrDeptDetailDescValidGroup.class,SysDeptInfoEntity.VersionValidGroup.class,SysDeptInfoEntity.IsEnableValidGroup.class,SysDeptInfoEntity.IsDeleteValidGroup.class,SysDeptInfoEntity.CreatedByValidGroup.class,SysDeptInfoEntity.CreatedDateValidGroup.class,SysDeptInfoEntity.UpdatedByValidGroup.class,SysDeptInfoEntity.UpdatedDateValidGroup.class}) 
public class SysDeptInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键标识 不能是Null", groups = {SysDeptInfoEntityValidGroup.class, DeptInfoIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键标识 数字精度必须符合(19,0)", groups = {SysDeptInfoEntityValidGroup.class, DeptInfoIdValidGroup.class})
    @ApiModelProperty(value = "主键标识")
    private Long deptInfoId;
    
    
    /**
     * 部门编码
     */
    @Size(min=0, max=50, message="部门编码 字符长度必须小于等于50", groups = {SysDeptInfoEntityValidGroup.class, HhrDeptCodeValidGroup.class})
    @ApiModelProperty(value = "部门编码")
    private String hhrDeptCode;
    
    /**
     * 状态
     */
    @Size(min=0, max=10, message="状态 字符长度必须小于等于10", groups = {SysDeptInfoEntityValidGroup.class, HhrStatusValidGroup.class})
    @ApiModelProperty(value = "状态")
    private String hhrStatus;
    
    /**
     * 部门名称（中文）
     */
    @Size(min=0, max=100, message="部门名称（中文） 字符长度必须小于等于100", groups = {SysDeptInfoEntityValidGroup.class, HhrDeptZhNameValidGroup.class})
    @ApiModelProperty(value = "部门名称（中文）")
    private String hhrDeptZhName;
    
    /**
     * 部门缩写（中文）
     */
    @Size(min=0, max=100, message="部门缩写（中文） 字符长度必须小于等于100", groups = {SysDeptInfoEntityValidGroup.class, HhrDeptZhShortNameValidGroup.class})
    @ApiModelProperty(value = "部门缩写（中文）")
    private String hhrDeptZhShortName;
    
    /**
     * 部门名称（英文）
     */
    @Size(min=0, max=100, message="部门名称（英文） 字符长度必须小于等于100", groups = {SysDeptInfoEntityValidGroup.class, HhrDeptEnNameValidGroup.class})
    @ApiModelProperty(value = "部门名称（英文）")
    private String hhrDeptEnName;
    
    /**
     * 部门缩写（英文）
     */
    @Size(min=0, max=100, message="部门缩写（英文） 字符长度必须小于等于100", groups = {SysDeptInfoEntityValidGroup.class, HhrDeptEnShortNameValidGroup.class})
    @ApiModelProperty(value = "部门缩写（英文）")
    private String hhrDeptEnShortName;
    
    /**
     * 部门层级
     */
    @Size(min=0, max=40, message="部门层级 字符长度必须小于等于40", groups = {SysDeptInfoEntityValidGroup.class, HhrDeptLevelValidGroup.class})
    @ApiModelProperty(value = "部门层级")
    private String hhrDeptLevel;
    
    /**
     * 上级部门编码
     */
    @Size(min=0, max=40, message="上级部门编码 字符长度必须小于等于40", groups = {SysDeptInfoEntityValidGroup.class, HhrDeptHigherDeptValidGroup.class})
    @ApiModelProperty(value = "上级部门编码")
    private String hhrDeptHigherDept;
    
    /**
     * 成本中心编码
     */
    @Size(min=0, max=30, message="成本中心编码 字符长度必须小于等于30", groups = {SysDeptInfoEntityValidGroup.class, HhrOrgDeptAttr02ValidGroup.class})
    @ApiModelProperty(value = "成本中心编码")
    private String hhrOrgDeptAttr02;
    
    /**
     * 所属分部编码
     */
    @Size(min=0, max=20, message="所属分部编码 字符长度必须小于等于20", groups = {SysDeptInfoEntityValidGroup.class, HhrPartDeptValidGroup.class})
    @ApiModelProperty(value = "所属分部编码")
    private String hhrPartDept;
    
    /**
     * HR BP
     */
    @Size(min=0, max=30, message="HR BP 字符长度必须小于等于30", groups = {SysDeptInfoEntityValidGroup.class, HhrOrgDeptAttr09ValidGroup.class})
    @ApiModelProperty(value = "HR BP")
    private String hhrOrgDeptAttr09;
    
    /**
     * 高级经理
     */
    @Size(min=0, max=30, message="高级经理 字符长度必须小于等于30", groups = {SysDeptInfoEntityValidGroup.class, HhrOrgDeptAttr06ValidGroup.class})
    @ApiModelProperty(value = "高级经理")
    private String hhrOrgDeptAttr06;
    
    /**
     * 部门总监
     */
    @Size(min=0, max=30, message="部门总监 字符长度必须小于等于30", groups = {SysDeptInfoEntityValidGroup.class, HhrOrgDeptAttr05ValidGroup.class})
    @ApiModelProperty(value = "部门总监")
    private String hhrOrgDeptAttr05;
    
    /**
     * 分管副总
     */
    @Size(min=0, max=30, message="分管副总 字符长度必须小于等于30", groups = {SysDeptInfoEntityValidGroup.class, HhrOrgDeptAttr08ValidGroup.class})
    @ApiModelProperty(value = "分管副总")
    private String hhrOrgDeptAttr08;
    
    /**
     * 分管总裁
     */
    @Size(min=0, max=30, message="分管总裁 字符长度必须小于等于30", groups = {SysDeptInfoEntityValidGroup.class, HhrOrgDeptAttr07ValidGroup.class})
    @ApiModelProperty(value = "分管总裁")
    private String hhrOrgDeptAttr07;
    
    /**
     * 
     */
    @Size(min=0, max=30, message=" 字符长度必须小于等于30", groups = {SysDeptInfoEntityValidGroup.class, HhrOrgDeptAttr10ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgDeptAttr10;
    
    /**
     * 部门详细信息
     */
    @Size(min=0, max=200, message="部门详细信息 字符长度必须小于等于200", groups = {SysDeptInfoEntityValidGroup.class, HhrDeptDetailDescValidGroup.class})
    @ApiModelProperty(value = "部门详细信息")
    private String hhrDeptDetailDesc;
    
    /**
     * 更新日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private Date lastUpdateDate;
    
    /**
     * 版本号
     */
    @Digits(integer=10, fraction=0, message="版本号 数字精度必须符合(10,0)", groups = {SysDeptInfoEntityValidGroup.class, VersionValidGroup.class})
    @ApiModelProperty(value = "版本号")
    private Integer version;
    
    /**
     * 是否可用00、禁用，01、启用
     */
    @Size(min=0, max=2, message="是否可用00、禁用，01、启用 字符长度必须小于等于2", groups = {SysDeptInfoEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、禁用，01、启用")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {SysDeptInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {SysDeptInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysDeptInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysDeptInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysDeptInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysDeptInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysDeptInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysDeptInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysDeptInfoEntity() {
    }
    
    public SysDeptInfoEntity(Long deptInfoId) {
        this.deptInfoId = deptInfoId;
    }

    public void setDeptInfoId(Long deptInfoId) {
        this.deptInfoId = deptInfoId;
    }
    public Long getDeptInfoId() {
        return this.deptInfoId;
    }
    

    public void setHhrDeptCode(String hhrDeptCode) {
        this.hhrDeptCode = hhrDeptCode;
    }
    public String getHhrDeptCode() {
        return this.hhrDeptCode;
    }
    
    public void setHhrStatus(String hhrStatus) {
        this.hhrStatus = hhrStatus;
    }
    public String getHhrStatus() {
        return this.hhrStatus;
    }
    
    public void setHhrDeptZhName(String hhrDeptZhName) {
        this.hhrDeptZhName = hhrDeptZhName;
    }
    public String getHhrDeptZhName() {
        return this.hhrDeptZhName;
    }
    
    public void setHhrDeptZhShortName(String hhrDeptZhShortName) {
        this.hhrDeptZhShortName = hhrDeptZhShortName;
    }
    public String getHhrDeptZhShortName() {
        return this.hhrDeptZhShortName;
    }
    
    public void setHhrDeptEnName(String hhrDeptEnName) {
        this.hhrDeptEnName = hhrDeptEnName;
    }
    public String getHhrDeptEnName() {
        return this.hhrDeptEnName;
    }
    
    public void setHhrDeptEnShortName(String hhrDeptEnShortName) {
        this.hhrDeptEnShortName = hhrDeptEnShortName;
    }
    public String getHhrDeptEnShortName() {
        return this.hhrDeptEnShortName;
    }
    
    public void setHhrDeptLevel(String hhrDeptLevel) {
        this.hhrDeptLevel = hhrDeptLevel;
    }
    public String getHhrDeptLevel() {
        return this.hhrDeptLevel;
    }
    
    public void setHhrDeptHigherDept(String hhrDeptHigherDept) {
        this.hhrDeptHigherDept = hhrDeptHigherDept;
    }
    public String getHhrDeptHigherDept() {
        return this.hhrDeptHigherDept;
    }
    
    public void setHhrOrgDeptAttr02(String hhrOrgDeptAttr02) {
        this.hhrOrgDeptAttr02 = hhrOrgDeptAttr02;
    }
    public String getHhrOrgDeptAttr02() {
        return this.hhrOrgDeptAttr02;
    }
    
    public void setHhrPartDept(String hhrPartDept) {
        this.hhrPartDept = hhrPartDept;
    }
    public String getHhrPartDept() {
        return this.hhrPartDept;
    }
    
    public void setHhrOrgDeptAttr09(String hhrOrgDeptAttr09) {
        this.hhrOrgDeptAttr09 = hhrOrgDeptAttr09;
    }
    public String getHhrOrgDeptAttr09() {
        return this.hhrOrgDeptAttr09;
    }
    
    public void setHhrOrgDeptAttr06(String hhrOrgDeptAttr06) {
        this.hhrOrgDeptAttr06 = hhrOrgDeptAttr06;
    }
    public String getHhrOrgDeptAttr06() {
        return this.hhrOrgDeptAttr06;
    }
    
    public void setHhrOrgDeptAttr05(String hhrOrgDeptAttr05) {
        this.hhrOrgDeptAttr05 = hhrOrgDeptAttr05;
    }
    public String getHhrOrgDeptAttr05() {
        return this.hhrOrgDeptAttr05;
    }
    
    public void setHhrOrgDeptAttr08(String hhrOrgDeptAttr08) {
        this.hhrOrgDeptAttr08 = hhrOrgDeptAttr08;
    }
    public String getHhrOrgDeptAttr08() {
        return this.hhrOrgDeptAttr08;
    }
    
    public void setHhrOrgDeptAttr07(String hhrOrgDeptAttr07) {
        this.hhrOrgDeptAttr07 = hhrOrgDeptAttr07;
    }
    public String getHhrOrgDeptAttr07() {
        return this.hhrOrgDeptAttr07;
    }
    
    public void setHhrOrgDeptAttr10(String hhrOrgDeptAttr10) {
        this.hhrOrgDeptAttr10 = hhrOrgDeptAttr10;
    }
    public String getHhrOrgDeptAttr10() {
        return this.hhrOrgDeptAttr10;
    }
    
    public void setHhrDeptDetailDesc(String hhrDeptDetailDesc) {
        this.hhrDeptDetailDesc = hhrDeptDetailDesc;
    }
    public String getHhrDeptDetailDesc() {
        return this.hhrDeptDetailDesc;
    }
    
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    public Integer getVersion() {
        return this.version;
    }
    
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public String getIsEnable() {
        return this.isEnable;
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
              (deptInfoId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                deptInfoId = RandomIDGennerator.get().generate();
    }

    public interface SysDeptInfoEntityValidGroup {}
    public interface DeptInfoIdValidGroup {}
    public interface HhrDeptCodeValidGroup {}
    public interface HhrStatusValidGroup {}
    public interface HhrDeptZhNameValidGroup {}
    public interface HhrDeptZhShortNameValidGroup {}
    public interface HhrDeptEnNameValidGroup {}
    public interface HhrDeptEnShortNameValidGroup {}
    public interface HhrDeptLevelValidGroup {}
    public interface HhrDeptHigherDeptValidGroup {}
    public interface HhrOrgDeptAttr02ValidGroup {}
    public interface HhrPartDeptValidGroup {}
    public interface HhrOrgDeptAttr09ValidGroup {}
    public interface HhrOrgDeptAttr06ValidGroup {}
    public interface HhrOrgDeptAttr05ValidGroup {}
    public interface HhrOrgDeptAttr08ValidGroup {}
    public interface HhrOrgDeptAttr07ValidGroup {}
    public interface HhrOrgDeptAttr10ValidGroup {}
    public interface HhrDeptDetailDescValidGroup {}
    public interface VersionValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            DeptInfoIdValidGroup.class
            , HhrDeptCodeValidGroup.class
            , HhrStatusValidGroup.class
            , HhrDeptZhNameValidGroup.class
            , HhrDeptZhShortNameValidGroup.class
            , HhrDeptEnNameValidGroup.class
            , HhrDeptEnShortNameValidGroup.class
            , HhrDeptLevelValidGroup.class
            , HhrDeptHigherDeptValidGroup.class
            , HhrOrgDeptAttr02ValidGroup.class
            , HhrPartDeptValidGroup.class
            , HhrOrgDeptAttr09ValidGroup.class
            , HhrOrgDeptAttr06ValidGroup.class
            , HhrOrgDeptAttr05ValidGroup.class
            , HhrOrgDeptAttr08ValidGroup.class
            , HhrOrgDeptAttr07ValidGroup.class
            , HhrOrgDeptAttr10ValidGroup.class
            , HhrDeptDetailDescValidGroup.class
            , VersionValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
