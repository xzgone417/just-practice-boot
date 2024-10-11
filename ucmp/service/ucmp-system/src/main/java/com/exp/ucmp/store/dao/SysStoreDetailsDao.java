package com.exp.ucmp.store.dao;

import com.exp.ucmp.store.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022/08/16
 * 查询人员信息
 */
public interface SysStoreDetailsDao {
    /**
     * Description: 根据条件查询集合实体(门店信息)
     * @param sysStoreInfoQueryDto 查询条件
     * @return 实体集合
     */
    public List<SysStoreInfoDto> selectStoreMsg(SysStoreInfoQueryDto sysStoreInfoQueryDto);

    public List<SysFindStoreByNameDto> selectStoreByStoreName(@Param("storeName") String storeName,@Param("partnerId") Long partnerId);

    public List<SysFindPartnerByNameDto> selectSysPartnerByName(@Param("name") String name);


    /**
     * Description: 根据条件查询集合实体(门店人员信息)
     * @param sysStoreStaffInfoQueryDto 查询条件
     * @return 实体集合
     */
    public List<SysStoreStaffInfoDto> selectStoreStaff(SysStoreStaffInfoQueryDto sysStoreStaffInfoQueryDto);


    /**
     * Description: 根据当事人id查看所属门店
     * @param partyId 当时人id
     * @return 实体集合
     */
     List<SysStoreInfoDto> selectStoreByPartyId(Long partyId);

    /**
     * Description: 根据合作商id查看管辖门店
     * @param partnerId 合作商id
     * @return 实体集合
     */
    List<SysStoreInfoDto> selectStoreByPartnerId(Long partnerId);

    /**
     * Description: 查询门店人员信息(包括对应的账户名称)提供给定时任务使用
     * @return 实体集合
     */
    public List<SysStoreStaffDetailsDto> selectAllStoreStaffList();

	public List<DeliveryCenterDto> findDeliveryCenter(@Param("storeName")String storeName);

}
