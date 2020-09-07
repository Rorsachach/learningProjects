package org.example.web.day2.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: 卑微小冯
 * Date: 2020/9/6 上午9:19
 * Project: learningProjects
 * Package: org.example.web.day2
 */

public class JDBCUpdate {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "update student set name = 'zhw' where num = 1";

            stat = conn.createStatement();
            int i = stat.executeUpdate(sql);
            System.out.println(i);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(stat, conn);
        }
    }
}
