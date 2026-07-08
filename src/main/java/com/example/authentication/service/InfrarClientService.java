package com.example.authentication.service;

import com.example.authentication.model.InfrarClient;
import com.example.authentication.repository.InfrarClientRepository;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class InfrarClientService {

    private final InfrarClientRepository repository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a", Locale.ENGLISH);

    public InfrarClientService(InfrarClientRepository repository) {
        this.repository = repository;
    }

    public List<InfrarClient> getAll() {
        return repository.findAll();
    }

    public Optional<InfrarClient> getById(Integer id) {
        return repository.findById(id);
    }

    // CREATE: Encrypts password to MD5 + sets date
    public InfrarClient create(InfrarClient client) {
        String encryptedPassword = convertToMd5(client.getPassword());
        client.setPassword(encryptedPassword);

        String formattedCurrentDate = LocalDateTime.now().format(formatter);
        client.setDateRegister(formattedCurrentDate);

        return repository.save(client);
    }

    // UPDATE: Encrypts password to MD5 if updated
    public InfrarClient update(Integer id, InfrarClient details) {
        return repository.findById(id).map(existing -> {
            existing.setUsername(details.getUsername());

            if (details.getPassword() != null && !details.getPassword().isEmpty()) {
                existing.setPassword(convertToMd5(details.getPassword()));
            }

            existing.setDepartment(details.getDepartment());
            existing.setEmail(details.getEmail());

            if (details.getDateRegister() != null) {
                existing.setDateRegister(details.getDateRegister());
            }
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Client not found with id " + id));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }


    private String convertToMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting password to MD5", e);
        }
    }
}