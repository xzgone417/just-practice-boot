/**
 * IPsiCarStockInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.exp.ucmp.car.dto.ApproveChangePriceDto;
import com.exp.ucmp.car.dto.CarMainInfoDto;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.exp.ucmp.pk.PsiCarStockInfoPk;
import com.exp.ucmp.pricing.retail.DiscountBasicDto;
/**
 * <p>ClassName: IPsiCarStockInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarStockInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_stock_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarStockInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarStockInfoEntity psiCarStockInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarStockInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarStockInfoEntity psiCarStockInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarStockInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarStockInfoEntity> listPsiCarStockInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarStockInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarStockInfoEntity psiCarStockInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarStockInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarStockInfoEntity psiCarStockInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarStockInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarStockInfoEntity> listPsiCarStockInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarStockInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarStockInfoEntity> listPsiCarStockInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarStockInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarStockInfoPk psiCarStockInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarStockInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarStockInfoEntity psiCarStockInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarStockInfoPk 主键实体
     * @return psiCarStockInfoPk 单个实体对象
     */
    public PsiCarStockInfoEntity load(PsiCarStockInfoPk psiCarStockInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarStockInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarStockInfoEntity> selectBySelective(PsiCarStockInfoEntity psiCarStockInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarStockInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarStockInfoEntity psiCarStockInfoEntity);
    
    /**
     * Description: 根据条件查询集合实体（不包括已售出的车辆信息）
     * @param psiCarStockInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarStockInfoEntity> selectNewBySelective(PsiCarStockInfoEntity psiCarStockInfoEntity);
    
	public CarMainInfoDto getCarInfoByVin(@Param("stockId")Long stockId,@Param("vinCode") String vinCode);
	
	public DiscountBasicDto queryChangePriceInfo(Long stockId);
	
	public Double queryCarSalePrice(Long stockId);
	
	public String selectDictValue(String reason);

}
