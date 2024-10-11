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

@ApiModel(value = "SysParamConfigEntity", description = "参数配置表")
@GroupSequence({SysParamConfigEntity.class, SysParamConfigEntity.SysParamConfigEntityValidGroup.class,SysParamConfigEntity.ParamIdValidGroup.class,SysParamConfigEntity.ParamTypeValidGroup.class,SysParamConfigEntity.ParamProfileValidGroup.class,SysParamConfigEntity.ParamDetailsValidGroup.class,SysParamConfigEntity.ParamValuesValidGroup.class,SysParamConfigEntity.ParamUnitValidGroup.class,SysParamConfigEntity.ParamUnitDetailsValidGroup.class,SysParamConfigEntity.CreatedByValidGroup.class,SysParamConfigEntity.CreatedDateValidGroup.class,SysParamConfigEntity.UpdatedByValidGroup.class,SysParamConfigEntity.UpdatedDateValidGroup.class,SysParamConfigEntity.IsEnableValidGroup.class,SysParamConfigEntity.IsDeleteValidGroup.class}) 
public class SysParamConfigEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键id 不能是Null", groups = {SysParamConfigEntityValidGroup.class, ParamIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键id 数字精度必须符合(19,0)", groups = {SysParamConfigEntityValidGroup.class, ParamIdValidGroup.class})
    @ApiModelProperty(value = "主键id")
    private Long paramId;
    
    
    /**
     * 参数类型(001:报价截止时间/002:自动关闭时间/003:首次材料未上报提醒时间/004:过户材料未上报提醒时间)
     */
    @Size(min=0, max=10, message="参数类型(001:报价截止时间/002:自动关闭时间/003:首次材料未上报提醒时间/004:过户材料未上报提醒时间) 字符长度必须小于等于10", groups = {SysParamConfigEntityValidGroup.class, ParamTypeValidGroup.class})
    @ApiModelProperty(value = "参数类型(001:报价截止时间/002:自动关闭时间/003:首次材料未上报提醒时间/004:过户材料未上报提醒时间)")
    private String paramType;
    
    /**
     * 参数描述
     */
    @Size(min=0, max=50, message="参数描述 字符长度必须小于等于50", groups = {SysParamConfigEntityValidGroup.class, ParamProfileValidGroup.class})
    @ApiModelProperty(value = "参数描述")
    private String paramProfile;
    
    /**
     * 参数详细描述
     */
    @NotNull(message = "参数详细描述 不能是Null", groups = {SysParamConfigEntityValidGroup.class, ParamDetailsValidGroup.class})
    @Size(min=0, max=50, message="参数详细描述 字符长度必须小于等于50", groups = {SysParamConfigEntityValidGroup.class, ParamDetailsValidGroup.class})
    @ApiModelProperty(value = "参数详细描述")
    private String paramDetails;
    
    /**
     * 参数值
     */
    @Size(min=0, max=10, message="参数值 字符长度必须小于等于10", groups = {SysParamConfigEntityValidGroup.class, ParamValuesValidGroup.class})
    @ApiModelProperty(value = "参数值")
    private String paramValues;
    
    /**
     * 参数单位(DAYS:天/HOUR:小时/MIN:分钟/SECOND:秒)
     */
    @Size(min=0, max=10, message="参数单位(DAYS:天/HOUR:小时/MIN:分钟/SECOND:秒) 字符长度必须小于等于10", groups = {SysParamConfigEntityValidGroup.class, ParamUnitValidGroup.class})
    @ApiModelProperty(value = "参数单位(DAYS:天/HOUR:小时/MIN:分钟/SECOND:秒)")
    private String paramUnit;
    
    /**
     * 参数单位描述
     */
    @NotNull(message = "参数单位描述 不能是Null", groups = {SysParamConfigEntityValidGroup.class, ParamUnitDetailsValidGroup.class})
    @Size(min=0, max=50, message="参数单位描述 字符长度必须小于等于50", groups = {SysParamConfigEntityValidGroup.class, ParamUnitDetailsValidGroup.class})
    @ApiModelProperty(value = "参数单位描述")
    private String paramUnitDetails;
    
    /**
     * 参数排序
     */
    @ApiModelProperty(value = "参数排序")
    private Integer paramSort;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysParamConfigEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysParamConfigEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysParamConfigEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysParamConfigEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysParamConfigEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysParamConfigEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {SysParamConfigEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {SysParamConfigEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {SysParamConfigEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public SysParamConfigEntity() {
    }
    
    public SysParamConfigEntity(Long paramId) {
        this.paramId = paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }
    public Long getParamId() {
        return this.paramId;
    }
    

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }
    public String getParamType() {
        return this.paramType;
    }
    
    public void setParamProfile(String paramProfile) {
        this.paramProfile = paramProfile;
    }
    public String getParamProfile() {
        return this.paramProfile;
    }
    
    public void setParamDetails(String paramDetails) {
        this.paramDetails = paramDetails;
    }
    public String getParamDetails() {
        return this.paramDetails;
    }
    
    public void setParamValues(String paramValues) {
        this.paramValues = paramValues;
    }
    public String getParamValues() {
        return this.paramValues;
    }
    
    public void setParamUnit(String paramUnit) {
        this.paramUnit = paramUnit;
    }
    public String getParamUnit() {
        return this.paramUnit;
    }
    
    public void setParamUnitDetails(String paramUnitDetails) {
        this.paramUnitDetails = paramUnitDetails;
    }
    public String getParamUnitDetails() {
        return this.paramUnitDetails;
    }
    
    public void setParamSort(Integer paramSort) {
        this.paramSort = paramSort;
    }
    public Integer getParamSort() {
        return this.paramSort;
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
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (paramId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                paramId = RandomIDGennerator.get().generate();
    }

    public interface SysParamConfigEntityValidGroup {}
    public interface ParamIdValidGroup {}
    public interface ParamTypeValidGroup {}
    public interface ParamProfileValidGroup {}
    public interface ParamDetailsValidGroup {}
    public interface ParamValuesValidGroup {}
    public interface ParamUnitValidGroup {}
    public interface ParamUnitDetailsValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            ParamIdValidGroup.class
            , ParamTypeValidGroup.class
            , ParamProfileValidGroup.class
            , ParamDetailsValidGroup.class
            , ParamValuesValidGroup.class
            , ParamUnitValidGroup.class
            , ParamUnitDetailsValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
