package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02125Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.arguments(new String[]{"011001", "000000", "010100", "001000"}, 8),
                Arguments.arguments(new String[]{"000", "111", "000"}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numberOfLaserBeamsInABank(String[] bank, int expected) {
        final int actual = new Solution02125().numberOfLaserBeamsInABank(bank);
        assertEquals(expected, actual);
    }
}