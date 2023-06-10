package com.example.spring2.service;

import com.example.spring2.database.entity.Company;
import com.example.spring2.eventListener.EntityEvent;
import com.example.spring2.database.repository.CrudRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    public static final Integer COMPANY_ID = 1;
    @Mock
    private CrudRepository<Company, Integer> companyRepository;
    @Mock
    private UserService userService;
    @Mock
    private ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private CompanyService companyService;


    @Test
    void findById() {
        Mockito.when(companyRepository.findById(COMPANY_ID)).thenReturn(Optional.of(new Company(COMPANY_ID, null, Collections.emptyMap())));
        final var result = companyService.findById(COMPANY_ID);
        Assertions.assertTrue(result.isPresent());
        final var expected = new Company(COMPANY_ID, null, Collections.emptyMap());

        result.ifPresent(actual -> assertEquals(expected, actual));
//        Assertions.assertEquals();
        Mockito.verify(eventPublisher).publishEvent(ArgumentMatchers.any(EntityEvent.class));
        Mockito.verifyNoMoreInteractions(eventPublisher, userService);
    }
}