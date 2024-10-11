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

@ApiModel(value = "JobReceiveInfoEntity", description = "信息接收")
@GroupSequence({JobReceiveInfoEntity.class, JobReceiveInfoEntity.JobReceiveInfoEntityValidGroup.class,JobReceiveInfoEntity.ReceiveIdValidGroup.class,JobReceiveInfoEntity.ReceiveTypeValidGroup.class,JobReceiveInfoEntity.JobTypeValidGroup.class,JobReceiveInfoEntity.ReceiveTaskTypeValidGroup.class,JobReceiveInfoEntity.ReceiveCountValidGroup.class,JobReceiveInfoEntity.ReceiveTimestampValidGroup.class,JobReceiveInfoEntity.MessageNoValidGroup.class,JobReceiveInfoEntity.ReceiveResultValidGroup.class,JobReceiveInfoEntity.ProcessingStatusValidGroup.class,JobReceiveInfoEntity.CreatedByValidGroup.class,JobReceiveInfoEntity.CreatedDateValidGroup.class,JobReceiveInfoEntity.UpdatedByValidGroup.class,JobReceiveInfoEntity.UpdatedDateValidGroup.class}) 
public class JobReceiveInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键 不能是Null", groups = {JobReceiveInfoEntityValidGroup.class, ReceiveIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键 数字精度必须符合(19,0)", groups = {JobReceiveInfoEntityValidGroup.class, ReceiveIdValidGroup.class})
    @ApiModelProperty(value = "主键")
    private Long receiveId;
    
    
    /**
     * 接收类型：MQ、HTTP
     */
    @NotNull(message = "接收类型：MQ、HTTP 不能是Null", groups = {JobReceiveInfoEntityValidGroup.class, ReceiveTypeValidGroup.class})
    @Size(min=0, max=10, message="接收类型：MQ、HTTP 字符长度必须小于等于10", groups = {JobReceiveInfoEntityValidGroup.class, ReceiveTypeValidGroup.class})
    @ApiModelProperty(value = "接收类型：MQ、HTTP")
    private String receiveType;
    
    /**
     * 任务类型
     */
    @NotNull(message = "任务类型 不能是Null", groups = {JobReceiveInfoEntityValidGroup.class, JobTypeValidGroup.class})
    @Size(min=0, max=50, message="任务类型 字符长度必须小于等于50", groups = {JobReceiveInfoEntityValidGroup.class, JobTypeValidGroup.class})
    @ApiModelProperty(value = "任务类型")
    private String jobType;
    
    /**
     * 接收任务类型，MQ是绑定类型，HTTP可能是定时任务名称
     */
    @Size(min=0, max=50, message="接收任务类型，MQ是绑定类型，HTTP可能是定时任务名称 字符长度必须小于等于50", groups = {JobReceiveInfoEntityValidGroup.class, ReceiveTaskTypeValidGroup.class})
    @ApiModelProperty(value = "接收任务类型，MQ是绑定类型，HTTP可能是定时任务名称")
    private String receiveTaskType;
    
    /**
     * 响应数据的记录数
     */
    @Digits(integer=10, fraction=0, message="响应数据的记录数 数字精度必须符合(10,0)", groups = {JobReceiveInfoEntityValidGroup.class, ReceiveCountValidGroup.class})
    @ApiModelProperty(value = "响应数据的记录数")
    private Integer receiveCount;
    
    /**
     * 接收时间戳
     */
    @Digits(integer=19, fraction=0, message="接收时间戳 数字精度必须符合(19,0)", groups = {JobReceiveInfoEntityValidGroup.class, ReceiveTimestampValidGroup.class})
    @ApiModelProperty(value = "接收时间戳")
    private Long receiveTimestamp;
    
    /**
     * 消息号，用于MQ
     */
    @Size(min=0, max=50, message="消息号，用于MQ 字符长度必须小于等于50", groups = {JobReceiveInfoEntityValidGroup.class, MessageNoValidGroup.class})
    @ApiModelProperty(value = "消息号，用于MQ")
    private String messageNo;
    
    /**
     * 接收结果：00、失败；01、成功
     */
    @Size(min=0, max=2, message="接收结果：00、失败；01、成功 字符长度必须小于等于2", groups = {JobReceiveInfoEntityValidGroup.class, ReceiveResultValidGroup.class})
    @ApiModelProperty(value = "接收结果：00、失败；01、成功")
    private String receiveResult;
    
    /**
     * 处理状态：01、待处理，02、处理成功，09、处理失败
     */
    @Size(min=0, max=2, message="处理状态：01、待处理，02、处理成功，09、处理失败 字符长度必须小于等于2", groups = {JobReceiveInfoEntityValidGroup.class, ProcessingStatusValidGroup.class})
    @ApiModelProperty(value = "处理状态：01、待处理，02、处理成功，09、处理失败")
    private String processingStatus;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {JobReceiveInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {JobReceiveInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {JobReceiveInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {JobReceiveInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {JobReceiveInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {JobReceiveInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public JobReceiveInfoEntity() {
    }
    
    public JobReceiveInfoEntity(Long receiveId) {
        this.receiveId = receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }
    public Long getReceiveId() {
        return this.receiveId;
    }
    

    public void setReceiveType(String receiveType) {
        this.receiveType = receiveType;
    }
    public String getReceiveType() {
        return this.receiveType;
    }
    
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
    public String getJobType() {
        return this.jobType;
    }
    
    public void setReceiveTaskType(String receiveTaskType) {
        this.receiveTaskType = receiveTaskType;
    }
    public String getReceiveTaskType() {
        return this.receiveTaskType;
    }
    
    public void setReceiveCount(Integer receiveCount) {
        this.receiveCount = receiveCount;
    }
    public Integer getReceiveCount() {
        return this.receiveCount;
    }
    
    public void setReceiveTimestamp(Long receiveTimestamp) {
        this.receiveTimestamp = receiveTimestamp;
    }
    public Long getReceiveTimestamp() {
        return this.receiveTimestamp;
    }
    
    public void setMessageNo(String messageNo) {
        this.messageNo = messageNo;
    }
    public String getMessageNo() {
        return this.messageNo;
    }
    
    public void setReceiveResult(String receiveResult) {
        this.receiveResult = receiveResult;
    }
    public String getReceiveResult() {
        return this.receiveResult;
    }
    
    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }
    public String getProcessingStatus() {
        return this.processingStatus;
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
              (receiveId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                receiveId = RandomIDGennerator.get().generate();
    }

    public interface JobReceiveInfoEntityValidGroup {}
    public interface ReceiveIdValidGroup {}
    public interface ReceiveTypeValidGroup {}
    public interface JobTypeValidGroup {}
    public interface ReceiveTaskTypeValidGroup {}
    public interface ReceiveCountValidGroup {}
    public interface ReceiveTimestampValidGroup {}
    public interface MessageNoValidGroup {}
    public interface ReceiveResultValidGroup {}
    public interface ProcessingStatusValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            JobReceiveInfoEntity.ReceiveIdValidGroup.class
            , JobReceiveInfoEntity.ReceiveTypeValidGroup.class
            , JobReceiveInfoEntity.JobTypeValidGroup.class
            , JobReceiveInfoEntity.ReceiveTaskTypeValidGroup.class
            , JobReceiveInfoEntity.ReceiveCountValidGroup.class
            , JobReceiveInfoEntity.ReceiveTimestampValidGroup.class
            , JobReceiveInfoEntity.MessageNoValidGroup.class
            , JobReceiveInfoEntity.ReceiveResultValidGroup.class
            , JobReceiveInfoEntity.ProcessingStatusValidGroup.class
            , JobReceiveInfoEntity.CreatedByValidGroup.class
            , JobReceiveInfoEntity.CreatedDateValidGroup.class
            , JobReceiveInfoEntity.UpdatedByValidGroup.class
            , JobReceiveInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
