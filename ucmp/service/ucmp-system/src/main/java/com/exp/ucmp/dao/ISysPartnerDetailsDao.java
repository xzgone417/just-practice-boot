/**
 * ISysPartnerDetailsDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysPartnerDetailsEntity;
import com.exp.ucmp.pk.SysPartnerDetailsPk;
/**
 * <p>ClassName: ISysPartnerDetailsDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysPartnerDetailsDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_partner_details.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysPartnerDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysPartnerDetailsEntity sysPartnerDetailsEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysPartnerDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysPartnerDetailsEntity sysPartnerDetailsEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysPartnerDetailsEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysPartnerDetailsEntity> listSysPartnerDetailsEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysPartnerDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysPartnerDetailsEntity sysPartnerDetailsEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysPartnerDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysPartnerDetailsEntity sysPartnerDetailsEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysPartnerDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysPartnerDetailsEntity> listSysPartnerDetailsEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysPartnerDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysPartnerDetailsEntity> listSysPartnerDetailsEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysPartnerDetailsPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysPartnerDetailsPk sysPartnerDetailsPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysPartnerDetailsEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysPartnerDetailsEntity sysPartnerDetailsEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysPartnerDetailsPk 主键实体
     * @return sysPartnerDetailsPk 单个实体对象
     */
    public SysPartnerDetailsEntity load(SysPartnerDetailsPk sysPartnerDetailsPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysPartnerDetailsEntity 查询条件
     * @return 实体集合
     */
    public List<SysPartnerDetailsEntity> selectBySelective(SysPartnerDetailsEntity sysPartnerDetailsEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysPartnerDetailsEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysPartnerDetailsEntity sysPartnerDetailsEntity);
    
}
