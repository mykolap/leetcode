package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03038Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxOperations(int[] nums, int expected) {
        int result = new Solution03038().maxOperations(nums);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1, 4, 5}, 2),
                Arguments.of(new int[]{3, 2, 6, 1, 4}, 1)
        );
    }
    
}