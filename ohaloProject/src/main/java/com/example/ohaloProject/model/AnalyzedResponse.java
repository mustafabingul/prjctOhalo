package com.example.ohaloProject.model;


import lombok.Data;

import java.util.List;

@Data
public class AnalyzedResponse {
    private String inputText;
    private List<Annotation> annotations;

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }
}
