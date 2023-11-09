package leetcode.decodeWays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getIsAnagramArgs() {
        return Stream.of(
                Arguments.of("12", 2),
                Arguments.of("226", 3),
                Arguments.of("0", 0),
                Arguments.of("06", 0),
                Arguments.of("901", 0),
                Arguments.of("10", 1),
                Arguments.of("2101", 1),
                Arguments.of("21012", 2),
                Arguments.of("210123", 3),
                Arguments.of("2101234567890", 0),
                Arguments.of("21012345678901", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("getIsAnagramArgs")
    void numDecodingsRecursion(String input, int expected) {
        assertEquals(expected, new Solution().numDecodingsRecursion(input));
    }

    @ParameterizedTest
    @MethodSource("getIsAnagramArgs")
    void numDecodingsDp(String input, int expected) {
        assertEquals(expected, new Solution().numDecodingsDp(input));
    }

    @ParameterizedTest
    @MethodSource("getIsAnagramArgs")
    void numDecodings(String input, int expected) {
        assertEquals(expected, new Solution().numDecodings(input));
    }

}