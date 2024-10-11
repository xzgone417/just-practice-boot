package com.exp.ucmp.staff.service;

import com.exp.ucmp.area.dto.SysAreaInfoDto;
import com.exp.ucmp.staff.dto.*;
import com.exp.ucmp.store.dto.SysStoreInfoDto;
import com.exp.ucmp.store.dto.SysStoreStaffListDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022年08月12日
 */

public interface SysStaffService {
    /**
     * 新增组织信息
     * @param partyId 主键id
     * @param organName 组织名称
     * @param partyType 当事人类型：0100、人员，0200、组织，0300、职位
     */
    void insertPartyAndOrganization(Long partyId,String organName,String partyType);


    /**
     * Description: 根据条件查询集合实体(人员信息)
     * @param sysStaffDetailsDto 查询条件
     * @return 实体集合
     */
    public PageInfo<SysStaffDetailsDto> queryStaff(SysStaffDetailsDto sysStaffDetailsDto) ;

    /**
     * Description: 查询人员状态
     * @return 人员状态类型
     */
    public List<String> queryStaffStatus();

    /**
     * Description: 新增人员信息
     * @param sysStaffDetailsEditDto 新增内容
     */
    public void addStaffMsg(SysStaffDetailsAddDto sysStaffDetailsEditDto);

    /**
     * Description: 人员角色维护
     * @param partyRoleRelaDto 修改内容
     */
    public void staffRoleEdit(PartyRoleRelaDto partyRoleRelaDto);

    /**
     * Description: 人员状态(启用/禁用)
     * @param staffDetailsStatusDto 修改内容
     */
    public void StaffStatusEdit(SysStaffDetailsStatusDto staffDetailsStatusDto);


    /**
     * Description: 人员角色查询
     * @param sysStaffDetailsRoleQueryDto 修改内容
     */
    public PageInfo<SysStaffDetailsRoleQueryDto> staffRoleQuery(SysStaffDetailsRoleQueryDto sysStaffDetailsRoleQueryDto);



    /**
     * Description: 人员区域查询
     * @param sysAreaInfoQueryDto 查询条件
     */
    public List<SysAreaInfoDto> staffAreaQuery(SysAreaInfoQueryDto sysAreaInfoQueryDto);


    /**
     * Description: 人员区域维护
     * @param sysAreaInfoEditDto 修改内容
     */
    public void staffAreaEdit(SysAreaInfoEditDto sysAreaInfoEditDto);



    /**
     * Description: 修改人员信息
     * @param sysStaffDetailsModifyDto 修改内容
     */
    public void modifyStaffMsg(SysStaffDetailsModifyDto sysStaffDetailsModifyDto);

    /**
     * Description: 删除人员信息
     */
    public void delStaffMsg(SysStaffDetailsDelDto sysStaffDetailsDelDto);


    /**
     * Description: 查询添加的人员信息(查询添加的人员信息)
     * @param sysStaffDetailsDto 查询条件
     * @return 实体集合
     */
     PageInfo<SysStaffDetailsDto> queryAddStaffMsg(SysStaffDetailsDto sysStaffDetailsDto);

    /**
     * 授权门店查询列表查询
     * @param storeListQueryDto 参数实体
     * @return
     */
    PageInfo<SysStoreStaffListDto> findStorePage(SysStaffStoreListQueryDto storeListQueryDto);

    /**
     * 门店授权
     * @param storeAuthDto
     */
    void authorizeStore(SysStaffStoreAuthDto storeAuthDto);

    /**
     * 查看授权门店列表
     * @param sysStaffStoreListQueryDto 当事人id
     * @return
     */
    PageInfo<SysStoreInfoDto> findStorePageByPartyId(SysStaffStoreListQueryDto sysStaffStoreListQueryDto);

    /**
     * 修改人员状态
     * @param statusEditDto
     */
    void modifyStaffStatus(SysStaffStatusEditDto statusEditDto);

    void testUpdatePhone();


	void testUpdateUserMapping();
}
