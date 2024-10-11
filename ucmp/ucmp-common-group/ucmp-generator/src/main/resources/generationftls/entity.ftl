package ${tableWrapper.entityPackagePath};

<#list tableWrapper.listEntityImport?if_exists as className>
import ${className.fullyQualifiedNameWithoutTypeParameters};
</#list>

<#list tableWrapper.listClassImport?if_exists as className>
import ${className};
</#list>
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "${tableWrapper.entityName}", description = "${tableWrapper.tableInfo.remarks}")
@GroupSequence({${tableWrapper.entityName}.class, ${tableWrapper.entityName}.${tableWrapper.entityName}ValidGroup.class<#t>
<#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as field>
     ,${tableWrapper.entityName}.${field.javaMethod}ValidGroup.class<#t>
</#list>
<#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as field>
   <#assign isValidateGroup = false>
   <#if field.nullable == false >
    <#assign isValidateGroup = true>
   </#if>
   <#if field.jdbcType == 1 || field.jdbcType == 12 >
    <#if field.length gt 0 >
     <#assign isValidateGroup = true>
    </#if>
   <#elseif field.jdbcType == -5 || field.jdbcType == 3 || field.jdbcType == 8 || field.jdbcType == 6 || field.jdbcType == 4 || field.jdbcType == 2 || field.jdbcType == 5 >
    <#if field.length gt 0 >
     <#assign isValidateGroup = true>
    </#if>
   </#if>
   <#if isValidateGroup == true >
    ,${tableWrapper.entityName}.${field.javaMethod}ValidGroup.class<#t>
   </#if>
</#list>
}) 
public class ${tableWrapper.entityName} extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
<#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as field>
   <#if field.remarks?? >
    /**
     * ${(field.remarks)!}
     */
   </#if>
   <#if field.jdbcType == 4 || field.jdbcType == -5 >
    @JsonSerialize(using = ToStringSerializer.class)
   </#if>
   <#if field.remarks?? >
    @NotNull(message = "${(field.remarks)!} 不能是Null", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
   <#else>
    @NotNull(message = "${field.javaProperty} 不能是Null", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
   </#if>
   <#if field.jdbcType == 1 || field.jdbcType == 12 >
    <#if field.length gt 0 >
     <#if field.remarks?? >
    @Size(min=0, max=${field.length?c}, message="${(field.remarks)!} 字符长度必须小于等于${field.length?c}", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
     <#else>
    @Size(min=0, max=${field.length?c}, message="${field.javaProperty} 字符长度必须小于等于${field.length?c}", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
     </#if>
    </#if>
   <#elseif field.jdbcType == -5 || field.jdbcType == 3 || field.jdbcType == 8 || field.jdbcType == 6 || field.jdbcType == 4 || field.jdbcType == 2 || field.jdbcType == 5 >
    <#if field.length gt 0 >
     <#if field.remarks?? >
    @Digits(integer=${field.length?c}, fraction=${field.scale?c}, message="${(field.remarks)!} 数字精度必须符合(${field.length?c},${field.scale?c})", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
     <#else>
    @Digits(integer=${field.length?c}, fraction=${field.scale?c}, message="${field.javaProperty} 数字精度必须符合(${field.length?c},${field.scale?c})", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
     </#if>
    </#if>
   </#if>
    @ApiModelProperty(value = "${(field.remarks)!}")
    private ${field.fullyQualifiedJavaType.shortNameWithoutTypeArguments} ${field.javaProperty};
    
</#list>
    
<#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as field>
   <#if field.remarks?? >
    /**
     * ${(field.remarks)!}
     */
   </#if>
   <#--数据库字段类型是Date类型-->
   <#if field.jdbcType == 91 >
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
   </#if>
   <#--数据库字段类型是Time类型-->
   <#if field.jdbcType == 92 >
    @DateTimeFormat(pattern = "HH:mm:ss")
   </#if>
   <#--数据库字段类型是Timestamp类型-->
   <#if field.jdbcType == 93 >
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   </#if>
   <#if field.nullable == false >
    <#if field.remarks?? >
    @NotNull(message = "${(field.remarks)!} 不能是Null", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
    <#else>
    @NotNull(message = "${field.javaProperty} 不能是Null", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
    </#if>
   </#if>
   <#if field.jdbcType == 1 || field.jdbcType == 12 >
    <#if field.length gt 0 >
     <#if field.remarks?? >
    @Size(min=0, max=${field.length?c}, message="${(field.remarks)!} 字符长度必须小于等于${field.length?c}", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
     <#else>
    @Size(min=0, max=${field.length?c}, message="${field.javaProperty} 字符长度必须小于等于${field.length?c}", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
     </#if>
    </#if>
   <#elseif field.jdbcType == -5 || field.jdbcType == 3 || field.jdbcType == 8 || field.jdbcType == 6 || field.jdbcType == 4 || field.jdbcType == 2 || field.jdbcType == 5 >
    <#if field.length gt 0 >
     <#if field.remarks?? >
    @Digits(integer=${field.length?c}, fraction=${field.scale?c}, message="${(field.remarks)!} 数字精度必须符合(${field.length?c},${field.scale?c})", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
     <#else>
    @Digits(integer=${field.length?c}, fraction=${field.scale?c}, message="${field.javaProperty} 数字精度必须符合(${field.length?c},${field.scale?c})", groups = {${tableWrapper.entityName}ValidGroup.class, ${field.javaMethod}ValidGroup.class})
     </#if>
    </#if>
   </#if>
    @ApiModelProperty(value = "${(field.remarks)!}")
    private ${field.fullyQualifiedJavaType.shortNameWithoutTypeArguments} ${field.javaProperty}<#if field.defaultValue?? > = "${field.defaultValue}"</#if>;
    
</#list>
    public ${tableWrapper.entityName}() {
    }
    
    public ${tableWrapper.entityName}(<#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as field>${field.fullyQualifiedJavaType.shortNameWithoutTypeArguments} ${field.javaProperty}<#if field_has_next>,</#if></#list>) {
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

<#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as field>
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
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
        <#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as field>
           <#if field.jdbcType == 4 || field.jdbcType == -5 >
                ${field.javaProperty} = RandomIDGennerator.get().generate();
           <#else>
                ${field.javaProperty} = null;
           </#if>
        </#list>
    }

    public interface ${tableWrapper.entityName}ValidGroup {}
<#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as field>
    public interface ${field.javaMethod}ValidGroup {}
</#list>
<#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as field>
   <#assign isValidateGroup = false>
   <#if field.nullable == false >
    <#assign isValidateGroup = true>
   </#if>
   <#if field.jdbcType == 1 || field.jdbcType == 12 >
    <#if field.length gt 0 >
     <#assign isValidateGroup = true>
    </#if>
   <#elseif field.jdbcType == -5 || field.jdbcType == 3 || field.jdbcType == 8 || field.jdbcType == 6 || field.jdbcType == 4 || field.jdbcType == 2 || field.jdbcType == 5 >
    <#if field.length gt 0 >
     <#assign isValidateGroup = true>
    </#if>
   </#if>
   <#if isValidateGroup == true >
    public interface ${field.javaMethod}ValidGroup {}
   </#if>
</#list>

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
<#assign index = 0>
<#list tableWrapper.tableInfo.primaryKeyColumns?if_exists as field>
            <#if index != 0>, </#if>${tableWrapper.entityName}.${field.javaMethod}ValidGroup.class<#assign index = index + 1>
</#list>
<#list tableWrapper.tableInfo.nonPrimaryKeyColumns?if_exists as field>
   <#assign isValidateGroup = false>
   <#if field.nullable == false >
    <#assign isValidateGroup = true>
   </#if>
   <#if field.jdbcType == 1 || field.jdbcType == 12 >
    <#if field.length gt 0 >
     <#assign isValidateGroup = true>
    </#if>
   <#elseif field.jdbcType == -5 || field.jdbcType == 3 || field.jdbcType == 8 || field.jdbcType == 6 || field.jdbcType == 4 || field.jdbcType == 2 || field.jdbcType == 5 >
    <#if field.length gt 0 >
     <#assign isValidateGroup = true>
    </#if>
   </#if>
   <#if isValidateGroup == true >
            , ${tableWrapper.entityName}.${field.javaMethod}ValidGroup.class
   </#if>
</#list>
        };
    }
}
