package com.example.authentication.service;

import com.example.authentication.model.Infrastructure;
import com.example.authentication.repository.InfrastructureRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InfrastructureService {

    private final InfrastructureRepository repository;

    public InfrastructureService(InfrastructureRepository repository) {
        this.repository = repository;
    }

    public List<Infrastructure> getAll() {
        return repository.findAll();
    }

    public Optional<Infrastructure> getById(Integer id) {
        return repository.findById(id);
    }

    public Infrastructure create(Infrastructure infrastructure) {
        return repository.save(infrastructure);
    }

    public Infrastructure update(Integer id, Infrastructure details) {
        return repository.findById(id).map(existing -> {
            existing.setInfrarName(details.getInfrarName());
            existing.setInfrarFile(details.getInfrarFile());
            existing.setInfrarCategory(details.getInfrarCategory());
            existing.setFolderName(details.getFolderName());
            existing.setInfrarStatus(details.getInfrarStatus());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Record not found with id " + id));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}