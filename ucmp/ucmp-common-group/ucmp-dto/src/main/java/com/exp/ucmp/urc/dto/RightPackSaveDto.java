package com.exp.ucmp.urc.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RightPackSaveDto", description = "权益包创建参数类")
public class RightPackSaveDto {
	
	@ApiModelProperty(value = "权益活动主键")
	private String campaignId;
	
	@ApiModelProperty(value = "权益活动名称")
    private String campaignName;
	
	@NotNull(message="rightList不能为空")
	@ApiModelProperty(value = "权益ID列表集合")
    private List<Long> rightList;
	
	@ApiModelProperty(value = "发放说明")
    private String memo;
	
	@NotNull(message="type不能为空")
	@ApiModelProperty(value = "权益包类型 0:购车类、1:服务包、2:更新升级 类、3:触达类、4:商城购买、5:二 手车（非新车销售）、6:二手车（用户过户）、7:售后Goodwill、8:售后用户活动、9:用户运营、11置换业务")
    private Integer type;
	
	@ApiModelProperty(value = "生效日期")
    private String effectTime;
	
	@ApiModelProperty(value = "失效日期")
    private String expireTime;
	
	@NotNull(message="timeless不能为空")
	@ApiModelProperty(value = "是否限时 0不限、1限期、2区间时间")
    private Integer timeless;
	
	@ApiModelProperty(value = "生效后有效期")
    private Long deadline;

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public List<Long> getRightList() {
		return rightList;
	}

	public void setRightList(List<Long> rightList) {
		this.rightList = rightList;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(String effectTime) {
		this.effectTime = effectTime;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

	public Integer getTimeless() {
		return timeless;
	}

	public void setTimeless(Integer timeless) {
		this.timeless = timeless;
	}

	public Long getDeadline() {
		return deadline;
	}

	public void setDeadline(Long deadline) {
		this.deadline = deadline;
	}
	
}
