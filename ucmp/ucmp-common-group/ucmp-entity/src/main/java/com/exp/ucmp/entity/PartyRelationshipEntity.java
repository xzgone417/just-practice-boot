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

@ApiModel(value = "PartyRelationshipEntity", description = "当事人关系")
@GroupSequence({PartyRelationshipEntity.class, PartyRelationshipEntity.PartyRelationshipEntityValidGroup.class,PartyRelationshipEntity.RelationshipIdValidGroup.class,PartyRelationshipEntity.RelationshipTypeCodeValidGroup.class,PartyRelationshipEntity.SrcPartyIdValidGroup.class,PartyRelationshipEntity.TagPartyIdValidGroup.class,PartyRelationshipEntity.CreatedByValidGroup.class,PartyRelationshipEntity.CreatedDateValidGroup.class,PartyRelationshipEntity.UpdatedByValidGroup.class,PartyRelationshipEntity.UpdatedDateValidGroup.class}) 
public class PartyRelationshipEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 当事人标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "当事人标识 不能是Null", groups = {PartyRelationshipEntityValidGroup.class, RelationshipIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="当事人标识 数字精度必须符合(19,0)", groups = {PartyRelationshipEntityValidGroup.class, RelationshipIdValidGroup.class})
    @ApiModelProperty(value = "当事人标识")
    private Long relationshipId;
    
    
    /**
     * 当事人关系类型(比如说隶属：当事人张三隶属于运营部)
     */
    @NotNull(message = "当事人关系类型(比如说隶属：当事人张三隶属于运营部) 不能是Null", groups = {PartyRelationshipEntityValidGroup.class, RelationshipTypeCodeValidGroup.class})
    @Size(min=0, max=4, message="当事人关系类型(比如说隶属：当事人张三隶属于运营部) 字符长度必须小于等于4", groups = {PartyRelationshipEntityValidGroup.class, RelationshipTypeCodeValidGroup.class})
    @ApiModelProperty(value = "当事人关系类型(比如说隶属：当事人张三隶属于运营部)")
    private String relationshipTypeCode;
    
    /**
     * 源当事人(张三)
     */
    @NotNull(message = "源当事人(张三) 不能是Null", groups = {PartyRelationshipEntityValidGroup.class, SrcPartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="源当事人(张三) 数字精度必须符合(19,0)", groups = {PartyRelationshipEntityValidGroup.class, SrcPartyIdValidGroup.class})
    @ApiModelProperty(value = "源当事人(张三)")
    private Long srcPartyId;
    
    /**
     * 目标当事人(运营部)
     */
    @NotNull(message = "目标当事人(运营部) 不能是Null", groups = {PartyRelationshipEntityValidGroup.class, TagPartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="目标当事人(运营部) 数字精度必须符合(19,0)", groups = {PartyRelationshipEntityValidGroup.class, TagPartyIdValidGroup.class})
    @ApiModelProperty(value = "目标当事人(运营部)")
    private Long tagPartyId;
    
    /**
     * 关系开始时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "关系开始时间")
    private Date startDate;
    
    /**
     * 关系结束时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "关系结束时间")
    private Date endDate;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PartyRelationshipEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PartyRelationshipEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PartyRelationshipEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PartyRelationshipEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PartyRelationshipEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PartyRelationshipEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PartyRelationshipEntity() {
    }
    
    public PartyRelationshipEntity(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }
    public Long getRelationshipId() {
        return this.relationshipId;
    }
    

    public void setRelationshipTypeCode(String relationshipTypeCode) {
        this.relationshipTypeCode = relationshipTypeCode;
    }
    public String getRelationshipTypeCode() {
        return this.relationshipTypeCode;
    }
    
    public void setSrcPartyId(Long srcPartyId) {
        this.srcPartyId = srcPartyId;
    }
    public Long getSrcPartyId() {
        return this.srcPartyId;
    }
    
    public void setTagPartyId(Long tagPartyId) {
        this.tagPartyId = tagPartyId;
    }
    public Long getTagPartyId() {
        return this.tagPartyId;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getEndDate() {
        return this.endDate;
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
              (relationshipId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                relationshipId = RandomIDGennerator.get().generate();
    }

    public interface PartyRelationshipEntityValidGroup {}
    public interface RelationshipIdValidGroup {}
    public interface RelationshipTypeCodeValidGroup {}
    public interface SrcPartyIdValidGroup {}
    public interface TagPartyIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PartyRelationshipEntity.RelationshipIdValidGroup.class
            , PartyRelationshipEntity.RelationshipTypeCodeValidGroup.class
            , PartyRelationshipEntity.SrcPartyIdValidGroup.class
            , PartyRelationshipEntity.TagPartyIdValidGroup.class
            , PartyRelationshipEntity.CreatedByValidGroup.class
            , PartyRelationshipEntity.CreatedDateValidGroup.class
            , PartyRelationshipEntity.UpdatedByValidGroup.class
            , PartyRelationshipEntity.UpdatedDateValidGroup.class
        };
    }
}
