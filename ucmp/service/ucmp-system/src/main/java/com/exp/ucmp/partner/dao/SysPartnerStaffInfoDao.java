package com.exp.ucmp.partner.dao;


import com.exp.ucmp.pertner.dto.SysPartnerDetailsDto;
import com.exp.ucmp.store.dto.SysPartnerStaffInfoDto;

import java.util.List;

/**
 * @author hailele
 * @date 2022/10/20
 * 人员管理DAO
 */
public interface SysPartnerStaffInfoDao {


    /**
     * Description: 查询门店下面的车商指定人信息
     * @param storeId  门店id
     * @return 实体集合
     */
    List<SysPartnerStaffInfoDto> selectPartnerStaffInfoByStoreId(Long storeId);

    /**
     * Description: 查询门店下面的所有合作商信息
     * @param storeId  门店id
     * @return 实体集合
     */
    List<SysPartnerDetailsDto> findPartnerDetailsByStoreId(Long storeId);

}
