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

@ApiModel(value = "PsiMessageInfoEntity", description = "消息模板表")
@GroupSequence({PsiMessageInfoEntity.class, PsiMessageInfoEntity.PsiMessageInfoEntityValidGroup.class,PsiMessageInfoEntity.MessageIdValidGroup.class,PsiMessageInfoEntity.MessageTypeValidGroup.class,PsiMessageInfoEntity.TemplateIdValidGroup.class,PsiMessageInfoEntity.ReservationIdValidGroup.class,PsiMessageInfoEntity.RecipientValidGroup.class,PsiMessageInfoEntity.StatusValidGroup.class}) 
public class PsiMessageInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 消息标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "消息标识 不能是Null", groups = {PsiMessageInfoEntityValidGroup.class, MessageIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="消息标识 数字精度必须符合(19,0)", groups = {PsiMessageInfoEntityValidGroup.class, MessageIdValidGroup.class})
    @ApiModelProperty(value = "消息标识")
    private Long messageId;
    
    
    /**
     * 消息类型:(消息:01,短信:02)
     */
    @NotNull(message = "消息类型:(消息:01,短信:02) 不能是Null", groups = {PsiMessageInfoEntityValidGroup.class, MessageTypeValidGroup.class})
    @Size(min=0, max=4, message="消息类型:(消息:01,短信:02) 字符长度必须小于等于4", groups = {PsiMessageInfoEntityValidGroup.class, MessageTypeValidGroup.class})
    @ApiModelProperty(value = "消息类型:(消息:01,短信:02)")
    private String messageType;
    
    /**
     * 模板ID
     */
    @NotNull(message = "模板ID 不能是Null", groups = {PsiMessageInfoEntityValidGroup.class, TemplateIdValidGroup.class})
    @Size(min=0, max=50, message="模板ID 字符长度必须小于等于50", groups = {PsiMessageInfoEntityValidGroup.class, TemplateIdValidGroup.class})
    @ApiModelProperty(value = "模板ID")
    private String templateId;
    
    /**
     * 预约ID
     */
    @NotNull(message = "预约ID 不能是Null", groups = {PsiMessageInfoEntityValidGroup.class, ReservationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="预约ID 数字精度必须符合(19,0)", groups = {PsiMessageInfoEntityValidGroup.class, ReservationIdValidGroup.class})
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    /**
     * 接收人
     */
    @NotNull(message = "接收人 不能是Null", groups = {PsiMessageInfoEntityValidGroup.class, RecipientValidGroup.class})
    @Size(min=0, max=200, message="接收人 字符长度必须小于等于200", groups = {PsiMessageInfoEntityValidGroup.class, RecipientValidGroup.class})
    @ApiModelProperty(value = "接收人")
    private String recipient;
    
    /**
     * 状态:(发送:01,未发送:02)
     */
    @Size(min=0, max=2, message="状态:(发送:01,未发送:02) 字符长度必须小于等于2", groups = {PsiMessageInfoEntityValidGroup.class, StatusValidGroup.class})
    @ApiModelProperty(value = "状态:(发送:01,未发送:02)")
    private String status;
    
    /**
     * 发送时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "发送时间")
    private Date receptionTime;
    
    public PsiMessageInfoEntity() {
    }
    
    public PsiMessageInfoEntity(Long messageId) {
        this.messageId = messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
    public Long getMessageId() {
        return this.messageId;
    }
    




    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
    public String getMessageType() {
        return this.messageType;
    }
    
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }
    public String getTemplateId() {
        return this.templateId;
    }
    
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }
    
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public String getRecipient() {
        return this.recipient;
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
              (messageId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                messageId = RandomIDGennerator.get().generate();
    }

    public interface PsiMessageInfoEntityValidGroup {}
    public interface MessageIdValidGroup {}
    public interface MessageTypeValidGroup {}
    public interface TemplateIdValidGroup {}
    public interface ReservationIdValidGroup {}
    public interface RecipientValidGroup {}
    public interface StatusValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiMessageInfoEntity.MessageIdValidGroup.class
            , PsiMessageInfoEntity.MessageTypeValidGroup.class
            , PsiMessageInfoEntity.TemplateIdValidGroup.class
            , PsiMessageInfoEntity.ReservationIdValidGroup.class
            , PsiMessageInfoEntity.RecipientValidGroup.class
            , PsiMessageInfoEntity.StatusValidGroup.class
        };
    }
}
