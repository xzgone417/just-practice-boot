package com.exp.ucmp.iautos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarSeriesDto", description = "车系信息")
public class CarSeriesDto implements Comparable<CarSeriesDto>{
	
	@ApiModelProperty(value = "车系id")
	private String id;
	
	@ApiModelProperty(value = "车系名称")
	private String name;

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

	@Override
	public int compareTo(CarSeriesDto o) {
		//名称排序
		if(this.name.compareTo(o.getName())>0){
			return 1;
		}
		if(this.name.compareTo(o.getName())<0){
			return -1;
		}
		return 0;
	}
}
