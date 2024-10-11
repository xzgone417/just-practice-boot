/**
 * MenuInfoEntity.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
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

/**
 * ClassName: MenuInfoEntity
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
@ApiModel(value = "MenuInfoEntity", description = "菜单")
@GroupSequence({MenuInfoEntity.class, MenuInfoEntity.MenuInfoEntityValidGroup.class,MenuInfoEntity.MenuIdValidGroup.class,MenuInfoEntity.ParentMenuIdValidGroup.class,MenuInfoEntity.MenuNameValidGroup.class,MenuInfoEntity.IdentifierIdValidGroup.class,MenuInfoEntity.IsValidValidGroup.class,MenuInfoEntity.IsDeleteValidGroup.class,MenuInfoEntity.MenuSequenceValidGroup.class,MenuInfoEntity.CreatedByValidGroup.class,MenuInfoEntity.CreatedDateValidGroup.class,MenuInfoEntity.UpdatedByValidGroup.class,MenuInfoEntity.UpdatedDateValidGroup.class}) 
public class MenuInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 菜单标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "菜单标识 不能是Null", groups = {MenuInfoEntityValidGroup.class, MenuIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="菜单标识 数字精度必须符合(19,0)", groups = {MenuInfoEntityValidGroup.class, MenuIdValidGroup.class})
    @ApiModelProperty(value = "菜单标识")
    private Long menuId;
    
    
    /**
     * 父菜单
     */
    @Digits(integer=19, fraction=0, message="父菜单 数字精度必须符合(19,0)", groups = {MenuInfoEntityValidGroup.class, ParentMenuIdValidGroup.class})
    @ApiModelProperty(value = "父菜单")
    private Long parentMenuId;
    
    /**
     * 菜单名
     */
    @NotNull(message = "菜单名 不能是Null", groups = {MenuInfoEntityValidGroup.class, MenuNameValidGroup.class})
    @Size(min=0, max=45, message="菜单名 字符长度必须小于等于45", groups = {MenuInfoEntityValidGroup.class, MenuNameValidGroup.class})
    @ApiModelProperty(value = "菜单名")
    private String menuName;
    
    /**
     * 菜单对应的URL，能否看到菜单由该URL对应的资源决定
     */
    @Digits(integer=19, fraction=0, message="菜单对应的URL，能否看到菜单由该URL对应的资源决定 数字精度必须符合(19,0)", groups = {MenuInfoEntityValidGroup.class, IdentifierIdValidGroup.class})
    @ApiModelProperty(value = "菜单对应的URL，能否看到菜单由该URL对应的资源决定")
    private Long identifierId;
    
    /**
     * 是否有效：01、有效，09、无效
     */
    @NotNull(message = "是否有效：01、有效，09、无效 不能是Null", groups = {MenuInfoEntityValidGroup.class, IsValidValidGroup.class})
    @Size(min=0, max=2, message="是否有效：01、有效，09、无效 字符长度必须小于等于2", groups = {MenuInfoEntityValidGroup.class, IsValidValidGroup.class})
    @ApiModelProperty(value = "是否有效：01、有效，09、无效")
    private String isValid;
    
    /**
     * 是否被删除：00、删除，01、未删除
     */
    @NotNull(message = "是否被删除：00、删除，01、未删除 不能是Null", groups = {MenuInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、删除，01、未删除 字符长度必须小于等于2", groups = {MenuInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;
    
    /**
     * 菜单顺序号
     */
    @Digits(integer=10, fraction=0, message="菜单顺序号 数字精度必须符合(10,0)", groups = {MenuInfoEntityValidGroup.class, MenuSequenceValidGroup.class})
    @ApiModelProperty(value = "菜单顺序号")
    private Integer menuSequence;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {MenuInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {MenuInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {MenuInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {MenuInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {MenuInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {MenuInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public MenuInfoEntity() {
    }
    
    public MenuInfoEntity(Long menuId) {
        this.menuId = menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    public Long getMenuId() {
        return this.menuId;
    }
    

    public void setParentMenuId(Long parentMenuId) {
        this.parentMenuId = parentMenuId;
    }
    public Long getParentMenuId() {
        return this.parentMenuId;
    }
    
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getMenuName() {
        return this.menuName;
    }
    
    public void setIdentifierId(Long identifierId) {
        this.identifierId = identifierId;
    }
    public Long getIdentifierId() {
        return this.identifierId;
    }
    
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }
    public String getIsValid() {
        return this.isValid;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }
    
    public void setMenuSequence(Integer menuSequence) {
        this.menuSequence = menuSequence;
    }
    public Integer getMenuSequence() {
        return this.menuSequence;
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
              (menuId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                menuId = RandomIDGennerator.get().generate();
    }

    public interface MenuInfoEntityValidGroup {}
    public interface MenuIdValidGroup {}
    public interface ParentMenuIdValidGroup {}
    public interface MenuNameValidGroup {}
    public interface IdentifierIdValidGroup {}
    public interface IsValidValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface MenuSequenceValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            MenuInfoEntity.MenuIdValidGroup.class
            , MenuInfoEntity.ParentMenuIdValidGroup.class
            , MenuInfoEntity.MenuNameValidGroup.class
            , MenuInfoEntity.IdentifierIdValidGroup.class
            , MenuInfoEntity.IsValidValidGroup.class
            , MenuInfoEntity.IsDeleteValidGroup.class
            , MenuInfoEntity.MenuSequenceValidGroup.class
            , MenuInfoEntity.CreatedByValidGroup.class
            , MenuInfoEntity.CreatedDateValidGroup.class
            , MenuInfoEntity.UpdatedByValidGroup.class
            , MenuInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
