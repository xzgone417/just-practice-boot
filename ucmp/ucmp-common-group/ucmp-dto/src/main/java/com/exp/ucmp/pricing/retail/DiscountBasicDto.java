package com.exp.ucmp.pricing.retail;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author GeYiJiang
 * @Description: 车辆折扣信息dto
 * @date 2023/2/9 13:37
 */
@ApiModel(value = "CarDiscountInfoDto", description = "车辆折扣信息dto")
public class DiscountBasicDto extends BaseModel {

    @ApiModelProperty(value = "里程折扣")
    private Map<String,String> mileageDiscount;

    @ApiModelProperty(value = "折旧折扣")
    private Map<String,String> depreciationDiscount;

    @ApiModelProperty(value = "维修折扣")
    private List<MaintenanceDto> maintenanceDtos;

    @ApiModelProperty(value = "当前维修折扣类型")
    private String maintenanceNow;

    @ApiModelProperty(value = "当前使用类型")
    private String useNatureNow;

    @ApiModelProperty(value = "生产年份折扣")
    private Map<String,String> productionDiscount;

    @ApiModelProperty(value = "过户次数折扣")
    private Map<String,String> transferCount;
    @ApiModelProperty(value = "使用性质折扣")
    private List<UseNatureDto> useNatureDtos;

    @ApiModelProperty(value = "建议价")
    private String suggestedPrice;
    
    @ApiModelProperty(value = "上一次的定价")
    private BigDecimal price;
    
    @ApiModelProperty(value = "新车价")
    private Double newCarPrice;
    
    @ApiModelProperty(value = "当前销售价")
    private Double curCarPrice;
    
    @ApiModelProperty(value = "审批状态")
    private Integer approveStatus;
	
	@ApiModelProperty(value = "审批状态名称")
    private String approveStatusName;
	
	@ApiModelProperty(value = "驳回原因")
    private String rejectReason;

    public Map<String, String> getMileageDiscount() {
        return mileageDiscount;
    }

    public void setMileageDiscount(Map<String, String> mileageDiscount) {
        this.mileageDiscount = mileageDiscount;
    }

    public Map<String, String> getDepreciationDiscount() {
        return depreciationDiscount;
    }

    public void setDepreciationDiscount(Map<String, String> depreciationDiscount) {
        this.depreciationDiscount = depreciationDiscount;
    }

    public List<MaintenanceDto> getMaintenanceDtos() {
        return maintenanceDtos;
    }

    public void setMaintenanceDtos(List<MaintenanceDto> maintenanceDtos) {
        this.maintenanceDtos = maintenanceDtos;
    }

    public Map<String, String> getProductionDiscount() {
        return productionDiscount;
    }

    public void setProductionDiscount(Map<String, String> productionDiscount) {
        this.productionDiscount = productionDiscount;
    }

    public Map<String, String> getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(Map<String, String> transferCount) {
        this.transferCount = transferCount;
    }

    public List<UseNatureDto> getUseNatureDtos() {
        return useNatureDtos;
    }

    public void setUseNatureDtos(List<UseNatureDto> useNatureDtos) {
        this.useNatureDtos = useNatureDtos;
    }

    public String getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(String suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }

    public String getMaintenanceNow() {
        return maintenanceNow;
    }

    public void setMaintenanceNow(String maintenanceNow) {
        this.maintenanceNow = maintenanceNow;
    }

    public String getUseNatureNow() {
        return useNatureNow;
    }

    public void setUseNatureNow(String useNatureNow) {
        this.useNatureNow = useNatureNow;
    }

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Double getNewCarPrice() {
		return newCarPrice;
	}

	public void setNewCarPrice(Double newCarPrice) {
		this.newCarPrice = newCarPrice;
	}

	public Double getCurCarPrice() {
		return curCarPrice;
	}

	public void setCurCarPrice(Double curCarPrice) {
		this.curCarPrice = curCarPrice;
	}

	public Integer getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Integer approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getApproveStatusName() {
		return approveStatusName;
	}

	public void setApproveStatusName(String approveStatusName) {
		this.approveStatusName = approveStatusName;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
}
