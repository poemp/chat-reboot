package org.poem;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.util.List;

public class WordTest {
    public static void main(String[] args) {
        List<Word> words = WordSegmenter.seg("杨尚川是APDPlat应用级产品开发平台的作者");
        System.err.println(words.toString());
    }
}
