package com.example.authentication.controller;

import com.example.authentication.model.Popup;
import com.example.authentication.service.PopupService;
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
@RequestMapping("/api/v1/popup")
public class PopupController {

    private final PopupService service;
    private final String UPLOAD_DIR = "./images/popup/";

    public PopupController(PopupService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Popup>> getAllPopups() {
        return ResponseEntity.ok(service.getAllPopups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Popup> getPopupById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPopupById(id));
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createPopup(
            @RequestParam("status") String status,
            @RequestParam("snow") String snow,
            @RequestParam("name") String name,
            @RequestParam("link") String link,
            @RequestParam("setTime") Integer setTime,
            @RequestParam("imageM") MultipartFile imageMFile,
            @RequestParam("imageD") MultipartFile imageDFile) {

        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String imageMName = imageMFile.getOriginalFilename();
            String imageDName = imageDFile.getOriginalFilename();
            Files.copy(imageMFile.getInputStream(), uploadPath.resolve(imageMName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageDFile.getInputStream(), uploadPath.resolve(imageDName), StandardCopyOption.REPLACE_EXISTING);

            Popup popup = new Popup(status, snow, name, imageMName, imageDName, link, setTime);
            return ResponseEntity.ok(service.createPopup(popup));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Failed to save images: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> updatePopup(

            @PathVariable Integer id,
            @RequestParam("status") String status,
            @RequestParam("snow") String snow,
            @RequestParam("name") String name,
            @RequestParam("link") String link,
            @RequestParam("setTime") Integer setTime,
            @RequestParam("imageM") MultipartFile imageMFile,
            @RequestParam("imageD") MultipartFile imageDFile) {

        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            String imageMName = imageMFile.getOriginalFilename();
            String imageDName = imageDFile.getOriginalFilename();

            Files.copy(imageMFile.getInputStream(), uploadPath.resolve(imageMName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageDFile.getInputStream(), uploadPath.resolve(imageDName), StandardCopyOption.REPLACE_EXISTING);
            Popup updatedDetails = new Popup(status, snow, name, imageMName, imageDName, link, setTime);
            return ResponseEntity.ok(service.updatePopup(id, updatedDetails));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Failed to update images: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePopup(@PathVariable Integer id) {
        service.deletePopup(id);
        return ResponseEntity.ok("Popup Record deleted successfully with ID: " + id);
    }
}