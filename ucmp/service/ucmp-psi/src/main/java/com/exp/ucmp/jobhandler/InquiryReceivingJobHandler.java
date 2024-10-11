package com.exp.ucmp.jobhandler;

import com.exp.ucmp.carDealer.dto.JobHandlerResult;
import com.exp.ucmp.carDealer.service.InquiryReceivingService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 * 开发步骤：
 * 1、在Spring Bean实例中，开发Job方法，方式格式要求为 "public ReturnT<String> execute(String param)"
 * 2、为Job方法添加注解 "@XxlJob(value="自定义jobhandler名称", init = "JobHandler初始化方法", destroy = "JobHandler销毁方法")"，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 3、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 *
 * @author xuxueli 2019-12-11 21:52:51
 */
@Component
public class InquiryReceivingJobHandler {
    @Autowired
    InquiryReceivingService inquiryReceivingService;

    /**
     * 询价单截止接单
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("inquiryReceivingDeadline")
    public ReturnT<String> inquiryReceivingDeadlineJobHandler(String param) throws Exception {
        try {
        	JobHandlerResult result = inquiryReceivingService.receivingDeadline();
        	XxlJobLogger.log("本次处理的已过接单截止时间的预约跟踪单计有:" + result.getHandlerCount());
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
