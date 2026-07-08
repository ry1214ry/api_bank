package com.example.authentication.controller;

import com.example.authentication.model.InfrarCategory;
import com.example.authentication.service.InfrarCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/infrar-categories")
public class InfrarCategoryController {

    private final InfrarCategoryService service;

    public InfrarCategoryController(InfrarCategoryService service) {
        this.service = service;
    }


    @GetMapping
    public List<InfrarCategory> getAllCategories() {
        return service.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<InfrarCategory> getCategoryById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public InfrarCategory createCategory(@RequestBody InfrarCategory category) {
        return service.create(category);
    }


    @PutMapping("/{id}")
    public ResponseEntity<InfrarCategory> updateCategory(@PathVariable Integer id, @RequestBody InfrarCategory category) {
        try {
            return ResponseEntity.ok(service.update(id, category));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


