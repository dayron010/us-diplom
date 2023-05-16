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
            List<SozModelDto> qushimchaModelDto = sozModelService.getQushimchaData(sozQismlari.getQushimchaList());
            SozModelDto sozModelDto = sozModelService.getData(sozQismlari);
            System.out.println("sozModelDto = " + sozModelDto);
            String model = sozModelService.createModel(sozQismlari.getSoz(), sozModelDto, qushimchaModelDto);
            System.out.println("MODEL = " + model);
        }
    }
}
