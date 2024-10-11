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

@ApiModel(value = "PsiSalesPaymentRecordEntity", description = "二手车销售收款记录表")
@GroupSequence({PsiSalesPaymentRecordEntity.class, PsiSalesPaymentRecordEntity.PsiSalesPaymentRecordEntityValidGroup.class,PsiSalesPaymentRecordEntity.RecordIdValidGroup.class,PsiSalesPaymentRecordEntity.RecordCodeValidGroup.class,PsiSalesPaymentRecordEntity.OrderInfoIdValidGroup.class,PsiSalesPaymentRecordEntity.OrderNoValidGroup.class,PsiSalesPaymentRecordEntity.PaymentItemValidGroup.class,PsiSalesPaymentRecordEntity.PaymentAmountValidGroup.class,PsiSalesPaymentRecordEntity.SerialNumberValidGroup.class,PsiSalesPaymentRecordEntity.ProceedsByValidGroup.class,PsiSalesPaymentRecordEntity.PaymentMethodValidGroup.class,PsiSalesPaymentRecordEntity.PayStatusValidGroup.class,PsiSalesPaymentRecordEntity.PaymentAccountValidGroup.class,PsiSalesPaymentRecordEntity.AccountNameValidGroup.class,PsiSalesPaymentRecordEntity.CreateByValidGroup.class,PsiSalesPaymentRecordEntity.CreateDateValidGroup.class,PsiSalesPaymentRecordEntity.UpdateByValidGroup.class}) 
public class PsiSalesPaymentRecordEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 付款记录ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "付款记录ID 不能是Null", groups = {PsiSalesPaymentRecordEntityValidGroup.class, RecordIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="付款记录ID 数字精度必须符合(19,0)", groups = {PsiSalesPaymentRecordEntityValidGroup.class, RecordIdValidGroup.class})
    @ApiModelProperty(value = "付款记录ID")
    private Long recordId;
    
    
    /**
     * 付款记录code
     */
    @NotNull(message = "付款记录code 不能是Null", groups = {PsiSalesPaymentRecordEntityValidGroup.class, RecordCodeValidGroup.class})
    @Size(min=0, max=20, message="付款记录code 字符长度必须小于等于20", groups = {PsiSalesPaymentRecordEntityValidGroup.class, RecordCodeValidGroup.class})
    @ApiModelProperty(value = "付款记录code")
    private String recordCode;
    
    /**
     * 销售订单ID
     */
    @NotNull(message = "销售订单ID 不能是Null", groups = {PsiSalesPaymentRecordEntityValidGroup.class, OrderInfoIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="销售订单ID 数字精度必须符合(19,0)", groups = {PsiSalesPaymentRecordEntityValidGroup.class, OrderInfoIdValidGroup.class})
    @ApiModelProperty(value = "销售订单ID")
    private Long orderInfoId;
    
    /**
     * 订单号
     */
    @Size(min=0, max=50, message="订单号 字符长度必须小于等于50", groups = {PsiSalesPaymentRecordEntityValidGroup.class, OrderNoValidGroup.class})
    @ApiModelProperty(value = "订单号")
    private String orderNo;
    
    /**
     * 付款项目
     */
    @NotNull(message = "付款项目 不能是Null", groups = {PsiSalesPaymentRecordEntityValidGroup.class, PaymentItemValidGroup.class})
    @Size(min=0, max=20, message="付款项目 字符长度必须小于等于20", groups = {PsiSalesPaymentRecordEntityValidGroup.class, PaymentItemValidGroup.class})
    @ApiModelProperty(value = "付款项目")
    private String paymentItem;
    
    /**
     * 付款金额(元)
     */
    @NotNull(message = "付款金额(元) 不能是Null", groups = {PsiSalesPaymentRecordEntityValidGroup.class, PaymentAmountValidGroup.class})
    @Digits(integer=9, fraction=2, message="付款金额(元) 数字精度必须符合(9,2)", groups = {PsiSalesPaymentRecordEntityValidGroup.class, PaymentAmountValidGroup.class})
    @ApiModelProperty(value = "付款金额(元)")
    private BigDecimal paymentAmount;
    
    /**
     * 流水号
     */
    @Size(min=0, max=50, message="流水号 字符长度必须小于等于50", groups = {PsiSalesPaymentRecordEntityValidGroup.class, SerialNumberValidGroup.class})
    @ApiModelProperty(value = "流水号")
    private String serialNumber;
    
    /**
     * 收款人
     */
    @NotNull(message = "收款人 不能是Null", groups = {PsiSalesPaymentRecordEntityValidGroup.class, ProceedsByValidGroup.class})
    @Digits(integer=19, fraction=0, message="收款人 数字精度必须符合(19,0)", groups = {PsiSalesPaymentRecordEntityValidGroup.class, ProceedsByValidGroup.class})
    @ApiModelProperty(value = "收款人")
    private Long proceedsBy;
    
    /**
     * 收款方式  01:微信扫码支付,00:支付宝扫码支付,03:快捷,05:POS,06:线下
     */
    @NotNull(message = "收款方式  01:微信扫码支付,00:支付宝扫码支付,03:快捷,05:POS,06:线下 不能是Null", groups = {PsiSalesPaymentRecordEntityValidGroup.class, PaymentMethodValidGroup.class})
    @Size(min=0, max=20, message="收款方式  01:微信扫码支付,00:支付宝扫码支付,03:快捷,05:POS,06:线下 字符长度必须小于等于20", groups = {PsiSalesPaymentRecordEntityValidGroup.class, PaymentMethodValidGroup.class})
    @ApiModelProperty(value = "收款方式  01:微信扫码支付,00:支付宝扫码支付,03:快捷,05:POS,06:线下")
    private String paymentMethod;
    
    /**
     * 付款状态 00:未支付,01:付款成功,02:付款失败,03:退款申请中,04退款成功,05退款失败
     */
    @Size(min=0, max=2, message="付款状态 00:未支付,01:付款成功,02:付款失败,03:退款申请中,04退款成功,05退款失败 字符长度必须小于等于2", groups = {PsiSalesPaymentRecordEntityValidGroup.class, PayStatusValidGroup.class})
    @ApiModelProperty(value = "付款状态 00:未支付,01:付款成功,02:付款失败,03:退款申请中,04退款成功,05退款失败")
    private String payStatus;
    
    /**
     * 付款账户
     */
    @Size(min=0, max=100, message="付款账户 字符长度必须小于等于100", groups = {PsiSalesPaymentRecordEntityValidGroup.class, PaymentAccountValidGroup.class})
    @ApiModelProperty(value = "付款账户")
    private String paymentAccount;
    
    /**
     * 付款账户名称
     */
    @Size(min=0, max=100, message="付款账户名称 字符长度必须小于等于100", groups = {PsiSalesPaymentRecordEntityValidGroup.class, AccountNameValidGroup.class})
    @ApiModelProperty(value = "付款账户名称")
    private String accountName;
    
    /**
     * 创建人
     */
    @NotNull(message = "创建人 不能是Null", groups = {PsiSalesPaymentRecordEntityValidGroup.class, CreateByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人 数字精度必须符合(19,0)", groups = {PsiSalesPaymentRecordEntityValidGroup.class, CreateByValidGroup.class})
    @ApiModelProperty(value = "创建人")
    private Long createBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiSalesPaymentRecordEntityValidGroup.class, CreateDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createDate;
    
    /**
     * 更新人
     */
    @Digits(integer=19, fraction=0, message="更新人 数字精度必须符合(19,0)", groups = {PsiSalesPaymentRecordEntityValidGroup.class, UpdateByValidGroup.class})
    @ApiModelProperty(value = "更新人")
    private Long updateBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;
    
    public PsiSalesPaymentRecordEntity() {
    }
    
    public PsiSalesPaymentRecordEntity(Long recordId) {
        this.recordId = recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }
    public Long getRecordId() {
        return this.recordId;
    }
    

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }
    public String getRecordCode() {
        return this.recordCode;
    }
    
    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }
    public Long getOrderInfoId() {
        return this.orderInfoId;
    }
    
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getOrderNo() {
        return this.orderNo;
    }
    
    public void setPaymentItem(String paymentItem) {
        this.paymentItem = paymentItem;
    }
    public String getPaymentItem() {
        return this.paymentItem;
    }
    
    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    public BigDecimal getPaymentAmount() {
        return this.paymentAmount;
    }
    
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public String getSerialNumber() {
        return this.serialNumber;
    }
    
    public void setProceedsBy(Long proceedsBy) {
        this.proceedsBy = proceedsBy;
    }
    public Long getProceedsBy() {
        return this.proceedsBy;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public String getPaymentMethod() {
        return this.paymentMethod;
    }
    
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
    public String getPayStatus() {
        return this.payStatus;
    }
    
    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }
    public String getPaymentAccount() {
        return this.paymentAccount;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getAccountName() {
        return this.accountName;
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
    
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
    public Long getUpdateBy() {
        return this.updateBy;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (recordId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                recordId = RandomIDGennerator.get().generate();
    }

    public interface PsiSalesPaymentRecordEntityValidGroup {}
    public interface RecordIdValidGroup {}
    public interface RecordCodeValidGroup {}
    public interface OrderInfoIdValidGroup {}
    public interface OrderNoValidGroup {}
    public interface PaymentItemValidGroup {}
    public interface PaymentAmountValidGroup {}
    public interface SerialNumberValidGroup {}
    public interface ProceedsByValidGroup {}
    public interface PaymentMethodValidGroup {}
    public interface PayStatusValidGroup {}
    public interface PaymentAccountValidGroup {}
    public interface AccountNameValidGroup {}
    public interface CreateByValidGroup {}
    public interface CreateDateValidGroup {}
    public interface UpdateByValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiSalesPaymentRecordEntity.RecordIdValidGroup.class
            , PsiSalesPaymentRecordEntity.RecordCodeValidGroup.class
            , PsiSalesPaymentRecordEntity.OrderInfoIdValidGroup.class
            , PsiSalesPaymentRecordEntity.OrderNoValidGroup.class
            , PsiSalesPaymentRecordEntity.PaymentItemValidGroup.class
            , PsiSalesPaymentRecordEntity.PaymentAmountValidGroup.class
            , PsiSalesPaymentRecordEntity.SerialNumberValidGroup.class
            , PsiSalesPaymentRecordEntity.ProceedsByValidGroup.class
            , PsiSalesPaymentRecordEntity.PaymentMethodValidGroup.class
            , PsiSalesPaymentRecordEntity.PayStatusValidGroup.class
            , PsiSalesPaymentRecordEntity.PaymentAccountValidGroup.class
            , PsiSalesPaymentRecordEntity.AccountNameValidGroup.class
            , PsiSalesPaymentRecordEntity.CreateByValidGroup.class
            , PsiSalesPaymentRecordEntity.CreateDateValidGroup.class
            , PsiSalesPaymentRecordEntity.UpdateByValidGroup.class
        };
    }
}
