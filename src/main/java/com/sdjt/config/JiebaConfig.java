package com.sdjt.config;

import com.huaban.analysis.jieba.WordDictionary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class JiebaConfig {

    @PostConstruct
    public void init() {
        Path dictPath = Paths.get("D:\\Data\\JavaTrain\\SDJT\\intelligentTransportion\\intelligentTransportion\\src\\main\\resources\\static\\jieba\\dict.txt");
        WordDictionary.getInstance().loadUserDict(dictPath);
    }
}
