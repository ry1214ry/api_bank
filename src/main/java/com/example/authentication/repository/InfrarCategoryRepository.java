package com.example.authentication.repository;

import com.example.authentication.model.InfrarCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfrarCategoryRepository extends JpaRepository<InfrarCategory, Integer> {
}