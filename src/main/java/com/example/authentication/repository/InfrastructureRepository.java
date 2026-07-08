package com.example.authentication.repository;

import com.example.authentication.model.Infrastructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfrastructureRepository extends JpaRepository<Infrastructure, Integer> {
    // Standard CRUD operations are automatically included here
}