package org.example.web.day2.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author: 卑微小冯
 * Date: 2020/9/6 上午8:29
 * Project: learningProjects
 * Package: org.example.web.day2
 */

public class JDBC1 {
    public static void main(String[] args) throws Exception{
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取数据库链接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEcoding=utf-8&serverTimezone=UTC", "fxy", "first1999");
        // 定义sql语句
        String sql = "update student set name='wer' where num = 1";
        // 获取sql语句对象
        Statement stmt = connection.createStatement();
        // 处理结果
        int i = stmt.executeUpdate(sql);
        System.out.println(i);
        // 释放资源
        stmt.close();
        connection.close();
    }
}
