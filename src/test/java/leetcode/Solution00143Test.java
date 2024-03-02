package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00143Test {

    @Test
    void reorderListEven() {
        Solution00143.ListNode head = new Solution00143.ListNode(1,
                new Solution00143.ListNode(2,
                        new Solution00143.ListNode(3,
                                new Solution00143.ListNode(4))));

        new Solution00143().reorderList(head);

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
        Solution00143.ListNode head = new Solution00143.ListNode(1,
                new Solution00143.ListNode(2,
                        new Solution00143.ListNode(3,
                                new Solution00143.ListNode(4,
                                        new Solution00143.ListNode(5)))));

        new Solution00143().reorderList(head);

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
        Solution00143.ListNode head = new Solution00143.ListNode(1);

        new Solution00143().reorderList(head);

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