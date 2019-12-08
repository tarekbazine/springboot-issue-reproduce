package com.example.issue_reproduce.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface IDocumentRepository extends JpaRepository<Document, Long>, JpaSpecificationExecutor<Document> {
	Optional<Document> findById(long id);
	
}
