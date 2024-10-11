package com.exp.ucmp.car.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarMainInfoDto", description = "车辆基本信息实体类")
public class MaintenanceInfoDto {

	@ApiModelProperty(value = "维修日期")
	private String maintenanceDate;
	
	@ApiModelProperty(value = "工单号")
	private String workOrderNo;
	
	@ApiModelProperty(value = "维修里程（KM）")
	private String mileage;
	
	@ApiModelProperty(value = "维修费用（元）")
	private String cost;
	
	@ApiModelProperty(value = "维修地点")
	private String address;
	
	@ApiModelProperty(value = "维修类型")
	private String maintenanceType;
	
	@ApiModelProperty(value = "维修项目集合")
	private List<MaintenanceItemDto> maintenanceItemList;
	
	@ApiModelProperty(value = "维修配件集合")
	private List<RepairPartsDto> repairPartsList;
	
	@ApiModelProperty(value = "其他费用集合")
	private List<OtherFeesDto> otherFeesList;

	public String getMaintenanceDate() {
		return maintenanceDate;
	}

	public void setMaintenanceDate(String maintenanceDate) {
		this.maintenanceDate = maintenanceDate;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMaintenanceType() {
		return maintenanceType;
	}

	public void setMaintenanceType(String maintenanceType) {
		this.maintenanceType = maintenanceType;
	}

	public List<MaintenanceItemDto> getMaintenanceItemList() {
		return maintenanceItemList;
	}

	public void setMaintenanceItemList(List<MaintenanceItemDto> maintenanceItemList) {
		this.maintenanceItemList = maintenanceItemList;
	}

	public List<RepairPartsDto> getRepairPartsList() {
		return repairPartsList;
	}

	public void setRepairPartsList(List<RepairPartsDto> repairPartsList) {
		this.repairPartsList = repairPartsList;
	}

	public List<OtherFeesDto> getOtherFeesList() {
		return otherFeesList;
	}

	public void setOtherFeesList(List<OtherFeesDto> otherFeesList) {
		this.otherFeesList = otherFeesList;
	}
	
}
