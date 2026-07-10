package com.example.authentication.controller;

import com.example.authentication.model.ContactList;
import com.example.authentication.service.ContactListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contact-lists")
public class ContactListController {

    private final ContactListService service;

    public ContactListController(ContactListService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ContactList>> getAllContactLists() {
        return ResponseEntity.ok(service.getAllContactLists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactList> getContactListById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getContactListById(id));
    }

    @PostMapping
    public ResponseEntity<ContactList> createContactList(@RequestBody ContactList contactList) {
        return ResponseEntity.ok(service.createContactList(contactList));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactList> updateContactList(@PathVariable Integer id, @RequestBody ContactList contactList) {
        return ResponseEntity.ok(service.updateContactList(id, contactList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContactList(@PathVariable Integer id) {
        service.deleteContactList(id);
        return ResponseEntity.ok("Contact List record deleted successfully with ID: " + id);
    }
}