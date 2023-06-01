package com.example.spring2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component//("pool1")
@RequiredArgsConstructor
public class ConnectionPool {

    @Value("${db.username}")
    private String username;
    @Value("${db.poolProperties.size}")
    private Integer poolSize;
//    @Value("${}")
//    private Person person;

    @PostConstruct
    private void init() {
        log.info("Init connection pool ");
    }

    @PreDestroy
    private void destroy() {
        log.info("Clean connection pool");
    }

}
