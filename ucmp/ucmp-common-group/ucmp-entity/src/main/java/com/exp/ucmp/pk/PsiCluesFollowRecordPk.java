package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCluesFollowRecordPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 跟进记录id
     */
    private Long followId;
    
    public PsiCluesFollowRecordPk() {
    }
    
    public PsiCluesFollowRecordPk(Long followId) {
        this.followId = followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }
    public Long getFollowId() {
        return this.followId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (followId == null)
           
               ? true : false;
    }
    
}
