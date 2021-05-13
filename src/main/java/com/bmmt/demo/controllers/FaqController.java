package com.bmmt.demo.controllers;

import com.bmmt.demo.entities.Faq;
import com.bmmt.demo.services.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FaqController {
    private final FaqService faqService;

    @Autowired
    public FaqController(FaqService faqService) {
        this.faqService = faqService;
    }

    @PostMapping("/faq")
    public ResponseEntity<Faq> create(Faq faq) {
        return new ResponseEntity<>(faqService.create(faq), HttpStatus.CREATED);
    }

    @GetMapping("/faq/all")
    public ResponseEntity<Iterable<Faq>> getAll() {
        return new ResponseEntity<>(faqService.index(), HttpStatus.OK);
    }

    @GetMapping("/faq/{id}")
    public ResponseEntity<Faq> getById(@PathVariable Long id) {
        return new ResponseEntity<>(faqService.show(id), HttpStatus.OK);
    }

    @PutMapping("/faq/{id}")
    public ResponseEntity<Faq> update(@PathVariable Long id, Faq faq) {
        return new ResponseEntity<>(faqService.update(id, faq), HttpStatus.OK);
    }

//    @DeleteMapping("/faq/{id}")
//    public ResponseEntity<Boolean> destroy(@PathVariable Faq faq){
//        return new ResponseEntity<>(faqService.delete(faq)), HttpStatus.OK);
//    }

}
