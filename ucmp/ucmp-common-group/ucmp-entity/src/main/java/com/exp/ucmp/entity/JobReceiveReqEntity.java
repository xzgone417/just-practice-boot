package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "JobReceiveReqEntity", description = "接收数据时发出的请求信息")
@GroupSequence({JobReceiveReqEntity.class, JobReceiveReqEntity.JobReceiveReqEntityValidGroup.class,JobReceiveReqEntity.ReceiveIdValidGroup.class,JobReceiveReqEntity.CreatedByValidGroup.class,JobReceiveReqEntity.CreatedDateValidGroup.class,JobReceiveReqEntity.UpdatedByValidGroup.class,JobReceiveReqEntity.UpdatedDateValidGroup.class,JobReceiveReqEntity.ReceiveReqDataValidGroup.class}) 
public class JobReceiveReqEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键 不能是Null", groups = {JobReceiveReqEntityValidGroup.class, ReceiveIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键 数字精度必须符合(19,0)", groups = {JobReceiveReqEntityValidGroup.class, ReceiveIdValidGroup.class})
    @ApiModelProperty(value = "主键")
    private Long receiveId;
    
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {JobReceiveReqEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {JobReceiveReqEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {JobReceiveReqEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {JobReceiveReqEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {JobReceiveReqEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {JobReceiveReqEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 请求数据(主要用于HTTP方式)
     */
    @NotNull(message = "请求数据(主要用于HTTP方式) 不能是Null", groups = {JobReceiveReqEntityValidGroup.class, ReceiveReqDataValidGroup.class})
    @ApiModelProperty(value = "请求数据(主要用于HTTP方式)")
    private String receiveReqData;
    
    public JobReceiveReqEntity() {
    }
    
    public JobReceiveReqEntity(Long receiveId) {
        this.receiveId = receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }
    public Long getReceiveId() {
        return this.receiveId;
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
    
    public void setReceiveReqData(String receiveReqData) {
        this.receiveReqData = receiveReqData;
    }
    public String getReceiveReqData() {
        return this.receiveReqData;
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

    public interface JobReceiveReqEntityValidGroup {}
    public interface ReceiveIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface ReceiveReqDataValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            JobReceiveReqEntity.ReceiveIdValidGroup.class
            , JobReceiveReqEntity.CreatedByValidGroup.class
            , JobReceiveReqEntity.CreatedDateValidGroup.class
            , JobReceiveReqEntity.UpdatedByValidGroup.class
            , JobReceiveReqEntity.UpdatedDateValidGroup.class
            , JobReceiveReqEntity.ReceiveReqDataValidGroup.class
        };
    }
}
