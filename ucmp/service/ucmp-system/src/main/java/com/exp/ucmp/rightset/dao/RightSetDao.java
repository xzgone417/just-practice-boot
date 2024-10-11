package com.exp.ucmp.rightset.dao;

import com.exp.ucmp.rightset.dto.DistributeDetailsPageDto;
import com.exp.ucmp.rightset.dto.DistributeDetailsPageQueryDto;
import com.exp.ucmp.rightset.dto.RightSetPageDto;
import com.exp.ucmp.rightset.dto.RightSetQueryParamsDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/11/18 14:12
 */
public interface RightSetDao {

    /**
     * 查询姓名
     * @param partyId
     * @return
     */
    String selectPersonName(@Param("partyId")Long partyId);

    /**
     * 查询权益活动列表
     * @param paramsDto
     * @return
     */
    List<RightSetPageDto> selectRightSetList(@Param("paramsDto") RightSetQueryParamsDto paramsDto);


}
