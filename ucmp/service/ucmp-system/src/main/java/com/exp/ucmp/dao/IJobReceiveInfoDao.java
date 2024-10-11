/**
 * IJobReceiveInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.JobReceiveInfoEntity;
import com.exp.ucmp.pk.JobReceiveInfoPk;
/**
 * <p>ClassName: IJobReceiveInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IJobReceiveInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_job_receive_info.Nextval from dual")
    public long selectSequence() ;
    /**
     * <p>Description: 全字段插入</p>
     * @param jobReceiveInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(JobReceiveInfoEntity jobReceiveInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param jobReceiveInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(JobReceiveInfoEntity jobReceiveInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listJobReceiveInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<JobReceiveInfoEntity> listJobReceiveInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param jobReceiveInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(JobReceiveInfoEntity jobReceiveInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param jobReceiveInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(JobReceiveInfoEntity jobReceiveInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listJobReceiveInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<JobReceiveInfoEntity> listJobReceiveInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listJobReceiveInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<JobReceiveInfoEntity> listJobReceiveInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param jobReceiveInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(JobReceiveInfoPk jobReceiveInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param jobReceiveInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(JobReceiveInfoEntity jobReceiveInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param jobReceiveInfoPk 主键实体
     * @return jobReceiveInfoPk 单个实体对象
     */
    public JobReceiveInfoEntity load(JobReceiveInfoPk jobReceiveInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param jobReceiveInfoEntity 查询条件
     * @return 实体集合
     */
    public List<JobReceiveInfoEntity> selectBySelective(JobReceiveInfoEntity jobReceiveInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param jobReceiveInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(JobReceiveInfoEntity jobReceiveInfoEntity);
    
}
