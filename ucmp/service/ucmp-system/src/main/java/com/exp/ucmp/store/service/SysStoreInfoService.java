package com.exp.ucmp.store.service;

import com.exp.ucmp.entity.JobReceiveRspEntity;
import com.exp.ucmp.entity.SysStoreInfoEntity;

import java.util.List;

/**
 * @author hailele
 * @date 2022/10/24
 * 门店Service
 */
public interface SysStoreInfoService {
    /**
     * 批量新增或更新
     * @param sysStoreInfoList 数据集合
     */
    void batchInsertorUpdate(List<SysStoreInfoEntity> sysStoreInfoList);

    /**
     * 更新门店的地区信息
     * @param storeInfoEntitie 门店地区为空的
     */
    void synStoreArea(List<SysStoreInfoEntity> storeInfoEntitie);

    /**
     * 同步门店信息
     * @param rsp
     */
    void synSmpStoresInfo(JobReceiveRspEntity rsp);

	void synStoreCodeInfo(JobReceiveRspEntity rsp);
}
