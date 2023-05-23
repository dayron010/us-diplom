package com.example.usdiplom.service;

import com.example.usdiplom.model.SozModelDto;
import com.example.usdiplom.model.SozQismlari;
import com.example.usdiplom.model.entity.WordTypes;
import com.example.usdiplom.repository.WordTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WeightService {

    @Autowired
    private SozModelService sozModelService;

    @Autowired
    private WordTypeRepository wordTypeRepository;

    public Double gapWeight(List<SozQismlari> sozQismlariList) {
        double gapWeight = 0;
        for (SozQismlari sozQismlari : sozQismlariList) {

            System.out.println("SOZ = " + sozQismlari.getSoz());
            Double ozakWeight = getOzakWeight(sozQismlari);
            System.out.println("ozakWeight = " + sozQismlari.getOzak() + " => " + ozakWeight);

            System.out.println("QO\'SHIMCHALAR = " + sozQismlari.getQushimchaList());
            Double qushimchaWeight = getQoshimchaWeight(sozQismlari.getQushimchaList());
            System.out.println("qushimchaWeight = " + sozQismlari.getQushimchaList() + " => " + qushimchaWeight);

            gapWeight += ozakWeight + qushimchaWeight;
            System.out.println("SOZ VAZNI = " + sozQismlari.getOzak() + " => " + ozakWeight + qushimchaWeight);
        }
        return gapWeight;
    }

    private Double getQoshimchaWeight(List<String> qushimchaList) {
        double weight = 0.0;
        List<SozModelDto> modelDtos = sozModelService.getQushimchaData(qushimchaList);
        for (SozModelDto modelDto : modelDtos) {
            Integer tId = modelDto.getBaseEntity().getT_id();
            Optional<WordTypes> optionalWordTypes = wordTypeRepository.findById(Long.valueOf(tId));
            if (optionalWordTypes.isEmpty() || Objects.equals(optionalWordTypes.get().getWeight(), null)) {
                continue;
            }
            WordTypes wordTypes = optionalWordTypes.get();
            weight += modelDto.getBaseEntity().getId() / 100.0 + wordTypes.getWeight();

        }
        return weight;
    }

    private Double getOzakWeight(SozQismlari sozQismlari) {
        SozModelDto sozModelDto = sozModelService.getData(sozQismlari);
        Integer tId = sozModelDto.getBaseEntity().getT_id();
        Optional<WordTypes> optionalWordTypes = wordTypeRepository.findById(Long.valueOf(tId));
        return optionalWordTypes.map(wordTypes -> sozModelDto.getBaseEntity().getId() / 100.0 + wordTypes.getWeight()).orElse(0.0);
    }

}
