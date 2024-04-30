package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01915Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void wonderfulSubstrings(String word, long expected) {
        long result = new Solution01915().wonderfulSubstrings(word);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("aba", 4),
                Arguments.of("aabb", 9),
                Arguments.of("he", 2)
        );
    }
}