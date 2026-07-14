package com.example.authentication.controller;

import com.example.authentication.model.ItRequestForm;
import com.example.authentication.service.ItRequestFormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/it-requests")
public class ItRequestFormController {

    private final ItRequestFormService service;

    public ItRequestFormController(ItRequestFormService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ItRequestForm> createRequest(@RequestBody ItRequestForm form) {
        return ResponseEntity.ok(service.createRequest(form));
    }

    @GetMapping
    public ResponseEntity<List<ItRequestForm>> getAllRequests() {
        return ResponseEntity.ok(service.getAllRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItRequestForm> getRequestById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getRequestById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItRequestForm> updateRequest(@PathVariable Integer id, @RequestBody ItRequestForm details) {
        return ResponseEntity.ok(service.updateRequest(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRequest(@PathVariable Integer id) {
        service.deleteRequest(id);
        return ResponseEntity.ok("IT Request Record deleted successfully with ID: " + id);
    }
}