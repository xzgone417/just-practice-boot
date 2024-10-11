/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.exception;

import com.egrid.core.exception.CmfaException;
import com.egrid.core.exception.constants.CmfaExceptionType;

/**
 * @author Yiyongfei
 * @date 2022/07/12
 */
public class IllegalParameterException extends CmfaException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 构造函数
     * @param illegalParameter 非法参数枚举
     */
    public IllegalParameterException(String message) {
        super(CmfaExceptionType.VALIDATION_EXCEPTION.code(), message);
    }
}
