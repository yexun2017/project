package com.wwx.myo2o.test.annotation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/11/2  15:26
 **/
public class Test {
    public static void main(String[] args) {
        try {
            CustomAnnotationProcessor.processor(DBUtil.class);
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tb_person_info");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long maxMemory = Runtime.getRuntime().maxMemory();  //返回Java虚拟机试图使用的最大内存量。
        Long totalMemory = Runtime.getRuntime().totalMemory();  //返回Java虚拟机中的内存总量。
        System.out.println("MAX_MEMORY ="+maxMemory +"(字节)、"+(maxMemory/(double)1024/1024) + "MB");
        System.out.println("TOTAL_ MEMORY = "+totalMemory +"(字节)"+(totalMemory/(double)1024/1024) + "MB");
    }
}
