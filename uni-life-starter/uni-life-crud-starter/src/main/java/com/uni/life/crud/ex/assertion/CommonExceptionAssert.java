package com.uni.life.crud.ex.assertion;

import com.uni.life.crud.ex.ArgumentException;
import com.uni.life.crud.ex.BaseException;
import com.uni.life.crud.ex.IResponseEnum;

import java.text.MessageFormat;

/**
 * <pre>
 * 公共异常信息
 * </pre>
 *

 */
public interface CommonExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new ArgumentException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new ArgumentException(this, args, msg, t);
    }

}
