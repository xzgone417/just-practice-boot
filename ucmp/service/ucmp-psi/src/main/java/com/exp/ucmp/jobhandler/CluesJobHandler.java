package com.exp.ucmp.jobhandler;

import com.exp.ucmp.carDealer.dto.JobHandlerResult;
import com.exp.ucmp.clues.dto.UsedCarSupervisorDto;
import com.exp.ucmp.mall.dao.PsiRetentionDao;
import com.exp.ucmp.mall.service.CluesJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>@ClassName: CluesJobHandler</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/19 17:11<p>
 */

@Component
public class CluesJobHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CluesJobHandler.class);

    @Autowired
    private CluesJobService cluesService;

    @Autowired
    private PsiRetentionDao psiRetentionDao;
    /**
     *
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("clues")
    public ReturnT<String> clues(String param) throws Exception {
        try {
            JobHandlerResult result = cluesService.clues();
            if(result !=null){
            	LOGGER.info("离职人员线索重新流转分配:" + result.getHandlerCount());
            	if (result.getHandlerCount() > 0) {
            		for (String str : result.getHanderMessages()) {
            			LOGGER.info(str);
            		}
            	}
            }
        } catch (Exception ex) {
            LOGGER.info("离职人员线索流转线索池异常：",ex);
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }
    /**
     *线索15天未分配店
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("store")
    public ReturnT<String> store(String param) throws Exception {
        try {
            List<UsedCarSupervisorDto> allUsedCarSupervisor = psiRetentionDao.queryUsedCarSupervisor(null);
            JobHandlerResult result = cluesService.store(allUsedCarSupervisor);
            LOGGER.info("线索15天未分配店:" + result.getHandlerCount());
            if (result.getHandlerCount() !=null &&result.getHandlerCount() > 0) {
                for (String str : result.getHanderMessages()) {
                    LOGGER.info(str);
                }
            }
        } catch (Exception ex) {
        	LOGGER.info("线索15天未分配店异常:",ex);
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }
    /**
     *线索15天未分配人
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("person")
    public ReturnT<String> person(String param) throws Exception {
        try {
            List<UsedCarSupervisorDto> allUsedCarSupervisor = psiRetentionDao.queryUsedCarSupervisor(null);
            JobHandlerResult result = cluesService.person(allUsedCarSupervisor);
            LOGGER.info("线索15天未分配人:" + result.getHandlerCount());
            if (result.getHandlerCount() !=null &&result.getHandlerCount() > 0) {
                for (String str : result.getHanderMessages()) {
                    LOGGER.info(str);
                }
            }
        } catch (Exception ex) {
            LOGGER.error("线索15天未分配人异常：",ex);
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }

    /**
     *线索15天未更新跟进
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("follow")
    public ReturnT<String> follow(String param) throws Exception {
        try {
            List<UsedCarSupervisorDto> allUsedCarSupervisor = psiRetentionDao.queryUsedCarSupervisor(null);
            JobHandlerResult result = cluesService.follow(allUsedCarSupervisor);
            LOGGER.info("线索15天未更新跟进:" + result.getHandlerCount());
            if (result.getHandlerCount() !=null &&result.getHandlerCount() > 0) {
                for (String str : result.getHanderMessages()) {
                    LOGGER.info(str);
                }
            }
        } catch (Exception ex) {
            LOGGER.error("线索15天未更新跟进异常：",ex);
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }
    /**
     * 订单长时间停留
     * @param param
     * @return
     * @throws Exception
     */
    @XxlJob("order")
    public ReturnT<String> order(String param) throws Exception {
        try {
            List<UsedCarSupervisorDto> allUsedCarSupervisor = psiRetentionDao.queryUsedCarSupervisor(null);
            JobHandlerResult result = cluesService.order(allUsedCarSupervisor);
            LOGGER.info("订单长时间停留状态:" + result.getHandlerCount());
            if (result.getHandlerCount() !=null &&result.getHandlerCount() > 0) {
                for (String str : result.getHanderMessages()) {
                    LOGGER.info(str);
                }
            }
        } catch (Exception ex) {
            LOGGER.error("订单长时间停留异常：",ex);
            return ReturnT.FAIL;
        }
        return ReturnT.SUCCESS;
    }
}
