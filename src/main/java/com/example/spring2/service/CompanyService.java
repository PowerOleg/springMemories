package com.example.spring2.service;

import com.example.spring2.database.entity.Company;
import com.example.spring2.eventListener.AccessType;
import com.example.spring2.eventListener.EntityEvent;
import com.example.spring2.repository.CrudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;             //!!!Добавляет способность Listener'а который мы в Listener прописали

    public Optional<Company/*CompanyReadDto*/> findById(Integer id) {
        return companyRepository.findById(id).map(entity -> {
            eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
            return new Company(entity.getId(), null, Collections.emptyMap());                                                          //?
        });
    }
}
