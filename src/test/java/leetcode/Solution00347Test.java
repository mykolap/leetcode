package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00347Test {

    static Stream<Arguments> getTopKFrequentArgs() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1}, 1, new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("getTopKFrequentArgs")
    void topKFrequentStream(int[] nums, int k, int[] expected) {
        assertArrayEquals(expected, new Solution00347().topKFrequentStream(nums, k));
    }

    @ParameterizedTest
    @MethodSource("getTopKFrequentArgs")
    void topKFrequentInSteps(int[] nums, int k, int[] expected) {
        assertArrayEquals(expected, new Solution00347().topKFrequentInSteps(nums, k));
    }

}