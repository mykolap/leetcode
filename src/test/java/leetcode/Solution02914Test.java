package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02914Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minChanges(String s, int expected) {
        Solution02914 solution = new Solution02914();
        assertEquals(expected, solution.minChanges(s));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("1001", 2),
                Arguments.of("10", 1),
                Arguments.of("0000", 0)
        );
    }

}