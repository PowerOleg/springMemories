package com.example.spring2.database.repository;

import com.example.spring2.ConnectionPool;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Getter
public class UserRepository {
    @Qualifier("connectionPool") //связь с ConnectionPool
    private final ConnectionPool connectionPool;
}
