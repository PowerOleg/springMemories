package com.example.spring2.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(exclude = "userChats")
@EqualsAndHashCode (of = "username")
//@NamedEntityGraph(name = "User.company", attributeNodes = @NamedAttributeNode("company")) //это нужно для UserRepository @EntityGraph(value)
public class User implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<UserChat> userChats = new ArrayList<>();

}
