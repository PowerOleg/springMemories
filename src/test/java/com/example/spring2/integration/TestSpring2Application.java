package com.example.spring2.integration;

import com.example.spring2.ConnectionPool;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;

@TestConfiguration
public class TestSpring2Application {

    @SpyBean(name = "connectionPool")
    private ConnectionPool connectionPool;

}
