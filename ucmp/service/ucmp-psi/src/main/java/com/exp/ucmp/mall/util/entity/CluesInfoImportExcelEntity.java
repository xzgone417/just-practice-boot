package com.exp.ucmp.mall.util.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;

/**
 * <p>@ClassName: entity</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/20 14:41<p>
 */
public class CluesInfoImportExcelEntity implements Serializable {

    @ExcelProperty(
            value = {"客户名称"},
            index = 0
    )
    private String customerName;
    @ExcelProperty(
            value = {"手机号"},
            index = 1
    )
    private String customerPhone;
    @ExcelProperty(
            value = {"意向交付地"},
            index = 2
    )
    private String deliveryPlace;

    @ExcelProperty(
            value = {"意向车型"},
            index = 3
    )
    private String shapeName;
    @ExcelProperty(
            value = {"vin"},
            index = 4
    )
    private String vin;

    /**
     * 加密手机号
     */
    @ExcelIgnore
    private String encryptionPhone;

    /**
     * 错误信息
     */
    @ExcelIgnore
    private String msg;



    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getEncryptionPhone() {
        return encryptionPhone;
    }

    public void setEncryptionPhone(String encryptionPhone) {
        this.encryptionPhone = encryptionPhone;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = this.msg + msg;
    }
}
