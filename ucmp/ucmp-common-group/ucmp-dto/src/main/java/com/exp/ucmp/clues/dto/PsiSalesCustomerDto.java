package com.exp.ucmp.clues.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <p>@ClassName: PsiSalesCustomerDto</p>
 * <p>@Description: 销售客户表</p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/20 15:56<p>
 */
@ApiModel(value = "PsiSalesCustomerDto", description = "销售客户表")
public class PsiSalesCustomerDto extends PageDto {
    /**
     * 客户手机号/客户姓名/意向VIN
     */
    @ApiModelProperty(value = "客户手机号/客户姓名/意向VIN")
    private String multiField;
    /**
     * 客户ID
     */
    @ApiModelProperty(value = "客户ID")
    private Long customerId;
    /**
     * 客户手机号
     */
    @ApiModelProperty(value = "客户手机号")
    private String customerPhone;
    /**
     * 客户手机号
     */
    @ApiModelProperty(value = "客户手机号")
    private List<String> customerPhoneList;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerName;
    /**
     * 意向VIN
     */
    @ApiModelProperty(value = "意向VIN")
    private String vin;

    public String getMultiField() {
        return multiField;
    }

    public void setMultiField(String multiField) {
        this.multiField = multiField;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<String> getCustomerPhoneList() {
        return customerPhoneList;
    }

    public void setCustomerPhoneList(List<String> customerPhoneList) {
        this.customerPhoneList = customerPhoneList;
    }
}
