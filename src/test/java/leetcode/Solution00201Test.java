package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00201Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rangeBitwiseAnd(int left, int right, int expected) {
        assertEquals(expected, new Solution00201().rangeBitwiseAnd(left, right));
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(5, 7, 4),
                Arguments.of(0, 0, 0),
                Arguments.of(1, 2147483647, 0)
        );
    }

}