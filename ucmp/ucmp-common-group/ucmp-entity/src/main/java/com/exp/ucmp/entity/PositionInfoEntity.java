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

@ApiModel(value = "PositionInfoEntity", description = "职位信息")
@GroupSequence({PositionInfoEntity.class, PositionInfoEntity.PositionInfoEntityValidGroup.class,PositionInfoEntity.PartyIdValidGroup.class,PositionInfoEntity.PositionNameValidGroup.class,PositionInfoEntity.PositionMemoValidGroup.class,PositionInfoEntity.CreatedByValidGroup.class,PositionInfoEntity.CreatedDateValidGroup.class,PositionInfoEntity.UpdatedByValidGroup.class,PositionInfoEntity.UpdatedDateValidGroup.class}) 
public class PositionInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = " 不能是Null", groups = {PositionInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message=" 数字精度必须符合(19,0)", groups = {PositionInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "")
    private Long partyId;
    
    
    /**
     * 职位名称
     */
    @Size(min=0, max=45, message="职位名称 字符长度必须小于等于45", groups = {PositionInfoEntityValidGroup.class, PositionNameValidGroup.class})
    @ApiModelProperty(value = "职位名称")
    private String positionName;
    
    /**
     * 职位描述
     */
    @Size(min=0, max=200, message="职位描述 字符长度必须小于等于200", groups = {PositionInfoEntityValidGroup.class, PositionMemoValidGroup.class})
    @ApiModelProperty(value = "职位描述")
    private String positionMemo;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PositionInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PositionInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PositionInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PositionInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PositionInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PositionInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PositionInfoEntity() {
    }
    
    public PositionInfoEntity(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
    public String getPositionName() {
        return this.positionName;
    }
    
    public void setPositionMemo(String positionMemo) {
        this.positionMemo = positionMemo;
    }
    public String getPositionMemo() {
        return this.positionMemo;
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
              (partyId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                partyId = RandomIDGennerator.get().generate();
    }

    public interface PositionInfoEntityValidGroup {}
    public interface PartyIdValidGroup {}
    public interface PositionNameValidGroup {}
    public interface PositionMemoValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PositionInfoEntity.PartyIdValidGroup.class
            , PositionInfoEntity.PositionNameValidGroup.class
            , PositionInfoEntity.PositionMemoValidGroup.class
            , PositionInfoEntity.CreatedByValidGroup.class
            , PositionInfoEntity.CreatedDateValidGroup.class
            , PositionInfoEntity.UpdatedByValidGroup.class
            , PositionInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
