package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * <p>@ClassName: SalesOrderMaterialDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/6 16:00<p>
 */
public class SalesOrderMaterialDto {
    /**
     * 订单信息id
     */
    @ApiModelProperty(value = "订单信息id")
    private Long orderInfoId;
    /**
     * 交付中心
     */
    @ApiModelProperty(value = "交付中心")
    private Long deliveryStore;

    /**
     * 交付中心名称
     */
    @ApiModelProperty(value = "交付中心名称")
    private String deliveryStoreName;

    /**
     * 材料信息
     */
    @ApiModelProperty(value = "材料信息")
    private List<OrderMaterial> orderMaterialList;

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Long getDeliveryStore() {
        return deliveryStore;
    }

    public void setDeliveryStore(Long deliveryStore) {
        this.deliveryStore = deliveryStore;
    }

    public String getDeliveryStoreName() {
        return deliveryStoreName;
    }

    public void setDeliveryStoreName(String deliveryStoreName) {
        this.deliveryStoreName = deliveryStoreName;
    }

    public List<OrderMaterial> getOrderMaterialList() {
        return orderMaterialList;
    }

    public void setOrderMaterialList(List<OrderMaterial> orderMaterialList) {
        this.orderMaterialList = orderMaterialList;
    }

    public static class OrderMaterial {

        /**
         * 材料ID
         */
        @ApiModelProperty(value = "材料ID")
        private Long materialId;


        /**
         * 销售订单ID
         */
        @ApiModelProperty(value = "销售订单ID")
        private Long orderInfoId;

        /**
         * 材料类型
         */
        @ApiModelProperty(value = "材料类型")
        private String materialType;

        /**
         * 上传人
         */
        @ApiModelProperty(value = "上传人")
        private Long uploadPerson;

        /**
         * 上传时间
         */
        @ApiModelProperty(value = "上传时间")
        private Date uploadDate;

        public Long getMaterialId() {
            return materialId;
        }

        public void setMaterialId(Long materialId) {
            this.materialId = materialId;
        }

        public Long getOrderInfoId() {
            return orderInfoId;
        }

        public void setOrderInfoId(Long orderInfoId) {
            this.orderInfoId = orderInfoId;
        }

        public String getMaterialType() {
            return materialType;
        }

        public void setMaterialType(String materialType) {
            this.materialType = materialType;
        }

        public Long getUploadPerson() {
            return uploadPerson;
        }

        public void setUploadPerson(Long uploadPerson) {
            this.uploadPerson = uploadPerson;
        }

        public Date getUploadDate() {
            return uploadDate;
        }

        public void setUploadDate(Date uploadDate) {
            this.uploadDate = uploadDate;
        }
    }
}
