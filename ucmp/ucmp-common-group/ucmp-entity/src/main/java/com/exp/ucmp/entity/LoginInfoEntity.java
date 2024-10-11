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

@ApiModel(value = "LoginInfoEntity", description = "用户登录信息")
@GroupSequence({LoginInfoEntity.class, LoginInfoEntity.LoginInfoEntityValidGroup.class,LoginInfoEntity.LoginIdValidGroup.class,LoginInfoEntity.PartyIdValidGroup.class,LoginInfoEntity.LoginNameValidGroup.class,LoginInfoEntity.IsPrimaryValidGroup.class,LoginInfoEntity.IsPasswordValidGroup.class,LoginInfoEntity.ValidMarkValidGroup.class,LoginInfoEntity.CreatedByValidGroup.class,LoginInfoEntity.CreatedDateValidGroup.class,LoginInfoEntity.UpdatedByValidGroup.class,LoginInfoEntity.UpdatedDateValidGroup.class}) 
public class LoginInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 登录标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "登录标识 不能是Null", groups = {LoginInfoEntityValidGroup.class, LoginIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="登录标识 数字精度必须符合(19,0)", groups = {LoginInfoEntityValidGroup.class, LoginIdValidGroup.class})
    @ApiModelProperty(value = "登录标识")
    private Long loginId;
    
    
    /**
     * 当事人标识
     */
    @NotNull(message = "当事人标识 不能是Null", groups = {LoginInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="当事人标识 数字精度必须符合(19,0)", groups = {LoginInfoEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;
    
    /**
     * 登录用户名
     */
    @NotNull(message = "登录用户名 不能是Null", groups = {LoginInfoEntityValidGroup.class, LoginNameValidGroup.class})
    @Size(min=0, max=50, message="登录用户名 字符长度必须小于等于50", groups = {LoginInfoEntityValidGroup.class, LoginNameValidGroup.class})
    @ApiModelProperty(value = "登录用户名")
    private String loginName;
    
    /**
     * 是否主登录用户：01、主用户，09、非主用户；一个当事人只允许一个主登录用户
     */
    @NotNull(message = "是否主登录用户：01、主用户，09、非主用户；一个当事人只允许一个主登录用户 不能是Null", groups = {LoginInfoEntityValidGroup.class, IsPrimaryValidGroup.class})
    @Size(min=0, max=2, message="是否主登录用户：01、主用户，09、非主用户；一个当事人只允许一个主登录用户 字符长度必须小于等于2", groups = {LoginInfoEntityValidGroup.class, IsPrimaryValidGroup.class})
    @ApiModelProperty(value = "是否主登录用户：01、主用户，09、非主用户；一个当事人只允许一个主登录用户")
    private String isPrimary;
    
    /**
     * 是否需要密码：01、需密码登录，02、可免密码登录
     */
    @Size(min=0, max=2, message="是否需要密码：01、需密码登录，02、可免密码登录 字符长度必须小于等于2", groups = {LoginInfoEntityValidGroup.class, IsPasswordValidGroup.class})
    @ApiModelProperty(value = "是否需要密码：01、需密码登录，02、可免密码登录")
    private String isPassword;
    
    /**
     * 有效标记：00、已失效，01、有效，09、暂时失效
     */
    @NotNull(message = "有效标记：00、已失效，01、有效，09、暂时失效 不能是Null", groups = {LoginInfoEntityValidGroup.class, ValidMarkValidGroup.class})
    @Size(min=0, max=2, message="有效标记：00、已失效，01、有效，09、暂时失效 字符长度必须小于等于2", groups = {LoginInfoEntityValidGroup.class, ValidMarkValidGroup.class})
    @ApiModelProperty(value = "有效标记：00、已失效，01、有效，09、暂时失效")
    private String validMark;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {LoginInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {LoginInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {LoginInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {LoginInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {LoginInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {LoginInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public LoginInfoEntity() {
    }
    
    public LoginInfoEntity(Long loginId) {
        this.loginId = loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }
    public Long getLoginId() {
        return this.loginId;
    }
    

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getLoginName() {
        return this.loginName;
    }
    
    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
    }
    public String getIsPrimary() {
        return this.isPrimary;
    }
    
    public void setIsPassword(String isPassword) {
        this.isPassword = isPassword;
    }
    public String getIsPassword() {
        return this.isPassword;
    }
    
    public void setValidMark(String validMark) {
        this.validMark = validMark;
    }
    public String getValidMark() {
        return this.validMark;
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
              (loginId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                loginId = RandomIDGennerator.get().generate();
    }

    public interface LoginInfoEntityValidGroup {}
    public interface LoginIdValidGroup {}
    public interface PartyIdValidGroup {}
    public interface LoginNameValidGroup {}
    public interface IsPrimaryValidGroup {}
    public interface IsPasswordValidGroup {}
    public interface ValidMarkValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            LoginInfoEntity.LoginIdValidGroup.class
            , LoginInfoEntity.PartyIdValidGroup.class
            , LoginInfoEntity.LoginNameValidGroup.class
            , LoginInfoEntity.IsPrimaryValidGroup.class
            , LoginInfoEntity.IsPasswordValidGroup.class
            , LoginInfoEntity.ValidMarkValidGroup.class
            , LoginInfoEntity.CreatedByValidGroup.class
            , LoginInfoEntity.CreatedDateValidGroup.class
            , LoginInfoEntity.UpdatedByValidGroup.class
            , LoginInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
