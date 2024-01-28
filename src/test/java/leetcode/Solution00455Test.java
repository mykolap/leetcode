package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00455Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 1}, 1),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2, 3}, 2),
                Arguments.of(new int[]{1, 2, 3}, new int[]{3}, 1),
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 3),
                Arguments.of(new int[]{1, 2, 3}, new int[]{}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findContentChildren(int[] g, int[] s, int expected) {
        int actual = new Solution00455().findContentChildren(g, s);
        assertEquals(expected, actual);
    }

}