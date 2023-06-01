package com.example.spring2.database;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
//@Getter
@Data
public class Company {
    @Value("1")
    private final Integer id;

//    public Company(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getId() {
//        return id;
//    }
}
