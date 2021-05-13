package com.bmmt.demo.controllers;

import com.bmmt.demo.entities.Contact;
import com.bmmt.demo.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> create(Contact contact) {
        return new ResponseEntity<>(contactService.create(contact), HttpStatus.CREATED);
    }

    @GetMapping("/contact/all")
    public ResponseEntity<Iterable<Contact>> getAll() {
        return new ResponseEntity<>(contactService.index(), HttpStatus.OK);
    }

    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getById(@PathVariable Long id) {
        return new ResponseEntity<>(contactService.show(id), HttpStatus.OK);
    }

    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id, Contact contact) {
        return new ResponseEntity<>(contactService.update(id, contact), HttpStatus.OK);
    }
}
