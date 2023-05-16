package com.example.usdiplom.repository;

import com.example.usdiplom.model.entity.Fel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FelRepository extends JpaRepository<Fel, Long> {
    Optional<Fel> findByName(String name);
}
