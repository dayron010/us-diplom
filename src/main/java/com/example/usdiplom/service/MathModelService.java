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

    @Autowired
    private WeightService weightService;

    public void mathModel(List<SozQismlari> sozQismlariList) {
        String gapModel = gapModelService.gapModel(sozQismlariList);
        System.out.println("GAP MODELI = " + gapModel + "\n");
        Double gapWeight = weightService.gapWeight(sozQismlariList);
        System.out.println("GAP VAZNI = " + gapWeight);
    }
}
