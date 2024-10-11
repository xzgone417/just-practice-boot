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

@ApiModel(value = "PsiBusinessNodesMaterialEntity", description = "业务节点材料表")
@GroupSequence({PsiBusinessNodesMaterialEntity.class, PsiBusinessNodesMaterialEntity.PsiBusinessNodesMaterialEntityValidGroup.class,PsiBusinessNodesMaterialEntity.IdValidGroup.class,PsiBusinessNodesMaterialEntity.BusinessNodesValidGroup.class,PsiBusinessNodesMaterialEntity.BusinessNodesNameValidGroup.class,PsiBusinessNodesMaterialEntity.MaterialTypeValidGroup.class,PsiBusinessNodesMaterialEntity.MaterialTypeNameValidGroup.class,PsiBusinessNodesMaterialEntity.MaterialSequenceValidGroup.class,PsiBusinessNodesMaterialEntity.MaterialCountValidGroup.class,PsiBusinessNodesMaterialEntity.IsUploadValidGroup.class,PsiBusinessNodesMaterialEntity.CreatedByValidGroup.class,PsiBusinessNodesMaterialEntity.CreatedDateValidGroup.class,PsiBusinessNodesMaterialEntity.UpdatedByValidGroup.class,PsiBusinessNodesMaterialEntity.UpdatedDateValidGroup.class}) 
public class PsiBusinessNodesMaterialEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "ID 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, IdValidGroup.class})
    @Digits(integer=19, fraction=0, message="ID 数字精度必须符合(19,0)", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, IdValidGroup.class})
    @ApiModelProperty(value = "ID")
    private Long id;
    
    
    /**
     * 业务节点
     */
    @NotNull(message = "业务节点 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, BusinessNodesValidGroup.class})
    @Size(min=0, max=10, message="业务节点 字符长度必须小于等于10", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, BusinessNodesValidGroup.class})
    @ApiModelProperty(value = "业务节点")
    private String businessNodes;
    
    /**
     * 业务节点中文
     */
    @NotNull(message = "业务节点中文 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, BusinessNodesNameValidGroup.class})
    @Size(min=0, max=10, message="业务节点中文 字符长度必须小于等于10", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, BusinessNodesNameValidGroup.class})
    @ApiModelProperty(value = "业务节点中文")
    private String businessNodesName;
    
    /**
     * 材料类型
     */
    @NotNull(message = "材料类型 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, MaterialTypeValidGroup.class})
    @Size(min=0, max=4, message="材料类型 字符长度必须小于等于4", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, MaterialTypeValidGroup.class})
    @ApiModelProperty(value = "材料类型")
    private String materialType;
    
    /**
     * 材料类型中文
     */
    @NotNull(message = "材料类型中文 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, MaterialTypeNameValidGroup.class})
    @Size(min=0, max=10, message="材料类型中文 字符长度必须小于等于10", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, MaterialTypeNameValidGroup.class})
    @ApiModelProperty(value = "材料类型中文")
    private String materialTypeName;
    
    /**
     * 材料顺序
     */
    @NotNull(message = "材料顺序 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, MaterialSequenceValidGroup.class})
    @Digits(integer=10, fraction=0, message="材料顺序 数字精度必须符合(10,0)", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, MaterialSequenceValidGroup.class})
    @ApiModelProperty(value = "材料顺序")
    private Integer materialSequence;
    
    /**
     * 材料个数
     */
    @NotNull(message = "材料个数 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, MaterialCountValidGroup.class})
    @Digits(integer=10, fraction=0, message="材料个数 数字精度必须符合(10,0)", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, MaterialCountValidGroup.class})
    @ApiModelProperty(value = "材料个数")
    private Integer materialCount;
    
    /**
     * 是否必传(0必传，1非必传)
     */
    @NotNull(message = "是否必传(0必传，1非必传) 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, IsUploadValidGroup.class})
    @Digits(integer=10, fraction=0, message="是否必传(0必传，1非必传) 数字精度必须符合(10,0)", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, IsUploadValidGroup.class})
    @ApiModelProperty(value = "是否必传(0必传，1非必传)")
    private Integer isUpload;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiBusinessNodesMaterialEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PsiBusinessNodesMaterialEntity() {
    }
    
    public PsiBusinessNodesMaterialEntity(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }
    

    public void setBusinessNodes(String businessNodes) {
        this.businessNodes = businessNodes;
    }
    public String getBusinessNodes() {
        return this.businessNodes;
    }
    
    public void setBusinessNodesName(String businessNodesName) {
        this.businessNodesName = businessNodesName;
    }
    public String getBusinessNodesName() {
        return this.businessNodesName;
    }
    
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
    public String getMaterialType() {
        return this.materialType;
    }
    
    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }
    public String getMaterialTypeName() {
        return this.materialTypeName;
    }
    
    public void setMaterialSequence(Integer materialSequence) {
        this.materialSequence = materialSequence;
    }
    public Integer getMaterialSequence() {
        return this.materialSequence;
    }
    
    public void setMaterialCount(Integer materialCount) {
        this.materialCount = materialCount;
    }
    public Integer getMaterialCount() {
        return this.materialCount;
    }
    
    public void setIsUpload(Integer isUpload) {
        this.isUpload = isUpload;
    }
    public Integer getIsUpload() {
        return this.isUpload;
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
              (id == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                id = RandomIDGennerator.get().generate();
    }

    public interface PsiBusinessNodesMaterialEntityValidGroup {}
    public interface IdValidGroup {}
    public interface BusinessNodesValidGroup {}
    public interface BusinessNodesNameValidGroup {}
    public interface MaterialTypeValidGroup {}
    public interface MaterialTypeNameValidGroup {}
    public interface MaterialSequenceValidGroup {}
    public interface MaterialCountValidGroup {}
    public interface IsUploadValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            IdValidGroup.class
            , BusinessNodesValidGroup.class
            , BusinessNodesNameValidGroup.class
            , MaterialTypeValidGroup.class
            , MaterialTypeNameValidGroup.class
            , MaterialSequenceValidGroup.class
            , MaterialCountValidGroup.class
            , IsUploadValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
