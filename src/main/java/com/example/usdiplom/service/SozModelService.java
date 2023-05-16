package com.example.usdiplom.service;

import com.example.usdiplom.model.SozModelDto;
import com.example.usdiplom.model.SozQismlari;
import com.example.usdiplom.model.entity.*;
import com.example.usdiplom.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SozModelService {

    private final FelRepository felRepository;
    private final OlmoshRepository olmoshRepository;
    private final OtRepository otRepository;
    private final QushimchaRepository qushimchaRepository;
    private final RavishRepository ravishRepository;
    private final SifatRepository sifatRepository;
    private final SonRepository sonRepository;

    public SozModelDto sozModel(SozQismlari sozQismlari) {
        String ozak = sozQismlari.getOzak();
        Optional<Fel> optionalFel = felRepository.findByName(ozak);
        Optional<Olmosh> optionalOlmosh = olmoshRepository.findByName(ozak);
        Optional<Ot> optionalOt = otRepository.findByName(ozak);
        Optional<Qushimcha> optionalQushimcha = qushimchaRepository.findByName(ozak);
        Optional<Ravish> optionalRavish = ravishRepository.findByName(ozak);
        Optional<Sifat> optionalSifat = sifatRepository.findByName(ozak);
        Optional<Son> optionalSon = sonRepository.findByName(ozak);
        if (optionalFel.isPresent())
            return new SozModelDto(optionalFel.get(), felRepository.count());
        if (optionalOlmosh.isPresent())
            return new SozModelDto(optionalOlmosh.get(), olmoshRepository.count());
        if (optionalOt.isPresent())
            return new SozModelDto(optionalOt.get(), otRepository.count());
        if (optionalRavish.isPresent())
            return new SozModelDto(optionalRavish.get(), ravishRepository.count());
        if (optionalSifat.isPresent())
            return new SozModelDto(optionalSifat.get(), sifatRepository.count());
        if (optionalSon.isPresent())
            return new SozModelDto(optionalSon.get(), sonRepository.count());
        return new SozModelDto(null, null);
    }

}
