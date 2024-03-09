package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02540Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void getCommon(int[] nums1, int[] nums2, int expected) {
        int actual = new Solution02540().getCommon(nums1, nums2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{2, 4},
                        2),
                Arguments.of(
                        new int[]{1, 2, 3, 6},
                        new int[]{2, 3, 4, 5},
                        2),
                Arguments.of(
                        new int[]{1, 2, 3},
                        new int[]{4, 5},
                        -1)
        );
    }
}