package com.exp.ucmp.department.service.impl;

import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.ISysDepartmentStaffRelaDao;
import com.exp.ucmp.dao.ISysStaffDetailsDao;
import com.exp.ucmp.department.dao.SysDepartmentDao;
import com.exp.ucmp.department.dao.SysDepartmentStaffDao;
import com.exp.ucmp.department.dto.SysDepartmentInfoDto;
import com.exp.ucmp.department.dto.SysDepartmentStaffRelaDto;
import com.exp.ucmp.department.dto.SysDepartmentStaffRelaEditDto;
import com.exp.ucmp.department.dto.SysStaffAllDto;
import com.exp.ucmp.department.service.SysDepartmentStaffService;
import com.exp.ucmp.entity.SysDepartmentInfoEntity;
import com.exp.ucmp.entity.SysDepartmentStaffRelaEntity;
import com.exp.ucmp.entity.SysStaffDetailsEntity;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.model.Person;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author zhouchengwei
 * @date 2022年08月09日
 */
@Service
public class SysDepartmentStaffServiceImpl implements SysDepartmentStaffService {


    @Autowired
    private SysDepartmentStaffDao sysDepartmentStaffDao;

    @Autowired
    private ISysDepartmentStaffRelaDao iSysDepartmentStaffRelaDao;


    /**
     * Description: 查询总部所有部门员工
     *
     * @param staffAllDto 查询条件
     * @return 实体集合
     */
    @Override
    public PageInfo<SysStaffAllDto> queryDepartmentStaffMsg(SysStaffAllDto staffAllDto) {

        if ((staffAllDto.getPageNum() == null) || (staffAllDto.getPageSize() == null)) {
            staffAllDto.setPageNum(1);
            staffAllDto.setPageSize(9999);
            PageHelper.startPage(staffAllDto.getPageNum(), staffAllDto.getPageSize());
            List<SysStaffAllDto> sysDepartmentStaffListAll = sysDepartmentStaffDao.selectDepartmentStaff(staffAllDto);
            PageInfo<SysStaffAllDto> page = new PageInfo<SysStaffAllDto>(sysDepartmentStaffListAll);
            return page;
        }else {
            PageHelper.startPage(staffAllDto.getPageNum(), staffAllDto.getPageSize());
            List<SysStaffAllDto> sysDepartmentStaffList = new ArrayList<>();
            if (ObjectUtils.isEmpty(staffAllDto.getRoleDetailsName()) && ObjectUtils.isEmpty(staffAllDto.getRoleDetailsType())) {
                sysDepartmentStaffList = sysDepartmentStaffDao.selectDepartmentStaffAll(staffAllDto);
            } else {
                sysDepartmentStaffList = sysDepartmentStaffDao.selectDepartmentStaffRoleAll(staffAllDto);
            }

            for (int i = 0; i < sysDepartmentStaffList.size(); i++) {
                if (sysDepartmentStaffList.get(i).getDepartmentId() != null) {
                    sysDepartmentStaffList.get(i).setDepartmentFlag(true);
                } else {
                    sysDepartmentStaffList.get(i).setDepartmentFlag(false);
                }

            }
            PageInfo<SysStaffAllDto> page = new PageInfo<SysStaffAllDto>(sysDepartmentStaffList);

            return page;
        }

    }

    /**
     * Description: 查询当前部门下的员工
     * @param staffAllDto 查询条件
     * @return 实体集合
     */
    @Override
    public PageInfo<SysStaffAllDto> queryDepartmentStaffRoleMsg(SysStaffAllDto staffAllDto) {
        PageHelper.startPage(staffAllDto.getPageNum(), staffAllDto.getPageSize());
        List<SysStaffAllDto> sysDepartmentStaffList = new ArrayList<>();
        if (ObjectUtils.isEmpty(staffAllDto.getRoleDetailsName()) && ObjectUtils.isEmpty(staffAllDto.getRoleDetailsType())) {
            sysDepartmentStaffList = sysDepartmentStaffDao.selectDepartmentStaff(staffAllDto);
        } else {
            sysDepartmentStaffList = sysDepartmentStaffDao.selectDepartmentStaffRole(staffAllDto);
        }
        PageInfo<SysStaffAllDto> page = new PageInfo<SysStaffAllDto>(sysDepartmentStaffList);

        return page;
    }


    /**
     * Description: 编辑部门员工
     *
     * @param sysDepartmentStaffRelaEditDto 部门员工信息
     * @return 实体集合
     */
    @Override
    public void editDepartmentStaff(SysDepartmentStaffRelaEditDto sysDepartmentStaffRelaEditDto) {

        SysDepartmentStaffRelaEntity sysDepartmentStaffRelaEntity = new SysDepartmentStaffRelaEntity();

        try {
            sysDepartmentStaffRelaEntity =
                    Copiers.beanToBean(sysDepartmentStaffRelaEditDto, SysDepartmentStaffRelaEditDto.class, SysDepartmentStaffRelaEntity.class);
            if (Constants.DepartmentOpe.delete.value().equals(sysDepartmentStaffRelaEditDto.getDepartmentOpe())) {
                iSysDepartmentStaffRelaDao.deleteBySelective(sysDepartmentStaffRelaEntity);
            } else if (Constants.DepartmentOpe.insert.value().equals(sysDepartmentStaffRelaEditDto.getDepartmentOpe())) {

                int sysDepartmentStaffCount = iSysDepartmentStaffRelaDao.selectBySelectiveCount(sysDepartmentStaffRelaEntity);
                if (sysDepartmentStaffCount > 0) {
                    throw new IllegalParameterException("当前员工已存在该部门，不能新增!");
                } else {
                    sysDepartmentStaffRelaEntity.generatePk();
                    sysDepartmentStaffRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                    sysDepartmentStaffRelaEntity.setUpdatedBy(sysDepartmentStaffRelaEntity.getCreatedBy());
                    iSysDepartmentStaffRelaDao.insertSelective(sysDepartmentStaffRelaEntity);
                }
            }


        } finally {
            sysDepartmentStaffRelaEntity = null;
        }


    }
}
