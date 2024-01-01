package leetcode.assignCookies;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/assign-cookies/">
 * 455. Assign Cookies
 * </a>
 * <br/>
 * <div class="content__u3I1 question-content__JfgR">
 * <div><p>Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.</p>
 *
 * <p>Each child <code>i</code> has&nbsp;a greed factor <code>g[i]</code>, which is the minimum size of a cookie that the child will be content with; and each cookie <code>j</code> has a size <code>s[j]</code>. If <code>s[j]&nbsp;&gt;= g[i]</code>, we can assign the cookie <code>j</code> to the child <code>i</code>, and the child <code>i</code> will be content. Your goal is to maximize the number of your content children and output the maximum number.</p>
 *
 * <p>&nbsp;</p>
 * <p><strong>Example 1:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> g = [1,2,3], s = [1,1]
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 *
 * <pre>
 * <strong>Input:</strong> g = [1,2], s = [1,2,3]
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 * </pre>
 *
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * <p>
 * 1 <= g.length <= 3 * 104
 * 0 <= s.length <= 3 * 104
 * 1 <= g[i], s[j] <= 231 - 1
 */
public class Solution0455 {

    // O(n⋅logn+m⋅logm)
    // Space: O(logn+logm)
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        int childIndex = 0;
        int cookieIndex = 0;

        if (s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);

        while (childIndex < g.length && cookieIndex < s.length) {
            int greed = g[childIndex];
            int cookieSize = s[cookieIndex];
            if (greed <= cookieSize) {
                result++;
                childIndex++;
                cookieIndex++;
            } else {
                cookieIndex++;
            }
        }
        return result;
    }
}
