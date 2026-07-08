package com.example.authentication.repository;

import com.example.authentication.model.Choosepost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoosepostRepository extends JpaRepository<Choosepost, Integer> {
}