package com.example.authentication.controller;

import com.example.authentication.model.ContactUs;
import com.example.authentication.service.ContactUsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contact-us")
public class ContactUsController {

    private final ContactUsService service;
    private final String UPLOAD_DIR = "./images/contacts/";

    public ContactUsController(ContactUsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ContactUs>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactUs> getContactById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getContactById(id));
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createContact(
            @RequestParam("location") String location,
            @RequestParam("tproduct") String tproduct,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("phone") Integer phone,
            @RequestParam("email") String email,
            @RequestParam("ccustomer") String ccustomer,
            @RequestParam("feedback") String feedback,
            @RequestParam("tfeedback") String tfeedback,
            @RequestParam("date") String date,
            @RequestParam("image") MultipartFile imageFile) {

        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            String imageName = imageFile.getOriginalFilename();
            Files.copy(imageFile.getInputStream(), uploadPath.resolve(imageName), StandardCopyOption.REPLACE_EXISTING);

            ContactUs contactUs = new ContactUs(location, tproduct, firstname, lastname, phone,
                    email, ccustomer, feedback, tfeedback, imageName, date);

            return ResponseEntity.ok(service.createContact(contactUs));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error saving contact asset: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> updateContact(
            @PathVariable Integer id,
            @RequestParam("location") String location,
            @RequestParam("tproduct") String tproduct,
            @RequestParam("firstname") String firstname,
            @RequestParam("lastname") String lastname,
            @RequestParam("phone") Integer phone,
            @RequestParam("email") String email,
            @RequestParam("ccustomer") String ccustomer,
            @RequestParam("feedback") String feedback,
            @RequestParam("tfeedback") String tfeedback,
            @RequestParam("date") String date,
            @RequestParam(value = "image", required = false) MultipartFile imageFile) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            ContactUs existingContact = service.getContactById(id);

            String imageName = existingContact.getImage();
            if (imageFile != null && !imageFile.isEmpty()) {
                if (imageName != null && !imageName.equals(imageFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageName));
                }
                imageName = imageFile.getOriginalFilename();
                Files.copy(imageFile.getInputStream(), uploadPath.resolve(imageName), StandardCopyOption.REPLACE_EXISTING);
            }

            ContactUs updatedDetails = new ContactUs(location, tproduct, firstname, lastname, phone,
                    email, ccustomer, feedback, tfeedback, imageName, date);

            return ResponseEntity.ok(service.updateContact(id, updatedDetails));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error updating contact asset: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Integer id) {
        service.deleteContact(id);
        return ResponseEntity.ok("Contact record and file deleted successfully with ID: " + id);
    }
}