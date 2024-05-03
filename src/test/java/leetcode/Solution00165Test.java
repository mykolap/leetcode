package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00165Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void compareVersion(String version1, String version2, int expected) {
        Solution00165 solution = new Solution00165();
        int output = solution.compareVersion(version1, version2);
        assertEquals(expected, output);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("1.01", "1.001", 0),
                Arguments.of("1.0", "1.0.0", 0),
                Arguments.of("0.1", "1.1", -1),
                Arguments.of("1.0.1", "1", 1)
        );
    }

}