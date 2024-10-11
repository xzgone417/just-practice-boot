package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IspOrderHistoryDto", description = "isp维修配件查询返回类")
public class IspOrderHistoryDto{
	
	@ApiModelProperty(value = "配件编码")
	private String partCode;
	
	@ApiModelProperty(value = "配件名称")
    private String partName;
	
	@ApiModelProperty(value = "维修时间")
    private String workOrderTime;
	
	@ApiModelProperty(value = "维修时间")
    private String workOrderTimeStr;
	
	@ApiModelProperty(value = "维修工项code")
    private String maintenanceCode;
	
	@ApiModelProperty(value = "工项名称")
    private String maintenanceName;
	
	@ApiModelProperty(value = "收费区分Code")
    private Long feeType;
	
	@ApiModelProperty(value = "收费区分描述")
    private String feeTypeLabel;
	
	@ApiModelProperty(value = "是否是正常保修 0 是 1 不是")
    private int isWarranty;

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

	public String getWorkOrderTime() {
		return workOrderTime;
	}

	public void setWorkOrderTime(String workOrderTime) {
		this.workOrderTime = workOrderTime;
	}

	public String getWorkOrderTimeStr() {
		return workOrderTimeStr;
	}

	public void setWorkOrderTimeStr(String workOrderTimeStr) {
		this.workOrderTimeStr = workOrderTimeStr;
	}

	public String getMaintenanceCode() {
		return maintenanceCode;
	}

	public void setMaintenanceCode(String maintenanceCode) {
		this.maintenanceCode = maintenanceCode;
	}

	public String getMaintenanceName() {
		return maintenanceName;
	}

	public void setMaintenanceName(String maintenanceName) {
		this.maintenanceName = maintenanceName;
	}

	public Long getFeeType() {
		return feeType;
	}

	public void setFeeType(Long feeType) {
		this.feeType = feeType;
	}

	public String getFeeTypeLabel() {
		return feeTypeLabel;
	}

	public void setFeeTypeLabel(String feeTypeLabel) {
		this.feeTypeLabel = feeTypeLabel;
	}

	public int getIsWarranty() {
		return isWarranty;
	}

	public void setIsWarranty(int isWarranty) {
		this.isWarranty = isWarranty;
	}

}
