package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Solution00125Test {

    @ParameterizedTest
    @CsvSource({
            "'A man, a plan, a canal: Panama', true",
            "race a car, false"
    })
    void isPalindrome(String s, boolean expected) {
        Assertions.assertEquals(expected, new Solution00125().isPalindrome(s));
    }

}