package com.example.usdiplom.repository;

import com.example.usdiplom.model.entity.Qushimcha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface QushimchaRepository extends JpaRepository<Qushimcha, Long> {

    List<Qushimcha> findByName(String name);

}
