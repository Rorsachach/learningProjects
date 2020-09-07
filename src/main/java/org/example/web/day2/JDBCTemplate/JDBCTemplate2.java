package org.example.web.day2.JDBCTemplate;

import org.example.web.day2.druid.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: 卑微小冯
 * Date: 2020/9/7 上午5:24
 * Project: learningProjects
 * Package: org.example.web.day2.JDBCTemplate
 */

public class JDBCTemplate2 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        String sql = "select * from student";
        List<Element> query = template.query(sql, new RowMapper<Element>() {
            @Override
            public Element mapRow(ResultSet rs, int i) throws SQLException {
                int num = rs.getInt("num");
                String name = rs.getString("name");

                Element e = new Element();
                e.setName(name);
                e.setNum(num);
                return e;
            }
        });
        for (Element element : query) {
            System.out.println(element);
        }

        // 很重要，更简单
        List<Element> query1 = template.query(sql, new BeanPropertyRowMapper<Element>(Element.class));
        for (Element element : query1) {
            System.out.println(element);
        }
    }
}
