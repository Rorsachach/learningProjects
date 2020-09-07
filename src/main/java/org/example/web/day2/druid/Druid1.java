package org.example.web.day2.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author: 卑微小冯
 * Date: 2020/9/7 上午3:19
 * Project: learningProjects
 * Package: org.example.web.day2.druid
 */

public class Druid1 {
    public static void main(String[] args) throws Exception {
        // 获取连接池对象
        Properties pro = new Properties();
        pro.load(Druid1.class.getClassLoader().getResourceAsStream("druid.properties"));
        // 获取连接
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
