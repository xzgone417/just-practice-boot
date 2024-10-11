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

@ApiModel(value = "SysMenuExtendedInfoEntity", description = "菜单的扩展信息，补充一些当前菜单不支持的一些属性")
@GroupSequence({SysMenuExtendedInfoEntity.class, SysMenuExtendedInfoEntity.SysMenuExtendedInfoEntityValidGroup.class,SysMenuExtendedInfoEntity.MenuIdValidGroup.class,SysMenuExtendedInfoEntity.MenuPathValidGroup.class,SysMenuExtendedInfoEntity.CreatedByValidGroup.class,SysMenuExtendedInfoEntity.CreatedDateValidGroup.class,SysMenuExtendedInfoEntity.UpdatedByValidGroup.class,SysMenuExtendedInfoEntity.UpdatedDateValidGroup.class}) 
public class SysMenuExtendedInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 菜单ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "菜单ID 不能是Null", groups = {SysMenuExtendedInfoEntityValidGroup.class, MenuIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="菜单ID 数字精度必须符合(19,0)", groups = {SysMenuExtendedInfoEntityValidGroup.class, MenuIdValidGroup.class})
    @ApiModelProperty(value = "菜单ID")
    private Long menuId;
    
    
    /**
     * 菜单路径
     */
    @NotNull(message = "菜单路径 不能是Null", groups = {SysMenuExtendedInfoEntityValidGroup.class, MenuPathValidGroup.class})
    @Size(min=0, max=100, message="菜单路径 字符长度必须小于等于100", groups = {SysMenuExtendedInfoEntityValidGroup.class, MenuPathValidGroup.class})
    @ApiModelProperty(value = "菜单路径")
    private String menuPath;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysMenuExtendedInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysMenuExtendedInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysMenuExtendedInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysMenuExtendedInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysMenuExtendedInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysMenuExtendedInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysMenuExtendedInfoEntity() {
    }
    
    public SysMenuExtendedInfoEntity(Long menuId) {
        this.menuId = menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    public Long getMenuId() {
        return this.menuId;
    }
    

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }
    public String getMenuPath() {
        return this.menuPath;
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

    public interface SysMenuExtendedInfoEntityValidGroup {}
    public interface MenuIdValidGroup {}
    public interface MenuPathValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            SysMenuExtendedInfoEntity.MenuIdValidGroup.class
            , SysMenuExtendedInfoEntity.MenuPathValidGroup.class
            , SysMenuExtendedInfoEntity.CreatedByValidGroup.class
            , SysMenuExtendedInfoEntity.CreatedDateValidGroup.class
            , SysMenuExtendedInfoEntity.UpdatedByValidGroup.class
            , SysMenuExtendedInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
