package com.bulingbuu.annotation.two;

import java.util.function.IntBinaryOperator;

/**
 * @author bulingbuu
 * @date 18-11-21 下午6:56
 */

public class Bar {
    @Adapt(IntBinaryOperator.class)
    public static int add(int a, int b) {
        return a + b;
    }
}

