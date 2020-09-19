package com.uni.framework.crud.base.ex.assertion;

import com.uni.framework.crud.base.ex.BaseException;
import com.uni.framework.crud.base.ex.BusinessException;
import com.uni.framework.crud.base.ex.IResponseEnum;

import java.text.MessageFormat;

/**
 * <p>
 * 业务异常断言
 * </p>
 *

 */
public interface BusinessExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg, t);
    }

}
