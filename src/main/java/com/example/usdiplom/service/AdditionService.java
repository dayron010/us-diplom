package com.example.usdiplom.service;

import com.example.usdiplom.model.SozQismlari;
import com.example.usdiplom.model.entity.BaseEntity;
import com.example.usdiplom.model.entity.Qushimcha;
import com.example.usdiplom.repository.OtRepository;
import com.example.usdiplom.repository.OzakRepository;
import com.example.usdiplom.repository.QushimchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AdditionService {

    @Autowired
    private QushimchaRepository qushimchaRepository;

    @Autowired
    private OzakRepository ozakRepository;

    @Autowired
    private OtRepository otRepository;

    @Autowired
    private SozModelService sozModelService;

    //So'zlarni ozak va qo'shimchalarga ajratish
    public SozQismlari getAddition(String soz) {
//        HashSet<String> set = new HashSet<>();
        SozQismlari sozQismlari = null;

        System.out.println("soz = " + soz);

        List<BaseEntity> allOzakList = sozModelService.sozgetAllOzakList();
        for (BaseEntity baseEntity : allOzakList) {
            if (Objects.equals(baseEntity.getName(), null)) {
                continue;
            }
            if (soz.toLowerCase().contains(baseEntity.getName())) {
                System.out.println("ozak = " + baseEntity.getName());
//                SozQismlari sozQismlari = chopqi(soz, ozak.getName());
                sozQismlari = chopqi(soz, baseEntity.getName());
                System.out.println("sozQismlari = " + sozQismlari);
                soz = sozQismlari.getOzak();
                return sozQismlari;
            }
        }

        return sozQismlari;
    }

    private SozQismlari chopqi(String soz, String ozakString) {
        if (soz.length() > ozakString.length()) {
            String ozak = soz.substring(0, ozakString.length());
            List<String> wordAdditions = getWordAddition(soz.substring(ozakString.length()));
//            System.out.println("wordAdditions = " + wordAdditions);
            return new SozQismlari(soz, ozak, wordAdditions);
        }
        return new SozQismlari(soz, soz, new ArrayList<>());
    }

    private List<String> getWordAddition(String string) {
//        System.out.println("qo'shimcha = " + string);
//        List<String> qushimchaList = List.of("da", "mi", "moqda", "lar", "i");
        List<Qushimcha> qushimchaList = qushimchaRepository.findAll();
        List<String> result = new ArrayList<>();

        for (Qushimcha qushimcha : qushimchaList) {
            if (string.length() >= qushimcha.getName().length()) {
                if (string.toLowerCase().startsWith(qushimcha.getName())) {
                    // todo containsga tekshir
                    result.add(qushimcha.getName());
                    string = string.substring(qushimcha.getName().length());
                }
            }
        }
        return result;
    }

}
