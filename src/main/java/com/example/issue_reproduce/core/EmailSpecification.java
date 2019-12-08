package com.example.issue_reproduce.core;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class EmailSpecification implements Specification<Email> {


    @Override
    public Predicate toPredicate(Root<Email> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();


//        predicates.add(criteriaBuilder.like(root.get("name"), "%xx%"));


        query.orderBy(criteriaBuilder.asc(root.join("document", JoinType.LEFT).get("name")));

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

    }
}
