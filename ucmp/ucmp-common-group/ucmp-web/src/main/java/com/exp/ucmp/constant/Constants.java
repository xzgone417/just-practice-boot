/**
 * Constants.java Created at 2022年07月12日 Created by Yiyongfei Copyright (C) 2022 chumi, All rights reserved.
 */
package com.exp.ucmp.constant;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 常量
 *
 * @author Yiyongfei
 * @date 2022/07/12
 */
public class  Constants {
    public static final String PROFILE_DEV = "dev";
    public static final String PROFILE_TEST = "test";
    public static final String PROFILE_UAT = "uat";
    public static final String PROFILE_PROD = "prod";

    public enum DeleteRemak { // 删除标记
        DELETE("00"), UN_DELETE("01");

        private String value;

        private DeleteRemak(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum IsLock { // 用户是否锁定：01、未锁定；09、被锁定
        LOCK("09"), UNLOCK("01");

        private String value;

        private IsLock(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum IsPrimary { // 是否主登录用户：01、主用户，09、非主用户；一个当事人只允许一个主登录用户
        YES("01"), NO("09");

        private String value;

        private IsPrimary(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum ValidMark { // 有效标记：00、已失效，01、有效, 09、暂时失效
        INVALID("00"), VALID("01"), TEMP_FAIL("09");

        private String value;

        private ValidMark(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum PartyType { // 当事人类型：0100、人员，0200、组织，0300、职位
        PERSON("0100"), ORGANIZATION("0200"), POSITION("0300");

        private String value;

        private PartyType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum ResouceAccessType { //资源访问类型：01、匿名；02、用户(包含登录和记住我)；03、登录；04、授权
        ANON("01"), USER("02"), LOGIN("03"), AUTHZ("04");

        private String value;

        private ResouceAccessType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum SEPARATOR { //分隔符,GRAPHIC图文分隔符
        SPACE(" "), UNDERLINE("_"), SLASH("/"), COLON(":"), SEMICOLON(";"), COMMA(","), TAB("\t"), GRAPHIC("\\|");

        private String value;

        private SEPARATOR(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum LoginType { //登录类型
        person("person"), nopassword("nopassword");

        private String value;

        private LoginType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }
    /**登录类型 是否需要密码：01、需密码登录，02、可免密码登录 **/
    public enum IsPassword {
        password("01"), nopassword("02");

        private String value;

        private IsPassword(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum DepartmentOpe { //部门员工操作类型
        insert("01"), delete("00");

        private String value;

        private DepartmentOpe(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum RoleIfAvailable { //角色是否可用
        effective("01"), invalid("00");

        private String value;

        private RoleIfAvailable(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum RoleType { //角色类型
        headquarters("0010"),
        store("0020"),
        carDealer("0030");

        private String value;

        private RoleType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum StaffType { //人员类型
        headquarters("0010"),
        store("0020"),
        carDealer("0030");

        private String value;

        private StaffType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum StaffOpe { //员工操作类型
        insert("01"), delete("00");

        private String value;

        private StaffOpe(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum DataType { //数据类型标记
        area("A"),
        province("P"),
        city("C");

        private String value;

        private DataType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum Sex { //数据类型标记
        man("01"),
        women("02");


        private String value;

        private Sex(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum SexType { //数据类型标记
        man("男"),
        women("女");


        private String value;

        private SexType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum DepartmentType { //部门类型
        headquarters("0010"),
        store("0020"),
        carDealer("0030");

        private String value;

        private DepartmentType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    /** 是否被删除 (00：未删除/01：已删除) **/
    public enum IsDelete {
        YES("01"),
        NO("00");

        private String value;

        private IsDelete(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum UserPassword { //是否被删除
        defaultPwd("123456");


        private String value;

        private UserPassword(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum staffStatus { //人员状态
        disable("01"),
        enable("00");


        private String value;

        private staffStatus(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum cluesType { //线索类型
        replace("0101"),
        acquisition("0102"),
        sale("0103");
        private String value;

        private cluesType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum cluesSource { //线索来源
        EOS("0201"),
        applets("0202"),
        gaoheApp("0203"),
        pipeNetwork("0204"),
        SLF("0205");


        private String value;

        private cluesSource(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum cluesStatus { //线索状态
        unReserved("0301"),
        reserved("0302"),
        invalid("0309");


        private String value;

        private cluesStatus(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum FollowStatus {//线索管理-状态（t_psi_retention_clues.follow_status）
        NOT_FOLLOWED_UP("7801","待跟进"),
        FOLLOWED_UP("7802","跟进中"),
        GENERATE_ORDER("7803","已生成订单"),
        DEFEAT("7804","战败");
        private String code;
        private String name;

        FollowStatus(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public enum RetentionCluesSource {//线索管理-状态（t_psi_retention_clues.follow_status）
        SHOPPING("6801","商城"),
        IMPORT("6802","导入"),
        SCENE("6803","到店");
        private String code;
        private String name;

        RetentionCluesSource(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public enum PurchaseTime {//线索管理-购车时间（t_psi_retention_clues.purchase_time）
        PURCHASE_TIME_7601("7601","一个月内"),
        PURCHASE_TIME_7602("7602","1-3个月内"),
        PURCHASE_TIME_7603("7603","3个月以上"),
        PURCHASE_TIME_7604("7604","购车时间未知");
        private String code;
        private String name;

        PurchaseTime(String code, String name) {
            this.code = code;
            this.name = name;
        }
        public static String getName(String code){
            if(Objects.isNull(code)){
                return null;
            }
            for (PurchaseTime value : PurchaseTime.values()) {
                if(Objects.equals(value.getCode(),code)){
                    return value.getName();
                }
            }
            return null;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public enum FamilySituation {//线索管理-家庭情况（t_psi_retention_clues.family_situation）
        SINGLE("7501","单身"),
        CHILDLESS("7502","无小孩"),
        HAVING_CHILDREN("7503","有小孩"),
        SINGLE_PARENT_WITH_CHILDREN("7504","单亲有子女"),
        UNKNOWN("7505","家庭情况未知");
        private String code;
        private String name;

        FamilySituation(String code, String name) {
            this.code = code;
            this.name = name;
        }
        public static String getName(String code){
            if(Objects.isNull(code)){
                return null;
            }
            for (FamilySituation value : FamilySituation.values()) {
                if(Objects.equals(value.getCode(),code)){
                    return value.getName();
                }
            }
            return null;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public enum CustomerCharacter {//线索管理-客户性格（t_psi_retention_clues.customer_character）
        EXTROVERSION("00","外向"),
        INTROVERSION("01","内向");
        private String code;
        private String name;

        CustomerCharacter(String code, String name) {
            this.code = code;
            this.name = name;
        }
        public static String getName(String code){
            if(Objects.isNull(code)){
                return null;
            }
            for (CustomerCharacter value : CustomerCharacter.values()) {
                if(Objects.equals(value.getCode(),code)){
                    return value.getName();
                }
            }
            return null;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public enum ApproveResult {//线索管理-订单管理-改配状态（t_psi_sales_modify_config.approve_result）
        PROCESS(1,"改配中"),
        SUCCESS(2,"改配通过"),
        REJECT(3,"改配驳回"),
        CANCEL(4,"改配取消");
        private Integer code;
        private String name;

        ApproveResult(Integer code, String name) {
            this.code = code;
            this.name = name;
        }
        public static String getName(Integer code){
            if(Objects.isNull(code)){
                return null;
            }
            for (ApproveResult value : ApproveResult.values()) {
                if(Objects.equals(value.getCode(),code)){
                    return value.getName();
                }
            }
            return null;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



    public enum businessType { //业务类型
        otherBrand("0401"),
        oneselfBrand("0402");


        private String value;

        private businessType(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum trackStatus { //跟踪状态
        toBeAllocated("0701"),
        assigned("0702"),
        toBeTested("0703"),
        testing("0704"),
        quoted("0705"),
        completed("0706"),
        closed("0709"),
        noReceiving("0711"), //无车商接单
        noQuote("0712"),  //无车商报价
        noAcquisition("0713");  //无车商收购


        private String value;

        private trackStatus(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum shutCause { //关闭原因

        noReceiving("0601"),
        noQuoting("0602"),
        noAcquisitions("0603"),
        customerRefuses("0604");

        private String value;

        private shutCause(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum shutCauseDetails { //关闭原因细项

        noReceiving("060101"),
        noQuoting("060201"),
        noAcquisitions("060301"),
        customerRefuses("060401");

        private String value;

        private shutCauseDetails(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum inquiryStatus { //询价状态状态
        unOrderReceiving("0901"),//待接单
        orderReceiving("0902"),
        abandonOrderReceiving("0909"),//放弃接单
        unOffer("0911"),//待报价
        alreadyOffer("0912"),//已报价
        overdueUnOffer("0918"),//逾期未报价
        abandonOffer("0919"),//放弃报价
        unAcquired("0921"),//待收购
        unAllotDeliveryCenter("0913"),//待分配交付中心
        unTransfer("0922"),//待过户
        Acquired("0923"),//收购完成
        abandonAcquisition("0929"),//放弃收购
        laterOffer("0917");//报价失效

        private String value;

        private inquiryStatus(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum acquisitionStatus { //收购状态
        unAcquired("1101"),//待收购
        Acquired("1102"),//已收够
        abandonAcquisition("1103"),//放弃收购
        stockpending("1104"),//待入库
        warehoused("1105"),//已入库
        toBeAllocated("1106");//待分配-车辆支持

        private String value;

        private acquisitionStatus(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum customerIntention { //客户意向

        customerAgrees("0501"),
        customerBargaining("0502"),
        customerRefuse("0503");

        private String value;

        private customerIntention(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum materialStatus { //材料状态

        notUpload("1501"),
        againUpload("1502"),
        uploaded("1503");

        private String value;

        private materialStatus(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum businessLogo { //业务标识

        substitution("1601"),
        sale("1602");

        private String value;

        private businessLogo(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }






    public enum equityGrant { //权益发放

        grant("1801"),
        unGrant("1802");

        private String value;

        private equityGrant(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum oldCarConfirme { //旧车确人

        unConfirme("1201"),
        confirme("1202");

        private String value;

        private oldCarConfirme(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }





    public enum approvalResult { //审批结果

        adopt("1401"),//审批通过
        unAdopt("1402"),//审批驳回
        close("1403"),//审批关闭
        confirmed("1404"),//旧车确认
        reject("1405");//旧车驳回

        private String value;

        private approvalResult(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum approvalStatus { //审批状态

        unConfirmed("1301"),//待确认
        confirmed("1302"),//确认通过
        unApproval("1303"),//待审批
        approval("1304"),//审批通过
        reject("1305"),//驳回
        close("1309");//关闭

        private String value;

        private approvalStatus(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum businessNodes { //业务节点

        acquisitionMaterial("9101"),//首次
        transferMaterial("9102"),//待过户
        approvalRejection("9103"),//审批驳回
        quotedMaterial("9104");//报价

        private String value;

        private businessNodes(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }



    public enum storeRole { //门店角色编码

        adviser("RE010"),//MC
        director("RE006"),//MO
        shopowner("RE005");

        private String value;

        private storeRole(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum slfRole { //slf门店角色编码

        MC("MC"),   //出行顾问
        MO("MO"),   //MO    出行主管
        PMO("PMO"), //MO    预备出行主管
        ME("ME"),   //MO    出行专家
        SH("SH");   //店长

        private String value;

        private slfRole(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

        public static List<String> getAllMo(){
            List<String> moList = new ArrayList<>();
            for (slfRole slfRole : slfRole.values()) {
                if(!Objects.equals(slfRole.value,slfRole.MC.value()) &&
                        !Objects.equals(slfRole.value,slfRole.SH.value())){
                    moList.add(slfRole.value);
                }
            }
            return moList;
        }
    }
    
    public enum smpRole { //smp门店角色编码

        MO("4467720210223534254"),   //交付体验顾问
        SH("7163020210223314224");   //交付主管

        private String value;

        private smpRole(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    public enum fileStatus { //文件状态

        used("2101"),//使用中
        notUsed("2102"),//未使用
        deleted("2109");//已删除

        private String value;

        private fileStatus(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }

    /** t_organization_info表 华人运通的party_id**/
    public  static  final  Long HRYT_PARTY_ID = 1366656669688804579L;

    /** 系统默认登录密码 **/
    public static final String DEFAULT_PASSWORD = "123456";



    /**t_job_receive_info表:
     * 处理状态：01、待处理，02、处理成功，09、处理失败
     **/
    public enum JobProcessingStatus{
        /**
         * 处理成功
         **/
        SUCCESS("02"),

        /**
         * 处理失败
         **/
        FAIL("09"),

        /**
         * 待处理
         **/
        WAIT("01");
        private String value;

        JobProcessingStatus(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    /**t_job_receive_info表中的任务类型:

     **/
    public enum JobType{

        EMDM("emdm"),
        EOS("eos"),
        SMP("smp"),
        SLF("slf");
        private String value;

        JobType(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    /**t_job_receive_info表中的接收任务类型，
     * MQ是绑定类型，HTTP可能是定时任务
     **/
    public enum ReceiveTaskType{
        /** 人员管理定时任务**/
        PERSON_INFO_HANDLER("emdmPersonInfoHandler"),

        /** 门店管理定时任务 **/
        ORG_LIST_HANDLER("smpOrgListHandler"),
        
        /** 门店code定时任务 **/
        STORE_CODE_HANDLER("smpCodeListHandler"),
    	
        ALL_USER_HANDLER("eosAllUsersHandler"),
        
        SMP_ALL_USER_HANDLER("smpAllUsersHandler"),

        DEPT_INFO_HANDLER("emdmDeptInfoHandler"),

        SYN_NEWCARORDER_HANDLER("synNewCarOrderHandler"),

        SLF_ALL_USER_HANDLER("slfAllUsersHandler");
    	
        private String value;

        ReceiveTaskType(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    /**t_relationship_type_code当事人关系类型表枚举类:
     * 0101 隶属于组织的管理员
     * 0110 隶属于组织的普通用户
     **/
    public enum RelationshipTypeCode{
        /**
         * 隶属于组织的管理员
         **/
        ADMIN("0101"),

        /**
         * 隶属于组织的普通用户
         **/
        USER("0110");

        private String value;

        RelationshipTypeCode(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }

    }

    /**t_sys_store_info:
     * orgType组织类型(1:总公司;2:大区;3:子公司;4:交付中心;5:高合中心)
     **/
    public enum OrgType{
        /**
         * 禁用
         **/
        PARENT_OFFICE("1","总公司"),
        REGION("2","大区"),
        CHILD_OFFICE("3","子公司"),
        SUBMIT_CORE("4","交付中心"),
        /**
         * 启用
         **/
        ENABLE("5","高合中心");
        private String orgCode;
        private String orgType;

        OrgType(String orgCode, String orgType) {
            this.orgCode = orgCode;
            this.orgType = orgType;
        }
        public static String getOrgType(String orgCode) {
            for (OrgType  item : OrgType.values()) {
                if(item.orgCode.equals(orgCode)){
                    return item.orgType;
                }
            }
            return  null;
        }
        public String getOrgCode() {
            return orgCode;
        }

        public void setOrgCode(String orgCode) {
            this.orgCode = orgCode;
        }

        public String getOrgType() {
            return orgType;
        }

        public void setOrgType(String orgType) {
            this.orgType = orgType;
        }
    }
    /**是否可用00、无效，01、有效
     **/
    public enum IsEnable{
        /**
         * 禁用
         **/
        DISABLE("00"),

        /**
         * 启用
         **/
        ENABLE("01");

        private String value;

        IsEnable(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    /**t_sys_param_config表的参数类型
     * 001:报价截止时间/002:自动关闭时间/
     * 003:首次材料未上报提醒时间/004:过户材料未上报提醒时间)
     **/
    public enum SysParamConfigType{
        /**
         * 报价截止时间
         **/
        DEADLINE("001"),
        /**
         * 自动关闭时间
         **/
        CLOSING_TIME("002"),
        /**
         * 首次材料未上报提醒时间
         **/
        FIRST_REMINDER_TIME("003"),
        /**
         * 过户材料未上报提醒时间
         **/
        TRANSFER_REMINDER_TIME("004");

        private String value;

        SysParamConfigType(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }


    /**t_sys_parent_user_info表:
     * 状态(00:禁用/01:启用)
     **/
    public enum ParentUserInfoStatus{
        /**
         * 禁用
         **/
        DISABLE("00"),

        /**
         * 启用
         **/
        ENABLE("01");

        private String value;

        ParentUserInfoStatus(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    public enum templateId { //信息模板id

        templateTitleFirst("d9b2da5c-dd35-4897-96e5-b792acd863ad"),//您有一条新的置换单待分配，请及时处理
        templateTitleSecond("1f28b80c-84e0-4bb4-b2c2-766e7a4d7ae1"),//您的预约已过期无人接单
        templateTitleThird("8c4e3954-0a43-4c40-b1fb-11be4df3f78e"),//您的预约即将到达检测时间
        templateTitleFourth("c236797a-5150-4c69-8c63-155dc9318d03"),//您的预约即将到估价截止时间
        templateTitleFifth("9b829193-57f3-4248-babe-6ac8d375fb27"),//车商未上传收车材料
        templateTitleSixth("5daf8778-2674-48a0-80be-00aeb88039d0"),//您的预约即将到达检测时间
        templateTitleSeventh("09da5779-8b54-4290-8f85-bff6a6b48fe9"),//车商未上传过户材料
        templateTitleEighth("7e78015e-eb07-4c7a-b827-650cb87a970a"),//您的置换单已被接单
        templateTitleNine("ddbb21a5-1cb0-66f9-5ffe-d53d91ea29fa"),//	任务	线索自动下发至店长
        templateTitleTen("f3c56a16-29cc-338c-4e73-ae780da15cd1"),//	任务	店长分配线索至自己或销售人员
        templateTitleEleven("745c7d22-da2b-a76a-0d8d-f8ed71a602c4"),//状态提醒	线索长时间未分配到人
        templateTitleTwelve("8ac4ebe7-62e2-fa09-1c9d-a9e6bf79c946"),//	状态提醒	线索长时间无人跟进
        templateTitleThirteen("f1ab78c3-0bda-4a31-02f7-aa80b60dd12d"),//	状态提醒	订单长时间停留状态
        templateTitleFourteen("6bbfe434-fd67-d086-7794-0d684c084673"),//	状态提醒	总部通过改配申请
        templateTitleFifteen("f1409d02-4f3f-afda-a630-dbd8a8ffc258"),//	状态提醒	总部驳回改配申请
        templateTitleSixteen("d3907428-3a4b-5097-656c-67ac336664d0");//	状态提醒	总部激活线索



        private String value;

        private templateId(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }
    
    //极光消息模板id
    public enum jPushtemplateId { 
        JPUSHFIRST(2019042154874406626L),//总部分配本品收购订单
        JPUSHSECOND(2019045782159485695L),//交付主管分配本品收购订单
        JPUSHTHIRD(2019046352129791952L),//收购材料审批被驳回
        JPUSHFOURTH(2019046526197095329L),//审批通过，已入库待过户
        JPUSHFIFTH(2019046807739189334L),//审批通过，待总部人员手动入库
        JPUSHSIXTH(2019047796325891228L),//销售人员转交付至交付主管
        JPUSHSEVEN(2019047851688433465L);//交付主管分配订单至自己或顾问

        private Long value;

        private jPushtemplateId(Long value) {
            this.value = value;
        }

        public Long value() {
            return this.value;
        }
    }

    public enum MessageType{ //消息类型

        message("01"),
        Sms("02");
        private String value;

        public String value() {
            return this.value;
        }

        MessageType(String value) {
            this.value = value;
        }
    }



    public enum sendMessage { //短信模板id

        sendMessageFirst("773a1aa2e8cf4b46b977b8620c7a3eeb"),//通知车主在指定时间去指定地点做检测
        sendMessageSecond("9ca85a6dbba34e1f826212a9701dde62"),//报价完成后通知车主报价结果
        sendMessageThird("99cac98ed2394f19a84a4173e2182c1b"),//分配车商后通知车商人员
        sendMessageFourth("e0a9ff9a04e348db99cc0992a46681e7"),//接单截止前提醒车商人员
        sendMessageFifth("7bc53c82f1c94b9aab045097a3aea35c"),//提醒车商人员前往检测地点检测
        sendMessageSixth("a08e7911ed8b488c83066b96e1393f7c"),//客户同意报价提醒车商人员收购
        sendMessageSeventh("b791837a8ac74e46a811976678d2edf2"),//客户想议价提醒车商人员议价
        sendMessageEighth("5c4b2229e642488bbd099629a7fbd624"),//提醒车商人员上传过户材料
        sendMessageNinth("b6ab9c4620814580afc15ee64c75d3e5"),//提醒车商人员材料被驳回
        sendMessageTenth("7ab7eae2fd524a669ae279601989fe85"),//提醒总部人员置换预约单已生成
        sendMessageEleventh("b7c2e1162d7646a78257b58438f8b334"),//提醒总部人员车商未接单
        sendMessageTwelfth("83b443ff8d2b4316a5e397882c0b004f"),//提醒总部人员有车商未签到
        sendMessageThirteenth("0e8e9336b2cf42c58d799de8eff72848"),//提醒总部人员有最优报价
        sendMessageFourteenth("1ef14b5fee4349b188f20c4663e5f11a"),//提醒总部人员车商已收购
        sendMessageFifteenth("2dc70066c97648d2b6cef97ef5597bba"),//提醒车商人员上传过户材料-2
        sendMessageSixteenth("1ea59e6be4ae4a4c8d11026bb371845b"),//新的改配申请提醒
        sendMessageSeventeenth("a66a1f416f074e8e9dd39d3e3ef552a6"),//订单未跟进提醒
        sendMessageEighteenth("769f46001c1140fa921ea32d1b175db8"),//线索未跟进提醒
        sendMessageNineteenth("c9cab73b36794d75830a06a186c37b38"),//分配车商后通知车商人员_2
        sendMessageTwentieth("9ec5aee841ee45b29b9ed310009c7ff6"),//线索未分配提醒
        sendMessageTwentyFirst("28f22a8913534e0caf57e28663cb9a63"),//本品收购材料审批提醒
        sendMessageTwentySecond("70895149ed65437b8f70e0ffa41479cd"),//本品收购待入库提醒
        ;

        private String value;

        private sendMessage(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }


    public enum orderStatus{ //订单状态

        complete("2001"),
        unComplete("2002");
        private String value;

        public String value() {
            return this.value;
        }

        orderStatus(String value) {
            this.value = value;
        }
    }
    
    public enum paymentItem{ 

    	INTENTIONPAY("6701"),//小定
    	SETPAYMENT("6702"),//大定
    	BALANCEPAYMENT("6703"),//尾款
    	OTHERPAYMENTS("6704");//其他款项
        private String value;

        public String value() {
            return this.value;
        }

        paymentItem(String value) {
            this.value = value;
        }
    }


    public enum deliverStatus{ //订单交付状态

        deliver("2201"),
        unDeliver("2202");
        private String value;

        public String value() {
            return this.value;
        }

        deliverStatus(String value) {
            this.value = value;
        }
    }
    
    public enum usedCarOrderStatus{ //二手车订单状态

    	toBeDecided("7401"),//待下定
    	decided("7402"),// 已下定待转交付
    	allocated("7403"),// 已分配待付全款
    	fullyPaid("7404"),// 已全款待过户
    	transferred("7405"),//已过户待交付
    	delivered("7406"),//已交付
    	cancel("7407"),//订单取消
    	changing ("7408"),//改配申请中
    	toBeAllocated ("7409");//已转交付待分配
        private String value;

        public String value() {
            return this.value;
        }

        usedCarOrderStatus(String value) {
            this.value = value;
        }
    }
    
    public enum usedCarPdiStatus{ //二手车订单状态

    	toBeTested("6501"),//PDI状态 01 待检测 
    	toBePrepared("6502"),// 02 待整备
    	completed("6503");// 03 已完成
        private String value;

        public String value() {
            return this.value;
        }

        usedCarPdiStatus(String value) {
            this.value = value;
        }
    }
    
    /**t_sys_car_used_storage表:
     * 是否手动创建(00否01是)
     **/
    public enum IS_MANUAL_CREATION{
        YES("01"),
        NO("00");
        private String value;

        public String value() {
            return this.value;
        }

        IS_MANUAL_CREATION(String value) {
            this.value = value;
        }
    }
    /**t_sys_car_used_storage表:
     * 默认搬入地(00否01是)
     **/
    public enum DEFAULT_MOVE_ADDRESS{
        YES("01"),
        NO("00");
        private String value;

        public String value() {
            return this.value;
        }

        DEFAULT_MOVE_ADDRESS(String value) {
            this.value = value;
        }
    }

    //t_psi_car_stock_info表repeal_is字段 是否作废(00、否，01、是 )
    public enum IS_REPEAL{
        YES("01"),
        NO("00");
        private String value;

        public String value() {
            return this.value;
        }

        IS_REPEAL(String value) {
            this.value = value;
        }
    }

    // -------------------------库存状态-------------------------
    public enum STOCK_STATUS{
        /**
         * 5101:在库待售
         **/
        InStockForSale("5101"),

        /**
         * 5102:整备中
         **/
        Servicing("5102"),

        /**
         * 5103:待上架
         **/
        WAIT_PUT("5103"),

        /**
         * 5104:在售中
         **/
        ONSALE("5104"),

        /**
         * 5105:已预订
         **/
        Reserved("5105"),

        /**
         * 5106:已售出
         **/
        Sold("5106"),

        /**
         * 5107:退款待上架
         **/
        RefundPending("5107");

        private String value;

        STOCK_STATUS(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
        //获取库存车辆列表tab页对应状态:在库待售、整备中、待上架、在售中、已预订、已售出、退款待上架
        public static String[] getStockTab(){
           return new String[]{InStockForSale.value(),Servicing.value(),WAIT_PUT.value(),ONSALE.value(),Sold.value(),Reserved.value(),RefundPending.value()};
        }
        public static String[] getCancelStockTab(){
            return new String[]{InStockForSale.value()};
        }
        public static String[] getSaleTab(){
            return new String[]{InStockForSale.value(),Servicing.value(),WAIT_PUT.value(),ONSALE.value(),RefundPending.value()};
         }
    }


    //-------------------------调拨状态-------------------------
    /**t_psi_car_transfer_apply表:
     * 调拨状态(00:待发运/01:已调度/02:待发运出库/03:已出库/04:运输中/05:到达待入库/06:已入库/07:等待取消中/08:已取消)
     **/
    public enum TRANSFER_STATUS{
        /**
         * 待发运
         **/
        WAIT_SHIPP("5201"),

        /**
         * 已调度
         **/
        DISPATCH("5202"),

        /**
         * 待发运出库
         **/
        WAIT_OUTBOUND("5203"),

        /**
         * 已出库
         **/
        OUTBOUND("5204"),

        /**
         * 运输中
         **/
        TRANSPORT("5205"),

        /**
         * 到达待入库
         **/
        WAIT_WAREHOUS("5206"),

        /**
         * 已入库
         **/
        WAREHOUS("5207"),

        /**
         * 等待取消中
         **/
        WAIT_CANCEL("5208"),

        /**
         * 已取消
         **/
        CANCEL("5209");

        private String value;

        TRANSFER_STATUS(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    //-------------------------整备单状态-------------------------

    /**t_psi_car_transfer_apply表:
     * 是否提交(00未提交 01已提交 02关闭)
     **/
    public enum IS_SUBMIT{
        /**
         * 未提交
         **/
        WAIT_SUBMIT("00"),

        /**
         * 已提交
         **/
        SUBMIT("01"),

        /**
         * 关闭
         **/
        CLOSE("02"),
        
        /**
         * 交付端保存
         **/
        SAVE("03");

        private String value;

        IS_SUBMIT(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }


    /**t_psi_car_service_info表:
     * 整备单状态
     **/
    public enum SERVICE_STATE{
        /**
         * 待反馈
         **/
        WAIT_FEEDBACK("5301"),

        /**
         * 已反馈待审批
         **/
        WAIT_APPROVAL("5302"),

        /**
         * 已通过-施工中
         **/
        WAIT_GENERATE("5303"),

        /**
         * 有增项-待审批
         **/
        WAIT_EXECUTE("5304"),

        /**
         * 已生成工单-待实施
         **/
        WAIT_IMPLEMENT("5305"),
        
        /**
         * 实施完成-待验收
         **/
        FINISH("5306"),
        
        /**
         * 已验收入库
         **/
        WAREHOUS("5307"),

        /**
         * 驳回
         **/
        REJECT("5308"),

        /**
         * 放弃整备-转批售
         **/
        WHOLESALE("5309"),

        /**
         * 审批通过
         */
        PASS("5310"),
        
        /**
         * 反结算
         **/
        CANCEL("5311"),
        
        /**
         * 工单审批驳回
         **/
        ORDERREJECT("5312")
        ;

        private String value;

        SERVICE_STATE(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
        //维修项目反馈tab页状态值：待反馈、已反馈-待审批、已通过-待生成工单、审批驳回、已放弃整备、已取消整备
        public static  String[] getProjectFeedbackTab() {
            return new String []{WAIT_FEEDBACK.value(),WAIT_APPROVAL.value(),WAIT_GENERATE.value(),REJECT.value(),WHOLESALE.value(),CANCEL.value()};
        }
        //维修工单反馈tab页状态值：待反馈、已反馈-待审批、已通过-待生成工单、审批驳回、已放弃整备、已取消整备
        public static  String[] getWorkOrderFeedbackTab() {
            return new String []{WAIT_EXECUTE.value(),WAIT_IMPLEMENT.value(),ORDERREJECT.value(),PASS.value(),WAREHOUS.value(),FINISH.value(),WHOLESALE.value(),CANCEL.value()};
        }
    }

    //-------------------------维修状态-------------------------
    public enum maintenanceStatus{
        //电池/电机等维修
        Battery("4401"),
        //漆面维修
        PaintWork("4402"),
        //非重要配件更换
        noImportant("4403"),
        //车辆显示屏或电脑更换
        Display("4404"),
        //其他因本地政策需要披露的维修
        Other("4405");
        private String value;
        maintenanceStatus(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    //-------------------------适用性质-------------------------
    public enum useNatureStatus{
        //一般企业-营运
        GeneralEnterpriseOperation("4301"),
        //一般企业-非营运
        GeneralEnterpriseNoOperation("4302"),
        //租赁公司-营运
        LeasingCompanyOperation("4303"),
        //租赁公司-非营运
        LeasingCompanyNoOperation("4304");
        private String value;
        useNatureStatus(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    //-------------------------过户次数-------------------------
    public enum transferCountStatus{
        //一次
        One("4501"),
        //两次
        Two("4502"),
        //3
        Three("4503"),
        //4
        Four("4504"),
        //>=4
        Other("4505");
        private String value;
        transferCountStatus(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    //-------------------------生产年份-------------------------
    public enum ProductionYearDiscountStatus{
        //生产日期-年份累计折扣
        YearCumulative("4601"),
        //车型年变化折扣
        ModelYearChange("4602");
        private String value;
        ProductionYearDiscountStatus(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    //-------------------------区间折扣-------------------------
    public enum SectionDiscountStatus{
        //里程
        Mile("00"),
        //折旧
        Month("01");
        private String value;
        SectionDiscountStatus(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    //-------------------------调拨类型---------------------
    public enum TRANSFER_TYPE{
        //异地销售
        ALLOPATRY("5501"),
        //库存调整
        STOCK_ADJUST("5502");
        private String value;
        TRANSFER_TYPE(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    //-------------------------库存类型---------------------
    public enum STOCK_TYPE{
        //网点库存
        OutletInventory("5801"),
        //调拨申请中
        TransferApply("5802"),
        //调拨在途
        TransferInTransit("5803");
        private String value;
        STOCK_TYPE(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    //-------------------------出入库类型-------------------------
    public enum ReceiptType{

        //调拨出库
        TransferIssue("5401"),
        //调拨入库
        TransferReceipt("5402"),
        //零售出库Retail outbound
        RetailOutbound("5403"),
        //批售出库Issuebatch
        BatchIssue("5404"),
        //整备出库
        SERVICE_OUTBOUND("5405"),
        //整备入库
        SERVICE_PUT_STORAGE("5406");
        private String value;
        ReceiptType(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }
    /**归属主体:保益/7901;悦华/7902;高合/7903**/
    public enum REVERT_BODY{
        //保益
        BY("7901","保益"),
        //悦华
        YH("7902","悦华"),
        //高合
        GH("7903","高合");
        private String value;
        private String desc;
        REVERT_BODY(String value,String desc) {
            this.desc = desc;
            this.value = value;
        }
        public String desc() {
            return this.desc;
        }
        public String value() {
            return this.value;
        }
        public static String getValue(String desc) {
            for (REVERT_BODY item: REVERT_BODY.values()) {
                if(item.desc.equals(desc)){
                    return item.value;
                }
            }
            return null;
        }
    }

    /** t_psi_car_stock_info表决策类型:零售：2301/批售：2302**/
    public enum DECISION_TYPE{
        /**
         * 零售
         */
        RETAIL("2301"),
        /**
         * 批售
         */
        WHOLESALE("2302");
        private String value;
        DECISION_TYPE(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }

    /** t_psi_car_service_material_approval_record表审批结果00:驳回/01:通过**/
    public enum APPROVAL_RESULT{
        /**
         * 驳回
         */
        REJECT("00"),
        /**
         * 通过
         */
        PASS("01");
        private String value;
        APPROVAL_RESULT(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
        }
    }


    /**车辆来源
     **/
    public enum CAR_SOURCE{

        IMPORT("2101","导入车源"),//导入车源
        ACQUISITION_STORAGE("2102","收购入库")//收购入库
        ;
    	
        private String value;
        private String desc;

        CAR_SOURCE(String value,String desc) {
            this.value = value;
            this.desc = desc;
        }
        
        public String value() {
            return this.value;
        }
        
        public String desc() {
            return this.desc;
        }
		
		public static String getValue(String desc) {
            for (CAR_SOURCE item: CAR_SOURCE.values()) {
                if(item.desc.equals(desc)){
                    return item.value;
                }
            }
            return null;
        }
    }
    
    /**车辆性质
     **/
    public enum CAR_NATURE{

    	OPERATE("0801","营运"),//营运
    	NON_OPERATING("0802","非营运")//非营运
        ;
    	
        private String value;
        private String desc;

        CAR_NATURE(String value,String desc) {
            this.value = value;
            this.desc = desc;
        }
        
        public String value() {
            return this.value;
        }
        
        public String desc() {
            return this.desc;
        }
		
		public static String getValue(String desc) {
            for (CAR_NATURE item: CAR_NATURE.values()) {
                if(item.desc.equals(desc)){
                    return item.value;
                }
            }
            return null;
        }
    }
    
    /**车辆类型
     **/
    public enum CAR_TYPE{

    	INTERNAL_VEHICLE_TRANSFER("2401","内部车转移"),//内部车转移
    	EXTERNAL_CAR_PURCHASE("2402","外部车采购")//外部车采购
        ;
    	
    	private String value;
        private String desc;

        CAR_TYPE(String value,String desc) {
            this.value = value;
            this.desc = desc;
        }
        public String value() {
            return this.value;
        }
        public String desc() {
            return this.desc;
        }
        public static String getValue(String desc) {
            for (CAR_TYPE item: CAR_TYPE.values()) {
                if(item.desc.equals(desc)){
                    return item.value;
                }
            }
            return null;
        }
    }

    public enum CodeEnum { 
		smpCode("000000"),
		eosCode("200"),
		slfCode("000000");

		private String value;

		private CodeEnum(String value) {
			this.value = value;
		}

		public String value() {
			return this.value;
		}
	}
    
    public enum IsRightOrPoints {
        RIGHT("3401"),
        POINTS("3402");

        private String value;

        private IsRightOrPoints(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }
    }
}

