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

@ApiModel(value = "SysUserBehaviorEntity", description = "用户行为记录")
@GroupSequence({SysUserBehaviorEntity.class, SysUserBehaviorEntity.SysUserBehaviorEntityValidGroup.class,SysUserBehaviorEntity.BehaviorIdValidGroup.class,SysUserBehaviorEntity.UserIdValidGroup.class,SysUserBehaviorEntity.BehaviorTypeValidGroup.class,SysUserBehaviorEntity.BehaviorTargetValidGroup.class,SysUserBehaviorEntity.BehaviorTargetUrlValidGroup.class,SysUserBehaviorEntity.BehaviorTimeValidGroup.class,SysUserBehaviorEntity.BehaviorEndpointValidGroup.class}) 
public class SysUserBehaviorEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 用户行为ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "用户行为ID 不能是Null", groups = {SysUserBehaviorEntityValidGroup.class, BehaviorIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="用户行为ID 数字精度必须符合(19,0)", groups = {SysUserBehaviorEntityValidGroup.class, BehaviorIdValidGroup.class})
    @ApiModelProperty(value = "用户行为ID")
    private Long behaviorId;
    
    
    /**
     * 用户ID，对应Party_id
     */
    @NotNull(message = "用户ID，对应Party_id 不能是Null", groups = {SysUserBehaviorEntityValidGroup.class, UserIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="用户ID，对应Party_id 数字精度必须符合(19,0)", groups = {SysUserBehaviorEntityValidGroup.class, UserIdValidGroup.class})
    @ApiModelProperty(value = "用户ID，对应Party_id")
    private Long userId;
    
    /**
     * 行为类型：01、系统行为，02、其他行为
     */
    @NotNull(message = "行为类型：01、系统行为，02、其他行为 不能是Null", groups = {SysUserBehaviorEntityValidGroup.class, BehaviorTypeValidGroup.class})
    @Size(min=0, max=2, message="行为类型：01、系统行为，02、其他行为 字符长度必须小于等于2", groups = {SysUserBehaviorEntityValidGroup.class, BehaviorTypeValidGroup.class})
    @ApiModelProperty(value = "行为类型：01、系统行为，02、其他行为")
    private String behaviorType;
    
    /**
     * 目标：如果是系统行为，固定为system或gateway，如果是其他行为，为对应的渠道等
     */
    @NotNull(message = "目标：如果是系统行为，固定为system或gateway，如果是其他行为，为对应的渠道等 不能是Null", groups = {SysUserBehaviorEntityValidGroup.class, BehaviorTargetValidGroup.class})
    @Size(min=0, max=50, message="目标：如果是系统行为，固定为system或gateway，如果是其他行为，为对应的渠道等 字符长度必须小于等于50", groups = {SysUserBehaviorEntityValidGroup.class, BehaviorTargetValidGroup.class})
    @ApiModelProperty(value = "目标：如果是系统行为，固定为system或gateway，如果是其他行为，为对应的渠道等")
    private String behaviorTarget;
    
    /**
     * 目标URL
     */
    @NotNull(message = "目标URL 不能是Null", groups = {SysUserBehaviorEntityValidGroup.class, BehaviorTargetUrlValidGroup.class})
    @Size(min=0, max=765, message="目标URL 字符长度必须小于等于765", groups = {SysUserBehaviorEntityValidGroup.class, BehaviorTargetUrlValidGroup.class})
    @ApiModelProperty(value = "目标URL")
    private String behaviorTargetUrl;
    
    /**
     * 行为发生时间
     */
    @NotNull(message = "行为发生时间 不能是Null", groups = {SysUserBehaviorEntityValidGroup.class, BehaviorTimeValidGroup.class})
    @Digits(integer=19, fraction=0, message="行为发生时间 数字精度必须符合(19,0)", groups = {SysUserBehaviorEntityValidGroup.class, BehaviorTimeValidGroup.class})
    @ApiModelProperty(value = "行为发生时间")
    private Long behaviorTime;
    
    /**
     * 行为发生对应的终端设备
     */
    @Size(min=0, max=50, message="行为发生对应的终端设备 字符长度必须小于等于50", groups = {SysUserBehaviorEntityValidGroup.class, BehaviorEndpointValidGroup.class})
    @ApiModelProperty(value = "行为发生对应的终端设备")
    private String behaviorEndpoint;
    
    public SysUserBehaviorEntity() {
    }
    
    public SysUserBehaviorEntity(Long behaviorId) {
        this.behaviorId = behaviorId;
    }

    public void setBehaviorId(Long behaviorId) {
        this.behaviorId = behaviorId;
    }
    public Long getBehaviorId() {
        return this.behaviorId;
    }
    

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getUserId() {
        return this.userId;
    }
    
    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }
    public String getBehaviorType() {
        return this.behaviorType;
    }
    
    public void setBehaviorTarget(String behaviorTarget) {
        this.behaviorTarget = behaviorTarget;
    }
    public String getBehaviorTarget() {
        return this.behaviorTarget;
    }
    
    public void setBehaviorTargetUrl(String behaviorTargetUrl) {
        this.behaviorTargetUrl = behaviorTargetUrl;
    }
    public String getBehaviorTargetUrl() {
        return this.behaviorTargetUrl;
    }
    
    public void setBehaviorTime(Long behaviorTime) {
        this.behaviorTime = behaviorTime;
    }
    public Long getBehaviorTime() {
        return this.behaviorTime;
    }
    
    public void setBehaviorEndpoint(String behaviorEndpoint) {
        this.behaviorEndpoint = behaviorEndpoint;
    }
    public String getBehaviorEndpoint() {
        return this.behaviorEndpoint;
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

    public interface SysUserBehaviorEntityValidGroup {}
    public interface BehaviorIdValidGroup {}
    public interface UserIdValidGroup {}
    public interface BehaviorTypeValidGroup {}
    public interface BehaviorTargetValidGroup {}
    public interface BehaviorTargetUrlValidGroup {}
    public interface BehaviorTimeValidGroup {}
    public interface BehaviorEndpointValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            SysUserBehaviorEntity.BehaviorIdValidGroup.class
            , SysUserBehaviorEntity.UserIdValidGroup.class
            , SysUserBehaviorEntity.BehaviorTypeValidGroup.class
            , SysUserBehaviorEntity.BehaviorTargetValidGroup.class
            , SysUserBehaviorEntity.BehaviorTargetUrlValidGroup.class
            , SysUserBehaviorEntity.BehaviorTimeValidGroup.class
            , SysUserBehaviorEntity.BehaviorEndpointValidGroup.class
        };
    }
}
