package com.example.javagraphqlapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication(scanBasePackages = {"com.example.javagraphqlapi","graphql.spring.web.servlet.components"})
@MapperScan(annotationClass = Repository.class,basePackages = {"com.example.javagraphqlapi.dao.mysql"})
public class JavaGraphqlApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaGraphqlApiApplication.class, args);
    }

}
