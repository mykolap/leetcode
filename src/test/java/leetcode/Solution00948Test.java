package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00948Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void bagOfTokensScore(int[] tokens, int power, int expected) {
        var result = new Solution00948().bagOfTokensScore(tokens, power);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{100}, 50, 0),
                Arguments.of(new int[]{100, 200}, 150, 1),
                Arguments.of(new int[]{100, 200, 300, 400}, 200, 2)
        );
    }

}