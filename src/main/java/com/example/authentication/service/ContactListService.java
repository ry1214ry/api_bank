package com.example.authentication.service;

import com.example.authentication.model.ContactList;
import com.example.authentication.repository.ContactListRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactListService {

    private final ContactListRepository repository;

    public ContactListService(ContactListRepository repository) {
        this.repository = repository;
    }

    public ContactList createContactList(ContactList contactList) {
        return repository.save(contactList);
    }

    public List<ContactList> getAllContactLists() {
        return repository.findAll();
    }

    public ContactList getContactListById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact List record not found with id: " + id));
    }

    public ContactList updateContactList(Integer id, ContactList updatedDetails) {
        ContactList existingRecord = getContactListById(id);
        existingRecord.setFileName(updatedDetails.getFileName());
        existingRecord.setFileUpload(updatedDetails.getFileUpload());
        existingRecord.setStatus(updatedDetails.getStatus());
        return repository.save(existingRecord);
    }

    public void deleteContactList(Integer id) {
        ContactList existingRecord = getContactListById(id);
        repository.delete(existingRecord);
    }
}