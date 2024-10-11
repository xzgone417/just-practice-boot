package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: CluesTransferenceDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/20 12:33<p>
 */

@ApiModel(value = "CluesTransferenceDto", description = "线索转让")
public class CluesTransferenceDto {
    @ApiModelProperty("线索id")
    private Long cluesId;


    @ApiModelProperty("跟进门店")
    private Long followStore;

    @ApiModelProperty("跟进人")
    private Long followPerson;

    public Long getCluesId() {
        return cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }

    public Long getFollowStore() {
        return followStore;
    }

    public void setFollowStore(Long followStore) {
        this.followStore = followStore;
    }

    public Long getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(Long followPerson) {
        this.followPerson = followPerson;
    }
}
