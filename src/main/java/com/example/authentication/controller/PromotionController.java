package com.example.authentication.controller;

import com.example.authentication.model.Promotion;
import com.example.authentication.service.PromotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/api/v1/promotions")
public class PromotionController {

    private final PromotionService service;
    private final String UPLOAD_DIR = "./images/promotions/";

    public PromotionController(PromotionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Promotion>> getAllPromotions() {
        return ResponseEntity.ok(service.getAllPromotions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getPromotionById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPromotionById(id));
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createPromotion(
            @RequestParam("proKh") String proKh,
            @RequestParam("proEn") String proEn,
            @RequestParam("proCh") String proCh,
            @RequestParam("periodDate") String periodDate,
            @RequestParam("detailKh") String detailKh,
            @RequestParam("detailEn") String detailEn,
            @RequestParam("detailCh") String detailCh,
            @RequestParam("status") String status,
            @RequestParam("valid") String valid,
            @RequestParam("expire") String expire,
            @RequestParam("imageBg") MultipartFile imageBgFile,
            @RequestParam("imageM") MultipartFile imageMFile,
            @RequestParam("imageD") MultipartFile imageDFile,
            @RequestParam("imageHover") MultipartFile imageHoverFile) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String imageBgName = imageBgFile.getOriginalFilename();
            String imageMName = imageMFile.getOriginalFilename();
            String imageDName = imageDFile.getOriginalFilename();
            String imageHoverName = imageHoverFile.getOriginalFilename();

            Files.copy(imageBgFile.getInputStream(), uploadPath.resolve(imageBgName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageMFile.getInputStream(), uploadPath.resolve(imageMName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageDFile.getInputStream(), uploadPath.resolve(imageDName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageHoverFile.getInputStream(), uploadPath.resolve(imageHoverName), StandardCopyOption.REPLACE_EXISTING);

            Promotion promotion = new Promotion(proKh, proEn, proCh, imageBgName, periodDate,
                    detailKh, detailEn, detailCh, status, imageMName, imageDName, imageHoverName, valid, expire);

            return ResponseEntity.ok(service.createPromotion(promotion));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error saving promotion assets: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> updatePromotion(
            @PathVariable Integer id,
            @RequestParam("proKh") String proKh,
            @RequestParam("proEn") String proEn,
            @RequestParam("proCh") String proCh,
            @RequestParam("periodDate") String periodDate,
            @RequestParam("detailKh") String detailKh,
            @RequestParam("detailEn") String detailEn,
            @RequestParam("detailCh") String detailCh,
            @RequestParam("status") String status,
            @RequestParam("valid") String valid,
            @RequestParam("expire") String expire,
            @RequestParam(value = "imageBg", required = false) MultipartFile imageBgFile,
            @RequestParam(value = "imageM", required = false) MultipartFile imageMFile,
            @RequestParam(value = "imageD", required = false) MultipartFile imageDFile,
            @RequestParam(value = "imageHover", required = false) MultipartFile imageHoverFile) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            Promotion existingPromo = service.getPromotionById(id);

            String imageBgName = existingPromo.getImageBg();
            if (imageBgFile != null && !imageBgFile.isEmpty()) {
                if (imageBgName != null && !imageBgName.equals(imageBgFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageBgName));
                }
                imageBgName = imageBgFile.getOriginalFilename();
                Files.copy(imageBgFile.getInputStream(), uploadPath.resolve(imageBgName), StandardCopyOption.REPLACE_EXISTING);
            }

            String imageMName = existingPromo.getImageM();
            if (imageMFile != null && !imageMFile.isEmpty()) {
                if (imageMName != null && !imageMName.equals(imageMFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageMName));
                }
                imageMName = imageMFile.getOriginalFilename();
                Files.copy(imageMFile.getInputStream(), uploadPath.resolve(imageMName), StandardCopyOption.REPLACE_EXISTING);
            }

            String imageDName = existingPromo.getImageD();
            if (imageDFile != null && !imageDFile.isEmpty()) {
                if (imageDName != null && !imageDName.equals(imageDFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageDName));
                }
                imageDName = imageDFile.getOriginalFilename();
                Files.copy(imageDFile.getInputStream(), uploadPath.resolve(imageDName), StandardCopyOption.REPLACE_EXISTING);
            }

            String imageHoverName = existingPromo.getImageHover();
            if (imageHoverFile != null && !imageHoverFile.isEmpty()) {
                if (imageHoverName != null && !imageHoverName.equals(imageHoverFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageHoverName));
                }
                imageHoverName = imageHoverFile.getOriginalFilename();
                Files.copy(imageHoverFile.getInputStream(), uploadPath.resolve(imageHoverName), StandardCopyOption.REPLACE_EXISTING);
            }

            Promotion updatedDetails = new Promotion(proKh, proEn, proCh, imageBgName, periodDate,
                    detailKh, detailEn, detailCh, status, imageMName, imageDName, imageHoverName, valid, expire);

            return ResponseEntity.ok(service.updatePromotion(id, updatedDetails));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error updating promotion assets: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePromotion(@PathVariable Integer id) {
        service.deletePromotion(id);
        return ResponseEntity.ok("Promotion record and files deleted successfully with ID: " + id);
    }
}