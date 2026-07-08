package com.example.authentication.service;

import com.example.authentication.model.Newsletter;
import com.example.authentication.repository.NewsletterRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewsletterService {

    private final NewsletterRepository repository;

    public NewsletterService(NewsletterRepository repository) {
        this.repository = repository;
    }

    public Newsletter createNewsletter(Newsletter newsletter) {
        return repository.save(newsletter);
    }

    public List<Newsletter> getAllNewsletters() {
        return repository.findAll();
    }

    public Newsletter getNewsletterById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Newsletter Record not found with id: " + id));
    }

    public Newsletter updateNewsletter(Integer id, Newsletter updatedDetails) {
        Newsletter existingNewsletter = getNewsletterById(id);

        existingNewsletter.setEmail(updatedDetails.getEmail());
        existingNewsletter.setPhone(updatedDetails.getPhone());
        existingNewsletter.setRegisterDate(updatedDetails.getRegisterDate());

        return repository.save(existingNewsletter);
    }

    public void deleteNewsletter(Integer id) {
        Newsletter existingNewsletter = getNewsletterById(id);
        repository.delete(existingNewsletter);
    }
}