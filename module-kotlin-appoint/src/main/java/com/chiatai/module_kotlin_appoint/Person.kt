package com.chiatai.module_kotlin_appoint

/**
 * @author : zhangqi
 * @time : 2020/11/8
 * desc :
 */
class Person(val firstName: String, val lastName: String) : Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::lastName)
    }
}