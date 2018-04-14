package org.poem;

import darts.DoubleArrayTrie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChartsMamin {
    public static void main(String[] args) throws IOException {
        File file = new File(ChartsMamin.class.getClassLoader().getResource("").getPath() + File.separator + "small.dic");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        List<String> words = new ArrayList<String>();
        Set<Character> charset = new HashSet<Character>();
        while ((line = reader.readLine()) != null) {
            words.add(line);
            // 制作一份码表debug
            for (char c : line.toCharArray()) {
                charset.add(c);
            }
        }
        reader.close();
        System.out.println("字典词条：" + words.size());

        StringBuilder infoCharsetValue = new StringBuilder();
        StringBuilder infoCharsetCode = new StringBuilder();
        for (Character c : charset) {
            infoCharsetValue.append(c.charValue()).append("    ");
            infoCharsetCode.append((int) c.charValue()).append(" ");
        }
        infoCharsetValue.append('\n');
        infoCharsetCode.append('\n');
        System.out.print(infoCharsetValue);
        System.out.print(infoCharsetCode);

        DoubleArrayTrie dat = new DoubleArrayTrie();
        System.out.println("是否错误: " + dat.build(words));
        System.out.println(dat);
        List<Integer> integerList = dat.commonPrefixSearch("一举成名天下知");
        for (int index : integerList) {
            System.out.println(words.get(index));
        }
    }
}
