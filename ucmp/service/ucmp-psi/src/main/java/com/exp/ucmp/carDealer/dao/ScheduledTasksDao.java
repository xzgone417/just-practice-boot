package com.exp.ucmp.carDealer.dao;

import com.exp.ucmp.carDealer.dto.DetectionCustomerDto;
import com.exp.ucmp.entity.PsiCarDealerInquiryEntity;
import com.exp.ucmp.entity.PsiCustomerReservationMsgEntity;

import java.util.List;
import java.util.Map;

public interface ScheduledTasksDao {
    /**
     * 查询指定状态，晚于指定时间的客户预约信息表
     * @param params
     * @return
     */
    List<DetectionCustomerDto> selectMsgByDetectionDate(Map<String, Object> params);

    /**
     * 查询指定状态，晚于指定时间的客户预约信息表
     * @param params
     * @return
     */
    List<PsiCarDealerInquiryEntity> selectByReservationId(Map<String, Object> params);
}
