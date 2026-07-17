package com.example.authentication.controller;

import com.example.authentication.model.Career;
import com.example.authentication.service.CareerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/career")
@CrossOrigin(origins = "*")
public class CareerController {

    private final CareerService service;
    private final String UPLOAD_DIR = "./images/news/";

    public CareerController(CareerService service) {
        this.service = service;
    }

    // 1. POST Endpoint - Handles multipart/form-data via @ModelAttribute
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Career> createCareer(@ModelAttribute Career career,
                                               @RequestParam(value = "file", required = false) MultipartFile file) {
        handleImageUpload(career, file);
        return ResponseEntity.ok(service.createCareer(career));
    }

    @GetMapping
    public ResponseEntity<List<Career>> getAllCareers() {
        return ResponseEntity.ok(service.getAllCareers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Career> getCareerById(@PathVariable String id) {
        return ResponseEntity.ok(service.getCareerById(id));
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<Career> updateCareer(@PathVariable String id,
                                               @ModelAttribute Career details,
                                               @RequestParam(value = "file", required = false) MultipartFile file) {
        handleImageUpload(details, file);
        return ResponseEntity.ok(service.updateCareer(id, details));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCareer(@PathVariable String id) {
        service.deleteCareer(id);
        return ResponseEntity.ok("Career Record deleted successfully with ID: " + id);
    }




    private void handleImageUpload(Career career, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                Path uploadPath = Paths.get(UPLOAD_DIR);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(file.getInputStream(), filePath);

                career.setImage("images/news/" + fileName);
            } catch (IOException e) {
                throw new RuntimeException("Could not save image file: " + e.getMessage());
            }
        }
    }
}