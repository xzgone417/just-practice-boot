package com.exp.ucmp.car.dto;

import java.util.List;

import com.exp.ucmp.clues.dto.OrderChangeFileDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarSalePriceDto", description = "车辆销售定价实体类")
public class CarSalePriceDto {
	
	@ApiModelProperty(value = "车辆id,必传")
    private Long stockId;
	
	@ApiModelProperty(value = "销售定价/修改后价格,必传")
	private Double salePrice;
	
	@ApiModelProperty(value = "变更人,不用传")
	private Long partyId;
	
	@ApiModelProperty(value = "维修折扣类型")
	private String maintenanceType;
	
	@ApiModelProperty(value = "运营性质类型")
	private String useNatureType;

	@ApiModelProperty(value = "当前价格")
	private Double curSalePrice;
	
	@ApiModelProperty(value = "改价原因")
	private String changeReason;
	
	@ApiModelProperty(value = "OA编号")
	private String oaCode;
	
	@ApiModelProperty(value = "凭证材料")
    private List<OrderChangeFileDto> proofMaterials;
	
	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public Double getCurSalePrice() {
		return curSalePrice;
	}

	public void setCurSalePrice(Double curSalePrice) {
		this.curSalePrice = curSalePrice;
	}

	public String getMaintenanceType() {
		return maintenanceType;
	}

	public void setMaintenanceType(String maintenanceType) {
		this.maintenanceType = maintenanceType;
	}

	public String getUseNatureType() {
		return useNatureType;
	}

	public void setUseNatureType(String useNatureType) {
		this.useNatureType = useNatureType;
	}

	public String getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	public String getOaCode() {
		return oaCode;
	}

	public void setOaCode(String oaCode) {
		this.oaCode = oaCode;
	}

	public List<OrderChangeFileDto> getProofMaterials() {
		return proofMaterials;
	}

	public void setProofMaterials(List<OrderChangeFileDto> proofMaterials) {
		this.proofMaterials = proofMaterials;
	}
	
}
