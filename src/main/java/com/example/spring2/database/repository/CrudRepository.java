package com.example.spring2.database.repository;

import java.util.Optional;

public interface CrudRepository<Integer, Company> {
   Optional<Company> findById(Integer id);
}
