package com.example.authentication.controller;

import com.example.authentication.model.CareerCv;
import com.example.authentication.service.CareerCvService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/careerCV")
@CrossOrigin(origins = "*")
public class CareerCvController {

    private final CareerCvService service;

    public CareerCvController(CareerCvService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CareerCv> createCv(@RequestBody CareerCv careerCv) {
        return ResponseEntity.ok(service.createCv(careerCv));
    }

    @GetMapping
    public ResponseEntity<List<CareerCv>> getAllCvs() {
        return ResponseEntity.ok(service.getAllCvs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CareerCv> getCvById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCvById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CareerCv> updateCv(@PathVariable Integer id, @RequestBody CareerCv details) {
        return ResponseEntity.ok(service.updateCv(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCv(@PathVariable Integer id) {
        service.deleteCv(id);
        return ResponseEntity.ok("CV Record deleted successfully with ID: " + id);
    }
}