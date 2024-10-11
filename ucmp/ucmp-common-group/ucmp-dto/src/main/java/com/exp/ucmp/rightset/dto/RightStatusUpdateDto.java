package com.exp.ucmp.rightset.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/11/22 9:45
 */
@ApiModel(value = "RightStatusUpdateDto", description = "更新活动状态入参")
public class RightStatusUpdateDto extends BaseModel {

    /**
     * 权益活动ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "权益活动ID")
    private Long rightId;

    public RightStatusUpdateDto() {
    }

    public RightStatusUpdateDto(Long rightId) {
        this.rightId = rightId;
    }

    /**
     * 获取
     * @return rightId
     */
    public Long getRightId() {
        return rightId;
    }

    /**
     * 设置
     * @param rightId
     */
    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }

    public String toString() {
        return "RightStatusUpdateDto{rightId = " + rightId + "}";
    }
}
