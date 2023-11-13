package leetcode.minimumWindowSubstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "'ADOBECODEBANC', 'ABC', 'BANC'",
            "'a', 'a', 'a'",
            "'a', 'aa', ''"
    })
    void minWindow(String s, String t, String expected) {
        assertEquals(expected, new Solution().minWindow(s, t));
    }

}