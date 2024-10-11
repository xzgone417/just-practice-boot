package com.exp.ucmp.store.service;

import com.exp.ucmp.pertner.dto.SysPartnerDetailsDto;
import com.exp.ucmp.staff.dto.PartyRoleRelaDto;
import com.exp.ucmp.store.dto.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022/08/16
 * 查询人员信息
 */
public interface SysStoreDetailsService {
    /**
     * Description: 根据条件查询集合实体(门店信息)
     * @param sysStoreInfoQueryDto 查询条件
     * @return 实体集合
     */
    public PageInfo<SysStoreInfoDto> queryStoreMsg(SysStoreInfoQueryDto sysStoreInfoQueryDto);

    /**
     * 根据门店名称 模糊查询
     * @param storeName
     * @return
     */
    public List<SysFindStoreByNameDto> queryStoreByStoreName(SysFindStoreByNameParamsDto storeName);

    /**
     * 根据车商名称 模糊查询
     * @param name
     * @return
     */
    public List<SysFindPartnerByNameDto> queryPartnerByName(String name);

    /**
     * Description: 根据条件查询集合实体(门店人员信息)
     * @param sysStoreStaffInfoQueryDto 查询条件
     * @return 实体集合
     */
    public PageInfo<SysStoreStaffInfoDto> queryStoreStaff(SysStoreStaffInfoQueryDto sysStoreStaffInfoQueryDto);


    /**
     * Description: 门店状态改变(门店状态：启用01/禁用00（当前门店是否能在APP端可见）)
     * @param sysStoreStatusDto
     */
   public void modifyStoreStatus(SysStoreStatusDto sysStoreStatusDto);
    /**
     * Description: 批量门店状态改变
     * @param sysStoreStatusDto
     */
    public void batchModifyStoreStatus(SysStoreStatusDto sysStoreStatusDto);

    /**
     * 批量修改门店官二资质状态
     * @param sysStoreStatusDto
     */
    void batchQualificationStatus(SysStoreStatusDto sysStoreStatusDto);

    /**
     * 修改门店官二资质状态
     * @param sysStoreStatusDto
     */
    String modifyQualificationStatus(SysStoreStatusDto sysStoreStatusDto);


    /**
     * Description: 门店员工改变(人员状态：启用01/禁用00（当前门店是否能在APP端可见）)
     * @param sysStoreStaffStatusDto 查询条件
     */
    public void modifyStoreStaffStatus(SysStoreStaffStatusDto sysStoreStaffStatusDto);


    /**
     * Description: 新增门店信息
     * @param sysStoreAddDto 门店信息集合
     */
    public void insertStore(SysStoreAddDto sysStoreAddDto );

    /**
     * 查询门店下面的车商指定人信息
     * @param storeId 门店id
     * @param pageNum   页数
     * @param pageSize  行数
     * @return
     */
    PageInfo<SysPartnerStaffInfoDto> findPartnerStaffInfo(Long storeId,Integer pageNum,Integer pageSize);

    /**
     * 查询门店下面的所有合作商信息
     * @param storeId 门店id
     * @param pageNum   页数
     * @param pageSize  行数
     * @return
     */
    PageInfo<SysPartnerDetailsDto> findPartnerDetails(Long storeId, Integer pageNum, Integer pageSize);

    void modifyPartnerStatus(Long relaId, String isEnable);

    void modifyPartnerStaffStatus(Long relaId, String isEnable);

    void testStoreRelationship();

    void editStoreStaffRole(PartyRoleRelaDto partyRoleRelaDto);

	public List<DeliveryCenterDto> findDeliveryCenter(String storeName);

    /**
     * 修改门店人员官二资质状态
     * @param sysStoreStaffQualificationStatusDto
     */
    String modifyStoreStaffQualificationStatus(SysStoreStaffQualificationStatusDto sysStoreStaffQualificationStatusDto);

    List<SysStoreInfoDto> listStoreInfo(SysStoreInfoQueryDto sysStoreInfoQueryDto);

    List<SysStoreStaffInfoDto> listStoreStaffInfo(SysStoreStaffInfoQueryDto sysStoreStaffInfoQueryDto);
}
