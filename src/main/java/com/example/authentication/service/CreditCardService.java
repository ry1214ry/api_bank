package com.example.authentication.service;

import com.example.authentication.model.CreditCard;
import com.example.authentication.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
public class CreditCardService {

    private final CreditCardRepository repository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a", Locale.ENGLISH);

    public CreditCardService(CreditCardRepository repository) {
        this.repository = repository;
    }

    public CreditCard createCard(CreditCard card) {
        String formattedCurrentDate = LocalDateTime.now().format(formatter);
        card.setDate(formattedCurrentDate);
        return repository.save(card);
    }

    public List<CreditCard> getAllCards() {
        return repository.findAll();
    }

    public CreditCard getCardById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Credit Card Record not found with id: " + id));
    }

    public CreditCard updateCard(Integer id, CreditCard updatedDetails) {
        CreditCard existingCard = getCardById(id);

        existingCard.setFirstname(updatedDetails.getFirstname());
        existingCard.setEmail(updatedDetails.getEmail());
        existingCard.setPhone(updatedDetails.getPhone());
        existingCard.setLast4digit(updatedDetails.getLast4digit());

        if (updatedDetails.getDate() != null) {
            existingCard.setDate(updatedDetails.getDate());
        }

        return repository.save(existingCard);
    }

    public void deleteCard(Integer id) {
        CreditCard existingCard = getCardById(id);
        repository.delete(existingCard);
    }
}