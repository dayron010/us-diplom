package com.example.usdiplom.service;

import com.example.usdiplom.model.SozModelDto;
import com.example.usdiplom.model.SozQismlari;
import com.example.usdiplom.model.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GapModelService {


    @Autowired
    private SozModelService sozModelService;

    public void gapModel(List<SozQismlari> sozQismlariList) {
        for (SozQismlari sozQismlari : sozQismlariList) {
            SozModelDto sozModelDto = sozModelService.sozModel(sozQismlari);

        }
    }
}
