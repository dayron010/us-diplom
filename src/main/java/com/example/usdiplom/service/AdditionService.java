package com.example.usdiplom.service;

import com.example.usdiplom.repository.QushimchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdditionService {

    @Autowired
    private QushimchaRepository qushimchaRepository;

    public List<String> getAddition(String soz) {
        List<String> qushimchaList = List.of("lar", "ni", "ning");

        List<String> list = new ArrayList<>();
        for (String qushimcha : qushimchaList) {
            if (soz.endsWith(qushimcha)) {
                list.add(qushimcha);
            }
        }
        return list;
    }
}
