package com.exp.ucmp.rightset.service;

import com.exp.ucmp.rightset.dto.RightSetPageDto;
import com.exp.ucmp.rightset.dto.RightSetQueryParamsDto;
import com.exp.ucmp.rightset.dto.RightSetSaveDto;
import com.exp.ucmp.rightset.dto.RightStatusUpdateDto;
import com.exp.ucmp.rightset.dto.*;
import com.github.pagehelper.PageInfo;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/11/18 14:11
 */
public interface RightSetService {

    /**
     * 权益活动列表查询
     * @param paramsDto
     * @return
     */
    PageInfo<RightSetPageDto> selectRightSetList(RightSetQueryParamsDto paramsDto);

    /**
     * 权益活动设置
     * @param setSaveDto 设置入参
     * @return
     */
    Boolean savaRightSet(RightSetSaveDto setSaveDto) throws Exception;

    /**
     * 获取创建人姓名 及 权益编码
     * @return
     */
    Map<String,String> rightSetNeed();

    /**
     * 更新权益活动状态
     * @param updateDto
     * @return
     */
    Boolean updateRightStatus(RightStatusUpdateDto updateDto);

    PageInfo<RightActivitiesDetailsPageDto> findActivitiesDetailsPage(@Valid String rightId, @Valid Integer pageNum, @Valid Integer pageSize);

    PageInfo<DistributeDetailsPageDto> findDistributeDetailsPage(DistributeDetailsPageQueryDto detailsPageQueryDto);

    RightActivitiesDetailsPageDto findActivitiesDetails(String detailId);

	List<RightSetPageDto> findRightActivities(RightSetQueryParamsDto paramsDto);
}
