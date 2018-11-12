package com.wwx.myo2o.test.annotation;

import java.sql.Connection;

/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/11/2  15:26
 **/
public class DBUtil {
    private DBUtil() {//构造方法
    }
    @CustomConnection(url = "jdbc:mysql://localhost:3306/project-o2o?useSSL=false",
            driverClass = "com.mysql.jdbc.Driver",
            username = "root",
            password = "")
    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }
}
