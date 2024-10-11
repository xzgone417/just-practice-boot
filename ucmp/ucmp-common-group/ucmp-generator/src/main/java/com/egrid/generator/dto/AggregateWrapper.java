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

import java.util.ArrayList;
import java.util.List;

import com.egrid.generator.dto.java.FullyQualifiedJavaType;
import com.egrid.generator.dto.table.IntrospectedColumn;
import com.egrid.generator.dto.table.IntrospectedTable;

/**
 * 类DDD里的聚合概念
 * @author yiyongfei
 *
 */
public class AggregateWrapper extends Wrapper{
	private List<FullyQualifiedJavaType> listEntityImport = new ArrayList<FullyQualifiedJavaType>();
	
	public AggregateWrapper(IntrospectedTable arg0, GeneratorConfig config) {
		super(arg0, config.getTablePrefixOverrides(), config.getServiceName(), config.getModuleName(), config.getBasePackagePath());
		
		for(IntrospectedColumn column : arg0.getPrimaryKeyColumns()) {
			if(!column.getFullyQualifiedJavaType().getFullyQualifiedNameWithoutTypeParameters().startsWith("java.lang.")) {
				if(!listEntityImport.contains(column.getFullyQualifiedJavaType())) {
					listEntityImport.add(column.getFullyQualifiedJavaType());
				}
			}
		}
		
		if(!config.getDaoGenerateable()) {
			this.setDaoGenerateable(config.getDaoGenerateable());
		}
		
		String temp = this.getAggregatePackagePath();
		temp = temp.replaceAll("\\.", "\\/");
		if(config.getBuildPath().endsWith("/") || config.getBuildPath().endsWith("\\")) {
			this.setFilePath(config.getBuildPath() + "src/main/java/" + temp + "/");
		} else {
			this.setFilePath(config.getBuildPath() + "/src/main/java/" + temp + "/");
		}
		this.setFileName(this.getAggregateName() + ".java");
		
		this.setFtlName("aggregate.ftl");
	}

	public List<FullyQualifiedJavaType> getListEntityImport() {
		return listEntityImport;
	}	
}
