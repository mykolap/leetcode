package leetcode.validPalindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "'A man, a plan, a canal: Panama', true",
            "race a car, false"
    })
    void isPalindrome(String s, boolean expected) {
        assertEquals(expected, new Solution().isPalindrome(s));
    }

}