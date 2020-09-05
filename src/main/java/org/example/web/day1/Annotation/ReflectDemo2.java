package org.example.web.day1.Annotation;

import java.lang.reflect.Constructor;

/**
 * @author: 卑微小冯
 * Date: 2020/9/5 上午7:26
 * Project: learningProjects
 * Package: org.example.web.day1.Annotation
 */

@Pro(className = "org.example.web.day1.Annotation.Student", methodName = "eat")
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        // 1. 解析注解
        // 获取该类的字节码文件
        Class<ReflectDemo2> c = ReflectDemo2.class;
        // 获取注解对象
        // 在内存中生成了一个该注释接口的子类实现对象
        Pro pro = c.getAnnotation(Pro.class);
        // 调用注解对象中定义的抽象方法，获取返回值
        String className = pro.className();
        String methodName = pro.methodName();

        Class cls = Class.forName(className);
        Constructor constructor = cls.getConstructor();
        Object o = constructor.newInstance();
        cls.getMethod(methodName).invoke(o);
    }
}
