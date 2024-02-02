package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01291Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(100, 300, List.of(123, 234)),
                Arguments.of(1000, 13000, List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345))
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sequentialDigits(int low, int high, List<Integer> expected) {
        assertThat(new Solution01291().sequentialDigits(low, high))
                .containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sequentialDigitsWithSorting(int low, int high, List<Integer> expected) {
        assertThat(new Solution01291().sequentialDigitsWithSorting(low, high))
                .containsExactlyElementsOf(expected);
    }
}