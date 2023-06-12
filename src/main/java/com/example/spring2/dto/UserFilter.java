package com.example.spring2.dto;


import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

//тесткласс, класс чтобы динамически искать пользователей
@Value
@Builder
public class UserFilter {
    String firstname;
    String lastname;
    LocalDate birthDate;
}
