package com.example.issue_reproduce;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "text")
    private String text;

    @Column(name = "document")
    private Document document;
}