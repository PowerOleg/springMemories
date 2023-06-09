package com.example.spring2.database.repository;

import com.example.spring2.ConnectionPool;
import com.example.spring2.database.entity.Company;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.Repository;


import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CompanyRepositoryAuto extends CrudRepository<Company, Integer>, Repository<Company, Integer> {

//    Optional<Company> findById(Integer id);

}
