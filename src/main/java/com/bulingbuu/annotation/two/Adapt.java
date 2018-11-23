package com.bulingbuu.annotation.two;

import java.lang.annotation.*;

/**
 * @author bulingbuu
 * @date 18-11-21 下午6:55
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Adapt {
    Class<?> value();
}
