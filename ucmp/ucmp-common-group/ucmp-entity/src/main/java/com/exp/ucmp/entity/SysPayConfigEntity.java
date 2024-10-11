package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "SysPayConfigEntity", description = "支付主体信息配置")
@GroupSequence({SysPayConfigEntity.class, SysPayConfigEntity.SysPayConfigEntityValidGroup.class,SysPayConfigEntity.RevertBodyValidGroup.class,SysPayConfigEntity.AppIdValidGroup.class,SysPayConfigEntity.SecretValidGroup.class,SysPayConfigEntity.AppCodeValidGroup.class,SysPayConfigEntity.MerchantNumberValidGroup.class,SysPayConfigEntity.CreatedByValidGroup.class,SysPayConfigEntity.CreatedDateValidGroup.class,SysPayConfigEntity.UpdatedByValidGroup.class,SysPayConfigEntity.UpdatedDateValidGroup.class,SysPayConfigEntity.IsEnableValidGroup.class,SysPayConfigEntity.IsDeleteValidGroup.class}) 
public class SysPayConfigEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 车辆主体code
     */
    @NotNull(message = "车辆主体code 不能是Null", groups = {SysPayConfigEntityValidGroup.class, RevertBodyValidGroup.class})
    @Size(min=0, max=10, message="车辆主体code 字符长度必须小于等于10", groups = {SysPayConfigEntityValidGroup.class, RevertBodyValidGroup.class})
    @ApiModelProperty(value = "车辆主体code")
    private String revertBody;
    
    
    /**
     * 主体对应的appId
     */
    @NotNull(message = "主体对应的appId 不能是Null", groups = {SysPayConfigEntityValidGroup.class, AppIdValidGroup.class})
    @Size(min=0, max=20, message="主体对应的appId 字符长度必须小于等于20", groups = {SysPayConfigEntityValidGroup.class, AppIdValidGroup.class})
    @ApiModelProperty(value = "主体对应的appId")
    private String appId;
    
    /**
     * 密钥
     */
    @NotNull(message = "密钥 不能是Null", groups = {SysPayConfigEntityValidGroup.class, SecretValidGroup.class})
    @Size(min=0, max=50, message="密钥 字符长度必须小于等于50", groups = {SysPayConfigEntityValidGroup.class, SecretValidGroup.class})
    @ApiModelProperty(value = "密钥")
    private String secret;
    
    /**
     * 前缀代码
     */
    @NotNull(message = "前缀代码 不能是Null", groups = {SysPayConfigEntityValidGroup.class, AppCodeValidGroup.class})
    @Size(min=0, max=50, message="前缀代码 字符长度必须小于等于50", groups = {SysPayConfigEntityValidGroup.class, AppCodeValidGroup.class})
    @ApiModelProperty(value = "前缀代码")
    private String appCode;
    
    /**
     * 商户号
     */
    @NotNull(message = "商户号 不能是Null", groups = {SysPayConfigEntityValidGroup.class, MerchantNumberValidGroup.class})
    @Size(min=0, max=20, message="商户号 字符长度必须小于等于20", groups = {SysPayConfigEntityValidGroup.class, MerchantNumberValidGroup.class})
    @ApiModelProperty(value = "商户号")
    private String merchantNumber;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysPayConfigEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysPayConfigEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysPayConfigEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysPayConfigEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysPayConfigEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysPayConfigEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @NotNull(message = "是否可用00、无效，01、有效 不能是Null", groups = {SysPayConfigEntityValidGroup.class, IsEnableValidGroup.class})
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {SysPayConfigEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {SysPayConfigEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {SysPayConfigEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public SysPayConfigEntity() {
    }
    
    public SysPayConfigEntity(String revertBody) {
        this.revertBody = revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }
    public String getRevertBody() {
        return this.revertBody;
    }
    

    public void setAppId(String appId) {
        this.appId = appId;
    }
    public String getAppId() {
        return this.appId;
    }
    
    public void setSecret(String secret) {
        this.secret = secret;
    }
    public String getSecret() {
        return this.secret;
    }
    
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }
    public String getAppCode() {
        return this.appCode;
    }
    
    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber;
    }
    public String getMerchantNumber() {
        return this.merchantNumber;
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
    
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public String getIsEnable() {
        return this.isEnable;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (revertBody == null || revertBody.trim().length() == 0)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                revertBody = null;
    }

    public interface SysPayConfigEntityValidGroup {}
    public interface RevertBodyValidGroup {}
    public interface AppIdValidGroup {}
    public interface SecretValidGroup {}
    public interface AppCodeValidGroup {}
    public interface MerchantNumberValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            SysPayConfigEntity.RevertBodyValidGroup.class
            , SysPayConfigEntity.AppIdValidGroup.class
            , SysPayConfigEntity.SecretValidGroup.class
            , SysPayConfigEntity.AppCodeValidGroup.class
            , SysPayConfigEntity.MerchantNumberValidGroup.class
            , SysPayConfigEntity.CreatedByValidGroup.class
            , SysPayConfigEntity.CreatedDateValidGroup.class
            , SysPayConfigEntity.UpdatedByValidGroup.class
            , SysPayConfigEntity.UpdatedDateValidGroup.class
            , SysPayConfigEntity.IsEnableValidGroup.class
            , SysPayConfigEntity.IsDeleteValidGroup.class
        };
    }
}
