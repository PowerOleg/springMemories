package com.example.spring2.database.repository;

import java.util.Optional;

public interface CrudRepository<Company, Integer>{
   Optional<Company> findById(Integer id);
}
