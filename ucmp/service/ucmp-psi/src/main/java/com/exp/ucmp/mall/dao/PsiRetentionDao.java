package com.exp.ucmp.mall.dao;

import com.exp.ucmp.clues.dto.*;
import com.exp.ucmp.dao.IPsiOrderInfoDao;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.pk.PsiRetentionCluesPk;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author gubonai
 * @Description:
 * @date 2023/2/3 11:12
 */
public interface PsiRetentionDao {

    List<RetentionCluesDto> queryRetentionCluesList(RetentionCluesParamDto retentionCluesParamDto);

    List<SalesRetentionCluesDto> querySalesCluesList(SalesCluesParamDto salesCluesParamDto);

    List<OrderInfoDto> queryOrderList(OrderInfoParamDto orderInfoParamDto);

    PsiOrderInfoDto queryDetails(Long orderInfoId);

    List<String> queryVinList();

    String findNewOddNumbers();

    CustomerInfoDto queryCluesCustomerInfo(PsiRetentionCluesPk psiRetentionCluesPk);

    List<PsiCluesFollowRecordDto> queryCluesFollowRecord(PsiCluesFollowRecordEntity psiCluesFollowRecordEntity);

    PsiRetentionCluesEntity selectLastClues(SalesCustomerParamDto paramDto);

    List<SalesConsultantDto> salesConsultantList(SalesConsultantParamDto paramDto);

    PsiCarStockInfoEntity selectByVinCode(@Param("vin")String vin,@Param("type") int type);

    List<PsiSalesCustomerEntity> selectAllPerson(@Param("notStoreId") String notStoreId,
                                                 @Param("notPartyId") String notPartyId,
                                                 @Param("customerPhoneList") List<String> customerPhoneList);



    List<PsiRetentionCluesEntity> selectByCluesList(PsiRetentionCluesParamDto cluesParamDto);

     List<PsiSalesCustomerEntity> selectCustomerList(@Param("customerIds") Set<Long> customerIds);
    /**
     * 查询二手车主管手机号
     * @return
     */
    List<UsedCarSupervisorDto> queryUsedCarSupervisor(UsedCarSupervisorParamDto paramDto);


    List<PsiRetentionCluesEntity> selectClues(@Param("customerPhoneList")List<String> customerPhoneList);


    String selectPersonName(@Param("partyId") Long partyId);

    List<PsiOrderInfoEntity> listByOrder(PsiOrderInfoEntity paramDto);
    void batchUpdateStockState(@Param("list") List<PsiCarStockInfoEntity> list);


    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiSalesCustomerEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateCustomer(List<PsiSalesCustomerEntity> listPsiSalesCustomerEntity);


    /**
     * 根据门店ID置空销售客户根据门店、跟进人（客户表）
     * @param storeId
     */
    void redistributionStoreCustomer(@Param("storeId") Long storeId);

    /**
     * 根据人员ID置空跟进人（客户表）
     * @param parsonList
     */
    void redistributionCustomerId(List<Long> parsonList);

    /**
     *  根据人员ID置空跟进人（线索表）
     * @param parsonList
     */
    void redistributionClues(List<Long> parsonList);

    /**
     *  根据人员ID置空跟进人（订单表）
     * @param parsonList
     */
    void redistributionOrder(List<Long> parsonList);


    /**
     * 根据手机号修改线索
     * @param customerId 条件
     * @param customerPhone 修改字段
     * @param followStore 修改字段
     * @param followPerson 修改字段
     * @param updatedBy 修改字段
     * @return
     */
    int updatePhoneFollowPerson(@Param("customerPhone") String customerPhone,
                                @Param("customerId") Long customerId,
                                @Param("followStore") Long followStore,
                                @Param("followPerson") Long followPerson,
                                @Param("updatedBy") Long updatedBy);

    /**
     *
     * @param customerId 条件
     * @param followStore 条件
     * @param changeFollowStore 修改
     * @param changeFollowPerson 修改
     * @param updatedBy 修改
     * @return
     */
    int updateStoreClues(@Param("customerId") Long customerId,
                         @Param("followStore") Long followStore,
                         @Param("changeFollowStore") Long changeFollowStore,
                         @Param("changeFollowPerson") Long changeFollowPerson,
                         @Param("updatedBy") Long updatedBy);

    /**
     *
     * @param customerId 条件
     * @param followStore 条件
     * @param changeFollowStore 修改
     * @param changeFollowPerson 修改
     * @param updatedBy 修改
     * @return
     */
    int updateStoreOrder(@Param("customerId") Long customerId,
                         @Param("followStore") Long followStore,
                         @Param("changeFollowStore") Long changeFollowStore,
                         @Param("changeFollowPerson") Long changeFollowPerson,
                         @Param("updatedBy") Long updatedBy);

	List<PayRecordDto> queryPayRecords(Long orderInfoId);

	void changeOrderPrice(OrderChangePriceDto orderChangePriceDto);

	void changeCarSalePrice(OrderChangePriceDto orderChangePriceDto);

	void addChangPriceRecord(OrderChangePriceDto orderChangePriceDto);

	OrderChangePriceDto queryChangePrice(Long orderInfoId);

	void addChangPriceFile(List<OrderChangeFileDto> fileList);

	List<OrderChangeFileDto> queryFileList(Long recordId);

	Double querySuggestedPrice(Long stockId);

	Long queryStockId(Long orderInfoId);

	void updateChangPriceRecord(Long orderRecordId);

	Long queryOrderId(Long orderRecordId);




}
