package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00424Test {

    @ParameterizedTest
    @CsvSource({
            "ABAB, 2, 4",
            "AABABBA, 1, 4",
            "ABBB, 2, 4",
            "ABBB, 0, 3"
    })
    void characterReplacement(String s, int k, int expected) {
        int actual = new Solution00424().characterReplacement(s, k);
        assertEquals(expected, actual);
    }

}