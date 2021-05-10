package com.mapei.www.entity;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "com.mapei")
public class Properties {
    private String name;
    private String age;
    private List<String> address;
}
