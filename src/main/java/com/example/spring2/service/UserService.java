package com.example.spring2.service;

import com.example.spring2.database.entity.Company;
import com.example.spring2.database.repository.CompanyRepositoryAuto;
import com.example.spring2.database.repository.CrudRepository;
//import com.example.spring2.repository.UserRepository;
import com.example.spring2.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;                        //найдет по имени

    private final CompanyRepositoryAuto companyRepository;       //найдет по имени, потом пойдет в Qualifier

}
