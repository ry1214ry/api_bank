package com.example.authentication.controller;

import com.example.authentication.model.Product;
import com.example.authentication.service.ProductService;
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
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService service;
    private final String UPLOAD_DIR = "./images/products/";
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<?> createProduct(
            @RequestParam("proKh") String proKh,
            @RequestParam("proEn") String proEn,
            @RequestParam("proCh") String proCh,
            @RequestParam(value = "linkKh", required = false) String linkKh,
            @RequestParam(value = "linkEn", required = false) String linkEn,
            @RequestParam(value = "linkCh", required = false) String linkCh,
            @RequestParam("boxDetailKh") String boxDetailKh,
            @RequestParam("boxDetailEn") String boxDetailEn,
            @RequestParam("boxDetailCh") String boxDetailCh,
            @RequestParam("detailKh") String detailKh,
            @RequestParam("detailEn") String detailEn,
            @RequestParam("detailCh") String detailCh,
            @RequestParam("status") String status,
            @RequestParam("visible") String visible,
            @RequestParam("image") MultipartFile imageFile,
            @RequestParam("imageM") MultipartFile imageMFile,
            @RequestParam("imageD") MultipartFile imageDFile) {

        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String imageName = imageFile.getOriginalFilename();
            String imageMName = imageMFile.getOriginalFilename();
            String imageDName = imageDFile.getOriginalFilename();

            Files.copy(imageFile.getInputStream(), uploadPath.resolve(imageName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageMFile.getInputStream(), uploadPath.resolve(imageMName), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(imageDFile.getInputStream(), uploadPath.resolve(imageDName), StandardCopyOption.REPLACE_EXISTING);

            Product product = new Product(proKh, proEn, proCh, linkKh, linkEn, linkCh, imageName,
                    boxDetailKh, boxDetailEn, boxDetailCh, detailKh, detailEn, detailCh, status, imageMName, imageDName, visible);

            return ResponseEntity.ok(service.createProduct(product));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error saving product images: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> updateProduct(
            @PathVariable Integer id,
            @RequestParam("proKh") String proKh,
            @RequestParam("proEn") String proEn,
            @RequestParam("proCh") String proCh,
            @RequestParam(value = "linkKh", required = false) String linkKh,
            @RequestParam(value = "linkEn", required = false) String linkEn,
            @RequestParam(value = "linkCh", required = false) String linkCh,
            @RequestParam("boxDetailKh") String boxDetailKh,
            @RequestParam("boxDetailEn") String boxDetailEn,
            @RequestParam("boxDetailCh") String boxDetailCh,
            @RequestParam("detailKh") String detailKh,
            @RequestParam("detailEn") String detailEn,
            @RequestParam("detailCh") String detailCh,
            @RequestParam("status") String status,
            @RequestParam("visible") String visible,
            @RequestParam(value = "image", required = false) MultipartFile imageFile,
            @RequestParam(value = "imageM", required = false) MultipartFile imageMFile,
            @RequestParam(value = "imageD", required = false) MultipartFile imageDFile) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            Product existingProduct = service.getProductById(id);

            String imageName = existingProduct.getImage();
            if (imageFile != null && !imageFile.isEmpty()) {

                if (imageName != null && !imageName.equals(imageFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageName));
                }
                imageName = imageFile.getOriginalFilename();
                Files.copy(imageFile.getInputStream(), uploadPath.resolve(imageName), StandardCopyOption.REPLACE_EXISTING);
            }

            String imageMName = existingProduct.getImageM();
            if (imageMFile != null && !imageMFile.isEmpty()) {

                if (imageMName != null && !imageMName.equals(imageMFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageMName));
                }
                imageMName = imageMFile.getOriginalFilename();
                Files.copy(imageMFile.getInputStream(), uploadPath.resolve(imageMName), StandardCopyOption.REPLACE_EXISTING);
            }

            String imageDName = existingProduct.getImageD();
            if (imageDFile != null && !imageDFile.isEmpty()) {

                if (imageDName != null && !imageDName.equals(imageDFile.getOriginalFilename())) {
                    Files.deleteIfExists(uploadPath.resolve(imageDName));
                }
                imageDName = imageDFile.getOriginalFilename();
                Files.copy(imageDFile.getInputStream(), uploadPath.resolve(imageDName), StandardCopyOption.REPLACE_EXISTING);
            }

            Product updatedDetails = new Product(proKh, proEn, proCh, linkKh, linkEn, linkCh, imageName,
                    boxDetailKh, boxDetailEn, boxDetailCh, detailKh, detailEn, detailCh, status, imageMName, imageDName, visible);

            return ResponseEntity.ok(service.updateProduct(id, updatedDetails));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error updating product images: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        service.deleteProduct(id);
        return ResponseEntity.ok("Product record and associated files deleted successfully with ID: " + id);
    }
}