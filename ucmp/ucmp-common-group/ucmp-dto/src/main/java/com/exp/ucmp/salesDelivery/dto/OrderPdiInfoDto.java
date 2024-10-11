package com.exp.ucmp.salesDelivery.dto;


import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderPdiInfoDto", description = "订单pdi信息详情")
public class OrderPdiInfoDto {
	
	@ApiModelProperty(value = "订单id 必传")
	private Long orderInfoId;
	
	@ApiModelProperty(value = "PDI状态 6501 待检测 6502 待整备 6503 已完成 ")
	private String pdiStatus;
	
	@ApiModelProperty(value = "PDI状态名称 不必传")
	private String pdiStatusName;
	
	@ApiModelProperty(value = "PDI结果 6401 有问题，已转处理流程 6402 检查合格 ")
	private String pdiResult;
	
	@ApiModelProperty(value = "PDI结果名称")
	private String pdiResultName;
	
	@ApiModelProperty(value = "PDI检测报告")
	private List<DeliveryOrderPicDto> pdiTestReportList;
	
	@ApiModelProperty(value = "维修历史")
	private List<DeliveryOrderPicDto> maintenanceHistoryList;
	
	@ApiModelProperty(value = "瑕疵图片")
	private List<DeliveryOrderPicDto> defectivePicturesList;
	
	@ApiModelProperty(value = "操作类型 1 提交 2 保存 必传")
    private Integer operationType;

	public Long getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public String getPdiStatus() {
		return pdiStatus;
	}

	public void setPdiStatus(String pdiStatus) {
		this.pdiStatus = pdiStatus;
	}

	public String getPdiStatusName() {
		return pdiStatusName;
	}

	public void setPdiStatusName(String pdiStatusName) {
		this.pdiStatusName = pdiStatusName;
	}

	public String getPdiResult() {
		return pdiResult;
	}

	public void setPdiResult(String pdiResult) {
		this.pdiResult = pdiResult;
	}

	public String getPdiResultName() {
		return pdiResultName;
	}

	public void setPdiResultName(String pdiResultName) {
		this.pdiResultName = pdiResultName;
	}

	public List<DeliveryOrderPicDto> getPdiTestReportList() {
		return pdiTestReportList;
	}

	public void setPdiTestReportList(List<DeliveryOrderPicDto> pdiTestReportList) {
		this.pdiTestReportList = pdiTestReportList;
	}

	public List<DeliveryOrderPicDto> getMaintenanceHistoryList() {
		return maintenanceHistoryList;
	}

	public void setMaintenanceHistoryList(List<DeliveryOrderPicDto> maintenanceHistoryList) {
		this.maintenanceHistoryList = maintenanceHistoryList;
	}

	public List<DeliveryOrderPicDto> getDefectivePicturesList() {
		return defectivePicturesList;
	}

	public void setDefectivePicturesList(List<DeliveryOrderPicDto> defectivePicturesList) {
		this.defectivePicturesList = defectivePicturesList;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}
	
}
