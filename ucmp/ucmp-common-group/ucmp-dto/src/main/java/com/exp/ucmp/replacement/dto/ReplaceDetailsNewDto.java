package com.exp.ucmp.replacement.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.exp.ucmp.entity.PsiOrderReceivingRecordEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReplaceDetailsNewDto", description = "本品置换单详情实体类")
public class ReplaceDetailsNewDto {
	
	@ApiModelProperty(value = "门店名称")
    private String orgName;
	
	@ApiModelProperty(value = "顾问姓名")
	private String userName;
	
	@ApiModelProperty(value = "客户姓名")
	private String customerName;
	
	@ApiModelProperty(value = "客户手机号")
	private String customerIphone;
	
	@ApiModelProperty(value = "派单人")
    private String allotPerson;
    
    @ApiModelProperty(value = "派单人ID")
    private String allotPersonId;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "预约检测时间")
    private Date reservationDetectionDate;
    
    @ApiModelProperty(value = "本品收车交付中心ID")
    private Long acquisitionStoreId;
    
    @ApiModelProperty(value = "本品收车交付中心名称")
    private String acquisitionStoreName;
    
    @ApiModelProperty(value = "业务类型：0401、他品，0402、本品")
    private String businessType;
    
    @ApiModelProperty(value = "收购人员ID")
    private Long acquirerId;
    
    @ApiModelProperty(value = "收购人员姓名")
    private String acquirerName;
    
    @ApiModelProperty(value = "战败标记(1-战败 0-未战败)")
    private Integer isDefeat;
    
    @ApiModelProperty(value = "置换单状态码 0701:待分配车商, 0901:待接单,0911:他品-待报价/本品-待评估,0921:待收购,0922:待过户,"
    		+ "1301、1303:待审批,1305:审批驳回,1302、1304:审批通过,0909:放弃接单,0918:逾期未报价,0919、0929:战败,1309:审批关闭")
    private String approvalStatus;
    
    @ApiModelProperty(value = "置换单状态名称 ")
    private String approvalName;
    
    @ApiModelProperty(value = "权益发放标志：01、发放，02、不发放 ")
    private String rightsIssueSign;
	
	@ApiModelProperty(value = "旧车信息")
	private OldCarInfoDto oldCarInfoDto;
	
	@ApiModelProperty(value = "新车信息")
	private PsiNewCarOrderDto newCarOrderDto;
	
	@ApiModelProperty(value = "接单记录")
	private List<PsiOrderReceivingRecordEntity> takeOrdersDto;
	
	@ApiModelProperty(value = "报价记录")
	private List<PsiOrderReceivingRecordEntity> quoteRecordDto;
	
	@ApiModelProperty(value = "收购记录")
	private List<PsiOrderReceivingRecordEntity> acquisitionRecordDto;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getReservationDetectionDate() {
		return reservationDetectionDate;
	}

	public void setReservationDetectionDate(Date reservationDetectionDate) {
		this.reservationDetectionDate = reservationDetectionDate;
	}

	public Long getAcquisitionStoreId() {
		return acquisitionStoreId;
	}

	public void setAcquisitionStoreId(Long acquisitionStoreId) {
		this.acquisitionStoreId = acquisitionStoreId;
	}

	public String getAcquisitionStoreName() {
		return acquisitionStoreName;
	}

	public void setAcquisitionStoreName(String acquisitionStoreName) {
		this.acquisitionStoreName = acquisitionStoreName;
	}

	public Long getAcquirerId() {
		return acquirerId;
	}

	public void setAcquirerId(Long acquirerId) {
		this.acquirerId = acquirerId;
	}

	public String getAcquirerName() {
		return acquirerName;
	}

	public void setAcquirerName(String acquirerName) {
		this.acquirerName = acquirerName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public Integer getIsDefeat() {
		return isDefeat;
	}

	public void setIsDefeat(Integer isDefeat) {
		this.isDefeat = isDefeat;
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

	public String getRightsIssueSign() {
		return rightsIssueSign;
	}

	public void setRightsIssueSign(String rightsIssueSign) {
		this.rightsIssueSign = rightsIssueSign;
	}

	public OldCarInfoDto getOldCarInfoDto() {
		return oldCarInfoDto;
	}

	public void setOldCarInfoDto(OldCarInfoDto oldCarInfoDto) {
		this.oldCarInfoDto = oldCarInfoDto;
	}

	public PsiNewCarOrderDto getNewCarOrderDto() {
		return newCarOrderDto;
	}

	public void setNewCarOrderDto(PsiNewCarOrderDto newCarOrderDto) {
		this.newCarOrderDto = newCarOrderDto;
	}

	public List<PsiOrderReceivingRecordEntity> getTakeOrdersDto() {
		return takeOrdersDto;
	}

	public void setTakeOrdersDto(List<PsiOrderReceivingRecordEntity> takeOrdersDto) {
		this.takeOrdersDto = takeOrdersDto;
	}

	public List<PsiOrderReceivingRecordEntity> getQuoteRecordDto() {
		return quoteRecordDto;
	}

	public void setQuoteRecordDto(List<PsiOrderReceivingRecordEntity> quoteRecordDto) {
		this.quoteRecordDto = quoteRecordDto;
	}

	public List<PsiOrderReceivingRecordEntity> getAcquisitionRecordDto() {
		return acquisitionRecordDto;
	}

	public void setAcquisitionRecordDto(List<PsiOrderReceivingRecordEntity> acquisitionRecordDto) {
		this.acquisitionRecordDto = acquisitionRecordDto;
	}
	
}
