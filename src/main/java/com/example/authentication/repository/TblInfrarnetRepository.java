package com.example.authentication.repository;

import com.example.authentication.model.TblInfrarnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblInfrarnetRepository extends JpaRepository<TblInfrarnet, Integer> {
}