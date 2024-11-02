package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02490Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isCircularSentence(String input, boolean expected) {
        assertEquals(expected, new Solution02490().isCircularSentence(input));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("leetcode exercises sound delightful", true),
                Arguments.of("eetcode", true),
                Arguments.of("Leetcode is cool", false)
        );
    }

}