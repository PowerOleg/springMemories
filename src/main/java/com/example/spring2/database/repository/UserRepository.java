package com.example.spring2.database.repository;

import com.example.spring2.ConnectionPool;
import com.example.spring2.database.entity.Company;
import com.example.spring2.database.entity.Role;
import com.example.spring2.database.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

//@Repository                   //можно убрать т.к. мы extends от Repository И значит нас видят
public interface UserRepository extends JpaRepository<User, Long> {
    //удобная сортировка используя Pageable
    List<User> findAllBy(Pageable pageable);

//    удобная сортировка
    List<User> findTop3ByBirthDateBefore(LocalDate localDate, Sort sort);


        //TreeJpa  //неудобным способом можно сортировать так
    List<User> findTop3ByBirthDateBeforeOrderByBirthDateDesc(LocalDate localDate);



    @Query(value = "select u from User u where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "update User u set u.role = :role where u.id in (:ids)")
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    int updateRole(Role role, Long... ids);


}
