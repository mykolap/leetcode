package leetcode.containsDuplicate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getContainsDuplicateArgs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("getContainsDuplicateArgs")
    void containsDuplicateBrutforce(int[] nums, boolean expected) {
        assertEquals(expected, new Solution().containsDuplicateBrutforce(nums));
    }

    @ParameterizedTest
    @MethodSource("getContainsDuplicateArgs")
    void containsDuplicateSorted(int[] nums, boolean expected) {
        assertEquals(expected, new Solution().containsDuplicateSorted(nums));
    }

    @ParameterizedTest
    @MethodSource("getContainsDuplicateArgs")
    void containsDuplicate(int[] nums, boolean expected) {
        assertEquals(expected, new Solution().containsDuplicate(nums));
    }

}