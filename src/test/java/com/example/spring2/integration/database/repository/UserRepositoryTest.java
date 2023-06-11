package com.example.spring2.integration.database.repository;

import com.example.spring2.database.entity.Role;
import com.example.spring2.database.entity.User;
import com.example.spring2.database.repository.UserRepository;
import com.example.spring2.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@IT
@RequiredArgsConstructor
@Transactional
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    public void checkQueries() {
        final var users = userRepository.findAllBy("a", "ov");
        System.out.println(users);
    }

    @Test
    public void updateRole() {
        final var result = userRepository.updateRole(Role.USER, 1L, 5L);
        System.out.println(result);
    }

    //сортировка как профи
    @Test
    public void PeageableSort() {
        final var pageable = PageRequest.of(1, 2, Sort.by("id"));
        final var result = userRepository.findAllBy(pageable);
        assertThat(result).hasSize(2);
    }

//сортировка
    @Test
    public void checkFirstTop() {
        //сортировка удобным способом
        final var sortBy = Sort.sort(User.class);
        final var sort = sortBy.by(User::getFirstname).and(sortBy.by(User::getLastname));
        final var userList = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sort);

        //неудобным способом сортировка потому что имя метода длинное
        final var users = userRepository.findTop3ByBirthDateBeforeOrderByBirthDateDesc(LocalDate.now());    //Top3 это первые 3 User
        assertThat(users).hasSize(3);
    }
}