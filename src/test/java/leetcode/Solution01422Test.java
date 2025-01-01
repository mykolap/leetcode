package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01422Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxScore(String s, int expected) {
        int result = new Solution01422().maxScore(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("011101", 5),
                Arguments.of("00111", 5),
                Arguments.of("1111", 3),
                Arguments.of("00", 1)
        );
    }

}