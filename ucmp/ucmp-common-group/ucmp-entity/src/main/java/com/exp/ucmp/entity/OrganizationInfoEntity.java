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

@ApiModel(value = "OrganizationInfoEntity", description = "组织机构信息")
@GroupSequence({OrganizationInfoEntity.class, OrganizationInfoEntity.OrganizationInfoEntityValidGroup.class,OrganizationInfoEntity.PartyIdValidGroup.class,OrganizationInfoEntity.OrganNameValidGroup.class,OrganizationInfoEntity.CreatedByValidGroup.class,OrganizationInfoEntity.CreatedDateValidGroup.class,OrganizationInfoEntity.UpdatedByValidGroup.class,OrganizationInfoEntity.UpdatedDateValidGroup.class}) 
public class OrganizationInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 组织机构ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "组织机构ID 不能是Null", groups = {OrganizationInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="组织机构ID 数字精度必须符合(19,0)", groups = {OrganizationInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "组织机构ID")
    private Long partyId;
    
    
    /**
     * 组织机构名称
     */
    @Size(min=0, max=45, message="组织机构名称 字符长度必须小于等于45", groups = {OrganizationInfoEntityValidGroup.class, OrganNameValidGroup.class})
    @ApiModelProperty(value = "组织机构名称")
    private String organName;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {OrganizationInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {OrganizationInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {OrganizationInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {OrganizationInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {OrganizationInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {OrganizationInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public OrganizationInfoEntity() {
    }
    
    public OrganizationInfoEntity(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    

    public void setOrganName(String organName) {
        this.organName = organName;
    }
    public String getOrganName() {
        return this.organName;
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

    public interface OrganizationInfoEntityValidGroup {}
    public interface PartyIdValidGroup {}
    public interface OrganNameValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            OrganizationInfoEntity.PartyIdValidGroup.class
            , OrganizationInfoEntity.OrganNameValidGroup.class
            , OrganizationInfoEntity.CreatedByValidGroup.class
            , OrganizationInfoEntity.CreatedDateValidGroup.class
            , OrganizationInfoEntity.UpdatedByValidGroup.class
            , OrganizationInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
