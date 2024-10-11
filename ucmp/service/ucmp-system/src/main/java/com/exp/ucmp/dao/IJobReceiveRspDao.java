/**
 * IJobReceiveRspDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.JobReceiveRspEntity;
import com.exp.ucmp.pk.JobReceiveRspPk;
/**
 * <p>ClassName: IJobReceiveRspDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IJobReceiveRspDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_job_receive_rsp.Nextval from dual")
    public long selectSequence() ;
    /**
     * <p>Description: 全字段插入</p>
     * @param jobReceiveRspEntity 实体类
     * @return 插入多少行
     */
    public int insert(JobReceiveRspEntity jobReceiveRspEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param jobReceiveRspEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(JobReceiveRspEntity jobReceiveRspEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listJobReceiveRspEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<JobReceiveRspEntity> listJobReceiveRspEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param jobReceiveRspEntity 实体类
     * @return 更新了多少行
     */
    public int update(JobReceiveRspEntity jobReceiveRspEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param jobReceiveRspEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(JobReceiveRspEntity jobReceiveRspEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listJobReceiveRspEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<JobReceiveRspEntity> listJobReceiveRspEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listJobReceiveRspEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<JobReceiveRspEntity> listJobReceiveRspEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param jobReceiveRspPk 实体类
     * @return 删除了多少行
     */
    public int delete(JobReceiveRspPk jobReceiveRspPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param jobReceiveRspEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(JobReceiveRspEntity jobReceiveRspEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param jobReceiveRspPk 主键实体
     * @return jobReceiveRspPk 单个实体对象
     */
    public JobReceiveRspEntity load(JobReceiveRspPk jobReceiveRspPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param jobReceiveRspEntity 查询条件
     * @return 实体集合
     */
    public List<JobReceiveRspEntity> selectBySelective(JobReceiveRspEntity jobReceiveRspEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param jobReceiveRspEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(JobReceiveRspEntity jobReceiveRspEntity);
    
}
