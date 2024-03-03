package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02998Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(26, 1, 3),
                Arguments.of(54, 2, 4),
                Arguments.of(25, 30, 5),
                Arguments.of(4, 2, 2),
                Arguments.of(8, 2, 3),
                Arguments.of(13, 1, 3),
                Arguments.of(13, 3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumOperationsToMakeEqual(int x, int y, int expected) {
        assertEquals(expected, new Solution02998().minimumOperationsToMakeEqual(x, y));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumOperationsToMakeEqualBfs(int x, int y, int expected) {
        assertEquals(expected, new Solution02998().minimumOperationsToMakeEqualBfs(x, y));
    }

}