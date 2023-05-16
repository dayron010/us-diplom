package com.example.usdiplom.repository;

import com.example.usdiplom.model.entity.Fel;
import com.example.usdiplom.model.entity.Ot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtRepository extends JpaRepository<Ot, Long> {

    Optional<Ot> findByName(String name);

}
