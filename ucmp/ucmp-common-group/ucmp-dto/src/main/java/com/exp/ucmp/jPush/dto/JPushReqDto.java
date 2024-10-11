package com.exp.ucmp.jPush.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author Dragon
 * @describe 极光推送参数
 * @date 2022年6月9日
 */
@ApiModel(value = "极光推送参数")
public class JPushReqDto implements Serializable {

    private static final long serialVersionUID = 2360050182274891013L;

    @ApiModelProperty(value = "员工号数组")
    @NotBlank(message = "员工号不能为空")
    private String[] alias;

    @ApiModelProperty(value = "标题")
    @NotBlank(message = "标题不能为空")
    private String title;

    @ApiModelProperty(value = "消息")
    @NotBlank(message = "消息不能为空")
    private String msg;

    @ApiModelProperty(value = "跳转地址")
    private String url;

    @ApiModelProperty(value = "订单号")
    private String orderNum;
    
    @ApiModelProperty(value = "消息模板id")
    private Long jPushtemplateId;
    
    @ApiModelProperty(value = "模板类型")
    private String type;
    
    @ApiModelProperty(value = "业务id")
    private Long relevanceId;
    
    @ApiModelProperty(value = "动态参数，按照模板对应顺序一次排序，逗号隔开")
    private String params;

    public String[] getAlias() {
        return alias;
    }

    public void setAlias(String[] alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

	public Long getjPushtemplateId() {
		return jPushtemplateId;
	}

	public void setjPushtemplateId(Long jPushtemplateId) {
		this.jPushtemplateId = jPushtemplateId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getRelevanceId() {
		return relevanceId;
	}

	public void setRelevanceId(Long relevanceId) {
		this.relevanceId = relevanceId;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
