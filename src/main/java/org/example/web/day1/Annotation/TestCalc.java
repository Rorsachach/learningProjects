package org.example.web.day1.Annotation;

/**
 * @author: 卑微小冯
 * Date: 2020/9/5 上午7:51
 * Project: learningProjects
 * Package: org.example.web.day1.Annotation
 */

public class TestCalc {
    @Check
    public int add(int a, int b){
        return a/b;
    }

    @Check
    public int sub(int a, int b){
        return a-b;
    }

    @Check
    public int mul(int a, int b){
        return a*b;
    }

    @Check
    public int div(int a, int b){
        return a/b;
    }

    @Check
    public void show(int a, int b){
        System.out.println("ending...");
    }
}
