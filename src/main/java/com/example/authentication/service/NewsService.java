package com.example.authentication.service;

import com.example.authentication.model.News;
import com.example.authentication.repository.NewsRepository;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class NewsService {

    private final NewsRepository repository;
    private final String UPLOAD_DIR = "./images/news/";

    public NewsService(NewsRepository repository) {
        this.repository = repository;
    }

    public News createNews(News news) {
        return repository.save(news);
    }

    public List<News> getAllNews() {
        return repository.findAll();
    }

    public News getNewsById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("News record not found with id: " + id));
    }

    public News updateNews(Integer id, News updatedDetails) {
        News existingNews = getNewsById(id);

        // Clean out old physical files if they are replaced with new names
        if (updatedDetails.getImageBg() != null && !existingNews.getImageBg().equals(updatedDetails.getImageBg())) {
            deletePhysicalFile(existingNews.getImageBg());
        }
        if (updatedDetails.getImageM() != null && !existingNews.getImageM().equals(updatedDetails.getImageM())) {
            deletePhysicalFile(existingNews.getImageM());
        }
        if (updatedDetails.getImageD() != null && !existingNews.getImageD().equals(updatedDetails.getImageD())) {
            deletePhysicalFile(existingNews.getImageD());
        }
        if (updatedDetails.getImageHover() != null && !existingNews.getImageHover().equals(updatedDetails.getImageHover())) {
            deletePhysicalFile(existingNews.getImageHover());
        }
        if (updatedDetails.getImageShare() != null && !existingNews.getImageShare().equals(updatedDetails.getImageShare())) {
            deletePhysicalFile(existingNews.getImageShare());
        }

        existingNews.setProKh(updatedDetails.getProKh());
        existingNews.setProEn(updatedDetails.getProEn());
        existingNews.setProCh(updatedDetails.getProCh());
        existingNews.setImageBg(updatedDetails.getImageBg());
        existingNews.setPeriodDate(updatedDetails.getPeriodDate());
        existingNews.setDetailKh(updatedDetails.getDetailKh());
        existingNews.setDetailEn(updatedDetails.getDetailEn());
        existingNews.setDetailCh(updatedDetails.getDetailCh());
        existingNews.setStatus(updatedDetails.getStatus());
        existingNews.setImageM(updatedDetails.getImageM());
        existingNews.setImageD(updatedDetails.getImageD());
        existingNews.setImageHover(updatedDetails.getImageHover());
        existingNews.setValid(updatedDetails.getValid());
        existingNews.setExpire(updatedDetails.getExpire());
        existingNews.setImageShare(updatedDetails.getImageShare());

        return repository.save(existingNews);
    }

    public void deleteNews(Integer id) {
        News existingNews = getNewsById(id);

        deletePhysicalFile(existingNews.getImageBg());
        deletePhysicalFile(existingNews.getImageM());
        deletePhysicalFile(existingNews.getImageD());
        deletePhysicalFile(existingNews.getImageHover());
        deletePhysicalFile(existingNews.getImageShare());

        repository.delete(existingNews);
    }

    private void deletePhysicalFile(String fileName) {
        try {
            if (fileName != null && !fileName.isEmpty()) {
                Path filePath = Paths.get(UPLOAD_DIR).resolve(fileName);
                Files.deleteIfExists(filePath);
            }
        } catch (IOException e) {
            System.err.println("Failed to delete news file from disk: " + e.getMessage());
        }
    }
}