package com.exp.ucmp.storeApp.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


@ApiModel(value = "ReplaceCluesDetailsQueryDto", description = "客户线索详情信息查询Dto")
public class ReplaceCluesDetailsQueryDto extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "link标识(为漏斗筛选所需 00-未 01-已)")
    private String link;

    @ApiModelProperty(value = "已关闭筛选状态( 放弃接单 0909 战败 0919 审批关闭 1309")
    private String closedStatus;

    @ApiModelProperty(value = "已完成筛选状态( 已报价待收购 0921 已收购待过户 0922 已过户待审批 1303 审批驳回 1305 审批通过) 1304")
    private String status;

    @ApiModelProperty(value = "签到标识(为漏斗筛选所需 00-未 01-已)")
    private String sign;
    
    /**
     * 漏斗筛选状态
     */
    @ApiModelProperty(value = "预约单：待分配0701 已分配0702 无车商接单0711 " + 
    						  "报价单：待签到0703 已签到0704 无车商报价0712 " +
                              "已完成：已报价-待接洽0705 待车商收购0921 待过户0922 " +
                              "已收购--未link新车订单0923 已收购--已link新车订单0923 无车商收购(0929、0713)" +
                              "已关闭：无车商接单0711 无车商报价0712 无车商收购0713   客户拒绝的数据，系统自动置为已关闭0709")
    private List<String> filterStatus;
    
    /**
     * 跟踪状态
     * 0701	待分配
     * 0702	已分配
     * 0703	待检测
     * 0704	检测中
     * 0705	已报价
     * 0706	已完成
     * 0709	已关闭
     */

    @ApiModelProperty(value = "跟踪状态：0701\t待分配\n" +
            "0702\t已分配\n" +
            "0703\t待检测\n" +
            "0704\t检测中\n" +
            "0705\t已报价\n" +
            "0706\t已完成\n" +
            "0709\t已关闭\n/" +
            "0711\t无车商接单\n/" +
            "0712\t无车商报价\n/" +
            "0713\t无车商收购\n/(预约单传0701,0702,0711/已报价传0703,0704,0712/已完成传0705,0706,0713/已关闭传0709)")
    private List<String> trackStatus;
    
    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID/某个置换单查询需要传的参数")
    private Long reservationId;

    /**
     * 登录人id
     */
    @ApiModelProperty(value = "登录人的id")
    private Long loginPersonId;

    /**
     * 角色
     */
    @ApiModelProperty(value = "角色")
    private String role;

    /**
     * 店端登录人名字
     */
    @ApiModelProperty(value = "店端登录人名字")
    private String idmAccountName;

    /**
     * 店端登录人上级名字
     */
    @ApiModelProperty(value = "店端登录人上级名字")
    private String idmAccountUpName;

    /**
     * 业务编号
     */
    @ApiModelProperty(value = "业务编号")
    private String businessOrderNo;

    /**
     * 门店id or  顾问id or 经理id(不需要传)
     */
    @ApiModelProperty(value = "门店id or  顾问id or 经理id(不需要传)")
    private Long partyId;


    /**
     * 门店id(不需要传)
     */
    @ApiModelProperty(value = "门店id(不需要传)")
    private Long storeId;

    /**
     * 顾问id(不需要传)
     */
    @ApiModelProperty(value = "顾问id(不需要传)")
    private Long consultantId;

    /**
     * 经理id(不需要传)
     */
    @ApiModelProperty(value = "经理id(不需要传)")
    private Long managerId;
    
    public String getClosedStatus() {
        return closedStatus;
    }

    public void setClosedStatus(String closedStatus) {
        this.closedStatus = closedStatus;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getFilterStatus() {
        return filterStatus;
    }

    public void setFilterStatus(List<String> filterStatus) {
        this.filterStatus = filterStatus;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public List<String> getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(List<String> trackStatus) {
        this.trackStatus = trackStatus;
    }

    public Long getLoginPersonId() {
        return loginPersonId;
    }

    public void setLoginPersonId(Long loginPersonId) {
        this.loginPersonId = loginPersonId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getConsultantId() {
        return consultantId;
    }

    public void setConsultantId(Long consultantId) {
        this.consultantId = consultantId;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public String getIdmAccountName() {
        return idmAccountName;
    }

    public void setIdmAccountName(String idmAccountName) {
        this.idmAccountName = idmAccountName;
    }

    public String getIdmAccountUpName() {
        return idmAccountUpName;
    }

    public void setIdmAccountUpName(String idmAccountUpName) {
        this.idmAccountUpName = idmAccountUpName;
    }

    public String getBusinessOrderNo() {
        return businessOrderNo;
    }

    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }
}
