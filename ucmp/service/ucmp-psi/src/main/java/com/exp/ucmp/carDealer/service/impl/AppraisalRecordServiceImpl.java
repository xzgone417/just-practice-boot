package com.exp.ucmp.carDealer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.carDealer.dao.AppraisalRecordDao;
import com.exp.ucmp.carDealer.dto.AcquisitionMaterialDto;
import com.exp.ucmp.carDealer.dto.AcquisitionRecordDto;
import com.exp.ucmp.carDealer.dto.AppraisalRecordDto;
import com.exp.ucmp.carDealer.dto.AppraisalRecordParamDto;
import com.exp.ucmp.carDealer.service.AppraisalRecordService;
import com.exp.ucmp.carDealer.web.AppraisalRecordController;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class AppraisalRecordServiceImpl implements AppraisalRecordService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AppraisalRecordServiceImpl.class);
	
	@Autowired
	private AppraisalRecordDao appraisalRecordDao;
	
	@Autowired
	private UcmpAesConfig ucmpAesConfig;

	@Override
	public PageInfo<AppraisalRecordDto> queryAppraisalRecord(AppraisalRecordParamDto paramDto) throws Exception {
		Long partyId=paramDto.getAppraisalStaffId();
		if( partyId==null || partyId==0){
			PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
			Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
			partyId= user.getPartyId();
		}
        List<AppraisalRecordDto> resultList=appraisalRecordDao.queryAppraisalRecord(partyId);
        for (AppraisalRecordDto appraisalRecordDto : resultList) {
        	appraisalRecordDto.setMakeOrderPersonIphone(UcmpAesConfig.dataMask(AesUtils.decryptHex(appraisalRecordDto.getEnMakeOrderPersonIphone(), ucmpAesConfig.getSecret()), 3, 7, "****"));
        	appraisalRecordDto.setCustomerIphone(UcmpAesConfig.dataMask(AesUtils.decryptHex(appraisalRecordDto.getEnCustomerIphone(), ucmpAesConfig.getSecret()), 3, 7, "****"));
        }
        return new PageInfo<>(resultList);
	}

	public static void main(String[] args) {
		String str="13856196814";
		LOGGER.info("==="+AesUtils.encryptHex(str, "IG66EV656W"));
	}

	@Override
	public PageInfo<AcquisitionRecordDto> queryAcquisitionRecord(AppraisalRecordParamDto paramDto) throws Exception {
		Long partyId=paramDto.getAppraisalStaffId();
		if( partyId==null || partyId==0){
			PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
			Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
			partyId= user.getPartyId();
		}
		 List<AcquisitionRecordDto> resultList=appraisalRecordDao.queryAcquisitionRecord(partyId);
		 for (AcquisitionRecordDto acquisitionRecordDto : resultList) {
			 acquisitionRecordDto.setMakeOrderPersonIphone(UcmpAesConfig.dataMask(AesUtils.decryptHex(acquisitionRecordDto.getEnMakeOrderPersonIphone(), ucmpAesConfig.getSecret()), 3, 7, "****"));
			 List<AcquisitionMaterialDto> list=this.appraisalRecordDao.queryAcquisitionMaterial(acquisitionRecordDto.getReservationId());
			 acquisitionRecordDto.setMaterialList(list);
		 }
		return new PageInfo<>(resultList);
	}
}
