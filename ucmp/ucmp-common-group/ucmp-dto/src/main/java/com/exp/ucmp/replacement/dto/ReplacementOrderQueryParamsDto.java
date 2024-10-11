package com.exp.ucmp.replacement.dto;

import com.egrid.core.util.StringUtil;
import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/11/2 14:46
 */
@ApiModel(value = "ReplacementOrderQueryParamsDto", description = "置换单查询参数dto")
public class ReplacementOrderQueryParamsDto extends PageDto {

    private static final long serialVersionUID = 2657591469942699408L;

    @ApiModelProperty(value = "业务编号")
    private String businessOrderNo;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "归属门店ID列表")
    private List<Long> storeIds;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "车商所属门店ID列表")
    private List<Long> storeIdsByPartner;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "接单车商ID列表")
    private Long partnerId;
    
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "业务类型 0401 他品置换 0402 本品置换")
    private String businessType="0401";

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户手机号")
    private String customerIphone;

    @ApiModelProperty(value = "制单人姓名(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonName;

    @ApiModelProperty(value = "创建预约时间起始")
    private String startDate;

    @ApiModelProperty(value = "创建预约时间截止")
    private String endDate;

    @ApiModelProperty(value = "'旧车车型描述'")
    private String carTypeChineseDescribe;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店ID")
    private Long storeId;

    @ApiModelProperty(value = "员工id")
    private Long partyId;

    @ApiModelProperty(value = "待审批(传1303)" +
                            "审批驳回(传1305)" +
                            "审批通过(传1302)" +
                            "审核关闭(传1309))")
    private String approvalStatus;

    @ApiModelProperty(value = "待分配 0701")
    private String trackStatus;

    @ApiModelProperty(value = "待接单(0901)" +
                            "待报价(0911)" +
                            "待分配(0913)" +
                            "待收购(0921)" +
                            "待过户(0922)" +
                            "放弃接单(0909)" +
                            "逾期未报价(0918)" +
                            "战败(0919)")
    private String inquiryStatus;
    
    /**
     * 线索来源
     */
    @ApiModelProperty(value = "线索来源")
    private String cluesSource;
    
    @ApiModelProperty(value = "本品列表状态筛选，待分配车商:0701,待接单:0901,已关闭:0909,待评估:0911,战败:0919,待分配交付中心:0913,待收购:0921,待审批:1303,"
    		+ "审批驳回:1305,审批关闭:1309,待入库:1104,已入库:1105,待发放权益:1306,已完成:0923")
    private String status;

    
    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    
    public String getBusinessOrderNo() {
        return businessOrderNo;
    }

    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }

    public List<Long> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public List<Long> getStoreIdsByPartner() {
        return storeIdsByPartner;
    }

    public void setStoreIdsByPartner(List<Long> storeIdsByPartner) {
        this.storeIdsByPartner = storeIdsByPartner;
    }

    public String getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(String trackStatus) {
        this.trackStatus = trackStatus;
    }

    public String getInquiryStatus() {
        return inquiryStatus;
    }

    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

	/**
     * 获取
     * @return customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取
     * @return customerIphone
     */
    public String getCustomerIphone() {
        return customerIphone;
    }

    /**
     * 设置
     * @param customerIphone
     */
    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }

    /**
     * 获取
     * @return makeOrderPersonName
     */
    public String getMakeOrderPersonName() {
        return makeOrderPersonName;
    }

    /**
     * 设置
     * @param makeOrderPersonName
     */
    public void setMakeOrderPersonName(String makeOrderPersonName) {
        this.makeOrderPersonName = makeOrderPersonName;
    }

    /**
     * 获取
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 设置
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取
     * @return carTypeChineseDescribe
     */
    public String getCarTypeChineseDescribe() {
        return carTypeChineseDescribe;
    }

    /**
     * 设置
     * @param carTypeChineseDescribe
     */
    public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
        this.carTypeChineseDescribe = carTypeChineseDescribe;
    }

    /**
     * 获取
     * @return storeId
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * 设置
     * @param storeId
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取
     * @return approvalStatus
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * 设置
     * @param approvalStatus
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    /**
     * 获取
     * @return cluesSource
     */
    public String getCluesSource() {
        return cluesSource;
    }

    /**
     * 设置
     * @param cluesSource
     */
    public void setCluesSource(String cluesSource) {
        this.cluesSource = cluesSource;
    }

    public String getBusinessType() {
    	if(StringUtil.isEmpty(businessType)){
    		businessType="0401";
    	}
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReplacementOrderQueryParamsDto [businessOrderNo=" + businessOrderNo + ", storeIds=" + storeIds
				+ ", storeIdsByPartner=" + storeIdsByPartner + ", partnerId=" + partnerId + ", businessType="
				+ businessType + ", customerName=" + customerName + ", customerIphone=" + customerIphone
				+ ", makeOrderPersonName=" + makeOrderPersonName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", carTypeChineseDescribe=" + carTypeChineseDescribe + ", storeId=" + storeId + ", partyId=" + partyId
				+ ", approvalStatus=" + approvalStatus + ", trackStatus=" + trackStatus + ", inquiryStatus="
				+ inquiryStatus + ", cluesSource=" + cluesSource + ", status=" + status + "]";
	}

	public ReplacementOrderQueryParamsDto(String businessOrderNo, List<Long> storeIds, List<Long> storeIdsByPartner,
			Long partnerId, String businessType, String customerName, String customerIphone, String makeOrderPersonName,
			String startDate, String endDate, String carTypeChineseDescribe, Long storeId, Long partyId,
			String approvalStatus, String trackStatus, String inquiryStatus, String cluesSource, String status) {
		super();
		this.businessOrderNo = businessOrderNo;
		this.storeIds = storeIds;
		this.storeIdsByPartner = storeIdsByPartner;
		this.partnerId = partnerId;
		this.businessType = businessType;
		this.customerName = customerName;
		this.customerIphone = customerIphone;
		this.makeOrderPersonName = makeOrderPersonName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.carTypeChineseDescribe = carTypeChineseDescribe;
		this.storeId = storeId;
		this.partyId = partyId;
		this.approvalStatus = approvalStatus;
		this.trackStatus = trackStatus;
		this.inquiryStatus = inquiryStatus;
		this.cluesSource = cluesSource;
		this.status = status;
	}

	public ReplacementOrderQueryParamsDto() {
		super();
	}
	

}
