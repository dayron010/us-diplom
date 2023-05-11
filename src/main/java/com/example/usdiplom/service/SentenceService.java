//package com.example.usdiplom.service;
//
//import com.example.usdiplom.constants.ConstantType;
//import com.example.usdiplom.model.MyClass;
//import com.example.usdiplom.model.MyStr;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class SentenceService {
//
//    public String calculate(String sentence) {
//
////        String sentense = name.getName();
//
////        List<MyClass> list = new ArrayList<>();
////
////        String str = "";
////        for (int i = 0; i < string.length(); i++) {
////            if (!(string.charAt(i) == ' ' && string.charAt(i + 1) == ' ')) {
////                str += string.charAt(i);
////            }
////        }
////
////        str = str.trim();
////        System.out.println("str = " + str);
////
////        List<String> split = List.of(str.split(" "));
////        System.out.println("split = " + split);
////
////        return str;
//        String str = "";
//        for (int i = 0; i < sentence.length(); i++) {
//            if (!(sentence.charAt(i) == ' ' && sentence.charAt(i + 1) == ' ')) {
//                str += sentence.charAt(i);
//            }
//        }
//
//        str = str.trim();
//        System.out.println("str = " + str);
//
//        List<MyClass> list = new ArrayList<>();
//        int start = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '.') {
//                list.add(new MyClass(str.substring(start, i).trim(), ConstantType.DARAK_GAP));
//                start = i + 1;
//            } else if (str.charAt(i) == '?') {
//                list.add(new MyClass(str.substring(start, i).trim(), ConstantType.SOROQ_GAP));
//                start = i + 1;
//            } else if (str.charAt(i) == '!') {
//                list.add(new MyClass(str.substring(start, i).trim(), ConstantType.UNDOV_GAP));
//                start = i + 1;
//            }
//        }
//
//        System.out.println("list = " + list);
//
//        return str;
//    }
//
//}

package com.example.usdiplom.service;

import com.example.usdiplom.constants.ConstantType;
import com.example.usdiplom.model.MyClass;
import com.example.usdiplom.model.MyStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class SentenceService {

    @Autowired
    private AdditionService additionService;


    public String calculate(String sentense) {

        System.out.println("sentense = " + sentense);

//        String sentense = name.getName();

//        List<MyClass> list = new ArrayList<>();
//
//        String str = "";
//        for (int i = 0; i < string.length(); i++) {
//            if (!(string.charAt(i) == ' ' && string.charAt(i + 1) == ' ')) {
//                str += string.charAt(i);
//            }
//        }
//
//        str = str.trim();
//        System.out.println("str = " + str);
//
//        List<String> split = List.of(str.split(" "));
//        System.out.println("split = " + split);
//
//        return str;
//        String str = "";
//        for (int i = 0; i < sentense.length(); i++) {
//            if (!(sentense.charAt(i) == ' ' && sentense.charAt(i + 1) == ' ')) {
//                str += sentense.charAt(i);
//            }
//        }

        String str = correctSentence(sentense);

//        str = str.trim();
//        System.out.println("str = " + str);

//        List<MyClass> list = new ArrayList<>();
//        int start = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '.') {
//                list.add(new MyClass(str.substring(start, i).trim(), ConstantType.DARAK_GAP));
//                start = i + 1;
//            } else if (str.charAt(i) == '?') {
//                list.add(new MyClass(str.substring(start, i).trim(), ConstantType.SOROQ_GAP));
//                start = i + 1;
//            } else if (str.charAt(i) == '!') {
//                list.add(new MyClass(str.substring(start, i).trim(), ConstantType.UNDOV_GAP));
//                start = i + 1;
//            }
//        }

        List<MyClass> list = sentenceCause(str);
        System.out.println("list = " + list);

        List<List<String>> lists = wordCause(list);
        for (List<String> sozlist : lists) {
            System.out.println("sozlar = " + sozlist);
            for (String soz : sozlist) {
                Set<String> additionList = additionService.getAddition(soz);
//                System.out.println("additionList = " + additionList);
            }
        }

//        for (MyClass myClass : list) {
//            String gap = myClass.getGap();
//            List<String> sozList = Arrays.stream(gap.split(" ")).toList();
//            for (String soz : sozList) {
//                System.out.println("soz = " + soz);
//                ArrayList<String> qoshimchalar = new ArrayList<>(List.of("lar", "ni", "ning"));
//                System.out.println("qoshimchalar = " + qoshimchalar);
//                for (String qoshimcha : qoshimchalar) {
//                    if (soz.length() > qoshimcha.length()) {
//                        if (soz.endsWith(qoshimcha)) {
//                            System.out.println("qo'shimchani chiqardik:");
//                            System.out.println("qoshimcha = " + qoshimcha);
//                        }
////                    soz.substring(sozList.size() - 1 - qoshimcha.length());
//                    }
//                }
//            }
//            System.out.println("sozList = " + sozList);
//        }
//
//        System.out.println("list = " + list);

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
