package org.poem;

import com.hankcs.hanlp.HanLP;

public class WordTest {
    public static void main(String[] args) {
        HanLP.Config.Normalization = false;
        HanLP.Config.DEBUG = true;
        HanLP.Config.ShowTermNature = false;
        System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包！"));
    }
}
