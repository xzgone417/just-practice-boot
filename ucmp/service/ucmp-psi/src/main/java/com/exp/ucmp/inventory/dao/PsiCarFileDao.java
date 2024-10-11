package com.exp.ucmp.inventory.dao;

import com.exp.ucmp.file.dto.FileReturnDto;

import java.util.List;

/**
 * @author hailele
 * @Description: 文件相关DAO
 * @date 2022/02/23
 */
public interface PsiCarFileDao {

    /**
     * 获取车辆的批售记录（收款凭证）文件
     * @param saleRecordId 车辆批售记录id
     * @return
     */
    List<FileReturnDto> selectSaleRecordFile(Long saleRecordId);


}
