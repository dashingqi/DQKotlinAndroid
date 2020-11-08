package com.dashingqi.kotlinproject.compare;

import java.util.Comparator;

/**
 * @author : zhangqi
 * @time : 2020/11/8
 * desc :
 */
public class PersonComapre implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
