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

@ApiModel(value = "SysOrganizationStaffInfoEntity", description = "组织员工信息表")
@GroupSequence({SysOrganizationStaffInfoEntity.class, SysOrganizationStaffInfoEntity.SysOrganizationStaffInfoEntityValidGroup.class,SysOrganizationStaffInfoEntity.RspUserInfoIdValidGroup.class,SysOrganizationStaffInfoEntity.HhrStatusValidGroup.class,SysOrganizationStaffInfoEntity.HhrCompanyNameZhValidGroup.class,SysOrganizationStaffInfoEntity.IdmAccountnameValidGroup.class,SysOrganizationStaffInfoEntity.IdmEmailValidGroup.class,SysOrganizationStaffInfoEntity.HhrPhoneNumValidGroup.class,SysOrganizationStaffInfoEntity.HhrRankCodeValidGroup.class,SysOrganizationStaffInfoEntity.HhrImgValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgDeptAttr04ValidGroup.class,SysOrganizationStaffInfoEntity.HhrDeptCodeValidGroup.class,SysOrganizationStaffInfoEntity.HhrDeptNameValidGroup.class,SysOrganizationStaffInfoEntity.HhrEmpidValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgDeptAttr02ValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgDeptAttr03ValidGroup.class,SysOrganizationStaffInfoEntity.HhrLocationValidGroup.class,SysOrganizationStaffInfoEntity.HhrPositionCodeValidGroup.class,SysOrganizationStaffInfoEntity.VersionValidGroup.class,SysOrganizationStaffInfoEntity.HhrDirectEmpidValidGroup.class,SysOrganizationStaffInfoEntity.HhrCompanyCodeValidGroup.class,SysOrganizationStaffInfoEntity.HhrEmpRcdValidGroup.class,SysOrganizationStaffInfoEntity.HhrCompanyNameEnValidGroup.class,SysOrganizationStaffInfoEntity.HhrQyWeixinValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgCompanyAttr08ValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgCompanyAttr05ValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgPosnAttr06ValidGroup.class,SysOrganizationStaffInfoEntity.HhrCompanyStatusValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgCompanyAttr04ValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgPosnAttr05ValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgCompanyAttr07ValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgPosnAttr04ValidGroup.class,SysOrganizationStaffInfoEntity.HhrOtherNameValidGroup.class,SysOrganizationStaffInfoEntity.HhrEmpClassValidGroup.class,SysOrganizationStaffInfoEntity.HhrPosnLocationValidGroup.class,SysOrganizationStaffInfoEntity.HhrGenderValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgCompanyAttr01ValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgPosnAttr02ValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgCompanyAttr03ValidGroup.class,SysOrganizationStaffInfoEntity.HhrOrgCompanyAttr02ValidGroup.class,SysOrganizationStaffInfoEntity.HhrNameValidGroup.class,SysOrganizationStaffInfoEntity.IsEnableValidGroup.class,SysOrganizationStaffInfoEntity.IsDeleteValidGroup.class,SysOrganizationStaffInfoEntity.CreatedByValidGroup.class,SysOrganizationStaffInfoEntity.CreatedDateValidGroup.class,SysOrganizationStaffInfoEntity.UpdatedByValidGroup.class,SysOrganizationStaffInfoEntity.UpdatedDateValidGroup.class}) 
public class SysOrganizationStaffInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键标识 不能是Null", groups = {SysOrganizationStaffInfoEntityValidGroup.class, RspUserInfoIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键标识 数字精度必须符合(19,0)", groups = {SysOrganizationStaffInfoEntityValidGroup.class, RspUserInfoIdValidGroup.class})
    @ApiModelProperty(value = "主键标识")
    private Long rspUserInfoId;
    
    
    /**
     * 状态 Y:未离职,N:已离职
     */
    @Size(min=0, max=10, message="状态 Y:未离职,N:已离职 字符长度必须小于等于10", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrStatusValidGroup.class})
    @ApiModelProperty(value = "状态 Y:未离职,N:已离职")
    private String hhrStatus;
    
    /**
     * 公司中文名
     */
    @Size(min=0, max=50, message="公司中文名 字符长度必须小于等于50", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrCompanyNameZhValidGroup.class})
    @ApiModelProperty(value = "公司中文名")
    private String hhrCompanyNameZh;
    
    /**
     * 最后修改日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后修改日期")
    private Date lastUpdateDate;
    
    /**
     * 账户名称
     */
    @Size(min=0, max=100, message="账户名称 字符长度必须小于等于100", groups = {SysOrganizationStaffInfoEntityValidGroup.class, IdmAccountnameValidGroup.class})
    @ApiModelProperty(value = "账户名称")
    private String idmAccountname;
    
    /**
     * 邮箱
     */
    @Size(min=0, max=100, message="邮箱 字符长度必须小于等于100", groups = {SysOrganizationStaffInfoEntityValidGroup.class, IdmEmailValidGroup.class})
    @ApiModelProperty(value = "邮箱")
    private String idmEmail;
    
    /**
     * 手机号
     */
    @Size(min=0, max=50, message="手机号 字符长度必须小于等于50", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrPhoneNumValidGroup.class})
    @ApiModelProperty(value = "手机号")
    private String hhrPhoneNum;
    
    /**
     * 
     */
    @Size(min=0, max=20, message=" 字符长度必须小于等于20", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrRankCodeValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrRankCode;
    
    /**
     * 
     */
    @Size(min=0, max=50, message=" 字符长度必须小于等于50", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrImgValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrImg;
    
    /**
     * 
     */
    @Size(min=0, max=80, message=" 字符长度必须小于等于80", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgDeptAttr04ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgDeptAttr04;
    
    /**
     * 账号有效期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "账号有效期")
    private Date hhrEndDate;
    
    /**
     * 部门编码
     */
    @Size(min=0, max=20, message="部门编码 字符长度必须小于等于20", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrDeptCodeValidGroup.class})
    @ApiModelProperty(value = "部门编码")
    private String hhrDeptCode;
    
    /**
     * 部门名称
     */
    @Size(min=0, max=30, message="部门名称 字符长度必须小于等于30", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrDeptNameValidGroup.class})
    @ApiModelProperty(value = "部门名称")
    private String hhrDeptName;
    
    /**
     * 人员编号
     */
    @Size(min=0, max=20, message="人员编号 字符长度必须小于等于20", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrEmpidValidGroup.class})
    @ApiModelProperty(value = "人员编号")
    private String hhrEmpid;
    
    /**
     * 成本中心编码
     */
    @Size(min=0, max=40, message="成本中心编码 字符长度必须小于等于40", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgDeptAttr02ValidGroup.class})
    @ApiModelProperty(value = "成本中心编码")
    private String hhrOrgDeptAttr02;
    
    /**
     * 
     */
    @Size(min=0, max=40, message=" 字符长度必须小于等于40", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgDeptAttr03ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgDeptAttr03;
    
    /**
     * 工作地点
     */
    @Size(min=0, max=30, message="工作地点 字符长度必须小于等于30", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrLocationValidGroup.class})
    @ApiModelProperty(value = "工作地点")
    private String hhrLocation;
    
    /**
     * 职位编码
     */
    @Size(min=0, max=20, message="职位编码 字符长度必须小于等于20", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrPositionCodeValidGroup.class})
    @ApiModelProperty(value = "职位编码")
    private String hhrPositionCode;
    
    /**
     * 版本号
     */
    @Digits(integer=10, fraction=0, message="版本号 数字精度必须符合(10,0)", groups = {SysOrganizationStaffInfoEntityValidGroup.class, VersionValidGroup.class})
    @ApiModelProperty(value = "版本号")
    private Integer version;
    
    /**
     * 直接上级
     */
    @Size(min=0, max=30, message="直接上级 字符长度必须小于等于30", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrDirectEmpidValidGroup.class})
    @ApiModelProperty(value = "直接上级")
    private String hhrDirectEmpid;
    
    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "")
    private Date hhrCompanyEffeDate;
    
    /**
     * 公司编码
     */
    @Size(min=0, max=20, message="公司编码 字符长度必须小于等于20", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrCompanyCodeValidGroup.class})
    @ApiModelProperty(value = "公司编码")
    private String hhrCompanyCode;
    
    /**
     * 任职记录号
     */
    @Size(min=0, max=20, message="任职记录号 字符长度必须小于等于20", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrEmpRcdValidGroup.class})
    @ApiModelProperty(value = "任职记录号")
    private String hhrEmpRcd;
    
    /**
     * 公司英文名
     */
    @Size(min=0, max=80, message="公司英文名 字符长度必须小于等于80", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrCompanyNameEnValidGroup.class})
    @ApiModelProperty(value = "公司英文名")
    private String hhrCompanyNameEn;
    
    /**
     * 企业微信
     */
    @Size(min=0, max=50, message="企业微信 字符长度必须小于等于50", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrQyWeixinValidGroup.class})
    @ApiModelProperty(value = "企业微信")
    private String hhrQyWeixin;
    
    /**
     * 
     */
    @Size(min=0, max=40, message=" 字符长度必须小于等于40", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgCompanyAttr08ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgCompanyAttr08;
    
    /**
     * 
     */
    @Size(min=0, max=40, message=" 字符长度必须小于等于40", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgCompanyAttr05ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgCompanyAttr05;
    
    /**
     * 
     */
    @Size(min=0, max=30, message=" 字符长度必须小于等于30", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgPosnAttr06ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgPosnAttr06;
    
    /**
     * 
     */
    @Size(min=0, max=10, message=" 字符长度必须小于等于10", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrCompanyStatusValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrCompanyStatus;
    
    /**
     * 
     */
    @Size(min=0, max=30, message=" 字符长度必须小于等于30", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgCompanyAttr04ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgCompanyAttr04;
    
    /**
     * 
     */
    @Size(min=0, max=10, message=" 字符长度必须小于等于10", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgPosnAttr05ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgPosnAttr05;
    
    /**
     * 
     */
    @Size(min=0, max=20, message=" 字符长度必须小于等于20", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgCompanyAttr07ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgCompanyAttr07;
    
    /**
     * 
     */
    @Size(min=0, max=30, message=" 字符长度必须小于等于30", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgPosnAttr04ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgPosnAttr04;
    
    /**
     * 英文名
     */
    @Size(min=0, max=40, message="英文名 字符长度必须小于等于40", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOtherNameValidGroup.class})
    @ApiModelProperty(value = "英文名")
    private String hhrOtherName;
    
    /**
     * 人员类别
     */
    @Size(min=0, max=30, message="人员类别 字符长度必须小于等于30", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrEmpClassValidGroup.class})
    @ApiModelProperty(value = "人员类别")
    private String hhrEmpClass;
    
    /**
     * 
     */
    @Size(min=0, max=20, message=" 字符长度必须小于等于20", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrPosnLocationValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrPosnLocation;
    
    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "")
    private Date hhrEffeDate;
    
    /**
     * 性别:M:男，F:女
     */
    @Size(min=0, max=5, message="性别:M:男，F:女 字符长度必须小于等于5", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrGenderValidGroup.class})
    @ApiModelProperty(value = "性别:M:男，F:女")
    private String hhrGender;
    
    /**
     * 
     */
    @Size(min=0, max=30, message=" 字符长度必须小于等于30", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgCompanyAttr01ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgCompanyAttr01;
    
    /**
     * 
     */
    @Size(min=0, max=30, message=" 字符长度必须小于等于30", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgPosnAttr02ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgPosnAttr02;
    
    /**
     * 
     */
    @Size(min=0, max=30, message=" 字符长度必须小于等于30", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgCompanyAttr03ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgCompanyAttr03;
    
    /**
     * 
     */
    @Size(min=0, max=30, message=" 字符长度必须小于等于30", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrOrgCompanyAttr02ValidGroup.class})
    @ApiModelProperty(value = "")
    private String hhrOrgCompanyAttr02;
    
    /**
     * 姓名
     */
    @Size(min=0, max=20, message="姓名 字符长度必须小于等于20", groups = {SysOrganizationStaffInfoEntityValidGroup.class, HhrNameValidGroup.class})
    @ApiModelProperty(value = "姓名")
    private String hhrName;
    
    /**
     * 是否可用00、禁用，01、启用
     */
    @Size(min=0, max=2, message="是否可用00、禁用，01、启用 字符长度必须小于等于2", groups = {SysOrganizationStaffInfoEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、禁用，01、启用")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {SysOrganizationStaffInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {SysOrganizationStaffInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysOrganizationStaffInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysOrganizationStaffInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysOrganizationStaffInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysOrganizationStaffInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysOrganizationStaffInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysOrganizationStaffInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysOrganizationStaffInfoEntity() {
    }
    
    public SysOrganizationStaffInfoEntity(Long rspUserInfoId) {
        this.rspUserInfoId = rspUserInfoId;
    }

    public void setRspUserInfoId(Long rspUserInfoId) {
        this.rspUserInfoId = rspUserInfoId;
    }
    public Long getRspUserInfoId() {
        return this.rspUserInfoId;
    }
    

    public void setHhrStatus(String hhrStatus) {
        this.hhrStatus = hhrStatus;
    }
    public String getHhrStatus() {
        return this.hhrStatus;
    }
    
    public void setHhrCompanyNameZh(String hhrCompanyNameZh) {
        this.hhrCompanyNameZh = hhrCompanyNameZh;
    }
    public String getHhrCompanyNameZh() {
        return this.hhrCompanyNameZh;
    }
    
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    public Date getLastUpdateDate() {
        return this.lastUpdateDate;
    }
    
    public void setIdmAccountname(String idmAccountname) {
        this.idmAccountname = idmAccountname;
    }
    public String getIdmAccountname() {
        return this.idmAccountname;
    }
    
    public void setIdmEmail(String idmEmail) {
        this.idmEmail = idmEmail;
    }
    public String getIdmEmail() {
        return this.idmEmail;
    }
    
    public void setHhrPhoneNum(String hhrPhoneNum) {
        this.hhrPhoneNum = hhrPhoneNum;
    }
    public String getHhrPhoneNum() {
        return this.hhrPhoneNum;
    }
    
    public void setHhrRankCode(String hhrRankCode) {
        this.hhrRankCode = hhrRankCode;
    }
    public String getHhrRankCode() {
        return this.hhrRankCode;
    }
    
    public void setHhrImg(String hhrImg) {
        this.hhrImg = hhrImg;
    }
    public String getHhrImg() {
        return this.hhrImg;
    }
    
    public void setHhrOrgDeptAttr04(String hhrOrgDeptAttr04) {
        this.hhrOrgDeptAttr04 = hhrOrgDeptAttr04;
    }
    public String getHhrOrgDeptAttr04() {
        return this.hhrOrgDeptAttr04;
    }
    
    public void setHhrEndDate(Date hhrEndDate) {
        this.hhrEndDate = hhrEndDate;
    }
    public Date getHhrEndDate() {
        return this.hhrEndDate;
    }
    
    public void setHhrDeptCode(String hhrDeptCode) {
        this.hhrDeptCode = hhrDeptCode;
    }
    public String getHhrDeptCode() {
        return this.hhrDeptCode;
    }
    
    public void setHhrDeptName(String hhrDeptName) {
        this.hhrDeptName = hhrDeptName;
    }
    public String getHhrDeptName() {
        return this.hhrDeptName;
    }
    
    public void setHhrEmpid(String hhrEmpid) {
        this.hhrEmpid = hhrEmpid;
    }
    public String getHhrEmpid() {
        return this.hhrEmpid;
    }
    
    public void setHhrOrgDeptAttr02(String hhrOrgDeptAttr02) {
        this.hhrOrgDeptAttr02 = hhrOrgDeptAttr02;
    }
    public String getHhrOrgDeptAttr02() {
        return this.hhrOrgDeptAttr02;
    }
    
    public void setHhrOrgDeptAttr03(String hhrOrgDeptAttr03) {
        this.hhrOrgDeptAttr03 = hhrOrgDeptAttr03;
    }
    public String getHhrOrgDeptAttr03() {
        return this.hhrOrgDeptAttr03;
    }
    
    public void setHhrLocation(String hhrLocation) {
        this.hhrLocation = hhrLocation;
    }
    public String getHhrLocation() {
        return this.hhrLocation;
    }
    
    public void setHhrPositionCode(String hhrPositionCode) {
        this.hhrPositionCode = hhrPositionCode;
    }
    public String getHhrPositionCode() {
        return this.hhrPositionCode;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    public Integer getVersion() {
        return this.version;
    }
    
    public void setHhrDirectEmpid(String hhrDirectEmpid) {
        this.hhrDirectEmpid = hhrDirectEmpid;
    }
    public String getHhrDirectEmpid() {
        return this.hhrDirectEmpid;
    }
    
    public void setHhrCompanyEffeDate(Date hhrCompanyEffeDate) {
        this.hhrCompanyEffeDate = hhrCompanyEffeDate;
    }
    public Date getHhrCompanyEffeDate() {
        return this.hhrCompanyEffeDate;
    }
    
    public void setHhrCompanyCode(String hhrCompanyCode) {
        this.hhrCompanyCode = hhrCompanyCode;
    }
    public String getHhrCompanyCode() {
        return this.hhrCompanyCode;
    }
    
    public void setHhrEmpRcd(String hhrEmpRcd) {
        this.hhrEmpRcd = hhrEmpRcd;
    }
    public String getHhrEmpRcd() {
        return this.hhrEmpRcd;
    }
    
    public void setHhrCompanyNameEn(String hhrCompanyNameEn) {
        this.hhrCompanyNameEn = hhrCompanyNameEn;
    }
    public String getHhrCompanyNameEn() {
        return this.hhrCompanyNameEn;
    }
    
    public void setHhrQyWeixin(String hhrQyWeixin) {
        this.hhrQyWeixin = hhrQyWeixin;
    }
    public String getHhrQyWeixin() {
        return this.hhrQyWeixin;
    }
    
    public void setHhrOrgCompanyAttr08(String hhrOrgCompanyAttr08) {
        this.hhrOrgCompanyAttr08 = hhrOrgCompanyAttr08;
    }
    public String getHhrOrgCompanyAttr08() {
        return this.hhrOrgCompanyAttr08;
    }
    
    public void setHhrOrgCompanyAttr05(String hhrOrgCompanyAttr05) {
        this.hhrOrgCompanyAttr05 = hhrOrgCompanyAttr05;
    }
    public String getHhrOrgCompanyAttr05() {
        return this.hhrOrgCompanyAttr05;
    }
    
    public void setHhrOrgPosnAttr06(String hhrOrgPosnAttr06) {
        this.hhrOrgPosnAttr06 = hhrOrgPosnAttr06;
    }
    public String getHhrOrgPosnAttr06() {
        return this.hhrOrgPosnAttr06;
    }
    
    public void setHhrCompanyStatus(String hhrCompanyStatus) {
        this.hhrCompanyStatus = hhrCompanyStatus;
    }
    public String getHhrCompanyStatus() {
        return this.hhrCompanyStatus;
    }
    
    public void setHhrOrgCompanyAttr04(String hhrOrgCompanyAttr04) {
        this.hhrOrgCompanyAttr04 = hhrOrgCompanyAttr04;
    }
    public String getHhrOrgCompanyAttr04() {
        return this.hhrOrgCompanyAttr04;
    }
    
    public void setHhrOrgPosnAttr05(String hhrOrgPosnAttr05) {
        this.hhrOrgPosnAttr05 = hhrOrgPosnAttr05;
    }
    public String getHhrOrgPosnAttr05() {
        return this.hhrOrgPosnAttr05;
    }
    
    public void setHhrOrgCompanyAttr07(String hhrOrgCompanyAttr07) {
        this.hhrOrgCompanyAttr07 = hhrOrgCompanyAttr07;
    }
    public String getHhrOrgCompanyAttr07() {
        return this.hhrOrgCompanyAttr07;
    }
    
    public void setHhrOrgPosnAttr04(String hhrOrgPosnAttr04) {
        this.hhrOrgPosnAttr04 = hhrOrgPosnAttr04;
    }
    public String getHhrOrgPosnAttr04() {
        return this.hhrOrgPosnAttr04;
    }
    
    public void setHhrOtherName(String hhrOtherName) {
        this.hhrOtherName = hhrOtherName;
    }
    public String getHhrOtherName() {
        return this.hhrOtherName;
    }
    
    public void setHhrEmpClass(String hhrEmpClass) {
        this.hhrEmpClass = hhrEmpClass;
    }
    public String getHhrEmpClass() {
        return this.hhrEmpClass;
    }
    
    public void setHhrPosnLocation(String hhrPosnLocation) {
        this.hhrPosnLocation = hhrPosnLocation;
    }
    public String getHhrPosnLocation() {
        return this.hhrPosnLocation;
    }
    
    public void setHhrEffeDate(Date hhrEffeDate) {
        this.hhrEffeDate = hhrEffeDate;
    }
    public Date getHhrEffeDate() {
        return this.hhrEffeDate;
    }
    
    public void setHhrGender(String hhrGender) {
        this.hhrGender = hhrGender;
    }
    public String getHhrGender() {
        return this.hhrGender;
    }
    
    public void setHhrOrgCompanyAttr01(String hhrOrgCompanyAttr01) {
        this.hhrOrgCompanyAttr01 = hhrOrgCompanyAttr01;
    }
    public String getHhrOrgCompanyAttr01() {
        return this.hhrOrgCompanyAttr01;
    }
    
    public void setHhrOrgPosnAttr02(String hhrOrgPosnAttr02) {
        this.hhrOrgPosnAttr02 = hhrOrgPosnAttr02;
    }
    public String getHhrOrgPosnAttr02() {
        return this.hhrOrgPosnAttr02;
    }
    
    public void setHhrOrgCompanyAttr03(String hhrOrgCompanyAttr03) {
        this.hhrOrgCompanyAttr03 = hhrOrgCompanyAttr03;
    }
    public String getHhrOrgCompanyAttr03() {
        return this.hhrOrgCompanyAttr03;
    }
    
    public void setHhrOrgCompanyAttr02(String hhrOrgCompanyAttr02) {
        this.hhrOrgCompanyAttr02 = hhrOrgCompanyAttr02;
    }
    public String getHhrOrgCompanyAttr02() {
        return this.hhrOrgCompanyAttr02;
    }
    
    public void setHhrName(String hhrName) {
        this.hhrName = hhrName;
    }
    public String getHhrName() {
        return this.hhrName;
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
              (rspUserInfoId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                rspUserInfoId = RandomIDGennerator.get().generate();
    }

    public interface SysOrganizationStaffInfoEntityValidGroup {}
    public interface RspUserInfoIdValidGroup {}
    public interface HhrStatusValidGroup {}
    public interface HhrCompanyNameZhValidGroup {}
    public interface IdmAccountnameValidGroup {}
    public interface IdmEmailValidGroup {}
    public interface HhrPhoneNumValidGroup {}
    public interface HhrRankCodeValidGroup {}
    public interface HhrImgValidGroup {}
    public interface HhrOrgDeptAttr04ValidGroup {}
    public interface HhrDeptCodeValidGroup {}
    public interface HhrDeptNameValidGroup {}
    public interface HhrEmpidValidGroup {}
    public interface HhrOrgDeptAttr02ValidGroup {}
    public interface HhrOrgDeptAttr03ValidGroup {}
    public interface HhrLocationValidGroup {}
    public interface HhrPositionCodeValidGroup {}
    public interface VersionValidGroup {}
    public interface HhrDirectEmpidValidGroup {}
    public interface HhrCompanyCodeValidGroup {}
    public interface HhrEmpRcdValidGroup {}
    public interface HhrCompanyNameEnValidGroup {}
    public interface HhrQyWeixinValidGroup {}
    public interface HhrOrgCompanyAttr08ValidGroup {}
    public interface HhrOrgCompanyAttr05ValidGroup {}
    public interface HhrOrgPosnAttr06ValidGroup {}
    public interface HhrCompanyStatusValidGroup {}
    public interface HhrOrgCompanyAttr04ValidGroup {}
    public interface HhrOrgPosnAttr05ValidGroup {}
    public interface HhrOrgCompanyAttr07ValidGroup {}
    public interface HhrOrgPosnAttr04ValidGroup {}
    public interface HhrOtherNameValidGroup {}
    public interface HhrEmpClassValidGroup {}
    public interface HhrPosnLocationValidGroup {}
    public interface HhrGenderValidGroup {}
    public interface HhrOrgCompanyAttr01ValidGroup {}
    public interface HhrOrgPosnAttr02ValidGroup {}
    public interface HhrOrgCompanyAttr03ValidGroup {}
    public interface HhrOrgCompanyAttr02ValidGroup {}
    public interface HhrNameValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RspUserInfoIdValidGroup.class
            , HhrStatusValidGroup.class
            , HhrCompanyNameZhValidGroup.class
            , IdmAccountnameValidGroup.class
            , IdmEmailValidGroup.class
            , HhrPhoneNumValidGroup.class
            , HhrRankCodeValidGroup.class
            , HhrImgValidGroup.class
            , HhrOrgDeptAttr04ValidGroup.class
            , HhrDeptCodeValidGroup.class
            , HhrDeptNameValidGroup.class
            , HhrEmpidValidGroup.class
            , HhrOrgDeptAttr02ValidGroup.class
            , HhrOrgDeptAttr03ValidGroup.class
            , HhrLocationValidGroup.class
            , HhrPositionCodeValidGroup.class
            , VersionValidGroup.class
            , HhrDirectEmpidValidGroup.class
            , HhrCompanyCodeValidGroup.class
            , HhrEmpRcdValidGroup.class
            , HhrCompanyNameEnValidGroup.class
            , HhrQyWeixinValidGroup.class
            , HhrOrgCompanyAttr08ValidGroup.class
            , HhrOrgCompanyAttr05ValidGroup.class
            , HhrOrgPosnAttr06ValidGroup.class
            , HhrCompanyStatusValidGroup.class
            , HhrOrgCompanyAttr04ValidGroup.class
            , HhrOrgPosnAttr05ValidGroup.class
            , HhrOrgCompanyAttr07ValidGroup.class
            , HhrOrgPosnAttr04ValidGroup.class
            , HhrOtherNameValidGroup.class
            , HhrEmpClassValidGroup.class
            , HhrPosnLocationValidGroup.class
            , HhrGenderValidGroup.class
            , HhrOrgCompanyAttr01ValidGroup.class
            , HhrOrgPosnAttr02ValidGroup.class
            , HhrOrgCompanyAttr03ValidGroup.class
            , HhrOrgCompanyAttr02ValidGroup.class
            , HhrNameValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
