package com.example.authentication.service;

import com.example.authentication.model.ItRequestForm;
import com.example.authentication.repository.ItRequestFormRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItRequestFormService {

    private final ItRequestFormRepository repository;

    public ItRequestFormService(ItRequestFormRepository repository) {
        this.repository = repository;
    }

    public ItRequestForm createRequest(ItRequestForm form) {
        return repository.save(form);
    }

    public List<ItRequestForm> getAllRequests() {
        return repository.findAll();
    }

    public ItRequestForm getRequestById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("IT Request record not found with id: " + id));
    }

    public ItRequestForm updateRequest(Integer id, ItRequestForm updatedDetails) {
        ItRequestForm existingForm = getRequestById(id);

        existingForm.setReq1(updatedDetails.getReq1());
        existingForm.setReq2(updatedDetails.getReq2());
        existingForm.setReq3(updatedDetails.getReq3());
        existingForm.setReq4(updatedDetails.getReq4());
        existingForm.setReq5(updatedDetails.getReq5());
        existingForm.setReq6(updatedDetails.getReq6());
        existingForm.setReq7(updatedDetails.getReq7());
        existingForm.setWindowLogon(updatedDetails.getWindowLogon());
        existingForm.setEmail(updatedDetails.getEmail());
        existingForm.setCassisSystem(updatedDetails.getCassisSystem());
        existingForm.setTricubeSystem(updatedDetails.getTricubeSystem());
        existingForm.setPc(updatedDetails.getPc());
        existingForm.setPrinter(updatedDetails.getPrinter());
        existingForm.setWebsite(updatedDetails.getWebsite());
        existingForm.setOther(updatedDetails.getOther());
        existingForm.setReq8(updatedDetails.getReq8());
        existingForm.setRegisterDate(updatedDetails.getRegisterDate());
        existingForm.setAcceptance(updatedDetails.getAcceptance());
        existingForm.setItProcess1(updatedDetails.getItProcess1());
        existingForm.setItProcess2(updatedDetails.getItProcess2());
        existingForm.setItProcess3(updatedDetails.getItProcess3());
        existingForm.setItProcess4(updatedDetails.getItProcess4());
        existingForm.setItProcess5(updatedDetails.getItProcess5());
        existingForm.setItProcess6(updatedDetails.getItProcess6());
        existingForm.setItProcess7(updatedDetails.getItProcess7());
        existingForm.setItProcess8(updatedDetails.getItProcess8());
        existingForm.setUserAccept1(updatedDetails.getUserAccept1());
        existingForm.setUserAccept2(updatedDetails.getUserAccept2());
        existingForm.setUserAccept3(updatedDetails.getUserAccept3());
        existingForm.setUserAccept4(updatedDetails.getUserAccept4());
        return repository.save(existingForm);
    }

    public void deleteRequest(Integer id) {
        ItRequestForm existingForm = getRequestById(id);
        repository.delete(existingForm);
    }
}