package com.example.spring2.integration.database.repository;

import com.example.spring2.database.entity.Role;
import com.example.spring2.database.entity.User;
import com.example.spring2.database.repository.UserRepository;
import com.example.spring2.dto.PersonalInfo;
import com.example.spring2.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
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

    //test Projection
    @Test
    public void test_projection() {
        var users = userRepository.findAllByCompanyId(1);
        System.out.println(users);
//        final var personalInfoList = userRepository.findByFirstname("Petr", PersonalInfo.class);
//        System.out.println(personalInfoList);
    }



    //сортировка как профи используя Page
    @Test
    public void PeageableSortPageTest() {
        final var pageable = PageRequest.of(1, 2, Sort.by("id"));
        var page = userRepository.findBy(pageable);                                          //суть тут
        page.forEach(n -> System.out.println(n.getCompany().getName()));
        assertThat(page).hasSize(2);

        while (page.hasNext()) {
            page = userRepository.findBy(page.nextPageable());
            page.forEach(n -> System.out.println(n.getCompany().getName()));
        }
    }

    //сортировка как профи используя Slice
    @Test
    public void PeageableSortSliceTest() {
        final var pageable = PageRequest.of(1, 2, Sort.by("id"));
        var slice = userRepository.findAllBy(pageable);                                             //суть тут
        slice.forEach(n -> System.out.println(n.getId()));
        assertThat(slice).hasSize(2);

        while (slice.hasNext()) {
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(n -> System.out.println(n.getId()));
        }

    }

    //сортировка не как профи
    @Test
    public void checkFirstTop() {
        //сортировка удобным способом
        final var sortBy = Sort.sort(User.class);
        final var sort = sortBy.by(User::getFirstname).and(sortBy.by(User::getLastname));
        final var userList = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sort);
        System.out.println(userList);

//        //неудобным способом сортировка потому что имя метода длинное
//        final var users = userRepository.findTop3ByBirthDateBeforeOrderByBirthDateDesc(LocalDate.now());    //Top3 это первые 3 User
//        assertThat(users).hasSize(3);
    }

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




}