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

@ApiModel(value = "PsiCluesStoreConfigEntity", description = "线索分配配置表")
@GroupSequence({PsiCluesStoreConfigEntity.class, PsiCluesStoreConfigEntity.PsiCluesStoreConfigEntityValidGroup.class,PsiCluesStoreConfigEntity.IdValidGroup.class,PsiCluesStoreConfigEntity.CityNameValidGroup.class,PsiCluesStoreConfigEntity.StoreIdValidGroup.class,PsiCluesStoreConfigEntity.StatusValidGroup.class,PsiCluesStoreConfigEntity.CreatedByValidGroup.class,PsiCluesStoreConfigEntity.CreatedDateValidGroup.class,PsiCluesStoreConfigEntity.UpdatedByValidGroup.class,PsiCluesStoreConfigEntity.UpdatedDateValidGroup.class}) 
public class PsiCluesStoreConfigEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键ID 不能是Null", groups = {PsiCluesStoreConfigEntityValidGroup.class, IdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键ID 数字精度必须符合(19,0)", groups = {PsiCluesStoreConfigEntityValidGroup.class, IdValidGroup.class})
    @ApiModelProperty(value = "主键ID")
    private Long id;
    
    
    /**
     * 城市
     */
    @NotNull(message = "城市 不能是Null", groups = {PsiCluesStoreConfigEntityValidGroup.class, CityNameValidGroup.class})
    @Size(min=0, max=255, message="城市 字符长度必须小于等于255", groups = {PsiCluesStoreConfigEntityValidGroup.class, CityNameValidGroup.class})
    @ApiModelProperty(value = "城市")
    private String cityName;
    
    /**
     * 门店ID
     */
    @NotNull(message = "门店ID 不能是Null", groups = {PsiCluesStoreConfigEntityValidGroup.class, StoreIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="门店ID 数字精度必须符合(19,0)", groups = {PsiCluesStoreConfigEntityValidGroup.class, StoreIdValidGroup.class})
    @ApiModelProperty(value = "门店ID")
    private Long storeId;
    
    /**
     * 配置状态（00、已失效；01、已生效；）
     */
    @NotNull(message = "配置状态（00、已失效；01、已生效；） 不能是Null", groups = {PsiCluesStoreConfigEntityValidGroup.class, StatusValidGroup.class})
    @Size(min=0, max=2, message="配置状态（00、已失效；01、已生效；） 字符长度必须小于等于2", groups = {PsiCluesStoreConfigEntityValidGroup.class, StatusValidGroup.class})
    @ApiModelProperty(value = "配置状态（00、已失效；01、已生效；）")
    private String status;
    
    /**
     * 创建人
     */
    @NotNull(message = "创建人 不能是Null", groups = {PsiCluesStoreConfigEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人 数字精度必须符合(19,0)", groups = {PsiCluesStoreConfigEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCluesStoreConfigEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人
     */
    @NotNull(message = "更新人 不能是Null", groups = {PsiCluesStoreConfigEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人 数字精度必须符合(19,0)", groups = {PsiCluesStoreConfigEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCluesStoreConfigEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PsiCluesStoreConfigEntity() {
    }
    
    public PsiCluesStoreConfigEntity(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }
    

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCityName() {
        return this.cityName;
    }
    
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
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

    public interface PsiCluesStoreConfigEntityValidGroup {}
    public interface IdValidGroup {}
    public interface CityNameValidGroup {}
    public interface StoreIdValidGroup {}
    public interface StatusValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            IdValidGroup.class
            , CityNameValidGroup.class
            , StoreIdValidGroup.class
            , StatusValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
