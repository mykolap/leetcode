package leetcode;

import leetcode.common.ArrayUtils;
import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution03217Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void modifiedList(String numsStr, String headStr, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        ListNode head = ListNode.of(headStr);
        ListNode actual = new Solution03217().modifiedList(nums, head);
        assertThat(actual).hasToString(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3]", "[1,2,3,4,5]", "[4,5]"),
                Arguments.of("[1]", "[1,2,1,2,1,2]", "[2,2,2]"),
                Arguments.of("[5]", "[1,2,3,4]", "[1,2,3,4]")
        );
    }

}