package com.example.usdiplom.service;

import com.example.usdiplom.constants.ConstantType;
import com.example.usdiplom.model.MyClass;
import com.example.usdiplom.model.SozQismlari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SentenceService {

    @Autowired
    private AdditionService additionService;

    @Autowired
    private MathModelService mathModelService;


    public String calculate(String sentense) {
        System.out.println("sentense = " + sentense);

        String str = correctSentence(sentense);

        List<MyClass> list = sentenceCause(str);
        System.out.println("list = " + list);

        List<List<String>> lists = wordCause(list);
        for (List<String> sozlist : lists) {
            List<SozQismlari> sozQismlariList = new ArrayList<>();
            System.out.println("sozlar = " + sozlist);
            for (String soz : sozlist) {
                sozQismlariList.add(additionService.getAddition(soz));
//                System.out.println("additionList = " + additionList);
            }
            System.out.println("sozQismlariList = " + sozQismlariList);
            mathModelService.mathModel(sozQismlariList);
        }

        return str;
    }

    // gaplarni so'zlarga ajratish
    private List<List<String>> wordCause(List<MyClass> list) {
        List<List<String>> sozList = new ArrayList<>();
        for (MyClass myClass : list) {
            String gap = myClass.getGap();
            sozList.add(Arrays.stream(gap.split(" ")).toList());
        }
        return sozList;
    }

    // gapni qo'shimcha probellardan tozalash
    public String correctSentence(String sentence) {
        String str = "";
        for (int i = 0; i < sentence.length(); i++) {
            if (!(sentence.charAt(i) == ' ' && sentence.charAt(i + 1) == ' ')) {
                str += sentence.charAt(i);
            }
        }
        return str.trim();
    }

    // gaplarni turiga qarab ajratish
    public List<MyClass> sentenceCause(String str) {
        List<MyClass> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                list.add(new MyClass(str.substring(start, i).trim(), ConstantType.DARAK_GAP));
                start = i + 1;
            } else if (str.charAt(i) == '?') {
                list.add(new MyClass(str.substring(start, i).trim(), ConstantType.SOROQ_GAP));
                start = i + 1;
            } else if (str.charAt(i) == '!') {
                list.add(new MyClass(str.substring(start, i).trim(), ConstantType.UNDOV_GAP));
                start = i + 1;
            }
        }
        return list;
    }

}
