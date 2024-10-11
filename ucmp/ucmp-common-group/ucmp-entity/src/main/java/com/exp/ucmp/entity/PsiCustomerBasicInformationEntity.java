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

@ApiModel(value = "PsiCustomerBasicInformationEntity", description = "客户基本信息表")
@GroupSequence({PsiCustomerBasicInformationEntity.class, PsiCustomerBasicInformationEntity.PsiCustomerBasicInformationEntityValidGroup.class,PsiCustomerBasicInformationEntity.CustomerIdValidGroup.class,PsiCustomerBasicInformationEntity.UidValidGroup.class,PsiCustomerBasicInformationEntity.SidValidGroup.class,PsiCustomerBasicInformationEntity.CluesTypeValidGroup.class,PsiCustomerBasicInformationEntity.CluesSourceValidGroup.class,PsiCustomerBasicInformationEntity.CreationTimeValidGroup.class,PsiCustomerBasicInformationEntity.CluesOrderNoValidGroup.class,PsiCustomerBasicInformationEntity.CustomerNameValidGroup.class,PsiCustomerBasicInformationEntity.CustomerIphoneValidGroup.class,PsiCustomerBasicInformationEntity.CluesStatusValidGroup.class,PsiCustomerBasicInformationEntity.CreatedByValidGroup.class,PsiCustomerBasicInformationEntity.CreatedDateValidGroup.class,PsiCustomerBasicInformationEntity.UpdatedByValidGroup.class,PsiCustomerBasicInformationEntity.UpdatedDateValidGroup.class}) 
public class PsiCustomerBasicInformationEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 客户ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "客户ID 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CustomerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="客户ID 数字精度必须符合(19,0)", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CustomerIdValidGroup.class})
    @ApiModelProperty(value = "客户ID")
    private Long customerId;
    
    
    /**
     * UID
     */
    @NotNull(message = "UID 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, UidValidGroup.class})
    @Size(min=0, max=50, message="UID 字符长度必须小于等于50", groups = {PsiCustomerBasicInformationEntityValidGroup.class, UidValidGroup.class})
    @ApiModelProperty(value = "UID")
    private String uid;
    
    /**
     * IDM-ID
     */
    @Size(min=0, max=50, message="IDM-ID 字符长度必须小于等于50", groups = {PsiCustomerBasicInformationEntityValidGroup.class, SidValidGroup.class})
    @ApiModelProperty(value = "IDM-ID")
    private String sid;
    
    /**
     * 线索类型：01、置换线索，02、收购线索，03、销售线索
     */
    @NotNull(message = "线索类型：01、置换线索，02、收购线索，03、销售线索 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CluesTypeValidGroup.class})
    @Size(min=0, max=4, message="线索类型：01、置换线索，02、收购线索，03、销售线索 字符长度必须小于等于4", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CluesTypeValidGroup.class})
    @ApiModelProperty(value = "线索类型：01、置换线索，02、收购线索，03、销售线索")
    private String cluesType;
    
    /**
     * 线索来源：01、录入，02、小程序，03、高合APP，04、官网
     */
    @NotNull(message = "线索来源：01、录入，02、小程序，03、高合APP，04、官网 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CluesSourceValidGroup.class})
    @Size(min=0, max=4, message="线索来源：01、录入，02、小程序，03、高合APP，04、官网 字符长度必须小于等于4", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CluesSourceValidGroup.class})
    @ApiModelProperty(value = "线索来源：01、录入，02、小程序，03、高合APP，04、官网")
    private String cluesSource;
    
    /**
     * 产生时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "产生时间 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CreationTimeValidGroup.class})
    @ApiModelProperty(value = "产生时间")
    private Date creationTime;
    
    /**
     * 线索单号
     */
    @NotNull(message = "线索单号 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CluesOrderNoValidGroup.class})
    @Size(min=0, max=20, message="线索单号 字符长度必须小于等于20", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CluesOrderNoValidGroup.class})
    @ApiModelProperty(value = "线索单号")
    private String cluesOrderNo;
    
    /**
     * 姓名
     */
    @NotNull(message = "姓名 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CustomerNameValidGroup.class})
    @Size(min=0, max=20, message="姓名 字符长度必须小于等于20", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CustomerNameValidGroup.class})
    @ApiModelProperty(value = "姓名")
    private String customerName;
    
    /**
     * 手机号
     */
    @NotNull(message = "手机号 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CustomerIphoneValidGroup.class})
    @Size(min=0, max=20, message="手机号 字符长度必须小于等于20", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CustomerIphoneValidGroup.class})
    @ApiModelProperty(value = "手机号")
    private String customerIphone;
    
    /**
     * 线索状态：01、待预约，02、已预约，09、无效线索
     */
    @NotNull(message = "线索状态：01、待预约，02、已预约，09、无效线索 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CluesStatusValidGroup.class})
    @Size(min=0, max=4, message="线索状态：01、待预约，02、已预约，09、无效线索 字符长度必须小于等于4", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CluesStatusValidGroup.class})
    @ApiModelProperty(value = "线索状态：01、待预约，02、已预约，09、无效线索")
    private String cluesStatus;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCustomerBasicInformationEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCustomerBasicInformationEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PsiCustomerBasicInformationEntity() {
    }
    
    public PsiCustomerBasicInformationEntity(Long customerId) {
        this.customerId = customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    

    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getUid() {
        return this.uid;
    }
    
    public void setSid(String sid) {
        this.sid = sid;
    }
    public String getSid() {
        return this.sid;
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
    
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
    public Date getCreationTime() {
        return this.creationTime;
    }
    
    public void setCluesOrderNo(String cluesOrderNo) {
        this.cluesOrderNo = cluesOrderNo;
    }
    public String getCluesOrderNo() {
        return this.cluesOrderNo;
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
              (customerId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                customerId = RandomIDGennerator.get().generate();
    }

    public interface PsiCustomerBasicInformationEntityValidGroup {}
    public interface CustomerIdValidGroup {}
    public interface UidValidGroup {}
    public interface SidValidGroup {}
    public interface CluesTypeValidGroup {}
    public interface CluesSourceValidGroup {}
    public interface CreationTimeValidGroup {}
    public interface CluesOrderNoValidGroup {}
    public interface CustomerNameValidGroup {}
    public interface CustomerIphoneValidGroup {}
    public interface CluesStatusValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiCustomerBasicInformationEntity.CustomerIdValidGroup.class
            , PsiCustomerBasicInformationEntity.UidValidGroup.class
            , PsiCustomerBasicInformationEntity.SidValidGroup.class
            , PsiCustomerBasicInformationEntity.CluesTypeValidGroup.class
            , PsiCustomerBasicInformationEntity.CluesSourceValidGroup.class
            , PsiCustomerBasicInformationEntity.CreationTimeValidGroup.class
            , PsiCustomerBasicInformationEntity.CluesOrderNoValidGroup.class
            , PsiCustomerBasicInformationEntity.CustomerNameValidGroup.class
            , PsiCustomerBasicInformationEntity.CustomerIphoneValidGroup.class
            , PsiCustomerBasicInformationEntity.CluesStatusValidGroup.class
            , PsiCustomerBasicInformationEntity.CreatedByValidGroup.class
            , PsiCustomerBasicInformationEntity.CreatedDateValidGroup.class
            , PsiCustomerBasicInformationEntity.UpdatedByValidGroup.class
            , PsiCustomerBasicInformationEntity.UpdatedDateValidGroup.class
        };
    }
}
