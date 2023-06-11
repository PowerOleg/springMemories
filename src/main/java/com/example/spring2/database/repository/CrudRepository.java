package com.example.spring2.database.repository;

import com.example.spring2.database.entity.Company;

import java.util.Optional;
//устарел;
public interface CrudRepository<Company, Integer> {
    Optional<com.example.spring2.database.entity.Company> findById(java.lang.Integer id);
}
