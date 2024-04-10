package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00950Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void deckRevealedIncreasing(int[] deck, int[] expected) {
        int[] actual = new Solution00950().deckRevealedIncreasing(deck);
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{17, 13, 11, 2, 3, 5, 7},
                        new int[]{2, 13, 3, 11, 5, 17, 7}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6},
                        new int[]{1, 4, 2, 6, 3, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7},
                        new int[]{1, 6, 2, 5, 3, 7, 4}),
                Arguments.of(new int[]{1, 1000},
                        new int[]{1, 1000})
        );
    }
}