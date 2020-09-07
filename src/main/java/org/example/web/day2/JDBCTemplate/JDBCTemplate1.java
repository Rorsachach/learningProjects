package org.example.web.day2.JDBCTemplate;

import org.example.web.day2.druid.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author: 卑微小冯
 * Date: 2020/9/7 上午5:07
 * Project: learningProjects
 * Package: org.example.web.day2.JDBCTemplate
 */

public class JDBCTemplate1 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

        String sql = "update student set name='zxcv' where num=?";
        template.update(sql, 6);
    }
}
