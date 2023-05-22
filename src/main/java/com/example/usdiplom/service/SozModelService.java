package com.example.usdiplom.service;

import com.example.usdiplom.model.SozModelDto;
import com.example.usdiplom.model.SozQismlari;
import com.example.usdiplom.model.entity.*;
import com.example.usdiplom.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private final WordTypeRepository wordTypeRepository;
    private final OzakRepository ozakRepository;

    public SozModelDto getData(SozQismlari sozQismlari) {

        String ozak = sozQismlari.getOzak().toLowerCase();
//        System.out.println("ozakBoyicha = " + ozak);
        Optional<Ozak> optionalOzak = ozakRepository.findByName(ozak);
//        System.out.println("optionalOzak.get() = " + optionalOzak.get().getName());
        Optional<Fel> optionalFel = felRepository.findByName(ozak);
        Optional<Olmosh> optionalOlmosh = olmoshRepository.findByName(ozak);
        Optional<Ot> optionalOt = otRepository.findByName(ozak);
        Optional<Ravish> optionalRavish = ravishRepository.findByName(ozak);
        Optional<Sifat> optionalSifat = sifatRepository.findByName(ozak);
        Optional<Son> optionalSon = sonRepository.findByName(ozak);
        if (optionalOzak.isPresent())
            return new SozModelDto(optionalOzak.get(), ozakRepository.count());
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

    public List<SozModelDto> getQushimchaData(List<String> qushimchaList) {
        List<SozModelDto> sozModelDtos = new ArrayList<>();
        for (String qushimcha : qushimchaList) {
            List<Qushimcha> qushimchas = qushimchaRepository.findByName(qushimcha);
            if (qushimchas.size() > 0) {
                sozModelDtos.add(new SozModelDto(qushimchas.get(0), qushimchaRepository.count()));
            }

        }
        return sozModelDtos;
    }

    public String createModel(String soz, SozModelDto sozModelDto, List<SozModelDto> qushimchModelDtoList) {

//        sozModelDto.

        String str = "";
        str += "$[" + sozModelDto.getBaseEntity().getId() + ", 1/" + sozModelDto.getDbSize() + "]";
        Optional<WordTypes> optionalWordTypes = wordTypeRepository.findById(Long.valueOf(sozModelDto.getBaseEntity().getT_id()));
        if (optionalWordTypes.isEmpty()) {
            return "Bunday T_idlik soz turkumi topilmadi";
        }
        WordTypes wordTypes = optionalWordTypes.get();
        str += "(" + wordTypes.getName() + "[" + sozModelDto.getBaseEntity().getId() + "])";
        System.out.println("OZAK MODEL = " + sozModelDto.getBaseEntity().getName() + " => " + str);

        String additionModel = createAdditionModel(qushimchModelDtoList);
        str += additionModel;

        return str;
    }

    private String createAdditionModel(List<SozModelDto> qushimchModelDtoList) {

        String result = "";
        String str = "";
        for (SozModelDto sozModelDto : qushimchModelDtoList) {
            String qushimcha = sozModelDto.getBaseEntity().getName();
            str += "$[" + sozModelDto.getBaseEntity().getId() + ", 1/" + sozModelDto.getDbSize() + "]";
            Optional<WordTypes> optionalWordTypes = wordTypeRepository.findById(Long.valueOf(sozModelDto.getBaseEntity().getT_id()));
            if (optionalWordTypes.isEmpty()) {
                return "Bunday T_idlik soz turkumi topilmadi";
            }
            WordTypes wordTypes = optionalWordTypes.get();
            str += "(" + wordTypes.getName() + "[" + sozModelDto.getBaseEntity().getId() + "])";
            System.out.println("QUSHIMCHA MODEL = " + qushimcha + " => " + str);
            str = " + " + str;
            result += str;
            str = "";
        }
        return result;
    }

    public List<BaseEntity> sozgetAllOzakList() {
        List<BaseEntity> baseEntityList = new ArrayList<>();
        baseEntityList.addAll(felRepository.findAll());
        baseEntityList.addAll(olmoshRepository.findAll());
        baseEntityList.addAll(otRepository.findAll());
        baseEntityList.addAll(ozakRepository.findAll());
        baseEntityList.addAll(ravishRepository.findAll());
        baseEntityList.addAll(sifatRepository.findAll());
        baseEntityList.addAll(sonRepository.findAll());
        return baseEntityList;
    }
}
