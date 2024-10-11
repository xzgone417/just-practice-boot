package com.exp.ucmp.partner.service;

import com.exp.ucmp.parentUser.dto.SysParentAddStoreListDto;
import com.exp.ucmp.parentUser.dto.SysParentStoreQueryDto;
import com.exp.ucmp.parentUser.dto.SysPartnerStaffInfoInsertDto;
import com.exp.ucmp.parentUser.dto.SysPartnerStoreAuthDto;
import com.exp.ucmp.pertner.dto.*;
import com.exp.ucmp.staff.dto.SysStaffDetailsDto;
import com.exp.ucmp.store.dto.SysStoreInfoDto;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author zhouchengwei
 * @date 2022年09月01日
 */

public interface SysPartnetDetailsService {


    /**
     * Description: 查询合作商列表信息
     * @param sysPartnerDetailsDto 查询条件
     * @return 实体集合
     */
    public PageInfo<SysPartnerDetailsDto> queryPartnerMsg(SysPartnerDetailsDto sysPartnerDetailsDto);

    /**
     * Description: 查询当前合作商下人员详情
     * @param sysPartnerStaffDetailsDto 查询条件
     * @return 实体集合
     */
    public PageInfo<SysPartnerStaffDetailsDto> queryPartnerStaffMsg(SysPartnerStaffDetailsDto sysPartnerStaffDetailsDto);


    /**
     * Description: 查询公司管辖城市信息
     * @param sysPartnerCityQueryDto 查询条件
     * @return 实体集合
     */
    public PageInfo<SysPartnerCityRelaDto> queryPartnerCitiesMsg(SysPartnerCityQueryDto sysPartnerCityQueryDto);


    /**
     * Description: 查询区域省市信息
     * @param sysAreaRegionDetailsDto 查询条件
     * @return 实体集合
     */
    public List<Map> queryAreaRegionMsg(SysAreaRegionDetailsDto sysAreaRegionDetailsDto);





    /**
     * Description: 添加合作商
     * @param sysPartnerDetailsDto 查询条件
     */

    public String insertPartner(SysPartnerDetailsDto sysPartnerDetailsDto);


    /**
     * Description: 添加当前合作商人员
     * @param sysStaffDetailsDtos 查询条件
     */

    public void insertPartnerStaff(SysStaffDetailsDto sysStaffDetailsDtos);


    /**
     * Description: 添加当前合作商管辖城市
     * @param sysPartnerCityRelaDto 查询条件
     */

    public void insertPartnerCities(SysPartnerCityRelaDto sysPartnerCityRelaDto);


    /**
     * Description: 修改合作商信息
     * @param sysPartnerDetailsDto 查询条件
     */

    public void updatePartner(SysPartnerDetailsDto sysPartnerDetailsDto);


    /**
     * Description: 修改当前合作商人员信息
     * @param sysPartnerStaffDetailsDto 查询条件
     */

    public void updatePartnerStaff(SysStaffDetailsDto  sysPartnerStaffDetailsDto);


    /**
     * Description: 删除当前合作商信息
     * @param partnerId 合作商id
     */
     void dropPartnerMsg(Long partnerId);



    /**
     * Description: 删除当前合作商城市信息
     * @param sysPartnerCityDropDto 查询条件
     */

    public void dropPartnerCitiesMsg(SysPartnerCityDropDto sysPartnerCityDropDto);


    /**
     * Description: 删除当前合作商人员信息
     * @param sysPartnerStaffDropDto 查询条件
     */

    public void dropPartnerStaffMsg(SysPartnerStaffDropDto sysPartnerStaffDropDto);


    /**
     * Description: 查询当前登录车商人员管辖的门店
     */

    public List<Long> findStoreIdByCurrPartnerStaff();

    /**
     * 查询指定门店有管辖车商人员最新的那个
     * @param storeId
     * @param partnerId
     * @return
     */
    public List<Long> findPartnerStaffIdByStoreByAuto(Long storeId, Long partnerId);

    /**
     * 查询指定门店有管辖车商人员
     * @param storeId
     * @param partnerId
     * @return
     */
    public List<Long> findPartnerStaffIdByStore(Long storeId, Long partnerId);
    
    /**
     * 查询指定车商的人员
     * @param partnerId
     * @return
     */
    public List<Long> findPartnerStaffId(Long partnerId);

    /***********************************************************************/

    /**
     * Description: 添加当前合作商人员
     * @param sysParentUserInfoInsertDto 查询条件
     */

     void insertParentUserInfo(SysPartnerStaffInfoInsertDto sysParentUserInfoInsertDto);

    /**
     * Description: 更新当前合作商人员
     * @param sysStaffDetailsDto 更新实体
     */
    void updateParentUserInfo(SysPartnerStaffInfoInsertDto sysStaffDetailsDto);


    /**
     * 删除当前合作商的人员信息
     * @param partnerId 当前合作商id
     * @param partyId 当前人员id
     */
    void deleteUserInfoById(Long partnerId, Long partyId);

    /**
     * 查询合作商管辖门店列表
     * @param sysPartnerStaffDetailsDto
     * @return
     */
    PageInfo<SysStoreInfoDto> findPartnerStorePage(SysParentStoreQueryDto sysPartnerStaffDetailsDto);
    /**
     * 合作商添加门店列表页面
     * @param sysPartnerStaffDetailsDto
     * @return
     */
    PageInfo<SysParentAddStoreListDto> findAddPartnerStorePage(SysParentStoreQueryDto sysPartnerStaffDetailsDto);

    /**
     * 合作商授权门店数据
     * @param storeAuthDto
     */
    void authorizeStore(SysPartnerStoreAuthDto storeAuthDto);

    /**
     * 合作商状态修改
     * @param sysPartnerStatusDto
     */
    void modifyPartnerStatus(SysPartnerStatusDto sysPartnerStatusDto);
    /**
     * 合作商状态修改(批量)
     * @param sysPartnerStatusDto
     */
    void batchModifyPartnerStatus(SysPartnerStatusDto sysPartnerStatusDto);


    /**
     * 查询当前合作商人员名单
     * @param staffQueryDto
     * @return
     */
    PageInfo<SysPartnerStaffDetailsDto> findPartnerStaffPage(SysPartnerStaffQueryDto staffQueryDto);

    /**
     * 合作商人员名单删除
     * @param partnerId
     * @param partyId
     */
    void deletePartnerStaffById(Long partnerId, Long partyId,String storeIds);

    /**
     * 合作商排名修改
     * @param partnerId 业务id
     * @param sort 排序id
     */
    void updateSort(String partnerId, Double sort);

    List<SysStoreInfoDto> getPartnerStoreList(Long partnerId);
}
