package org.example.web.day2.JDBC;


import java.sql.*;
import java.util.Scanner;

/**
 * @author: 卑微小冯
 * Date: 2020/9/7 上午2:03
 * Project: learningProjects
 * Package: org.example.web.day2
 */

public class JDBCLogin {
    public static void main(String[] args) {
        int num;
        String name;
        Scanner sc = new Scanner(System.in);

        System.out.println("num = ?");
        num = sc.nextInt();
        System.out.println("name = ?");
        name = sc.next();

        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            String sql = "select * from student where num = ? and name = ?";

            pstat = conn.prepareStatement(sql); // 可以防止SQL注入
            pstat.setInt(1, num);
            pstat.setString(2, name);

            rs = pstat.executeQuery();
            if (rs.next())
                System.out.println("yes");
            else
                System.out.println("no");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(rs, pstat, conn);
        }
    }
}
