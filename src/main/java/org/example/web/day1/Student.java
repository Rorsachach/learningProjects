package org.example.web.day1;

import org.example.web.day1.Annotation.MyAnno;

/**
 * @author: 卑微小冯
 * ate: 2020/9/5 上午6:14
 * Project: learningProjects
 * Package: org.example.web.day1
 */

@MyAnno(age = 1)
public class Student {
    public void study(){
        System.out.println("Studying...");
    }
}
