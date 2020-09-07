package org.example.web.day2.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: 卑微小冯
 * Date: 2020/9/7 上午3:03
 * Project: learningProjects
 * Package: org.example.web.day2.c3p0
 */

public class C3P02 {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();

        for(int i = 1; i <= 10; i++){
            Connection conn = ds.getConnection();
            System.out.println(conn);
        }

        DataSource ds2 = new ComboPooledDataSource("otherc3p0"); // 可以使用其他名称的连接池

        for(int i = 1; i <= 10; i++){
            Connection conn = ds2.getConnection();
            System.out.println(conn);
        }
    }
}
