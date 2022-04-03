package com.example.ohaloProject.model;

import lombok.Data;

@Data
public class Annotation {
    private String annotatedText;
    private int startIndex;
    private int endIndex;

    public Annotation(String annotatedText, int startIndex, int endIndex) {
        this.annotatedText = annotatedText;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
}
