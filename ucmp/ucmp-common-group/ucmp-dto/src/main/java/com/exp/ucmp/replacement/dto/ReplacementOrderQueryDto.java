package com.exp.ucmp.replacement.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author GeYiJiang
 * @Description: 置换单查询dto
 * @date 2022/11/2 14:18
 */
@ApiModel(value = "ReplacementOrderQueryDto", description = "置换单查询dto")
public class ReplacementOrderQueryDto extends BaseModel {

    private static final long serialVersionUID = -1705852881349806824L;

    @ApiModelProperty(value = "战败标记(1-战败 0-未战败)")
    private Integer isDefeat;

    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /**
     * 门店名
     */
    @ApiModelProperty(value = "门店名")
    private String storeName;

    /**
     * 门店ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店ID")
    private Long storeId;

    /**
     * 业务类型：01、他品，02、本品
     */
    @ApiModelProperty(value = "业务类型：01、他品，02、本品")
    private String businessType;


    /**
     * 业务标识：1601、置换，1602、销售
     */
    @ApiModelProperty(value = "业务标识：1601、置换，1602、销售")
    private String businessClassify;

    /**
     * 业务单号(同线索单号)
     */
    @ApiModelProperty(value = "业务单号(同线索单号)")
    private String businessOrderNo;

    /**
     * '旧车客户姓名'
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    /**
     * '旧车车型描述'
     */
    @ApiModelProperty(value = "客户手机号")
    private String customerIphone;

    /**
     * '旧车车型描述'
     */
    @ApiModelProperty(value = "'车型描述'")
    private String carTypeChineseDescribe;

    /**
     * 制单人ID(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人ID(指的是预约表里面的顾问或者经理、店长)")
    private Long makeOrderPersonId;

    /**
     * 制单人姓名(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人姓名(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonName;

    /**
     * 制单人姓名(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人角色(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonRole;

    /**
     * 置换单状态
     */
    @ApiModelProperty(value = "置换单状态码 0701:待分配车商, 0901:待接单,0911:他品-待报价/本品-待评估,0921:待收购,0922:待过户,"
    		+ "1301、1303:待审批,1305:审批驳回,1302、1304:审批通过,0909:放弃接单,0918:逾期未报价,0919、0929:战败,1309:审批关闭")
    private String approvalStatus;
    
    /**
     * 置换单状态
     */
    @ApiModelProperty(value = "置换单状态名称 ")
    private String approvalName;

    /**
     * 创建预约时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "创建预约时间")
    private Date createdDate;

    /**
     * 创建预约时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "创建预约时间")
    private String exCreatedDate;

    /**
     * 预约检测时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "预约检测时间")
    private Date reservationDetectionDate;

    /**
     * 预约检测时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "预约检测时间")
    private String exReservationDetectionDate;

    /**
     * 预约检测地点
     */
    @ApiModelProperty(value = "预约检测地点")
    private String reservationDetectionAddress;

    /**
     * 线索类型：01、置换线索，02、收购线索，03、销售线索
     */
    @ApiModelProperty(value = "线索类型：01、置换线索，02、收购线索，03、销售线索")
    private String cluesType;

    @ApiModelProperty(value = "接单车商")
    private String receivingOrdersDealer;

    /**
     * 线索来源：01、录入，02、小程序，03、高合APP，04、官网
     */
    @ApiModelProperty(value = "线索来源：01、录入，02、小程序，03、高合APP，04、官网")
    private String cluesSource;

    /**
     * 客户是否同意价格
     */
    @ApiModelProperty(value = "客户是否同意价格(0501-是 0502-否)")
    private String customerIntention;

    /**
     * 是否收购
     */
    @ApiModelProperty(value = "是否收购(有值-是 NULL-否)")
    private String generateAcquisitionsTime;

    /**
     * 分派车商数
     */
    @ApiModelProperty(value = "分派车商数")
    private Integer dispatcherCount;

