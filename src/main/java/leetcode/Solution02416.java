package leetcode;

/**
 * 2416. Sum of Prefix Scores of Strings
 * <a href="https://leetcode.com/problems/sum-of-prefix-scores-of-strings">Web link</a> |
 * Hard
 */

public class Solution02416 {

    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (var word : words) {
            root.insert(word);
        }
        int size = words.length;
        int[] answer = new int[size];
        for (int indx = 0; indx < size; indx++) {
            answer[indx] = root.findScore(words[indx]);
        }
        return answer;
    }

    private static class TrieNode {
        private final TrieNode[] children = new TrieNode[26];
        private int nodeFreq = 0;

        void insert(String key) {
            TrieNode curr = this;
            for (var chr : key.toCharArray()) {
                int indx = chr - 'a';
                if (curr.children[indx] == null) {
                    curr.children[indx] = new TrieNode();
                }
                curr.children[indx].nodeFreq++;
                curr = curr.children[indx];
            }
        }

        int findScore(String key) {
            TrieNode curr = this;
            int score = 0;
            for (var chr : key.toCharArray()) {
                int indx = chr - 'a';
                score += curr.children[indx].nodeFreq;
                curr = curr.children[indx];
            }
            return score;
        }
    }

}