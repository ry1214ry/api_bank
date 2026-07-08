package com.example.authentication.service;

import com.example.authentication.model.InfrarCategory;
import com.example.authentication.repository.InfrarCategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InfrarCategoryService {

    private final InfrarCategoryRepository repository;

    public InfrarCategoryService(InfrarCategoryRepository repository) {
        this.repository = repository;
    }


    // Get all categories
    public List<InfrarCategory> getAll() {
        return repository.findAll();
    }

    // Get category by ID
    public Optional<InfrarCategory> getById(Integer id) {
        return repository.findById(id);
    }


    // Create a new category
    public InfrarCategory create(InfrarCategory category) {
        return repository.save(category);
    }

    // Update an existing category
    public InfrarCategory update(Integer id, InfrarCategory details) {
        return repository.findById(id).map(existing -> {
            existing.setInfrarCategory(details.getInfrarCategory());
            existing.setStatus(details.getStatus());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    }

    // Delete a category
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}