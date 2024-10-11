package com.exp.ucmp.usc.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuestionDto", description = "评价问题类")
public class QuestionDto {
	
	@ApiModelProperty(value = "问题选项")
	private AnswerOptionDto answerOption;
	
	@ApiModelProperty(value = "问题选项及用户答案列表")
    private List<AnswerOptionListDto> answerOptionList;
	
	@ApiModelProperty(value = "问题")
    private String conent;
	
	@ApiModelProperty(value = "创建时间")
    private long createTime;
	
	@ApiModelProperty(value = "逻辑删除")
    private boolean deleted;
	
	@ApiModelProperty(value = "主键")
    private long evaluateCategoryQuestionId;
	
	@ApiModelProperty(value = "状态 0：停用，1：启用，2：待启用")
    private int status;
	
	@ApiModelProperty(value = "问题类型 SINGLE:单选，MULTIPLE:多选, NPS:nps问题")
    private String type;
	
	@ApiModelProperty(value = "修改时间")
    private long updateTime;
	
    private String evaluateCategoryId;

	public AnswerOptionDto getAnswerOption() {
		return answerOption;
	}

	public void setAnswerOption(AnswerOptionDto answerOption) {
		this.answerOption = answerOption;
	}

	public List<AnswerOptionListDto> getAnswerOptionList() {
		return answerOptionList;
	}

	public void setAnswerOptionList(List<AnswerOptionListDto> answerOptionList) {
		this.answerOptionList = answerOptionList;
	}

	public String getConent() {
		return conent;
	}

	public void setConent(String conent) {
		this.conent = conent;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public long getEvaluateCategoryQuestionId() {
		return evaluateCategoryQuestionId;
	}

	public void setEvaluateCategoryQuestionId(long evaluateCategoryQuestionId) {
		this.evaluateCategoryQuestionId = evaluateCategoryQuestionId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public String getEvaluateCategoryId() {
		return evaluateCategoryId;
	}

	public void setEvaluateCategoryId(String evaluateCategoryId) {
		this.evaluateCategoryId = evaluateCategoryId;
	}
	
}
