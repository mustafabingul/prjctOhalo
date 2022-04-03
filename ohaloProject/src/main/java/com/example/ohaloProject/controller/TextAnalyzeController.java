package com.example.ohaloProject.controller;

import com.example.ohaloProject.entity.TextDictionary;
import com.example.ohaloProject.model.AnalyzedRequest;
import com.example.ohaloProject.model.AnalyzedResponse;
import com.example.ohaloProject.service.TextAnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TextAnalyzeController {

    @Autowired
    private TextAnalyzeService textAnalyzeService;

    @PostMapping("/textAnalyze")
    public TextDictionary createTextDict(@RequestBody TextDictionary textDictionary){
        return textAnalyzeService.createTextDictionary(textDictionary);
    }

    @GetMapping("/textAnalyze")
    public List<TextDictionary> listAllTextDictionary(){
        return textAnalyzeService.listTextDictionary();
    }

    @GetMapping("/textAnalyze/{id}")
    public TextDictionary readTextDictionary(@PathVariable("id") Long textDictionaryId){
        return textAnalyzeService.readTextDictionary(textDictionaryId);
    }

    @PutMapping("/textAnalyze/{id}")
    public TextDictionary updateDepartment(@RequestBody TextDictionary textDictionary, @PathVariable("id") Long textDictionaryId){
        return textAnalyzeService.updateTextDictionary(textDictionary, textDictionaryId);
    }

    @DeleteMapping("/textAnalyze/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long textDictionaryId){
        textAnalyzeService.deleteTextDictionary(textDictionaryId);
        return "Deleted Successfully";
    }

    @PostMapping("/targetAnalyze")
    public AnalyzedResponse analyzeText(@RequestBody AnalyzedRequest analyzedRequest){
        return textAnalyzeService.analyzeText(analyzedRequest);
    }


}