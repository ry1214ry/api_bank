package com.example.authentication.service;

import com.example.authentication.model.Position;
import com.example.authentication.repository.PositionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionService {

    private final PositionRepository repository;

    public PositionService(PositionRepository repository) {
        this.repository = repository;
    }

    public Position createPosition(Position position) {
        return repository.save(position);
    }

    public List<Position> getAllPositions() {
        return repository.findAll();
    }

    public Position getPositionById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Position record not found with id: " + id));
    }

    public Position updatePosition(Integer id, Position updatedDetails) {
        Position existingPosition = getPositionById(id);

        existingPosition.setPosition(updatedDetails.getPosition());
        existingPosition.setLink(updatedDetails.getLink());
        existingPosition.setPosId(updatedDetails.getPosId());
        existingPosition.setStatus(updatedDetails.getStatus());

        return repository.save(existingPosition);
    }

    public void deletePosition(Integer id) {
        Position existingPosition = getPositionById(id);
        repository.delete(existingPosition);
    }
}