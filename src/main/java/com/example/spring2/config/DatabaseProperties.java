package com.example.spring2.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

//@Data
//@NoArgsConstructor

@Value
@ConstructorBinding
@ConfigurationProperties(prefix = "db")
public class DatabaseProperties {
    String username;
    String password;
    String driver;
    String url;
    String hosts;
    PoolProperties poolProperties;
    Map<String, Object> properties;
    List<PoolProperties> pools;

    //    @Data
//    @NoArgsConstructor
    @Value
    public static class PoolProperties {
        Integer size;
        Integer timeout;
    }
}
