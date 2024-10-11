/**
 * IPersonInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PersonInfoEntity;
import com.exp.ucmp.pk.PersonInfoPk;
/**
 * <p>ClassName: IPersonInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPersonInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_person_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param personInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PersonInfoEntity personInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param personInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PersonInfoEntity personInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPersonInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PersonInfoEntity> listPersonInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param personInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PersonInfoEntity personInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param personInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PersonInfoEntity personInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPersonInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PersonInfoEntity> listPersonInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPersonInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PersonInfoEntity> listPersonInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param personInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PersonInfoPk personInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param personInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PersonInfoEntity personInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param personInfoPk 主键实体
     * @return personInfoPk 单个实体对象
     */
    public PersonInfoEntity load(PersonInfoPk personInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param personInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PersonInfoEntity> selectBySelective(PersonInfoEntity personInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param personInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PersonInfoEntity personInfoEntity);
    
}
