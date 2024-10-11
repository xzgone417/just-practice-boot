package com.exp.ucmp.entity;


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

@ApiModel(value = "SysJpushTemplateConfigEntity", description = "消息模板配置表")
@GroupSequence({SysJpushTemplateConfigEntity.class, SysJpushTemplateConfigEntity.SysJpushTemplateConfigEntityValidGroup.class,SysJpushTemplateConfigEntity.TemplateIdValidGroup.class,SysJpushTemplateConfigEntity.TemplateTypeValidGroup.class,SysJpushTemplateConfigEntity.CategoryValidGroup.class,SysJpushTemplateConfigEntity.TriggerNameValidGroup.class,SysJpushTemplateConfigEntity.TitleValidGroup.class,SysJpushTemplateConfigEntity.ContentValidGroup.class,SysJpushTemplateConfigEntity.UrlValidGroup.class}) 
public class SysJpushTemplateConfigEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 消息模板id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "消息模板id 不能是Null", groups = {SysJpushTemplateConfigEntityValidGroup.class, TemplateIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="消息模板id 数字精度必须符合(19,0)", groups = {SysJpushTemplateConfigEntityValidGroup.class, TemplateIdValidGroup.class})
    @ApiModelProperty(value = "消息模板id")
    private Long templateId;
    
    
    /**
     * 模板类型
     */
    @Size(min=0, max=100, message="模板类型 字符长度必须小于等于100", groups = {SysJpushTemplateConfigEntityValidGroup.class, TemplateTypeValidGroup.class})
    @ApiModelProperty(value = "模板类型")
    private String templateType;
    
    /**
     * 业务模块
     */
    @Size(min=0, max=255, message="业务模块 字符长度必须小于等于255", groups = {SysJpushTemplateConfigEntityValidGroup.class, CategoryValidGroup.class})
    @ApiModelProperty(value = "业务模块")
    private String category;
    
    /**
     * 触发点
     */
    @Size(min=0, max=255, message="触发点 字符长度必须小于等于255", groups = {SysJpushTemplateConfigEntityValidGroup.class, TriggerNameValidGroup.class})
    @ApiModelProperty(value = "触发点")
    private String triggerName;
    
    /**
     * 标题
     */
    @NotNull(message = "标题 不能是Null", groups = {SysJpushTemplateConfigEntityValidGroup.class, TitleValidGroup.class})
    @Size(min=0, max=255, message="标题 字符长度必须小于等于255", groups = {SysJpushTemplateConfigEntityValidGroup.class, TitleValidGroup.class})
    @ApiModelProperty(value = "标题")
    private String title;
    
    /**
     * 内容
     */
    @NotNull(message = "内容 不能是Null", groups = {SysJpushTemplateConfigEntityValidGroup.class, ContentValidGroup.class})
    @Size(min=0, max=255, message="内容 字符长度必须小于等于255", groups = {SysJpushTemplateConfigEntityValidGroup.class, ContentValidGroup.class})
    @ApiModelProperty(value = "内容")
    private String content;
    
    /**
     * 跳转地址
     */
    @Size(min=0, max=255, message="跳转地址 字符长度必须小于等于255", groups = {SysJpushTemplateConfigEntityValidGroup.class, UrlValidGroup.class})
    @ApiModelProperty(value = "跳转地址")
    private String url;
    
    public SysJpushTemplateConfigEntity() {
    }
    
    public SysJpushTemplateConfigEntity(Long templateId) {
        this.templateId = templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
    public Long getTemplateId() {
        return this.templateId;
    }
    

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }
    public String getTemplateType() {
        return this.templateType;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return this.category;
    }
    
    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }
    public String getTriggerName() {
        return this.triggerName;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return this.url;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (templateId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                templateId = RandomIDGennerator.get().generate();
    }

    public interface SysJpushTemplateConfigEntityValidGroup {}
    public interface TemplateIdValidGroup {}
    public interface TemplateTypeValidGroup {}
    public interface CategoryValidGroup {}
    public interface TriggerNameValidGroup {}
    public interface TitleValidGroup {}
    public interface ContentValidGroup {}
    public interface UrlValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            SysJpushTemplateConfigEntity.TemplateIdValidGroup.class
            , SysJpushTemplateConfigEntity.TemplateTypeValidGroup.class
            , SysJpushTemplateConfigEntity.CategoryValidGroup.class
            , SysJpushTemplateConfigEntity.TriggerNameValidGroup.class
            , SysJpushTemplateConfigEntity.TitleValidGroup.class
            , SysJpushTemplateConfigEntity.ContentValidGroup.class
            , SysJpushTemplateConfigEntity.UrlValidGroup.class
        };
    }
}
