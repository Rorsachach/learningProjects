package org.example.web.day2.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: 卑微小冯
 * Date: 2020/9/7 上午2:32
 * Project: learningProjects
 * Package: org.example.web.day2.c3p0
 */

public class C3P01 {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();

        System.out.println(conn);
    }
}
