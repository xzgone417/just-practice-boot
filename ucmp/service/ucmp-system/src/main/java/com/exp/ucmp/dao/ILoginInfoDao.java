/**
 * ILoginInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.LoginInfoEntity;
import com.exp.ucmp.pk.LoginInfoPk;
/**
 * <p>ClassName: ILoginInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ILoginInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_login_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param loginInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(LoginInfoEntity loginInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param loginInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(LoginInfoEntity loginInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listLoginInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<LoginInfoEntity> listLoginInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param loginInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(LoginInfoEntity loginInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param loginInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(LoginInfoEntity loginInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listLoginInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<LoginInfoEntity> listLoginInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listLoginInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<LoginInfoEntity> listLoginInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param loginInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(LoginInfoPk loginInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param loginInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(LoginInfoEntity loginInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param loginInfoPk 主键实体
     * @return loginInfoPk 单个实体对象
     */
    public LoginInfoEntity load(LoginInfoPk loginInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param loginInfoEntity 查询条件
     * @return 实体集合
     */
    public List<LoginInfoEntity> selectBySelective(LoginInfoEntity loginInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param loginInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(LoginInfoEntity loginInfoEntity);
    
}
