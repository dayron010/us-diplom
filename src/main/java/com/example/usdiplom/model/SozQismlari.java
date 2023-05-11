package com.example.usdiplom.model;

import com.example.usdiplom.model.entity.Ozak;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SozQismlari {

    private Ozak ozak;
    private List<String> qushimchaList;

}
