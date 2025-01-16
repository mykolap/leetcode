package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02425Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void xorAllNums(String nums1Str, String nums2Str, int expected) {
        int[] nums1 = ArrayUtils.stringToIntArray(nums1Str);
        int[] nums2 = ArrayUtils.stringToIntArray(nums2Str);
        assertEquals(expected, new Solution02425().xorAllNums(nums1, nums2));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[2,1,3]", "[10,2,5,0]", 13),
                Arguments.of("[1,2]", "[3,4]", 0)
        );
    }

}