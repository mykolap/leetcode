package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03042Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countPrefixSuffixPairs(String wordsStr, int expected) {
        String[] words = ArrayUtils.stringToStringArray(wordsStr);
        assertEquals(expected, new Solution03042().countPrefixSuffixPairs(words));
    }

    /*
    Example 1:

Input: words = ["a","aba","ababa","aa"]
Output: 4
Explanation: In this example, the counted index pairs are:
i = 0 and j = 1 because isPrefixAndSuffix("a", "aba") is true.
i = 0 and j = 2 because isPrefixAndSuffix("a", "ababa") is true.
i = 0 and j = 3 because isPrefixAndSuffix("a", "aa") is true.
i = 1 and j = 2 because isPrefixAndSuffix("aba", "ababa") is true.
Therefore, the answer is 4.
Example 2:

Input: words = ["pa","papa","ma","mama"]
Output: 2
Explanation: In this example, the counted index pairs are:
i = 0 and j = 1 because isPrefixAndSuffix("pa", "papa") is true.
i = 2 and j = 3 because isPrefixAndSuffix("ma", "mama") is true.
Therefore, the answer is 2.
Example 3:

Input: words = ["abab","ab"]
Output: 0
Explanation: In this example, the only valid index pair is i = 0 and j = 1, and isPrefixAndSuffix("abab", "ab") is false.
Therefore, the answer is 0.
     */
    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\"a\",\"aba\",\"ababa\",\"aa\"]", 4),
                Arguments.of("[\"pa\",\"papa\",\"ma\",\"mama\"]", 2),
                Arguments.of("[\"abab\",\"ab\"]", 0)
        );
    }

}