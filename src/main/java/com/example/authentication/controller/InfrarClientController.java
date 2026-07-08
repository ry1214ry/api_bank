package com.example.authentication.controller;

import com.example.authentication.model.InfrarClient;
import com.example.authentication.service.InfrarClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/infrar-clients")
public class InfrarClientController {

    private final InfrarClientService service;

    public InfrarClientController(InfrarClientService service) {
        this.service = service;
    }


    @GetMapping
    public List<InfrarClient> getAllClients() {
        return service.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<InfrarClient> getClientById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public InfrarClient createClient(@RequestBody InfrarClient client) {
        return service.create(client);
    }


    @PutMapping("/{id}")
    public ResponseEntity<InfrarClient> updateClient(@PathVariable Integer id, @RequestBody InfrarClient client) {
        try {
            return ResponseEntity.ok(service.update(id, client));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}