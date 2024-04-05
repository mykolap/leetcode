package leetcode;

/**
 * 3081. Replace Question Marks in String to Minimize Its Value
 * <a href="https://leetcode.com/problems/replace-question-marks-in-string-to-minimize-its-value">Web link</a>
 * Medium
 */
public class Solution03081 {

    public String minimizeStringValue(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '?') {
                count[s.charAt(i) - 'a']++;
            }
        }
        int[] charactersToAdd = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                int minIndex = -1;
                int minCount = Integer.MAX_VALUE;
                for (int j = 0; j < 26; j++) {
                    if (count[j] < minCount) {
                        minCount = count[j];
                        minIndex = j;
                    }
                }
                charactersToAdd[minIndex]++;
                count[minIndex]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int currentIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                while (charactersToAdd[currentIndex] == 0) {
                    currentIndex++;
                }
                sb.append((char) ('a' + currentIndex));
                charactersToAdd[currentIndex]--;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
