package com.example.spring2.database.repository;

import com.example.spring2.ConnectionPool;
import com.example.spring2.database.entity.Company;
import com.example.spring2.database.entity.Payment;
import com.example.spring2.database.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CompanyRepositoryAuto extends JpaRepository<Company, Integer> {

    Optional<Company> findByIdAndName(Integer id, String name);                         //мой метод ищет сразу по двум столбцам, указал бы OR делал бы или а не и
    List<Company> findDistinctByNameContainingIgnoreCase(String fragment);

    //метод для @NamedQuery
    Optional<Company> findByName(String name);

    //метод для SimpleJpaQuery
    @Query(value = "select u from User u" +
//            " join fetch u.chat ch" +
            " where u.username = :username")
    Optional<User> findByUsername(String username);

    @Query(value = "select c from Company c" +
            " join fetch c.locales cl" +
            " where c.name = :name")
    Optional<Company> findByCompanyName(String name);
}
