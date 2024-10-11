package com.exp.ucmp.carDealer.dao;


import com.exp.ucmp.entity.PsiCarDealerInquiryEntity;
import com.exp.ucmp.entity.PsiCustomerReservationTrackEntity;

import java.util.List;
import java.util.Map;

public interface MessagePushDao {
    /**
     * 查询指定状态，晚于指定时间的客户预约信息表
     * @param params
     * @return
     */
    List<PsiCustomerReservationTrackEntity> selectTrackByDeadlineTime(Map<String, Object> params);

    /**
     * 查询指定状态，晚于系统设定时间的客户预约信息表
     * @param params
     * @return
     */
    List<PsiCustomerReservationTrackEntity> selectTrackBySysTime(Map<String, Object> params);
}
