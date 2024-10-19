package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01545Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findKthBit(int n, int k, char expected) {
        Solution01545 solution01545 = new Solution01545();
        assertEquals(expected, solution01545.findKthBit(n, k));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(3, 1, '0'),
                Arguments.of(4, 11, '1')
        );
    }

}