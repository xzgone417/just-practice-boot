package com.exp.ucmp.dictionary;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022年10月16日
 */


@ApiModel(value = "SysDictionaryQueryDto", description = "字典信息查询入参")
public class SysDictionaryQueryDto extends BaseModel {
    private static final long serialVersionUID = 1L;



    /**
     * 分类编码
     */
    @ApiModelProperty(value = "分类编码(01线索类型,02线索来源,03线索状态,04业务类型,05客户意向,06关闭原因,0601,0602,0603,0604关闭原因细项," +
            "07跟踪状态,08使用性质,09询价单状态,10支付方式,11收购状态,12旧车确认状态,13审批状态,14审批结果,15材料状态," +
            "51库存状态,52调拨状态,53整备状态,54出入库状态,62slf角色" +
            "77跟进形式,78商城留资线索状态,79车辆主体,80颜色,81证件类型" +
            "90材料类型91业务节点,94整备图片大类,95外观图,92内试图,93瑕疵图)")
    private List<String> dictTag;


    public List<String> getDictTag() {
        return dictTag;
    }

    public void setDictTag(List<String> dictTag) {
        this.dictTag = dictTag;
    }
}
