package com.example.ohaloProject.model;


import lombok.Data;

@Data
public class AnalyzedRequest {
    private Long dictionaryId;
    private String targetText;

    public Long getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
    }

    public String getTargetText() {
        return targetText;
    }

    public void setTargetText(String targetText) {
        this.targetText = targetText;
    }
}