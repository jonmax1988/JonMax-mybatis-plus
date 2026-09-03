package com.jonmax.conf;

import com.jonmax.bean.Jon;
import com.jonmax.bean.Max;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "cartoon")
@Data
public class CartoonProperties {
    private Jon jon;
    private Max max;
}
