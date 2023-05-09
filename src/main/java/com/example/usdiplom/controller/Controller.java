package com.example.usdiplom.controller;

import com.example.usdiplom.model.MyClass;
import com.example.usdiplom.model.MyStr;
import com.example.usdiplom.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private SentenceService sentenceService;

    @GetMapping("")
    public String addOzakModel(@RequestBody MyStr string) {
        return sentenceService.calculate(string.getName());
    }

}