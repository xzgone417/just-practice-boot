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

@ApiModel(value = "PsiMainteanceItemsEntity", description = "")
@GroupSequence({PsiMainteanceItemsEntity.class, PsiMainteanceItemsEntity.PsiMainteanceItemsEntityValidGroup.class,PsiMainteanceItemsEntity.IdValidGroup.class,PsiMainteanceItemsEntity.StockIdValidGroup.class,PsiMainteanceItemsEntity.VinCodeValidGroup.class,PsiMainteanceItemsEntity.ProjectNoValidGroup.class,PsiMainteanceItemsEntity.ProjectNameValidGroup.class,PsiMainteanceItemsEntity.CollectFeesValidGroup.class,PsiMainteanceItemsEntity.MaintainTypeValidGroup.class,PsiMainteanceItemsEntity.CreatedByValidGroup.class,PsiMainteanceItemsEntity.UpdateByValidGroup.class}) 
public class PsiMainteanceItemsEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键id 不能是Null", groups = {PsiMainteanceItemsEntityValidGroup.class, IdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键id 数字精度必须符合(19,0)", groups = {PsiMainteanceItemsEntityValidGroup.class, IdValidGroup.class})
    @ApiModelProperty(value = "主键id")
    private Long id;
    
    
    /**
     * 库存车辆ID
     */
    @Digits(integer=19, fraction=0, message="库存车辆ID 数字精度必须符合(19,0)", groups = {PsiMainteanceItemsEntityValidGroup.class, StockIdValidGroup.class})
    @ApiModelProperty(value = "库存车辆ID")
    private Long stockId;
    
    /**
     * vin
     */
    @Size(min=0, max=100, message="vin 字符长度必须小于等于100", groups = {PsiMainteanceItemsEntityValidGroup.class, VinCodeValidGroup.class})
    @ApiModelProperty(value = "vin")
    private String vinCode;
    
    /**
     * 项目编号
     */
    @Size(min=0, max=50, message="项目编号 字符长度必须小于等于50", groups = {PsiMainteanceItemsEntityValidGroup.class, ProjectNoValidGroup.class})
    @ApiModelProperty(value = "项目编号")
    private String projectNo;
    
    /**
     * 项目名称
     */
    @Size(min=0, max=255, message="项目名称 字符长度必须小于等于255", groups = {PsiMainteanceItemsEntityValidGroup.class, ProjectNameValidGroup.class})
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    
    /**
     * 配件编号
     */
    @Size(min=0, max=50, message="配件编号 字符长度必须小于等于50")
    @ApiModelProperty(value = "配件编号")
    private String partCode;
    
    /**
     * 项目名称
     */
    @Size(min=0, max=255, message="配件名称 字符长度必须小于等于255")
    @ApiModelProperty(value = "配件名称")
    private String partName;
    
    /**
     * 维修时间戳
     */
    @Digits(integer=19, fraction=0, message="维修时间戳 数字精度必须符合(19,0)")
    @ApiModelProperty(value = "维修时间戳")
    private Long workOrderTime;
    
    /**
     * 收费类型
     */
    @Size(min=0, max=50, message="收费类型 字符长度必须小于等于20")
    @ApiModelProperty(value = "收费类型")
    private String feeType;
    
    /**
     * 收费类型名称
     */
    @Size(min=0, max=255, message="配件名称 字符长度必须小于等于100")
    @ApiModelProperty(value = "收费类型名称")
    private String feeTypeLabel;
    
    /**
     * 收费类型
     */
    @Size(min=0, max=50, message="收费类型 字符长度必须小于等于50", groups = {PsiMainteanceItemsEntityValidGroup.class, CollectFeesValidGroup.class})
    @ApiModelProperty(value = "收费类型")
    private String collectFees;
    
    /**
     * 维修时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "维修时间")
    private Date maintainTime;
    
    /**
     * 维修类型(001维修工单项目002整备工单项目)
     */
    @Size(min=0, max=10, message="维修类型(001维修工单项目002整备工单项目) 字符长度必须小于等于10", groups = {PsiMainteanceItemsEntityValidGroup.class, MaintainTypeValidGroup.class})
    @ApiModelProperty(value = "维修类型(001维修工单项目002整备工单项目)")
    private String maintainType;
    
    /**
     * 创建人
     */
    @Digits(integer=19, fraction=0, message="创建人 数字精度必须符合(19,0)", groups = {PsiMainteanceItemsEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人
     */
    @Digits(integer=19, fraction=0, message="更新人 数字精度必须符合(19,0)", groups = {PsiMainteanceItemsEntityValidGroup.class, UpdateByValidGroup.class})
    @ApiModelProperty(value = "更新人")
    private Long updateBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;
    
    public PsiMainteanceItemsEntity() {
    }
    
    public PsiMainteanceItemsEntity(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }
    

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    public Long getStockId() {
        return this.stockId;
    }
    
    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }
    public String getVinCode() {
        return this.vinCode;
    }
    
    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }
    public String getProjectNo() {
        return this.projectNo;
    }
    
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getProjectName() {
        return this.projectName;
    }
    
    public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Long getWorkOrderTime() {
		return workOrderTime;
	}

	public void setWorkOrderTime(Long workOrderTime) {
		this.workOrderTime = workOrderTime;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getFeeTypeLabel() {
		return feeTypeLabel;
	}

	public void setFeeTypeLabel(String feeTypeLabel) {
		this.feeTypeLabel = feeTypeLabel;
	}

	public void setCollectFees(String collectFees) {
        this.collectFees = collectFees;
    }
    public String getCollectFees() {
        return this.collectFees;
    }
    
    public void setMaintainTime(Date maintainTime) {
        this.maintainTime = maintainTime;
    }
    public Date getMaintainTime() {
        return this.maintainTime;
    }
    
    public void setMaintainType(String maintainType) {
        this.maintainType = maintainType;
    }
    public String getMaintainType() {
        return this.maintainType;
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
    
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
    public Long getUpdateBy() {
        return this.updateBy;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (id == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                id = RandomIDGennerator.get().generate();
    }

    public interface PsiMainteanceItemsEntityValidGroup {}
    public interface IdValidGroup {}
    public interface StockIdValidGroup {}
    public interface VinCodeValidGroup {}
    public interface ProjectNoValidGroup {}
    public interface ProjectNameValidGroup {}
    public interface CollectFeesValidGroup {}
    public interface MaintainTypeValidGroup {}
    public interface CreatedByValidGroup {}
    public interface UpdateByValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            IdValidGroup.class
            , StockIdValidGroup.class
            , VinCodeValidGroup.class
            , ProjectNoValidGroup.class
            , ProjectNameValidGroup.class
            , CollectFeesValidGroup.class
            , MaintainTypeValidGroup.class
            , CreatedByValidGroup.class
            , UpdateByValidGroup.class
        };
    }
}
