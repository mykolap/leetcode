package leetcode.reorderList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void reorderListEven() {
        Solution.ListNode head = new Solution.ListNode(1,
                new Solution.ListNode(2,
                        new Solution.ListNode(3,
                                new Solution.ListNode(4))));

        new Solution().reorderList(head);

        // Expected values in the merged list
        int[] expectedValues = {1, 4, 2, 3};
        int index = 0;

        // Traverse the result list and check each node's value
        while (head != null) {
            assertEquals(expectedValues[index], head.val);
            head = head.next;
            index++;
        }

        // Assert that the length of the result list is equal to the length of the expected values array
        assertEquals(expectedValues.length, index, "The length of the result list should be equal to the length of the expected values array");
    }

    @Test
    void reorderListOdd() {
        Solution.ListNode head = new Solution.ListNode(1,
                new Solution.ListNode(2,
                        new Solution.ListNode(3,
                                new Solution.ListNode(4,
                                        new Solution.ListNode(5)))));

        new Solution().reorderList(head);

        // Expected values in the merged list
        int[] expectedValues = {1, 5, 2, 4, 3};
        int index = 0;

        // Traverse the result list and check each node's value
        while (head != null) {
            assertEquals(expectedValues[index], head.val);
            head = head.next;
            index++;
        }

        // Assert that the length of the result list is equal to the length of the expected values array
        assertEquals(expectedValues.length, index, "The length of the result list should be equal to the length of the expected values array");
    }

    @Test
    void reorderListSingleElement() {
        Solution.ListNode head = new Solution.ListNode(1);

        new Solution().reorderList(head);

        // Expected values in the merged list
        int[] expectedValues = {1};
        int index = 0;

        // Traverse the result list and check each node's value
        while (head != null) {
            assertEquals(expectedValues[index], head.val);
            head = head.next;
            index++;
        }

        // Assert that the length of the result list is equal to the length of the expected values array
        assertEquals(expectedValues.length, index, "The length of the result list should be equal to the length of the expected values array");
    }

}