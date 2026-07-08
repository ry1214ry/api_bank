package com.example.authentication.controller;

import com.example.authentication.model.Infrastructure;
import com.example.authentication.service.InfrastructureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/infrastructure")
public class InfrastructureController {

    private final InfrastructureService service;

    public InfrastructureController(InfrastructureService service) {
        this.service = service;
    }

    @GetMapping
    public List<Infrastructure> getAllData() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Infrastructure> getDataById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Infrastructure createData(@RequestBody Infrastructure infrastructure) {
        return service.create(infrastructure);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Infrastructure> updateData(@PathVariable Integer id, @RequestBody Infrastructure infrastructure) {
        try {
            return ResponseEntity.ok(service.update(id, infrastructure));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}