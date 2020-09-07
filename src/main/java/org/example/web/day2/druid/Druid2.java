package org.example.web.day2.druid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: 卑微小冯
 * Date: 2020/9/7 上午4:46
 * Project: learningProjects
 * Package: org.example.web.day2.druid
 */

public class Druid2 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstat = null;
        try {
            conn = DruidUtils.getConnection();

            String sql="insert into student values(?,?)";

            pstat = conn.prepareStatement(sql);
            pstat.setInt(1, 6);
            pstat.setString(2, "hello");

            int i = pstat.executeUpdate();
            System.out.println(i);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
          DruidUtils.close(pstat, conn);
        }

    }
}
