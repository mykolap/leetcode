package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00539Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findMinDifference(List<String> timePoints, int expected) {
        assertEquals(expected, new Solution00539().findMinDifference(timePoints));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(List.of("23:59", "00:00"), 1),
                Arguments.of(List.of("00:00", "23:59", "00:00"), 0)
        );
    }

}