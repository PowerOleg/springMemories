package com.example.spring2.integration.database.repository;

import com.example.spring2.database.entity.Company;
import com.example.spring2.integration.annotation.IT;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
@Transactional
//@Commit
class CompanyRepositoryTest {
    private final EntityManager entityManager;

    @Test
    void test_findById() {
        final int expectedLocales = 2;
        final var company = entityManager.find(Company.class, 1);
        Assertions.assertNotNull(company);
        final var locales = company.getLocales().size();
        Assertions.assertEquals(expectedLocales, locales);
    }

    @Test
    void save() {
        final var company = Company.builder().name("Apple")
                .locales(Map.of(
                        "ru", "Apple описание",
                        "en", "Apple desctiption"
                )).build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}