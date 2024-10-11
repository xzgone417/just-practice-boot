package com.exp.ucmp.mall.util.listener;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellExtra;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.mall.util.entity.CluesInfoImportExcelEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>@ClassName: CluesInfoImportExtraListener</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/20 14:51<p>
 */
public class CluesInfoImportExtraListener extends AnalysisEventListener<CluesInfoImportExcelEntity> {

    @Autowired
    private UcmpAesConfig ucmpAesConfig;
    /**
     * 记录行数 第一行为表头
     */
    int row = 0;
    /**
     * 用于暂时存储数据
     */
    private List<CluesInfoImportExcelEntity> datas;
    public CluesInfoImportExtraListener(List<CluesInfoImportExcelEntity> datas) {
        this.datas = datas;
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        super.onException(exception, context);
    }

    @Override
    public void invoke(CluesInfoImportExcelEntity excelEntity, AnalysisContext context) {
        //第一行为表头
        row++;
        if(StringUtils.isEmpty(excelEntity.getCustomerName())){
            excelEntity.setMsg("客户名称不能为空;");
        }
        if(StringUtils.isEmpty(excelEntity.getCustomerPhone())){
            excelEntity.setMsg("手机号不能为空;");
        } else {
            try {
                Long.valueOf(excelEntity.getCustomerPhone());
            } catch (NumberFormatException e) {
                excelEntity.setMsg("手机号错误;");
            }
            if(excelEntity.getCustomerPhone().length() != 11){
                excelEntity.setMsg("手机号错误;");
            }
        }
        if(StringUtils.isEmpty(excelEntity.getDeliveryPlace())){
            excelEntity.setMsg("意向交付地不能为空;");
        }
        datas.add(excelEntity);
    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        super.extra(extra, context);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    @Override
    public boolean hasNext(AnalysisContext context) {
        return super.hasNext(context);
    }
}
