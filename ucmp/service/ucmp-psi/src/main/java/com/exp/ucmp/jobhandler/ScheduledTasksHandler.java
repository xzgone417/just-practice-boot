package com.exp.ucmp.jobhandler;

import com.exp.ucmp.carDealer.dto.JobHandlerResult;
import com.exp.ucmp.carDealer.service.ScheduledTasksService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasksHandler {

    @Autowired
    private ScheduledTasksService scheduledTasksService;

    /**
     * 待接单截止前一小时短信提醒
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("inquiryReceivingDeadlineSms")
    public ReturnT<String> inquiryReceivingDeadlineSmsJobHandler(String param) throws Exception {
        try {
            JobHandlerResult result = scheduledTasksService.receivingDeadlineSms();
            XxlJobLogger.log("本次处理的待接单短信提醒的预约信息单计有:" + result.getHandlerCount());
            if (result.getHandlerCount() > 0) {
                for (String str : result.getHanderMessages()) {
                    XxlJobLogger.log(str);
                }
            }
        } catch (Exception ex) {
            XxlJobLogger.log(ex);
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }

    /**
     * 检测前一小时发送短信
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("inquiryDetectionDateSms")
    public ReturnT<String> inquiryDetectionDateJobHandler(String param) throws Exception {
        try {
            JobHandlerResult result = scheduledTasksService.detectionDate();
            XxlJobLogger.log("本次处理的检测前短信提醒的预约跟踪单计有:" + result.getHandlerCount());
            if (result.getHandlerCount() > 0) {
                for (String str : result.getHanderMessages()) {
                    XxlJobLogger.log(str);
                }
            }
        } catch (Exception ex) {
            XxlJobLogger.log(ex);
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }


    /**
     * 预计过户时间已过
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("estimatedTransferTime")
    public ReturnT<String> estimatedTransferTimeJobHandler(String param) throws Exception {
        try {
            JobHandlerResult result = scheduledTasksService.estimatedTransferTime();
            XxlJobLogger.log("本次处理的待过户短信提醒的预约信息单计有:" + result.getHandlerCount());
            if (result.getHandlerCount() > 0) {
                for (String str : result.getHanderMessages()) {
                    XxlJobLogger.log(str);
                }
            }
        } catch (Exception ex) {
            XxlJobLogger.log(ex);
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }

    /**
     * 待接单截止半小时无车商接单提醒发送给二手车主管
     * @param param
     * @return
     * @throws Exception
     */

    @XxlJob("receivingDeadlineBeforeSms")
    public ReturnT<String> inquiryReceivingDeadlineBeforeSmsJobHandler(String param) throws Exception {
        try {
            JobHandlerResult result = scheduledTasksService.receivingDeadlineBeforeSms();
            XxlJobLogger.log("本次处理的待接单短信提醒的预约信息单计有:" + result.getHandlerCount());
            if (result.getHandlerCount() > 0) {
                for (String str : result.getHanderMessages()) {
                    XxlJobLogger.log(str);
                }
            }
        } catch (Exception ex) {
            XxlJobLogger.log(ex);
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }

}
