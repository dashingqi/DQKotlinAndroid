package com.dashingqi.kotlinproject.compare;

import java.util.Comparator;

/**
 * @author : zhangqi
 * @time : 2020/11/8
 * desc :
 *
 * Comparator与Comparable的区别在于
 * Comparable算是一个排序的接口，比如String类本身实现了Comparable接口，可以用来比较自身
 * Comparator是一个比较器 通常用作于是这个对象不能比较自身，但是想要有比较的功能，通常相比较于Comparable ，其可以自定义排序规则
 */
public class Person {

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
