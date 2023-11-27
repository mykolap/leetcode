package leetcode.medianOfTwoSortedArrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getMedianArgs() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2.0),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5),
                Arguments.of(new int[]{0, 0}, new int[]{0, 0}, 0.0),
                Arguments.of(new int[]{}, new int[]{1}, 1.0),
                Arguments.of(new int[]{2}, new int[]{}, 2.0),
                Arguments.of(new int[]{1, 3}, new int[]{2, 7}, 2.5),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}, 1.5)
        );
    }

    @ParameterizedTest
    @MethodSource("getMedianArgs")
    void findMedianSortedArrays(int[] nums1, int[] nums2, double expected) {
        assertEquals(expected, new Solution().findMedianSortedArrays(nums1, nums2));
    }

}