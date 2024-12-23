package leetcode;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02471Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumOperations(String rootStr, int expected) {
        TreeNode root = TreeNode.of(rootStr);
        int result = new Solution02471().minimumOperations(root);
        assertEquals(expected, result);
    }

    /*
    Example 1:


Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
Output: 3
Explanation:
- Swap 4 and 3. The 2nd level becomes [3,4].
- Swap 7 and 5. The 3rd level becomes [5,6,8,7].
- Swap 8 and 7. The 3rd level becomes [5,6,7,8].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.
Example 2:


Input: root = [1,3,2,7,6,5,4]
Output: 3
Explanation:
- Swap 3 and 2. The 2nd level becomes [2,3].
- Swap 7 and 4. The 3rd level becomes [4,6,5,7].
- Swap 6 and 5. The 3rd level becomes [4,5,6,7].
We used 3 operations so return 3.
It can be proven that 3 is the minimum number of operations needed.
Example 3:


Input: root = [1,2,3,4,5,6]
Output: 0
Explanation: Each level is already sorted in increasing order so return 0.
     */
    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,4,3,7,6,8,5,null,null,null,null,9,null,10]", 3),
                Arguments.of("[1,3,2,7,6,5,4]", 3),
                Arguments.of("[1,2,3,4,5,6]", 0)
        );
    }

}