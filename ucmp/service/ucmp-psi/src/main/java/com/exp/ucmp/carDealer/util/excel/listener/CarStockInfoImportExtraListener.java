package com.exp.ucmp.carDealer.util.excel.listener;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.exp.ucmp.carDealer.service.AppraisalRecordService;
import com.exp.ucmp.carDealer.util.excel.entity.CarStockInfoImportExcelEntity;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 库存车辆导入实体
 */
public class CarStockInfoImportExtraListener extends AnalysisEventListener<CarStockInfoImportExcelEntity> {
    AppraisalRecordService sysCaseService;
    /**
     * 记录行数 第一行为表头
     */
    int row = 1;
    /**
     * 用于暂时存储数据
     */
    private List<PsiCarStockInfoEntity> datas;
    /**
     * 每隔3000条存储数据库，然后清理list，方便内存回收 具体条数按实际情况确定
     */
    private static final int BATCH_COUNT = 3000;

    DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");

    public CarStockInfoImportExtraListener(List<PsiCarStockInfoEntity> datas) {
        this.datas = datas;
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {

    }

    @Override
    public void invoke(CarStockInfoImportExcelEntity excelEntity, AnalysisContext analysisContext) {
        //第一行为表头
        row++;
        PsiCarStockInfoEntity entity = new PsiCarStockInfoEntity();
        try {
            //导入字段，需转换和判断
            if (StringUtils.isNotBlank(excelEntity.getSourceBatch())) {
                entity.setSourceBatch(excelEntity.getSourceBatch());
            }
            if (StringUtils.isNotBlank(excelEntity.getVinCode())) {
                entity.setVinCode(excelEntity.getVinCode().replace(" ", ""));
            }
            if (StringUtils.isNotBlank(excelEntity.getRevertBody())) {
                entity.setRevertBody(Constants.REVERT_BODY.getValue(excelEntity.getRevertBody().replace(" ", "")));
            }
            if (StringUtils.isNotBlank(excelEntity.getCarType())) {
                entity.setCarType(Constants.CAR_TYPE.getValue(excelEntity.getCarType().replace(" ", "")));
            }
            if (StringUtils.isNotBlank(excelEntity.getCarNature())) {
                entity.setCarNature(Constants.CAR_NATURE.getValue(excelEntity.getCarNature().replace(" ", "")));
            }
            if (StringUtils.isNotBlank(excelEntity.getPurchasePriceStr())) {
                entity.setPurchasePrice(new BigDecimal(excelEntity.getPurchasePriceStr()));
            }
            if (StringUtils.isNotBlank(excelEntity.getLicensePlace())) {
                entity.setLicensePlace(excelEntity.getLicensePlace());
            }
            if (StringUtils.isNotBlank(excelEntity.getLicenseNumber())) {
                entity.setLicenseNumber(excelEntity.getLicenseNumber());
            }
            if (StringUtils.isNotBlank(excelEntity.getCompanyCode())) {
                entity.setCompanyCode(excelEntity.getCompanyCode());
            }
            if (StringUtils.isNotBlank(excelEntity.getStorageCode())) {
                entity.setStorageCode(excelEntity.getStorageCode());
            }
            if (StringUtils.isNotBlank(excelEntity.getAccidentInsuranceEndDateStr())) {
                entity.setAccidentInsuranceEndDate(fmt.parse(excelEntity.getAccidentInsuranceEndDateStr()));
            }
            if (StringUtils.isNotBlank(excelEntity.getYearlyInspectionEndDateStr())) {
                entity.setYearlyInspectionEndDate(fmt.parse(excelEntity.getYearlyInspectionEndDateStr()));
            }
            if (StringUtils.isNotBlank(excelEntity.getInvoicingDateStr())) {
                entity.setInvoicingDate(fmt.parse(excelEntity.getInvoicingDateStr()));
            }
            if (StringUtils.isNotBlank(excelEntity.getTransferCountStr())) {
                entity.setTransferCount(Integer.valueOf(excelEntity.getTransferCountStr()));
            }
            if (StringUtils.isNotBlank(excelEntity.getFirstLicenseDateStr())) {
                entity.setFirstLicenseDate(fmt.parse(excelEntity.getFirstLicenseDateStr()));
            }
            if (StringUtils.isNotBlank(excelEntity.getYearlyInspectionEndDateStr())) {
                entity.setYearlyInspectionEndDate(fmt.parse(excelEntity.getYearlyInspectionEndDateStr()));
            }
            if (StringUtils.isNotBlank(excelEntity.getAccidentInsuranceEndDateStr())) {
                entity.setAccidentInsuranceEndDate(fmt.parse(excelEntity.getAccidentInsuranceEndDateStr()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        datas.add(entity);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("数据:"+datas.size());
        //解析结束销毁不用的资源
    }


}
