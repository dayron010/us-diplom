package com.example.usdiplom.repository;

import com.example.usdiplom.model.entity.Ot;
import com.example.usdiplom.model.entity.Ravish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RavishRepository extends JpaRepository<Ravish, Long> {

    Optional<Ravish> findByName(String name);

}
