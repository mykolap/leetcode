package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03163Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void compressedString(String word, String expected) {
        Solution03163 solution = new Solution03163();
        assertEquals(expected, solution.compressedString(word));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abcde", "1a1b1c1d1e"),
                Arguments.of("aaaaaaaaaaaaaabb", "9a5a2b")
        );
    }

}