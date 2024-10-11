package com.exp.ucmp.smp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ContractDto", description = "合同")
public class ContractDto {
	
	@ApiModelProperty(value = "合同类型")
	private String contractType;
	
	@ApiModelProperty(value = "合同编号")
    private String contractCode;
	
	@ApiModelProperty(value = "发起方名称")
    private String initiateName;
	
	@ApiModelProperty(value = "合同名称")
    private String contractName;
	
	@ApiModelProperty(value = "合同状态")
    private String contractStatus;
	
	@ApiModelProperty(value = "合同创建时间")
	private String createTime;
	
	@ApiModelProperty(value = "合同状态")
    private List<AnnexDto> annexList;

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getInitiateName() {
		return initiateName;
	}

	public void setInitiateName(String initiateName) {
		this.initiateName = initiateName;
	}

	public String getContractName() {
		return contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public List<AnnexDto> getAnnexList() {
		return annexList;
	}

	public void setAnnexList(List<AnnexDto> annexList) {
		this.annexList = annexList;
	}
}
