package com.example.authentication.controller;

import com.example.authentication.model.News;
import com.example.authentication.service.NewsService;
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
@RequestMapping("/api/v1/news")
public class NewsController {

    private final NewsService service;
    private final String UPLOAD_DIR = "./images/news/";

    public NewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<News>> getAllNews() {
        return ResponseEntity.ok(service.getAllNews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getNewsById(id));
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createNews(
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
            @RequestParam("imageHover") MultipartFile imageHoverFile,
            @RequestParam("imageShare") MultipartFile imageShareFile) {

        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String imageBgName = imageBgFile.getOriginalFilename();
            String imageMName = imageMFile.getOriginalFilename();
            String imageDName = imageDFile.getOriginalFilename();
            String imageHoverName = imageHoverFile.getOriginalFilename();
            String imageShareName = imageShareFile.getOriginalFilename();

            Files.copy(imageBgFile.getInputStream(), uploadPath.resolve(imageBgName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageMFile.getInputStream(), uploadPath.resolve(imageMName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageDFile.getInputStream(), uploadPath.resolve(imageDName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageHoverFile.getInputStream(), uploadPath.resolve(imageHoverName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageShareFile.getInputStream(), uploadPath.resolve(imageShareName), StandardCopyOption.REPLACE_EXISTING);

            News news = new News(proKh, proEn, proCh, imageBgName, periodDate, detailKh, detailEn, detailCh,
                    status, imageMName, imageDName, imageHoverName, valid, expire, imageShareName);

            return ResponseEntity.ok(service.createNews(news));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error saving news images: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> updateNews(
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
            @RequestParam(value = "imageHover", required = false) MultipartFile imageHoverFile,
            @RequestParam(value = "imageShare", required = false) MultipartFile imageShareFile) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            News existingNews = service.getNewsById(id);

            String imageBgName = existingNews.getImageBg();
            if (imageBgFile != null && !imageBgFile.isEmpty()) {
                if (imageBgName != null && !imageBgName.equals(imageBgFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageBgName));
                }
                imageBgName = imageBgFile.getOriginalFilename();
                Files.copy(imageBgFile.getInputStream(), uploadPath.resolve(imageBgName), StandardCopyOption.REPLACE_EXISTING);
            }

            String imageMName = existingNews.getImageM();
            if (imageMFile != null && !imageMFile.isEmpty()) {
                if (imageMName != null && !imageMName.equals(imageMFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageMName));
                }
                imageMName = imageMFile.getOriginalFilename();
                Files.copy(imageMFile.getInputStream(), uploadPath.resolve(imageMName), StandardCopyOption.REPLACE_EXISTING);
            }

            String imageDName = existingNews.getImageD();
            if (imageDFile != null && !imageDFile.isEmpty()) {
                if (imageDName != null && !imageDName.equals(imageDFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageDName));
                }
                imageDName = imageDFile.getOriginalFilename();
                Files.copy(imageDFile.getInputStream(), uploadPath.resolve(imageDName), StandardCopyOption.REPLACE_EXISTING);
            }

            String imageHoverName = existingNews.getImageHover();
            if (imageHoverFile != null && !imageHoverFile.isEmpty()) {
                if (imageHoverName != null && !imageHoverName.equals(imageHoverFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageHoverName));
                }
                imageHoverName = imageHoverFile.getOriginalFilename();
                Files.copy(imageHoverFile.getInputStream(), uploadPath.resolve(imageHoverName), StandardCopyOption.REPLACE_EXISTING);
            }

            String imageShareName = existingNews.getImageShare();
            if (imageShareFile != null && !imageShareFile.isEmpty()) {
                if (imageShareName != null && !imageShareName.equals(imageShareFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageShareName));
                }
                imageShareName = imageShareFile.getOriginalFilename();
                Files.copy(imageShareFile.getInputStream(), uploadPath.resolve(imageShareName), StandardCopyOption.REPLACE_EXISTING);
            }

            News updatedDetails = new News(proKh, proEn, proCh, imageBgName, periodDate, detailKh, detailEn, detailCh,
                    status, imageMName, imageDName, imageHoverName, valid, expire, imageShareName);

            return ResponseEntity.ok(service.updateNews(id, updatedDetails));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error updating news images: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNews(@PathVariable Integer id) {
        service.deleteNews(id);
        return ResponseEntity.ok("News record and associated files deleted successfully with ID: " + id);
    }
}