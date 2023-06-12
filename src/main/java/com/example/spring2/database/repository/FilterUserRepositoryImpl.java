package com.example.spring2.database.repository;

import com.example.spring2.database.entity.User;
import com.example.spring2.dto.UserFilter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository {

    private final EntityManager entityManager;

    @Override
    public List<User> findAllByFilter(UserFilter userFilter) {
        final var criteriaBuilder = entityManager.getCriteriaBuilder();
        final var criteria = criteriaBuilder.createQuery(User.class);

        final var root = criteria.from(User.class);
        criteria.select(root);
        List<Predicate> predicates = new ArrayList<>();
        if (userFilter.getFirstname() != null) {
            predicates.add(criteriaBuilder.like(root.get("firstname"), userFilter.getFirstname()));
        }
        if (userFilter.getLastname() != null) {
            predicates.add(criteriaBuilder.like(root.get("lastname"), userFilter.getLastname()));
        }
        if (userFilter.getBirthDate() != null) {
            predicates.add(criteriaBuilder.lessThan(root.get("birthDate"), userFilter.getBirthDate()));
        }
        criteria.where(predicates.toArray(Predicate[]::new));
        return entityManager.createQuery(criteria).getResultList();
    }
}
