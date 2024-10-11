package com.exp.ucmp.xxljob.service;


import com.exp.ucmp.entity.JobReceiveRspEntity;
import com.exp.ucmp.entity.SysOrganizationStaffInfoEntity;
import com.exp.ucmp.entity.SysStaffDetailsEntity;
import com.exp.ucmp.parentUser.dto.JobReceiveRspUserInfoDto;
import com.exp.ucmp.storeApp.dto.UserInfoInsertDto;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
 * @author hailele
 * @date 2022年09月01日
 * 总部人员信息Service
 */

public interface JobReceiveRspUserInfoService {

    /**
     * Description: 从t_job_receive_info表拉取数据，更新用户信息
     * @return 实体集合
     */
    void batchUpdateParentUserInfo(List<JobReceiveRspEntity> rspList);

    /**
     * Description: 新增系统人员信息
     * @return 实体集合
     */
    void insertSysUserList(List<UserInfoInsertDto> sysUserList,boolean isStoreUser);



    /**
     * Description: 新增人员信息（同时更新系统相关登录信息）
     * @param staffDetailsEntity 实体对象，包含基础的业务字段信息
     * @param  tagPartyId 目标组织id
     * @return 
     */
    SysStaffDetailsEntity insertParentUserInfo(SysStaffDetailsEntity staffDetailsEntity,Long tagPartyId);

    /**
     * Description: 更新人员信息（同时更新系统相关登录信息）
     * @param parentUserInfo 实体对象
     * @return
     */
    void updateParentUserInfo(SysStaffDetailsEntity parentUserInfo);



    void batchInsertOrUpdateParentUser(List<SysOrganizationStaffInfoEntity> list);

    /**
     * Description: 查询人员管理页面
     * @param sysParentUserInfoDto 查询条件
     * @return 实体集合
     */
    PageInfo<JobReceiveRspUserInfoDto> findPage(JobReceiveRspUserInfoDto sysParentUserInfoDto);

    /**
     * Description: 删除人员信息
     * @return parentUserInfoId 人员id
     */
    void deleteUserInfoById(Long partyId);

}
