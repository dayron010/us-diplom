package com.example.usdiplom.repository;

import com.example.usdiplom.model.entity.Fel;
import com.example.usdiplom.model.entity.Olmosh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OlmoshRepository extends JpaRepository<Olmosh, Long> {

    Optional<Olmosh> findByName(String name);

}
