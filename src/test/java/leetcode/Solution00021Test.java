package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Solution00021Test {

    @Test
    void mergeTwoLists() {
        Solution00021.ListNode l1 = new Solution00021.ListNode(1,
                new Solution00021.ListNode(2,
                        new Solution00021.ListNode(4)));

        Solution00021.ListNode l2 = new Solution00021.ListNode(1,
                new Solution00021.ListNode(3,
                        new Solution00021.ListNode(4)));

        Solution00021.ListNode result = new Solution00021().mergeTwoLists(l1, l2);

        // Assert that the result is not null
        assertNotNull(result, "The result should not be null");

        // Expected values in the merged list
        int[] expectedValues = {1, 1, 2, 3, 4, 4};
        int index = 0;

        // Traverse the result list and check each node's value
        while (result != null) {
            assertEquals(expectedValues[index], result.val);
            result = result.next;
            index++;
        }

        // Assert that the length of the result list is equal to the length of the expected values array
        assertEquals(expectedValues.length, index, "The length of the result list should be equal to the length of the expected values array");
    }

    @Test
    void mergeTwoLists_list1Null() {
        Solution00021.ListNode l1 = null;

        Solution00021.ListNode l2 = new Solution00021.ListNode(1,
                new Solution00021.ListNode(3,
                        new Solution00021.ListNode(4)));

        Solution00021.ListNode result = new Solution00021().mergeTwoLists(l1, l2);

        // Assert that the result is not null
        assertNotNull(result, "The result should not be null");

        // Expected values in the merged list
        int[] expectedValues = {1, 3, 4};
        int index = 0;

        // Traverse the result list and check each node's value
        while (result != null) {
            assertEquals(expectedValues[index], result.val);
            result = result.next;
            index++;
        }

        // Assert that the length of the result list is equal to the length of the expected values array
        assertEquals(expectedValues.length, index, "The length of the result list should be equal to the length of the expected values array");
    }

    @Test
    void mergeTwoLists_list2Null() {
        Solution00021.ListNode l1 = new Solution00021.ListNode(1,
                new Solution00021.ListNode(2,
                        new Solution00021.ListNode(4)));

        Solution00021.ListNode l2 = null;

        Solution00021.ListNode result = new Solution00021().mergeTwoLists(l1, l2);

        // Assert that the result is not null
        assertNotNull(result, "The result should not be null");

        // Expected values in the merged list
        int[] expectedValues = {1, 2, 4};
        int index = 0;

        // Traverse the result list and check each node's value
        while (result != null) {
            assertEquals(expectedValues[index], result.val);
            result = result.next;
            index++;
        }

        // Assert that the length of the result list is equal to the length of the expected values array
        assertEquals(expectedValues.length, index, "The length of the result list should be equal to the length of the expected values array");
    }

}