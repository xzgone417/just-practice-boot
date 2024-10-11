package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "SysDatadictTypeCodeEntity", description = "数据字典分类表")
@GroupSequence({SysDatadictTypeCodeEntity.class, SysDatadictTypeCodeEntity.SysDatadictTypeCodeEntityValidGroup.class,SysDatadictTypeCodeEntity.DictTagValidGroup.class,SysDatadictTypeCodeEntity.DictNameValidGroup.class,SysDatadictTypeCodeEntity.DictPrefixValidGroup.class,SysDatadictTypeCodeEntity.DictTypeValidGroup.class,SysDatadictTypeCodeEntity.CreatedByValidGroup.class,SysDatadictTypeCodeEntity.CreatedDateValidGroup.class,SysDatadictTypeCodeEntity.UpdatedByValidGroup.class,SysDatadictTypeCodeEntity.UpdatedDateValidGroup.class}) 
public class SysDatadictTypeCodeEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 分类编码
     */
    @NotNull(message = "分类编码 不能是Null", groups = {SysDatadictTypeCodeEntityValidGroup.class, DictTagValidGroup.class})
    @Size(min=0, max=20, message="分类编码 字符长度必须小于等于20", groups = {SysDatadictTypeCodeEntityValidGroup.class, DictTagValidGroup.class})
    @ApiModelProperty(value = "分类编码")
    private String dictTag;
    
    
    /**
     * 分类名称
     */
    @NotNull(message = "分类名称 不能是Null", groups = {SysDatadictTypeCodeEntityValidGroup.class, DictNameValidGroup.class})
    @Size(min=0, max=50, message="分类名称 字符长度必须小于等于50", groups = {SysDatadictTypeCodeEntityValidGroup.class, DictNameValidGroup.class})
    @ApiModelProperty(value = "分类名称")
    private String dictName;
    
    /**
     * 字典前缀，表示该字典的内容以前缀_开头，设置字典时使用
     */
    @Size(min=0, max=10, message="字典前缀，表示该字典的内容以前缀_开头，设置字典时使用 字符长度必须小于等于10", groups = {SysDatadictTypeCodeEntityValidGroup.class, DictPrefixValidGroup.class})
    @ApiModelProperty(value = "字典前缀，表示该字典的内容以前缀_开头，设置字典时使用")
    private String dictPrefix;
    
    /**
     * 字典类型，01、系统字典(不可维护)；02、用户字典(可维护)
     */
    @NotNull(message = "字典类型，01、系统字典(不可维护)；02、用户字典(可维护) 不能是Null", groups = {SysDatadictTypeCodeEntityValidGroup.class, DictTypeValidGroup.class})
    @Size(min=0, max=2, message="字典类型，01、系统字典(不可维护)；02、用户字典(可维护) 字符长度必须小于等于2", groups = {SysDatadictTypeCodeEntityValidGroup.class, DictTypeValidGroup.class})
    @ApiModelProperty(value = "字典类型，01、系统字典(不可维护)；02、用户字典(可维护)")
    private String dictType;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysDatadictTypeCodeEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysDatadictTypeCodeEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysDatadictTypeCodeEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysDatadictTypeCodeEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysDatadictTypeCodeEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysDatadictTypeCodeEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysDatadictTypeCodeEntity() {
    }
    
    public SysDatadictTypeCodeEntity(String dictTag) {
        this.dictTag = dictTag;
    }

    public void setDictTag(String dictTag) {
        this.dictTag = dictTag;
    }
    public String getDictTag() {
        return this.dictTag;
    }
    

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }
    public String getDictName() {
        return this.dictName;
    }
    
    public void setDictPrefix(String dictPrefix) {
        this.dictPrefix = dictPrefix;
    }
    public String getDictPrefix() {
        return this.dictPrefix;
    }
    
    public void setDictType(String dictType) {
        this.dictType = dictType;
    }
    public String getDictType() {
        return this.dictType;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Long getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (dictTag == null || dictTag.trim().length() == 0)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                dictTag = null;
    }

    public interface SysDatadictTypeCodeEntityValidGroup {}
    public interface DictTagValidGroup {}
    public interface DictNameValidGroup {}
    public interface DictPrefixValidGroup {}
    public interface DictTypeValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            DictTagValidGroup.class
            , DictNameValidGroup.class
            , DictPrefixValidGroup.class
            , DictTypeValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
