package com.example.spring2.repository;

import com.example.spring2.ConnectionPool;
import com.example.spring2.database.Company;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer, Company> {
    private final ConnectionPool connectionPool;//pool1;
//может добавить @Value? тут инициализация через конструктор - все хорошо
    private final List<ConnectionPool> pools;
    @Value("${db.poolProperties.size}")
    private final Integer poolSize;




    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById");
        return Optional.of(new Company(id));
    }

    @PostConstruct
    private void init() {
        log.warn("Init of company repository");
    }
}
