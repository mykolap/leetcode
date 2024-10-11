package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01963Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minSwaps(String s, int expected) {
        int actual = new Solution01963().minSwaps(s);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("][][", 1),
                Arguments.of("]]][[[", 2),
                Arguments.of("[]", 0),
                Arguments.of("[[[]]]", 0)
        );
    }

}