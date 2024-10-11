package com.exp.ucmp.iautos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarBrandDto", description = "品牌信息")
public class CarBrandDto implements Comparable<CarBrandDto>{
	
	@ApiModelProperty(value = "品牌ID")
	private String id;
	
	@ApiModelProperty(value = "品牌首字母")
	private String initial;
	
	@ApiModelProperty(value = "品牌名称")
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(CarBrandDto o) {
		//先按首字母排序
		if(this.initial.compareTo(o.getInitial())>0){
			return 1;
		}
		
		if(this.initial.compareTo(o.getInitial())<0){
			return -1;
		}
		//再按名称排序
		if(this.name.compareTo(o.getName())>0){
			return 1;
		}
		if(this.name.compareTo(o.getName())<0){
			return -1;
		}
		return 0;
	}
}
