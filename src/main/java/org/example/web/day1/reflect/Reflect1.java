package org.example.web.day1.reflect;

import org.example.web.day1.Person;

public class Reflect1 {
    public static void main(String[] args) throws Exception {
        // 1. Class.forName("")
        Class cls1 = Class.forName("org.example.web.day1.Person");
        System.out.println(cls1);
        // 2. 类名.class
        System.out.println(Person.class);
        // 3. 对象.getClass()
        Person p = new Person();
        System.out.println(p.getClass());
    }
}
