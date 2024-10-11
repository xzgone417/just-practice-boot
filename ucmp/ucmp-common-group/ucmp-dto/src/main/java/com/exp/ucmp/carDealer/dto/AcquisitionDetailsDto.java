package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.PsiAcquisitionMaterialEntity;
import com.exp.ucmp.entity.PsiAcquisitionMaterialFileEntity;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 收购详情展示
 * @date 2022/10/19 10:39
 */
public class AcquisitionDetailsDto extends BaseModel {

    private static final long serialVersionUID = -8647697324380683669L;

    /**
     * 预约ID
     */
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /**
     * 他品询价ID
     */
    @ApiModelProperty(value = "他品询价ID")
    private Long otherBrandInquiryId;

    /**
     * 材料状态：01、待上传，02、重新上传，03、已上传
     */
    @ApiModelProperty(value = "材料状态：01、待上传，02、重新上传，03、已上传")
    private String materialStatus;

    /**
     * 预计过户时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "预计过户时间")
    private Date estimatedTransferTime;

    /**
     * 最终成交价
     */
    @ApiModelProperty(value = "最终成交价")
    private Long dealPriceEnd;

    /**
     * 发票号
     */
    @ApiModelProperty(value = "发票号")
    private String invoiceNum;

    /**
     * 支付方式
     */
    @ApiModelProperty(value = "支付方式")
    private String payType;

    /**
     * 文件列表
     */
    @ApiModelProperty(value = "文件类型列表")
    private List<AcquisitionAllFileDto> fileList;

    public AcquisitionDetailsDto() {
    }

    public AcquisitionDetailsDto(Long reservationId, Long otherBrandInquiryId, String materialStatus, Date estimatedTransferTime, Long dealPriceEnd, String invoiceNum, String payType, List<AcquisitionAllFileDto> fileList) {
        this.reservationId = reservationId;
        this.otherBrandInquiryId = otherBrandInquiryId;
        this.materialStatus = materialStatus;
        this.estimatedTransferTime = estimatedTransferTime;
        this.dealPriceEnd = dealPriceEnd;
        this.invoiceNum = invoiceNum;
        this.payType = payType;
        this.fileList = fileList;
    }

    /**
     * 获取
     * @return reservationId
     */
    public Long getReservationId() {
        return reservationId;
    }

    /**
     * 设置
     * @param reservationId
     */
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * 获取
     * @return otherBrandInquiryId
     */
    public Long getOtherBrandInquiryId() {
        return otherBrandInquiryId;
    }

    /**
     * 设置
     * @param otherBrandInquiryId
     */
    public void setOtherBrandInquiryId(Long otherBrandInquiryId) {
        this.otherBrandInquiryId = otherBrandInquiryId;
    }

    /**
     * 获取
     * @return materialStatus
     */
    public String getMaterialStatus() {
        return materialStatus;
    }

    /**
     * 设置
     * @param materialStatus
     */
    public void setMaterialStatus(String materialStatus) {
        this.materialStatus = materialStatus;
    }

    /**
     * 获取
     * @return estimatedTransferTime
     */
    public Date getEstimatedTransferTime() {
        return estimatedTransferTime;
    }

    /**
     * 设置
     * @param estimatedTransferTime
     */
    public void setEstimatedTransferTime(Date estimatedTransferTime) {
        this.estimatedTransferTime = estimatedTransferTime;
    }

    /**
     * 获取
     * @return dealPriceEnd
     */
    public Long getDealPriceEnd() {
        return dealPriceEnd;
    }

    /**
     * 设置
     * @param dealPriceEnd
     */
    public void setDealPriceEnd(Long dealPriceEnd) {
        this.dealPriceEnd = dealPriceEnd;
    }

    /**
     * 获取
     * @return invoiceNum
     */
    public String getInvoiceNum() {
        return invoiceNum;
    }

    /**
     * 设置
     * @param invoiceNum
     */
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    /**
     * 获取
     * @return payType
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置
     * @param payType
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * 获取
     * @return fileList
     */
    public List<AcquisitionAllFileDto> getFileList() {
        return fileList;
    }

    /**
     * 设置
     * @param fileList
     */
    public void setFileList(List<AcquisitionAllFileDto> fileList) {
        this.fileList = fileList;
    }

    public String toString() {
        return "AcquisitionDetailsDto{reservationId = " + reservationId + ", otherBrandInquiryId = " + otherBrandInquiryId + ", materialStatus = " + materialStatus + ", estimatedTransferTime = " + estimatedTransferTime + ", dealPriceEnd = " + dealPriceEnd + ", invoiceNum = " + invoiceNum + ", payType = " + payType + ", fileList = " + fileList + "}";
    }
}
