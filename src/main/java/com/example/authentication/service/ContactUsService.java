package com.example.authentication.service;

import com.example.authentication.model.ContactUs;
import com.example.authentication.repository.ContactUsRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ContactUsService {

    private final ContactUsRepository repository;
    private final String UPLOAD_DIR = "./images/contacts/";

    public ContactUsService(ContactUsRepository repository) {
        this.repository = repository;
    }

    public ContactUs createContact(ContactUs contactUs) {
        return repository.save(contactUs);
    }

    public List<ContactUs> getAllContacts() {
        return repository.findAll();
    }

    public ContactUs getContactById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact record not found with id: " + id));
    }

    public ContactUs updateContact(Integer id, ContactUs updatedDetails) {
        ContactUs existingContact = getContactById(id);

        // Clean out the old physical file if it's being replaced with a new one
        if (updatedDetails.getImage() != null && !existingContact.getImage().equals(updatedDetails.getImage())) {
            deletePhysicalFile(existingContact.getImage());
        }

        // Field Updates
        existingContact.setLocation(updatedDetails.getLocation());
        existingContact.setTproduct(updatedDetails.getTproduct());
        existingContact.setFirstname(updatedDetails.getFirstname());
        existingContact.setLastname(updatedDetails.getLastname());
        existingContact.setPhone(updatedDetails.getPhone());
        existingContact.setEmail(updatedDetails.getEmail());
        existingContact.setCcustomer(updatedDetails.getCcustomer());
        existingContact.setFeedback(updatedDetails.getFeedback());
        existingContact.setTfeedback(updatedDetails.getTfeedback());
        existingContact.setImage(updatedDetails.getImage());
        existingContact.setDate(updatedDetails.getDate());

        return repository.save(existingContact);
    }

    public void deleteContact(Integer id) {
        ContactUs existingContact = getContactById(id);

        // Clean out physical image asset from disk
        deletePhysicalFile(existingContact.getImage());

        repository.delete(existingContact);
    }

    private void deletePhysicalFile(String fileName) {
        try {
            if (fileName != null && !fileName.isEmpty()) {
                Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);
                Files.deleteIfExists(filePath);
            }
        } catch (IOException e) {
            System.err.println("Failed to delete contact file from disk: " + e.getMessage());
        }
    }
}