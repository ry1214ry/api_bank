package com.example.authentication.service;

import com.example.authentication.model.TblInfrarnet;
import com.example.authentication.repository.TblInfrarnetRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TblInfrarnetService {

    private final TblInfrarnetRepository repository;

    public TblInfrarnetService(TblInfrarnetRepository repository) {
        this.repository = repository;
    }

    public List<TblInfrarnet> getAll() {
        return repository.findAll();
    }

    public Optional<TblInfrarnet> getById(Integer id) {
        return repository.findById(id);
    }

    public TblInfrarnet create(TblInfrarnet tblInfrarnet) {
        return repository.save(tblInfrarnet);
    }

    public TblInfrarnet update(Integer id, TblInfrarnet details) {
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