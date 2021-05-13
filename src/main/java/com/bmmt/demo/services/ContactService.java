package com.bmmt.demo.services;

import com.bmmt.demo.entities.Contact;
import com.bmmt.demo.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ContactService {

    private final ContactRepository contactRepo;

    @Autowired
    public ContactService(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    public Iterable<Contact> index() {
        return contactRepo.findAll();
    }

    public Contact show(@PathVariable Long id) {
        return contactRepo.findById(id).get();
    }

    public Contact create(Contact contact) {
        return contactRepo.save(contact);
    }

    public Boolean delete(Contact contact) {
        contactRepo.delete(contact);
        return true;
    }

    public Contact update(@PathVariable Long id, Contact contact) {
        Contact original = contactRepo.findById(id).get();
        original.setId(contact.getId());
        original.setNumber(contact.getNumber());
        original.setEmail(contact.getEmail());
        original.setDepartment(contact.getDepartment());
        return contactRepo.save(original);
    }
}
