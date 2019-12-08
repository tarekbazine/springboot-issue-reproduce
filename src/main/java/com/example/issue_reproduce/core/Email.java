package com.example.issue_reproduce.core;

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

    @Column(name = "seen")
    private Boolean seen;

    @OneToOne
    private Document document;


    public Email(){}

    public Email(Boolean seen, Document document) {
        this.seen = seen;
        this.document = document;
    }
}