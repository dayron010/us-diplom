package com.example.usdiplom.service;

import com.example.usdiplom.model.entity.Ozak;
import com.example.usdiplom.model.entity.Qushimcha;
import com.example.usdiplom.repository.OzakRepository;
import com.example.usdiplom.repository.QushimchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdditionService {

    @Autowired
    private QushimchaRepository qushimchaRepository;

    @Autowired
    private OzakRepository ozakRepository;

    public Set<String> getAddition(String soz) {
        System.out.println("soz = " + soz);
//        List<String> qushimchaList = List.of("lar", "ni", "ning");

        HashSet<String> set = new HashSet<>();
        List<Ozak> ozakList = ozakRepository.findAll();

        for (Ozak ozak : ozakList) {
            if (soz.startsWith(ozak.getName())) {
                System.out.println("ozak = " + ozak.getName());
                String chopma = chopqi(soz, ozak.getName());
                soz = chopma;
            }
        }
        return set;
    }

    private String chopqi(String soz, String ozak) {
        if (soz.length() > ozak.length()){
            String substring = soz.substring(0, ozak.length());
            return substring;
        }
        return "";
    }
}
