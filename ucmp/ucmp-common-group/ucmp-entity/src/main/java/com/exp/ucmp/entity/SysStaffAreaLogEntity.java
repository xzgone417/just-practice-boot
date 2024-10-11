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

@ApiModel(value = "SysStaffAreaLogEntity", description = "区域日志记录表")
@GroupSequence({SysStaffAreaLogEntity.class, SysStaffAreaLogEntity.SysStaffAreaLogEntityValidGroup.class,SysStaffAreaLogEntity.LogIdValidGroup.class,SysStaffAreaLogEntity.LogOpePersonIdValidGroup.class,SysStaffAreaLogEntity.OpePersonIdValidGroup.class,SysStaffAreaLogEntity.LogOpeContentValidGroup.class,SysStaffAreaLogEntity.LogOpeDateValidGroup.class,SysStaffAreaLogEntity.CreatedByValidGroup.class,SysStaffAreaLogEntity.CreatedDateValidGroup.class,SysStaffAreaLogEntity.UpdatedByValidGroup.class,SysStaffAreaLogEntity.UpdatedDateValidGroup.class}) 
public class SysStaffAreaLogEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = " 不能是Null", groups = {SysStaffAreaLogEntityValidGroup.class, LogIdValidGroup.class})
    @Digits(integer=19, fraction=0, message=" 数字精度必须符合(19,0)", groups = {SysStaffAreaLogEntityValidGroup.class, LogIdValidGroup.class})
    @ApiModelProperty(value = "")
    private Long logId;
    
    
    /**
     * 操作人标识
     */
    @Digits(integer=19, fraction=0, message="操作人标识 数字精度必须符合(19,0)", groups = {SysStaffAreaLogEntityValidGroup.class, LogOpePersonIdValidGroup.class})
    @ApiModelProperty(value = "操作人标识")
    private Long logOpePersonId;
    
    /**
     * 被操作人标识
     */
    @NotNull(message = "被操作人标识 不能是Null", groups = {SysStaffAreaLogEntityValidGroup.class, OpePersonIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="被操作人标识 数字精度必须符合(19,0)", groups = {SysStaffAreaLogEntityValidGroup.class, OpePersonIdValidGroup.class})
    @ApiModelProperty(value = "被操作人标识")
    private Long opePersonId;
    
    /**
     * 操作内容
     */
    @NotNull(message = "操作内容 不能是Null", groups = {SysStaffAreaLogEntityValidGroup.class, LogOpeContentValidGroup.class})
    @Size(min=0, max=500, message="操作内容 字符长度必须小于等于500", groups = {SysStaffAreaLogEntityValidGroup.class, LogOpeContentValidGroup.class})
    @ApiModelProperty(value = "操作内容")
    private String logOpeContent;
    
    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "操作时间 不能是Null", groups = {SysStaffAreaLogEntityValidGroup.class, LogOpeDateValidGroup.class})
    @ApiModelProperty(value = "操作时间")
    private Date logOpeDate;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysStaffAreaLogEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysStaffAreaLogEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysStaffAreaLogEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysStaffAreaLogEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysStaffAreaLogEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysStaffAreaLogEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysStaffAreaLogEntity() {
    }
    
    public SysStaffAreaLogEntity(Long logId) {
        this.logId = logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }
    public Long getLogId() {
        return this.logId;
    }
    

    public void setLogOpePersonId(Long logOpePersonId) {
        this.logOpePersonId = logOpePersonId;
    }
    public Long getLogOpePersonId() {
        return this.logOpePersonId;
    }
    
    public void setOpePersonId(Long opePersonId) {
        this.opePersonId = opePersonId;
    }
    public Long getOpePersonId() {
        return this.opePersonId;
    }
    
    public void setLogOpeContent(String logOpeContent) {
        this.logOpeContent = logOpeContent;
    }
    public String getLogOpeContent() {
        return this.logOpeContent;
    }
    
    public void setLogOpeDate(Date logOpeDate) {
        this.logOpeDate = logOpeDate;
    }
    public Date getLogOpeDate() {
        return this.logOpeDate;
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
              (logId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                logId = RandomIDGennerator.get().generate();
    }

    public interface SysStaffAreaLogEntityValidGroup {}
    public interface LogIdValidGroup {}
    public interface LogOpePersonIdValidGroup {}
    public interface OpePersonIdValidGroup {}
    public interface LogOpeContentValidGroup {}
    public interface LogOpeDateValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            LogIdValidGroup.class
            , LogOpePersonIdValidGroup.class
            , OpePersonIdValidGroup.class
            , LogOpeContentValidGroup.class
            , LogOpeDateValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
