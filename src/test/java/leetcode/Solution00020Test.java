package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00020Test {

    @ParameterizedTest
    @CsvSource({
            "(), true",
            "()[]{}, true",
            "(], false",
            "([)], false",
            "{[]}, true",
    })
    void isValid(String s, boolean expected) {
        assertEquals(expected, new Solution00020().isValid(s));
    }

}