package com.exp.ucmp.xxljob.dao;

import com.exp.ucmp.entity.JobReceiveInfoEntity;
import com.exp.ucmp.entity.JobReceiveReqEntity;
import com.exp.ucmp.entity.JobReceiveRspEntity;

import java.util.List;

public interface IXxlJobDao {
	/**
     * <p>Description: 查询信息接收表该任务最新一次成功请求的时间戳</p>
     * @param jobReceiveInfoEntity 查询条件
     * @return 数据行数
     */
	public Long selectMaxtimestampByReveive(JobReceiveInfoEntity jobReceiveInfoEntity) ;

	/**
     * <p>Description: 根据时间戳查询上次请求信息</p>
     * @param jobReceiveInfoEntity 查询条件
     * @return 数据行数
     */
	public JobReceiveReqEntity selectReqByTimestamp(JobReceiveInfoEntity jobReceiveInfoEntity);

	/**
	 * <p>Description: 获取所有待处理的响应记录 </p>
	 * @param jobReceiveInfoEntity 查询条件
	 * @return 数据行数
	 */
	public List<JobReceiveRspEntity> selectALLWaitRspStr(JobReceiveInfoEntity jobReceiveInfoEntity);
	/**
	 * <p>Description: 获取所有待处理的门店人员响应记录 </p>
	 * @param jobReceiveInfoEntity 查询条件
	 * @return 数据行数
	 */
	public List<JobReceiveRspEntity> selectALLWaitRspByStoreStaff(JobReceiveInfoEntity jobReceiveInfoEntity);


	/**
	 * <p>Description: 获取所有的门店code </p>
	 * @param
	 * @return 数据行数
	 */
	public List<String> getDepartmentCodeList();


}
