/**
 * IUserInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.UserInfoEntity;
import com.exp.ucmp.pk.UserInfoPk;
/**
 * <p>ClassName: IUserInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IUserInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_user_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param userInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(UserInfoEntity userInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param userInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(UserInfoEntity userInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listUserInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<UserInfoEntity> listUserInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param userInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(UserInfoEntity userInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param userInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(UserInfoEntity userInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listUserInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<UserInfoEntity> listUserInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listUserInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<UserInfoEntity> listUserInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param userInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(UserInfoPk userInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param userInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(UserInfoEntity userInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param userInfoPk 主键实体
     * @return userInfoPk 单个实体对象
     */
    public UserInfoEntity load(UserInfoPk userInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param userInfoEntity 查询条件
     * @return 实体集合
     */
    public List<UserInfoEntity> selectBySelective(UserInfoEntity userInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param userInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(UserInfoEntity userInfoEntity);
    
}
