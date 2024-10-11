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

@ApiModel(value = "SysStoreStaffUserMappingEntity", description = "门店人员外部系统主键映射表详情表")
@GroupSequence({SysStoreStaffUserMappingEntity.class, SysStoreStaffUserMappingEntity.SysStoreStaffUserMappingEntityValidGroup.class,SysStoreStaffUserMappingEntity.MappingIdValidGroup.class,SysStoreStaffUserMappingEntity.PartyIdValidGroup.class,SysStoreStaffUserMappingEntity.UserIdValidGroup.class,SysStoreStaffUserMappingEntity.CreatedByValidGroup.class,SysStoreStaffUserMappingEntity.CreatedDateValidGroup.class,SysStoreStaffUserMappingEntity.UpdatedByValidGroup.class,SysStoreStaffUserMappingEntity.UpdatedDateValidGroup.class,SysStoreStaffUserMappingEntity.IsDeleteValidGroup.class}) 
public class SysStoreStaffUserMappingEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 映射id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "映射id 不能是Null", groups = {SysStoreStaffUserMappingEntityValidGroup.class, MappingIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="映射id 数字精度必须符合(19,0)", groups = {SysStoreStaffUserMappingEntityValidGroup.class, MappingIdValidGroup.class})
    @ApiModelProperty(value = "映射id")
    private Long mappingId;
    
    
    /**
     * 人员id
     */
    @NotNull(message = "人员id 不能是Null", groups = {SysStoreStaffUserMappingEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="人员id 数字精度必须符合(19,0)", groups = {SysStoreStaffUserMappingEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "人员id")
    private Long partyId;
    
    /**
     * 人员编号
     */
    @NotNull(message = "人员编号 不能是Null", groups = {SysStoreStaffUserMappingEntityValidGroup.class, UserIdValidGroup.class})
    @Size(min=0, max=20, message="人员编号 字符长度必须小于等于20", groups = {SysStoreStaffUserMappingEntityValidGroup.class, UserIdValidGroup.class})
    @ApiModelProperty(value = "人员编号")
    private String userId;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysStoreStaffUserMappingEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysStoreStaffUserMappingEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysStoreStaffUserMappingEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysStoreStaffUserMappingEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysStoreStaffUserMappingEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysStoreStaffUserMappingEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否被删除：00、删除，01、未删除
     */
    @NotNull(message = "是否被删除：00、删除，01、未删除 不能是Null", groups = {SysStoreStaffUserMappingEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、删除，01、未删除 字符长度必须小于等于2", groups = {SysStoreStaffUserMappingEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;
    
    public SysStoreStaffUserMappingEntity() {
    }
    
    public SysStoreStaffUserMappingEntity(Long mappingId) {
        this.mappingId = mappingId;
    }

    public void setMappingId(Long mappingId) {
        this.mappingId = mappingId;
    }
    public Long getMappingId() {
        return this.mappingId;
    }
    

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserId() {
        return this.userId;
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
              (mappingId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                mappingId = RandomIDGennerator.get().generate();
    }

    public interface SysStoreStaffUserMappingEntityValidGroup {}
    public interface MappingIdValidGroup {}
    public interface PartyIdValidGroup {}
    public interface UserIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            SysStoreStaffUserMappingEntity.MappingIdValidGroup.class
            , SysStoreStaffUserMappingEntity.PartyIdValidGroup.class
            , SysStoreStaffUserMappingEntity.UserIdValidGroup.class
            , SysStoreStaffUserMappingEntity.CreatedByValidGroup.class
            , SysStoreStaffUserMappingEntity.CreatedDateValidGroup.class
            , SysStoreStaffUserMappingEntity.UpdatedByValidGroup.class
            , SysStoreStaffUserMappingEntity.UpdatedDateValidGroup.class
            , SysStoreStaffUserMappingEntity.IsDeleteValidGroup.class
        };
    }
}
