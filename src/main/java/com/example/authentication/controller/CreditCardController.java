package com.example.authentication.controller;

import com.example.authentication.model.CreditCard;
import com.example.authentication.service.CreditCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/creditcards")
public class CreditCardController {

    private final CreditCardService service;

    public CreditCardController(CreditCardService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreditCard> createCard(@RequestBody CreditCard card) {
        return ResponseEntity.ok(service.createCard(card));
    }

    @GetMapping
    public ResponseEntity<List<CreditCard>> getAllCards() {
        return ResponseEntity.ok(service.getAllCards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getCardById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCardById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditCard> updateCard(@PathVariable Integer id, @RequestBody CreditCard details) {
        return ResponseEntity.ok(service.updateCard(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCard(@PathVariable Integer id) {
        service.deleteCard(id);
        return ResponseEntity.ok("Credit Card Record deleted successfully with ID: " + id);
    }
}