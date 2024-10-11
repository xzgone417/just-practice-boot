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

@ApiModel(value = "SysKeyWordEntity", description = "关键字表")
@GroupSequence({SysKeyWordEntity.class, SysKeyWordEntity.SysKeyWordEntityValidGroup.class,SysKeyWordEntity.KeyWordsIdValidGroup.class,SysKeyWordEntity.KeyWordsValidGroup.class,SysKeyWordEntity.KeyWordsTypeValidGroup.class,SysKeyWordEntity.CreatedByValidGroup.class,SysKeyWordEntity.CreatedDateValidGroup.class,SysKeyWordEntity.UpdatedByValidGroup.class,SysKeyWordEntity.UpdatedDateValidGroup.class,SysKeyWordEntity.IsDeleteValidGroup.class}) 
public class SysKeyWordEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键id 不能是Null", groups = {SysKeyWordEntityValidGroup.class, KeyWordsIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键id 数字精度必须符合(19,0)", groups = {SysKeyWordEntityValidGroup.class, KeyWordsIdValidGroup.class})
    @ApiModelProperty(value = "主键id")
    private Long keyWordsId;
    
    
    /**
     * 关键字
     */
    @NotNull(message = "关键字 不能是Null", groups = {SysKeyWordEntityValidGroup.class, KeyWordsValidGroup.class})
    @Size(min=0, max=10, message="关键字 字符长度必须小于等于10", groups = {SysKeyWordEntityValidGroup.class, KeyWordsValidGroup.class})
    @ApiModelProperty(value = "关键字")
    private String keyWords;
    
    /**
     * 关键字类型  1 维修记录抓取关键字
     */
    @NotNull(message = "关键字类型  1 维修记录抓取关键字 不能是Null", groups = {SysKeyWordEntityValidGroup.class, KeyWordsTypeValidGroup.class})
    @Digits(integer=10, fraction=0, message="关键字类型  1 维修记录抓取关键字 数字精度必须符合(10,0)", groups = {SysKeyWordEntityValidGroup.class, KeyWordsTypeValidGroup.class})
    @ApiModelProperty(value = "关键字类型  1 维修记录抓取关键字")
    private Integer keyWordsType;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysKeyWordEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysKeyWordEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysKeyWordEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysKeyWordEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysKeyWordEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysKeyWordEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {SysKeyWordEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {SysKeyWordEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public SysKeyWordEntity() {
    }
    
    public SysKeyWordEntity(Long keyWordsId) {
        this.keyWordsId = keyWordsId;
    }

    public void setKeyWordsId(Long keyWordsId) {
        this.keyWordsId = keyWordsId;
    }
    public Long getKeyWordsId() {
        return this.keyWordsId;
    }
    

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
    public String getKeyWords() {
        return this.keyWords;
    }
    
    public void setKeyWordsType(Integer keyWordsType) {
        this.keyWordsType = keyWordsType;
    }
    public Integer getKeyWordsType() {
        return this.keyWordsType;
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
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (keyWordsId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                keyWordsId = RandomIDGennerator.get().generate();
    }

    public interface SysKeyWordEntityValidGroup {}
    public interface KeyWordsIdValidGroup {}
    public interface KeyWordsValidGroup {}
    public interface KeyWordsTypeValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            SysKeyWordEntity.KeyWordsIdValidGroup.class
            , SysKeyWordEntity.KeyWordsValidGroup.class
            , SysKeyWordEntity.KeyWordsTypeValidGroup.class
            , SysKeyWordEntity.CreatedByValidGroup.class
            , SysKeyWordEntity.CreatedDateValidGroup.class
            , SysKeyWordEntity.UpdatedByValidGroup.class
            , SysKeyWordEntity.UpdatedDateValidGroup.class
            , SysKeyWordEntity.IsDeleteValidGroup.class
        };
    }
}
