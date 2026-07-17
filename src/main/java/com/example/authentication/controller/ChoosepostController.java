package com.example.authentication.controller;

import com.example.authentication.model.Choosepost;
import com.example.authentication.service.ChoosepostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chooseposts")
public class ChoosepostController {

    private final ChoosepostService service;

    public ChoosepostController(ChoosepostService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Choosepost> createPost(@RequestBody Choosepost choosepost) {
        return ResponseEntity.ok(service.createPost(choosepost));
    }

    @GetMapping
    public ResponseEntity<List<Choosepost>> getAllPosts() {
        return ResponseEntity.ok(service.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Choosepost> getPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Choosepost> updatePost(@PathVariable Integer id, @RequestBody Choosepost details) {
        return ResponseEntity.ok(service.updatePost(id, details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Integer id) {
        service.deletePost(id);
        return ResponseEntity.ok("Post Record deleted successfully with ID: " + id);
    }

}