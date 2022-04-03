package com.example.ohaloProject.service;


import com.example.ohaloProject.entity.TextDictionary;
import com.example.ohaloProject.model.AnalyzedRequest;
import com.example.ohaloProject.model.AnalyzedResponse;
import com.example.ohaloProject.model.Annotation;
import com.example.ohaloProject.repository.TextDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextAnalyzeServiceImpl implements TextAnalyzeService{

    @Autowired
    private TextDictionaryRepository textDictionaryRepository;

    @Override
    public TextDictionary createTextDictionary(TextDictionary textDictionary) {
        return textDictionaryRepository.save(textDictionary);
    }

    @Override
    public List<TextDictionary> listTextDictionary() {
        return (List<TextDictionary>) textDictionaryRepository.findAll();
    }

    @Override
    public TextDictionary readTextDictionary(Long textDictionaryId) {
        return textDictionaryRepository.findById(textDictionaryId).orElse(null);
    }

    @Override
    public TextDictionary updateTextDictionary(TextDictionary textDictionary, Long textDictionaryId) {
        TextDictionary tmp = textDictionaryRepository.findById(textDictionaryId).get();
        tmp.setEntries(textDictionary.getEntries());
        return textDictionaryRepository.save(tmp);
    }

    @Override
    public void deleteTextDictionary(Long textDictionaryId) {
        textDictionaryRepository.deleteById(textDictionaryId);
    }

    @Override
    public AnalyzedResponse analyzeText(AnalyzedRequest analyzedRequest) {
        TextDictionary tmp = textDictionaryRepository.findById(analyzedRequest.getDictionaryId()).orElse(null);
        List<String> words = tmp.getEntries();
        AnalyzedResponse response = new AnalyzedResponse();
        List<Annotation> tmpAnnts = new ArrayList<Annotation>();
        for(int i=0; i<tmp.getEntries().size(); ++i)
        {
            if(analyzedRequest.getTargetText().contains(words.get(i))){
                Annotation tmpAnt = new Annotation(words.get(i),analyzedRequest.getTargetText().indexOf(words.get(i)),analyzedRequest.getTargetText().indexOf(words.get(i)) + words.get(i).length());
                tmpAnnts.add(tmpAnt);
            }
        }
        response.setInputText(analyzedRequest.getTargetText());
        response.setAnnotations(tmpAnnts);
        return response;
    }
}
