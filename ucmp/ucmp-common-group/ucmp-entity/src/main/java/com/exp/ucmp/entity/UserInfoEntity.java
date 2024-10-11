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

@ApiModel(value = "UserInfoEntity", description = "用户信息")
@GroupSequence({UserInfoEntity.class, UserInfoEntity.UserInfoEntityValidGroup.class,UserInfoEntity.PartyIdValidGroup.class,UserInfoEntity.LoginPasswordValidGroup.class,UserInfoEntity.LoginSaltValidGroup.class,UserInfoEntity.IsLockValidGroup.class,UserInfoEntity.CreatedByValidGroup.class,UserInfoEntity.CreatedDateValidGroup.class,UserInfoEntity.UpdatedByValidGroup.class,UserInfoEntity.UpdatedDateValidGroup.class}) 
public class UserInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 当事人标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "当事人标识 不能是Null", groups = {UserInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="当事人标识 数字精度必须符合(19,0)", groups = {UserInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;
    
    
    /**
     * 登录密码
     */
    @NotNull(message = "登录密码 不能是Null", groups = {UserInfoEntityValidGroup.class, LoginPasswordValidGroup.class})
    @Size(min=0, max=50, message="登录密码 字符长度必须小于等于50", groups = {UserInfoEntityValidGroup.class, LoginPasswordValidGroup.class})
    @ApiModelProperty(value = "登录密码")
    private String loginPassword;
    
    /**
     * 登录密码加盐
     */
    @NotNull(message = "登录密码加盐 不能是Null", groups = {UserInfoEntityValidGroup.class, LoginSaltValidGroup.class})
    @Size(min=0, max=20, message="登录密码加盐 字符长度必须小于等于20", groups = {UserInfoEntityValidGroup.class, LoginSaltValidGroup.class})
    @ApiModelProperty(value = "登录密码加盐")
    private String loginSalt;
    
    /**
     * 用户是否锁定：01、未锁定；09、被锁定
     */
    @NotNull(message = "用户是否锁定：01、未锁定；09、被锁定 不能是Null", groups = {UserInfoEntityValidGroup.class, IsLockValidGroup.class})
    @Size(min=0, max=2, message="用户是否锁定：01、未锁定；09、被锁定 字符长度必须小于等于2", groups = {UserInfoEntityValidGroup.class, IsLockValidGroup.class})
    @ApiModelProperty(value = "用户是否锁定：01、未锁定；09、被锁定")
    private String isLock;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {UserInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {UserInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {UserInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {UserInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {UserInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {UserInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public UserInfoEntity() {
    }
    
    public UserInfoEntity(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
    public String getLoginPassword() {
        return this.loginPassword;
    }
    
    public void setLoginSalt(String loginSalt) {
        this.loginSalt = loginSalt;
    }
    public String getLoginSalt() {
        return this.loginSalt;
    }
    
    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }
    public String getIsLock() {
        return this.isLock;
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

    public interface UserInfoEntityValidGroup {}
    public interface PartyIdValidGroup {}
    public interface LoginPasswordValidGroup {}
    public interface LoginSaltValidGroup {}
    public interface IsLockValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            UserInfoEntity.PartyIdValidGroup.class
            , UserInfoEntity.LoginPasswordValidGroup.class
            , UserInfoEntity.LoginSaltValidGroup.class
            , UserInfoEntity.IsLockValidGroup.class
            , UserInfoEntity.CreatedByValidGroup.class
            , UserInfoEntity.CreatedDateValidGroup.class
            , UserInfoEntity.UpdatedByValidGroup.class
            , UserInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
