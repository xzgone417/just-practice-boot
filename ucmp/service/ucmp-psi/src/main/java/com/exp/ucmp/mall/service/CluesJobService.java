package com.exp.ucmp.mall.service;

import com.exp.ucmp.carDealer.dto.JobHandlerResult;
import com.exp.ucmp.clues.dto.UsedCarSupervisorDto;

import java.util.List;

/**
 * <p>@ClassName: CluesService</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/24 13:47<p>
 */
public interface CluesJobService {
    JobHandlerResult clues();

    JobHandlerResult remind() throws Exception;

    JobHandlerResult store(List<UsedCarSupervisorDto> allUsedCarSupervisor) throws Exception;

    JobHandlerResult person(List<UsedCarSupervisorDto> allUsedCarSupervisor) throws Exception;

    JobHandlerResult follow(List<UsedCarSupervisorDto> allUsedCarSupervisor) throws Exception;

    JobHandlerResult order(List<UsedCarSupervisorDto> allUsedCarSupervisor) throws Exception;
}
