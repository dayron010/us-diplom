package com.example.usdiplom.repository;

import com.example.usdiplom.model.entity.Ot;
import com.example.usdiplom.model.entity.Sifat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SifatRepository extends JpaRepository<Sifat, Long> {

    Optional<Sifat> findByName(String name);

}
