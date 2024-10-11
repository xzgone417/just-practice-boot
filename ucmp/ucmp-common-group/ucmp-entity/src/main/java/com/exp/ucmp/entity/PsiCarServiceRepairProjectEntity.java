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

@ApiModel(value = "PsiCarServiceRepairProjectEntity", description = "整备维修项目表")
@GroupSequence({PsiCarServiceRepairProjectEntity.class, PsiCarServiceRepairProjectEntity.PsiCarServiceRepairProjectEntityValidGroup.class,PsiCarServiceRepairProjectEntity.ProjectIdValidGroup.class,PsiCarServiceRepairProjectEntity.ServiceIdValidGroup.class,PsiCarServiceRepairProjectEntity.RepairProjectTypeValidGroup.class,PsiCarServiceRepairProjectEntity.RepairProjectCodeValidGroup.class,PsiCarServiceRepairProjectEntity.RepairProjectNameValidGroup.class,PsiCarServiceRepairProjectEntity.TimePriceValidGroup.class,PsiCarServiceRepairProjectEntity.CreatedByValidGroup.class,PsiCarServiceRepairProjectEntity.CreatedDateValidGroup.class,PsiCarServiceRepairProjectEntity.UpdatedByValidGroup.class,PsiCarServiceRepairProjectEntity.UpdatedDateValidGroup.class,PsiCarServiceRepairProjectEntity.IsEnableValidGroup.class,PsiCarServiceRepairProjectEntity.IsDeleteValidGroup.class}) 
public class PsiCarServiceRepairProjectEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 项目id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "项目id 不能是Null", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, ProjectIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="项目id 数字精度必须符合(19,0)", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, ProjectIdValidGroup.class})
    @ApiModelProperty(value = "项目id")
    private Long projectId;
    
    
    /**
     * 整备信息id
     */
    @NotNull(message = "整备信息id 不能是Null", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, ServiceIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="整备信息id 数字精度必须符合(19,0)", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, ServiceIdValidGroup.class})
    @ApiModelProperty(value = "整备信息id")
    private Long serviceId;
    
    /**
     * 维修项目类型
     */
    @Size(min=0, max=50, message="维修项目类型 字符长度必须小于等于50", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, RepairProjectTypeValidGroup.class})
    @ApiModelProperty(value = "维修项目类型")
    private String repairProjectType;
    
    /**
     * 维修项目代码
     */
    @Size(min=0, max=50, message="维修项目代码 字符长度必须小于等于50", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, RepairProjectCodeValidGroup.class})
    @ApiModelProperty(value = "维修项目代码")
    private String repairProjectCode;
    
    /**
     * 维修项目名称
     */
    @Size(min=0, max=50, message="维修项目名称 字符长度必须小于等于50", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, RepairProjectNameValidGroup.class})
    @ApiModelProperty(value = "维修项目名称")
    private String repairProjectName;
    
    /**
     * 工时费用
     */
    @Digits(integer=9, fraction=2, message="工时费用 数字精度必须符合(9,2)", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, TimePriceValidGroup.class})
    @ApiModelProperty(value = "工时费用")
    private BigDecimal timePrice;
    
    /**
     * 是否有配件(0 是 1 否)
     */
    @ApiModelProperty(value = "是否有配件(0 是 1 否)")
    private Byte isComponent;
    
    /**
     * 是否维修(0 是 1 否)
     */
    @ApiModelProperty(value = "是否维修(0 是 1 否)")
    private Byte isRepair;
    
    /**
     * 变更操作(0 无变更 1 新增 2 删除)
     */
    @ApiModelProperty(value = "变更操作(0 无变更 1 新增 2 删除)")
    private Byte changeOperate;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiCarServiceRepairProjectEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiCarServiceRepairProjectEntity() {
    }
    
    public PsiCarServiceRepairProjectEntity(Long projectId) {
        this.projectId = projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    public Long getProjectId() {
        return this.projectId;
    }
    

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    public Long getServiceId() {
        return this.serviceId;
    }
    
    public void setRepairProjectType(String repairProjectType) {
        this.repairProjectType = repairProjectType;
    }
    public String getRepairProjectType() {
        return this.repairProjectType;
    }
    
    public void setRepairProjectCode(String repairProjectCode) {
        this.repairProjectCode = repairProjectCode;
    }
    public String getRepairProjectCode() {
        return this.repairProjectCode;
    }
    
    public void setRepairProjectName(String repairProjectName) {
        this.repairProjectName = repairProjectName;
    }
    public String getRepairProjectName() {
        return this.repairProjectName;
    }
    
    public void setTimePrice(BigDecimal timePrice) {
        this.timePrice = timePrice;
    }
    public BigDecimal getTimePrice() {
        return this.timePrice;
    }
    
    public void setIsComponent(Byte isComponent) {
        this.isComponent = isComponent;
    }
    public Byte getIsComponent() {
        return this.isComponent;
    }
    
    public void setIsRepair(Byte isRepair) {
        this.isRepair = isRepair;
    }
    public Byte getIsRepair() {
        return this.isRepair;
    }
    
    public void setChangeOperate(Byte changeOperate) {
        this.changeOperate = changeOperate;
    }
    public Byte getChangeOperate() {
        return this.changeOperate;
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
              (projectId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                projectId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarServiceRepairProjectEntityValidGroup {}
    public interface ProjectIdValidGroup {}
    public interface ServiceIdValidGroup {}
    public interface RepairProjectTypeValidGroup {}
    public interface RepairProjectCodeValidGroup {}
    public interface RepairProjectNameValidGroup {}
    public interface TimePriceValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            ProjectIdValidGroup.class
            , ServiceIdValidGroup.class
            , RepairProjectTypeValidGroup.class
            , RepairProjectCodeValidGroup.class
            , RepairProjectNameValidGroup.class
            , TimePriceValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
