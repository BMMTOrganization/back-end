package com.bmmt.demo.services;

import com.bmmt.demo.entities.Faq;
import com.bmmt.demo.repositories.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class FaqService {
    private final FaqRepository faqRepo;

    @Autowired
    public FaqService(FaqRepository faqRepo) {
        this.faqRepo = faqRepo;
    }

    public Iterable<Faq> index() {
        return faqRepo.findAll();
    }

    public Faq show(@PathVariable Long id) {
        return faqRepo.findById(id).get();
    }

    public Faq create(Faq faq) {
        return faqRepo.save(faq);
    }

    public Boolean delete(Long id) {
        faqRepo.delete(show(id));
        return true;
    }

    public Faq update(@PathVariable Long id, Faq faq) {
        Faq original = faqRepo.findById(id).get();
        original.setId(faq.getId());
        original.setAnswer(faq.getAnswer());
        original.setQuestion(faq.getQuestion());
        return faqRepo.save(original);
    }
}
