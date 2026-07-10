package com.example.authentication.controller;

import com.example.authentication.model.Newsletter;
import com.example.authentication.service.NewsletterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/newsletter")
public class NewsletterController {

    private final NewsletterService service;

    public NewsletterController(NewsletterService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Newsletter> createNewsletter(@RequestBody Newsletter newsletter) {
        return ResponseEntity.ok(service.createNewsletter(newsletter));
    }

    @GetMapping
    public ResponseEntity<List<Newsletter>> getAllNewsletters() {
        return ResponseEntity.ok(service.getAllNewsletters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Newsletter> getNewsletterById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getNewsletterById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Newsletter> updateNewsletter(@PathVariable Integer id, @RequestBody Newsletter details) {
        return ResponseEntity.ok(service.updateNewsletter(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNewsletter(@PathVariable Integer id) {
        service.deleteNewsletter(id);
        return ResponseEntity.ok("Newsletter Record deleted successfully with ID: " + id);
    }


}