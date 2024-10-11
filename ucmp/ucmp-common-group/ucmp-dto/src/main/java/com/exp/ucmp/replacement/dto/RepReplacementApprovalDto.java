package com.exp.ucmp.replacement.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepReplacementApprovalDto", description = "置换审批入参")
public class RepReplacementApprovalDto extends PageDto {

    private static final long serialVersionUID = 1L;


    public enum markStatus{
        usedCarConfirmation,
        approved
    }

    /**
     * 导出标识
     */
    @ApiModelProperty(value = "usedCarConfirmation 旧车确认,\n" +
            "        approved 审批\n")
    private String mark;

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

    @ApiModelProperty(value = "员工id")
    private Long partyId;
    
    @ApiModelProperty(value = "业务编号")
    private String businessOrderNo;
    
    @ApiModelProperty(value = "vin码")
    private String vinCode;
    
    @ApiModelProperty(value = "车牌号")
    private String licensePlateNum;

   @ApiModelProperty(value = "业务类型：01、他品，02、本品")
    private String businessType;

    @ApiModelProperty(value = "业务标识：1601、置换，1602、销售")
    private String businessLogo;

    @ApiModelProperty(value = "旧车客户姓名")
    private String oldCarCustomerName;

    @ApiModelProperty(value = "旧车客户手机号")
    private String oldCarCustomerIphone;

    //    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "审批开始时间")
    private String approvalDateStart;

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "审批结束时间")
    private String  approvalDateEnd;

    @ApiModelProperty(value = "创建人姓名")
    private String makeOrderPersonName;

    @ApiModelProperty(value = "审批状态1301\t待确认\n" +
            "1302\t确认通过\n" +
            "1303\t待审批\n" +
            "1304\t审批通过\n" +
            "1305\t驳回\n" +
            "1309\t关闭")
    private String approvalStatus;

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建开始时间")
    private String createdDateStart;

//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建结束时间")
    private String createdDateEnd;

    public RepReplacementApprovalDto() {
    }
    
    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    /**
     * 获取
     * @return mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * 设置
     * @param mark
     */
    public void setMark(String mark) {
        this.mark = mark;
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

    public String getBusinessLogo() {
        return businessLogo;
    }

    public void setBusinessLogo(String businessLogo) {
        this.businessLogo = businessLogo;
    }

    public String getOldCarCustomerName() {
        return oldCarCustomerName;
    }

    public void setOldCarCustomerName(String oldCarCustomerName) {
        this.oldCarCustomerName = oldCarCustomerName;
    }

    public String getOldCarCustomerIphone() {
        return oldCarCustomerIphone;
    }

    public void setOldCarCustomerIphone(String oldCarCustomerIphone) {
        this.oldCarCustomerIphone = oldCarCustomerIphone;
    }

    public String getApprovalDateStart() {
        return approvalDateStart;
    }

    public void setApprovalDateStart(String approvalDateStart) {
        this.approvalDateStart = approvalDateStart;
    }

    public String getApprovalDateEnd() {
        return approvalDateEnd;
    }

    public void setApprovalDateEnd(String approvalDateEnd) {
        this.approvalDateEnd = approvalDateEnd;
    }

    public String getMakeOrderPersonName() {
        return makeOrderPersonName;
    }

    public void setMakeOrderPersonName(String makeOrderPersonName) {
        this.makeOrderPersonName = makeOrderPersonName;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getCreatedDateStart() {
        return createdDateStart;
    }

    public void setCreatedDateStart(String createdDateStart) {
        this.createdDateStart = createdDateStart;
    }

    public String getCreatedDateEnd() {
        return createdDateEnd;
    }

    public void setCreatedDateEnd(String createdDateEnd) {
        this.createdDateEnd = createdDateEnd;
    }

	public String getBusinessOrderNo() {
		return businessOrderNo;
	}

	public void setBusinessOrderNo(String businessOrderNo) {
		this.businessOrderNo = businessOrderNo;
	}

	public String getVinCode() {
		return vinCode;
	}

	public void setVinCode(String vinCode) {
		this.vinCode = vinCode;
	}

	public String getLicensePlateNum() {
		return licensePlateNum;
	}

	public void setLicensePlateNum(String licensePlateNum) {
		this.licensePlateNum = licensePlateNum;
	}
}
