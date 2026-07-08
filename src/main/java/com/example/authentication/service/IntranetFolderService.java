package com.example.authentication.service;

import com.example.authentication.model.IntranetFolder;
import com.example.authentication.repository.IntranetFolderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IntranetFolderService {

    private final IntranetFolderRepository repository;

    public IntranetFolderService(IntranetFolderRepository repository) {
        this.repository = repository;
    }

    public IntranetFolder createFolder(IntranetFolder folder) {
        return repository.save(folder);
    }

    public List<IntranetFolder> getAllFolders() {
        return repository.findAll();
    }

    public IntranetFolder getFolderById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Folder Record not found with id: " + id));
    }

    public IntranetFolder updateFolder(Integer id, IntranetFolder updatedDetails) {
        IntranetFolder existingFolder = getFolderById(id);

        existingFolder.setFolderName(updatedDetails.getFolderName());
        existingFolder.setFolderCategory(updatedDetails.getFolderCategory());
        existingFolder.setFolderStatus(updatedDetails.getFolderStatus());

        return repository.save(existingFolder);
    }

    public void deleteFolder(Integer id) {
        IntranetFolder existingFolder = getFolderById(id);
        repository.delete(existingFolder);
    }
}