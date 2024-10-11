package com.exp.ucmp.usc.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EvaluationDetailDto", description = "评价详情类")
public class EvaluationDetailDto {
	
	@ApiModelProperty(value = "业务单号")
    private String businessNo;
	
	@ApiModelProperty(value = "评价内容")
    private String content;
	
	@ApiModelProperty(value = "创建时间")
    private long createTime;
	
	@ApiModelProperty(value = "问卷")
    private EvaluateCategoryDto evaluateCategory;
	
	@ApiModelProperty(value = "主键")
    private String evaluateRecordId;
	
	@ApiModelProperty(value = "评价星级")
    private int level;
	
	@ApiModelProperty(value = "用户手机号")
    private String mobile;
	
	@ApiModelProperty(value = "用户昵称")
    private String nickName;
	
	@ApiModelProperty(value = "问题列表")
    private List<QuestionDto> questionList;
	
	@ApiModelProperty(value = "标签列表")
    private List<TagDto> tagList;
	
	@ApiModelProperty(value = "用户编号,用户唯一标识 URM-UID")
    private String userId;
	
	@ApiModelProperty(value = "车辆VIN码")
    private String vinNo;

    private String evaluateCategoryId;
    private String idmId;
    private String updateTime;
    private String deleted;
    private int statusNotificationSms;
    private int statusNotificationApp;
    private int status;
    private String startTime;
    private String endTime;
    private String image;
    private String video;
    private String cityName;
    private String servicePersonnelCode;
    private String servicePersonnelName;
    private String reward;
    private String materialCode;
    private String materialName;
    private String storeCode;
    private String storeName;
    private String serviceEndTime;
    private String cityCode;
    private String name;
    private String platForm;
    private String bigAreaCode;
    private String bigAreaName;
    private String tagBatchNo;
    private String questionBatchNo;
    private String stationId;
    private String stationName;
    private String equipmentId;
    private String statusReport;
    private String smsReceiptCode;
    private String smsId;
    private String statusForm;
    private String channelId;
    private String categoryName;
    private String parentCategoryName;
    private String formLink;
    
	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public EvaluateCategoryDto getEvaluateCategory() {
		return evaluateCategory;
	}

	public void setEvaluateCategory(EvaluateCategoryDto evaluateCategory) {
		this.evaluateCategory = evaluateCategory;
	}

	public String getEvaluateRecordId() {
		return evaluateRecordId;
	}

	public void setEvaluateRecordId(String evaluateRecordId) {
		this.evaluateRecordId = evaluateRecordId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public List<QuestionDto> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<QuestionDto> questionList) {
		this.questionList = questionList;
	}

	public List<TagDto> getTagList() {
		return tagList;
	}

	public void setTagList(List<TagDto> tagList) {
		this.tagList = tagList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public String getEvaluateCategoryId() {
		return evaluateCategoryId;
	}

	public void setEvaluateCategoryId(String evaluateCategoryId) {
		this.evaluateCategoryId = evaluateCategoryId;
	}

	public String getIdmId() {
		return idmId;
	}

	public void setIdmId(String idmId) {
		this.idmId = idmId;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public int getStatusNotificationSms() {
		return statusNotificationSms;
	}

	public void setStatusNotificationSms(int statusNotificationSms) {
		this.statusNotificationSms = statusNotificationSms;
	}

	public int getStatusNotificationApp() {
		return statusNotificationApp;
	}

	public void setStatusNotificationApp(int statusNotificationApp) {
		this.statusNotificationApp = statusNotificationApp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getServicePersonnelCode() {
		return servicePersonnelCode;
	}

	public void setServicePersonnelCode(String servicePersonnelCode) {
		this.servicePersonnelCode = servicePersonnelCode;
	}

	public String getServicePersonnelName() {
		return servicePersonnelName;
	}

	public void setServicePersonnelName(String servicePersonnelName) {
		this.servicePersonnelName = servicePersonnelName;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getServiceEndTime() {
		return serviceEndTime;
	}

	public void setServiceEndTime(String serviceEndTime) {
		this.serviceEndTime = serviceEndTime;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatForm() {
		return platForm;
	}

	public void setPlatForm(String platForm) {
		this.platForm = platForm;
	}

	public String getBigAreaCode() {
		return bigAreaCode;
	}

	public void setBigAreaCode(String bigAreaCode) {
		this.bigAreaCode = bigAreaCode;
	}

	public String getBigAreaName() {
		return bigAreaName;
	}

	public void setBigAreaName(String bigAreaName) {
		this.bigAreaName = bigAreaName;
	}

	public String getTagBatchNo() {
		return tagBatchNo;
	}

	public void setTagBatchNo(String tagBatchNo) {
		this.tagBatchNo = tagBatchNo;
	}

	public String getQuestionBatchNo() {
		return questionBatchNo;
	}

	public void setQuestionBatchNo(String questionBatchNo) {
		this.questionBatchNo = questionBatchNo;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getStatusReport() {
		return statusReport;
	}

	public void setStatusReport(String statusReport) {
		this.statusReport = statusReport;
	}

	public String getSmsReceiptCode() {
		return smsReceiptCode;
	}

	public void setSmsReceiptCode(String smsReceiptCode) {
		this.smsReceiptCode = smsReceiptCode;
	}

	public String getSmsId() {
		return smsId;
	}

	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}

	public String getStatusForm() {
		return statusForm;
	}

	public void setStatusForm(String statusForm) {
		this.statusForm = statusForm;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getParentCategoryName() {
		return parentCategoryName;
	}

	public void setParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
	}

	public String getFormLink() {
		return formLink;
	}

	public void setFormLink(String formLink) {
		this.formLink = formLink;
	}
	
}
