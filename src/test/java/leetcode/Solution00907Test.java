package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00907Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 1, 2, 4}, 17),
                Arguments.of(new int[]{11, 81, 94, 43, 3}, 444)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sumSubarrayMins(int[] arr, int expected) {
        assertEquals(expected, new Solution00907().sumSubarrayMins(arr));
    }

}