package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/20 20:13
 */
@ApiModel(value = "BusinessNodesQueryDto", description = "业务节点查询对象")
public class BusinessNodesQueryDto extends BaseModel {

    private static final long serialVersionUID = 6839836701542716059L;

    public enum BusinessNodesQueryTypeEnum {
        acquisitionMaterial, transferMaterial, approvalRejection,quotedMaterial;
    }

    /**
     * 查询类型
     */
    @ApiModelProperty(value = "查询类型: acquisitionMaterial(收购), transferMaterial(过户), approvalRejection(驳回) ,quotedMaterial(报价)")
    private String businessNodesQueryType;

    public String getBusinessNodesType() {
        return businessNodesQueryType;
    }

    public void setBusinessNodesQueryType(String businessNodesQueryType) {
        this.businessNodesQueryType = businessNodesQueryType;
    }
}
