package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02516Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void takeCharacters(String s, int k, int expected) {
        int result = new Solution02516().takeCharacters(s, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("aabaaaacaabc", 2, 8),
                Arguments.of("a", 1, -1)
        );
    }

}