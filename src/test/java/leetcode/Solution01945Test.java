package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01945Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void getLucky(String s, int k, int expected) {
        Solution01945 solution01945 = new Solution01945();
        int result = solution01945.getLucky(s, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return java.util.stream.Stream.of(
                Arguments.of("iiii", 1, 36),
                Arguments.of("leetcode", 2, 6),
                Arguments.of("zbax", 2, 8)
        );
    }

}