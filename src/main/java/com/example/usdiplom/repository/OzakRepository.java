package com.example.usdiplom.repository;

import com.example.usdiplom.model.entity.Ozak;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OzakRepository extends JpaRepository<Ozak, Long> {

    Optional<Ozak> findByName(String name);
}
