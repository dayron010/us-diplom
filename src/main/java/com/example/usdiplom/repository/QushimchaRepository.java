package com.example.usdiplom.repository;

import com.example.usdiplom.model.entity.Qushimcha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QushimchaRepository extends JpaRepository<Qushimcha, Long> {

    Optional<Qushimcha> findByName(String name);

}
