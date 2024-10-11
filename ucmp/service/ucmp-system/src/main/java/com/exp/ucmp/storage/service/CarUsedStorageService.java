package com.exp.ucmp.storage.service;

import com.exp.ucmp.usedstorage.dto.SysUsedStorageInfoDto;
import com.exp.ucmp.usedstorage.dto.SysUsedStorageListDto;
import com.exp.ucmp.usedstorage.dto.SysUsedStorageSelectListDto;
import com.exp.ucmp.usedstorage.dto.UsedStorageInfoDto;

import java.util.List;

/**
 * @author hailele
 * @date 2022/02/14
 * 仓储点Service
 */
public interface CarUsedStorageService {

    List<SysUsedStorageListDto> findList();

    List<SysUsedStorageSelectListDto> findSelectList(Long storeId);

    void addUsedStorage(SysUsedStorageInfoDto usedStorageInfoDto);

    SysUsedStorageInfoDto getUsedStorageInfo(Long storageId);

    void synUsedStorage();

    void updateUsedStorage(SysUsedStorageInfoDto usedStorageInfoDto);

	List<UsedStorageInfoDto> queryList(String usedstorageName);
}
