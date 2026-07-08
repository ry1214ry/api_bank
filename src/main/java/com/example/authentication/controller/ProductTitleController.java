package com.example.authentication.controller;

import com.example.authentication.model.ProductTitle;
import com.example.authentication.service.ProductTitleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-title")
public class ProductTitleController {

    private final ProductTitleService service;

    public ProductTitleController(ProductTitleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductTitle> createTitle(@RequestBody ProductTitle productTitle) {
        return ResponseEntity.ok(service.createTitle(productTitle));
    }

    @GetMapping
    public ResponseEntity<List<ProductTitle>> getAllTitles() {
        return ResponseEntity.ok(service.getAllTitles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTitle> getTitleById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getTitleById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductTitle> updateTitle(@PathVariable Integer id, @RequestBody ProductTitle details) {
        return ResponseEntity.ok(service.updateTitle(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTitle(@PathVariable Integer id) {
        service.deleteTitle(id);
        return ResponseEntity.ok("Product Title deleted successfully with ID: " + id);
    }
}