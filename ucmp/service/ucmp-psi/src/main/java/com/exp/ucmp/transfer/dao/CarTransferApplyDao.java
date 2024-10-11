package com.exp.ucmp.transfer.dao;

import com.exp.ucmp.transfer.dto.TransferCarApplyQueryDto;
import com.exp.ucmp.transfer.dto.TransferCarApplyResultDto;
import com.exp.ucmp.transfer.dto.TransferCarApplyStatusDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 调度申请dao
 * @date 2023/2/13 14:36
 */
public interface CarTransferApplyDao {

    /**
     * 申请列表
     */
    List<TransferCarApplyResultDto> selectApplyList(TransferCarApplyQueryDto queryDto);

    /**
     * 登记列表
     */
    List<TransferCarApplyResultDto> selectRegisterList(TransferCarApplyQueryDto queryDto);

    /**
     * 发运状态列表
     */
    List<TransferCarApplyStatusDto> selectApplyStatusList(TransferCarApplyQueryDto queryDto);

}
