/**
 * ${tableWrapper.daoName}.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package ${tableWrapper.daoPackagePath};

import java.util.List;
<#list tableWrapper.listEntityImport?if_exists as className>
import ${className.fullyQualifiedNameWithoutTypeParameters};
</#list>
import org.apache.ibatis.annotations.Select;
import ${tableWrapper.entityPackagePath}.${tableWrapper.entityName};
import ${tableWrapper.pkPackagePath}.${tableWrapper.pkName};
/**
 * <p>ClassName: ${tableWrapper.daoName}</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ${tableWrapper.daoName} {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_${tableWrapper.tableInfo.introspectedTableName}.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param ${tableWrapper.entityVar} 实体类
     * @return 插入多少行
     */
    public int insert(${tableWrapper.entityName} ${tableWrapper.entityVar});
    /**
     * <p>Description: 选择全字段插入</p>
     * @param ${tableWrapper.entityVar} 实体类
     * @return 插入多少行
     */
    public int insertSelective(${tableWrapper.entityName} ${tableWrapper.entityVar});
    /**
     * <p>Description: 全字段插入</p>
     * @param list${tableWrapper.entityName} 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<${tableWrapper.entityName}> list${tableWrapper.entityName});
    /**
     * <p>Description: 全字段更新</p>
     * @param ${tableWrapper.entityVar} 实体类
     * @return 更新了多少行
     */
    public int update(${tableWrapper.entityName} ${tableWrapper.entityVar});
    /**
     * <p>Description: 选择字段更新</p>
     * @param ${tableWrapper.entityVar} 实体类
     * @return 更新了多少行
     */
    public int updateSelective(${tableWrapper.entityName} ${tableWrapper.entityVar});
    
    /**
     * <p>Description: 全字段更新</p>
     * @param list${tableWrapper.entityName} 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<${tableWrapper.entityName}> list${tableWrapper.entityName});
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param list${tableWrapper.entityName} 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<${tableWrapper.entityName}> list${tableWrapper.entityName});
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param ${tableWrapper.pkVar} 实体类
     * @return 删除了多少行
     */
    public int delete(${tableWrapper.pkName} ${tableWrapper.pkVar});
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param ${tableWrapper.entityVar} 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(${tableWrapper.entityName} ${tableWrapper.entityVar});
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param ${tableWrapper.pkVar} 主键实体
     * @return ${tableWrapper.pkVar} 单个实体对象
     */
    public ${tableWrapper.entityName} load(${tableWrapper.pkName} ${tableWrapper.pkVar});
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param ${tableWrapper.entityVar} 查询条件
     * @return 实体集合
     */
    public List<${tableWrapper.entityName}> selectBySelective(${tableWrapper.entityName} ${tableWrapper.entityVar});
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param ${tableWrapper.entityVar} 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(${tableWrapper.entityName} ${tableWrapper.entityVar});
    
}
