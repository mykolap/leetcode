package leetcode;

import java.util.Arrays;

/**
 * 274. H-Index
 * <a href="https://leetcode.com/problems/h-index">Web link</a> |
 * Medium
 */

public class Solution00274 {

    // Time: O(n)
    // Space: O(n)
    public int hIndex(int[] citations) {
        int totalPapers = citations.length;
        int[] papersWithCitations = new int[totalPapers + 1];

        for (int citationCount : citations) {
            if (citationCount > totalPapers) {
                papersWithCitations[totalPapers]++;
            } else {
                papersWithCitations[citationCount]++;
            }
        }

        int hIndexCandidate = totalPapers;
        int totalPapersWithAtLeastHCitations = papersWithCitations[totalPapers];

        while (hIndexCandidate > totalPapersWithAtLeastHCitations) {
            totalPapersWithAtLeastHCitations += papersWithCitations[--hIndexCandidate];
        }

        return hIndexCandidate;
    }

    public int hIndexSorting(int[] citations) {
        Arrays.sort(citations);
        int totalPapers = citations.length;
        int result = 0;
        for (int i = 0; i < totalPapers; i++) {
            if (citations[i] >= totalPapers - i) {
                result = totalPapers - i;
                break;
            }
        }
        return result;
    }

}