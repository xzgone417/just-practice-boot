package com.exp.ucmp.transfer.service;

import com.exp.ucmp.transfer.dto.TransferApplyCarInfoDto;
import com.exp.ucmp.transfer.dto.TransferCarApplyQueryDto;
import com.exp.ucmp.transfer.dto.TransferCarApplyResultDto;
import com.exp.ucmp.transfer.dto.TransferCarApplyStatusDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface TransferApplyService {


    TransferApplyCarInfoDto findTransferApplyInfo(Long dispatchApplyId);

    void submitTransferApply(Integer operation, TransferApplyCarInfoDto transferApplyCarInfoDto);

    PageInfo<TransferCarApplyResultDto> findList(TransferCarApplyQueryDto queryDto);

    PageInfo<TransferCarApplyResultDto> registerList(TransferCarApplyQueryDto queryDto);

    PageInfo<TransferCarApplyStatusDto> findStatusList(TransferCarApplyQueryDto queryDto);

    boolean transferWarehousing(Integer option, List<Long> transferApplyId);

    /**
     * 调拨登记关闭/提交
     * @param option 1提交 2关闭
     */
    boolean submitOrClose(Integer option,Long transferApplyId);

}
