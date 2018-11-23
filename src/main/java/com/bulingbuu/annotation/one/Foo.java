package com.bulingbuu.annotation.one;

/**
 * @author bulingbuu
 * @date 18-11-21 下午7:03
 */

@CheckGetter
class Foo {      // TypeElement
    int a;           // VariableElement
    static int b;    // VariableElement

    Foo() {
    }        // ExecutableElement

    void setA(      // ExecutableElement
                    int newA         // VariableElement
    ) {
    }


}

