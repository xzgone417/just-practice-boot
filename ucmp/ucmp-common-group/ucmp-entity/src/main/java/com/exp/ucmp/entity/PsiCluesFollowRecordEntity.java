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

@ApiModel(value = "PsiCluesFollowRecordEntity", description = "线索跟进记录表(v2)")
@GroupSequence({PsiCluesFollowRecordEntity.class, PsiCluesFollowRecordEntity.PsiCluesFollowRecordEntityValidGroup.class,PsiCluesFollowRecordEntity.FollowIdValidGroup.class,PsiCluesFollowRecordEntity.CluesIdValidGroup.class,PsiCluesFollowRecordEntity.FollowTimeValidGroup.class,PsiCluesFollowRecordEntity.FollowInfoValidGroup.class,PsiCluesFollowRecordEntity.LastFollowTimeValidGroup.class,PsiCluesFollowRecordEntity.FollowTypeValidGroup.class,PsiCluesFollowRecordEntity.IsArrivalValidGroup.class,PsiCluesFollowRecordEntity.FollowStatusValidGroup.class,PsiCluesFollowRecordEntity.FollowPersonValidGroup.class,PsiCluesFollowRecordEntity.CreatedByValidGroup.class,PsiCluesFollowRecordEntity.CreatedDateValidGroup.class,PsiCluesFollowRecordEntity.UpdatedByValidGroup.class,PsiCluesFollowRecordEntity.UpdatedDateValidGroup.class,PsiCluesFollowRecordEntity.IsEnableValidGroup.class,PsiCluesFollowRecordEntity.IsDeleteValidGroup.class}) 
public class PsiCluesFollowRecordEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 跟进记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "跟进记录id 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="跟进记录id 数字精度必须符合(19,0)", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowIdValidGroup.class})
    @ApiModelProperty(value = "跟进记录id")
    private Long followId;
    
    
    /**
     * 线索id
     */
    @NotNull(message = "线索id 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, CluesIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="线索id 数字精度必须符合(19,0)", groups = {PsiCluesFollowRecordEntityValidGroup.class, CluesIdValidGroup.class})
    @ApiModelProperty(value = "线索id")
    private Long cluesId;
    
    /**
     * 跟进时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "跟进时间 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowTimeValidGroup.class})
    @ApiModelProperty(value = "跟进时间")
    private Date followTime;
    
    /**
     * 跟进信息
     */
    @NotNull(message = "跟进信息 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowInfoValidGroup.class})
    @Size(min=0, max=200, message="跟进信息 字符长度必须小于等于200", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowInfoValidGroup.class})
    @ApiModelProperty(value = "跟进信息")
    private String followInfo;
    
    /**
     * 上次跟进时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "上次跟进时间 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, LastFollowTimeValidGroup.class})
    @ApiModelProperty(value = "上次跟进时间")
    private Date lastFollowTime;
    
    /**
     * 跟进方式
     */
    @NotNull(message = "跟进方式 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowTypeValidGroup.class})
    @Size(min=0, max=4, message="跟进方式 字符长度必须小于等于4", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowTypeValidGroup.class})
    @ApiModelProperty(value = "跟进方式")
    private String followType;
    
    /**
     * 是否到店(00不到店 01到店)
     */
    @Size(min=0, max=2, message="是否到店(00不到店 01到店) 字符长度必须小于等于2", groups = {PsiCluesFollowRecordEntityValidGroup.class, IsArrivalValidGroup.class})
    @ApiModelProperty(value = "是否到店(00不到店 01到店)")
    private String isArrival;
    
    /**
     * 跟进状态
     */
    @NotNull(message = "跟进状态 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowStatusValidGroup.class})
    @Size(min=0, max=4, message="跟进状态 字符长度必须小于等于4", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowStatusValidGroup.class})
    @ApiModelProperty(value = "跟进状态")
    private String followStatus;

    /**
     * 跟进门店
     */
    @NotNull(message = "跟进门店 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowPersonValidGroup.class})
    @Digits(integer=19, fraction=0, message="跟进门店 数字精度必须符合(19,0)", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowPersonValidGroup.class})
    @ApiModelProperty(value = "跟进门店")
    private Long followStore;
    
    /**
     * 跟进人
     */
    @NotNull(message = "跟进人 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowPersonValidGroup.class})
    @Digits(integer=19, fraction=0, message="跟进人 数字精度必须符合(19,0)", groups = {PsiCluesFollowRecordEntityValidGroup.class, FollowPersonValidGroup.class})
    @ApiModelProperty(value = "跟进人")
    private Long followPerson;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCluesFollowRecordEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCluesFollowRecordEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCluesFollowRecordEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiCluesFollowRecordEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiCluesFollowRecordEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiCluesFollowRecordEntity() {
    }
    
    public PsiCluesFollowRecordEntity(Long followId) {
        this.followId = followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }
    public Long getFollowId() {
        return this.followId;
    }
    

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }
    public Long getCluesId() {
        return this.cluesId;
    }
    
    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
    public Date getFollowTime() {
        return this.followTime;
    }
    
    public void setFollowInfo(String followInfo) {
        this.followInfo = followInfo;
    }
    public String getFollowInfo() {
        return this.followInfo;
    }
    
    public void setLastFollowTime(Date lastFollowTime) {
        this.lastFollowTime = lastFollowTime;
    }
    public Date getLastFollowTime() {
        return this.lastFollowTime;
    }
    
    public void setFollowType(String followType) {
        this.followType = followType;
    }
    public String getFollowType() {
        return this.followType;
    }
    
    public void setIsArrival(String isArrival) {
        this.isArrival = isArrival;
    }
    public String getIsArrival() {
        return this.isArrival;
    }
    
    public void setFollowStatus(String followStatus) {
        this.followStatus = followStatus;
    }
    public String getFollowStatus() {
        return this.followStatus;
    }
    
    public void setFollowPerson(Long followPerson) {
        this.followPerson = followPerson;
    }
    public Long getFollowPerson() {
        return this.followPerson;
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

    public Long getFollowStore() {
        return followStore;
    }

    public void setFollowStore(Long followStore) {
        this.followStore = followStore;
    }

    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (followId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                followId = RandomIDGennerator.get().generate();
    }

    public interface PsiCluesFollowRecordEntityValidGroup {}
    public interface FollowIdValidGroup {}
    public interface CluesIdValidGroup {}
    public interface FollowTimeValidGroup {}
    public interface FollowInfoValidGroup {}
    public interface LastFollowTimeValidGroup {}
    public interface FollowTypeValidGroup {}
    public interface IsArrivalValidGroup {}
    public interface FollowStatusValidGroup {}
    public interface FollowPersonValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            FollowIdValidGroup.class
            , CluesIdValidGroup.class
            , FollowTimeValidGroup.class
            , FollowInfoValidGroup.class
            , LastFollowTimeValidGroup.class
            , FollowTypeValidGroup.class
            , IsArrivalValidGroup.class
            , FollowStatusValidGroup.class
            , FollowPersonValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
