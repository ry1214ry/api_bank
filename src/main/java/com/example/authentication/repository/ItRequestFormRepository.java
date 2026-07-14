package com.example.authentication.repository;

import com.example.authentication.model.ItRequestForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItRequestFormRepository extends JpaRepository<ItRequestForm, Integer> {
}