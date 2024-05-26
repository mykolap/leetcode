package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00552Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void checkRecord(int n, int expected) {
        int result = new Solution00552().checkRecord(n);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void checkRecordAlternative(int n, int expected) {
        int result = new Solution00552().checkRecordAlternative(n);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(2, 8),
                Arguments.of(1, 3),
                Arguments.of(10101, 183236316)
        );
    }

}