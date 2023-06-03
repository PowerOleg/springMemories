package com.example.spring2.integration.service;

import com.example.spring2.ConnectionPool;
import com.example.spring2.integration.annotation.IT;
import com.example.spring2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@IT
@RequiredArgsConstructor
public class UserServiceIT {

    private final UserService userService;
    private final ConnectionPool connectionPool;

    @Test
    void test() {
        System.out.println();
    }
}