    /**
     * 放弃接单
     */
    @ApiModelProperty(value = "放弃接单")
    private Integer abandonReceivingOrdersCount;

    /**
     * 已接单-待报价
     */
    @ApiModelProperty(value = "已接单-待报价")
    private Integer ordersReceivedAndToBeQuotedCount;

    /**
     * 到期未报价
     */
    @ApiModelProperty(value = "到期未报价")
    private Integer noQuotationDueCount;

    /**
     * 放弃报价
     */
    @ApiModelProperty(value = "放弃报价")
    private Integer abandonQuotationCount;

    /**
     * 已报价
     */
    @ApiModelProperty(value = "已报价")
    private Integer quotedCount;
    
    @ApiModelProperty(value = "派单人")
    private String allotPerson;
    
    @ApiModelProperty(value = "派单人ID")
    private String allotPersonId;

	public Integer getIsDefeat() {
		return isDefeat;
	}

	public void setIsDefeat(Integer isDefeat) {
		this.isDefeat = isDefeat;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessClassify() {
		return businessClassify;
	}

	public void setBusinessClassify(String businessClassify) {
		this.businessClassify = businessClassify;
	}

	public String getBusinessOrderNo() {
		return businessOrderNo;
	}

	public void setBusinessOrderNo(String businessOrderNo) {
		this.businessOrderNo = businessOrderNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerIphone() {
		return customerIphone;
	}

	public void setCustomerIphone(String customerIphone) {
		this.customerIphone = customerIphone;
	}

	public String getCarTypeChineseDescribe() {
		return carTypeChineseDescribe;
	}

	public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
		this.carTypeChineseDescribe = carTypeChineseDescribe;
	}

	public Long getMakeOrderPersonId() {
		return makeOrderPersonId;
	}

	public void setMakeOrderPersonId(Long makeOrderPersonId) {
		this.makeOrderPersonId = makeOrderPersonId;
	}

	public String getMakeOrderPersonName() {
		return makeOrderPersonName;
	}

	public void setMakeOrderPersonName(String makeOrderPersonName) {
		this.makeOrderPersonName = makeOrderPersonName;
	}

	public String getMakeOrderPersonRole() {
		return makeOrderPersonRole;
	}

	public void setMakeOrderPersonRole(String makeOrderPersonRole) {
		this.makeOrderPersonRole = makeOrderPersonRole;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getExCreatedDate() {
		return exCreatedDate;
	}

	public void setExCreatedDate(String exCreatedDate) {
		this.exCreatedDate = exCreatedDate;
	}

	public Date getReservationDetectionDate() {
		return reservationDetectionDate;
	}

	public void setReservationDetectionDate(Date reservationDetectionDate) {
		this.reservationDetectionDate = reservationDetectionDate;
	}

	public String getExReservationDetectionDate() {
		return exReservationDetectionDate;
	}

	public void setExReservationDetectionDate(String exReservationDetectionDate) {
		this.exReservationDetectionDate = exReservationDetectionDate;
	}

	public String getReservationDetectionAddress() {
		return reservationDetectionAddress;
	}

	public void setReservationDetectionAddress(String reservationDetectionAddress) {
		this.reservationDetectionAddress = reservationDetectionAddress;
	}

	public String getCluesType() {
		return cluesType;
	}

	public void setCluesType(String cluesType) {
		this.cluesType = cluesType;
	}

	public String getReceivingOrdersDealer() {
		return receivingOrdersDealer;
	}

	public void setReceivingOrdersDealer(String receivingOrdersDealer) {
		this.receivingOrdersDealer = receivingOrdersDealer;
	}

	public String getCluesSource() {
		return cluesSource;
	}

	public void setCluesSource(String cluesSource) {
		this.cluesSource = cluesSource;
	}

	public String getCustomerIntention() {
		return customerIntention;
	}

	public void setCustomerIntention(String customerIntention) {
		this.customerIntention = customerIntention;
	}

	public String getGenerateAcquisitionsTime() {
		return generateAcquisitionsTime;
	}

	public void setGenerateAcquisitionsTime(String generateAcquisitionsTime) {
		this.generateAcquisitionsTime = generateAcquisitionsTime;
	}

	public Integer getDispatcherCount() {
		return dispatcherCount;
	}

	public void setDispatcherCount(Integer dispatcherCount) {
		this.dispatcherCount = dispatcherCount;
	}

	public Integer getAbandonReceivingOrdersCount() {
		return abandonReceivingOrdersCount;
	}

	public void setAbandonReceivingOrdersCount(Integer abandonReceivingOrdersCount) {
		this.abandonReceivingOrdersCount = abandonReceivingOrdersCount;
	}

	public Integer getOrdersReceivedAndToBeQuotedCount() {
		return ordersReceivedAndToBeQuotedCount;
	}

	public void setOrdersReceivedAndToBeQuotedCount(Integer ordersReceivedAndToBeQuotedCount) {
		this.ordersReceivedAndToBeQuotedCount = ordersReceivedAndToBeQuotedCount;
	}

	public Integer getNoQuotationDueCount() {
		return noQuotationDueCount;
	}

	public void setNoQuotationDueCount(Integer noQuotationDueCount) {
		this.noQuotationDueCount = noQuotationDueCount;
	}

	public Integer getAbandonQuotationCount() {
		return abandonQuotationCount;
	}

	public void setAbandonQuotationCount(Integer abandonQuotationCount) {
		this.abandonQuotationCount = abandonQuotationCount;
	}

	public Integer getQuotedCount() {
		return quotedCount;
	}

	public void setQuotedCount(Integer quotedCount) {
		this.quotedCount = quotedCount;
	}

	public String getAllotPerson() {
		return allotPerson;
	}

	public void setAllotPerson(String allotPerson) {
		this.allotPerson = allotPerson;
	}

	public String getAllotPersonId() {
		return allotPersonId;
	}

	public void setAllotPersonId(String allotPersonId) {
		this.allotPersonId = allotPersonId;
	}

	@Override
	public String toString() {
		return "ReplacementOrderQueryDto [isDefeat=" + isDefeat + ", reservationId=" + reservationId + ", storeName="
				+ storeName + ", storeId=" + storeId + ", businessType=" + businessType + ", businessClassify="
				+ businessClassify + ", businessOrderNo=" + businessOrderNo + ", customerName=" + customerName
				+ ", customerIphone=" + customerIphone + ", carTypeChineseDescribe=" + carTypeChineseDescribe
				+ ", makeOrderPersonId=" + makeOrderPersonId + ", makeOrderPersonName=" + makeOrderPersonName
				+ ", makeOrderPersonRole=" + makeOrderPersonRole + ", approvalStatus=" + approvalStatus
				+ ", approvalName=" + approvalName + ", createdDate=" + createdDate + ", exCreatedDate=" + exCreatedDate
				+ ", reservationDetectionDate=" + reservationDetectionDate + ", exReservationDetectionDate="
				+ exReservationDetectionDate + ", reservationDetectionAddress=" + reservationDetectionAddress
				+ ", cluesType=" + cluesType + ", receivingOrdersDealer=" + receivingOrdersDealer + ", cluesSource="
				+ cluesSource + ", customerIntention=" + customerIntention + ", generateAcquisitionsTime="
				+ generateAcquisitionsTime + ", dispatcherCount=" + dispatcherCount + ", abandonReceivingOrdersCount="
				+ abandonReceivingOrdersCount + ", ordersReceivedAndToBeQuotedCount=" + ordersReceivedAndToBeQuotedCount
				+ ", noQuotationDueCount=" + noQuotationDueCount + ", abandonQuotationCount=" + abandonQuotationCount
				+ ", quotedCount=" + quotedCount + ", allotPerson=" + allotPerson + ", allotPersonId=" + allotPersonId
				+ "]";
	}
    
}
