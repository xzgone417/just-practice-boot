package com.exp.ucmp.pk;

import com.egrid.core.base.entity.AbstractBasePk;

/**
 * <p>@ClassName: PsiSalesModifyConfigPK</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/27 13:52<p>
 */
public class PsiSalesModifyConfigPK extends AbstractBasePk {
    private static final long serialVersionUID = 1L;

    /**
     * 材料文件ID
     */
    private Long applyId;

    public PsiSalesModifyConfigPK() {
    }

    public PsiSalesModifyConfigPK(Long applyId) {
        this.applyId = applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }
    public Long getApplyId() {
        return this.applyId;
    }

    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
                (applyId == null)

                        ? true : false;
    }
}
