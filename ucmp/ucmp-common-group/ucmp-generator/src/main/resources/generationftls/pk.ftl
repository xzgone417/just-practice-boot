package ${tableWrapper.pkPackagePath};

<#list tableWrapper.listEntityImport?if_exists as className>
import ${className.fullyQualifiedNameWithoutTypeParameters};
</#list>

import com.egrid.core.base.entity.AbstractBasePk;

public class ${tableWrapper.pkName} extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
<#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as field>
   <#if field.remarks?? >
    /**
     * ${(field.remarks)!}
     */
   </#if>
    private ${field.fullyQualifiedJavaType.shortNameWithoutTypeArguments} ${field.javaProperty};
    
</#list>
    public ${tableWrapper.pkName}() {
    }
    
    public ${tableWrapper.pkName}(<#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as field>${field.fullyQualifiedJavaType.shortNameWithoutTypeArguments} ${field.javaProperty}<#if field_has_next>,</#if></#list>) {
    <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as field>
        this.${field.javaProperty} = ${field.javaProperty};
    </#list>
    }

<#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as field>
    public void set${field.javaMethod}(${field.fullyQualifiedJavaType.shortNameWithoutTypeArguments} ${field.javaProperty}) {
        this.${field.javaProperty} = ${field.javaProperty};
    }
    public ${field.fullyQualifiedJavaType.shortNameWithoutTypeArguments} get${field.javaMethod}() {
        return this.${field.javaProperty};
    }
    
</#list>
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
        <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as field>
           <#if field.jdbcType == 1 || field.jdbcType == 12 >
              (${field.javaProperty} == null || ${field.javaProperty}.trim().length() == 0)
           <#else>
              (${field.javaProperty} == null)
           </#if>
           <#if field_has_next>||</#if>
        </#list>
               ? true : false;
    }
    
}
