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

@ApiModel(value = "PsiSalesMessageRecordEntity", description = "线索消息记录表")
@GroupSequence({PsiSalesMessageRecordEntity.class, PsiSalesMessageRecordEntity.PsiSalesMessageRecordEntityValidGroup.class,PsiSalesMessageRecordEntity.MessageRecordIdValidGroup.class,PsiSalesMessageRecordEntity.TemplateIdValidGroup.class,PsiSalesMessageRecordEntity.RelevanceTypeValidGroup.class,PsiSalesMessageRecordEntity.MessageTypeValidGroup.class,PsiSalesMessageRecordEntity.RelevanceIdValidGroup.class,PsiSalesMessageRecordEntity.RecipientValidGroup.class,PsiSalesMessageRecordEntity.ParamValidGroup.class,PsiSalesMessageRecordEntity.StatusValidGroup.class,PsiSalesMessageRecordEntity.ReceptionTimeValidGroup.class}) 
public class PsiSalesMessageRecordEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 消息标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "消息标识 不能是Null", groups = {PsiSalesMessageRecordEntityValidGroup.class, MessageRecordIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="消息标识 数字精度必须符合(19,0)", groups = {PsiSalesMessageRecordEntityValidGroup.class, MessageRecordIdValidGroup.class})
    @ApiModelProperty(value = "消息标识")
    private Long messageRecordId;
    
    
    /**
     * 模板ID
     */
    @NotNull(message = "模板ID 不能是Null", groups = {PsiSalesMessageRecordEntityValidGroup.class, TemplateIdValidGroup.class})
    @Size(min=0, max=50, message="模板ID 字符长度必须小于等于50", groups = {PsiSalesMessageRecordEntityValidGroup.class, TemplateIdValidGroup.class})
    @ApiModelProperty(value = "模板ID")
    private String templateId;
    
    /**
     * 数据类型:(线索:01,订单:02,定时任务:03)
     */
    @NotNull(message = "数据类型:(线索:01,订单:02,定时任务:03) 不能是Null", groups = {PsiSalesMessageRecordEntityValidGroup.class, RelevanceTypeValidGroup.class})
    @Size(min=0, max=4, message="数据类型:(线索:01,订单:02,定时任务:03) 字符长度必须小于等于4", groups = {PsiSalesMessageRecordEntityValidGroup.class, RelevanceTypeValidGroup.class})
    @ApiModelProperty(value = "数据类型:(线索:01,订单:02,定时任务:03)")
    private String relevanceType;
    
    /**
     * 消息类型:(消息:01,短信:02)
     */
    @NotNull(message = "消息类型:(消息:01,短信:02) 不能是Null", groups = {PsiSalesMessageRecordEntityValidGroup.class, MessageTypeValidGroup.class})
    @Size(min=0, max=4, message="消息类型:(消息:01,短信:02) 字符长度必须小于等于4", groups = {PsiSalesMessageRecordEntityValidGroup.class, MessageTypeValidGroup.class})
    @ApiModelProperty(value = "消息类型:(消息:01,短信:02)")
    private String messageType;
    
    /**
     * 关联ID
     */
    @Digits(integer=19, fraction=0, message="关联ID 数字精度必须符合(19,0)", groups = {PsiSalesMessageRecordEntityValidGroup.class, RelevanceIdValidGroup.class})
    @ApiModelProperty(value = "关联ID")
    private Long relevanceId;
    
    /**
     * 接收人
     */
    @NotNull(message = "接收人 不能是Null", groups = {PsiSalesMessageRecordEntityValidGroup.class, RecipientValidGroup.class})
    @Size(min=0, max=200, message="接收人 字符长度必须小于等于200", groups = {PsiSalesMessageRecordEntityValidGroup.class, RecipientValidGroup.class})
    @ApiModelProperty(value = "接收人")
    private String recipient;
    
    /**
     * 模板动态参数
     */
    @Size(min=0, max=255, message="模板动态参数 字符长度必须小于等于255", groups = {PsiSalesMessageRecordEntityValidGroup.class, ParamValidGroup.class})
    @ApiModelProperty(value = "模板动态参数")
    private String param;
    
    /**
     * 状态:(发送:01,未发送:02)
     */
    @NotNull(message = "状态:(发送:01,未发送:02) 不能是Null", groups = {PsiSalesMessageRecordEntityValidGroup.class, StatusValidGroup.class})
    @Size(min=0, max=2, message="状态:(发送:01,未发送:02) 字符长度必须小于等于2", groups = {PsiSalesMessageRecordEntityValidGroup.class, StatusValidGroup.class})
    @ApiModelProperty(value = "状态:(发送:01,未发送:02)")
    private String status;
    
    /**
     * 发送时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "发送时间 不能是Null", groups = {PsiSalesMessageRecordEntityValidGroup.class, ReceptionTimeValidGroup.class})
    @ApiModelProperty(value = "发送时间")
    private Date receptionTime;
    
    public PsiSalesMessageRecordEntity() {
    }
    
    public PsiSalesMessageRecordEntity(Long messageRecordId) {
        this.messageRecordId = messageRecordId;
    }

    public void setMessageRecordId(Long messageRecordId) {
        this.messageRecordId = messageRecordId;
    }
    public Long getMessageRecordId() {
        return this.messageRecordId;
    }
    

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
    public String getTemplateId() {
        return this.templateId;
    }
    
    public void setRelevanceType(String relevanceType) {
        this.relevanceType = relevanceType;
    }
    public String getRelevanceType() {
        return this.relevanceType;
    }
    
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    public String getMessageType() {
        return this.messageType;
    }
    
    public void setRelevanceId(Long relevanceId) {
        this.relevanceId = relevanceId;
    }
    public Long getRelevanceId() {
        return this.relevanceId;
    }
    
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public String getRecipient() {
        return this.recipient;
    }
    
    public void setParam(String param) {
        this.param = param;
    }
    public String getParam() {
        return this.param;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setReceptionTime(Date receptionTime) {
        this.receptionTime = receptionTime;
    }
    public Date getReceptionTime() {
        return this.receptionTime;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (messageRecordId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                messageRecordId = RandomIDGennerator.get().generate();
    }

    public interface PsiSalesMessageRecordEntityValidGroup {}
    public interface MessageRecordIdValidGroup {}
    public interface TemplateIdValidGroup {}
    public interface RelevanceTypeValidGroup {}
    public interface MessageTypeValidGroup {}
    public interface RelevanceIdValidGroup {}
    public interface RecipientValidGroup {}
    public interface ParamValidGroup {}
    public interface StatusValidGroup {}
    public interface ReceptionTimeValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            MessageRecordIdValidGroup.class
            , TemplateIdValidGroup.class
            , RelevanceTypeValidGroup.class
            , MessageTypeValidGroup.class
            , RelevanceIdValidGroup.class
            , RecipientValidGroup.class
            , ParamValidGroup.class
            , StatusValidGroup.class
            , ReceptionTimeValidGroup.class
        };
    }
}
