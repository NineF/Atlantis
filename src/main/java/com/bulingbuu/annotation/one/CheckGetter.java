package com.bulingbuu.annotation.one;


import java.lang.annotation.*;

/**
 * @author bulingbuu
 * @date 18-11-21 下午7:02
 */
@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.SOURCE)
public @interface CheckGetter {
}
