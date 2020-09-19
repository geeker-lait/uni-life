package com.uni.life.crud.ex.assertion;

import com.uni.life.crud.ex.BaseException;
import com.uni.life.crud.ex.BusinessException;
import com.uni.life.crud.ex.IResponseEnum;

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
