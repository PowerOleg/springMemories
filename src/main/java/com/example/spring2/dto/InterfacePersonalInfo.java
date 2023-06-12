package com.example.spring2.dto;

import org.springframework.beans.factory.annotation.Value;

public interface InterfacePersonalInfo {
     String getFirstname();
     String getBirthDate();

     @Value("#{target.firstname + ' ' + target.birthDate}")
     String getFullname();
}
