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

@ApiModel(value = "SysPartnerDetailsEntity", description = "合作商详情表")
@GroupSequence({SysPartnerDetailsEntity.class, SysPartnerDetailsEntity.SysPartnerDetailsEntityValidGroup.class,SysPartnerDetailsEntity.PartnerIdValidGroup.class,SysPartnerDetailsEntity.PartnerCodeValidGroup.class,SysPartnerDetailsEntity.PartnerChargePersonValidGroup.class,SysPartnerDetailsEntity.ChargePersonIphoneValidGroup.class,SysPartnerDetailsEntity.PartnerNameValidGroup.class,SysPartnerDetailsEntity.PartnerAbbreviationValidGroup.class,SysPartnerDetailsEntity.PartnerJoinRoleValidGroup.class,SysPartnerDetailsEntity.PartnerStatusValidGroup.class,SysPartnerDetailsEntity.PartnerAddressValidGroup.class,SysPartnerDetailsEntity.PartnerOrderValidGroup.class,SysPartnerDetailsEntity.CreatedByValidGroup.class,SysPartnerDetailsEntity.CreatedDateValidGroup.class,SysPartnerDetailsEntity.UpdatedByValidGroup.class,SysPartnerDetailsEntity.UpdatedDateValidGroup.class})
public class SysPartnerDetailsEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键/合作商标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键/合作商标识 不能是Null", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键/合作商标识 数字精度必须符合(19,0)", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerIdValidGroup.class})
    @ApiModelProperty(value = "主键/合作商标识")
    private Long partnerId;


    /**
     * 合作商编码
     */
    @Size(min=0, max=20, message="合作商编码 字符长度必须小于等于20", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerCodeValidGroup.class})
    @ApiModelProperty(value = "合作商编码")
    private String partnerCode;

    /**
     * 负责人
     */
    @Size(min=0, max=20, message="负责人 字符长度必须小于等于20", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerChargePersonValidGroup.class})
    @ApiModelProperty(value = "负责人")
    private String partnerChargePerson;

    /**
     * 负责人手机号
     */
    @Size(min=0, max=100, message="负责人手机号 字符长度必须小于等于100", groups = {SysPartnerDetailsEntityValidGroup.class, ChargePersonIphoneValidGroup.class})
    @ApiModelProperty(value = "负责人手机号")
    private String chargePersonIphone;

    /**
     * 合作商名称
     */
    @NotNull(message = "合作商名称 不能是Null", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerNameValidGroup.class})
    @Size(min=0, max=100, message="合作商名称 字符长度必须小于等于100", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerNameValidGroup.class})
    @ApiModelProperty(value = "合作商名称")
    private String partnerName;

    /**
     * 合作商简称
     */
    @Size(min=0, max=50, message="合作商简称 字符长度必须小于等于50", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerAbbreviationValidGroup.class})
    @ApiModelProperty(value = "合作商简称")
    private String partnerAbbreviation;

    /**
     * 参与权限： 0100置换 0200转售
     */
    @Size(min=0, max=4, message="参与权限： 0100置换 0200转售 字符长度必须小于等于4", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerJoinRoleValidGroup.class})
    @ApiModelProperty(value = "参与权限： 0100置换 0200转售")
    private String partnerJoinRole;

    /**
     * 合作商状态 00：关闭 01：开启
     */
    @NotNull(message = "合作商状态 00：关闭 01：开启 不能是Null", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerStatusValidGroup.class})
    @Size(min=0, max=2, message="合作商状态 00：关闭 01：开启 字符长度必须小于等于2", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerStatusValidGroup.class})
    @ApiModelProperty(value = "合作商状态 00：关闭 01：开启")
    private String partnerStatus;

    /**
     * 合作商地址
     */
    @Size(min=0, max=200, message="合作商地址 字符长度必须小于等于200", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerAddressValidGroup.class})
    @ApiModelProperty(value = "合作商地址")
    private String partnerAddress;

    /**
     * 排名
     */
    @Digits(integer=10, fraction=0, message="排名 数字精度必须符合(10,0)", groups = {SysPartnerDetailsEntityValidGroup.class, PartnerOrderValidGroup.class})
    @ApiModelProperty(value = "排名")
    private Double partnerOrder;

    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysPartnerDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysPartnerDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysPartnerDetailsEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;

    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysPartnerDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysPartnerDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysPartnerDetailsEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;

    /**
     * 是否已删除(0：未删除/1：已删除)
     */
    @ApiModelProperty(value = "是否已删除(0：未删除/1：已删除)")
    private Integer isDelete;

    public SysPartnerDetailsEntity() {
    }

    public SysPartnerDetailsEntity(Long partnerId) {
        this.partnerId = partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
    public Long getPartnerId() {
        return this.partnerId;
    }


    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }
    public String getPartnerCode() {
        return this.partnerCode;
    }

    public void setPartnerChargePerson(String partnerChargePerson) {
        this.partnerChargePerson = partnerChargePerson;
    }
    public String getPartnerChargePerson() {
        return this.partnerChargePerson;
    }

    public void setChargePersonIphone(String chargePersonIphone) {
        this.chargePersonIphone = chargePersonIphone;
    }
    public String getChargePersonIphone() {
        return this.chargePersonIphone;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
    public String getPartnerName() {
        return this.partnerName;
    }

    public void setPartnerAbbreviation(String partnerAbbreviation) {
        this.partnerAbbreviation = partnerAbbreviation;
    }
    public String getPartnerAbbreviation() {
        return this.partnerAbbreviation;
    }

    public void setPartnerJoinRole(String partnerJoinRole) {
        this.partnerJoinRole = partnerJoinRole;
    }
    public String getPartnerJoinRole() {
        return this.partnerJoinRole;
    }

    public void setPartnerStatus(String partnerStatus) {
        this.partnerStatus = partnerStatus;
    }
    public String getPartnerStatus() {
        return this.partnerStatus;
    }

    public void setPartnerAddress(String partnerAddress) {
        this.partnerAddress = partnerAddress;
    }
    public String getPartnerAddress() {
        return this.partnerAddress;
    }

    public void setPartnerOrder(Double partnerOrder) {
        this.partnerOrder = partnerOrder;
    }
    public Double getPartnerOrder() {
        return this.partnerOrder;
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

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public Integer getIsDelete() {
        return this.isDelete;
    }

    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
                (partnerId == null)

                        ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
        partnerId = RandomIDGennerator.get().generate();
    }

    public interface SysPartnerDetailsEntityValidGroup {}
    public interface PartnerIdValidGroup {}
    public interface PartnerCodeValidGroup {}
    public interface PartnerChargePersonValidGroup {}
    public interface ChargePersonIphoneValidGroup {}
    public interface PartnerNameValidGroup {}
    public interface PartnerAbbreviationValidGroup {}
    public interface PartnerJoinRoleValidGroup {}
    public interface PartnerStatusValidGroup {}
    public interface PartnerAddressValidGroup {}
    public interface PartnerOrderValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
                SysPartnerDetailsEntity.PartnerIdValidGroup.class
                , SysPartnerDetailsEntity.PartnerCodeValidGroup.class
                , SysPartnerDetailsEntity.PartnerChargePersonValidGroup.class
                , SysPartnerDetailsEntity.ChargePersonIphoneValidGroup.class
                , SysPartnerDetailsEntity.PartnerNameValidGroup.class
                , SysPartnerDetailsEntity.PartnerAbbreviationValidGroup.class
                , SysPartnerDetailsEntity.PartnerJoinRoleValidGroup.class
                , SysPartnerDetailsEntity.PartnerStatusValidGroup.class
                , SysPartnerDetailsEntity.PartnerAddressValidGroup.class
                , SysPartnerDetailsEntity.PartnerOrderValidGroup.class
                , SysPartnerDetailsEntity.CreatedByValidGroup.class
                , SysPartnerDetailsEntity.CreatedDateValidGroup.class
                , SysPartnerDetailsEntity.UpdatedByValidGroup.class
                , SysPartnerDetailsEntity.UpdatedDateValidGroup.class
        };
    }
}
