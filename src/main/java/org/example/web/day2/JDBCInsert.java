package org.example.web.day2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author: 卑微小冯
 * Date: 2020/9/6 上午8:57
 * Project: learningProjects
 * Package: org.example.web.day2
 */

public class JDBCInsert {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "insert into student values(2, 'fxy')";

            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(statement, connection);
        }
    }
}
