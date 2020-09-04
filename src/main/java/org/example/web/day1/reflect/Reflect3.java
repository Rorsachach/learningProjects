package org.example.web.day1.reflect;

import org.example.web.day1.Person;

import java.lang.reflect.Constructor;

public class Reflect3 {
    public static void main(String[] args) throws Exception {
        Class c = Person.class;

        Constructor constructor = c.getConstructor(String.class, int.class);
        System.out.println(constructor);

        // 使用构造方法创造对象
        Object person = constructor.newInstance("fxy", 21);
        System.out.println(person);
    }
}
