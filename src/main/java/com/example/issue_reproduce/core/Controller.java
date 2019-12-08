package com.example.issue_reproduce.core;

import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/emails")
public class Controller {

    @Autowired
    IEmailRepository emailRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> emails() {

        return new ResponseEntity<>(emailRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sorted", method = RequestMethod.GET)
    public ResponseEntity<?> emailsSortedByDocNames() {

        return new ResponseEntity<>(emailRepository.findAll(new EmailSpecification()), HttpStatus.OK);
    }
}
