/**
 * IJobReceiveReqDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.JobReceiveReqEntity;
import com.exp.ucmp.pk.JobReceiveReqPk;
/**
 * <p>ClassName: IJobReceiveReqDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IJobReceiveReqDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_job_receive_req.Nextval from dual")
    public long selectSequence() ;
    /**
     * <p>Description: 全字段插入</p>
     * @param jobReceiveReqEntity 实体类
     * @return 插入多少行
     */
    public int insert(JobReceiveReqEntity jobReceiveReqEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param jobReceiveReqEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(JobReceiveReqEntity jobReceiveReqEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listJobReceiveReqEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<JobReceiveReqEntity> listJobReceiveReqEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param jobReceiveReqEntity 实体类
     * @return 更新了多少行
     */
    public int update(JobReceiveReqEntity jobReceiveReqEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param jobReceiveReqEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(JobReceiveReqEntity jobReceiveReqEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listJobReceiveReqEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<JobReceiveReqEntity> listJobReceiveReqEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listJobReceiveReqEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<JobReceiveReqEntity> listJobReceiveReqEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param jobReceiveReqPk 实体类
     * @return 删除了多少行
     */
    public int delete(JobReceiveReqPk jobReceiveReqPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param jobReceiveReqEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(JobReceiveReqEntity jobReceiveReqEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param jobReceiveReqPk 主键实体
     * @return jobReceiveReqPk 单个实体对象
     */
    public JobReceiveReqEntity load(JobReceiveReqPk jobReceiveReqPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param jobReceiveReqEntity 查询条件
     * @return 实体集合
     */
    public List<JobReceiveReqEntity> selectBySelective(JobReceiveReqEntity jobReceiveReqEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param jobReceiveReqEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(JobReceiveReqEntity jobReceiveReqEntity);
    
}
