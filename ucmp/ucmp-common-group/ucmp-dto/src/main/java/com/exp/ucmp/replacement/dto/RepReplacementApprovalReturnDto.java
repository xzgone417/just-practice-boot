package com.exp.ucmp.replacement.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(value = "RepReplacementApprovalReturnDto", description = "置换审批返回信息")
public class RepReplacementApprovalReturnDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 置换ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "置换ID")
    private Long replacementId;


    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /**
     * 客户ID
     */
   @ApiModelProperty(value = "客户ID")
    private Long customerId;

    /**
     * 门店ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店ID")
    private Long storeId;

    /**
     * 门店名
     */
    @ApiModelProperty(value = "门店名")
    private String storeName;

    /**
     * 制单人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "制单人ID")
    private String makeOrderPersonId;

    /**
     * 制单人姓名
     */
    @ApiModelProperty(value = "制单人姓名")
    private String makeOrderPersonName;

    /**
     * 业务类型：0401	他品
     * 0402	本品
     */
    @ApiModelProperty(value = "业务类型：0401、他品，0402、本品")
    private String businessType;

    /**
     * 业务单号(同线索单号)
     */
    @ApiModelProperty(value = "业务单号(同线索单号)")
    private String businessOrderNo;

    /**
     * 旧车客户姓名
     */
    @ApiModelProperty(value = "旧车客户姓名")
    private String oldCarCustomerName;

    /**
     * 旧车客户手机号
     */
    @ApiModelProperty(value = "旧车客户手机号")
    private String oldCarCustomerIphone;

    /**
     * 旧车车型描述
     */
    @ApiModelProperty(value = "旧车车型描述")
    private String oldCarModelDescribe;

    /**
     * 最后交易上报时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后交易上报时间")
    private Date reportingDateEnd;

    /**
     * 最后审批时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后审批时间")
    private Date approvalDateEnd;


    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String exCreatedDte;

    /**
     * 最后审批时间
     */
    @ApiModelProperty(value = "最后审批时间")
    private String exApprovalDateEnd;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createdDte;

    /**
     * 权益发放标志：1801、发放，1802、不发放
     */
    @ApiModelProperty(value = "权益发放标志：1801、发放，1802、不发放")
    private String rightsIssueSign;

    /**
     * 旧车确认状态：1701、未确认，1702、驳回
     */
    @ApiModelProperty(value = "旧车确认状态：1701、未确认，1702、驳回")
    private String oldCarConfirmSign;

    /**
     * 审批状态：1301	待确认
     * 1302	确认通过
     * 1303	待审批
     * 1304	审批通过
     * 1305	驳回
     * 1309	关闭
     */
   @ApiModelProperty(value = "审批状态：1301\t待确认\n" +
           "1302\t确认通过\n" +
           "1303\t待审批\n" +
           "1304\t审批通过\n" +
           "1305\t驳回\n" +
           "1309\t关闭\n")
    private String approvalStatus;

    /**
     * 创建人姓名
     */
   @ApiModelProperty(value = "创建人姓名")
    private String createdPersonName;


    /**
     * 是否存在驳回记录
     */
    @ApiModelProperty(value = "是否存在驳回记录(存在true/不存在false)")
    private boolean flag;



    /**
     * 1601置换/1602销售   业务标识
     */
    @ApiModelProperty(value = "1601置换/1602销售   业务标识")
    private String businessClassify;
    
    @ApiModelProperty(value = "派单人")
    private String allotPerson;
    
    @ApiModelProperty(value = "派单人ID")
    private String allotPersonId;

    public RepReplacementApprovalReturnDto() {
    }

    public RepReplacementApprovalReturnDto(Long replacementId) {
        this.replacementId = replacementId;
    }

    public void setReplacementId(Long replacementId) {
        this.replacementId = replacementId;
    }
    public Long getReplacementId() {
        return this.replacementId;
    }
    

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }
    
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreName() {
        return this.storeName;
    }
    
    public void setMakeOrderPersonId(String makeOrderPersonId) {
        this.makeOrderPersonId = makeOrderPersonId;
    }
    public String getMakeOrderPersonId() {
        return this.makeOrderPersonId;
    }
    
    public void setMakeOrderPersonName(String makeOrderPersonName) {
        this.makeOrderPersonName = makeOrderPersonName;
    }
    public String getMakeOrderPersonName() {
        return this.makeOrderPersonName;
    }
    
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    public String getBusinessType() {
        return this.businessType;
    }
    
    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }
    public String getBusinessOrderNo() {
        return this.businessOrderNo;
    }
    
    public void setOldCarCustomerName(String oldCarCustomerName) {
        this.oldCarCustomerName = oldCarCustomerName;
    }
    public String getOldCarCustomerName() {
        return this.oldCarCustomerName;
    }
    
    public void setOldCarCustomerIphone(String oldCarCustomerIphone) {
        this.oldCarCustomerIphone = oldCarCustomerIphone;
    }
    public String getOldCarCustomerIphone() {
        return this.oldCarCustomerIphone;
    }
    
    public void setOldCarModelDescribe(String oldCarModelDescribe) {
        this.oldCarModelDescribe = oldCarModelDescribe;
    }
    public String getOldCarModelDescribe() {
        return this.oldCarModelDescribe;
    }
    
    public void setReportingDateEnd(Date reportingDateEnd) {
        this.reportingDateEnd = reportingDateEnd;
    }
    public Date getReportingDateEnd() {
        return this.reportingDateEnd;
    }
    
    public void setApprovalDateEnd(Date approvalDateEnd) {
        this.approvalDateEnd = approvalDateEnd;
    }
    public Date getApprovalDateEnd() {
        return this.approvalDateEnd;
    }
    
    public void setRightsIssueSign(String rightsIssueSign) {
        this.rightsIssueSign = rightsIssueSign;
    }
    public String getRightsIssueSign() {
        return this.rightsIssueSign;
    }
    
    public void setOldCarConfirmSign(String oldCarConfirmSign) {
        this.oldCarConfirmSign = oldCarConfirmSign;
    }
    public String getOldCarConfirmSign() {
        return this.oldCarConfirmSign;
    }
    
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
    public String getApprovalStatus() {
        return this.approvalStatus;
    }
    
    public void setCreatedPersonName(String createdPersonName) {
        this.createdPersonName = createdPersonName;
    }
    public String getCreatedPersonName() {
        return this.createdPersonName;
    }
    


    public String getBusinessClassify() {
        return businessClassify;
    }

    public void setBusinessClassify(String businessClassify) {
        this.businessClassify = businessClassify;
    }


    public Date getCreatedDte() {
        return createdDte;
    }

    public void setCreatedDte(Date createdDte) {
        this.createdDte = createdDte;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取
     * @return exCreatedDte
     */
    public String getExCreatedDte() {
        return exCreatedDte;
    }

    /**
     * 设置
     * @param exCreatedDte
     */
    public void setExCreatedDte(String exCreatedDte) {
        this.exCreatedDte = exCreatedDte;
    }

    /**
     * 获取
     * @return exApprovalDateEnd
     */
    public String getExApprovalDateEnd() {
        return exApprovalDateEnd;
    }

    /**
     * 设置
     * @param exApprovalDateEnd
     */
    public void setExApprovalDateEnd(String exApprovalDateEnd) {
        this.exApprovalDateEnd = exApprovalDateEnd;
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
		return "RepReplacementApprovalReturnDto [replacementId=" + replacementId + ", reservationId=" + reservationId
				+ ", customerId=" + customerId + ", storeId=" + storeId + ", storeName=" + storeName
				+ ", makeOrderPersonId=" + makeOrderPersonId + ", makeOrderPersonName=" + makeOrderPersonName
				+ ", businessType=" + businessType + ", businessOrderNo=" + businessOrderNo + ", oldCarCustomerName="
				+ oldCarCustomerName + ", oldCarCustomerIphone=" + oldCarCustomerIphone + ", oldCarModelDescribe="
				+ oldCarModelDescribe + ", reportingDateEnd=" + reportingDateEnd + ", approvalDateEnd="
				+ approvalDateEnd + ", exCreatedDte=" + exCreatedDte + ", exApprovalDateEnd=" + exApprovalDateEnd
				+ ", createdDte=" + createdDte + ", rightsIssueSign=" + rightsIssueSign + ", oldCarConfirmSign="
				+ oldCarConfirmSign + ", approvalStatus=" + approvalStatus + ", createdPersonName=" + createdPersonName
				+ ", flag=" + flag + ", businessClassify=" + businessClassify + ", allotPerson=" + allotPerson
				+ ", allotPersonId=" + allotPersonId + "]";
	}

}
