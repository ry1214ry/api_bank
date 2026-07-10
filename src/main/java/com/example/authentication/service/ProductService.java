package com.example.authentication.service;

import com.example.authentication.model.Product;
import com.example.authentication.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProductService {


    private final ProductRepository repository;
    private final String UPLOAD_DIR = "./product/";
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }
    public Product getProductById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
    public Product updateProduct(Integer id, Product updatedDetails) {
        Product existingProduct = getProductById(id);


        if (updatedDetails.getImage() != null && !existingProduct.getImage().equals(updatedDetails.getImage())) {
            deletePhysicalFile(existingProduct.getImage());
        }
        if (updatedDetails.getImageM() != null && !existingProduct.getImageM().equals(updatedDetails.getImageM())) {
            deletePhysicalFile(existingProduct.getImageM());
        }
        if (updatedDetails.getImageD() != null && !existingProduct.getImageD().equals(updatedDetails.getImageD())) {
            deletePhysicalFile(existingProduct.getImageD());
        }

        existingProduct.setProKh(updatedDetails.getProKh());
        existingProduct.setProEn(updatedDetails.getProEn());
        existingProduct.setProCh(updatedDetails.getProCh());
        existingProduct.setLinkKh(updatedDetails.getLinkKh());
        existingProduct.setLinkEn(updatedDetails.getLinkEn());
        existingProduct.setLinkCh(updatedDetails.getLinkCh());
        existingProduct.setImage(updatedDetails.getImage());
        existingProduct.setBoxDetailKh(updatedDetails.getBoxDetailKh());
        existingProduct.setBoxDetailEn(updatedDetails.getBoxDetailEn());
        existingProduct.setBoxDetailCh(updatedDetails.getBoxDetailCh());
        existingProduct.setDetailKh(updatedDetails.getDetailKh());
        existingProduct.setDetailEn(updatedDetails.getDetailEn());
        existingProduct.setDetailCh(updatedDetails.getDetailCh());
        existingProduct.setStatus(updatedDetails.getStatus());
        existingProduct.setImageM(updatedDetails.getImageM());
        existingProduct.setImageD(updatedDetails.getImageD());
        existingProduct.setVisible(updatedDetails.getVisible());
        return repository.save(existingProduct);
    }

    public void deleteProduct(Integer id) {
        Product existingProduct = getProductById(id);

        deletePhysicalFile(existingProduct.getImage());
        deletePhysicalFile(existingProduct.getImageM());
        deletePhysicalFile(existingProduct.getImageD());
        repository.delete(existingProduct);
    }
    private void deletePhysicalFile(String fileName) {
        try {
            if (fileName != null && !fileName.isEmpty()) {
                Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);
                Files.deleteIfExists(filePath);
            }
        } catch (IOException e) {
            System.err.println("Failed to delete file from disk: " + e.getMessage());
        }
    }
}