package com.example.authentication.controller;

import com.example.authentication.model.Position;
import com.example.authentication.service.PositionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/positions")
public class PositionController {

    private final PositionService service;

    public PositionController(PositionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Position>> getAllPositions() {
        return ResponseEntity.ok(service.getAllPositions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPositionById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPositionById(id));
    }

    @PostMapping
    public ResponseEntity<Position> createPosition(@RequestBody Position position) {
        return ResponseEntity.ok(service.createPosition(position));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Position> updatePosition(@PathVariable Integer id, @RequestBody Position position) {
        return ResponseEntity.ok(service.updatePosition(id, position));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePosition(@PathVariable Integer id) {
        service.deletePosition(id);
        return ResponseEntity.ok("Position record deleted successfully with ID: " + id);
    }
}