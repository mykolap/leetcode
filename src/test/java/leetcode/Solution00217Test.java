package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00217Test {

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
        Assertions.assertEquals(expected, new Solution00217().containsDuplicateBrutforce(nums));
    }

    @ParameterizedTest
    @MethodSource("getContainsDuplicateArgs")
    void containsDuplicateSorted(int[] nums, boolean expected) {
        assertEquals(expected, new Solution00217().containsDuplicateSorted(nums));
    }

    @ParameterizedTest
    @MethodSource("getContainsDuplicateArgs")
    void containsDuplicate(int[] nums, boolean expected) {
        assertEquals(expected, new Solution00217().containsDuplicate(nums));
    }

}