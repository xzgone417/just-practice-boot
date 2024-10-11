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

@ApiModel(value = "PsiOrderFollowRecordEntity", description = "订单状态变更记录表(v2)")
@GroupSequence({PsiOrderFollowRecordEntity.class, PsiOrderFollowRecordEntity.PsiOrderFollowRecordEntityValidGroup.class,PsiOrderFollowRecordEntity.OrderFollowIdValidGroup.class,PsiOrderFollowRecordEntity.OrderInfoIdValidGroup.class,PsiOrderFollowRecordEntity.FollowStatusValidGroup.class,PsiOrderFollowRecordEntity.CreatedByValidGroup.class,PsiOrderFollowRecordEntity.CreatedDateValidGroup.class,PsiOrderFollowRecordEntity.IsEnableValidGroup.class,PsiOrderFollowRecordEntity.IsDeleteValidGroup.class}) 
public class PsiOrderFollowRecordEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 订单状态变更记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "订单状态变更记录id 不能是Null", groups = {PsiOrderFollowRecordEntityValidGroup.class, OrderFollowIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="订单状态变更记录id 数字精度必须符合(19,0)", groups = {PsiOrderFollowRecordEntityValidGroup.class, OrderFollowIdValidGroup.class})
    @ApiModelProperty(value = "订单状态变更记录id")
    private Long orderFollowId;
    
    
    /**
     * 订单信息id
     */
    @NotNull(message = "订单信息id 不能是Null", groups = {PsiOrderFollowRecordEntityValidGroup.class, OrderInfoIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="订单信息id 数字精度必须符合(19,0)", groups = {PsiOrderFollowRecordEntityValidGroup.class, OrderInfoIdValidGroup.class})
    @ApiModelProperty(value = "订单信息id")
    private Long orderInfoId;
    
    /**
     * 订单状态
     */
    @NotNull(message = "订单状态 不能是Null", groups = {PsiOrderFollowRecordEntityValidGroup.class, FollowStatusValidGroup.class})
    @Size(min=0, max=4, message="订单状态 字符长度必须小于等于4", groups = {PsiOrderFollowRecordEntityValidGroup.class, FollowStatusValidGroup.class})
    @ApiModelProperty(value = "订单状态")
    private String followStatus;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiOrderFollowRecordEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiOrderFollowRecordEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiOrderFollowRecordEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiOrderFollowRecordEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiOrderFollowRecordEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiOrderFollowRecordEntity() {
    }
    
    public PsiOrderFollowRecordEntity(Long orderFollowId) {
        this.orderFollowId = orderFollowId;
    }

    public void setOrderFollowId(Long orderFollowId) {
        this.orderFollowId = orderFollowId;
    }
    public Long getOrderFollowId() {
        return this.orderFollowId;
    }
    

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }
    public Long getOrderInfoId() {
        return this.orderInfoId;
    }
    
    public void setFollowStatus(String followStatus) {
        this.followStatus = followStatus;
    }
    public String getFollowStatus() {
        return this.followStatus;
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
    
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public String getIsEnable() {
        return this.isEnable;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (orderFollowId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                orderFollowId = RandomIDGennerator.get().generate();
    }

    public interface PsiOrderFollowRecordEntityValidGroup {}
    public interface OrderFollowIdValidGroup {}
    public interface OrderInfoIdValidGroup {}
    public interface FollowStatusValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            OrderFollowIdValidGroup.class
            , OrderInfoIdValidGroup.class
            , FollowStatusValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
