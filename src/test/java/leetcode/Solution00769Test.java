package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00769Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxChunksToSorted(String arrStr, int expected) {
        int[] arr = ArrayUtils.stringToIntArray(arrStr);
        assertEquals(expected, new Solution00769().maxChunksToSorted(arr));
    }

    /*
    Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
     */

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[4,3,2,1,0]", 1),
                Arguments.of("[1,0,2,3,4]", 4)
        );
    }

}