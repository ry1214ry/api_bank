package com.example.authentication.service;

import com.example.authentication.model.ProductTitle;
import com.example.authentication.repository.ProductTitleRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductTitleService {

    private final ProductTitleRepository repository;

    public ProductTitleService(ProductTitleRepository repository) {
        this.repository = repository;
    }

    public ProductTitle createTitle(ProductTitle productTitle) {
        return repository.save(productTitle);
    }

    public List<ProductTitle> getAllTitles() {
        return repository.findAll();
    }

    public ProductTitle getTitleById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Title not found with id: " + id));
    }

    public ProductTitle updateTitle(Integer id, ProductTitle updatedDetails) {
        ProductTitle existingTitle = getTitleById(id);

        existingTitle.setProTitleKh(updatedDetails.getProTitleKh());
        existingTitle.setProTitleEn(updatedDetails.getProTitleEn());
        existingTitle.setProTitleCh(updatedDetails.getProTitleCh());
        return repository.save(existingTitle);

    }
    public void deleteTitle(Integer id) {
        ProductTitle existingTitle = getTitleById(id);
        repository.delete(existingTitle);
    }
}