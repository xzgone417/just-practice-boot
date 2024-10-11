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

@ApiModel(value = "PsiCustomerCluesEntity", description = "客户线索表")
@GroupSequence({PsiCustomerCluesEntity.class, PsiCustomerCluesEntity.PsiCustomerCluesEntityValidGroup.class,PsiCustomerCluesEntity.CluesIdValidGroup.class,PsiCustomerCluesEntity.CustomerIdValidGroup.class,PsiCustomerCluesEntity.CustomerNameValidGroup.class,PsiCustomerCluesEntity.CustomerIphoneValidGroup.class,PsiCustomerCluesEntity.CluesTypeValidGroup.class,PsiCustomerCluesEntity.CluesSourceValidGroup.class,PsiCustomerCluesEntity.CluesStatusValidGroup.class,PsiCustomerCluesEntity.CreatedByValidGroup.class,PsiCustomerCluesEntity.CreatedDateValidGroup.class,PsiCustomerCluesEntity.UpdatedByValidGroup.class,PsiCustomerCluesEntity.UpdatedDateValidGroup.class}) 
public class PsiCustomerCluesEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 线索ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "线索ID 不能是Null", groups = {PsiCustomerCluesEntityValidGroup.class, CluesIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="线索ID 数字精度必须符合(19,0)", groups = {PsiCustomerCluesEntityValidGroup.class, CluesIdValidGroup.class})
    @ApiModelProperty(value = "线索ID")
    private Long cluesId;
    
    
    /**
     * 客户ID
     */
    @NotNull(message = "客户ID 不能是Null", groups = {PsiCustomerCluesEntityValidGroup.class, CustomerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="客户ID 数字精度必须符合(19,0)", groups = {PsiCustomerCluesEntityValidGroup.class, CustomerIdValidGroup.class})
    @ApiModelProperty(value = "客户ID")
    private Long customerId;
    
    /**
     * 
     */
    @NotNull(message = " 不能是Null", groups = {PsiCustomerCluesEntityValidGroup.class, CustomerNameValidGroup.class})
    @Size(min=0, max=20, message=" 字符长度必须小于等于20", groups = {PsiCustomerCluesEntityValidGroup.class, CustomerNameValidGroup.class})
    @ApiModelProperty(value = "")
    private String customerName;
    
    /**
     * 
     */
    @NotNull(message = " 不能是Null", groups = {PsiCustomerCluesEntityValidGroup.class, CustomerIphoneValidGroup.class})
    @Size(min=0, max=20, message=" 字符长度必须小于等于20", groups = {PsiCustomerCluesEntityValidGroup.class, CustomerIphoneValidGroup.class})
    @ApiModelProperty(value = "")
    private String customerIphone;
    
    /**
     * 线索类型：01、置换线索
     */
    @NotNull(message = "线索类型：01、置换线索 不能是Null", groups = {PsiCustomerCluesEntityValidGroup.class, CluesTypeValidGroup.class})
    @Size(min=0, max=2, message="线索类型：01、置换线索 字符长度必须小于等于2", groups = {PsiCustomerCluesEntityValidGroup.class, CluesTypeValidGroup.class})
    @ApiModelProperty(value = "线索类型：01、置换线索")
    private String cluesType;
    
    /**
     * 线索来源：01、录入，02、小程序
     */
    @NotNull(message = "线索来源：01、录入，02、小程序 不能是Null", groups = {PsiCustomerCluesEntityValidGroup.class, CluesSourceValidGroup.class})
    @Size(min=0, max=2, message="线索来源：01、录入，02、小程序 字符长度必须小于等于2", groups = {PsiCustomerCluesEntityValidGroup.class, CluesSourceValidGroup.class})
    @ApiModelProperty(value = "线索来源：01、录入，02、小程序")
    private String cluesSource;
    
    /**
     * 线索产生时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "线索产生时间")
    private Date cluesGenerationTime;
    
    /**
     * 线索状态：01、待预约，02、已预约，09、无效线索
     */
    @Size(min=0, max=2, message="线索状态：01、待预约，02、已预约，09、无效线索 字符长度必须小于等于2", groups = {PsiCustomerCluesEntityValidGroup.class, CluesStatusValidGroup.class})
    @ApiModelProperty(value = "线索状态：01、待预约，02、已预约，09、无效线索")
    private String cluesStatus;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCustomerCluesEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCustomerCluesEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCustomerCluesEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 最后更新人
     */
    @NotNull(message = "最后更新人 不能是Null", groups = {PsiCustomerCluesEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="最后更新人 数字精度必须符合(19,0)", groups = {PsiCustomerCluesEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "最后更新人")
    private Long updatedBy;
    
    /**
     * 最后更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "最后更新时间 不能是Null", groups = {PsiCustomerCluesEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "最后更新时间")
    private Date updatedDate;
    
    public PsiCustomerCluesEntity() {
    }
    
    public PsiCustomerCluesEntity(Long cluesId) {
        this.cluesId = cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }
    public Long getCluesId() {
        return this.cluesId;
    }
    

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }
    public String getCustomerIphone() {
        return this.customerIphone;
    }
    
    public void setCluesType(String cluesType) {
        this.cluesType = cluesType;
    }
    public String getCluesType() {
        return this.cluesType;
    }
    
    public void setCluesSource(String cluesSource) {
        this.cluesSource = cluesSource;
    }
    public String getCluesSource() {
        return this.cluesSource;
    }
    
    public void setCluesGenerationTime(Date cluesGenerationTime) {
        this.cluesGenerationTime = cluesGenerationTime;
    }
    public Date getCluesGenerationTime() {
        return this.cluesGenerationTime;
    }
    
    public void setCluesStatus(String cluesStatus) {
        this.cluesStatus = cluesStatus;
    }
    public String getCluesStatus() {
        return this.cluesStatus;
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
              (cluesId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                cluesId = RandomIDGennerator.get().generate();
    }

    public interface PsiCustomerCluesEntityValidGroup {}
    public interface CluesIdValidGroup {}
    public interface CustomerIdValidGroup {}
    public interface CustomerNameValidGroup {}
    public interface CustomerIphoneValidGroup {}
    public interface CluesTypeValidGroup {}
    public interface CluesSourceValidGroup {}
    public interface CluesStatusValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            CluesIdValidGroup.class
            , CustomerIdValidGroup.class
            , CustomerNameValidGroup.class
            , CustomerIphoneValidGroup.class
            , CluesTypeValidGroup.class
            , CluesSourceValidGroup.class
            , CluesStatusValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
