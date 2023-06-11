package com.example.spring2.database.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "company")
//@RequiredArgsConstructor
//@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQuery(name = "Company.findByName", query="select c from Company c where lower(c.name) = lower(:name)")
public class Company implements BaseEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "company_locales", joinColumns = @JoinColumn(name = "company_id"))
    @MapKeyColumn(name = "lang")
    @Column(name = "description")
    @Builder.Default
    private Map<String, String> locales = new HashMap<>();
}
