package org.example.web.day1.Annotation;

import java.lang.reflect.Method;

/**
 * @author: 卑微小冯
 * Date: 2020/9/5 上午7:49
 * Project: learningProjects
 * Package: org.example.web.day1.Annotation
 *
 * 当方法执行后，会自动检测所有家了check注解的方法，判断方法是否有异常
 */

public class TestCheck {
    public static void main(String[] args) {
        //1. 创建计算器对象
        TestCalc calc = new TestCalc();
        Class c = calc.getClass();

        Method[] methods = c.getMethods();

        int num = 0;

        for (Method method : methods) {
            if(method.isAnnotationPresent(Check.class)){
                try{
                    method.invoke(calc, 1,0);
                }catch (Exception e){
                    System.out.println("第"+num+"个方法出异常了");
                    System.out.println("异常名称"+e.getCause().getClass().getSimpleName());
                    System.out.println("异常原因"+e.getCause().getMessage());
                }
                num++;
            }
        }

        System.out.println(num);
    }
}
