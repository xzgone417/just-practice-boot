package com.exp.ucmp.entity;


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

@ApiModel(value = "SysUserBehaviorResponseEntity", description = "用户行为响应记录")
@GroupSequence({SysUserBehaviorResponseEntity.class, SysUserBehaviorResponseEntity.SysUserBehaviorResponseEntityValidGroup.class,SysUserBehaviorResponseEntity.RequestIdValidGroup.class,SysUserBehaviorResponseEntity.HttpStatusValidGroup.class,SysUserBehaviorResponseEntity.ResponseCodeValidGroup.class,SysUserBehaviorResponseEntity.ResponseTimeValidGroup.class}) 
public class SysUserBehaviorResponseEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 请求ID
     */
    @NotNull(message = "请求ID 不能是Null", groups = {SysUserBehaviorResponseEntityValidGroup.class, RequestIdValidGroup.class})
    @Size(min=0, max=50, message="请求ID 字符长度必须小于等于50", groups = {SysUserBehaviorResponseEntityValidGroup.class, RequestIdValidGroup.class})
    @ApiModelProperty(value = "请求ID")
    private String requestId;
    
    
    /**
     * HTTP状态
     */
    @Size(min=0, max=10, message="HTTP状态 字符长度必须小于等于10", groups = {SysUserBehaviorResponseEntityValidGroup.class, HttpStatusValidGroup.class})
    @ApiModelProperty(value = "HTTP状态")
    private String httpStatus;
    
    /**
     * 响应编码
     */
    @Size(min=0, max=10, message="响应编码 字符长度必须小于等于10", groups = {SysUserBehaviorResponseEntityValidGroup.class, ResponseCodeValidGroup.class})
    @ApiModelProperty(value = "响应编码")
    private String responseCode;
    
    /**
     * 响应时间
     */
    @Digits(integer=19, fraction=0, message="响应时间 数字精度必须符合(19,0)", groups = {SysUserBehaviorResponseEntityValidGroup.class, ResponseTimeValidGroup.class})
    @ApiModelProperty(value = "响应时间")
    private Long responseTime;
    
    /**
     * 响应结果
     */
    @ApiModelProperty(value = "响应结果")
    private String behaviorResponse;
    
    public SysUserBehaviorResponseEntity() {
    }
    
    public SysUserBehaviorResponseEntity(String requestId) {
        this.requestId = requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public String getRequestId() {
        return this.requestId;
    }
    

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }
    public String getHttpStatus() {
        return this.httpStatus;
    }
    
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    public String getResponseCode() {
        return this.responseCode;
    }
    
    public void setResponseTime(Long responseTime) {
        this.responseTime = responseTime;
    }
    public Long getResponseTime() {
        return this.responseTime;
    }
    
    public void setBehaviorResponse(String behaviorResponse) {
        this.behaviorResponse = behaviorResponse;
    }
    public String getBehaviorResponse() {
        return this.behaviorResponse;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (requestId == null || requestId.trim().length() == 0)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                requestId = null;
    }

    public interface SysUserBehaviorResponseEntityValidGroup {}
    public interface RequestIdValidGroup {}
    public interface HttpStatusValidGroup {}
    public interface ResponseCodeValidGroup {}
    public interface ResponseTimeValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            SysUserBehaviorResponseEntity.RequestIdValidGroup.class
            , SysUserBehaviorResponseEntity.HttpStatusValidGroup.class
            , SysUserBehaviorResponseEntity.ResponseCodeValidGroup.class
            , SysUserBehaviorResponseEntity.ResponseTimeValidGroup.class
        };
    }
}
