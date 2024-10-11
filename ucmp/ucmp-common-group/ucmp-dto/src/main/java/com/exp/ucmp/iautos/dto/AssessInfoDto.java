package com.exp.ucmp.iautos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssessInfoDto", description = "估价信息类")
public class AssessInfoDto {
	
	@ApiModelProperty(value = "记录id")
	private Integer id;
	
	@ApiModelProperty(value = "车型id")
    private Integer modelId;
	
	@ApiModelProperty(value = "车型名称")
    private String modelName;
	
	@ApiModelProperty(value = "指导价/万元")
    private double guidePrice;
	
	@ApiModelProperty(value = "上牌时间(yyyy-MM)")
    private String firstRegDate;
	
	@ApiModelProperty(value = "里程/公里")
    private double km;
	
	@ApiModelProperty(value = "上牌城市行政编码")
    private String adcode;
	
	@ApiModelProperty(value = "上牌城市名称")
    private String city;
	
	@ApiModelProperty(value = "用户手机号")
    private String phone;
	
	@ApiModelProperty(value = "最低收购价/万元")
    private double resBuyPriceLow;
	
	@ApiModelProperty(value = "最高收购价/万元")
    private double resBuyPriceHigh;
	
	@ApiModelProperty(value = "评估来源(C0008-高合小程序 C0051-高合APP)")
    private String source;
	
	@ApiModelProperty(value = "评估时间(yyyy-MM-dd HH:mm:ss)")
    private String createTime;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public double getGuidePrice() {
		return guidePrice;
	}

	public void setGuidePrice(double guidePrice) {
		this.guidePrice = guidePrice;
	}

	public String getFirstRegDate() {
		return firstRegDate;
	}

	public void setFirstRegDate(String firstRegDate) {
		this.firstRegDate = firstRegDate;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public String getAdcode() {
		return adcode;
	}

	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getResBuyPriceLow() {
		return resBuyPriceLow;
	}

	public void setResBuyPriceLow(double resBuyPriceLow) {
		this.resBuyPriceLow = resBuyPriceLow;
	}

	public double getResBuyPriceHigh() {
		return resBuyPriceHigh;
	}

	public void setResBuyPriceHigh(double resBuyPriceHigh) {
		this.resBuyPriceHigh = resBuyPriceHigh;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
