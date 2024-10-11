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

@ApiModel(value = "SysUserBehaviorParamsEntity", description = "用户行为记录参数")
@GroupSequence({SysUserBehaviorParamsEntity.class, SysUserBehaviorParamsEntity.SysUserBehaviorParamsEntityValidGroup.class,SysUserBehaviorParamsEntity.BehaviorIdValidGroup.class,SysUserBehaviorParamsEntity.RequestIdValidGroup.class,SysUserBehaviorParamsEntity.BehaviorTagsValidGroup.class,SysUserBehaviorParamsEntity.BehaviorTimeValidGroup.class}) 
public class SysUserBehaviorParamsEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 用户行为ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "用户行为ID 不能是Null", groups = {SysUserBehaviorParamsEntityValidGroup.class, BehaviorIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="用户行为ID 数字精度必须符合(19,0)", groups = {SysUserBehaviorParamsEntityValidGroup.class, BehaviorIdValidGroup.class})
    @ApiModelProperty(value = "用户行为ID")
    private Long behaviorId;
    
    
    /**
     * 请求ID
     */
    @NotNull(message = "请求ID 不能是Null", groups = {SysUserBehaviorParamsEntityValidGroup.class, RequestIdValidGroup.class})
    @Size(min=0, max=50, message="请求ID 字符长度必须小于等于50", groups = {SysUserBehaviorParamsEntityValidGroup.class, RequestIdValidGroup.class})
    @ApiModelProperty(value = "请求ID")
    private String requestId;
    
    /**
     * 行为标签
     */
    @Size(min=0, max=500, message="行为标签 字符长度必须小于等于500", groups = {SysUserBehaviorParamsEntityValidGroup.class, BehaviorTagsValidGroup.class})
    @ApiModelProperty(value = "行为标签")
    private String behaviorTags;
    
    /**
     * 行为发生时间
     */
    @NotNull(message = "行为发生时间 不能是Null", groups = {SysUserBehaviorParamsEntityValidGroup.class, BehaviorTimeValidGroup.class})
    @Digits(integer=19, fraction=0, message="行为发生时间 数字精度必须符合(19,0)", groups = {SysUserBehaviorParamsEntityValidGroup.class, BehaviorTimeValidGroup.class})
    @ApiModelProperty(value = "行为发生时间")
    private Long behaviorTime;
    
    /**
     * Query上的参数
     */
    @ApiModelProperty(value = "Query上的参数")
    private String queryParams;
    
    /**
     * Post请求体里的参数
     */
    @ApiModelProperty(value = "Post请求体里的参数")
    private String bodyParams;
    
    public SysUserBehaviorParamsEntity() {
    }
    
    public SysUserBehaviorParamsEntity(Long behaviorId) {
        this.behaviorId = behaviorId;
    }

    public void setBehaviorId(Long behaviorId) {
        this.behaviorId = behaviorId;
    }
    public Long getBehaviorId() {
        return this.behaviorId;
    }
    

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public String getRequestId() {
        return this.requestId;
    }
    
    public void setBehaviorTags(String behaviorTags) {
        this.behaviorTags = behaviorTags;
    }
    public String getBehaviorTags() {
        return this.behaviorTags;
    }
    
    public void setBehaviorTime(Long behaviorTime) {
        this.behaviorTime = behaviorTime;
    }
    public Long getBehaviorTime() {
        return this.behaviorTime;
    }
    
    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }
    public String getQueryParams() {
        return this.queryParams;
    }
    
    public void setBodyParams(String bodyParams) {
        this.bodyParams = bodyParams;
    }
    public String getBodyParams() {
        return this.bodyParams;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (behaviorId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                behaviorId = RandomIDGennerator.get().generate();
    }

    public interface SysUserBehaviorParamsEntityValidGroup {}
    public interface BehaviorIdValidGroup {}
    public interface RequestIdValidGroup {}
    public interface BehaviorTagsValidGroup {}
    public interface BehaviorTimeValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            SysUserBehaviorParamsEntity.BehaviorIdValidGroup.class
            , SysUserBehaviorParamsEntity.RequestIdValidGroup.class
            , SysUserBehaviorParamsEntity.BehaviorTagsValidGroup.class
            , SysUserBehaviorParamsEntity.BehaviorTimeValidGroup.class
        };
    }
}
