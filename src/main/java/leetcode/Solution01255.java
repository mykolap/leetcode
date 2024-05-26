package leetcode;

/**
 * 1255. Maximum Score Words Formed by Letters
 * https://leetcode.com/problems/maximum-score-words-formed-by-letters/
 * Hard
 */

public class Solution01255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterCountsInWords = new int[26];
        int[] letterCountsInLetters = new int[26];

        for (char letter : letters) {
            letterCountsInLetters[letter - 'a']++;
        }

        int maxScore = 0;
        maxScore = calculateMaxScore(words, score, letterCountsInLetters, letterCountsInWords, 0, 0, maxScore);
        return maxScore;
    }

    private int calculateMaxScore(String[] words, int[] score, int[] letterCountsInLetters, int[] letterCountsInWords, int wordIndex, int currentScore, int maxScore) {
        for (int i = 0; i < 26; i++) {
            if (letterCountsInWords[i] > letterCountsInLetters[i]) return maxScore;
        }

        maxScore = Math.max(maxScore, currentScore);

        for (int i = wordIndex; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                letterCountsInWords[c - 'a']++;
                currentScore += score[c - 'a'];
            }

            maxScore = calculateMaxScore(words, score, letterCountsInLetters, letterCountsInWords, i + 1, currentScore, maxScore);

            for (char c : words[i].toCharArray()) {
                letterCountsInWords[c - 'a']--;
                currentScore -= score[c - 'a'];
            }
        }

        return maxScore;
    }

}