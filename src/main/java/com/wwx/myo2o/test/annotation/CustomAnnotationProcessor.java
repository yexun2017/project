package com.wwx.myo2o.test.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author: wangwx5
 * @Email: wangwx5@asiainfo.com
 * CreateDate: 2018/11/2  15:25
 **/
@SuppressWarnings("unchecked")//不显示警告提示
public class CustomAnnotationProcessor {
    public static <T> void processor(Class<T> clazz) {
        try {
            //T t = clazz.newInstance();
            T t = null;
            Field[] fields = clazz.getDeclaredFields();//获取T对象声明变量

            Constructor<?>[] constructors = clazz.getDeclaredConstructors();//获取T对象的构造函数，因为构造函数的访问级别问题
            for(Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);//无论T对象的构造函数是什么访问级别都可以访问其方法
                t = (T)constructor.newInstance(new Object[]{});
            }

            for(Field field : fields) {
                if(field.isAnnotationPresent(CustomConnection.class)) {
                    CustomConnection customConnection = field.getAnnotation(CustomConnection.class);
                    String url = customConnection.url();
                    String driverClass = customConnection.driverClass();
                    String username = customConnection.username();
                    String password = customConnection.password();
                    Class.forName(driverClass);
                    Connection connection = DriverManager.getConnection(url, username, password);
                    field.setAccessible(true);
                    field.set(t, connection);
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
