package leetcode;

/**
 * 1813. Sentence Similarity III
 * <a href="https://leetcode.com/problems/sentence-similarity-iii">Web link</a> |
 * Medium
 */

public class Solution01813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        final String smaller;
        final String bigger;
        int sentence1Length = sentence1.length();
        int sentence2Length = sentence2.length();
        if (sentence1Length == sentence2Length) {
            return sentence1.equals(sentence2);
        } else if (sentence1Length < sentence2Length) {
            smaller = sentence1;
            bigger = sentence2;
        } else {
            smaller = sentence2;
            bigger = sentence1;
        }

        if (bigger.startsWith(smaller)) {
            if (bigger.charAt(smaller.length()) == ' ') {
                return true;
            }
        } else if (bigger.endsWith(smaller)) {
            final char charBeforeSmaller = bigger.charAt(Math.abs(sentence1Length - sentence2Length) - 1);
            if (charBeforeSmaller == ' ') {
                return true;
            }
        }

        String[] smallerWords = smaller.split(" ");
        String[] biggerWords = bigger.split(" ");
        int smallerWordsLength = smallerWords.length;
        int biggerWordsLength = biggerWords.length;

        int left = 0;
        while (left < smallerWordsLength &&
                smallerWords[left].equals(biggerWords[left])) {
            left++;
        }

        int rightSmaller = smallerWordsLength - 1;
        int rightBigger = biggerWordsLength - 1;
        while (rightSmaller >= left &&
                rightBigger >= 0 &&
                smallerWords[rightSmaller].equals(biggerWords[rightBigger])) {
            rightSmaller--;
            rightBigger--;
        }


        return left > rightSmaller;
    }

}