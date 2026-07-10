package com.example.authentication.service;

import com.example.authentication.model.Promotion;
import com.example.authentication.repository.PromotionRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PromotionService {

    private final PromotionRepository repository;
    private final String UPLOAD_DIR = "./images/promotions/";

    public PromotionService(PromotionRepository repository) {
        this.repository = repository;
    }

    public Promotion createPromotion(Promotion promotion) {
        return repository.save(promotion);
    }

    public List<Promotion> getAllPromotions() {
        return repository.findAll();
    }

    public Promotion getPromotionById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Promotion record not found with id: " + id));
    }

    public Promotion updatePromotion(Integer id, Promotion updatedDetails) {
        Promotion existingPromo = getPromotionById(id);

        if (updatedDetails.getImageBg() != null && !existingPromo.getImageBg().equals(updatedDetails.getImageBg())) {
            deletePhysicalFile(existingPromo.getImageBg());
        }
        if (updatedDetails.getImageM() != null && !existingPromo.getImageM().equals(updatedDetails.getImageM())) {
            deletePhysicalFile(existingPromo.getImageM());
        }
        if (updatedDetails.getImageD() != null && !existingPromo.getImageD().equals(updatedDetails.getImageD())) {
            deletePhysicalFile(existingPromo.getImageD());
        }
        if (updatedDetails.getImageHover() != null && !existingPromo.getImageHover().equals(updatedDetails.getImageHover())) {
            deletePhysicalFile(existingPromo.getImageHover());
        }

        existingPromo.setProKh(updatedDetails.getProKh());
        existingPromo.setProEn(updatedDetails.getProEn());
        existingPromo.setProCh(updatedDetails.getProCh());
        existingPromo.setImageBg(updatedDetails.getImageBg());
        existingPromo.setPeriodDate(updatedDetails.getPeriodDate());
        existingPromo.setDetailKh(updatedDetails.getDetailKh());
        existingPromo.setDetailEn(updatedDetails.getDetailEn());
        existingPromo.setDetailCh(updatedDetails.getDetailCh());
        existingPromo.setStatus(updatedDetails.getStatus());
        existingPromo.setImageM(updatedDetails.getImageM());
        existingPromo.setImageD(updatedDetails.getImageD());
        existingPromo.setImageHover(updatedDetails.getImageHover());
        existingPromo.setValid(updatedDetails.getValid());
        existingPromo.setExpire(updatedDetails.getExpire());

        return repository.save(existingPromo);
    }

    public void deletePromotion(Integer id) {
        Promotion existingPromo = getPromotionById(id);

        deletePhysicalFile(existingPromo.getImageBg());
        deletePhysicalFile(existingPromo.getImageM());
        deletePhysicalFile(existingPromo.getImageD());
        deletePhysicalFile(existingPromo.getImageHover());
        repository.delete(existingPromo);
    }

    private void deletePhysicalFile(String fileName) {
        try {
            if (fileName != null && !fileName.isEmpty()) {
                Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);
                Files.deleteIfExists(filePath);
            }
        } catch (IOException e) {
            System.err.println("Failed to delete promotion file from disk: " + e.getMessage());
        }
    }
}