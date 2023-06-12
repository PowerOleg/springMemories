package com.example.spring2.database.repository;

import com.example.spring2.database.entity.User;
import com.example.spring2.dto.UserFilter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilterUserRepository {
    List<User> findAllByFilter(UserFilter userFilter);
}
