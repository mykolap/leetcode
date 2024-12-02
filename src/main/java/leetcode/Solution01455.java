/**
 * 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
 * <a href="https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence">Web link</a>
 * Easy
 */

package leetcode;

public class Solution01455 {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] splitted = sentence.split(" ");
        for (int i = 0; i < splitted.length; i++) {
            if (splitted[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

}