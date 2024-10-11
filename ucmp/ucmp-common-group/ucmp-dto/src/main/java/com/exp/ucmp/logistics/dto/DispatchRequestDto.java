package com.exp.ucmp.logistics.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DispatchRequestDto", description = "发运请求实体类")
public class DispatchRequestDto {
	
	@NotNull
	@ApiModelProperty(value = "业务类型 40-发运指令 41-取消发运")
	private String zbustp;
	
	@ApiModelProperty(value = "内部车辆编号")
    private String vhcle;
	
	@ApiModelProperty(value = "车辆识别代码VIN")
    private String vhvin;
	
	@ApiModelProperty(value = "发货工厂")
    private String werks;
	
	@ApiModelProperty(value = "请求编号 新建为空（VLMS返回），取消时必填")
    private String requestNo;
	
	@ApiModelProperty(value = "出发节点")
    private String startNode;
	
	@ApiModelProperty(value = "发货库位")
    private String lgort;
	
	@ApiModelProperty(value = "变式物料号")
    private String zMatnr;
	
	@ApiModelProperty(value = "客户")
    private String kunnr;
	
	@ApiModelProperty(value = "客户名称")
    private String name;
	
	@ApiModelProperty(value = "到达节点")
    private String endNode;
	
//	@NotNull
	@ApiModelProperty(value = "收货工厂")
    private String zRewerk;
	
	@ApiModelProperty(value = "收货库存地")
    private String zRelgort;
	
	@NotNull
	@ApiModelProperty(value = "收货地址")
    private String zAddress;
	
	@NotNull
	@ApiModelProperty(value = "接收人")
    private String zReceiver;
	
	@NotNull
	@ApiModelProperty(value = "联系方式")
    private String zContact;
	
	@NotNull
	@ApiModelProperty(value = "发货日期")
    private String wadat;
	
	@NotNull
	@ApiModelProperty(value = "数量")
    private String lfimg;
	
	@ApiModelProperty(value = "基本单位")
    private String meins;
	
	@ApiModelProperty(value = "发货地址")
    private String startAddress;
	
	@NotNull
	@ApiModelProperty(value = "车型")
    private String carModel;
	
	@NotNull
	@ApiModelProperty(value = "发货人联系方式")
    private List<SenderDto> senderList;
	
	@NotNull
	@ApiModelProperty(value = "收货人联系方式")
    private List<ReceiverDto> receiverList;
	
	@ApiModelProperty(value = "发运类型 5：特殊")
    private String businessType="5";
	
	@NotNull
	@ApiModelProperty(value = "请求时间")
    private String requestTime;
	
	@NotNull
	@ApiModelProperty(value = "可发运时间")
    private String shippingTime;
	
//	@NotNull
	@ApiModelProperty(value = "可收货时间")
    private String receivingTime;
	
	@NotNull
	@ApiModelProperty(value = "车辆类型 3 : 二手车")
    private String carType="3";

	public String getZbustp() {
		return zbustp;
	}

	public void setZbustp(String zbustp) {
		this.zbustp = zbustp;
	}

	public String getVhcle() {
		return vhcle;
	}

	public void setVhcle(String vhcle) {
		this.vhcle = vhcle;
	}

	public String getVhvin() {
		return vhvin;
	}

	public void setVhvin(String vhvin) {
		this.vhvin = vhvin;
	}

	public String getWerks() {
		return werks;
	}

	public void setWerks(String werks) {
		this.werks = werks;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getStartNode() {
		return startNode;
	}

	public void setStartNode(String startNode) {
		this.startNode = startNode;
	}

	public String getLgort() {
		return lgort;
	}

	public void setLgort(String lgort) {
		this.lgort = lgort;
	}

	public String getzMatnr() {
		return zMatnr;
	}

	public void setzMatnr(String zMatnr) {
		this.zMatnr = zMatnr;
	}

	public String getKunnr() {
		return kunnr;
	}

	public void setKunnr(String kunnr) {
		this.kunnr = kunnr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndNode() {
		return endNode;
	}

	public void setEndNode(String endNode) {
		this.endNode = endNode;
	}

	public String getzRewerk() {
		return zRewerk;
	}

	public void setzRewerk(String zRewerk) {
		this.zRewerk = zRewerk;
	}

	public String getzRelgort() {
		return zRelgort;
	}

	public void setzRelgort(String zRelgort) {
		this.zRelgort = zRelgort;
	}

	public String getzAddress() {
		return zAddress;
	}

	public void setzAddress(String zAddress) {
		this.zAddress = zAddress;
	}

	public String getzReceiver() {
		return zReceiver;
	}

	public void setzReceiver(String zReceiver) {
		this.zReceiver = zReceiver;
	}

	public String getzContact() {
		return zContact;
	}

	public void setzContact(String zContact) {
		this.zContact = zContact;
	}

	public String getWadat() {
		return wadat;
	}

	public void setWadat(String wadat) {
		this.wadat = wadat;
	}

	public String getLfimg() {
		return lfimg;
	}

	public void setLfimg(String lfimg) {
		this.lfimg = lfimg;
	}

	public String getMeins() {
		return meins;
	}

	public void setMeins(String meins) {
		this.meins = meins;
	}

	public String getStartAddress() {
		return startAddress;
	}

	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public List<SenderDto> getSenderList() {
		return senderList;
	}

	public void setSenderList(List<SenderDto> senderList) {
		this.senderList = senderList;
	}

	public List<ReceiverDto> getReceiverList() {
		return receiverList;
	}

	public void setReceiverList(List<ReceiverDto> receiverList) {
		this.receiverList = receiverList;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getShippingTime() {
		return shippingTime;
	}

	public void setShippingTime(String shippingTime) {
		this.shippingTime = shippingTime;
	}

	public String getReceivingTime() {
		return receivingTime;
	}

	public void setReceivingTime(String receivingTime) {
		this.receivingTime = receivingTime;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
	
}
