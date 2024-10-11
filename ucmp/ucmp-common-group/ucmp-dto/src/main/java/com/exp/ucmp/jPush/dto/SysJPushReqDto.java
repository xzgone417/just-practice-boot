package com.exp.ucmp.jPush.dto;

import com.exp.ucmp.entity.SysJpushRecordEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author Dragon
 * @describe 极光推送参数
 * @date 2022年6月9日
 */
@ApiModel(value = "极光推送参数")
public class SysJPushReqDto implements Serializable {

    private static final long serialVersionUID = 2360050182274891013L;


    /**
     * 类型
     */
    @NotNull(message = "类型 不能是Null")
    @ApiModelProperty(value = "类型")
    private String type;

    /**
     * 关联ID
     */
    @ApiModelProperty(value = "关联ID")
    private String relevanceId;

    /**
     * 动态参数
     */
    @ApiModelProperty(value = "动态参数")
    private List<String> params;

    @ApiModelProperty(value = "员工号数组")
    @NotBlank(message = "员工号不能为空")
    private String[] alias;

    @ApiModelProperty(value = "跳转地址")
    private String url;

    @ApiModelProperty(value = "订单号")
    private String orderNum;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRelevanceId() {
        return relevanceId;
    }

    public void setRelevanceId(String relevanceId) {
        this.relevanceId = relevanceId;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public String[] getAlias() {
        return alias;
    }

    public void setAlias(String[] alias) {
        this.alias = alias;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

}
