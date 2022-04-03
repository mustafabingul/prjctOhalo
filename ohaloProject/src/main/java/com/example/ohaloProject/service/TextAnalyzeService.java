package com.example.ohaloProject.service;

import com.example.ohaloProject.entity.TextDictionary;
import com.example.ohaloProject.model.AnalyzedRequest;
import com.example.ohaloProject.model.AnalyzedResponse;

import java.util.List;

public interface TextAnalyzeService {

    TextDictionary createTextDictionary(TextDictionary textDictionary);
    List<TextDictionary> listTextDictionary();
    TextDictionary readTextDictionary(Long textDictionaryId);
    TextDictionary updateTextDictionary(TextDictionary textDictionary, Long textDictionaryId);
    void deleteTextDictionary(Long textDictionaryId);
    AnalyzedResponse analyzeText(AnalyzedRequest analyzedRequest);
}