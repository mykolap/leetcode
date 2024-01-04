package leetcode.minimumNumberOfOperationsToMakeArrayEmpty;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution2870Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}, 4),
                Arguments.arguments(new int[]{2, 1, 2, 2, 3, 3}, -1),
                Arguments.arguments(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4, 2, 3, 3, 2, 2, 4, 2, 3, 4, 2, 3, 3, 2, 2, 4, 2, 3, 4, 2, 3, 3, 2, 2, 4, 2, 3, 4}, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minOperations(int[] nums, int expected) {
        final int actual = new Solution2870().minOperations(nums);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minOperationsCeil(int[] nums, int expected) {
        final int actual = new Solution2870().minOperationsCeil(nums);
        assertEquals(expected, actual);
    }

}