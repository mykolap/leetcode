package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02825Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canMakeSubsequence(String str1, String str2, boolean expected) {
        boolean result = new Solution02825().canMakeSubsequence(str1, str2);
        assertEquals(expected, result);
    }

    /*
    Example 1:

Input: str1 = "abc", str2 = "ad"
Output: true
Explanation: Select index 2 in str1.
Increment str1[2] to become 'd'.
Hence, str1 becomes "abd" and str2 is now a subsequence. Therefore, true is returned.
Example 2:

Input: str1 = "zc", str2 = "ad"
Output: true
Explanation: Select indices 0 and 1 in str1.
Increment str1[0] to become 'a'.
Increment str1[1] to become 'd'.
Hence, str1 becomes "ad" and str2 is now a subsequence. Therefore, true is returned.
Example 3:

Input: str1 = "ab", str2 = "d"
Output: false
Explanation: In this example, it can be shown that it is impossible to make str2 a subsequence of str1 using the operation at most once.
Therefore, false is returned.
     */

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abc", "ad", true),
                Arguments.of("zc", "ad", true),
                Arguments.of("ab", "d", false)
        );
    }

}