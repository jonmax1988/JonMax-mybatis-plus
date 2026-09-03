package com.jonmax.bean;

import com.jonmax.conf.CartoonProperties;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.annotation.PostConstruct;


@Data
@EnableConfigurationProperties(CartoonProperties.class)
public class CartoonJonAndMax {

    private Jon jon;
    private Max max;

    @Autowired
    private CartoonProperties ctp;

    public CartoonJonAndMax() {
        jon = new Jon();
        max = new Max();
    }

    @PostConstruct
    public void init() {
        jon.setName(ctp.getJon() != null && StringUtils.isNotBlank(ctp.getJon().getName()) ? ctp.getJon().getName() : "jon");
        jon.setAge(ctp.getJon() != null && ctp.getJon().getAge() != null ? ctp.getJon().getAge() : 20);
        max.setName(ctp.getMax() != null && StringUtils.isNotBlank(ctp.getMax().getName()) ? ctp.getMax().getName() : "max");
        max.setAge(ctp.getMax() != null && ctp.getMax().getAge() != null ? ctp.getMax().getAge() : 22);
    }

    public void play() {
        System.out.println("Name is " + jon.getName() + " and age is " + jon.getAge() +
                " play with " +
                "name is " + max.getName() + " and age is " + max.getAge() + ". They are very happy,HA HA!!!");
    }
}
