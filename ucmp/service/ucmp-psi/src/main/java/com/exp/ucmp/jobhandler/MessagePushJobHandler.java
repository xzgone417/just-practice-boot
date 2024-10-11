package com.exp.ucmp.jobhandler;

import com.exp.ucmp.carDealer.dto.JobHandlerResult;
import com.exp.ucmp.carDealer.service.InquiryReceivingService;
import com.exp.ucmp.carDealer.service.MessagePushService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagePushJobHandler {

    @Autowired
    InquiryReceivingService inquiryReceivingService;

    @Autowired
    MessagePushService messagePushService;

    /**
     * 询价单截检测前半小时，无车商签到消息推送
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("inquiryDeadlineTimeBefore")
    public ReturnT<String> inquiryDeadlineTimeBeforeJobHandler(String param) throws Exception {
        try {
            JobHandlerResult result = messagePushService.deadlineTimeBeforeTime();
            XxlJobLogger.log("本次处理的已过检测截止时间的预约跟踪单计有:" + result.getHandlerCount());
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
     * 询价单截止报价前半小时，无车商报价消息推送
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("inquiryQuotingDeadlineBefore")
    public ReturnT<String> inquiryQuotingDeadlineBeforeJobHandler(String param) throws Exception {
        try {
            JobHandlerResult result = messagePushService.quotingDeadlineBefore();
            XxlJobLogger.log("本次处理的已过报价截止时间的预约跟踪单计有:" + result.getHandlerCount());
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
     * 距离客户同意收购价格时间等于后台定义的时间差，车商未上传收车材料
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("customerAgreeTimeLater")
    public ReturnT<String> customerAgreeTimeLaterJobHandler(String param) throws Exception {
        try {
            JobHandlerResult result = messagePushService.customerAgreeTimeLater();
            XxlJobLogger.log("本次处理的车商未上传收车材料的预约跟踪单计有:" + result.getHandlerCount());
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
     * 距离首次上报材料时间等于后台定义的时间差，车商未上传过户材料
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("firstEscalationTimeLater")
    public ReturnT<String> firstEscalationTimeLaterJobHandler(String param) throws Exception {
        try {
            JobHandlerResult result = messagePushService.firstEscalationTimeLater();
            XxlJobLogger.log("本次处理的车商未上传过户材料的预约跟踪单计有:" + result.getHandlerCount());
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
