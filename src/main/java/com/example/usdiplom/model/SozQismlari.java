package com.example.usdiplom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SozQismlari {

    private String soz;
    private String ozak;
    private List<String> qushimchaList;

}
