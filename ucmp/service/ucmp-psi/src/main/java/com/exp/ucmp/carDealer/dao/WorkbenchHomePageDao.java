package com.exp.ucmp.carDealer.dao;


import com.exp.ucmp.carDealer.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkbenchHomePageDao {

	/**
	 * 查询接单、报价数量
	 * @param carDealerId 车商id
	 * @param carDealerStaffId 车商人员id
	 * @return
	 */
	List<InquiryStatusDto> selectValuationOrderAndOfferFollowCount(@Param("carDealerId")Long carDealerId , @Param("carDealerStaffId")Long carDealerStaffId);

	/**
	 * 收购、审批驳回数量
	 * @param carDealerId 车商id
	 * @param carDealerStaffId 车商人员id
	 * @param type 1-审批驳回 2-收购 3-待收购 4-待议价
	 * @return
	 */
	Integer selectAcquisitionCount(@Param("carDealerId")Long carDealerId , @Param("carDealerStaffId")Long carDealerStaffId ,@Param("type")Integer type);



	ValuationOrderDto getValuationOrder();

	OfferFollowDto getOfferFollow();

	AcquisitionFollowDto getAcquisitionFollow();

}
