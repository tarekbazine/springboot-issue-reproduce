package com.example.issue_reproduce.core;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IEmailRepository extends JpaRepository<Email, Long> {
	Optional<Email> findById(long emailId);
}
