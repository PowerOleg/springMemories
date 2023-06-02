package com.example.spring2.integration.service;

import com.example.spring2.Spring2Application;
import com.example.spring2.config.DatabaseProperties;
import com.example.spring2.database.Company;
import com.example.spring2.eventListener.EntityEvent;
import com.example.spring2.integration.annotation.IT;
import com.example.spring2.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = Spring2Application.class, initializers = ConfigDataApplicationContextInitializer.class)
@IT
@RequiredArgsConstructor
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyServiceIT {
    public static final Integer COMPANY_ID = 1;
    private final CompanyService companyService;
    private final DatabaseProperties databaseProperties;

    @Test
    void findById() {
        final var result = companyService.findById(COMPANY_ID);
        Assertions.assertTrue(result.isPresent());
        final var expected = new Company(COMPANY_ID);

        result.ifPresent(actual -> assertEquals(expected, actual));
    }

}
