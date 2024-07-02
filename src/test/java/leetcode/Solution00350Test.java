package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00350Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void intersect(String nums1Str, String nums2Str, String expectedStr) {
        int[] nums1 = ArrayUtils.stringToIntArray(nums1Str);
        int[] nums2 = ArrayUtils.stringToIntArray(nums2Str);
        assertThat(ArrayUtils.intArrayToString(new Solution00350().intersect(nums1, nums2)))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,2,1]", "[2,2]", "[2,2]"),
                Arguments.of("[4,9,5]", "[9,4,9,8,4]", "[4,9]")
        );
    }
}