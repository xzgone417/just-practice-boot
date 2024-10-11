package com.exp.ucmp.store.dao;

import org.apache.ibatis.annotations.Param;

/**
 * <p>@ClassName: PsiSalesDao</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/8/2 19:07<p>
 */
public interface PsiSalesDao {
    void redistributionCustomer(@Param("storeId") Long storeId,
                                @Param("updatedBy") Long updatedBy);

    void redistributionClues(@Param("storeId") Long storeId,
                             @Param("updatedBy") Long updatedBy);

    void redistributionOrder(@Param("storeId") Long storeId,
                             @Param("updatedBy") Long updatedBy);

    void redistributionCustomerParty(
                                @Param("partyId") Long partyId,
                                @Param("updatedBy") Long updatedBy);

    void redistributionCluesParty(
                             @Param("partyId") Long partyId,
                             @Param("updatedBy") Long updatedBy);

    void redistributionOrderParty(
                             @Param("partyId") Long partyId,
                             @Param("updatedBy") Long updatedBy);

    void updateConfig(@Param("storeId") Long storeId,
                      @Param("updatedBy") Long updatedBy);

}
