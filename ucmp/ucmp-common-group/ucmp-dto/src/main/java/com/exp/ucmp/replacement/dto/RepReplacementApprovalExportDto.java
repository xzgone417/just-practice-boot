package com.exp.ucmp.replacement.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(value = "RepReplacementApprovalExportDto", description = "置换审批导出信息")
public class RepReplacementApprovalExportDto extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 置换ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "置换ID")
    @ExcelIgnore
    private Long replacementId;

    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    @ExcelIgnore
    private Long reservationId;

    /**
     * 客户ID
     */
    @ApiModelProperty(value = "客户ID")
    @ExcelIgnore
    private Long customerId;

    /**
     * 门店ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店ID")
    @ExcelIgnore
    private Long storeId;

    /**
     * 制单人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "制单人ID")
    @ExcelIgnore
    private String makeOrderPersonId;

    /**
     * 制单人姓名
     */
    @ApiModelProperty(value = "制单人姓名")
    @ExcelIgnore
    private String makeOrderPersonName;

    /**
     * 业务类型：0401	他品
     * 0402	本品
     */
    @ApiModelProperty(value = "业务类型：0401、他品，0402、本品")
    @ExcelIgnore
    private String businessType;

    /**
     * 是否存在驳回记录
     */
    @ApiModelProperty(value = "是否存在驳回记录(存在true/不存在false)")
    @ExcelIgnore
    private boolean flag;

    /**
     * 门店名
     */
    @ApiModelProperty(value = "门店名")
    @ExcelProperty(value = "归属门店",index = 4)
    private String storeName;

    /**
     * 业务单号(同线索单号)
     */
    @ApiModelProperty(value = "业务单号(同线索单号)")
    @ExcelProperty(value = "置换单号",index = 0)
    private String businessOrderNo;

    /**
     * 旧车客户姓名
     */
    @ApiModelProperty(value = "旧车客户姓名")
    @ExcelProperty(value = "车主",index = 2)
    private String oldCarCustomerName;

    /**
     * 旧车客户手机号
     */
    @ApiModelProperty(value = "旧车客户手机号")
    @ExcelProperty(value = "手机号",index = 1)
    private String oldCarCustomerIphone;

    /**
     * 旧车车型描述
     */
    @ApiModelProperty(value = "车型")
    @ExcelProperty(value = "旧车车型描述",index = 3)
    private String oldCarModelDescribe;

    /**
     * 创建人姓名
     */
    @ApiModelProperty(value = "创建人姓名")
    @ExcelProperty(value = "创建人",index = 5)
    private String createdPersonName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @ExcelProperty(value = "创建时间",index = 6)
    private String exCreatedDte;

    /**
     * 最后审批时间
     */
    @ApiModelProperty(value = "最后审批时间")
    @ExcelProperty(value = "审批时间",index = 7)
    private String exApprovalDateEnd;

    /**
     * 最后审批时间
     */
    @ApiModelProperty(value = "最后审批时间")
    @ExcelIgnore
    private String approvalDateEnd;

    /**
     * 1601置换/1602销售   业务标识
     */
    @ApiModelProperty(value = "1601置换/1602销售   业务标识")
    @ExcelProperty(value = "业务类型",index = 8)
    private String businessClassify;

    /**
     * 最后交易上报时间
     */
    @ApiModelProperty(value = "最后交易上报时间")
    @ExcelIgnore
    private Date reportingDateEnd;

    /**
     * 权益发放标志：1801、发放，1802、不发放
     */
    @ApiModelProperty(value = "权益发放标志：1801、发放，1802、不发放")
    @ExcelIgnore
    private String rightsIssueSign;

    /**
     * 旧车确认状态：1701、未确认，1702、驳回
     */
    @ApiModelProperty(value = "旧车确认状态：1701、未确认，1702、驳回")
    @ExcelIgnore
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
    @ExcelIgnore
    private String approvalStatus;

    public RepReplacementApprovalExportDto() {
    }

    public RepReplacementApprovalExportDto(Long replacementId, Long reservationId, Long customerId, Long storeId, String makeOrderPersonId, String makeOrderPersonName, String businessType, boolean flag, String storeName, String businessOrderNo, String oldCarCustomerName, String oldCarCustomerIphone, String oldCarModelDescribe, String createdPersonName, String exCreatedDte, String exApprovalDateEnd, String approvalDateEnd, String businessClassify, Date reportingDateEnd, String rightsIssueSign, String oldCarConfirmSign, String approvalStatus) {
        this.replacementId = replacementId;
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.storeId = storeId;
        this.makeOrderPersonId = makeOrderPersonId;
        this.makeOrderPersonName = makeOrderPersonName;
        this.businessType = businessType;
        this.flag = flag;
        this.storeName = storeName;
        this.businessOrderNo = businessOrderNo;
        this.oldCarCustomerName = oldCarCustomerName;
        this.oldCarCustomerIphone = oldCarCustomerIphone;
        this.oldCarModelDescribe = oldCarModelDescribe;
        this.createdPersonName = createdPersonName;
        this.exCreatedDte = exCreatedDte;
        this.exApprovalDateEnd = exApprovalDateEnd;
        this.approvalDateEnd = approvalDateEnd;
        this.businessClassify = businessClassify;
        this.reportingDateEnd = reportingDateEnd;
        this.rightsIssueSign = rightsIssueSign;
        this.oldCarConfirmSign = oldCarConfirmSign;
        this.approvalStatus = approvalStatus;
    }

    /**
     * 获取
     * @return replacementId
     */
    public Long getReplacementId() {
        return replacementId;
    }

    /**
     * 设置
     * @param replacementId
     */
    public void setReplacementId(Long replacementId) {
        this.replacementId = replacementId;
    }

    /**
     * 获取
     * @return reservationId
     */
    public Long getReservationId() {
        return reservationId;
    }

    /**
     * 设置
     * @param reservationId
     */
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * 获取
     * @return customerId
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 设置
     * @param customerId
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
     * @return makeOrderPersonId
     */
    public String getMakeOrderPersonId() {
        return makeOrderPersonId;
    }

    /**
     * 设置
     * @param makeOrderPersonId
     */
    public void setMakeOrderPersonId(String makeOrderPersonId) {
        this.makeOrderPersonId = makeOrderPersonId;
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
     * @return businessType
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 设置
     * @param businessType
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取
     * @return flag
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * 设置
     * @param flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 设置
     * @param storeName
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * 获取
     * @return businessOrderNo
     */
    public String getBusinessOrderNo() {
        return businessOrderNo;
    }

    /**
     * 设置
     * @param businessOrderNo
     */
    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }

    /**
     * 获取
     * @return oldCarCustomerName
     */
    public String getOldCarCustomerName() {
        return oldCarCustomerName;
    }

    /**
     * 设置
     * @param oldCarCustomerName
     */
    public void setOldCarCustomerName(String oldCarCustomerName) {
        this.oldCarCustomerName = oldCarCustomerName;
    }

    /**
     * 获取
     * @return oldCarCustomerIphone
     */
    public String getOldCarCustomerIphone() {
        return oldCarCustomerIphone;
    }

    /**
     * 设置
     * @param oldCarCustomerIphone
     */
    public void setOldCarCustomerIphone(String oldCarCustomerIphone) {
        this.oldCarCustomerIphone = oldCarCustomerIphone;
    }

    /**
     * 获取
     * @return oldCarModelDescribe
     */
    public String getOldCarModelDescribe() {
        return oldCarModelDescribe;
    }

    /**
     * 设置
     * @param oldCarModelDescribe
     */
    public void setOldCarModelDescribe(String oldCarModelDescribe) {
        this.oldCarModelDescribe = oldCarModelDescribe;
    }

    /**
     * 获取
     * @return createdPersonName
     */
    public String getCreatedPersonName() {
        return createdPersonName;
    }

    /**
     * 设置
     * @param createdPersonName
     */
    public void setCreatedPersonName(String createdPersonName) {
        this.createdPersonName = createdPersonName;
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

    /**
     * 获取
     * @return approvalDateEnd
     */
    public String getApprovalDateEnd() {
        return approvalDateEnd;
    }

    /**
     * 设置
     * @param approvalDateEnd
     */
    public void setApprovalDateEnd(String approvalDateEnd) {
        this.approvalDateEnd = approvalDateEnd;
    }

    /**
     * 获取
     * @return businessClassify
     */
    public String getBusinessClassify() {
        return businessClassify;
    }

    /**
     * 设置
     * @param businessClassify
     */
    public void setBusinessClassify(String businessClassify) {
        this.businessClassify = businessClassify;
    }

    /**
     * 获取
     * @return reportingDateEnd
     */
    public Date getReportingDateEnd() {
        return reportingDateEnd;
    }

    /**
     * 设置
     * @param reportingDateEnd
     */
    public void setReportingDateEnd(Date reportingDateEnd) {
        this.reportingDateEnd = reportingDateEnd;
    }

    /**
     * 获取
     * @return rightsIssueSign
     */
    public String getRightsIssueSign() {
        return rightsIssueSign;
    }

    /**
     * 设置
     * @param rightsIssueSign
     */
    public void setRightsIssueSign(String rightsIssueSign) {
        this.rightsIssueSign = rightsIssueSign;
    }

    /**
     * 获取
     * @return oldCarConfirmSign
     */
    public String getOldCarConfirmSign() {
        return oldCarConfirmSign;
    }

    /**
     * 设置
     * @param oldCarConfirmSign
     */
    public void setOldCarConfirmSign(String oldCarConfirmSign) {
        this.oldCarConfirmSign = oldCarConfirmSign;
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

    public String toString() {
        return "RepReplacementApprovalExportDto{serialVersionUID = " + serialVersionUID + ", replacementId = " + replacementId + ", reservationId = " + reservationId + ", customerId = " + customerId + ", storeId = " + storeId + ", makeOrderPersonId = " + makeOrderPersonId + ", makeOrderPersonName = " + makeOrderPersonName + ", businessType = " + businessType + ", flag = " + flag + ", storeName = " + storeName + ", businessOrderNo = " + businessOrderNo + ", oldCarCustomerName = " + oldCarCustomerName + ", oldCarCustomerIphone = " + oldCarCustomerIphone + ", oldCarModelDescribe = " + oldCarModelDescribe + ", createdPersonName = " + createdPersonName + ", exCreatedDte = " + exCreatedDte + ", exApprovalDateEnd = " + exApprovalDateEnd + ", approvalDateEnd = " + approvalDateEnd + ", businessClassify = " + businessClassify + ", reportingDateEnd = " + reportingDateEnd + ", rightsIssueSign = " + rightsIssueSign + ", oldCarConfirmSign = " + oldCarConfirmSign + ", approvalStatus = " + approvalStatus + "}";
    }
}
