package org.example.web.day1.reflect;

import org.example.web.day1.Person;

import java.lang.reflect.Field;

/**
 * 获取成员变量
 * 			* `Field	getDeclaredField(String name)` 获取任意的成员变量
 * 			* `Field[]	getDeclaredFields()` 获取所有成员变量
 * 			* `Field	getField(String name)` 获取public修饰的成员变量
 * 			* `Field[]	getFields()`  获取所有public修饰的成员变量
 * 				* 获取成员变量后主要进行两种方法 `set` 和 `get`
 * 					1. `Object o = field.get(p);// 获取P对象中的成员变量field`
 * 					2. `field.set(p, 3); // 将P对象中的成员变量field设置为3`
 */

public class Reflect2 {
    public static void main(String[] args) throws Exception {
        Class c = Person.class;

        Field[] fields = c.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        Field field = c.getField("height");

        Person p = new Person("fxy", 21);
        Object o = field.get(p);// 获取P对象中的成员变量field
        System.out.println(o);
        field.set(p, 3); // 将P对象中的成员变量field设置为3
        System.out.println(p);

        Field name = c.getDeclaredField("name");

        name.setAccessible(true); // 暴力反射

        System.out.println(name.get(p));
        name.set(p, "ls");
        System.out.println(name.get(p));
    }
}