package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01481Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{5, 5, 4}, 1, 1),
                Arguments.of(new int[]{4, 3, 1, 1, 3, 3, 2}, 3, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findLeastNumOfUniqueInts(int[] arr, int k, int expected) {
        assertEquals(expected, new Solution01481().findLeastNumOfUniqueInts(arr, k));
    }

}