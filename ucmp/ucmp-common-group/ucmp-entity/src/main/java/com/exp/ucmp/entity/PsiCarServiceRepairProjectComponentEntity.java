package com.exp.ucmp.entity;

import java.math.BigDecimal;
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

@ApiModel(value = "PsiCarServiceRepairProjectComponentEntity", description = "维修项目配件表(二期)")
@GroupSequence({PsiCarServiceRepairProjectComponentEntity.class, PsiCarServiceRepairProjectComponentEntity.PsiCarServiceRepairProjectComponentEntityValidGroup.class,PsiCarServiceRepairProjectComponentEntity.ComponentIdValidGroup.class,PsiCarServiceRepairProjectComponentEntity.ProjectIdValidGroup.class,PsiCarServiceRepairProjectComponentEntity.ComponentCodeValidGroup.class,PsiCarServiceRepairProjectComponentEntity.ComponentNameValidGroup.class,PsiCarServiceRepairProjectComponentEntity.ComponentPriceValidGroup.class,PsiCarServiceRepairProjectComponentEntity.CreatedByValidGroup.class,PsiCarServiceRepairProjectComponentEntity.CreatedDateValidGroup.class,PsiCarServiceRepairProjectComponentEntity.UpdatedByValidGroup.class,PsiCarServiceRepairProjectComponentEntity.UpdatedDateValidGroup.class,PsiCarServiceRepairProjectComponentEntity.IsEnableValidGroup.class,PsiCarServiceRepairProjectComponentEntity.IsDeleteValidGroup.class}) 
public class PsiCarServiceRepairProjectComponentEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 配件id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "配件id 不能是Null", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, ComponentIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="配件id 数字精度必须符合(19,0)", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, ComponentIdValidGroup.class})
    @ApiModelProperty(value = "配件id")
    private Long componentId;
    
    
    /**
     * 维修项目id
     */
    @NotNull(message = "维修项目id 不能是Null", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, ProjectIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="维修项目id 数字精度必须符合(19,0)", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, ProjectIdValidGroup.class})
    @ApiModelProperty(value = "维修项目id")
    private Long projectId;
    
    /**
     * 配件代码
     */
    @Size(min=0, max=50, message="配件代码 字符长度必须小于等于50", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, ComponentCodeValidGroup.class})
    @ApiModelProperty(value = "配件代码")
    private String componentCode;
    
    /**
     * 配件名称
     */
    @Size(min=0, max=50, message="配件名称 字符长度必须小于等于50", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, ComponentNameValidGroup.class})
    @ApiModelProperty(value = "配件名称")
    private String componentName;
    
    /**
     * 配件费用
     */
    @Digits(integer=9, fraction=2, message="配件费用 数字精度必须符合(9,2)", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, ComponentPriceValidGroup.class})
    @ApiModelProperty(value = "配件费用")
    private BigDecimal componentPrice;
    
    /**
     * 是否维修(0 是 1 否)
     */
    @ApiModelProperty(value = "是否维修(0 是 1 否)")
    private Byte isRepair;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiCarServiceRepairProjectComponentEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiCarServiceRepairProjectComponentEntity() {
    }
    
    public PsiCarServiceRepairProjectComponentEntity(Long componentId) {
        this.componentId = componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }
    public Long getComponentId() {
        return this.componentId;
    }
    

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    public Long getProjectId() {
        return this.projectId;
    }
    
    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }
    public String getComponentCode() {
        return this.componentCode;
    }
    
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }
    public String getComponentName() {
        return this.componentName;
    }
    
    public void setComponentPrice(BigDecimal componentPrice) {
        this.componentPrice = componentPrice;
    }
    public BigDecimal getComponentPrice() {
        return this.componentPrice;
    }
    
    public void setIsRepair(Byte isRepair) {
        this.isRepair = isRepair;
    }
    public Byte getIsRepair() {
        return this.isRepair;
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
              (componentId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                componentId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarServiceRepairProjectComponentEntityValidGroup {}
    public interface ComponentIdValidGroup {}
    public interface ProjectIdValidGroup {}
    public interface ComponentCodeValidGroup {}
    public interface ComponentNameValidGroup {}
    public interface ComponentPriceValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            ComponentIdValidGroup.class
            , ProjectIdValidGroup.class
            , ComponentCodeValidGroup.class
            , ComponentNameValidGroup.class
            , ComponentPriceValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
