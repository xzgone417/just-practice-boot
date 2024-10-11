package com.exp.ucmp.department.service.impl;

import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.ISysDepartmentInfoDao;
import com.exp.ucmp.dao.ISysDepartmentStaffRelaDao;
import com.exp.ucmp.department.dao.SysDepartmentDao;
import com.exp.ucmp.department.dao.SysDepartmentStaffDao;
import com.exp.ucmp.department.dto.SysDepartmentInfoDelDto;
import com.exp.ucmp.department.dto.SysDepartmentInfoEditDto;
import com.exp.ucmp.department.dto.SysDepartmentInfoDto;
import com.exp.ucmp.department.service.SysDepartmentService;
import com.exp.ucmp.entity.SysDepartmentInfoEntity;
import com.exp.ucmp.entity.SysDepartmentStaffRelaEntity;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.model.Person;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhouchengwei
 * @date 2022年08月09日
 */
@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {

    @Autowired
    private SysDepartmentDao sysDepartmentDao;

    @Autowired
    private ISysDepartmentInfoDao iSysDepartmentInfoDao;

    @Autowired
    private ISysDepartmentStaffRelaDao iSysDepartmentStaffRelaDao;


    /**
     * Description: 根据条件查询集合实体(部门信息)
     * @param sysDepartmentInfoDto 查询条件
     * @return 实体集合
     */
    @Override
    public PageInfo<SysDepartmentInfoDto> queryDepartmentMsg(SysDepartmentInfoDto sysDepartmentInfoDto) {
            PageHelper.startPage(sysDepartmentInfoDto.getPageNum(), sysDepartmentInfoDto.getPageSize());
            List<SysDepartmentInfoDto> sysDepartmentInfoList = sysDepartmentDao.selectDepartmentMsg(sysDepartmentInfoDto);
            PageInfo<SysDepartmentInfoDto> page = new PageInfo<SysDepartmentInfoDto>(sysDepartmentInfoList);
            return page;
    }
    /**
     * Description: 新增部门信息
     * @param sysDepartmentInfoAddDto 新增内容
     */
    @Override
    public void addDepartmentMsg(SysDepartmentInfoEditDto sysDepartmentInfoAddDto) {
        SysDepartmentInfoEntity sysDepartmentInfoEntity = new SysDepartmentInfoEntity();
        sysDepartmentInfoEntity.setDepartmentName(sysDepartmentInfoAddDto.getDepartmentName());
        sysDepartmentInfoEntity.setDepartmentType(Constants.DepartmentType.headquarters.value());
        int departmentCount = iSysDepartmentInfoDao.selectBySelectiveCount(sysDepartmentInfoEntity);
        try {
            if (departmentCount>0){
                throw new IllegalParameterException("部门(" + sysDepartmentInfoAddDto.getDepartmentName() + ")已存在，不能新增!");
            }else {
                sysDepartmentInfoEntity =
                        Copiers.beanToBean(sysDepartmentInfoAddDto, SysDepartmentInfoEditDto.class, SysDepartmentInfoEntity.class);
                sysDepartmentInfoEntity.generatePk();
                sysDepartmentInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                sysDepartmentInfoEntity.setUpdatedBy(sysDepartmentInfoEntity.getCreatedBy());
                sysDepartmentInfoEntity.setDepartmentType(Constants.DepartmentType.headquarters.value());
                iSysDepartmentInfoDao.insertSelective(sysDepartmentInfoEntity);
            }
        } finally {
            sysDepartmentInfoEntity = null;
        }

    }
    /**
     * Description: 修改部门信息
     * @param sysDepartmentInfoEditDto 修改内容
     */
    @Override
    public void modifyDepartmentMsg(SysDepartmentInfoEditDto sysDepartmentInfoEditDto) {
        SysDepartmentInfoEntity sysDepartmentInfoEntity = new SysDepartmentInfoEntity();
        sysDepartmentInfoEntity.setDepartmentCode(sysDepartmentInfoEditDto.getDepartmentCode());
        int codeCount = iSysDepartmentInfoDao.selectBySelectiveCount(sysDepartmentInfoEntity);
        try {
        if (codeCount <=0){
            throw new IllegalParameterException("部门编码(" + sysDepartmentInfoEditDto.getDepartmentCode() + ")不能修改!");
        }else {
            sysDepartmentInfoEntity =
                    Copiers.beanToBean(sysDepartmentInfoEditDto, SysDepartmentInfoEditDto.class, SysDepartmentInfoEntity.class);
            sysDepartmentInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            iSysDepartmentInfoDao.updateSelective(sysDepartmentInfoEntity);
        }

        } finally {
            sysDepartmentInfoEntity = null;
        }
    }
    /**
     * Description: 删除部门信息
     */
    @Override
    public void delDepartmentMsg(SysDepartmentInfoDelDto sysDepartmentInfoDelDto) {
        SysDepartmentInfoEntity sysDepartmentInfoEntity = new SysDepartmentInfoEntity();
        try {
            sysDepartmentInfoEntity =
                    Copiers.beanToBean(sysDepartmentInfoDelDto, SysDepartmentInfoDelDto.class, SysDepartmentInfoEntity.class);
            sysDepartmentInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            SysDepartmentStaffRelaEntity sysDepartmentStaffRelaEntity = new SysDepartmentStaffRelaEntity();
            sysDepartmentStaffRelaEntity.setDepartmentId(sysDepartmentInfoDelDto.getDepartmentId());
            int partyCount = iSysDepartmentStaffRelaDao.selectBySelectiveCount(sysDepartmentStaffRelaEntity);
            if (partyCount>0){
                throw new IllegalParameterException("部门(" + sysDepartmentInfoDelDto.getDepartmentName() + ")下面存在人员,不能删除!");
            }else {
                iSysDepartmentInfoDao.updateSelective(sysDepartmentInfoEntity);
            }


        } finally {
            sysDepartmentInfoEntity = null;
        }
    }



    /**
     * Description: 查询部门名称
     */
    @Override
    public List<Map> queryDepartmentType() {
        return  sysDepartmentDao.selectDepartmentType();
    }
}
