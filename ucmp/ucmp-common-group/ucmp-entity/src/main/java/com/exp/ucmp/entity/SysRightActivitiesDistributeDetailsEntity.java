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
import com.exp.ucmp.entity.PsiCustomerReservationTrackEntity.PsiCustomerReservationTrackEntityValidGroup;
import com.exp.ucmp.entity.PsiCustomerReservationTrackEntity.ReservationIdValidGroup;

@ApiModel(value = "SysRightActivitiesDistributeDetailsEntity", description = "权益活动发放明细表")
@GroupSequence({SysRightActivitiesDistributeDetailsEntity.class, SysRightActivitiesDistributeDetailsEntity.SysRightActivitiesDistributeDetailsEntityValidGroup.class,SysRightActivitiesDistributeDetailsEntity.DistributeDetailIdValidGroup.class,SysRightActivitiesDistributeDetailsEntity.RightPackIdValidGroup.class,SysRightActivitiesDistributeDetailsEntity.RightGrantIdValidGroup.class,SysRightActivitiesDistributeDetailsEntity.CustomerNameValidGroup.class,SysRightActivitiesDistributeDetailsEntity.CustomerIphoneValidGroup.class,SysRightActivitiesDistributeDetailsEntity.DistributeDateValidGroup.class,SysRightActivitiesDistributeDetailsEntity.CampaignNameValidGroup.class,SysRightActivitiesDistributeDetailsEntity.IsEnableValidGroup.class,SysRightActivitiesDistributeDetailsEntity.IsDeleteValidGroup.class,SysRightActivitiesDistributeDetailsEntity.CreatedByValidGroup.class,SysRightActivitiesDistributeDetailsEntity.CreatedDateValidGroup.class,SysRightActivitiesDistributeDetailsEntity.UpdatedByValidGroup.class,SysRightActivitiesDistributeDetailsEntity.UpdatedDateValidGroup.class}) 
public class SysRightActivitiesDistributeDetailsEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 发放明细主键ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "发放明细主键ID 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, DistributeDetailIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="发放明细主键ID 数字精度必须符合(19,0)", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, DistributeDetailIdValidGroup.class})
    @ApiModelProperty(value = "发放明细主键ID")
    private Long distributeDetailId;
    
    @Digits(integer=19, fraction=0, message="预约ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, ReservationIdValidGroup.class})
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    /**
     * 权益包编号
     */
    @NotNull(message = "权益包编号 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, RightPackIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="权益包编号 数字精度必须符合(19,0)", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, RightPackIdValidGroup.class})
    @ApiModelProperty(value = "权益包编号")
    private Long rightPackId;
    
    /**
     * 权益发放编号
     */
    @NotNull(message = "权益发放编号 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, RightGrantIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="权益发放编号 数字精度必须符合(19,0)", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, RightGrantIdValidGroup.class})
    @ApiModelProperty(value = "权益发放编号")
    private Long rightGrantId;
    
    /**
     * 客户姓名
     */
    @NotNull(message = "客户姓名 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, CustomerNameValidGroup.class})
    @Size(min=0, max=20, message="客户姓名 字符长度必须小于等于20", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, CustomerNameValidGroup.class})
    @ApiModelProperty(value = "客户姓名")
    private String customerName;
    
    /**
     * 客户手机号
     */
    @NotNull(message = "客户手机号 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, CustomerIphoneValidGroup.class})
    @Size(min=0, max=100, message="客户手机号 字符长度必须小于等于100", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, CustomerIphoneValidGroup.class})
    @ApiModelProperty(value = "客户手机号")
    private String customerIphone;
    
    /**
     * 发放时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "发放时间 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, DistributeDateValidGroup.class})
    @ApiModelProperty(value = "发放时间")
    private Date distributeDate;
    
    /**
     * 权益名称
     */
    @NotNull(message = "权益名称 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, CampaignNameValidGroup.class})
    @Size(min=0, max=50, message="权益名称 字符长度必须小于等于50", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, CampaignNameValidGroup.class})
    @ApiModelProperty(value = "权益名称")
    private String campaignName;
    
    /**
     * 是否可用：00、不可用，01、可用
     */
    @NotNull(message = "是否可用：00、不可用，01、可用 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, IsEnableValidGroup.class})
    @Size(min=0, max=2, message="是否可用：00、不可用，01、可用 字符长度必须小于等于2", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用：00、不可用，01、可用")
    private String isEnable;
    
    /**
     * 是否被删除：00、未删除，01、删除
     */
    @NotNull(message = "是否被删除：00、未删除，01、删除 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、未删除，01、删除 字符长度必须小于等于2", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、未删除，01、删除")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysRightActivitiesDistributeDetailsEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysRightActivitiesDistributeDetailsEntity() {
    }
    
    public SysRightActivitiesDistributeDetailsEntity(Long distributeDetailId) {
        this.distributeDetailId = distributeDetailId;
    }

    public void setDistributeDetailId(Long distributeDetailId) {
        this.distributeDetailId = distributeDetailId;
    }
    public Long getDistributeDetailId() {
        return this.distributeDetailId;
    }

    public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public void setRightPackId(Long rightPackId) {
        this.rightPackId = rightPackId;
    }
    public Long getRightPackId() {
        return this.rightPackId;
    }
    
    public void setRightGrantId(Long rightGrantId) {
        this.rightGrantId = rightGrantId;
    }
    public Long getRightGrantId() {
        return this.rightGrantId;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }
    public String getCustomerIphone() {
        return this.customerIphone;
    }
    
    public void setDistributeDate(Date distributeDate) {
        this.distributeDate = distributeDate;
    }
    public Date getDistributeDate() {
        return this.distributeDate;
    }
    
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
    public String getCampaignName() {
        return this.campaignName;
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
              (distributeDetailId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                distributeDetailId = RandomIDGennerator.get().generate();
    }

    public interface SysRightActivitiesDistributeDetailsEntityValidGroup {}
    public interface DistributeDetailIdValidGroup {}
    public interface RightPackIdValidGroup {}
    public interface RightGrantIdValidGroup {}
    public interface CustomerNameValidGroup {}
    public interface CustomerIphoneValidGroup {}
    public interface DistributeDateValidGroup {}
    public interface CampaignNameValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            DistributeDetailIdValidGroup.class
            , RightPackIdValidGroup.class
            , RightGrantIdValidGroup.class
            , CustomerNameValidGroup.class
            , CustomerIphoneValidGroup.class
            , DistributeDateValidGroup.class
            , CampaignNameValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
