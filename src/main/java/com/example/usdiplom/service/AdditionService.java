package com.example.usdiplom.service;

import com.example.usdiplom.model.SozQismlari;
import com.example.usdiplom.model.entity.Ozak;
import com.example.usdiplom.repository.OzakRepository;
import com.example.usdiplom.repository.QushimchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdditionService {

    @Autowired
    private QushimchaRepository qushimchaRepository;

    @Autowired
    private OzakRepository ozakRepository;

    //So'zlarni ozak va qo'shimchalarga ajratish
    public SozQismlari getAddition(String soz) {
//        HashSet<String> set = new HashSet<>();
        SozQismlari sozQismlari = null;

        System.out.println("soz = " + soz);

        List<Ozak> ozakList = ozakRepository.findAll();

        for (Ozak ozak : ozakList) {
            if (soz.toLowerCase().startsWith(ozak.getName())) {
                System.out.println("ozak = " + ozak.getName());
//                SozQismlari sozQismlari = chopqi(soz, ozak.getName());
                sozQismlari = chopqi(soz, ozak.getName());
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
            return new SozQismlari(ozak, wordAdditions);
        }
        return new SozQismlari(soz, new ArrayList<>());
    }

    private List<String> getWordAddition(String string) {
//        System.out.println("qo'shimcha = " + string);
        List<String> qushimchaList = List.of("da", "mi", "moqda", "lar", "i");
        List<String> result = new ArrayList<>();

        for (String qushimcha : qushimchaList) {
            if (string.length() >= qushimcha.length()){
                if (string.toLowerCase().startsWith(qushimcha)) {
                    result.add(qushimcha);
                    string = string.substring(qushimcha.length());
                }
            }
        }
        return result;
    }

}
