package com.exp.ucmp.mall.web;

import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.clues.dto.UsedCarSupervisorDto;
import com.exp.ucmp.mall.dao.PsiRetentionDao;
import com.exp.ucmp.mall.service.CluesJobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>@ClassName: CluesJobController</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/8/1 18:28<p>
 */
@Api(tags = "线索定时任务相关接口")
@RestController
@RequestMapping("/cluesJob")
public class CluesJobController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CluesJobController.class);

    @Autowired
    private CluesJobService cluesJobService;
    @Autowired
    private PsiRetentionDao psiRetentionDao;

    @ApiOperation(value = "店长、销售人员离店，线索重新流转到线索池")
    @PostMapping("/departureCirculation")
    public RestResponse<String> departureCirculation() {
        try {
            cluesJobService.clues();
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    @ApiOperation(value = "线索15天未分配到店，发送提醒")
    @PostMapping("/storeCirculation")
    public RestResponse<String> store() {
        try {
            //所有的二手车主管
            List<UsedCarSupervisorDto> allUsedCarSupervisor = psiRetentionDao.queryUsedCarSupervisor(null);
            cluesJobService.store(allUsedCarSupervisor);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    @ApiOperation(value = "线索15天未分配到人，发送提醒")
    @PostMapping("/personCirculation")
    public RestResponse<String> person() {
        try {
            //所有的二手车主管
            List<UsedCarSupervisorDto> allUsedCarSupervisor = psiRetentionDao.queryUsedCarSupervisor(null);
            cluesJobService.person(allUsedCarSupervisor);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }


    @ApiOperation(value = "线索15天未跟进，发送提醒")
    @PostMapping("/followCirculation")
    public RestResponse<String> follow() {
        try {
            //所有的二手车主管
            List<UsedCarSupervisorDto> allUsedCarSupervisor = psiRetentionDao.queryUsedCarSupervisor(null);
            cluesJobService.follow(allUsedCarSupervisor);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    @ApiOperation(value = "订单15天未跟进，发送提醒")
    @PostMapping("/orderCirculation")
    public RestResponse<String> order() {
        try {
            //所有的二手车主管
            List<UsedCarSupervisorDto> allUsedCarSupervisor = psiRetentionDao.queryUsedCarSupervisor(null);
            cluesJobService.order(allUsedCarSupervisor);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
