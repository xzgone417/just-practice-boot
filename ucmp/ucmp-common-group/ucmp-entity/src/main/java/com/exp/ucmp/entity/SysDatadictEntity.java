package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "SysDatadictEntity", description = "")
@GroupSequence({SysDatadictEntity.class, SysDatadictEntity.SysDatadictEntityValidGroup.class,SysDatadictEntity.DictIdValidGroup.class,SysDatadictEntity.DictTagValidGroup.class,SysDatadictEntity.DictCodeValidGroup.class,SysDatadictEntity.DictPrefixValidGroup.class,SysDatadictEntity.DictValueValidGroup.class,SysDatadictEntity.DictStatusValidGroup.class,SysDatadictEntity.DictRemarksValidGroup.class,SysDatadictEntity.CreatedByValidGroup.class,SysDatadictEntity.CreatedDateValidGroup.class,SysDatadictEntity.UpdatedByValidGroup.class,SysDatadictEntity.UpdatedDateValidGroup.class,SysDatadictEntity.TSysDatadictcolValidGroup.class}) 
public class SysDatadictEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * PKID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "PKID 不能是Null", groups = {SysDatadictEntityValidGroup.class, DictIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="PKID 数字精度必须符合(19,0)", groups = {SysDatadictEntityValidGroup.class, DictIdValidGroup.class})
    @ApiModelProperty(value = "PKID")
    private Long dictId;
    
    
    /**
     * 分类编码
     */
    @NotNull(message = "分类编码 不能是Null", groups = {SysDatadictEntityValidGroup.class, DictTagValidGroup.class})
    @Size(min=0, max=20, message="分类编码 字符长度必须小于等于20", groups = {SysDatadictEntityValidGroup.class, DictTagValidGroup.class})
    @ApiModelProperty(value = "分类编码")
    private String dictTag;
    
    /**
     * 字典编码
     */
    @NotNull(message = "字典编码 不能是Null", groups = {SysDatadictEntityValidGroup.class, DictCodeValidGroup.class})
    @Size(min=0, max=500, message="字典编码 字符长度必须小于等于500", groups = {SysDatadictEntityValidGroup.class, DictCodeValidGroup.class})
    @ApiModelProperty(value = "字典编码")
    private String dictCode;
    
    /**
     * 字典前缀，使用时字典值为字典前缀+字典编码
     */
    @Size(min=0, max=10, message="字典前缀，使用时字典值为字典前缀+字典编码 字符长度必须小于等于10", groups = {SysDatadictEntityValidGroup.class, DictPrefixValidGroup.class})
    @ApiModelProperty(value = "字典前缀，使用时字典值为字典前缀+字典编码")
    private String dictPrefix;
    
    /**
     * 字典值
     */
    @NotNull(message = "字典值 不能是Null", groups = {SysDatadictEntityValidGroup.class, DictValueValidGroup.class})
    @Size(min=0, max=500, message="字典值 字符长度必须小于等于500", groups = {SysDatadictEntityValidGroup.class, DictValueValidGroup.class})
    @ApiModelProperty(value = "字典值")
    private String dictValue;
    
    /**
     * 字典状态：00、已失效；01、已生效；02、未生效
     */
    @NotNull(message = "字典状态：00、已失效；01、已生效；02、未生效 不能是Null", groups = {SysDatadictEntityValidGroup.class, DictStatusValidGroup.class})
    @Size(min=0, max=2, message="字典状态：00、已失效；01、已生效；02、未生效 字符长度必须小于等于2", groups = {SysDatadictEntityValidGroup.class, DictStatusValidGroup.class})
    @ApiModelProperty(value = "字典状态：00、已失效；01、已生效；02、未生效")
    private String dictStatus;
    
    /**
     * 
     */
    @Size(min=0, max=500, message=" 字符长度必须小于等于500", groups = {SysDatadictEntityValidGroup.class, DictRemarksValidGroup.class})
    @ApiModelProperty(value = "")
    private String dictRemarks;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysDatadictEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysDatadictEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysDatadictEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysDatadictEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysDatadictEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysDatadictEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 
     */
    @Size(min=0, max=45, message=" 字符长度必须小于等于45", groups = {SysDatadictEntityValidGroup.class, TSysDatadictcolValidGroup.class})
    @ApiModelProperty(value = "")
    private String tSysDatadictcol;
    
    public SysDatadictEntity() {
    }
    
    public SysDatadictEntity(Long dictId) {
        this.dictId = dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }
    public Long getDictId() {
        return this.dictId;
    }
    

    public void setDictTag(String dictTag) {
        this.dictTag = dictTag;
    }
    public String getDictTag() {
        return this.dictTag;
    }
    
    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }
    public String getDictCode() {
        return this.dictCode;
    }
    
    public void setDictPrefix(String dictPrefix) {
        this.dictPrefix = dictPrefix;
    }
    public String getDictPrefix() {
        return this.dictPrefix;
    }
    
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }
    public String getDictValue() {
        return this.dictValue;
    }
    
    public void setDictStatus(String dictStatus) {
        this.dictStatus = dictStatus;
    }
    public String getDictStatus() {
        return this.dictStatus;
    }
    
    public void setDictRemarks(String dictRemarks) {
        this.dictRemarks = dictRemarks;
    }
    public String getDictRemarks() {
        return this.dictRemarks;
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
    
    public void setTSysDatadictcol(String tSysDatadictcol) {
        this.tSysDatadictcol = tSysDatadictcol;
    }
    public String getTSysDatadictcol() {
        return this.tSysDatadictcol;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (dictId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                dictId = RandomIDGennerator.get().generate();
    }

    public interface SysDatadictEntityValidGroup {}
    public interface DictIdValidGroup {}
    public interface DictTagValidGroup {}
    public interface DictCodeValidGroup {}
    public interface DictPrefixValidGroup {}
    public interface DictValueValidGroup {}
    public interface DictStatusValidGroup {}
    public interface DictRemarksValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface TSysDatadictcolValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            DictIdValidGroup.class
            , DictTagValidGroup.class
            , DictCodeValidGroup.class
            , DictPrefixValidGroup.class
            , DictValueValidGroup.class
            , DictStatusValidGroup.class
            , DictRemarksValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , TSysDatadictcolValidGroup.class
        };
    }
}
