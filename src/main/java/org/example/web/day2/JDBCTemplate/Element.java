package org.example.web.day2.JDBCTemplate;

/**
 * @author: 卑微小冯
 * Date: 2020/9/7 上午5:23
 * Project: learningProjects
 * Package: org.example.web.day2.JDBCTemplate
 */

public class Element {
    Integer num;
    String name;

    @Override
    public String toString() {
        return "Element{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Element(Integer num, String name) {
        this.num = num;
        this.name = name;
    }

    public Element() {
    }
}
