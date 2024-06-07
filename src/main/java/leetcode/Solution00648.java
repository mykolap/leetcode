package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 648. Replace Words
 * <a href="https://leetcode.com/problems/replace-words">Web link</a>
 * Medium
 */

public class Solution00648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        List<String> result = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            int minLen = Integer.MAX_VALUE;
            for (String root : dictionary) {
                if (root.length() < minLen &&
                    word.startsWith(root)) {
                    minLen = root.length();
                    word = root;
                }
            }
            result.add(word);
        }
        return String.join(" ", result);
    }

}