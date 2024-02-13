package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02108Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new String[]{"abc", "car", "ada", "racecar", "cool"}, "ada"),
                Arguments.of(new String[]{"notapalindrome", "racecar"}, "racecar"),
                Arguments.of(new String[]{"def", "ghi"}, "")
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void firstPalindrome(String[] words, String expected) {
        assertEquals(expected, new Solution02108().firstPalindrome(words));
    }

}