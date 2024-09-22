package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00440Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findKthNumber(int n, int k, int expected) {
        int actual = new Solution00440().findKthNumber(n, k);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(13, 2, 10),
                Arguments.of(13, 5, 13),
                Arguments.of(13, 6, 2),
                Arguments.of(1, 1, 1),
                Arguments.of(681692778, 351251360, 416126219)
        );
    }

}