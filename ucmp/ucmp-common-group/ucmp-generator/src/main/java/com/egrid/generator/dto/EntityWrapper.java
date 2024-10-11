/**
 * Copyright 2017 伊永飞
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.egrid.generator.dto;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.egrid.generator.dto.java.FullyQualifiedJavaType;
import com.egrid.generator.dto.table.IntrospectedColumn;
import com.egrid.generator.dto.table.IntrospectedTable;

/**
 * 类DDD里的实体概念
 * 
 * @author yiyongfei
 *
 */
public class EntityWrapper extends Wrapper {
    private List<FullyQualifiedJavaType> listEntityImport = new ArrayList<FullyQualifiedJavaType>();
    private List<String> listClassImport = new ArrayList<String>();

    public EntityWrapper(IntrospectedTable arg0, GeneratorConfig config) {
        super(arg0, config.getTablePrefixOverrides(), config.getServiceName(), config.getModuleName(),
                config.getBasePackagePath());

        for (IntrospectedColumn column : arg0.getNonPrimaryKeyColumns()) {
            if (column.getFullyQualifiedJavaType().getFullyQualifiedNameWithoutTypeParameters().endsWith("[]")) {
                continue;
            }
            if (!column.getFullyQualifiedJavaType().getFullyQualifiedNameWithoutTypeParameters()
                    .startsWith("java.lang.")) {
                if (!listEntityImport.contains(column.getFullyQualifiedJavaType())) {
                    listEntityImport.add(column.getFullyQualifiedJavaType());
                }
                if (column.getJdbcType() == Types.TIMESTAMP || column.getJdbcType() == Types.TIME
                        || column.getJdbcType() == Types.DATE) {
                    FullyQualifiedJavaType tmpType = new FullyQualifiedJavaType(DateTimeFormat.class.getName());
                    if (!listEntityImport.contains(tmpType)) {
                        listEntityImport.add(tmpType);
                    }
                }
            }
        }
        for (IntrospectedColumn column : arg0.getAllColumns()) {
            if (column.getJdbcType() == Types.BIGINT || column.getJdbcType() == Types.DECIMAL) {
                listClassImport.add("com.fasterxml.jackson.databind.annotation.JsonSerialize");
                listClassImport.add("com.fasterxml.jackson.databind.ser.std.ToStringSerializer");
                break;
            }
        }
        for (IntrospectedColumn column : arg0.getAllColumns()) {
            if (!column.isNullable()) {
                if (!listClassImport.contains("javax.validation.constraints.NotNull")) {
                    listClassImport.add("javax.validation.constraints.NotNull");
                }
            }
            if (column.getLength() > 0) {
                if (column.getJdbcType() == Types.VARCHAR || column.getJdbcType() == Types.CHAR) {
                    if (!listClassImport.contains("javax.validation.constraints.Size")) {
                        listClassImport.add("javax.validation.constraints.Size");
                    }
                } else if (column.getJdbcType() == Types.BIGINT || column.getJdbcType() == Types.DECIMAL
                        || column.getJdbcType() == Types.DOUBLE || column.getJdbcType() == Types.FLOAT
                        || column.getJdbcType() == Types.INTEGER || column.getJdbcType() == Types.NUMERIC
                        || column.getJdbcType() == Types.SMALLINT) {
                    if (!listClassImport.contains("javax.validation.constraints.Digits")) {
                        listClassImport.add("javax.validation.constraints.Digits");
                    }
                }
            }
        }

        if (!config.getDaoGenerateable()) {
            this.setDaoPackagePath(config.getCommonDaoPackagePath());
            this.setDaoName(config.getCommonDaoName());
            this.setDaoGenerateable(config.getDaoGenerateable());
        }

        String temp = this.getEntityPackagePath();
        temp = temp.replaceAll("\\.", "\\/");
        if (config.getBuildPath().endsWith("/") || config.getBuildPath().endsWith("\\")) {
            this.setFilePath(config.getBuildPath() + "src/main/java/" + temp + "/");
        } else {
            this.setFilePath(config.getBuildPath() + "/src/main/java/" + temp + "/");
        }
        this.setFileName(this.getEntityName() + ".java");

        this.setFtlName("entity.ftl");
    }

    public List<FullyQualifiedJavaType> getListEntityImport() {
        return listEntityImport;
    }

    public List<String> getListClassImport() {
        return listClassImport;
    }
}
