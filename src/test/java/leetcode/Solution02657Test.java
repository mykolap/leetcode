package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02657Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findThePrefixCommonArray(String aStr, String bStr, String expectedStr) {
        int[] A = ArrayUtils.stringToIntArray(aStr);
        int[] B = ArrayUtils.stringToIntArray(bStr);
        int[] actual = new Solution02657().findThePrefixCommonArray(A, B);
        assertThat(ArrayUtils.intArrayToString(actual))
                .isEqualTo(expectedStr);
    }

    /*
    Example 1:

Input: A = [1,3,2,4], B = [3,1,2,4]
Output: [0,2,3,4]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
Example 2:

Input: A = [2,3,1], B = [3,1,2]
Output: [0,1,3]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: only 3 is common in A and B, so C[1] = 1.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
     */

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,3,2,4]", "[3,1,2,4]", "[0,2,3,4]"),
                Arguments.of("[2,3,1]", "[3,1,2]", "[0,1,3]")
        );
    }

}