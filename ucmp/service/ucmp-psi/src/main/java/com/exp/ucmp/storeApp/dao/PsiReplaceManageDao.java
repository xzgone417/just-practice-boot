package com.exp.ucmp.storeApp.dao;

import com.exp.ucmp.entity.PsiCustomerReservationTrackEntity;
import com.exp.ucmp.pertner.dto.SysPartnerDetailsDto;
import com.exp.ucmp.storeApp.dto.CarDealerMsgDto;
import com.exp.ucmp.storeApp.dto.CarDealerMsgQueryDto;
import com.exp.ucmp.storeApp.dto.ReplaceCluesDetailsDto;
import com.exp.ucmp.storeApp.dto.ReplaceCluesDetailsQueryDto;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author zhouchengwei
 * @date 2022/09/22
 * 查询人员信息
 */
public interface PsiReplaceManageDao {
    /**
     * Description: 查询合作商排名
     * @return 实体集合
     */
     List<SysPartnerDetailsDto> selectPartnerDetailsOrderSort();


    /**
     * Description: 置换线索详情
     * @param  replaceCluesDetailsQueryDto 查询条件
     * @return 实体集合
     */

    public List<ReplaceCluesDetailsDto> selectReplaceCluesDetails(ReplaceCluesDetailsQueryDto replaceCluesDetailsQueryDto);


    /**
     * Description: 车商信息查询(分配车商)
     * @param  carDealerMsgQueryDto 入参
     */

    public List<CarDealerMsgDto> selectCarDealer(CarDealerMsgQueryDto carDealerMsgQueryDto);


    /**
     * Description: 不同状态下的置换线索列表
     * @param  replaceCluesDetailsQueryDto 查询条件
     * @return 实体集合
     */
    public List<ReplaceCluesDetailsDto>  selectReplaceClues(ReplaceCluesDetailsQueryDto replaceCluesDetailsQueryDto);



    /**
     * Description: 车商信息查询(参与车商)
     * @param  carDealerMsgQueryDto 入参
     */

    public List<CarDealerMsgDto> selectCarDealerInfo(CarDealerMsgQueryDto carDealerMsgQueryDto);

    /**
     * 待接单参与车商
     */
    public List<CarDealerMsgDto> selectCarDealerInfoPendingOrder(CarDealerMsgQueryDto carDealerMsgQueryDto);


    /**
     * Description: 车商信息查询(车商签到)
     * @param  carDealerMsgQueryDto 入参
     */

    public List<CarDealerMsgDto> selectCarDealerSignIn(CarDealerMsgQueryDto carDealerMsgQueryDto);


    /**
     * Description: 信息发送接收人电话查询
     * @param  map 入参
     */

    public List<HashMap> sendMessagePerson(HashMap map);

    /**
     * <p>Description: 分配车商修改信息跟踪表</p>
     * @param psiCustomerReservationTrackEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity);

	List<CarDealerMsgDto> selectHipiCarDealer();

	void updateDealerApprovalStatus(@Param("reservationId")Long reservationId,@Param("partyId") Long partyId);

	void updateAcquisitionApprovalStatus(@Param("reservationId")Long reservationId,@Param("partyId") Long partyId);

	void updateApprovalStatus(@Param("reservationId")Long reservationId,@Param("partyId") Long partyId);

}
