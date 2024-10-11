package com.exp.ucmp.carDealer.util.excel.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 测试表格导入实体
 */
public class CarStockInfoImportExcelEntity implements Serializable{

    @ExcelProperty("批次")
    private String sourceBatch;

    @ExcelProperty("车架号")
    private String vinCode;

    @ExcelProperty("车辆主体")
    private String revertBody;

    @ExcelProperty("车辆类型")
    private String carType;

    @ExcelProperty("车辆使用性质")
    private String carNature;

    @ExcelProperty("采购价格")
    private String purchasePriceStr;

    @ExcelProperty("牌照属地")
    private String licensePlace;

    @ExcelProperty("牌照号")
    private String licenseNumber;

    @ExcelProperty("车辆所属仓储点编码")
    private String storageCode;

    @ExcelProperty("首次上牌时间")
    private String firstLicenseDateStr;

    @ExcelProperty("交强险到期日")
    private String accidentInsuranceEndDateStr;

    @ExcelProperty("年检到期日")
    private String yearlyInspectionEndDateStr;

    @ExcelProperty("新车开票日")
    private String invoicingDateStr;

    @ExcelProperty("过户次数")
    private String transferCountStr;
    
    @ExcelProperty("公司代码")
    private String companyCode;

    @ExcelIgnore
    private Date firstLicenseDate;
    @ExcelIgnore
    private Date accidentInsuranceEndDate;
    @ExcelIgnore
    private Date yearlyInspectionEndDate;
    @ExcelIgnore
    private Date invoicingDate;
    @ExcelIgnore
    private Integer transferCount;

    @ExcelIgnore
    private BigDecimal purchasePrice;

    public String getSourceBatch() {
        return sourceBatch;
    }

    public void setSourceBatch(String sourceBatch) {
        this.sourceBatch = sourceBatch;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getRevertBody() {
        return revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarNature() {
        return carNature;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setCarNature(String carNature) {
        this.carNature = carNature;
    }

    public String getPurchasePriceStr() {
        return purchasePriceStr;
    }

    public void setPurchasePriceStr(String purchasePriceStr) {
        this.purchasePriceStr = purchasePriceStr;
    }

    public String getLicensePlace() {
        return licensePlace;
    }

    public void setLicensePlace(String licensePlace) {
        this.licensePlace = licensePlace;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }


    public String getTransferCountStr() {
        return transferCountStr;
    }

    public void setTransferCountStr(String transferCountStr) {
        this.transferCountStr = transferCountStr;
    }

    public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getFirstLicenseDateStr() {
        return firstLicenseDateStr;
    }

    public void setFirstLicenseDateStr(String firstLicenseDateStr) {
        this.firstLicenseDateStr = firstLicenseDateStr;
    }



    public Date getFirstLicenseDate() {
        return firstLicenseDate;
    }

    public void setFirstLicenseDate(Date firstLicenseDate) {
        this.firstLicenseDate = firstLicenseDate;
    }

    public String getAccidentInsuranceEndDateStr() {
        return accidentInsuranceEndDateStr;
    }

    public void setAccidentInsuranceEndDateStr(String accidentInsuranceEndDateStr) {
        this.accidentInsuranceEndDateStr = accidentInsuranceEndDateStr;
    }

    public String getYearlyInspectionEndDateStr() {
        return yearlyInspectionEndDateStr;
    }

    public void setYearlyInspectionEndDateStr(String yearlyInspectionEndDateStr) {
        this.yearlyInspectionEndDateStr = yearlyInspectionEndDateStr;
    }

    public String getInvoicingDateStr() {
        return invoicingDateStr;
    }

    public void setInvoicingDateStr(String invoicingDateStr) {
        this.invoicingDateStr = invoicingDateStr;
    }

    public Integer getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(Integer transferCount) {
        this.transferCount = transferCount;
    }

    public Date getAccidentInsuranceEndDate() {
        return accidentInsuranceEndDate;
    }

    public void setAccidentInsuranceEndDate(Date accidentInsuranceEndDate) {
        this.accidentInsuranceEndDate = accidentInsuranceEndDate;
    }

    public Date getYearlyInspectionEndDate() {
        return yearlyInspectionEndDate;
    }

    public void setYearlyInspectionEndDate(Date yearlyInspectionEndDate) {
        this.yearlyInspectionEndDate = yearlyInspectionEndDate;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public Date getInvoicingDate() {
        return invoicingDate;
    }

    public void setInvoicingDate(Date invoicingDate) {
        this.invoicingDate = invoicingDate;
    }
}
