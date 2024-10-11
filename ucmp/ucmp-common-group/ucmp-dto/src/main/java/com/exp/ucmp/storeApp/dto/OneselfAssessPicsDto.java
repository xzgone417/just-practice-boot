package com.exp.ucmp.storeApp.dto;


import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OneselfOrderPicsDto", description = "本品订单材料信息")
public class OneselfAssessPicsDto {
	
    @ApiModelProperty(value = "评估车辆照片")
    private List<OneselfCarPicDto> carAssessPicList;
    
    @ApiModelProperty(value = "检测报告材料")
    private List<OneselfCarPicDto> testReportList;

	public List<OneselfCarPicDto> getCarAssessPicList() {
		return carAssessPicList;
	}

	public void setCarAssessPicList(List<OneselfCarPicDto> carAssessPicList) {
		this.carAssessPicList = carAssessPicList;
	}

	public List<OneselfCarPicDto> getTestReportList() {
		return testReportList;
	}

	public void setTestReportList(List<OneselfCarPicDto> testReportList) {
		this.testReportList = testReportList;
	}
}
