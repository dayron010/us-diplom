package com.example.usdiplom.repository;

import com.example.usdiplom.model.entity.Ot;
import com.example.usdiplom.model.entity.Son;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SonRepository extends JpaRepository<Son, Long> {

    Optional<Son> findByName(String name);

}
