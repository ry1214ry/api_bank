package com.example.authentication.service;

import com.example.authentication.model.CareerCv;
import com.example.authentication.repository.CareerCvRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CareerCvService {

    private final CareerCvRepository repository;

    public CareerCvService(CareerCvRepository repository) {
        this.repository = repository;
    }

    public CareerCv createCv(CareerCv careerCv) {
        return repository.save(careerCv);
    }

    public List<CareerCv> getAllCvs() {
        return repository.findAll();
    }

    public CareerCv getCvById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("CV Record not found with id: " + id));
    }

    public CareerCv updateCv(Integer id, CareerCv updatedDetails) {
        CareerCv existingCv = getCvById(id);

        existingCv.setFirstname(updatedDetails.getFirstname());
        existingCv.setLastname(updatedDetails.getLastname());
        existingCv.setPosition(updatedDetails.getPosition());
        existingCv.setEmail(updatedDetails.getEmail());
        existingCv.setPhonenumber(updatedDetails.getPhonenumber());
        existingCv.setDate(updatedDetails.getDate());
        existingCv.setCv(updatedDetails.getCv());
        existingCv.setStatus(updatedDetails.getStatus());
        return repository.save(existingCv);

    }

    public void deleteCv(Integer id) {
        CareerCv existingCv = getCvById(id);
        repository.delete(existingCv);
    }
}