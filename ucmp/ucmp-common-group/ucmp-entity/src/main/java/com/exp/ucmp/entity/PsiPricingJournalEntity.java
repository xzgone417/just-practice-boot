package com.exp.ucmp.entity;

import java.math.BigDecimal;
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

@ApiModel(value = "PsiPricingJournalEntity", description = "定价日志表(二期)")
@GroupSequence({PsiPricingJournalEntity.class, PsiPricingJournalEntity.PsiPricingJournalEntityValidGroup.class,PsiPricingJournalEntity.JournalIdValidGroup.class,PsiPricingJournalEntity.VhclIdValidGroup.class,PsiPricingJournalEntity.PricingAmountValidGroup.class,PsiPricingJournalEntity.CreateNameValidGroup.class,PsiPricingJournalEntity.CreateByValidGroup.class}) 
public class PsiPricingJournalEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 定价日志表id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "定价日志表id 不能是Null", groups = {PsiPricingJournalEntityValidGroup.class, JournalIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="定价日志表id 数字精度必须符合(19,0)", groups = {PsiPricingJournalEntityValidGroup.class, JournalIdValidGroup.class})
    @ApiModelProperty(value = "定价日志表id")
    private Long journalId;
    
    
    /**
     * 车辆id
     */
    @Digits(integer=19, fraction=0, message="车辆id 数字精度必须符合(19,0)", groups = {PsiPricingJournalEntityValidGroup.class, VhclIdValidGroup.class})
    @ApiModelProperty(value = "车辆id")
    private Long vhclId;
    
    /**
     * 定价金额
     */
    @Digits(integer=10, fraction=2, message="定价金额 数字精度必须符合(10,2)", groups = {PsiPricingJournalEntityValidGroup.class, PricingAmountValidGroup.class})
    @ApiModelProperty(value = "定价金额")
    private BigDecimal pricingAmount;
    
    /**
     * 操作人名称
     */
    @Size(min=0, max=100, message="操作人名称 字符长度必须小于等于100", groups = {PsiPricingJournalEntityValidGroup.class, CreateNameValidGroup.class})
    @ApiModelProperty(value = "操作人名称")
    private String createName;
    
    /**
     * 创建人
     */
    @Digits(integer=19, fraction=0, message="创建人 数字精度必须符合(19,0)", groups = {PsiPricingJournalEntityValidGroup.class, CreateByValidGroup.class})
    @ApiModelProperty(value = "创建人")
    private Long createBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    
    public PsiPricingJournalEntity() {
    }
    
    public PsiPricingJournalEntity(Long journalId) {
        this.journalId = journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }
    public Long getJournalId() {
        return this.journalId;
    }
    

    public void setVhclId(Long vhclId) {
        this.vhclId = vhclId;
    }
    public Long getVhclId() {
        return this.vhclId;
    }
    
    public void setPricingAmount(BigDecimal pricingAmount) {
        this.pricingAmount = pricingAmount;
    }
    public BigDecimal getPricingAmount() {
        return this.pricingAmount;
    }
    
    public void setCreateName(String createName) {
        this.createName = createName;
    }
    public String getCreateName() {
        return this.createName;
    }
    
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
    public Long getCreateBy() {
        return this.createBy;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getCreateDate() {
        return this.createDate;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (journalId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                journalId = RandomIDGennerator.get().generate();
    }

    public interface PsiPricingJournalEntityValidGroup {}
    public interface JournalIdValidGroup {}
    public interface VhclIdValidGroup {}
    public interface PricingAmountValidGroup {}
    public interface CreateNameValidGroup {}
    public interface CreateByValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            JournalIdValidGroup.class
            , VhclIdValidGroup.class
            , PricingAmountValidGroup.class
            , CreateNameValidGroup.class
            , CreateByValidGroup.class
        };
    }
}
