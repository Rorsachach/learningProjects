package org.example.web.day1.reflect;

import org.example.web.day1.Person;

import java.io.File;
import java.lang.reflect.Field;

public class Reflect2 {
    public static void main(String[] args) {
        Class c = Person.class;

        // 1. 获取成员变量
        Field[] fields = c.getFields();
    }
}