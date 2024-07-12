package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01717Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumGain(String s, int x, int y, int expected) {
        int result = new Solution01717().maximumGain(s, x, y);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumGainOptimal(String s, int x, int y, int expected) {
        int result = new Solution01717().maximumGainOptimal(s, x, y);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("cdbcbbaaabab", 4, 5, 19),
                Arguments.of("aabbaaxybbaabb", 5, 4, 20),
                Arguments.of("aabb", 2, 1, 4)
        );
    }

}