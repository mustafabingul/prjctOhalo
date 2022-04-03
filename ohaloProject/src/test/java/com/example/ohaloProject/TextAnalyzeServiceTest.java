package com.example.ohaloProject;

import com.example.ohaloProject.entity.TextDictionary;
import com.example.ohaloProject.model.AnalyzedRequest;
import com.example.ohaloProject.model.AnalyzedResponse;
import com.example.ohaloProject.service.TextAnalyzeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class TextAnalyzeServiceTest {

    @Autowired
    private TextAnalyzeService textAnalyzeService;

    @Test
    public void givenTargetText_withGivenDictionary() throws Exception {

        //mocking, should be mocked repo
        AnalyzedResponse tmpRes = new AnalyzedResponse();
        TextDictionary mockDict = new TextDictionary();
        mockDict.setEntries(new ArrayList<String>(){{add("test1");add("test2");add("test3");}});
        String tempTarget = "Dnm test1 test Mustafa";
        AnalyzedRequest tmpReq = new AnalyzedRequest();
        tmpReq.setTargetText(tempTarget);
        tmpReq.setDictionaryId(new Long(1));
        tmpRes = textAnalyzeService.analyzeText(tmpReq);
        //Mockito.atLeastOnce();
    }

}