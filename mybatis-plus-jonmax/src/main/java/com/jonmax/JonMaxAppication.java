package com.jonmax;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
@MapperScan("com.jonmax.mapper")
public class JonMaxAppication {
    public static void main(String[] args) {

        SpringApplication.run(JonMaxAppication.class, args);
    }
}
