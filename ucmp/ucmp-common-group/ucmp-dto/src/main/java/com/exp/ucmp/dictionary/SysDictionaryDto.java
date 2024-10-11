package com.exp.ucmp.dictionary;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author zhouchengwei
 * @date 2022年10月16日
 */


@ApiModel(value = "SysDictionaryDto", description = "字典信息")
public class SysDictionaryDto extends BaseModel {
    private static final long serialVersionUID = 1L;


    /**
     * 分类编码
     */
    @ApiModelProperty(value = "分类编码(01线索类型,02线索来源,03线索状态,04业务类型,05客户意向,06关闭原因,0601,0602,0603,0604关闭原因细项,07跟踪状态,08使用性质,09询价单状态,10支付方式,11收购状态,12旧车确认状态,13审批状态,14审批结果,15材料状态,90材料类型,91业务节点)")
    private String dictCode;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String dictType;


    /**
     * 编码值
     */
    @ApiModelProperty(value = "编码值")
    private String dictValue;


    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }
}
