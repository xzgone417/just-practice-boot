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

@ApiModel(value = "SysJpushRecordEntity", description = "极光消息记录表")
@GroupSequence({SysJpushRecordEntity.class, SysJpushRecordEntity.SysJpushRecordEntityValidGroup.class,SysJpushRecordEntity.JpushIdValidGroup.class,SysJpushRecordEntity.TemplateIdValidGroup.class,SysJpushRecordEntity.TypeValidGroup.class,SysJpushRecordEntity.RelevanceIdValidGroup.class,SysJpushRecordEntity.CreatedByValidGroup.class,SysJpushRecordEntity.CreatedDateValidGroup.class,SysJpushRecordEntity.UpdatedByValidGroup.class,SysJpushRecordEntity.UpdatedDateValidGroup.class}) 
public class SysJpushRecordEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键ID 不能是Null", groups = {SysJpushRecordEntityValidGroup.class, JpushIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键ID 数字精度必须符合(19,0)", groups = {SysJpushRecordEntityValidGroup.class, JpushIdValidGroup.class})
    @ApiModelProperty(value = "主键ID")
    private Long jpushId;
    
    
    /**
     * 消息模板ID
     */
    @NotNull(message = "消息模板ID 不能是Null", groups = {SysJpushRecordEntityValidGroup.class, TemplateIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="消息模板ID 数字精度必须符合(19,0)", groups = {SysJpushRecordEntityValidGroup.class, TemplateIdValidGroup.class})
    @ApiModelProperty(value = "消息模板ID")
    private Long templateId;
    
    /**
     * 类型
     */
    @Size(min=0, max=2, message="类型 字符长度必须小于等于2", groups = {SysJpushRecordEntityValidGroup.class, TypeValidGroup.class})
    @ApiModelProperty(value = "类型")
    private String type;
    
    /**
     * 关联ID业务线索订单id
     */
    @Digits(integer=19, fraction=0, message="关联ID业务线索订单id 数字精度必须符合(19,0)", groups = {SysJpushRecordEntityValidGroup.class, RelevanceIdValidGroup.class})
    @ApiModelProperty(value = "关联ID业务线索订单id")
    private Long relevanceId;
    
    /**
     * 创建人
     */
    @NotNull(message = "创建人 不能是Null", groups = {SysJpushRecordEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人 数字精度必须符合(19,0)", groups = {SysJpushRecordEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysJpushRecordEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人
     */
    @NotNull(message = "更新人 不能是Null", groups = {SysJpushRecordEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人 数字精度必须符合(19,0)", groups = {SysJpushRecordEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysJpushRecordEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 请求参数
     */
    @ApiModelProperty(value = "请求参数")
    private String requestParam;
    
    /**
     * 响回参数
     */
    @ApiModelProperty(value = "响回参数")
    private String responseParam;
    
    public SysJpushRecordEntity() {
    }
    
    public SysJpushRecordEntity(Long jpushId) {
        this.jpushId = jpushId;
    }

    public void setJpushId(Long jpushId) {
        this.jpushId = jpushId;
    }
    public Long getJpushId() {
        return this.jpushId;
    }
    

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
    public Long getTemplateId() {
        return this.templateId;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
    
    public void setRelevanceId(Long relevanceId) {
        this.relevanceId = relevanceId;
    }
    public Long getRelevanceId() {
        return this.relevanceId;
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
    
    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam;
    }
    public String getRequestParam() {
        return this.requestParam;
    }
    
    public void setResponseParam(String responseParam) {
        this.responseParam = responseParam;
    }
    public String getResponseParam() {
        return this.responseParam;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (jpushId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                jpushId = RandomIDGennerator.get().generate();
    }

    public interface SysJpushRecordEntityValidGroup {}
    public interface JpushIdValidGroup {}
    public interface TemplateIdValidGroup {}
    public interface TypeValidGroup {}
    public interface RelevanceIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            SysJpushRecordEntity.JpushIdValidGroup.class
            , SysJpushRecordEntity.TemplateIdValidGroup.class
            , SysJpushRecordEntity.TypeValidGroup.class
            , SysJpushRecordEntity.RelevanceIdValidGroup.class
            , SysJpushRecordEntity.CreatedByValidGroup.class
            , SysJpushRecordEntity.CreatedDateValidGroup.class
            , SysJpushRecordEntity.UpdatedByValidGroup.class
            , SysJpushRecordEntity.UpdatedDateValidGroup.class
        };
    }
}
