package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IspOrderMaintenanceItemsDto", description = "isp报价单申请返回类")
public class IspOrderPartsDto {
	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "配件名称")
    private String spName;
	
	@ApiModelProperty(value = "配件代码")
    private String spCode;
	
	@ApiModelProperty(value = "计量单位")
    private String measureUnit;
	
	@ApiModelProperty(value = "配件类型")
    private String spType;
	
	@ApiModelProperty(value = "替代件名称")
    private String spReplacementCode;
	
	@ApiModelProperty(value = "替代件代码")
    private String spReplacementName;
	
	@ApiModelProperty(value = "配件零售价（含税）")
    private Double spRetailIncluTaxPrice;
	
	@ApiModelProperty(value = "配件零售价（未税）")
    private Double spRetailExcluTaxPrice;
	
	@ApiModelProperty(value = "配件批售价（含税）")
    private String spMassSalesIncluTaxPrice;
	
	@ApiModelProperty(value = "配件批售价（未税）")
    private int spMassSalesExcluTaxPrice;
	
	@ApiModelProperty(value = "保修价")
    private String spClaimIncluTaxPrice;
	
	@ApiModelProperty(value = "配件采购价（含税）")
    private int spPurchaseIncluTaxPrice;
	
	@ApiModelProperty(value = "配件大类")
    private String spCategory;
	
	@ApiModelProperty(value = "是否是OEM")
    private int oemFlg;
	
	@ApiModelProperty(value = "安全库存")
    private Double safetyStock;
	
	@ApiModelProperty(value = "可用库存")
    private Double availableQuantity;
	
	@ApiModelProperty(value = "总库存")
    private String totalStock;
	
	@ApiModelProperty(value = "数量")
    private int amount;
	
	@ApiModelProperty(value = "总价")
    private Double totalPrice;
	
	@ApiModelProperty(value = "应收金额")
    private Double receivePrice;
	
	@ApiModelProperty(value = "是否出库")
    private boolean outRepo;
	
	@ApiModelProperty(value = "实际出库数量")
    private int outAmount;
	
	@ApiModelProperty(value = "已退库数量")
    private int returnAmount;
	
	@ApiModelProperty(value = "可退库存")
    private int canReturnAmount;
	
	@ApiModelProperty(value = "可出库存")
    private int canOutAmount;
	
	@ApiModelProperty(value = "折扣")
    private int discount;
	
	@ApiModelProperty(value = "关重件标识 0：是 1：不是")
    private int keySpFlg;
	
	@ApiModelProperty(value = "库位")
    private String repoLocation;
	
	@ApiModelProperty(value = "仓库名称")
    private String repoName;
	
	@ApiModelProperty(value = "费用区分，索赔，客户付费，内部结算、保险")
    private long feeDifferentiation;
	
	@ApiModelProperty(value = "费用区分中文")
    private String feeDifferentiationLabel;
	
	@ApiModelProperty(value = "concern号")
    private String concernCode;
	
	@ApiModelProperty(value = "组合代码")
    private String groupCode;
	
	@ApiModelProperty(value = "服务活动")
    private String activityNo;
	
	@ApiModelProperty(value = "0是内采的配件，1是外采的配件")
    private int dataFlg;
	
	@ApiModelProperty(value = "行号")
    private String posnr;
	
	@ApiModelProperty(value = "最后一次出库时间")
    private double lastOutRepoTime;
	
	@ApiModelProperty(value = "维修工时编码")
    private String maintenanceItemCode;
	
	@ApiModelProperty(value = "维修项目名称")
    private String maintenanceItemName;
	
	@ApiModelProperty(value = "折扣金额")
    private int discountMoney;
	
	@ApiModelProperty(value = "负工单退料标识：1是")
    private int returnMaterialFlg;
	
	@ApiModelProperty(value = "优惠金额")
    private String preferentialPrice;
	
	@ApiModelProperty(value = "销售价格")
    private Double salePrice;
	
	@ApiModelProperty(value = "适用车型")
    private String applicableModel;
	
	@ApiModelProperty(value = "自动索赔单号")
    private String autoClaimNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	public String getMeasureUnit() {
		return measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	public String getSpType() {
		return spType;
	}

	public void setSpType(String spType) {
		this.spType = spType;
	}

	public String getSpReplacementCode() {
		return spReplacementCode;
	}

	public void setSpReplacementCode(String spReplacementCode) {
		this.spReplacementCode = spReplacementCode;
	}

	public String getSpReplacementName() {
		return spReplacementName;
	}

	public void setSpReplacementName(String spReplacementName) {
		this.spReplacementName = spReplacementName;
	}

	public Double getSpRetailIncluTaxPrice() {
		return spRetailIncluTaxPrice;
	}

	public void setSpRetailIncluTaxPrice(Double spRetailIncluTaxPrice) {
		this.spRetailIncluTaxPrice = spRetailIncluTaxPrice;
	}

	public Double getSpRetailExcluTaxPrice() {
		return spRetailExcluTaxPrice;
	}

	public void setSpRetailExcluTaxPrice(Double spRetailExcluTaxPrice) {
		this.spRetailExcluTaxPrice = spRetailExcluTaxPrice;
	}

	public String getSpMassSalesIncluTaxPrice() {
		return spMassSalesIncluTaxPrice;
	}

	public void setSpMassSalesIncluTaxPrice(String spMassSalesIncluTaxPrice) {
		this.spMassSalesIncluTaxPrice = spMassSalesIncluTaxPrice;
	}

	public int getSpMassSalesExcluTaxPrice() {
		return spMassSalesExcluTaxPrice;
	}

	public void setSpMassSalesExcluTaxPrice(int spMassSalesExcluTaxPrice) {
		this.spMassSalesExcluTaxPrice = spMassSalesExcluTaxPrice;
	}

	public String getSpClaimIncluTaxPrice() {
		return spClaimIncluTaxPrice;
	}

	public void setSpClaimIncluTaxPrice(String spClaimIncluTaxPrice) {
		this.spClaimIncluTaxPrice = spClaimIncluTaxPrice;
	}

	public int getSpPurchaseIncluTaxPrice() {
		return spPurchaseIncluTaxPrice;
	}

	public void setSpPurchaseIncluTaxPrice(int spPurchaseIncluTaxPrice) {
		this.spPurchaseIncluTaxPrice = spPurchaseIncluTaxPrice;
	}

	public String getSpCategory() {
		return spCategory;
	}

	public void setSpCategory(String spCategory) {
		this.spCategory = spCategory;
	}

	public int getOemFlg() {
		return oemFlg;
	}

	public void setOemFlg(int oemFlg) {
		this.oemFlg = oemFlg;
	}

	public Double getSafetyStock() {
		return safetyStock;
	}

	public void setSafetyStock(Double safetyStock) {
		this.safetyStock = safetyStock;
	}

	public Double getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public String getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(String totalStock) {
		this.totalStock = totalStock;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getReceivePrice() {
		return receivePrice;
	}

	public void setReceivePrice(Double receivePrice) {
		this.receivePrice = receivePrice;
	}

	public boolean isOutRepo() {
		return outRepo;
	}

	public void setOutRepo(boolean outRepo) {
		this.outRepo = outRepo;
	}

	public int getOutAmount() {
		return outAmount;
	}

	public void setOutAmount(int outAmount) {
		this.outAmount = outAmount;
	}

	public int getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(int returnAmount) {
		this.returnAmount = returnAmount;
	}

	public int getCanReturnAmount() {
		return canReturnAmount;
	}

	public void setCanReturnAmount(int canReturnAmount) {
		this.canReturnAmount = canReturnAmount;
	}

	public int getCanOutAmount() {
		return canOutAmount;
	}

	public void setCanOutAmount(int canOutAmount) {
		this.canOutAmount = canOutAmount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getKeySpFlg() {
		return keySpFlg;
	}

	public void setKeySpFlg(int keySpFlg) {
		this.keySpFlg = keySpFlg;
	}

	public String getRepoLocation() {
		return repoLocation;
	}

	public void setRepoLocation(String repoLocation) {
		this.repoLocation = repoLocation;
	}

	public String getRepoName() {
		return repoName;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	public long getFeeDifferentiation() {
		return feeDifferentiation;
	}

	public void setFeeDifferentiation(long feeDifferentiation) {
		this.feeDifferentiation = feeDifferentiation;
	}

	public String getFeeDifferentiationLabel() {
		return feeDifferentiationLabel;
	}

	public void setFeeDifferentiationLabel(String feeDifferentiationLabel) {
		this.feeDifferentiationLabel = feeDifferentiationLabel;
	}

	public String getConcernCode() {
		return concernCode;
	}

	public void setConcernCode(String concernCode) {
		this.concernCode = concernCode;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getActivityNo() {
		return activityNo;
	}

	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
	}

	public int getDataFlg() {
		return dataFlg;
	}

	public void setDataFlg(int dataFlg) {
		this.dataFlg = dataFlg;
	}

	public String getPosnr() {
		return posnr;
	}

	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}

	public double getLastOutRepoTime() {
		return lastOutRepoTime;
	}

	public void setLastOutRepoTime(double lastOutRepoTime) {
		this.lastOutRepoTime = lastOutRepoTime;
	}

	public String getMaintenanceItemCode() {
		return maintenanceItemCode;
	}

	public void setMaintenanceItemCode(String maintenanceItemCode) {
		this.maintenanceItemCode = maintenanceItemCode;
	}

	public String getMaintenanceItemName() {
		return maintenanceItemName;
	}

	public void setMaintenanceItemName(String maintenanceItemName) {
		this.maintenanceItemName = maintenanceItemName;
	}

	public int getDiscountMoney() {
		return discountMoney;
	}

	public void setDiscountMoney(int discountMoney) {
		this.discountMoney = discountMoney;
	}

	public int getReturnMaterialFlg() {
		return returnMaterialFlg;
	}

	public void setReturnMaterialFlg(int returnMaterialFlg) {
		this.returnMaterialFlg = returnMaterialFlg;
	}

	public String getPreferentialPrice() {
		return preferentialPrice;
	}

	public void setPreferentialPrice(String preferentialPrice) {
		this.preferentialPrice = preferentialPrice;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public String getApplicableModel() {
		return applicableModel;
	}

	public void setApplicableModel(String applicableModel) {
		this.applicableModel = applicableModel;
	}

	public String getAutoClaimNo() {
		return autoClaimNo;
	}

	public void setAutoClaimNo(String autoClaimNo) {
		this.autoClaimNo = autoClaimNo;
	}

}
