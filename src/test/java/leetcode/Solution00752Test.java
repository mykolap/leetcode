package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00752Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void openLock(String[] deadends, String target, int expected) {
        int actual = new Solution00752().openLock(deadends, target);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202", 6),
                Arguments.of(new String[]{"8888"}, "0009", 1),
                Arguments.of(new String[]{"8888"}, "0000", 0),
                Arguments.of(new String[]{"0000"}, "8888", -1),
                Arguments.of(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888", -1)
        );
    }
}