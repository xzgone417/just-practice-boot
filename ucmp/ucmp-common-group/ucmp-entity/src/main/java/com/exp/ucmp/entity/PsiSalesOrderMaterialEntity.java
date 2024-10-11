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

@ApiModel(value = "PsiSalesOrderMaterialEntity", description = "二手车销售材料表")
@GroupSequence({PsiSalesOrderMaterialEntity.class, PsiSalesOrderMaterialEntity.PsiSalesOrderMaterialEntityValidGroup.class,PsiSalesOrderMaterialEntity.MaterialIdValidGroup.class,PsiSalesOrderMaterialEntity.OrderInfoIdValidGroup.class,PsiSalesOrderMaterialEntity.MaterialTypeValidGroup.class,PsiSalesOrderMaterialEntity.UploadPersonValidGroup.class,PsiSalesOrderMaterialEntity.UploadDateValidGroup.class}) 
public class PsiSalesOrderMaterialEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 材料ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "材料ID 不能是Null", groups = {PsiSalesOrderMaterialEntityValidGroup.class, MaterialIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="材料ID 数字精度必须符合(19,0)", groups = {PsiSalesOrderMaterialEntityValidGroup.class, MaterialIdValidGroup.class})
    @ApiModelProperty(value = "材料ID")
    private Long materialId;
    
    
    /**
     * 销售订单ID
     */
    @NotNull(message = "销售订单ID 不能是Null", groups = {PsiSalesOrderMaterialEntityValidGroup.class, OrderInfoIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="销售订单ID 数字精度必须符合(19,0)", groups = {PsiSalesOrderMaterialEntityValidGroup.class, OrderInfoIdValidGroup.class})
    @ApiModelProperty(value = "销售订单ID")
    private Long orderInfoId;
    
    /**
     * 材料类型
     */
    @NotNull(message = "材料类型 不能是Null", groups = {PsiSalesOrderMaterialEntityValidGroup.class, MaterialTypeValidGroup.class})
    @Size(min=0, max=4, message="材料类型 字符长度必须小于等于4", groups = {PsiSalesOrderMaterialEntityValidGroup.class, MaterialTypeValidGroup.class})
    @ApiModelProperty(value = "材料类型")
    private String materialType;
    
    /**
     * 上传人
     */
    @NotNull(message = "上传人 不能是Null", groups = {PsiSalesOrderMaterialEntityValidGroup.class, UploadPersonValidGroup.class})
    @Digits(integer=19, fraction=0, message="上传人 数字精度必须符合(19,0)", groups = {PsiSalesOrderMaterialEntityValidGroup.class, UploadPersonValidGroup.class})
    @ApiModelProperty(value = "上传人")
    private Long uploadPerson;
    
    /**
     * 上传时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "上传时间 不能是Null", groups = {PsiSalesOrderMaterialEntityValidGroup.class, UploadDateValidGroup.class})
    @ApiModelProperty(value = "上传时间")
    private Date uploadDate;
    
    public PsiSalesOrderMaterialEntity() {
    }
    
    public PsiSalesOrderMaterialEntity(Long materialId) {
        this.materialId = materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }
    public Long getMaterialId() {
        return this.materialId;
    }
    

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }
    public Long getOrderInfoId() {
        return this.orderInfoId;
    }
    
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
    public String getMaterialType() {
        return this.materialType;
    }
    
    public void setUploadPerson(Long uploadPerson) {
        this.uploadPerson = uploadPerson;
    }
    public Long getUploadPerson() {
        return this.uploadPerson;
    }
    
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
    public Date getUploadDate() {
        return this.uploadDate;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (materialId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                materialId = RandomIDGennerator.get().generate();
    }

    public interface PsiSalesOrderMaterialEntityValidGroup {}
    public interface MaterialIdValidGroup {}
    public interface OrderInfoIdValidGroup {}
    public interface MaterialTypeValidGroup {}
    public interface UploadPersonValidGroup {}
    public interface UploadDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            MaterialIdValidGroup.class
            , OrderInfoIdValidGroup.class
            , MaterialTypeValidGroup.class
            , UploadPersonValidGroup.class
            , UploadDateValidGroup.class
        };
    }
}
