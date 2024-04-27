package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00514Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findRotateSteps(String ring, String key, int expected) {
        int result = new Solution00514().findRotateSteps(ring, key);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("godding", "gd", 4),
                Arguments.of("godding", "godding", 13),
                Arguments.of("godding", "god", 5)
        );
    }

}