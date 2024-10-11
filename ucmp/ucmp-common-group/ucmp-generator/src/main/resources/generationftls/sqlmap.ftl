<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${tableWrapper.daoPackagePath}.${tableWrapper.daoName}" >
<#--Freemark注意点：
    1、boolean值的处理，不要用isXXX
    2、类似#的特殊字符，可以使用${r'#'}来转义
  -->
  <#if tableWrapper.daoGenerateable > 
    <#assign sqlidPrefix=""/>
  <#else>
    <#assign sqlidPrefix=tableWrapper.aggregateVar + "_" />
  </#if>
  <#assign resultMapName=tableWrapper.aggregateVar + "ResultMap"/>
  <#assign entityMapName=tableWrapper.aggregateVar + "EntityMap"/>
  <#assign pkMapName=tableWrapper.aggregateVar + "PKMap"/>
  
  <insert id="${sqlidPrefix}insert" parameterType="${tableWrapper.entityPackagePath}.${tableWrapper.entityName}" >
    INSERT INTO ${tableWrapper.tableInfo.introspectedTableName} 
       (
      <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
          ${column.actualColumnName},
      </#list>
      <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
          ${column.actualColumnName}<#if column_has_next>,</#if>
      </#list>
        ) VALUES (
      <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
          ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}},
      </#list>
      <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
          ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}}<#if column_has_next>,</#if>
      </#list>
        )
  </insert>
  
  <insert id="${sqlidPrefix}insertSelective" parameterType="${tableWrapper.entityPackagePath}.${tableWrapper.entityName}" >
    INSERT INTO ${tableWrapper.tableInfo.introspectedTableName}
      <trim prefix="(" suffix=")" suffixOverrides="," >
        <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
        <if test="${column.javaProperty} != null" >
          ${column.actualColumnName},
          </if>
        </#list>
        <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
        <if test="${column.javaProperty} != null" >
          ${column.actualColumnName},
          </if>
        </#list>
      </trim>
    VALUES
      <trim prefix="(" suffix=")" suffixOverrides="," >
        <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
        <if test="${column.javaProperty} != null" >
          ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}},
          </if>
        </#list>
        <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
        <if test="${column.javaProperty} != null" >
          ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}},
          </if>
        </#list>
      </trim>
  </insert>
  <insert id="${sqlidPrefix}batchInsert" parameterType="java.util.List" >
        
    INSERT INTO ${tableWrapper.tableInfo.introspectedTableName} 
       (
      <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
          ${column.actualColumnName},
      </#list>
      <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
          ${column.actualColumnName}<#if column_has_next>,</#if>
      </#list>
        ) VALUES 
      <foreach collection="list" item="item" index="index" separator=",">
     	(
	      <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
	          ${r'#'}{item.${column.javaProperty}, jdbcType=${column.jdbcTypeName}},
	      </#list>
	      <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
	          ${r'#'}{item.${column.javaProperty}, jdbcType=${column.jdbcTypeName}}<#if column_has_next>,</#if>
	      </#list>
        )
       </foreach>
  </insert>
  <update id="${sqlidPrefix}update" parameterType="${tableWrapper.entityPackagePath}.${tableWrapper.entityName}" >
    UPDATE ${tableWrapper.tableInfo.introspectedTableName} SET 
        <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
          ${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}}<#if column_has_next>,</#if>
        </#list>
     WHERE
     <trim prefixOverrides="AND">
          <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
           AND ${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}} 
          </#list>
     </trim>
  </update>
  
  <update id="${sqlidPrefix}updateSelective" parameterType="${tableWrapper.entityPackagePath}.${tableWrapper.entityName}" >
    UPDATE ${tableWrapper.tableInfo.introspectedTableName}
      <trim prefix="SET" suffixOverrides="," >
        <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
        <if test="${column.javaProperty} != null" >
          ${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}},
          </if>
        </#list>
      </trim>
      WHERE
     <trim prefixOverrides="AND">
         <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
           AND ${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}}
         </#list>
     </trim>
  </update>
  
  <update id="${sqlidPrefix}batchUpdate" parameterType="java.util.List" >
     <foreach collection="list" item="item" index="index" open="" close="" separator=";">
	    UPDATE ${tableWrapper.tableInfo.introspectedTableName} SET 
	        <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
	          ${column.actualColumnName} = ${r'#'}{item.${column.javaProperty}, jdbcType=${column.jdbcTypeName}}<#if column_has_next>,</#if>
	        </#list>
	     WHERE
	     <trim prefixOverrides="AND">
	          <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
	           AND ${column.actualColumnName} = ${r'#'}{item.${column.javaProperty}, jdbcType=${column.jdbcTypeName}} 
	          </#list>
	     </trim>
     </foreach>
  </update>
  
  <update id="${sqlidPrefix}batchUpdateSelective" parameterType="java.util.List" >
     <foreach collection="list" item="item" index="index" open="" close="" separator=";">
	    UPDATE ${tableWrapper.tableInfo.introspectedTableName}
	      <trim prefix="SET" suffixOverrides="," >
	        <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
	        <if test="item.${column.javaProperty} != null" >
	          ${column.actualColumnName} = ${r'#'}{item.${column.javaProperty}, jdbcType=${column.jdbcTypeName}},
	          </if>
	        </#list>
	      </trim>
	      WHERE
	     <trim prefixOverrides="AND">
	         <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
	           AND ${column.actualColumnName} = ${r'#'}{item.${column.javaProperty}, jdbcType=${column.jdbcTypeName}}
	         </#list>
	     </trim>
     </foreach>
  </update>
  
  <delete id="${sqlidPrefix}delete" parameterType="${tableWrapper.pkPackagePath}.${tableWrapper.pkName}" >
    DELETE FROM ${tableWrapper.tableInfo.introspectedTableName}
    WHERE
     <trim prefixOverrides="AND">
         <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
           AND ${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}}
         </#list>
     </trim>
  </delete>
  
  <delete id="${sqlidPrefix}deleteBySelective" parameterType="${tableWrapper.entityPackagePath}.${tableWrapper.entityName}" >
    DELETE FROM ${tableWrapper.tableInfo.introspectedTableName}
    WHERE
     <trim prefixOverrides="AND" >
     <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
        <#if column.jdbcType == 1 || column.jdbcType == 12 >
        <if test="${column.javaProperty} != null and ${column.javaProperty} != ''" >
        <#else>
        <if test="${column.javaProperty} != null" >
        </#if>
          AND ${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}}
        </if>
     </#list>
     <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
        <#if column.jdbcType == 1 || column.jdbcType == 12 >
        <if test="${column.javaProperty} != null and ${column.javaProperty} != ''" >
        <#else>
        <if test="${column.javaProperty} != null" >
        </#if>
          AND ${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}}
        </if>
     </#list>
     </trim>
  </delete>
  
  <resultMap id="${resultMapName}" type="${tableWrapper.entityPackagePath}.${tableWrapper.entityName}" >
      <constructor>
     <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
       <#if column.jdbcType == 4 || column.jdbcType == -5 >
       <idArg column="${column.actualColumnName}" javaType="${column.fullyQualifiedJavaType.shortNameWithoutTypeArguments}" jdbcType="${column.jdbcTypeName}"/>
       <#else>
       <arg column="${column.actualColumnName}" javaType="${column.fullyQualifiedJavaType.shortNameWithoutTypeArguments}" jdbcType="${column.jdbcTypeName}"/>
       </#if>
     </#list>
    </constructor>
  <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
    <result column="${column.actualColumnName}" property="${column.javaProperty}" jdbcType="${column.jdbcTypeName}" />
  </#list>
  </resultMap>
  
  <sql id="${tableWrapper.tableInfo.introspectedTableName}_Column_List" >
    <#list tableWrapper.tableInfo.allColumns?if_exists as column>
    ${r'a.'}${column.actualColumnName}<#if column_has_next>,</#if>
    </#list>
  </sql>
  
  <select id="${sqlidPrefix}load" parameterType="${tableWrapper.pkPackagePath}.${tableWrapper.pkName}" resultMap="${resultMapName}">
    SELECT 
    <include refid="${tableWrapper.tableInfo.introspectedTableName}_Column_List" />
      FROM ${tableWrapper.tableInfo.introspectedTableName} a
     WHERE 1 = 1
     <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
       AND ${r'a.'}${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}}
     </#list>
  </select>
  
  <select id="${sqlidPrefix}selectBySelective" parameterType="${tableWrapper.entityPackagePath}.${tableWrapper.entityName}" resultMap="${resultMapName}">
    SELECT 
    <include refid="${tableWrapper.tableInfo.introspectedTableName}_Column_List" />
      FROM ${tableWrapper.tableInfo.introspectedTableName} a
      <trim prefix="WHERE" prefixOverrides="AND" >
     <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
        <#if column.jdbcType == 1 || column.jdbcType == 12 >
        <if test="${column.javaProperty} != null and ${column.javaProperty} != ''" >
        <#else>
        <if test="${column.javaProperty} != null" >
        </#if>
          AND ${r'a.'}${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}}
        </if>
     </#list>
     <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
        <#if column.jdbcType == 1 || column.jdbcType == 12 >
        <if test="${column.javaProperty} != null and ${column.javaProperty} != ''" >
        <#else>
        <if test="${column.javaProperty} != null" >
        </#if>
          AND ${r'a.'}${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}}
        </if>
     </#list>
      </trim>
  </select>
  <select id="${sqlidPrefix}selectBySelectiveCount" parameterType="${tableWrapper.entityPackagePath}.${tableWrapper.entityName}" resultType="int">
    SELECT count(1) FROM ${tableWrapper.tableInfo.introspectedTableName} a
      <trim prefix="WHERE" prefixOverrides="AND" >
     <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as column>
        <#if column.jdbcType == 1 || column.jdbcType == 12 >
        <if test="${column.javaProperty} != null and ${column.javaProperty} != ''" >
        <#else>
        <if test="${column.javaProperty} != null" >
        </#if>
          AND ${r'a.'}${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}}
        </if>
     </#list>
     <#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as column>
        <#if column.jdbcType == 1 || column.jdbcType == 12 >
        <if test="${column.javaProperty} != null and ${column.javaProperty} != ''" >
        <#else>
        <if test="${column.javaProperty} != null" >
        </#if>
          AND ${r'a.'}${column.actualColumnName} = ${r'#'}{${column.javaProperty}, jdbcType=${column.jdbcTypeName}}
        </if>
     </#list>
      </trim>
  </select>
</mapper>