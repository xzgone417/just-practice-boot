package com.exp.ucmp.carDealer.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/13 16:17
 */
public class InquiryStatusDto {

    @ApiModelProperty("询价单状态")
    private String inquiryStatus;

    @ApiModelProperty("数量")
    private Integer count;

    public InquiryStatusDto() {
    }

    public InquiryStatusDto(String inquiryStatus, Integer count) {
        this.inquiryStatus = inquiryStatus;
        this.count = count;
    }

    /**
     * 获取
     * @return inquiryStatus
     */
    public String getInquiryStatus() {
        return inquiryStatus;
    }

    /**
     * 设置
     * @param inquiryStatus
     */
    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    /**
     * 获取
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    public String toString() {
        return "InquiryStatusDto{inquiryStatus = " + inquiryStatus + ", count = " + count + "}";
    }
}
