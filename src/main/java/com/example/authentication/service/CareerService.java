package com.example.authentication.service;

import com.example.authentication.model.Career;
import com.example.authentication.repository.CareerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CareerService {

    private final CareerRepository repository;

    public CareerService(CareerRepository repository) {
        this.repository = repository;
    }

    public Career createCareer(Career career) {
        return repository.save(career);
    }

    public List<Career> getAllCareers() {
        return repository.findAll();
    }

    public Career getCareerById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Career Record not found with id: " + id));
    }

    public Career updateCareer(String id, Career updatedDetails) {
        Career existingCareer = getCareerById(id);

        existingCareer.setCareerTitleKh(updatedDetails.getCareerTitleKh());
        existingCareer.setCareerTitleEn(updatedDetails.getCareerTitleEn());
        existingCareer.setCareerTitleCh(updatedDetails.getCareerTitleCh());
        existingCareer.setCareerKh(updatedDetails.getCareerKh());
        existingCareer.setCareerEn(updatedDetails.getCareerEn());
        existingCareer.setCareerCh(updatedDetails.getCareerCh());
        existingCareer.setDetailKh(updatedDetails.getDetailKh());
        existingCareer.setDetailEn(updatedDetails.getDetailEn());
        existingCareer.setDetailCh(updatedDetails.getDetailCh());
        existingCareer.setLinkKh(updatedDetails.getLinkKh());
        existingCareer.setLinkEn(updatedDetails.getLinkEn());
        existingCareer.setLinkCh(updatedDetails.getLinkCh());
        existingCareer.setPostDate(updatedDetails.getPostDate());
        existingCareer.setCloseDate(updatedDetails.getCloseDate());
        existingCareer.setStatus(updatedDetails.getStatus());
        existingCareer.setShortId(updatedDetails.getShortId());
        existingCareer.setReorder(updatedDetails.getReorder());


        if (updatedDetails.getImage() != null) {
            existingCareer.setImage(updatedDetails.getImage());
        }

        return repository.save(existingCareer);
    }

    public void deleteCareer(String id) {
        Career existingCareer = getCareerById(id);
        repository.delete(existingCareer);
    }
}