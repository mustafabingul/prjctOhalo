package com.example.ohaloProject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TextDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long textDictionaryId;

    @ElementCollection
    @CollectionTable(name="listOfWords")
    private List<String> entries = new ArrayList<String>();
    //private String entry;
    private Boolean isCaseSensitive;
}