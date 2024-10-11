package com.exp.ucmp.entity;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "RelationshipTypeCodeEntity", description = "当事人关系类型")
@GroupSequence({RelationshipTypeCodeEntity.class, RelationshipTypeCodeEntity.RelationshipTypeCodeEntityValidGroup.class,RelationshipTypeCodeEntity.RelationshipTypeCodeValidGroup.class,RelationshipTypeCodeEntity.RelationshipTypeDescValidGroup.class}) 
public class RelationshipTypeCodeEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 当事人关系类型Code
     */
    @NotNull(message = "当事人关系类型Code 不能是Null", groups = {RelationshipTypeCodeEntityValidGroup.class, RelationshipTypeCodeValidGroup.class})
    @Size(min=0, max=4, message="当事人关系类型Code 字符长度必须小于等于4", groups = {RelationshipTypeCodeEntityValidGroup.class, RelationshipTypeCodeValidGroup.class})
    @ApiModelProperty(value = "当事人关系类型Code")
    private String relationshipTypeCode;
    
    
    /**
     * 当事人关系类型描述
     */
    @Size(min=0, max=45, message="当事人关系类型描述 字符长度必须小于等于45", groups = {RelationshipTypeCodeEntityValidGroup.class, RelationshipTypeDescValidGroup.class})
    @ApiModelProperty(value = "当事人关系类型描述")
    private String relationshipTypeDesc;
    
    public RelationshipTypeCodeEntity() {
    }
    
    public RelationshipTypeCodeEntity(String relationshipTypeCode) {
        this.relationshipTypeCode = relationshipTypeCode;
    }

    public void setRelationshipTypeCode(String relationshipTypeCode) {
        this.relationshipTypeCode = relationshipTypeCode;
    }
    public String getRelationshipTypeCode() {
        return this.relationshipTypeCode;
    }
    

    public void setRelationshipTypeDesc(String relationshipTypeDesc) {
        this.relationshipTypeDesc = relationshipTypeDesc;
    }
    public String getRelationshipTypeDesc() {
        return this.relationshipTypeDesc;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (relationshipTypeCode == null || relationshipTypeCode.trim().length() == 0)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                relationshipTypeCode = null;
    }

    public interface RelationshipTypeCodeEntityValidGroup {}
    public interface RelationshipTypeCodeValidGroup {}
    public interface RelationshipTypeDescValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RelationshipTypeCodeEntity.RelationshipTypeCodeValidGroup.class
            , RelationshipTypeCodeEntity.RelationshipTypeDescValidGroup.class
        };
    }
}
