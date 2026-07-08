package com.example.authentication.controller;

import com.example.authentication.model.IntranetFolder;
import com.example.authentication.service.IntranetFolderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/intranet-folders")
public class IntranetFolderController {

    private final IntranetFolderService service;

    public IntranetFolderController(IntranetFolderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<IntranetFolder> createFolder(@RequestBody IntranetFolder folder) {
        return ResponseEntity.ok(service.createFolder(folder));
    }

    @GetMapping
    public ResponseEntity<List<IntranetFolder>> getAllFolders() {
        return ResponseEntity.ok(service.getAllFolders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntranetFolder> getFolderById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getFolderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IntranetFolder> updateFolder(@PathVariable Integer id, @RequestBody IntranetFolder details) {
        return ResponseEntity.ok(service.updateFolder(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFolder(@PathVariable Integer id) {
        service.deleteFolder(id);
        return ResponseEntity.ok("Folder Record deleted successfully with ID: " + id);
    }
}