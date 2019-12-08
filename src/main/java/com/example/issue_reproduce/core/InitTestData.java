package com.example.issue_reproduce.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class InitTestData {

    @Autowired
    IDocumentRepository documentRepository;

    @Autowired
    IEmailRepository emailRepository;

    Random random;

    @PostConstruct
    public void init() {
        this.random = new Random();

        Document document;
        for (int i = 0; i < 10; i++) {

            document = random.nextBoolean() ? documentRepository.save(new Document("doc " + random.nextInt(20))) : null;

            emailRepository.save(new Email(
                    random.nextBoolean(), document

            ));

        }

    }

}
