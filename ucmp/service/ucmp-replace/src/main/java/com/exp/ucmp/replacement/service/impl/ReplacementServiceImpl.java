package com.exp.ucmp.replacement.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson.JSON;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carDealer.dto.AcquisitionAllFileDto;
import com.exp.ucmp.carDealer.dto.PicDto;
import com.exp.ucmp.carDealer.dto.SaveTransactionPriceDto;
import com.exp.ucmp.carDealer.dto.UpdateInquiryApprovalStatusDto;
import com.exp.ucmp.carService.dto.OneselfApproveDto;
import com.exp.ucmp.carService.dto.OneselfPutIntoStorageDto;
import com.exp.ucmp.config.HwOBSConfig;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.fegin.ActivitiesFegin;
import com.exp.ucmp.fegin.PointsFegin;
import com.exp.ucmp.fegin.SendSmsFegin;
import com.exp.ucmp.fegin.SystemFegin;
import com.exp.ucmp.grantPointsRecord.dto.GrantPointsDto;
import com.exp.ucmp.huawei.dto.SmsParamsDto;
import com.exp.ucmp.jPush.dto.JPushReqDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiCustomerBasicInformationPk;
import com.exp.ucmp.pk.PsiCustomerCarsPk;
import com.exp.ucmp.pk.PsiCustomerReservationMsgPk;
import com.exp.ucmp.pk.PsiCustomerReservationTrackPk;
import com.exp.ucmp.pk.SysStoreInfoPk;
import com.exp.ucmp.replacement.dao.ReplacementDao;
import com.exp.ucmp.replacement.dao.SysRightActivitiesDao;
import com.exp.ucmp.replacement.dto.*;
import com.exp.ucmp.replacement.feign.ApprovalStatus;
import com.exp.ucmp.replacement.feign.SendJpushFegin;
import com.exp.ucmp.replacement.service.ReplacementService;
import com.exp.ucmp.storeApp.dto.OneselfAssessPicsDto;
import com.exp.ucmp.storeApp.dto.OneselfCarPicDto;
import com.exp.ucmp.tsp.dto.RegAndLoginDto;
import com.exp.ucmp.urc.dto.RightsGrantDto;
import com.exp.ucmp.urm.dto.UrmGrantReturnDto;
import com.exp.ucmp.urm.dto.UrmReturnDto;
import com.exp.ucmp.util.AesUtils;
import com.exp.ucmp.util.EasyExcelUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * @author zhouchengwei
 * @date 2022年10月16日
 */

