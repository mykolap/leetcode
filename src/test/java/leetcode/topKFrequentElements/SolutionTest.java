package leetcode.topKFrequentElements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    static Stream<Arguments> getTopKFrequentArgs() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1}, 1, new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("getTopKFrequentArgs")
    void topKFrequent(int[] nums, int k, int[] expected) {
        assertArrayEquals(expected, new Solution().topKFrequent(nums, k));
    }

    @ParameterizedTest
    @MethodSource("getTopKFrequentArgs")
    void topKFrequentBruteforce(int[] nums, int k, int[] expected) {
        assertArrayEquals(expected, new Solution().topKFrequentBruteforce(nums, k));
    }

    @ParameterizedTest
    @MethodSource("getTopKFrequentArgs")
    void topKFrequentPriorityQueue(int[] nums, int k, int[] expected) {
        assertArrayEquals(expected, new Solution().topKFrequentPriorityQueue(nums, k));
    }

}