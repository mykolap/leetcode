package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00349Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void intersection(int[] nums1, int[] nums2, int[] expected) {
        int[] actual = new Solution00349().intersection(nums1, nums2);
        assertThat(actual)
                .containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void intersectionImproved(int[] nums1, int[] nums2, int[] expected) {
        int[] actual = new Solution00349().intersectionImproved(nums1, nums2);
        assertThat(actual)
                .containsExactlyInAnyOrder(expected);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 2, 2, 1},
                        new int[]{2, 2},
                        new int[]{2}),
                Arguments.of(
                        new int[]{4, 9, 5},
                        new int[]{9, 4, 9, 8, 4},
                        new int[]{9, 4})
        );
    }

}