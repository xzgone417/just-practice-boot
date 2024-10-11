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

@ApiModel(value = "PsiAppraisalRecordEntity", description = "估价记录表")
@GroupSequence({PsiAppraisalRecordEntity.class, PsiAppraisalRecordEntity.PsiAppraisalRecordEntityValidGroup.class,PsiAppraisalRecordEntity.AppraisalIdValidGroup.class,PsiAppraisalRecordEntity.InquiryIdValidGroup.class,PsiAppraisalRecordEntity.AppraisalPriceValidGroup.class,PsiAppraisalRecordEntity.AppraisalStaffIdValidGroup.class,PsiAppraisalRecordEntity.AppraisalDateValidGroup.class}) 
public class PsiAppraisalRecordEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 估价ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "估价ID 不能是Null", groups = {PsiAppraisalRecordEntityValidGroup.class, AppraisalIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="估价ID 数字精度必须符合(19,0)", groups = {PsiAppraisalRecordEntityValidGroup.class, AppraisalIdValidGroup.class})
    @ApiModelProperty(value = "估价ID")
    private Long appraisalId;
    
    
    /**
     * 询价ID
     */
    @NotNull(message = "询价ID 不能是Null", groups = {PsiAppraisalRecordEntityValidGroup.class, InquiryIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="询价ID 数字精度必须符合(19,0)", groups = {PsiAppraisalRecordEntityValidGroup.class, InquiryIdValidGroup.class})
    @ApiModelProperty(value = "询价ID")
    private Long inquiryId;
    
    /**
     * 评估价格
     */
    @NotNull(message = "评估价格 不能是Null", groups = {PsiAppraisalRecordEntityValidGroup.class, AppraisalPriceValidGroup.class})
    @Digits(integer=9, fraction=0, message="评估价格 数字精度必须符合(9,0)", groups = {PsiAppraisalRecordEntityValidGroup.class, AppraisalPriceValidGroup.class})
    @ApiModelProperty(value = "评估价格")
    private Long appraisalPrice;
    
    /**
     * 估价人ID(某个车商人员id)
     */
    @Digits(integer=19, fraction=0, message="估价人ID(某个车商人员id) 数字精度必须符合(19,0)", groups = {PsiAppraisalRecordEntityValidGroup.class, AppraisalStaffIdValidGroup.class})
    @ApiModelProperty(value = "估价人ID(某个车商人员id)")
    private Long appraisalStaffId;
    
    /**
     * 估价时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "估价时间 不能是Null", groups = {PsiAppraisalRecordEntityValidGroup.class, AppraisalDateValidGroup.class})
    @ApiModelProperty(value = "估价时间")
    private Date appraisalDate;
    
    public PsiAppraisalRecordEntity() {
    }
    
    public PsiAppraisalRecordEntity(Long appraisalId) {
        this.appraisalId = appraisalId;
    }

    public void setAppraisalId(Long appraisalId) {
        this.appraisalId = appraisalId;
    }
    public Long getAppraisalId() {
        return this.appraisalId;
    }
    

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }
    public Long getInquiryId() {
        return this.inquiryId;
    }
    
    public void setAppraisalPrice(Long appraisalPrice) {
        this.appraisalPrice = appraisalPrice;
    }
    public Long getAppraisalPrice() {
        return this.appraisalPrice;
    }
    
    public void setAppraisalStaffId(Long appraisalStaffId) {
        this.appraisalStaffId = appraisalStaffId;
    }
    public Long getAppraisalStaffId() {
        return this.appraisalStaffId;
    }
    
    public void setAppraisalDate(Date appraisalDate) {
        this.appraisalDate = appraisalDate;
    }
    public Date getAppraisalDate() {
        return this.appraisalDate;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (appraisalId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                appraisalId = RandomIDGennerator.get().generate();
    }

    public interface PsiAppraisalRecordEntityValidGroup {}
    public interface AppraisalIdValidGroup {}
    public interface InquiryIdValidGroup {}
    public interface AppraisalPriceValidGroup {}
    public interface AppraisalStaffIdValidGroup {}
    public interface AppraisalDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            AppraisalIdValidGroup.class
            , InquiryIdValidGroup.class
            , AppraisalPriceValidGroup.class
            , AppraisalStaffIdValidGroup.class
            , AppraisalDateValidGroup.class
        };
    }
}
