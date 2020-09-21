package com.chiatai.module_designpatternes.template;

/**
 * @author : zhangqi
 * @time : 2020/9/21
 * desc : 模版方法模式中的抽象类
 * 基本方法：是由子类来实现的,
 * 模版方法：模版方法是用来调用基本方法的
 */
public abstract class AbstractClass {

    //基本方法
    protected abstract void doSomething();

    //基本方法
    protected abstract void doAnyThing();

    //模版方法

    public void templateMethod() {
        doSomething();
        doAnyThing();
    }
}
