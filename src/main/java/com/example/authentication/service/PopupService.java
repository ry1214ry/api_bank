package com.example.authentication.service;
import com.example.authentication.model.Popup;
import com.example.authentication.repository.PopupRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PopupService {
    private final PopupRepository repository;
    public PopupService(PopupRepository repository) {
        this.repository = repository;
    }
    public Popup createPopup(Popup popup) {
        return repository.save(popup);
    }
    public List<Popup> getAllPopups() {
        return repository.findAll();
    }
    public Popup getPopupById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Popup Record not found with id: " + id));
    }

    public Popup updatePopup(Integer id, Popup updatedDetails) {
        Popup existingPopup = getPopupById(id);
        existingPopup.setStatus(updatedDetails.getStatus());
        existingPopup.setSnow(updatedDetails.getSnow());
        existingPopup.setName(updatedDetails.getName());
        existingPopup.setImageM(updatedDetails.getImageM());
        existingPopup.setImageD(updatedDetails.getImageD());
        existingPopup.setLink(updatedDetails.getLink());
        existingPopup.setSetTime(updatedDetails.getSetTime());
        return repository.save(existingPopup);
    }

    public void deletePopup(Integer id) {
        Popup existingPopup = getPopupById(id);
        repository.delete(existingPopup);
    }
}