package com.example.spring2.database.repository;

import com.example.spring2.ConnectionPool;
import com.example.spring2.database.entity.Company;
import com.example.spring2.database.entity.Role;
import com.example.spring2.database.entity.User;
import com.example.spring2.dto.InterfacePersonalInfo;
import com.example.spring2.dto.PersonalInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.time.LocalDate;
import java.util.List;

//@Repository                   //можно убрать т.к. мы extends от Repository И значит нас видят
public interface UserRepository extends JpaRepository<User, Long>, FilterUserRepository {
    //test Projection используем интерфейсы как профи
    @Query(value = "SELECT firstname, birth_date birthDate FROM users WHERE company_id = :companyId   ", nativeQuery = true)
    List<InterfacePersonalInfo> findAllByCompanyId(Integer companyId);

    //test Projection используя класс
//    List<PersonalInfo> findAllByCompanyId(Integer companyId);

    //test Projection
    <T> List<T> findByFirstname(String firstname, Class<T> clazz);





    //удобная сортировка используя Pageable  возвращая Page с учетом общего числа страничек
//    @Query(value = "select u from User u", countQuery = "select count(distinct u.firstname) from User u") //можно изменить подсчет общего числа
    //страничек используя countQuery
//   @EntityGraph("User.company")       //создали используя первый параметр value
   @EntityGraph(attributePaths = {"company"})               //создали используя параметр attributePath
    Page<User> findBy(Pageable pageable);

    //удобная сортировка используя Pageable, возвращая SLice
    Slice<User> findAllBy(Pageable pageable);

//    удобная сортировка + Lock
    @QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value ="50"))
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<User> findTop3ByBirthDateBefore(LocalDate localDate, Sort sort);


        //PartTreeJpaRepository  //неудобным способом можно сортировать так
    List<User> findTop3ByBirthDateBeforeOrderByBirthDateDesc(LocalDate localDate);



    @Query(value = "select u from User u where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "update User u set u.role = :role where u.id in (:ids)")
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    int updateRole(Role role, Long... ids);


}
