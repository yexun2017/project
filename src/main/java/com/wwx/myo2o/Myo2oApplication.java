package com.wwx.myo2o;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
@MapperScan("com.wwx.myo2o.mapper")
/*@ComponentScan("com.wwx.myo2o.entity")
@ComponentScan("com.wwx.myo2o.service.**")*/
@EnableTransactionManagement
public class Myo2oApplication {
    public static void main(String[] args) {
        SpringApplication.run(Myo2oApplication.class, args);
        //todo 怎么配置logback
    }
}
