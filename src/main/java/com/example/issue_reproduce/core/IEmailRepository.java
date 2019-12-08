package com.example.issue_reproduce.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IEmailRepository extends JpaRepository<Email, Long>, JpaSpecificationExecutor<Email> {
    Optional<Email> findById(long emailId);
}
