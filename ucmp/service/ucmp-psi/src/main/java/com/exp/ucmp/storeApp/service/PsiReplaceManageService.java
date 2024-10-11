package com.exp.ucmp.storeApp.service;

import com.exp.ucmp.storeApp.dto.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022年09月22日
 */

public interface PsiReplaceManageService {

    /**
     * Description: 置换线索详情
     * @param  replaceCluesDetailsQueryDto 查询条件
     * @return 实体集合
     * @throws Exception 
     */

    public List<ReplaceCluesDetailsDto> queryReplaceCluesDetails(ReplaceCluesDetailsQueryDto replaceCluesDetailsQueryDto) throws Exception;





    /**
     * Description: 创建预约单
     * @param  replaceOrderInsertDto 入参
     * @throws Exception 
     */


    public ReplaceOrderInsertReturnDto insertReplaceOrder(ReplaceOrderInsertDto replaceOrderInsertDto) throws Exception;


    /**
     * Description: 车商信息查询
     * @param  carDealerMsgQueryDto 入参
     * @throws Exception 
     */

    public List<CarDealerMsgDto> queryCarDealer(CarDealerMsgQueryDto carDealerMsgQueryDto) throws Exception;


    /**
     * Description: 不同状态下的置换线索列表
     * @param  replaceCluesDetailsQueryDto 查询条件
     * @return 实体集合
     * @throws Exception 
     */
    public List<ReplaceCluesDetailsDto>  queryReplaceClues(ReplaceCluesDetailsQueryDto replaceCluesDetailsQueryDto) throws Exception;


    /**
     * Description: 关闭预约单
     * @param  replaceCluesCloseDto 条件
     * @return 实体集合
     * @throws Exception 
     */
    public void  updateReplaceClues(ReplaceCluesCloseDto replaceCluesCloseDto) throws Exception;


    /**
     * Description: 车商签到
     * @param  carDealerSignIn 条件
     * @return 实体集合
     * @throws Exception 
     */
    public void  updateCarDealerSignIn(CarDealerSignIn carDealerSignIn) throws Exception;


    /**
     * Description: 车商信息查询(参与车商)
     * @param  carDealerMsgQueryDto 入参
     * @throws Exception 
     */

    public List<CarDealerMsgDto> queryCarDealerInfo(CarDealerMsgQueryDto carDealerMsgQueryDto) throws Exception;


    /**
     * Description: 车商信息查询(车商签到)
     * @param  carDealerMsgQueryDto 入参
     * @throws Exception 
     */

    public List<CarDealerMsgDto> queryCarDealerSignIn(CarDealerMsgQueryDto carDealerMsgQueryDto) throws Exception;

    /**
     * Description: 分配车商
     * @param  divisionCarDealerDto 入参
     * @throws Exception 
     */
    public void divisionCarDealer(DivisionCarDealerDto divisionCarDealerDto) throws Exception;


    /**
     * Description: 客户操作(同意/接洽/拒绝)
     * @param  customerOperationDto 入参
     * @param type 
     * @throws Exception 
     */
    public void customerOperation(CustomerOperationDto customerOperationDto, int type) throws Exception;


    /**
     * Description: 关联新车订单信息(link订单)
     * @param  psiNewCarOrderDto 入参
     * @throws Exception 
     */
    public void linkNewCarOrder(PsiNewCarOrderDto psiNewCarOrderDto) throws Exception;


    /**
     * Description: 信息发送接收人电话查询
     * @param  map 入参
     */

    public List<HashMap> sendMessagePerson(HashMap map);
}
