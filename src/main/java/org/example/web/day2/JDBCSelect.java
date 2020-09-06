package org.example.web.day2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: 卑微小冯
 * Date: 2020/9/6 上午9:33
 * Project: learningProjects
 * Package: org.example.web.day2
 */

public class JDBCSelect {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "select * from student";

            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                System.out.println("num: " + rs.getInt(1) + " name: " + rs.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stat, conn);
        }
    }
}