@Service
public class ReplacementServiceImpl implements ReplacementService {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReplacementServiceImpl.class);
    
    @Autowired
    private HwOBSConfig hwOBSConfig;

    @Autowired
    ReplacementDao replacementDao;

    @Autowired
    IRepReplacementMaterialDao iRepReplacementMaterialDao;


    @Autowired
    IRepReplacementMaterialFileDao iRepReplacementMaterialFileDao;

    @Autowired
    ISysFileMsgDao iSysFileMsgDao;

    @Autowired
    IRepReplacementApprovalRecordDao iRepReplacementApprovalRecordDao;


    @Autowired
    IRepReplacementApprovalDao iRepReplacementApprovalDao;

    @Autowired
    ApprovalStatus approvalStatus;
    
    @Autowired
    SendJpushFegin sendJpushFegin;

    @Autowired
    IPsiCarAcquisitionDao iPsiCarAcquisitionDao;

    @Autowired
    ISysRightActivitiesDao iSysRightActivitiesDao;
    @Autowired
    IPsiNewCarOrderDao newCarOrderDao;

    @Autowired
    SysRightActivitiesDao sysRightActivitiesDao;
    @Autowired
    IPsiCustomerReservationTrackDao iPsiCustomerReservationTrackDao;
    @Autowired
    IPsiCustomerBasicInformationDao iPsiCustomerBasicInformationDao;
    @Autowired
    SendSmsFegin sendSmsFegin;

    @Autowired
    ActivitiesFegin activitiesFegin;

    @Autowired
    PointsFegin pointsFegin;	
    
    @Autowired
    ISysPartnerStaffInfoDao sysPartnerStaffInfoDao;

    @Autowired
    ISysRightActivitiesDistributeDetailsDao iSysRightActivitiesDistributeDetailsDao;
    @Autowired
    IPsiCarDealerInquiryDao iPsiCarDealerInquiryDao;

    @Autowired
    IPsiCustomerReservationMsgDao customerReservationMsgDao;

    @Autowired
    ISysStoreInfoDao sysStoreInfoDao;

    @Autowired
    UcmpAesConfig ucmpAesConfig;
    @Autowired
    IPsiAcquisitionMaterialDao materialDao;
    @Autowired
    IPsiAcquisitionMaterialFileDao fileDao;
    
    @Autowired
    IPsiOrderReceivingRecordDao iPsiOrderReceivingRecordDao;
    
    @Autowired
    private IPsiCustomerCarsDao iPsiCustomerCarsDao;
    
    @Autowired
    private IPsiCarStockInfoDao iPsiCarStockInfoDao;
    
    @Autowired
    private SystemFegin systemFegin;
    
    /**
     * 置换审批查询
     * @param repReplacementApprovalDto 查询条件
     * @return
     */
    @Override
    public PageInfo<RepReplacementApprovalReturnDto> queryReplaceApproval(RepReplacementApprovalDto repReplacementApprovalDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        repReplacementApprovalDto.setPartyId(user.getPartyId());
        Integer pageNum = repReplacementApprovalDto.getPageNum();
        Integer pageSize = repReplacementApprovalDto.getPageSize();
        repReplacementApprovalDto.setBusinessType(Constants.businessType.otherBrand.value());
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isNotBlank(repReplacementApprovalDto.getOldCarCustomerIphone())){
            repReplacementApprovalDto.setOldCarCustomerIphone(AesUtils.encryptHex(repReplacementApprovalDto.getOldCarCustomerIphone(),ucmpAesConfig.getSecret()));
        }
        List<RepReplacementApprovalReturnDto> repReplacementApprovalReturnDtos = replacementDao.selectReplaceApproval(repReplacementApprovalDto);
        if (CollectionUtils.isNotEmpty(repReplacementApprovalReturnDtos)){
            //只允许驳回一次
            for (RepReplacementApprovalReturnDto repReplacementApprovalReturnDto : repReplacementApprovalReturnDtos) {
                //手机号解密
                try {
                    repReplacementApprovalReturnDto.setOldCarCustomerIphone(AesUtils.decryptHex(repReplacementApprovalReturnDto.getOldCarCustomerIphone(),ucmpAesConfig.getSecret()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                RepReplacementApprovalRecordEntity approvalRecordEntity = new RepReplacementApprovalRecordEntity();
                approvalRecordEntity.setApprovalResult(Constants.approvalResult.unAdopt.value());
                approvalRecordEntity.setReplacementId(repReplacementApprovalReturnDto.getReplacementId());
                int unAdoptCount = iRepReplacementApprovalRecordDao.selectBySelectiveCount(approvalRecordEntity);
                RepReplacementApprovalRecordEntity approvalRecord = new RepReplacementApprovalRecordEntity();
                approvalRecord.setApprovalResult(Constants.approvalResult.reject.value());
                approvalRecord.setReplacementId(repReplacementApprovalReturnDto.getReplacementId());
                int rejectCount = iRepReplacementApprovalRecordDao.selectBySelectiveCount(approvalRecord);
                if (rejectCount>0 || unAdoptCount>0){
                    repReplacementApprovalReturnDto.setFlag(true);
                }

            }
        }
        PageInfo<RepReplacementApprovalReturnDto> page = new PageInfo<RepReplacementApprovalReturnDto>(repReplacementApprovalReturnDtos);
        return page;
    }

    /**
     * 旧车确认查询
     * @param repReplacementApprovalDto
     * @return
     */
    @Override
    public PageInfo<RepReplacementApprovalReturnDto>queryOldConfirm(RepReplacementApprovalDto repReplacementApprovalDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        repReplacementApprovalDto.setPartyId(user.getPartyId());
        Integer pageNum = repReplacementApprovalDto.getPageNum();
        Integer pageSize = repReplacementApprovalDto.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        if (StringUtils.isNotBlank(repReplacementApprovalDto.getOldCarCustomerIphone())){
            repReplacementApprovalDto.setOldCarCustomerIphone(AesUtils.encryptHex(repReplacementApprovalDto.getOldCarCustomerIphone(),ucmpAesConfig.getSecret()));
        }
        List<RepReplacementApprovalReturnDto> repReplacementApprovalReturnDtos = replacementDao.selectOldConfirm(repReplacementApprovalDto);
        if (CollectionUtils.isNotEmpty(repReplacementApprovalReturnDtos)){
            //只允许驳回一次
            for (RepReplacementApprovalReturnDto repReplacementApprovalReturnDto : repReplacementApprovalReturnDtos) {
                //手机号解密
                try {
                    repReplacementApprovalReturnDto.setOldCarCustomerIphone(AesUtils.decryptHex(repReplacementApprovalReturnDto.getOldCarCustomerIphone(),ucmpAesConfig.getSecret()));
                } catch (Exception e) {
                    LOGGER.error("===手机号解密==",e);
                }
                RepReplacementApprovalRecordEntity approvalRecordEntity = new RepReplacementApprovalRecordEntity();
                approvalRecordEntity.setApprovalResult(Constants.approvalResult.unAdopt.value());
                approvalRecordEntity.setReplacementId(repReplacementApprovalReturnDto.getReplacementId());
                int unAdoptCount = iRepReplacementApprovalRecordDao.selectBySelectiveCount(approvalRecordEntity);
                RepReplacementApprovalRecordEntity approvalRecord = new RepReplacementApprovalRecordEntity();
                approvalRecord.setApprovalResult(Constants.approvalResult.reject.value());
                approvalRecord.setReplacementId(repReplacementApprovalReturnDto.getReplacementId());
                int rejectCount = iRepReplacementApprovalRecordDao.selectBySelectiveCount(approvalRecord);
                if (rejectCount>0 || unAdoptCount>0){
                    repReplacementApprovalReturnDto.setFlag(true);
                }

            }
        }
        PageInfo<RepReplacementApprovalReturnDto> page = new PageInfo<RepReplacementApprovalReturnDto>(repReplacementApprovalReturnDtos);
        return page;
    }


    /**
     * 新车信息查询
     * @param newCarQueryDto 查询条件
     * @return
     */
    @Override
    public List<PsiNewCarOrderDto> queryNewCar(NewCarQueryDto newCarQueryDto) {
        PsiNewCarOrderEntity psiNewCarOrderEntity = new PsiNewCarOrderEntity();
        psiNewCarOrderEntity.setReservationId(newCarQueryDto.getReservationId());
        List<PsiNewCarOrderEntity> psiNewCarOrderEntities = newCarOrderDao.selectBySelective(psiNewCarOrderEntity);
        List<PsiNewCarOrderDto> newCar = new ArrayList<>();
        for (PsiNewCarOrderEntity newCarOrderEntity : psiNewCarOrderEntities) {
            PsiNewCarOrderDto psiNewCarOrderDto = new PsiNewCarOrderDto();
            BeanUtils.copyProperties(newCarOrderEntity,psiNewCarOrderDto);
            if(!StringUtil.isEmpty(newCarOrderEntity.getIsRightOrPoints())){
            	//权益
            	if(newCarOrderEntity.getIsRightOrPoints().equals(Constants.IsRightOrPoints.RIGHT.value())){
            		String campaignName = this.replacementDao.getCampaignName(newCarQueryDto.getReservationId());
            		psiNewCarOrderDto.setRightActivityName(campaignName);
            	}else{
            		//积分
            		Integer pointsValue = this.replacementDao.getPointsValue(newCarQueryDto.getReservationId());
            		if(pointsValue != null){
            			psiNewCarOrderDto.setPointsValue(pointsValue);
            		}
            	}
            }
            //手机号、身份证解密
            try {
                if (StringUtils.isNotBlank(psiNewCarOrderDto.getMainUserPhone())){
                    psiNewCarOrderDto.setMainUserPhone(AesUtils.decryptHex(psiNewCarOrderDto.getMainUserPhone(),ucmpAesConfig.getSecret()));
                }
                psiNewCarOrderDto.setOwnerPhone(AesUtils.decryptHex(psiNewCarOrderDto.getOwnerPhone(),ucmpAesConfig.getSecret()));
                psiNewCarOrderDto.setOwnerCardNo(AesUtils.decryptHex(psiNewCarOrderDto.getOwnerCardNo(),ucmpAesConfig.getSecret()));
            } catch (Exception e) {
                LOGGER.info("==手机号、身份证解密异常==",e);
            }
            newCar.add(psiNewCarOrderDto);
        }

        return newCar;
    }




    /**
     * Description: 旧车信息查询
     * @param psiCustomerCarsQueryDto 查询条件
     * @return 实体集合
     */
    @Override
    public List<PsiCustomerCarsDto> queryOldCar(PsiCustomerCarsQueryDto psiCustomerCarsQueryDto) {
        return replacementDao.selectOldCar(psiCustomerCarsQueryDto);
    }



    /**
     * Description: 材料列表
     * @param repReplacementMaterialQueryDto 材料列表
     * @return 实体集合
     */
    @Override
    public List<RepReplacementMaterialDto> materialSort(RepReplacementMaterialQueryDto repReplacementMaterialQueryDto) {
        List<RepReplacementMaterialDto> repReplacementMaterialDtos = replacementDao.selectMaterial(repReplacementMaterialQueryDto);
        for (RepReplacementMaterialDto repReplacementMaterialDto : repReplacementMaterialDtos) {
            RepReplacementMaterialFileEntity repReplacementMaterialFileEntity = new RepReplacementMaterialFileEntity();
            repReplacementMaterialFileEntity.setMaterialId(repReplacementMaterialDto.getMaterialId());
            List<RepReplacementMaterialFileEntity> repReplacementMaterialFileEntities = iRepReplacementMaterialFileDao.selectBySelective(repReplacementMaterialFileEntity);
            repReplacementMaterialDto.setRepReplacementMaterialFileEntity(repReplacementMaterialFileEntities);
        }
        return repReplacementMaterialDtos;
    }

    /**
     * Description: 文件列表
     * @param sysFileMsgQueryDto 查询条件
     * @return 实体集合
     */
    @Override
    public List<SysFileMsgDto> queryFileList(SysFileMsgQueryDto sysFileMsgQueryDto){
        SysFileMsgEntity sysFileMsgEntity = new SysFileMsgEntity();
        sysFileMsgEntity.setFileId(sysFileMsgQueryDto.getFileId());
        List<SysFileMsgDto> fileMsg = new ArrayList<>();
        List<SysFileMsgEntity> sysFileMsgEntities = iSysFileMsgDao.selectBySelective(sysFileMsgEntity);

        for (SysFileMsgEntity fileMsgEntity : sysFileMsgEntities) {
            SysFileMsgDto sysFileMsgDto = new SysFileMsgDto();
            BeanUtils.copyProperties(fileMsgEntity,sysFileMsgDto);
            fileMsg.add(sysFileMsgDto);
        }

        return fileMsg;
    }


    /**
     * Description: 审批/旧车确认
     * @param approvalUpdateDto 查询条件
     * @return 审批
     * @throws Exception 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void approval(ApprovalUpdateDto approvalUpdateDto) throws Exception{

        //修改车商询价表审批状态
        UpdateInquiryApprovalStatusDto updateInquiryApprovalStatusDto = new UpdateInquiryApprovalStatusDto();
        //修改车辆收购表审批状态
        PsiCarAcquisitionEntity psiCarAcquisitionEntity = new PsiCarAcquisitionEntity();
        //置换审批记录
        RepReplacementApprovalRecordEntity repReplacementApprovalRecordEntity = new RepReplacementApprovalRecordEntity();
        //置换审批
        RepReplacementApprovalEntity repReplacementApprovalEntity = new RepReplacementApprovalEntity();
        repReplacementApprovalRecordEntity.generatePk();
        repReplacementApprovalRecordEntity.setReplacementId(approvalUpdateDto.getReplacementId());
        repReplacementApprovalRecordEntity.setApprovalResult(approvalUpdateDto.getApprovalResult());
        repReplacementApprovalRecordEntity.setApprovalDate(new Date());
        //获取审批人
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        repReplacementApprovalRecordEntity.setApprovalPerson(user.getPartyId());
        String approvalName = replacementDao.selectApprovalName(user.getPartyId());
        if (Objects.nonNull(approvalName)){
            repReplacementApprovalRecordEntity.setApprovalPersonName(approvalName);
        }else {
            repReplacementApprovalRecordEntity.setApprovalPersonName(user.getLoginName());
        }
        //获取上报时间
        repReplacementApprovalEntity.setReplacementId(approvalUpdateDto.getReplacementId());
        List<RepReplacementApprovalEntity> repReplacementApprovalEntities = iRepReplacementApprovalDao.selectBySelective(repReplacementApprovalEntity);
        repReplacementApprovalRecordEntity.setReportingDate(repReplacementApprovalEntities.get(0).getReportingDateEnd());
        repReplacementApprovalRecordEntity.setApprovalRemark(approvalUpdateDto.getApprovalRemark());

        if (!StringUtil.isEmpty(approvalUpdateDto.getReplacementStatusBefore())){
            repReplacementApprovalRecordEntity.setReplacementBeforeStatus(approvalUpdateDto.getReplacementStatusBefore());
        }
        //插入审批记录表
        iRepReplacementApprovalRecordDao.insertSelective(repReplacementApprovalRecordEntity);
        if (Constants.approvalResult.adopt.value().equals(approvalUpdateDto.getApprovalResult())){
            repReplacementApprovalEntity.setApprovalStatus(Constants.approvalStatus.approval.value());
            repReplacementApprovalEntity.setOldCarConfirmSign(Constants.oldCarConfirme.confirme.value());
            repReplacementApprovalEntity.setApprovalDateEnd(new Date());
            updateInquiryApprovalStatusDto.setApprovalStatus(Constants.approvalStatus.approval.value());
            psiCarAcquisitionEntity.setApprovalStatus(Constants.approvalStatus.approval.value());
            //进行权益相关判断
            if(approvalUpdateDto.getRightActivitie() != null ){
            	if(1 == approvalUpdateDto.getRightActivitie().intValue()&&(approvalUpdateDto.getRightId() !=null || approvalUpdateDto.getPointsValue() >=0)){
            		try {
            			pushActivities(approvalUpdateDto.getReservationId(),approvalUpdateDto.getBusinessClassify(),approvalUpdateDto.getRightId(),approvalUpdateDto.getPointsValue());
            		} catch (Exception e) {
            			LOGGER.error("根据预约ID没有找到对应的新车订单数据",e);
            		}
                //修改审批状态权益发放标志为发放
                repReplacementApprovalEntity.setRightsIssueSign("01");
            }else if(0 == approvalUpdateDto.getRightActivitie()){
                //修改审批状态权益发放标志为不发放
                repReplacementApprovalEntity.setRightsIssueSign("02");
            }else{
            	throw new Exception("请选择权益包/输入积分值");
            }
            }
        }
        if (Constants.approvalResult.unAdopt.value().equals(approvalUpdateDto.getApprovalResult())){
            repReplacementApprovalEntity.setApprovalStatus(Constants.approvalStatus.reject.value());
            updateInquiryApprovalStatusDto.setApprovalStatus(Constants.approvalStatus.reject.value());
            psiCarAcquisitionEntity.setApprovalStatus(Constants.approvalStatus.reject.value());
        }
        if (Constants.approvalResult.close.value().equals(approvalUpdateDto.getApprovalResult())){
            repReplacementApprovalEntity.setApprovalStatus(Constants.approvalStatus.close.value());
            PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
            psiCustomerReservationTrackEntity.setReservationId(approvalUpdateDto.getReservationId());
            psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.closed.value());
            psiCustomerReservationTrackEntity.setShutDate(new Date());
            psiCustomerReservationTrackEntity.setShutDescribe(approvalUpdateDto.getApprovalRemark());
            iPsiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
            updateInquiryApprovalStatusDto.setApprovalStatus(Constants.approvalStatus.close.value());
            psiCarAcquisitionEntity.setApprovalStatus(Constants.approvalStatus.close.value());
        }
        if (Constants.approvalResult.confirmed.value().equals(approvalUpdateDto.getApprovalResult())){
            repReplacementApprovalEntity.setApprovalStatus(Constants.approvalStatus.confirmed.value());
            repReplacementApprovalEntity.setOldCarConfirmSign(Constants.oldCarConfirme.confirme.value());
            updateInquiryApprovalStatusDto.setApprovalStatus(Constants.approvalStatus.confirmed.value());
            psiCarAcquisitionEntity.setApprovalStatus(Constants.approvalStatus.confirmed.value());
            repReplacementApprovalEntity.setOldCarConfirmationTime(new Date());
        }
        if (Constants.approvalResult.reject.value().equals(approvalUpdateDto.getApprovalResult())){
            repReplacementApprovalEntity.setApprovalStatus(Constants.approvalStatus.reject.value());
            repReplacementApprovalEntity.setOldCarConfirmSign(Constants.oldCarConfirme.unConfirme.value());
            updateInquiryApprovalStatusDto.setApprovalStatus(Constants.approvalStatus.reject.value());
            psiCarAcquisitionEntity.setApprovalStatus(Constants.approvalStatus.reject.value());
        }
        repReplacementApprovalEntity.setApprovalDateEnd(repReplacementApprovalRecordEntity.getApprovalDate());
        repReplacementApprovalEntity.setUpdatedDate(new Date());

        //修改审批状态，最后审批时间
        iRepReplacementApprovalDao.updateSelective(repReplacementApprovalEntity);
        //修改审批状态,车商询价表审批状态修改
        updateInquiryApprovalStatusDto.setReservationId(approvalUpdateDto.getReservationId());
        approvalStatus.updateInquiryApprovalStatus(updateInquiryApprovalStatusDto);
        //修改收购表状态
        psiCarAcquisitionEntity.setReservationId(approvalUpdateDto.getReservationId());
        psiCarAcquisitionEntity.setUpdatedDate(new Date());
        iPsiCarAcquisitionDao.updateSelective(psiCarAcquisitionEntity);

        if (Constants.approvalResult.unAdopt.value().equals(approvalUpdateDto.getApprovalResult())
                || Constants.approvalResult.reject.value().equals(approvalUpdateDto.getApprovalResult())){
            //获取业务编号
            PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
            psiCustomerReservationTrackEntity.setReservationId(approvalUpdateDto.getReservationId());
            List<PsiCustomerReservationTrackEntity> psiCustomerReservationTrackEntities = iPsiCustomerReservationTrackDao.selectBySelective(psiCustomerReservationTrackEntity);

            //获取车商人员id
            PsiCarDealerInquiryEntity psiCarDealerInquiryEntity = new PsiCarDealerInquiryEntity();
            psiCarDealerInquiryEntity.setInquiryId(psiCustomerReservationTrackEntities.get(0).getOtherBrandInquiryId());
            List<PsiCarDealerInquiryEntity> psiCarDealerInquiryEntities = iPsiCarDealerInquiryDao.selectBySelective(psiCarDealerInquiryEntity);

            //获取车商人员电话
            SysPartnerStaffInfoEntity sysPartnerStaffInfoEntity = new SysPartnerStaffInfoEntity();
            sysPartnerStaffInfoEntity.setPartyId(psiCarDealerInquiryEntities.get(0).getCarDealerStaffId());
            List<SysPartnerStaffInfoEntity> sysPartnerStaffInfoEntities = sysPartnerStaffInfoDao.selectBySelective(sysPartnerStaffInfoEntity);


            SmsParamsDto smsParamsDto = new SmsParamsDto();
            smsParamsDto.setTemplateParas(new String[]{psiCustomerReservationTrackEntities.get(0).getBusinessOrderNo()});
            smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageNinth.value());
            //手机号解密
            try {
                String phone = AesUtils.decryptHex(sysPartnerStaffInfoEntities.get(0).getPartnerStaffIphone(),ucmpAesConfig.getSecret());
                smsParamsDto.setTo(phone);
            } catch (Exception e) {
                LOGGER.info("手机号解密失败");
            }

            sendSmsFegin.batchSendSms(smsParamsDto);

        }

    }

    //权益包推送
    private void pushActivities(Long reservationId,String businessClassify, Long rightId, Integer pointsValue) throws Exception {
    	Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiNewCarOrderEntity newCarOrderEntity = new PsiNewCarOrderEntity();
        newCarOrderEntity.setReservationId(reservationId);
        List<PsiNewCarOrderEntity> psiNewCarOrderEntities = newCarOrderDao.selectBySelective(newCarOrderEntity);
        if(CollectionUtils.isNotEmpty(psiNewCarOrderEntities)){
            LOGGER.info("====[权益发放]找到的新车订单记录条数:{},reservation_id{}",psiNewCarOrderEntities.size(),reservationId);
            PsiNewCarOrderEntity carOrderEntity = psiNewCarOrderEntities.get(0);
            if(StringUtil.isEmpty(carOrderEntity.getMainUserPhone())){
            	throw new Exception("发放权益/积分失败，新车主用车人手机号为空");
            }
          //根据新车主用车人手机号查询 UID
        	String customerPhone = AesUtils.decryptHex(carOrderEntity.getMainUserPhone(), ucmpAesConfig.getSecret());
        	String uid = getUid(customerPhone);
            if (StringUtils.isEmpty(uid)) {
                throw new IllegalParameterException("获取该客户UID失败");
            }
            //查询客户id信息
            PsiCustomerReservationTrackEntity customerReservationEntity = iPsiCustomerReservationTrackDao.load(new PsiCustomerReservationTrackPk(reservationId));
            PsiCustomerBasicInformationEntity basicInfor = iPsiCustomerBasicInformationDao.load(new PsiCustomerBasicInformationPk(customerReservationEntity.getCustomerId()));
            if(Objects.isNull(customerReservationEntity) || Objects.isNull(basicInfor)){
        		LOGGER.error("====[权益发放]没有找到该预约id对应的客户信息,预约id{}",reservationId);
        		throw new Exception("未找到该置换对应的客户信息");
        	}
            if(rightId != null){
	            //根据新车的工程车型和基础车型查询对应的权益活动
	            //官二销售:3103  置换：3102
	            String campaignType = businessClassify.equals("1601")?"3102":"3103";
//	            List<SysRightActivitiesEntity> rightActivitiesEntities = sysRightActivitiesDao.selectByModelAndShapeCode(carOrderEntity.getCarSeriesCode(), carOrderEntity.getCarTypeCode(),campaignType);
//	            if(CollectionUtils.isNotEmpty(rightActivitiesEntities)){
//	            LOGGER.info("====[权益发放]匹配到权益活动数:{}",rightActivitiesEntities.size());
//	            SysRightActivitiesEntity activitiesEntity = rightActivitiesEntities.get(0);
	            SysRightActivitiesEntity activitiesEntity = sysRightActivitiesDao.getActivitiesByRightPackId(rightId,campaignType);
	            if(activitiesEntity != null){
	            	LOGGER.info("====[权益发放]权益包信息"+JsonBeanUtil.beanToJson(activitiesEntity));
            		//发放权益包
            		RightsGrantDto grantDto = new RightsGrantDto();
            		grantDto.setRightPackId(activitiesEntity.getRightPackId());
//            		grantDto.setIdmId(basicInfor.getSid());
            		grantDto.setSuperId(uid);
            		grantDto.setVin(carOrderEntity.getNewCarVin());
            		RestResponse<Long> rightsGrant = activitiesFegin.rightsGrant(grantDto);
            		LOGGER.info("====[权益发放]activitiesFegin.rightsGrant调用接口返回:{}", JSON.toJSONString(rightsGrant));
            		if(RestStatusCode.OK.code() == rightsGrant.getCode()){
            			//同时权益活动发放明细表新增一条数据
            			SysRightActivitiesDistributeDetailsEntity distributeDetailsEntity = new SysRightActivitiesDistributeDetailsEntity();
            			distributeDetailsEntity.generatePk();
            			distributeDetailsEntity.setReservationId(reservationId);
            			distributeDetailsEntity.setRightPackId(activitiesEntity.getRightPackId());
            			distributeDetailsEntity.setRightGrantId(rightsGrant.getResult());
            			distributeDetailsEntity.setCustomerName(carOrderEntity.getMainUserName());
            			distributeDetailsEntity.setCustomerIphone(carOrderEntity.getMainUserPhone());
            			distributeDetailsEntity.setDistributeDate(new Date());
            			distributeDetailsEntity.setCampaignName(activitiesEntity.getCampaignName());
            			distributeDetailsEntity.setCreatedBy(user.getPartyId());
            			distributeDetailsEntity.setUpdatedBy(user.getPartyId());
            			iSysRightActivitiesDistributeDetailsDao.insertSelective(distributeDetailsEntity);
            		}
	            }else{
//	            	LOGGER.error("====[权益发放]没有找到该车型对应的权益活动,model_code{},shape_code{}",carOrderEntity.getCarSeriesCode(),carOrderEntity.getCarTypeCode());
	            	LOGGER.error("====[权益发放]没有找到该车型对应的权益活动,rightId{}",rightId);
	            }
            }else if (pointsValue !=null && pointsValue>0 ){
            	RestResponse<String> result = pointsFegin.urmGrantPoints(pointsValue, uid);
            	LOGGER.info("====[积分发放]调用接口返回:{}", JSON.toJSONString(result));
            	if(RestStatusCode.OK.code() == result.getCode()){
            		UrmGrantReturnDto returnDto = JsonBeanUtil.jsonToBean(result.getResult(), UrmGrantReturnDto.class);
            		//添加积分发放记录
            		GrantPointsDto grantPointsDto = new GrantPointsDto();
            		grantPointsDto.setRecordId(RandomIDGennerator.get().generate());
            		grantPointsDto.setReservationId(reservationId);
            		grantPointsDto.setPointsValue(pointsValue);
            		if(returnDto.isSuccess()){
            			grantPointsDto.setResult("成功");
            			grantPointsDto.setStateDesc(returnDto.getData());
            		}else{
            			grantPointsDto.setResult("失败");
            			grantPointsDto.setStateDesc(returnDto.getStateDesc());
            		}
            		grantPointsDto.setTraceId(returnDto.getTraceId());
            		grantPointsDto.setCreatedBy(user.getPartyId());
            		grantPointsDto.setUpdatedBy(user.getPartyId());
            		this.sysRightActivitiesDao.addRecordInfo(grantPointsDto);
            	}
            }else{
            	LOGGER.error("====[权益/积分发放]未选择权益包或输入积分值");
                throw new Exception("请选择权益包或输入积分值");
            }
        }else{
            LOGGER.error("====[权益/积分发放]根据预约ID没有找到对应的新车订单数据！reservation_id:" + reservationId);
            throw new Exception("根据预约ID没有找到对应的新车订单数据");
        }
    }
    
    private String getUid(String customerPhone) {
    	try {
            //查询UID
            RestResponse<String> stringRestResponse = systemFegin.urmUserUid(customerPhone);
            String uid = stringRestResponse.getResult();
            if (StringUtils.isNotEmpty(uid)) {
                return uid;
            }
            //注册
            RegAndLoginDto regAndLoginDto = new RegAndLoginDto();
            regAndLoginDto.setMobilePhone(customerPhone);
            RestResponse<String> stringRestResponse1 = systemFegin.mobilePhoneRegAndLogin(regAndLoginDto);
            return stringRestResponse1.getResult();
        }catch (Exception e){
            LOGGER.error("获取UID发生异常");
        }
        return null;
	}

	public static void main(String[] args) {
		String result ="{\"traceId\":\"TD770693019056738304-PointsTaskGrantInterface-169889978995931930\",\"respTime\":\"2023-11-02 12:36:30\",\"success\":true,\"stateCode\":1,\"data\":\"积分发放成功\",\"stateDesc\":null,\"stateDetail\":null,\"inner\":null}";
		UrmGrantReturnDto returnDto = JsonBeanUtil.jsonToBean(result, UrmGrantReturnDto.class);
		LOGGER.info("========"+returnDto.getStateDetail());
	}


    /**
     * Description: 审批历史
     * @param approvalHistoryDto 查询条件
     * @return 审批
     */

    public List<RepReplacementApprovalRecordDto> queryApprovalHistory(ApprovalHistoryDto approvalHistoryDto){
        return replacementDao.selectApprovalHistory(approvalHistoryDto);
    }

    /**
     * 置换单查询
     * @param paramsDto 查询条件
     * @return
     */
    @Override
    public PageInfo<ReplacementOrderQueryDto> selectReplacementOrder(ReplacementOrderQueryParamsDto paramsDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        paramsDto.setPartyId(user.getPartyId());
        paramsDto.setCluesSource(replacementDao.selectCodeByValue(paramsDto.getCluesSource()));
        PageHelper.startPage(paramsDto.getPageNum(), paramsDto.getPageSize());
        if (StringUtils.isNotBlank(paramsDto.getCustomerIphone())){
            paramsDto.setCustomerIphone(AesUtils.encryptHex(paramsDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
        }
        List<ReplacementOrderQueryDto> queryDtos;
        if(paramsDto.getBusinessType().equals(Constants.businessType.oneselfBrand.value())){
        	queryDtos = replacementDao.selectReplacementOrderNew(paramsDto);
        }else{
        	queryDtos = replacementDao.selectReplacementOrder(paramsDto);
        }
         
        if (CollectionUtils.isNotEmpty(queryDtos)){
            for (ReplacementOrderQueryDto replacementOrderQueryDto : queryDtos) {
                //手机号解密
                try {
                    replacementOrderQueryDto.setCustomerIphone(AesUtils.decryptHex(replacementOrderQueryDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                } catch (Exception e) {
                   LOGGER.error("====置换单查询手机号解密异常===",e);
                }

                //填充预约检测时间
                PsiCustomerReservationMsgPk psiCustomerReservationMsgPk = new PsiCustomerReservationMsgPk(replacementOrderQueryDto.getReservationId());
                PsiCustomerReservationMsgEntity customerReservationMsg = customerReservationMsgDao.load(psiCustomerReservationMsgPk);
                if (Objects.nonNull(customerReservationMsg)){
                    replacementOrderQueryDto.setReservationDetectionDate(customerReservationMsg.getReservationDetectionDate());
                }

                //填充门店名称
                SysStoreInfoPk sysStoreInfoPk = new SysStoreInfoPk(replacementOrderQueryDto.getStoreId());
                SysStoreInfoEntity sysStoreInfoEntity = sysStoreInfoDao.load(sysStoreInfoPk);
                if (Objects.nonNull(sysStoreInfoEntity)){
                    replacementOrderQueryDto.setStoreName(sysStoreInfoEntity.getOrgName());
                }
            }
        }
        return new PageInfo<>(queryDtos);
    }

    /**
     * 导出置换单查询
     * @param paramsDto
     */
    @Override
    public void replacementOrderExport(ReplacementOrderQueryParamsDto paramsDto, HttpServletResponse response) throws IOException, ParseException {
        PageInfo<ReplacementOrderQueryDto> queryDtoPageInfo = selectReplacementOrder(paramsDto);
        List<ReplacementOrderQueryDto> list = queryDtoPageInfo.getList();
        if (CollectionUtils.isNotEmpty(list)){

            for (ReplacementOrderQueryDto orderQueryDto : list) {

                //时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                if (Objects.nonNull(orderQueryDto.getCreatedDate())){
                    String format = simpleDateFormat.format(orderQueryDto.getCreatedDate());
                    orderQueryDto.setExCreatedDate(format);
                }
                if (Objects.nonNull(orderQueryDto.getReservationDetectionDate())){
                    String format = simpleDateFormat.format(orderQueryDto.getReservationDetectionDate());
                    orderQueryDto.setExReservationDetectionDate(format);
                }
                //来源
                if (orderQueryDto.getCluesSource().equals(Constants.cluesSource.EOS.value())){
                    orderQueryDto.setCluesSource("EOS");
                }else if (orderQueryDto.getCluesSource().equals(Constants.cluesSource.applets.value())){
                    orderQueryDto.setCluesSource("小程序");
                }else if (orderQueryDto.getCluesSource().equals(Constants.cluesSource.gaoheApp.value())){
                    orderQueryDto.setCluesSource("高合APP");
                }else if (orderQueryDto.getCluesSource().equals(Constants.cluesSource.pipeNetwork.value())){
                    orderQueryDto.setCluesSource("官网");
                }
            }

            EasyExcelUtils.webWriteExcel(response,list,ReplacementOrderExportDto.class,"置换单统计");
        }
    }
    
    @Override
	public void replacementOrderExportNew(ReplacementOrderQueryParamsDto paramsDto, HttpServletResponse response) throws Exception {
    	Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
    	LOGGER.info("========user====="+user.getPartyId());
    	LOGGER.info("========ucmpAesConfig.getWhite()====="+ucmpAesConfig.getWhite());
    	List<ReplacementOrderExportNewDto> queryDtoList = this.replacementDao.selectReplacementExportOrderNew(paramsDto);
    	if (CollectionUtils.isNotEmpty(queryDtoList)){
    		for (ReplacementOrderExportNewDto replacementOrderExportNewDto : queryDtoList) {
    			String customerIphone = AesUtils.decryptHex(replacementOrderExportNewDto.getCustomerIphone(), ucmpAesConfig.getSecret());
				if(ucmpAesConfig.getWhite().equals(user.getPartyId())){
					replacementOrderExportNewDto.setCustomerIphone(customerIphone);
				}else{
					replacementOrderExportNewDto.setCustomerIphone(ucmpAesConfig.dataMask(customerIphone, 3, 7, "****"));
				}
			}
            EasyExcelUtils.webWriteExcel(response,queryDtoList,ReplacementOrderExportNewDto.class,"置换单统计");
        }
	}

    /**
     * 置换审批导出
     * @param paramsDto
     * @param response
     * @throws IOException
     * @throws ParseException
     */
    @Override
    public void replacementApprovalExport(RepReplacementApprovalDto paramsDto, HttpServletResponse response) throws IOException, ParseException {
        List<RepReplacementApprovalReturnDto> dtoList ;
        //旧车确认导出
        if (paramsDto.getMark().equals(RepReplacementApprovalDto.markStatus.usedCarConfirmation.name())){
            dtoList = replacementDao.selectOldConfirm(paramsDto);
        }else {
            dtoList = replacementDao.selectReplaceApproval(paramsDto);
        }
        if (CollectionUtils.isNotEmpty(dtoList)){
            for (RepReplacementApprovalReturnDto approvalReturnDto : dtoList) {
                //手机号解密
                try {
                    approvalReturnDto.setOldCarCustomerIphone(AesUtils.decryptHex(approvalReturnDto.getOldCarCustomerIphone(),ucmpAesConfig.getSecret()));
                } catch (Exception e) {
                    LOGGER.error("===手机号解密异常===",e);
                }
                //时间格式
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                if (Objects.nonNull(approvalReturnDto.getCreatedDte())){
                    approvalReturnDto.setExCreatedDte(simpleDateFormat.format(approvalReturnDto.getCreatedDte()));
                }
                if (Objects.nonNull(approvalReturnDto.getApprovalDateEnd())){
                    approvalReturnDto.setExApprovalDateEnd(simpleDateFormat.format(approvalReturnDto.getApprovalDateEnd()));
                }
                //业务类型
                if (approvalReturnDto.getBusinessClassify().equals(Constants.businessLogo.substitution.value())){
                    approvalReturnDto.setBusinessClassify("他品");
                }
                if (approvalReturnDto.getBusinessClassify().equals(Constants.businessLogo.sale.value())){
                    approvalReturnDto.setBusinessClassify("本品");
                }
                //审批状态
                if (approvalReturnDto.getApprovalStatus().equals(Constants.approvalStatus.unConfirmed.value())){
                    approvalReturnDto.setApprovalStatus("待确认");
                }else if (approvalReturnDto.getApprovalStatus().equals(Constants.approvalStatus.confirmed.value())){
                    approvalReturnDto.setApprovalStatus("确认通过");
                }else if (approvalReturnDto.getApprovalStatus().equals(Constants.approvalStatus.unApproval.value())){
                    approvalReturnDto.setApprovalStatus("待审批");
                }else if (approvalReturnDto.getApprovalStatus().equals(Constants.approvalStatus.approval.value())){
                    approvalReturnDto.setApprovalStatus("审批通过");
                }else if (approvalReturnDto.getApprovalStatus().equals(Constants.approvalStatus.reject.value())){
                    approvalReturnDto.setApprovalStatus("驳回");
                }else if (approvalReturnDto.getApprovalStatus().equals(Constants.approvalStatus.close.value())){
                    approvalReturnDto.setApprovalStatus("关闭");
                }
            }
        }
        //旧车确认导出
        if (paramsDto.getMark().equals(RepReplacementApprovalDto.markStatus.usedCarConfirmation.name())){
            EasyExcelUtils.webWriteExcel(response,dtoList,RepReplacementApprovalOldCarExportDto.class,"置换审批统计");
        }else {
            EasyExcelUtils.webWriteExcel(response,dtoList,RepReplacementApprovalExportDto.class,"置换审批统计");
        }

    }

    @Override
	public ReplaceDetailsDto getReplaceDetails(Long reservationId) {
		//查询客户信息
		ReplaceDetailsDto dto=this.replacementDao.getReplaceDetails(reservationId);
		LOGGER.info("==dto==="+JsonBeanUtil.beanToJson(dto));
		if(dto != null){
			try {
				dto.setCustomerIphone(AesUtils.decryptHex(dto.getCustomerIphone(),ucmpAesConfig.getSecret()));
			} catch (Exception e) {
				LOGGER.error("===手机号解密异常===",e);
			}
			if(dto.getBusinessType().equals(Constants.businessType.otherBrand.value())){
				dto.setApprovalStatus(null);
				dto.setApprovalName(null);
			}
			//旧车信息
			OldCarInfoDto oldCarInfoDto=this.replacementDao.getOldCarInfo(reservationId);
			dto.setOldCarInfoDto(oldCarInfoDto);
			//接单记录
			List<TakeOrdersDto> takeOrdersDto=this.replacementDao.getTakeOrders(reservationId);
			dto.setTakeOrdersDto(takeOrdersDto);
			//报价记录
			List<QuoteRecordDto> quoteRecordDto=this.replacementDao.getQuoteRecord(reservationId);
			dto.setQuoteRecordDto(quoteRecordDto);
			//收购记录
			List<AcquisitionRecordDto> acquisitionRecordDto=this.replacementDao.getAcquisitionRecord(reservationId);
			dto.setAcquisitionRecordDto(acquisitionRecordDto);
		}
		return dto;
	}
    
    @Override
	public ReplaceDetailsNewDto getReplaceDetailsNew(Long reservationId) throws Exception {
    	ReplaceDetailsNewDto newDto= new ReplaceDetailsNewDto();
    	//查询客户信息
		ReplaceDetailsDto dto=this.replacementDao.getReplaceDetails(reservationId);
		if (Objects.nonNull(dto)){
            try {
                dto.setCustomerIphone(AesUtils.decryptHex(dto.getCustomerIphone(),ucmpAesConfig.getSecret()));
            } catch (Exception e) {
               LOGGER.error("===手机号解密异常===",e);
            }
            BeanUtils.copyProperties(dto, newDto);
        }
		LOGGER.info("==dto==="+JsonBeanUtil.beanToJson(dto));
		if(dto != null){
			//旧车信息
			OldCarInfoDto oldCarInfoDto=this.replacementDao.getOldCarInfoNew(reservationId);
			newDto.setOldCarInfoDto(oldCarInfoDto);
			PsiOrderReceivingRecordEntity entity=new PsiOrderReceivingRecordEntity();
			entity.setReservationId(reservationId);
			//新车信息
			PsiNewCarOrderDto psiNewCarOrderDto =this.replacementDao.selectNewCarOrderInfo(reservationId);
			if(psiNewCarOrderDto != null){
				if(StringUtils.isNotEmpty(psiNewCarOrderDto.getMainUserPhone())){
					psiNewCarOrderDto.setMainUserPhone(AesUtils.decryptHex(psiNewCarOrderDto.getMainUserPhone(),ucmpAesConfig.getSecret()));
				}
				if(StringUtils.isNotEmpty(psiNewCarOrderDto.getOwnerPhone())){
					psiNewCarOrderDto.setOwnerPhone(AesUtils.decryptHex(psiNewCarOrderDto.getOwnerPhone(),ucmpAesConfig.getSecret()));
				}
				if(StringUtils.isNotEmpty(psiNewCarOrderDto.getOwnerCardNo())){
					psiNewCarOrderDto.setOwnerCardNo(AesUtils.decryptHex(psiNewCarOrderDto.getOwnerCardNo(),ucmpAesConfig.getSecret()));
				}
				newDto.setNewCarOrderDto(psiNewCarOrderDto);
			}
			//接单记录
			entity.setRecordType("01");
			List<PsiOrderReceivingRecordEntity> takeOrdersDto=this.iPsiOrderReceivingRecordDao.selectBySelective(entity);
			newDto.setTakeOrdersDto(takeOrdersDto);
			//报价记录
			entity.setRecordType("02");
			List<PsiOrderReceivingRecordEntity> quoteRecordDto=this.iPsiOrderReceivingRecordDao.selectBySelective(entity);
			newDto.setQuoteRecordDto(quoteRecordDto);
			//收购记录
			entity.setRecordType("03");
			List<PsiOrderReceivingRecordEntity> acquisitionRecordDto=this.iPsiOrderReceivingRecordDao.selectBySelective(entity);
			newDto.setAcquisitionRecordDto(acquisitionRecordDto);
		}
		return newDto;
	}

    @Override
    public List<AcquisitionAllFileDto> getReplaceDetailsPic(Long reservationId) {
        List<AcquisitionAllFileDto> list = new ArrayList<>();
        PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
        materialEntity.setReservationId(reservationId);
        List<PsiAcquisitionMaterialEntity> materialList = materialDao.selectBySelective(materialEntity);
        if (CollectionUtils.isNotEmpty(materialList)){
            for (PsiAcquisitionMaterialEntity material : materialList) {
                AcquisitionAllFileDto acquisitionAllFileDto = new AcquisitionAllFileDto();
                acquisitionAllFileDto.setMaterialId(material.getMaterialId());
                acquisitionAllFileDto.setMaterialType(material.getMaterialType());
                acquisitionAllFileDto.setReservationId(reservationId);
                PsiAcquisitionMaterialFileEntity file = new PsiAcquisitionMaterialFileEntity();
                file.setMaterialId(material.getMaterialId());
                List<PsiAcquisitionMaterialFileEntity> fileList = fileDao.selectBySelective(file);
                acquisitionAllFileDto.setMaterialFileEntityList(fileList);
                list.add(acquisitionAllFileDto);
            }
        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean activate(Long reservationId) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiCarDealerInquiryEntity inquiryQuery = new PsiCarDealerInquiryEntity();
        inquiryQuery.setReservationId(reservationId);
        List<PsiCarDealerInquiryEntity> inquiry = iPsiCarDealerInquiryDao.selectBySelective(inquiryQuery);
        //查询单子的业务类型
        String businessType = this.replacementDao.getBusinessType(reservationId);

        //报价战败
        if (Constants.inquiryStatus.abandonOffer.value().equals(inquiry.get(0).getInquiryStatus())
        || Constants.inquiryStatus.overdueUnOffer.value().equals(inquiry.get(0).getInquiryStatus())){
        	LOGGER.info("===报价战败激活===");
            PsiCarDealerInquiryEntity entity = inquiry.get(0);
            entity.setInquiryStatus(Constants.inquiryStatus.unOffer.value());
            entity.setQuoteDeadline(null);
            entity.setUpdatedBy(user.getPartyId());
            entity.setOrderAbandonedReason(Strings.EMPTY);
            entity.setUpdatedDate(new Date());
            int cdi = iPsiCarDealerInquiryDao.update(entity);
            PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
            psiCustomerReservationTrackEntity.setReservationId(reservationId);
            PsiCustomerReservationTrackEntity load = iPsiCustomerReservationTrackDao.load(new PsiCustomerReservationTrackPk(reservationId));
            load.setTrackStatus(Constants.trackStatus.testing.value());
            load.setQuoteDeadline(null);
            load.setShutCause(null);
            load.setShutCauseDetails(null);
            load.setShutDescribe(null);
            load.setShutDate(null);
            load.setUpdatedBy(user.getPartyId());
            load.setUpdatedDate(new Date());
            int crt = iPsiCustomerReservationTrackDao.update(load);
            if (cdi >0 && crt>0){
            	if( businessType.equals(Constants.businessType.otherBrand.value())){
            		send(entity.getCarDealerStaffId());
            	}else{
            		//本品收购添加接单记录
                	PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
                	psiOrderReceivingRecordEntity.generatePk();
                	psiOrderReceivingRecordEntity.setOperation("激活");
                	psiOrderReceivingRecordEntity.setOrderStatus("待评估");
                	psiOrderReceivingRecordEntity.setRecordType("02");
                	psiOrderReceivingRecordEntity.setReservationId(reservationId);
                	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
                	psiOrderReceivingRecordEntity.setOperationDate(new Date());
                	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
            	}
                return true;
            }
            //收购战败
        }else if (Constants.inquiryStatus.abandonAcquisition.value().equals(inquiry.get(0).getInquiryStatus())){
        	 //修改预约跟踪表状态
            PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
            psiCustomerReservationTrackEntity.setReservationId(reservationId);
            PsiCustomerReservationTrackEntity load = iPsiCustomerReservationTrackDao.load(new PsiCustomerReservationTrackPk(reservationId));
            if( businessType.equals(Constants.businessType.otherBrand.value())){
            	load.setTrackStatus(Constants.trackStatus.completed.value());
        	}else{
        		load.setTrackStatus(Constants.trackStatus.testing.value());
        	}
            
            load.setShutCause(null);
            load.setShutCauseDetails(null);
            load.setShutDescribe(null);
            load.setShutDate(null);
            load.setUpdatedBy(user.getPartyId());
            load.setUpdatedDate(new Date());
            int crt = iPsiCustomerReservationTrackDao.update(load);
        	
        	LOGGER.info("===收购战败激活===");
            PsiCarDealerInquiryEntity psiCarDealerInquiryEntity = new PsiCarDealerInquiryEntity();
            psiCarDealerInquiryEntity.setInquiryId(inquiry.get(0).getInquiryId());
            psiCarDealerInquiryEntity.setReservationId(reservationId);
            if(load.getBusinessType().equals(Constants.businessType.oneselfBrand.value())){
            	psiCarDealerInquiryEntity.setInquiryStatus(Constants.inquiryStatus.unAllotDeliveryCenter.value());//待分配交付中心
            }else{
            	psiCarDealerInquiryEntity.setInquiryStatus(Constants.inquiryStatus.unAcquired.value());//待收购
            }
            psiCarDealerInquiryEntity.setOrderAbandonedReason(Strings.EMPTY);
            psiCarDealerInquiryEntity.setUpdatedBy(user.getPartyId());
            psiCarDealerInquiryEntity.setUpdatedDate(new Date());
            int cdi = iPsiCarDealerInquiryDao.updateSelective(psiCarDealerInquiryEntity);
        	if( businessType.equals(Constants.businessType.otherBrand.value())){
	            //修改收购状态
	            PsiCarAcquisitionEntity psiCarAcquisitionEntity = new PsiCarAcquisitionEntity();
	            psiCarAcquisitionEntity.setReservationId(reservationId);
	            psiCarAcquisitionEntity.setAcquisitionAbandonedReason(Strings.EMPTY);
	            psiCarAcquisitionEntity.setAcquisitionStatus(Constants.acquisitionStatus.unAcquired.value());
	            psiCarAcquisitionEntity.setUpdatedBy(user.getPartyId());
	            psiCarAcquisitionEntity.setUpdatedDate(new Date());
	            int ca = iPsiCarAcquisitionDao.updateSelective(psiCarAcquisitionEntity);
	            if (cdi >0 && ca>0 && crt>0) {
	            		send(inquiry.get(0).getCarDealerStaffId());
	                return true;
	            }
        	}else{
        		if (cdi >0 && crt>0) {
        			//本品收购添加接单记录
                	PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
                	psiOrderReceivingRecordEntity.generatePk();
                	psiOrderReceivingRecordEntity.setOperation("激活");
                	psiOrderReceivingRecordEntity.setOrderStatus("待分配");
                	psiOrderReceivingRecordEntity.setRecordType("02");
                	psiOrderReceivingRecordEntity.setReservationId(reservationId);
                	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
                	psiOrderReceivingRecordEntity.setOperationDate(new Date());
                	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
        			return true;
        		}
        	}
            //待接单
        }else if(Constants.inquiryStatus.abandonOrderReceiving.value().equals(inquiry.get(0).getInquiryStatus())){
        	LOGGER.info("===待接单放弃激活===");
        	PsiCarDealerInquiryEntity entity = inquiry.get(0);
            entity.setInquiryStatus(Constants.inquiryStatus.unOrderReceiving.value());//待接单
            entity.setQuoteDeadline(null);
            entity.setUpdatedBy(user.getPartyId());
            entity.setOrderAbandonedReason(Strings.EMPTY);
            entity.setUpdatedDate(new Date());
            int cdi = iPsiCarDealerInquiryDao.update(entity);
            PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
            psiCustomerReservationTrackEntity.setReservationId(reservationId);
            PsiCustomerReservationTrackEntity load = iPsiCustomerReservationTrackDao.load(new PsiCustomerReservationTrackPk(reservationId));
            load.setTrackStatus(Constants.trackStatus.assigned.value());//已分配
            load.setQuoteDeadline(null);
            load.setShutCause(null);
            load.setShutCauseDetails(null);
            load.setShutDescribe(null);
            load.setShutDate(null);
            load.setUpdatedBy(user.getPartyId());
            load.setUpdatedDate(new Date());
            int crt = iPsiCustomerReservationTrackDao.update(load);
            if (cdi >0 && crt>0){
            	if( businessType.equals(Constants.businessType.otherBrand.value())){
            		send(entity.getCarDealerStaffId());
            	}else{
            		//本品收购添加接单记录
                	PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
                	psiOrderReceivingRecordEntity.generatePk();
                	psiOrderReceivingRecordEntity.setOperation("激活");
                	psiOrderReceivingRecordEntity.setOrderStatus("待接单");
                	psiOrderReceivingRecordEntity.setRecordType("01");
                	psiOrderReceivingRecordEntity.setReservationId(reservationId);
                	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
                	psiOrderReceivingRecordEntity.setOperationDate(new Date());
                	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
            	}
                return true;
            }
        }
        return false;
    }

    private void send(Long partyId){
        //激活后发送短信
        SmsParamsDto smsParamsDto = new SmsParamsDto();
        smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageThird.value());
        SysPartnerStaffInfoEntity staffInfoEntity = new SysPartnerStaffInfoEntity();
        staffInfoEntity.setPartyId(partyId);
        List<SysPartnerStaffInfoEntity> staffInfoEntities = sysPartnerStaffInfoDao.selectBySelective(staffInfoEntity);
        if (CollectionUtils.isEmpty(staffInfoEntities)) {
            throw new IllegalParameterException("未查到对应车商");
        } else {
            if (Objects.nonNull(staffInfoEntities.get(0).getPartnerStaffIphone())){
                String value = staffInfoEntities.get(0).getPartnerStaffIphone();
                //解密
                try {
                    value = AesUtils.decryptHex(value,ucmpAesConfig.getSecret());
                } catch (Exception e) {
                    LOGGER.error("=====激活后发送短信异常=====",e);
                }
                smsParamsDto.setTo(value);
                sendSmsFegin.batchSendSms(smsParamsDto);
            }else {
                throw new IllegalParameterException("手机号为空");
            }

        }
    }

	@Override
	public OneselfAssessPicsDto getHipiReplaceDetailsPic(Long reservationId) {
		OneselfAssessPicsDto picsDto = new OneselfAssessPicsDto();
		List<String> typeList=new ArrayList<>();
		//查询评估车辆图片
		typeList.add("9009");
		typeList.add("9010");
		List<OneselfCarPicDto> carAssessPicList = this.replacementDao.queryPic(reservationId,typeList);
		this.appendUrl(carAssessPicList);
		picsDto.setCarAssessPicList(carAssessPicList);
		typeList.clear();
		//查询检测报告
		typeList.add("9011");
		List<OneselfCarPicDto> testReportList = this.replacementDao.queryPic(reservationId,typeList);
		this.appendUrl(testReportList);
		picsDto.setTestReportList(testReportList);
		typeList.clear();
		return picsDto;
	}
	
	private void appendUrl(List<OneselfCarPicDto> picDtoList) {
		if(picDtoList != null && !picDtoList.isEmpty()){
			for (OneselfCarPicDto oneselfCarPicDto : picDtoList) {
				oneselfCarPicDto.setFileUrl(hwOBSConfig.getFileUri()+oneselfCarPicDto.getFileUrl());
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveTransactionPrice(SaveTransactionPriceDto dto) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		dto.setUpdateBy(user.getPartyId());
		//更新最终成交价
		this.replacementDao.updateInquiry(dto);
		this.replacementDao.updateAcquisition(dto);
		//更新客户车辆表
		OneselfApproveDto oneselfApproveDto=new OneselfApproveDto();
		oneselfApproveDto.setRevertBody(dto.getRevertBody());
		oneselfApproveDto.setUpdateBy(user.getPartyId());
		oneselfApproveDto.setReservationId(dto.getReservationId());
		this.replacementDao.updateCustomerCars(oneselfApproveDto);
		
		PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
  		psiCustomerReservationTrackEntity.setReservationId(dto.getReservationId());
  		psiCustomerReservationTrackEntity.setUpdatedBy(user.getPartyId());
  		psiCustomerReservationTrackEntity.setUpdatedDate(new Date());
  		if(dto.getDealPriceEnd()!=null){
  			psiCustomerReservationTrackEntity.setDealPriceEnd(dto.getDealPriceEnd().longValue());
  		}
  		this.iPsiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
		//更新付款凭证
		if(dto.getPicDto() != null && !dto.getPicDto().isEmpty()){
			//本品收购材料保存
    		List<PsiAcquisitionMaterialEntity> materialEntityList = new ArrayList<>();
			for (PicDto picDto : dto.getPicDto()) {
				PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
				PsiAcquisitionMaterialEntity query = new PsiAcquisitionMaterialEntity();
				query.setMaterialType(picDto.getMaterialType());
				query.setReservationId(dto.getReservationId());
				materialDao.deleteBySelective(query);
				
				materialEntity.setMaterialId(picDto.getMaterialId());
				materialEntity.setMaterialType(picDto.getMaterialType());
				materialEntity.setReservationId(dto.getReservationId());
				materialEntity.setUploadDate(new Date());
				materialEntity.setUploadPerson(user.getPartyId());
				materialEntityList.add(materialEntity);
			}
			
            materialDao.batchInsert(materialEntityList);
		}else{
			//如果审批时平款凭证为空,清空付款凭证
			PsiAcquisitionMaterialEntity query = new PsiAcquisitionMaterialEntity();
			query.setMaterialType("9006");
			query.setReservationId(dto.getReservationId());
			materialDao.deleteBySelective(query);
		}
	}

	@Override
	@Transactional
	public void oneselfApproval(OneselfApproveDto dto) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		
		//查询需要推送的人员
    	List<String> alias=this.replacementDao.queryAlias(dto.getReservationId());
    	//查询订单号
    	String orderNum=this.replacementDao.queryOrderNum(dto.getReservationId());
    	JPushReqDto jPushReqDto = new JPushReqDto();
        jPushReqDto.setAlias(alias.toArray(new String[alias.size()]));
        jPushReqDto.setRelevanceId(dto.getReservationId());
        jPushReqDto.setParams(orderNum);
        
		dto.setUpdateBy(user.getPartyId());
		//本品收购添加操作记录
  		PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
  		
  		PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
  		psiCustomerReservationTrackEntity.setReservationId(dto.getReservationId());
  		psiCustomerReservationTrackEntity.setUpdatedBy(user.getPartyId());
  		psiCustomerReservationTrackEntity.setUpdatedDate(new Date());
  		if(dto.getDealPriceEnd()!=null){
  			psiCustomerReservationTrackEntity.setDealPriceEnd(dto.getDealPriceEnd().longValue());
  		}
		//审批通过
		if(Constants.approvalStatus.approval.value().equals(dto.getApproveStatus())){
			dto.setMaterialStatus(null);
			if(dto.getPicDto() !=null && !dto.getPicDto().isEmpty()){
				//更新预约表状态为0706
				psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.completed.value());
				//审批时上传了付款凭证，审批通过后，则为已入库状态；
				dto.setAcquisitionStatus(Constants.acquisitionStatus.warehoused.value());
				psiOrderReceivingRecordEntity.setOrderStatus("已入库待过户");
				
				//审批通过，已入库待过户
				jPushReqDto.setjPushtemplateId(Constants.jPushtemplateId.JPUSHFOURTH.value());
				sendJpushFegin.sendJPush(jPushReqDto);
			}else{
				//更新预约表状态为0705
				psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.quoted.value());
				//未上传付款凭证，审批通过后，则为待入库状态
				dto.setAcquisitionStatus(Constants.acquisitionStatus.stockpending.value());
				psiOrderReceivingRecordEntity.setOrderStatus("待入库");
				
				//审批通过，待总部人员手动入库
				jPushReqDto.setjPushtemplateId(Constants.jPushtemplateId.JPUSHFIFTH.value());
				sendJpushFegin.sendJPush(jPushReqDto);
			}
		}else if(Constants.approvalStatus.reject.value().equals(dto.getApproveStatus())){
			dto.setAcquisitionStatus(null);
			dto.setMaterialStatus(Constants.materialStatus.againUpload.value());
			psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.quoted.value());
			
			//收购材料审批被驳回
            jPushReqDto.setjPushtemplateId(Constants.jPushtemplateId.JPUSHTHIRD.value());
            sendJpushFegin.sendJPush(jPushReqDto);
		}else if(Constants.approvalStatus.close.value().equals(dto.getApproveStatus())){
			dto.setAcquisitionStatus(null);
			dto.setMaterialStatus(null);
			psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.closed.value());
		}
		
		if(dto.getPicDto() !=null && !dto.getPicDto().isEmpty()){
			//更新付款凭证
			//本品收购材料保存
    		List<PsiAcquisitionMaterialEntity> materialEntityList = new ArrayList<>();
			for (PicDto picDto : dto.getPicDto()) {
				PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
				PsiAcquisitionMaterialEntity query = new PsiAcquisitionMaterialEntity();
				query.setMaterialType(picDto.getMaterialType());
				query.setReservationId(dto.getReservationId());
				materialDao.deleteBySelective(query);
				
				materialEntity.setMaterialId(picDto.getMaterialId());
				materialEntity.setMaterialType(picDto.getMaterialType());
				materialEntity.setReservationId(dto.getReservationId());
				materialEntity.setUploadDate(new Date());
				materialEntity.setUploadPerson(user.getPartyId());
				materialEntityList.add(materialEntity);
			}
            materialDao.batchInsert(materialEntityList);
		}else{
			//如果审批时平款凭证为空,清空付款凭证
			PsiAcquisitionMaterialEntity query = new PsiAcquisitionMaterialEntity();
			query.setMaterialType("9006");
			query.setReservationId(dto.getReservationId());
			materialDao.deleteBySelective(query);
		}
		
		//更新预约表状态
		this.iPsiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
		//更新收购表状态
		this.replacementDao.updateAcquisitionStatus(dto);
		//更新询价表状态
		this.replacementDao.updateInquiryStatus(dto);
		//更新审批表状态
		this.replacementDao.updateApprovalStatus(dto);
		//更新客户车辆表
		this.replacementDao.updateCustomerCars(dto);
		
		if(dto.getPicDto() !=null && !dto.getPicDto().isEmpty()){
			//库存车辆表添加数据
            this.saveStockInfo(dto.getReservationId(),dto.getUpdateBy());
		}
		
		//添加审批记录
        RepReplacementApprovalRecordEntity repReplacementApprovalRecordEntity = new RepReplacementApprovalRecordEntity();
        
        repReplacementApprovalRecordEntity.generatePk();
        Long replacementId = this.replacementDao.getApprovalId(dto.getReservationId());
        repReplacementApprovalRecordEntity.setReplacementId(replacementId);
        if(dto.getApproveStatus().equals(Constants.approvalStatus.approval.value())){
        	repReplacementApprovalRecordEntity.setApprovalResult(Constants.approvalResult.adopt.value());
        	psiOrderReceivingRecordEntity.setOperation("审批通过");
        }else if(dto.getApproveStatus().equals(Constants.approvalStatus.reject.value())){
        	repReplacementApprovalRecordEntity.setApprovalResult(Constants.approvalResult.unAdopt.value());
        	repReplacementApprovalRecordEntity.setApprovalRemark(dto.getReason());
        	psiOrderReceivingRecordEntity.setOperation("审批驳回");
        	psiOrderReceivingRecordEntity.setOrderStatus("审批驳回");
        	psiOrderReceivingRecordEntity.setReason(dto.getReason());
        }else{
        	repReplacementApprovalRecordEntity.setApprovalResult(Constants.approvalResult.close.value());
        	repReplacementApprovalRecordEntity.setApprovalRemark(dto.getReason());
        	psiOrderReceivingRecordEntity.setOperation("审批关闭");
        	psiOrderReceivingRecordEntity.setOrderStatus("审批关闭");
        	psiOrderReceivingRecordEntity.setReason(dto.getReason());
        }
        repReplacementApprovalRecordEntity.setApprovalDate(new Date());
        repReplacementApprovalRecordEntity.setApprovalPerson(user.getPartyId());
        String approvalName = replacementDao.selectApprovalName(user.getPartyId());
        if (Objects.nonNull(approvalName)){
            repReplacementApprovalRecordEntity.setApprovalPersonName(approvalName);
        }else {
            repReplacementApprovalRecordEntity.setApprovalPersonName(user.getLoginName());
        }
        //获取上报时间
        RepReplacementApprovalEntity repReplacementApprovalEntity = new RepReplacementApprovalEntity();
        repReplacementApprovalEntity.setReplacementId(replacementId);
        List<RepReplacementApprovalEntity> repReplacementApprovalEntities = iRepReplacementApprovalDao.selectBySelective(repReplacementApprovalEntity);
        repReplacementApprovalRecordEntity.setReportingDate(repReplacementApprovalEntities.get(0).getReportingDateEnd());
        repReplacementApprovalRecordEntity.setApprovalRemark(dto.getReason());

        //插入审批记录表
        iRepReplacementApprovalRecordDao.insertSelective(repReplacementApprovalRecordEntity);
        
  	  	psiOrderReceivingRecordEntity.generatePk();
  	  	psiOrderReceivingRecordEntity.setRecordType("03");
  	  	psiOrderReceivingRecordEntity.setReservationId(dto.getReservationId());
  	  	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
  	  	psiOrderReceivingRecordEntity.setOperationDate(new Date());
  	  	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void putIntoStorage(OneselfPutIntoStorageDto dto) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		dto.setUpdateBy(user.getPartyId());
		//更新最终成交价和付款凭证
		SaveTransactionPriceDto saveTransactionPriceDto = new SaveTransactionPriceDto();
		saveTransactionPriceDto.setDealPriceEnd(dto.getDealPriceEnd());
		saveTransactionPriceDto.setPicDto(dto.getPicDto());
		saveTransactionPriceDto.setReservationId(dto.getReservationId());
		saveTransactionPriceDto.setRevertBody(dto.getRevertBody());
		this.saveTransactionPrice(saveTransactionPriceDto);
		
		//只有入库操作时才会变更状态
		if(dto.getOperationType() == 1){
			this.replacementDao.putIntoStorage(dto);
			//更新询价表状态为已收够0922
			this.replacementDao.updateInquiryStatusNew(dto);
			//本品收购添加接单记录
        	PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
        	psiOrderReceivingRecordEntity.generatePk();
        	psiOrderReceivingRecordEntity.setOperation("入库");
        	psiOrderReceivingRecordEntity.setOrderStatus("已入库");
        	psiOrderReceivingRecordEntity.setRecordType("03");
        	psiOrderReceivingRecordEntity.setReservationId(dto.getReservationId());
        	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
        	psiOrderReceivingRecordEntity.setOperationDate(new Date());
        	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
        	
        	//更新预约单为0706
        	PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
      		psiCustomerReservationTrackEntity.setReservationId(dto.getReservationId());
      		psiCustomerReservationTrackEntity.setUpdatedBy(user.getPartyId());
      		psiCustomerReservationTrackEntity.setUpdatedDate(new Date());
      		psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.completed.value());
      		this.iPsiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
      		
      		this.saveStockInfo(dto.getReservationId(),dto.getUpdateBy());
      		
      		//查询需要推送的人员
        	List<String> alias=this.replacementDao.queryAlias(dto.getReservationId());
        	//查询订单号
        	String orderNum=this.replacementDao.queryOrderNum(dto.getReservationId());
        	JPushReqDto jPushReqDto = new JPushReqDto();
            jPushReqDto.setAlias(alias.toArray(new String[alias.size()]));
            jPushReqDto.setRelevanceId(dto.getReservationId());
            jPushReqDto.setParams(orderNum);
            //审批通过，已入库待过户
			jPushReqDto.setjPushtemplateId(Constants.jPushtemplateId.JPUSHFOURTH.value());
			sendJpushFegin.sendJPush(jPushReqDto);
		}
	}

	private void saveStockInfo(Long reservationId, Long updateBy) {
		//查询入库车辆信息
  		PsiCustomerCarsEntity psiCustomerCarsEntity = this.iPsiCustomerCarsDao.load(new PsiCustomerCarsPk(reservationId));
  		LOGGER.info("==查询入库车辆信息==="+JsonBeanUtil.beanToJson(psiCustomerCarsEntity));
  		//校验车辆是否已经存在 未作废且未售出的车辆
  		int count=this.replacementDao.countCar(psiCustomerCarsEntity.getVinCode());
  		if(count == 0){
  			//查询仓储信息
  			CarStorageInfoDto  carStorageInfoDto= this.replacementDao.queryCarInfo(reservationId);
  			//库存车辆表添加车辆数据
  			PsiCarStockInfoEntity psiCarStockInfoEntity = new PsiCarStockInfoEntity();
  			psiCarStockInfoEntity.generatePk();
  			psiCarStockInfoEntity.setVinCode(psiCustomerCarsEntity.getVinCode());
  			psiCarStockInfoEntity.setSourceBatch(carStorageInfoDto.getBusinessOrderNo());
  			psiCarStockInfoEntity.setCarSource(Constants.CAR_SOURCE.ACQUISITION_STORAGE.value());
  			psiCarStockInfoEntity.setCarType(Constants.CAR_TYPE.EXTERNAL_CAR_PURCHASE.value());
  			psiCarStockInfoEntity.setStockType(Constants.STOCK_TYPE.OutletInventory.value());
  			psiCarStockInfoEntity.setBaseCarTypeName(psiCustomerCarsEntity.getCarTypeChineseDescribe());
  			psiCarStockInfoEntity.setCarSeriesName(psiCustomerCarsEntity.getCarSeriesChineseDescribe());
  			psiCarStockInfoEntity.setStorageId(carStorageInfoDto.getStorageId());
  			psiCarStockInfoEntity.setStorageName(carStorageInfoDto.getStorageName());
  			psiCarStockInfoEntity.setStorageCode(carStorageInfoDto.getStorageCode());
  			psiCarStockInfoEntity.setRevertBody(psiCustomerCarsEntity.getRevertBody());
  			psiCarStockInfoEntity.setPurchasePrice(carStorageInfoDto.getDealPriceEnd());
  			psiCarStockInfoEntity.setWarehousDate(new Date());
  			psiCarStockInfoEntity.setCarColour(psiCustomerCarsEntity.getColor());
  			psiCarStockInfoEntity.setCarNature(psiCustomerCarsEntity.getUsingNature());
  			psiCarStockInfoEntity.setLicensePlace(psiCustomerCarsEntity.getLicensingCity());
  			psiCarStockInfoEntity.setLicenseNumber(psiCustomerCarsEntity.getLicensePlateNum());
  			psiCarStockInfoEntity.setFirstLicenseDate(psiCustomerCarsEntity.getLicensingDate());
  			psiCarStockInfoEntity.setTransferCount(Integer.parseInt(psiCustomerCarsEntity.getTransferTimes()));
  			psiCarStockInfoEntity.setStockState(Constants.STOCK_STATUS.InStockForSale.value());
  			psiCarStockInfoEntity.setStockMileage(Long.getLong(psiCustomerCarsEntity.getDrivingMileage()));
  			psiCarStockInfoEntity.setCarLevel(psiCustomerCarsEntity.getRank());
  			psiCarStockInfoEntity.setRepealIs("00");
  			psiCarStockInfoEntity.setIsDelete("00");
  			psiCarStockInfoEntity.setIsEnable("01");
  			psiCarStockInfoEntity.setUpdatedBy(updateBy);
  			psiCarStockInfoEntity.setCreatedBy(updateBy);
  			LOGGER.info("==库存车辆表添加车辆数据==="+JsonBeanUtil.beanToJson(psiCarStockInfoEntity));
  			this.iPsiCarStockInfoDao.insert(psiCarStockInfoEntity);
  		}
	}
	
	@Override
	public void grantRights(Long reservationId, String businessClassify, Integer isGrant) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		if(isGrant == 1){
			this.pushActivities(reservationId, businessClassify,null,null);
		}
		//变更审批表信息
		this.replacementDao.updateApproval(isGrant,reservationId,user.getPartyId());
		OneselfApproveDto dto =new OneselfApproveDto();
		dto.setReservationId(reservationId);
		dto.setApproveStatus(Constants.approvalStatus.approval.value());
		dto.setUpdateBy(user.getPartyId());
		//变更询价表状态
		this.replacementDao.updateInquiryStatus(dto);
		//变更收购表状态
		this.replacementDao.updateAcquisitionStatus(dto);
	}

	@Override
	public void logicDeleteReplace(Long reservationId) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		// 逻辑删除置换预约
		PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity(reservationId);
		psiCustomerReservationTrackEntity.setIsDelete(Constants.IsEnable.DISABLE.value());
		psiCustomerReservationTrackEntity.setUpdatedBy(user.getPartyId());
		psiCustomerReservationTrackEntity.setUpdatedDate(new Date());
		this.iPsiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
		// 逻辑删除询价单
		PsiCarDealerInquiryEntity psiCarDealerInquiryEntity = new PsiCarDealerInquiryEntity();
		psiCarDealerInquiryEntity.setReservationId(reservationId);
		List<PsiCarDealerInquiryEntity> inquiryEntityList = this.iPsiCarDealerInquiryDao.selectBySelective(psiCarDealerInquiryEntity);
		if(CollectionUtils.isNotEmpty(inquiryEntityList)){
			psiCarDealerInquiryEntity.setInquiryId(inquiryEntityList.get(0).getInquiryId());
			psiCarDealerInquiryEntity.setIsDelete(Constants.IsEnable.DISABLE.value());
			psiCarDealerInquiryEntity.setUpdatedBy(user.getPartyId());
			psiCarDealerInquiryEntity.setUpdatedDate(psiCustomerReservationTrackEntity.getUpdatedDate());
			this.iPsiCarDealerInquiryDao.updateSelective(psiCarDealerInquiryEntity);
			
			//逻辑删除置换审核单
			this.replacementDao.updateApprovalDel(reservationId, user.getPartyId());
		}
		
	}

}
