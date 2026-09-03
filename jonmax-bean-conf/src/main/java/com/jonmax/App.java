package com.jonmax;


import com.jonmax.bean.CartoonJonAndMax;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(CartoonJonAndMax.class)
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class,args);
        CartoonJonAndMax bean = ctx.getBean(CartoonJonAndMax.class);
        bean.play();
    }
}