package com.exp.ucmp.partner.dao;

import com.exp.ucmp.entity.SysPartnerStaffStoreRelaEntity;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 自动接单所需
 * @date 2022/12/21 10:00
 */
public interface AutoOrderReceivingDao {
    List<SysPartnerStaffStoreRelaEntity> selectBySelective(SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity);

}
