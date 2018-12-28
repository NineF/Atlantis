package com.bulingbuu.unsafe;

import sun.misc.Unsafe;

import java.io.Serializable;

/**
 * @author bulingbuu
 * @date 18-12-28 下午7:50
 */
public class A implements Serializable {
    private final int num;

    public A(int num) {
        System.out.println("Hello Mum");
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static void main(String[] args) throws InstantiationException {
        Unsafe unsafe = Unsafe.getUnsafe();
        Class aClass = A.class;
        A a = (A) unsafe.allocateInstance(aClass);
        System.out.println(a);
    }
}
