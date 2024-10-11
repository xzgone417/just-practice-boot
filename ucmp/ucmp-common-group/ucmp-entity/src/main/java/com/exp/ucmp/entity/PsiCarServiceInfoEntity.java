package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

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

@ApiModel(value = "PsiCarServiceInfoEntity", description = "车辆整备信息表(二期)")
@GroupSequence({PsiCarServiceInfoEntity.class, PsiCarServiceInfoEntity.PsiCarServiceInfoEntityValidGroup.class,PsiCarServiceInfoEntity.ServiceIdValidGroup.class,PsiCarServiceInfoEntity.StockIdValidGroup.class,PsiCarServiceInfoEntity.ServicePlaceValidGroup.class,PsiCarServiceInfoEntity.ServicePlaceCodeValidGroup.class,PsiCarServiceInfoEntity.PlaceTypeValidGroup.class,PsiCarServiceInfoEntity.PlaceTypeCodeValidGroup.class,PsiCarServiceInfoEntity.ServiceNumberValidGroup.class,PsiCarServiceInfoEntity.StartPeopleIdValidGroup.class,PsiCarServiceInfoEntity.StartPeopleValidGroup.class,PsiCarServiceInfoEntity.ServiceStateValidGroup.class,PsiCarServiceInfoEntity.TotalPriceValidGroup.class,PsiCarServiceInfoEntity.WarehousPeopleIdValidGroup.class,PsiCarServiceInfoEntity.ApprovalResultValidGroup.class,PsiCarServiceInfoEntity.CreatedByValidGroup.class,PsiCarServiceInfoEntity.CreatedDateValidGroup.class,PsiCarServiceInfoEntity.UpdatedByValidGroup.class,PsiCarServiceInfoEntity.UpdatedDateValidGroup.class,PsiCarServiceInfoEntity.IsEnableValidGroup.class,PsiCarServiceInfoEntity.IsDeleteValidGroup.class}) 
public class PsiCarServiceInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 整备信息id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "整备信息id 不能是Null", groups = {PsiCarServiceInfoEntityValidGroup.class, ServiceIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="整备信息id 数字精度必须符合(19,0)", groups = {PsiCarServiceInfoEntityValidGroup.class, ServiceIdValidGroup.class})
    @ApiModelProperty(value = "整备信息id")
    private Long serviceId;
    
    
    /**
     * 库存id
     */
    @NotNull(message = "库存id 不能是Null", groups = {PsiCarServiceInfoEntityValidGroup.class, StockIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="库存id 数字精度必须符合(19,0)", groups = {PsiCarServiceInfoEntityValidGroup.class, StockIdValidGroup.class})
    @ApiModelProperty(value = "库存id")
    private Long stockId;
    
    /**
     * 服务点
     */
    @NotNull(message = "服务点 不能是Null", groups = {PsiCarServiceInfoEntityValidGroup.class, ServicePlaceValidGroup.class})
    @Size(min=0, max=100, message="服务点 字符长度必须小于等于100", groups = {PsiCarServiceInfoEntityValidGroup.class, ServicePlaceValidGroup.class})
    @ApiModelProperty(value = "服务点")
    private String servicePlace;
    
    /**
     * 服务点编码
     */
    @Size(min=0, max=20, message="服务点编码 字符长度必须小于等于20", groups = {PsiCarServiceInfoEntityValidGroup.class, ServicePlaceCodeValidGroup.class})
    @ApiModelProperty(value = "服务点编码")
    private String servicePlaceCode;
    
    /**
     * 服务点类型
     */
    @Size(min=0, max=50, message="服务点类型 字符长度必须小于等于50", groups = {PsiCarServiceInfoEntityValidGroup.class, PlaceTypeValidGroup.class})
    @ApiModelProperty(value = "服务点类型")
    private String placeType;
    
    /**
     * 服务点类型编码
     */
    @Size(min=0, max=20, message="服务点类型编码 字符长度必须小于等于20", groups = {PsiCarServiceInfoEntityValidGroup.class, PlaceTypeCodeValidGroup.class})
    @ApiModelProperty(value = "服务点类型编码")
    private String placeTypeCode;
    
    /**
     * 计划服务时间-开始
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "计划服务时间-开始")
    private Date planStartDate;
    
    /**
     * 计划服务时间-截止
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "计划服务时间-截止")
    private Date planEndDate;
    
    /**
     * 预估交车时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预估交车时间")
    private Date estimatedDeliveryTime;
    
    /**
     * 整备单号
     */
    @Size(min=0, max=30, message="整备单号 字符长度必须小于等于30", groups = {PsiCarServiceInfoEntityValidGroup.class, ServiceNumberValidGroup.class})
    @ApiModelProperty(value = "整备单号")
    private String serviceNumber;
    
    /**
     * 整备发起时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "整备发起时间")
    private Date startDate;
    
    /**
     * 期望整备结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "期望整备结束时间")
    private Date expectEndTime;
    
    /**
     * 整备发起人id
     */
    @NotNull(message = "整备发起人id 不能是Null", groups = {PsiCarServiceInfoEntityValidGroup.class, StartPeopleIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="整备发起人id 数字精度必须符合(19,0)", groups = {PsiCarServiceInfoEntityValidGroup.class, StartPeopleIdValidGroup.class})
    @ApiModelProperty(value = "整备发起人id")
    private Long startPeopleId;
    
    /**
     * 整备发起人
     */
    @Size(min=0, max=20, message="整备发起人 字符长度必须小于等于20", groups = {PsiCarServiceInfoEntityValidGroup.class, StartPeopleValidGroup.class})
    @ApiModelProperty(value = "整备发起人")
    private String startPeople;
    
    /**
     * 维修项目反馈时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "维修项目反馈时间")
    private Date feedbackDate;
    
    /**
     * 反馈预估维修时间-开始
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "反馈预估维修时间-开始")
    private Date planRepairStartDate;
    
    /**
     * 反馈预估维修时间-截止
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "反馈预估维修时间-截止")
    private Date planRepairEndDate;
    
    /**
     * 整备单状态(5301:待反馈 5302:已反馈待审批 5303:已通过-待生成工单 5304:已生成工单-待审批 5305:实施完成 5306:已验收入库 5307:审批驳回 5308:放弃整备-转批售 5309:取消整备 5310:审批通过 5311:已生成工单)
     */
    @NotNull(message = "整备单状态(5301:待反馈 5302:已反馈待审批 5303:已通过-待生成工单 5304:已生成工单-待审批 5305:实施完成 5306:已验收入库 5307:审批驳回 5308:放弃整备-转批售 5309:取消整备 5310:审批通过 5311:已生成工单) 不能是Null", groups = {PsiCarServiceInfoEntityValidGroup.class, ServiceStateValidGroup.class})
    @Size(min=0, max=4, message="整备单状态(5301:待反馈 5302:已反馈待审批 5303:已通过-待生成工单 5304:已生成工单-待审批 5305:实施完成 5306:已验收入库 5307:审批驳回 5308:放弃整备-转批售 5309:取消整备 5310:审批通过 5311:已生成工单) 字符长度必须小于等于4", groups = {PsiCarServiceInfoEntityValidGroup.class, ServiceStateValidGroup.class})
    @ApiModelProperty(value = "整备单状态(5301:待反馈 5302:已反馈待审批 5303:已通过-待生成工单 5304:已生成工单-待审批 5305:实施完成 5306:已验收入库 5307:审批驳回 5308:放弃整备-转批售 5309:取消整备 5310:审批通过 5311:已生成工单)")
    private String serviceState;
    
    /**
     * 整备总价
     */
    @Digits(integer=9, fraction=2, message="整备总价 数字精度必须符合(9,2)", groups = {PsiCarServiceInfoEntityValidGroup.class, TotalPriceValidGroup.class})
    @ApiModelProperty(value = "整备总价")
    private BigDecimal totalPrice;
    
    /**
     * 工单号
     */
    @Size(min=0, max=50, message="工单号 字符长度必须小于等于20")
    @ApiModelProperty(value = "ISP的报价单号")
    private String quoteOrderNo;
    
    /**
     * 预计完工时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预计完工时间")
    private Date planCompleteDate;
    
    /**
     * 实际完工时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际完工时间")
    private Date completeDate;
    
    /**
     * 整备入库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "整备入库时间")
    private Date warehousDate;
    
    /**
     * 入库人id
     */
    @Digits(integer=19, fraction=0, message="入库人id 数字精度必须符合(19,0)", groups = {PsiCarServiceInfoEntityValidGroup.class, WarehousPeopleIdValidGroup.class})
    @ApiModelProperty(value = "入库人id")
    private Long warehousPeopleId;
    
    /**
     * 整备材料审批结果
     */
    @ApiModelProperty(value = "整备材料审批结果")
    private int approvalResult;
    
    /**
     * 整备材料审批时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "整备材料审批时间")
    private Date approvalDate;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarServiceInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarServiceInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarServiceInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarServiceInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiCarServiceInfoEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {PsiCarServiceInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiCarServiceInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiCarServiceInfoEntity() {
    }
    
    public PsiCarServiceInfoEntity(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    public Long getServiceId() {
        return this.serviceId;
    }
    

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    public Long getStockId() {
        return this.stockId;
    }
    
    public void setServicePlace(String servicePlace) {
        this.servicePlace = servicePlace;
    }
    public String getServicePlace() {
        return this.servicePlace;
    }
    
    public void setServicePlaceCode(String servicePlaceCode) {
        this.servicePlaceCode = servicePlaceCode;
    }
    public String getServicePlaceCode() {
        return this.servicePlaceCode;
    }
    
    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }
    public String getPlaceType() {
        return this.placeType;
    }
    
    public void setPlaceTypeCode(String placeTypeCode) {
        this.placeTypeCode = placeTypeCode;
    }
    public String getPlaceTypeCode() {
        return this.placeTypeCode;
    }
    
    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }
    public Date getPlanStartDate() {
        return this.planStartDate;
    }
    
    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }
    public Date getPlanEndDate() {
        return this.planEndDate;
    }
    
    public void setEstimatedDeliveryTime(Date estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
    public Date getEstimatedDeliveryTime() {
        return this.estimatedDeliveryTime;
    }
    
    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }
    public String getServiceNumber() {
        return this.serviceNumber;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setExpectEndTime(Date expectEndTime) {
        this.expectEndTime = expectEndTime;
    }
    public Date getExpectEndTime() {
        return this.expectEndTime;
    }
    
    public void setStartPeopleId(Long startPeopleId) {
        this.startPeopleId = startPeopleId;
    }
    public Long getStartPeopleId() {
        return this.startPeopleId;
    }
    
    public void setStartPeople(String startPeople) {
        this.startPeople = startPeople;
    }
    public String getStartPeople() {
        return this.startPeople;
    }
    
    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }
    public Date getFeedbackDate() {
        return this.feedbackDate;
    }
    
    public void setPlanRepairStartDate(Date planRepairStartDate) {
        this.planRepairStartDate = planRepairStartDate;
    }
    public Date getPlanRepairStartDate() {
        return this.planRepairStartDate;
    }
    
    public void setPlanRepairEndDate(Date planRepairEndDate) {
        this.planRepairEndDate = planRepairEndDate;
    }
    public Date getPlanRepairEndDate() {
        return this.planRepairEndDate;
    }
    
    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }
    public String getServiceState() {
        return this.serviceState;
    }
    
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }
    
    public String getQuoteOrderNo() {
		return quoteOrderNo;
	}

	public void setQuoteOrderNo(String quoteOrderNo) {
		this.quoteOrderNo = quoteOrderNo;
	}

    public void setPlanCompleteDate(Date planCompleteDate) {
        this.planCompleteDate = planCompleteDate;
    }
    public Date getPlanCompleteDate() {
        return this.planCompleteDate;
    }
    
    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }
    public Date getCompleteDate() {
        return this.completeDate;
    }
    
    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }
    public Date getWarehousDate() {
        return this.warehousDate;
    }
    
    public void setWarehousPeopleId(Long warehousPeopleId) {
        this.warehousPeopleId = warehousPeopleId;
    }
    public Long getWarehousPeopleId() {
        return this.warehousPeopleId;
    }
    
    public void setApprovalResult(int approvalResult) {
        this.approvalResult = approvalResult;
    }
    public int getApprovalResult() {
        return this.approvalResult;
    }
    
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
    public Date getApprovalDate() {
        return this.approvalDate;
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
              (serviceId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                serviceId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarServiceInfoEntityValidGroup {}
    public interface ServiceIdValidGroup {}
    public interface StockIdValidGroup {}
    public interface ServicePlaceValidGroup {}
    public interface ServicePlaceCodeValidGroup {}
    public interface PlaceTypeValidGroup {}
    public interface PlaceTypeCodeValidGroup {}
    public interface ServiceNumberValidGroup {}
    public interface StartPeopleIdValidGroup {}
    public interface StartPeopleValidGroup {}
    public interface ServiceStateValidGroup {}
    public interface TotalPriceValidGroup {}
    public interface WarehousPeopleIdValidGroup {}
    public interface ApprovalResultValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            ServiceIdValidGroup.class
            , StockIdValidGroup.class
            , ServicePlaceValidGroup.class
            , ServicePlaceCodeValidGroup.class
            , PlaceTypeValidGroup.class
            , PlaceTypeCodeValidGroup.class
            , ServiceNumberValidGroup.class
            , StartPeopleIdValidGroup.class
            , StartPeopleValidGroup.class
            , ServiceStateValidGroup.class
            , TotalPriceValidGroup.class
            , WarehousPeopleIdValidGroup.class
            , ApprovalResultValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
