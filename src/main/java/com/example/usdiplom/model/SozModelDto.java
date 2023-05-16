package com.example.usdiplom.model;

import com.example.usdiplom.model.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SozModelDto {

    private BaseEntity baseEntity;
    private Long dbSize;

}
