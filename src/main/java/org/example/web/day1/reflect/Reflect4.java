package org.example.web.day1.reflect;

import org.example.web.day1.Person;

import java.lang.reflect.Method;

/**
 * Author: 卑微小冯
 * Date: 2020/9/4 下午2:07
 * Project: learningProjects
 * Package: org.example.web.day1.reflect
 */

public class Reflect4 {
    public static void main(String[] args) throws Exception {
        Class c = Person.class;

        Method setName = c.getMethod("setName", String.class);

    }
}
