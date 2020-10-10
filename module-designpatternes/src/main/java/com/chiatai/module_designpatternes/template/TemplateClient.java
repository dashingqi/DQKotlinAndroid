package com.chiatai.module_designpatternes.template;

/**
 * @author : zhangqi
 * @time : 2020/9/21
 * desc : 场景类，用来书写业务
 */
public class TemplateClient {

    public static void main(String[] args) {

        //抽象实现类one
        AbstractClassImplOne abstractClassImplOne = new AbstractClassImplOne();
        abstractClassImplOne.templateMethod();

        //抽象实现类two
        AbstractClassImplTwo abstractClassImplTwo = new AbstractClassImplTwo();
        abstractClassImplTwo.templateMethod();
    }
}
