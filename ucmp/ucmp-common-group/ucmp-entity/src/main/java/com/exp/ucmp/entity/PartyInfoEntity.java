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

@ApiModel(value = "PartyInfoEntity", description = "当事人信息")
@GroupSequence({PartyInfoEntity.class, PartyInfoEntity.PartyInfoEntityValidGroup.class,PartyInfoEntity.PartyIdValidGroup.class,PartyInfoEntity.PartyTypeValidGroup.class,PartyInfoEntity.CreatedByValidGroup.class,PartyInfoEntity.CreatedDateValidGroup.class,PartyInfoEntity.UpdatedByValidGroup.class,PartyInfoEntity.UpdatedDateValidGroup.class}) 
public class PartyInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 当事人标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "当事人标识 不能是Null", groups = {PartyInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="当事人标识 数字精度必须符合(19,0)", groups = {PartyInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;
    
    
    /**
     * 当事人类型：0100、人员，0200、组织，0300、职位
     */
    @NotNull(message = "当事人类型：0100、人员，0200、组织，0300、职位 不能是Null", groups = {PartyInfoEntityValidGroup.class, PartyTypeValidGroup.class})
    @Size(min=0, max=4, message="当事人类型：0100、人员，0200、组织，0300、职位 字符长度必须小于等于4", groups = {PartyInfoEntityValidGroup.class, PartyTypeValidGroup.class})
    @ApiModelProperty(value = "当事人类型：0100、人员，0200、组织，0300、职位")
    private String partyType;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PartyInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PartyInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PartyInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PartyInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PartyInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PartyInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PartyInfoEntity() {
    }
    
    public PartyInfoEntity(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }
    public String getPartyType() {
        return this.partyType;
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

    public interface PartyInfoEntityValidGroup {}
    public interface PartyIdValidGroup {}
    public interface PartyTypeValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PartyInfoEntity.PartyIdValidGroup.class
            , PartyInfoEntity.PartyTypeValidGroup.class
            , PartyInfoEntity.CreatedByValidGroup.class
            , PartyInfoEntity.CreatedDateValidGroup.class
            , PartyInfoEntity.UpdatedByValidGroup.class
            , PartyInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
