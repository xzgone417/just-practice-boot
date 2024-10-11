package com.exp.ucmp.dept.service;

import com.exp.ucmp.entity.JobReceiveRspEntity; /**
 * @author hailele
 * @date 2022年11月18日
 */

public interface SysDeptInfoService {

    /**
     * 数据同步
     * @param rsp
     */
    void synEmdmDeptInfo(JobReceiveRspEntity rsp);
}
