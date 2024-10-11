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

@ApiModel(value = "PsiTransferRouteInfoEntity", description = "车辆调拨途径点位信息表(v2)")
@GroupSequence({PsiTransferRouteInfoEntity.class, PsiTransferRouteInfoEntity.PsiTransferRouteInfoEntityValidGroup.class,PsiTransferRouteInfoEntity.RouteIdValidGroup.class,PsiTransferRouteInfoEntity.DispatchInfoIdValidGroup.class,PsiTransferRouteInfoEntity.CurrentAddressValidGroup.class,PsiTransferRouteInfoEntity.RecordTimeValidGroup.class,PsiTransferRouteInfoEntity.CreatedByValidGroup.class,PsiTransferRouteInfoEntity.CreatedDateValidGroup.class,PsiTransferRouteInfoEntity.UpdatedByValidGroup.class,PsiTransferRouteInfoEntity.UpdatedDateValidGroup.class,PsiTransferRouteInfoEntity.IsEnableValidGroup.class,PsiTransferRouteInfoEntity.IsDeleteValidGroup.class}) 
public class PsiTransferRouteInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 途径点位id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "途径点位id 不能是Null", groups = {PsiTransferRouteInfoEntityValidGroup.class, RouteIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="途径点位id 数字精度必须符合(19,0)", groups = {PsiTransferRouteInfoEntityValidGroup.class, RouteIdValidGroup.class})
    @ApiModelProperty(value = "途径点位id")
    private Long routeId;
    
    
    /**
     * 调度信息id
     */
    @NotNull(message = "调度信息id 不能是Null", groups = {PsiTransferRouteInfoEntityValidGroup.class, DispatchInfoIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="调度信息id 数字精度必须符合(19,0)", groups = {PsiTransferRouteInfoEntityValidGroup.class, DispatchInfoIdValidGroup.class})
    @ApiModelProperty(value = "调度信息id")
    private Long dispatchInfoId;
    
    /**
     * 当前地址
     */
    @NotNull(message = "当前地址 不能是Null", groups = {PsiTransferRouteInfoEntityValidGroup.class, CurrentAddressValidGroup.class})
    @Size(min=0, max=4, message="当前地址 字符长度必须小于等于4", groups = {PsiTransferRouteInfoEntityValidGroup.class, CurrentAddressValidGroup.class})
    @ApiModelProperty(value = "当前地址")
    private String currentAddress;
    
    /**
     * 过点时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "过点时间 不能是Null", groups = {PsiTransferRouteInfoEntityValidGroup.class, RecordTimeValidGroup.class})
    @ApiModelProperty(value = "过点时间")
    private Date recordTime;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiTransferRouteInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiTransferRouteInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiTransferRouteInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiTransferRouteInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiTransferRouteInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiTransferRouteInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiTransferRouteInfoEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiTransferRouteInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiTransferRouteInfoEntity() {
    }
    
    public PsiTransferRouteInfoEntity(Long routeId) {
        this.routeId = routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
    public Long getRouteId() {
        return this.routeId;
    }
    

    public void setDispatchInfoId(Long dispatchInfoId) {
        this.dispatchInfoId = dispatchInfoId;
    }
    public Long getDispatchInfoId() {
        return this.dispatchInfoId;
    }
    
    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }
    public String getCurrentAddress() {
        return this.currentAddress;
    }
    
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
    public Date getRecordTime() {
        return this.recordTime;
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
              (routeId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                routeId = RandomIDGennerator.get().generate();
    }

    public interface PsiTransferRouteInfoEntityValidGroup {}
    public interface RouteIdValidGroup {}
    public interface DispatchInfoIdValidGroup {}
    public interface CurrentAddressValidGroup {}
    public interface RecordTimeValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiTransferRouteInfoEntity.RouteIdValidGroup.class
            , PsiTransferRouteInfoEntity.DispatchInfoIdValidGroup.class
            , PsiTransferRouteInfoEntity.CurrentAddressValidGroup.class
            , PsiTransferRouteInfoEntity.RecordTimeValidGroup.class
            , PsiTransferRouteInfoEntity.CreatedByValidGroup.class
            , PsiTransferRouteInfoEntity.CreatedDateValidGroup.class
            , PsiTransferRouteInfoEntity.UpdatedByValidGroup.class
            , PsiTransferRouteInfoEntity.UpdatedDateValidGroup.class
            , PsiTransferRouteInfoEntity.IsEnableValidGroup.class
            , PsiTransferRouteInfoEntity.IsDeleteValidGroup.class
        };
    }
}
