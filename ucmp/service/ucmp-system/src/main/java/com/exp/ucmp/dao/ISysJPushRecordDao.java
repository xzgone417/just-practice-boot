package com.exp.ucmp.dao;

import com.exp.ucmp.entity.SysJpushRecordEntity;

/**
 * <p>@ClassName: ISysJPushRecordDao</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/15 14:40<p>
 */
public interface ISysJPushRecordDao {

    /**
     * <p>Description: 全字段插入</p>
     * @param sysJPushRecordEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysJpushRecordEntity sysJPushRecordEntity);
}
