package leetcode.validParentheses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "(), true",
            "()[]{}, true",
            "(], false",
            "([)], false",
            "{[]}, true",
    })
    void isValid(String s, boolean expected) {
        assertEquals(expected, new Solution().isValid(s));
    }

}