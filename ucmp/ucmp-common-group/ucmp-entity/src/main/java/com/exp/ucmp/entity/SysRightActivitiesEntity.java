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

@ApiModel(value = "SysRightActivitiesEntity", description = "权益活动表")
@GroupSequence({SysRightActivitiesEntity.class, SysRightActivitiesEntity.SysRightActivitiesEntityValidGroup.class,SysRightActivitiesEntity.RightIdValidGroup.class,SysRightActivitiesEntity.RightPackIdValidGroup.class,SysRightActivitiesEntity.CampaignNameValidGroup.class,SysRightActivitiesEntity.CampaignTypeValidGroup.class,SysRightActivitiesEntity.CampaignDescribeValidGroup.class,SysRightActivitiesEntity.CampaignCodeValidGroup.class,SysRightActivitiesEntity.ModelCodeValidGroup.class,SysRightActivitiesEntity.ModelNameValidGroup.class,SysRightActivitiesEntity.ShapeCodeValidGroup.class,SysRightActivitiesEntity.ShapeNameValidGroup.class,SysRightActivitiesEntity.ConditionsValidGroup.class,SysRightActivitiesEntity.StartDateValidGroup.class,SysRightActivitiesEntity.EndDateValidGroup.class,SysRightActivitiesEntity.IsEnableValidGroup.class,SysRightActivitiesEntity.IsDeleteValidGroup.class,SysRightActivitiesEntity.CreatedByValidGroup.class,SysRightActivitiesEntity.CreatedPersonNameValidGroup.class,SysRightActivitiesEntity.CreatedDateValidGroup.class,SysRightActivitiesEntity.UpdatedByValidGroup.class,SysRightActivitiesEntity.UpdatedDateValidGroup.class}) 
public class SysRightActivitiesEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 权益活动主键ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "权益活动主键ID 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, RightIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="权益活动主键ID 数字精度必须符合(19,0)", groups = {SysRightActivitiesEntityValidGroup.class, RightIdValidGroup.class})
    @ApiModelProperty(value = "权益活动主键ID")
    private Long rightId;
    
    
    /**
     * 权益包编号
     */
    @NotNull(message = "权益包编号 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, RightPackIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="权益包编号 数字精度必须符合(19,0)", groups = {SysRightActivitiesEntityValidGroup.class, RightPackIdValidGroup.class})
    @ApiModelProperty(value = "权益包编号")
    private Long rightPackId;
    
    /**
     * 权益活动名称
     */
    @NotNull(message = "权益活动名称 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, CampaignNameValidGroup.class})
    @Size(min=0, max=50, message="权益活动名称 字符长度必须小于等于50", groups = {SysRightActivitiesEntityValidGroup.class, CampaignNameValidGroup.class})
    @ApiModelProperty(value = "权益活动名称")
    private String campaignName;
    
    /**
     * 类型
     */
    @NotNull(message = "类型 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, CampaignTypeValidGroup.class})
    @Size(min=0, max=10, message="类型 字符长度必须小于等于10", groups = {SysRightActivitiesEntityValidGroup.class, CampaignTypeValidGroup.class})
    @ApiModelProperty(value = "类型")
    private String campaignType;
    
    /**
     * 描述
     */
    @Size(min=0, max=200, message="描述 字符长度必须小于等于200", groups = {SysRightActivitiesEntityValidGroup.class, CampaignDescribeValidGroup.class})
    @ApiModelProperty(value = "描述")
    private String campaignDescribe;
    
    /**
     * 权益代码
     */
    @NotNull(message = "权益代码 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, CampaignCodeValidGroup.class})
    @Size(min=0, max=20, message="权益代码 字符长度必须小于等于20", groups = {SysRightActivitiesEntityValidGroup.class, CampaignCodeValidGroup.class})
    @ApiModelProperty(value = "权益代码")
    private String campaignCode;
    
    /**
     * 工程车型代码
     */
    @Size(min=0, max=200, message="工程车型代码 字符长度必须小于等于200", groups = {SysRightActivitiesEntityValidGroup.class, ModelCodeValidGroup.class})
    @ApiModelProperty(value = "工程车型代码")
    private String modelCode;
    
    /**
     * 工程车型名称
     */
    @Size(min=0, max=200, message="工程车型名称 字符长度必须小于等于200", groups = {SysRightActivitiesEntityValidGroup.class, ModelNameValidGroup.class})
    @ApiModelProperty(value = "工程车型名称")
    private String modelName;
    
    /**
     * 基本车型代码
     */
    @Size(min=0, max=200, message="基本车型代码 字符长度必须小于等于200", groups = {SysRightActivitiesEntityValidGroup.class, ShapeCodeValidGroup.class})
    @ApiModelProperty(value = "基本车型代码")
    private String shapeCode;
    
    /**
     * 基本车型名称
     */
    @Size(min=0, max=200, message="基本车型名称 字符长度必须小于等于200", groups = {SysRightActivitiesEntityValidGroup.class, ShapeNameValidGroup.class})
    @ApiModelProperty(value = "基本车型名称")
    private String shapeName;
    
    /**
     * 达成条件
     */
    @Size(min=0, max=50, message="达成条件 字符长度必须小于等于50", groups = {SysRightActivitiesEntityValidGroup.class, ConditionsValidGroup.class})
    @ApiModelProperty(value = "达成条件")
    private String conditions;
    
    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "开始时间 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, StartDateValidGroup.class})
    @ApiModelProperty(value = "开始时间")
    private Date startDate;
    
    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "结束时间 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, EndDateValidGroup.class})
    @ApiModelProperty(value = "结束时间")
    private Date endDate;
    
    /**
     * 是否可用：00、不可用，01、可用
     */
    @NotNull(message = "是否可用：00、不可用，01、可用 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, IsEnableValidGroup.class})
    @Size(min=0, max=2, message="是否可用：00、不可用，01、可用 字符长度必须小于等于2", groups = {SysRightActivitiesEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用：00、不可用，01、可用")
    private String isEnable;
    
    /**
     * 是否被删除：00、未删除，01、删除
     */
    @NotNull(message = "是否被删除：00、未删除，01、删除 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、未删除，01、删除 字符长度必须小于等于2", groups = {SysRightActivitiesEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、未删除，01、删除")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysRightActivitiesEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建人姓名
     */
    @NotNull(message = "创建人姓名 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, CreatedPersonNameValidGroup.class})
    @Size(min=0, max=10, message="创建人姓名 字符长度必须小于等于10", groups = {SysRightActivitiesEntityValidGroup.class, CreatedPersonNameValidGroup.class})
    @ApiModelProperty(value = "创建人姓名")
    private String createdPersonName;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysRightActivitiesEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysRightActivitiesEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysRightActivitiesEntity() {
    }
    
    public SysRightActivitiesEntity(Long rightId) {
        this.rightId = rightId;
    }

    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }
    public Long getRightId() {
        return this.rightId;
    }
    

    public void setRightPackId(Long rightPackId) {
        this.rightPackId = rightPackId;
    }
    public Long getRightPackId() {
        return this.rightPackId;
    }
    
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
    public String getCampaignName() {
        return this.campaignName;
    }
    
    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }
    public String getCampaignType() {
        return this.campaignType;
    }
    
    public void setCampaignDescribe(String campaignDescribe) {
        this.campaignDescribe = campaignDescribe;
    }
    public String getCampaignDescribe() {
        return this.campaignDescribe;
    }
    
    public void setCampaignCode(String campaignCode) {
        this.campaignCode = campaignCode;
    }
    public String getCampaignCode() {
        return this.campaignCode;
    }
    
    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }
    public String getModelCode() {
        return this.modelCode;
    }
    
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getModelName() {
        return this.modelName;
    }
    
    public void setShapeCode(String shapeCode) {
        this.shapeCode = shapeCode;
    }
    public String getShapeCode() {
        return this.shapeCode;
    }
    
    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
    public String getShapeName() {
        return this.shapeName;
    }
    
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
    public String getConditions() {
        return this.conditions;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getEndDate() {
        return this.endDate;
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
    
    public void setCreatedPersonName(String createdPersonName) {
        this.createdPersonName = createdPersonName;
    }
    public String getCreatedPersonName() {
        return this.createdPersonName;
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
              (rightId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                rightId = RandomIDGennerator.get().generate();
    }

    public interface SysRightActivitiesEntityValidGroup {}
    public interface RightIdValidGroup {}
    public interface RightPackIdValidGroup {}
    public interface CampaignNameValidGroup {}
    public interface CampaignTypeValidGroup {}
    public interface CampaignDescribeValidGroup {}
    public interface CampaignCodeValidGroup {}
    public interface ModelCodeValidGroup {}
    public interface ModelNameValidGroup {}
    public interface ShapeCodeValidGroup {}
    public interface ShapeNameValidGroup {}
    public interface ConditionsValidGroup {}
    public interface StartDateValidGroup {}
    public interface EndDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedPersonNameValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RightIdValidGroup.class
            , RightPackIdValidGroup.class
            , CampaignNameValidGroup.class
            , CampaignTypeValidGroup.class
            , CampaignDescribeValidGroup.class
            , CampaignCodeValidGroup.class
            , ModelCodeValidGroup.class
            , ModelNameValidGroup.class
            , ShapeCodeValidGroup.class
            , ShapeNameValidGroup.class
            , ConditionsValidGroup.class
            , StartDateValidGroup.class
            , EndDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
            , CreatedByValidGroup.class
            , CreatedPersonNameValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
