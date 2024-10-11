package com.exp.ucmp.iautos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarModelDto", description = "车型信息")
public class CarModelDto implements Comparable<CarModelDto>{
	
	@ApiModelProperty(value = "车型id")
	private String id;
	
	@ApiModelProperty(value = "车型名称")
	private String name;

	@ApiModelProperty(value = "排量")
	private String displacement;
	
	@ApiModelProperty(value = "指导价")
	private String price;
	
	@ApiModelProperty(value = "变速方式")
	private String transmissionType;
	
	@ApiModelProperty(value = "年款")
	private String versionYear;
	
	@ApiModelProperty(value = "款式发布月份")
	private String versionDate;
	
	@ApiModelProperty(value = "出厂时间")
	private String productionYear;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public String getVersionYear() {
		return versionYear;
	}

	public void setVersionYear(String versionYear) {
		this.versionYear = versionYear;
	}

	public String getVersionDate() {
		return versionDate;
	}

	public void setVersionDate(String versionDate) {
		this.versionDate = versionDate;
	}

	public String getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(String productionYear) {
		this.productionYear = productionYear;
	}

	@Override
	public int compareTo(CarModelDto o) {
		//先按名称排序
		if(this.name.compareTo(o.getName())>0){
			return 1;
		}
		if(this.name.compareTo(o.getName())<0){
			return -1;
		}
		
		//再按年款
		if(this.versionYear.compareTo(o.getName())>0){
			return 1;
		}
		if(this.versionYear.compareTo(o.getName())<0){
			return -1;
		}
		
		//再按款式发布月份
		if(this.versionDate.compareTo(o.getName())>0){
			return 1;
		}
		if(this.versionDate.compareTo(o.getName())<0){
			return -1;
		}
		
		//再按出厂时间
		if(this.productionYear.compareTo(o.getName())>0){
			return 1;
		}
		if(this.productionYear.compareTo(o.getName())<0){
			return -1;
		}
		return 0;
	}
	
}
