package com.example.usdiplom.service;

import com.example.usdiplom.model.SozQismlari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MathModelService {

    @Autowired
    private GapModelService gapModelService;

    @Autowired
    private SozModelService sozModelService;


    public void mathModel(List<SozQismlari> sozQismlariList) {
        gapModelService.gapModel(sozQismlariList);

    }
}
