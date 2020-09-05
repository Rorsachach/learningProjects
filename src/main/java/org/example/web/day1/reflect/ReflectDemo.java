package org.example.web.day1.reflect;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Author: 卑微小冯
 * Date: 2020/9/5 上午6:13
 * Project: learningProjects
 * Package: org.example.web.day1.reflect
 */

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        // 可以创建任意类的对象，可以执行任意方法,举例 Person 和 Student
        // 创建Properties对象
        Properties properties = new Properties();
        // 加载配置文件
        // 可以使用类加载器来获取配置文件的路径
        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        properties.load(classLoader.getResourceAsStream("reflectDemoPro.properties"));

        // 获取数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        // 加载类
        Class c = Class.forName(className);
        // 创建对象
        Object o = c.getConstructor().newInstance();
        // 获取方法对象
        Method method = c.getMethod(methodName);
        // 执行方法
        method.invoke(o);
    }
}
