package com.exp.ucmp.pricing.retail;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author GeYiJiang
 * @Description: 规则保存Dto
 * @date 2023/2/6 17:15
 */
@ApiModel(value = "RuleSaveDto", description = "规则保存")
public class RuleSaveDto extends BaseModel {

    @ApiModelProperty(value = "规则编号(不传)")
    private String ruleNumber;

    @ApiModelProperty(value = "规则名称",required = true)
    private String ruleName;

    @ApiModelProperty(value = "规则描述")
    private String ruleDescription;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "生效开始时间",required = true)
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "生效结束时间",required = true)
    private Date endTime;

    public String getRuleNumber() {
        return ruleNumber;
    }

    public void setRuleNumber(String ruleNumber) {
        this.ruleNumber = ruleNumber;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
