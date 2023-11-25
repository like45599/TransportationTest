package com.sdjt.service.impl;


import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.WordDictionary;
import com.sdjt.service.JiebaSegmenterService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.file.Paths;
import java.util.List;

@Service
public class JiebaSegmenterServiceImpl implements JiebaSegmenterService {

    private JiebaSegmenter segmenter;

    @PostConstruct
    public void init() {
        segmenter = new JiebaSegmenter();
        loadUserDictionary();
    }

    private void loadUserDictionary() {
        // 替换为你的自定义词典路径
        String dictPath = "D:\\Data\\JavaTrain\\SDJT\\intelligentTransportion\\intelligentTransportion\\src\\main\\resources\\static\\jieba\\dict.txt";
        WordDictionary.getInstance().loadUserDict(Paths.get(dictPath));
    }

    @Override
    public List<String> segmentSentence(String sentence) {
        // 可以根据需要选择分词模式
        return segmenter.sentenceProcess(sentence);
    }
}
