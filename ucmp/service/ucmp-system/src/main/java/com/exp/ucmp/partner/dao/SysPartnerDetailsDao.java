package com.exp.ucmp.partner.dao;


import com.exp.ucmp.pertner.dto.*;

import java.util.List;
import java.util.Map;

/**
 * @author zhouchengwei
 * @date 2022/09/01
 * 查询合作商信息
 */
public interface SysPartnerDetailsDao {


    /**
     * Description: 查询合作商详情信息
     * @param sysPartnerDetailsDto 查询条件
     * @return 实体集合
     */
    public List<SysPartnerDetailsDto> selectPartnerMsg(SysPartnerDetailsDto sysPartnerDetailsDto);


    /**
     * Description: 查询当前合作商下人员详情
     * @param sysPartnerStaffDetailsDto 查询条件
     * @return 实体集合
     */
    public List<SysPartnerStaffDetailsDto> selectPartnerStaffMsg(SysPartnerStaffDetailsDto sysPartnerStaffDetailsDto);


    /**
     * Description: 查询省份信息
     * @param sysAreaRegionDetailsDto 查询条件
     * @return 实体集合
     */
    public List<Map> selectPartnerProvinceMsg(SysAreaRegionDetailsDto sysAreaRegionDetailsDto);


    /**
     * Description: 修改当前合作商下人员区域信息
     * @param pId 查询条件
     * @return 实体集合
     */
    public void updateStaffRegion(Long pId);

    /**
     * Description: 删除当前合作商下人员信息
     * @param sysPartnerCityQueryDto 查询条件
     * @return 实体集合
     */
    public void updatePartnerStaff(SysPartnerCityQueryDto sysPartnerCityQueryDto);


    /**
     * Description: 删除当前合作商下人员所属城市信息
     * @param sysPartnerCityQueryDto 查询条件
     * @return 实体集合
     */
    public void deleteStaffRegion(SysPartnerCityDropDto sysPartnerCityQueryDto);


    /**
     * Description: 删除当前合作商下所属区域信息
     * @param sysPartnerCityQueryDto 查询条件
     * @return 实体集合
     */
    public void deletePartnerArea(SysPartnerCityDropDto sysPartnerCityQueryDto);


    /**
     * Description: 查询当前合作商下人员名单
     * @param sysPartnerStaffDetailsDto 查询条件
     * @return 实体集合
     */
    public List<SysPartnerStaffDetailsDto> selectPartnerStoreStaffList(SysPartnerStaffQueryDto sysPartnerStaffDetailsDto);


    /**
     * Description: group_concat参数备用sql
     * @param partnerId 合作商id
     * @return 实体集合
     */
    public List<SysPartnerStaffDetailsDto> selectConcatPartnerStoreStaffList(Long partnerId);

}
