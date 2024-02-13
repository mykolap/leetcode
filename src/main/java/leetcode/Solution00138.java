package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 138. Copy List with Random Pointer
 * Medium
 */
public class Solution00138 {

    // Time: O(n)
    // Space: O(n)
    public Node copyRandomList(Node head) {
        // Create a hash map to store the mapping from the original node to the copied node.
        Map<Node, Node> map = new HashMap<>();
        // Create a dummy node to be the head of the copied linked list.
        Node dummy = new Node(0);
        // Create a pointer to the dummy node.
        Node curr = dummy;
        // Create a pointer to the head of the original linked list.
        Node original = head;
        // Iterate over the nodes in the original linked list.
        while (original != null) {
            // Create a new node with the same value as the current node in the original linked list.
            Node copy = new Node(original.val);
            // Add the mapping from the current node in the original linked list to the new node to the hash map.
            map.put(original, copy);
            // Set the next pointer of the current node in the copied linked list to the new node.
            curr.next = copy;
            // Move the pointer to the current node in the original linked list to the next node.
            original = original.next;
            // Move the pointer to the current node in the copied linked list to the next node.
            curr = curr.next;
        }
        // Reset the pointer to the head of the original linked list.
        original = head;
        // Reset the pointer to the head of the copied linked list.
        curr = dummy.next;
        // Iterate over the nodes in the original linked list.
        while (original != null) {
            // Set the random pointer of the current node in the copied linked list to the node in the hash map
            // that the random pointer of the current node in the original linked list points to.
            curr.random = map.get(original.random);
            // Move the pointer to the current node in the original linked list to the next node.
            original = original.next;
            // Move the pointer to the current node in the copied linked list to the next node.
            curr = curr.next;
        }
        // Return the head of the copied linked list.
        return dummy.next;
    }

    // Time: O(n)
    // Space: O(1)
    public Node copyRandomListInterweavingNodes(Node head) {
        // Create a pointer to the head of the original linked list.
        Node original = head;
        // Iterate over the nodes in the original linked list.
        while (original != null) {
            // Create a new node with the same value as the current node in the original linked list.
            Node copy = new Node(original.val);
            // Set the next pointer of the new node to the next pointer of the current node in the original linked list.
            copy.next = original.next;
            // Set the next pointer of the current node in the original linked list to the new node.
            original.next = copy;
            // Move the pointer to the current node in the original linked list to the next node.
            original = original.next.next;
        }
        // Reset the pointer to the head of the original linked list.
        original = head;
        // Iterate over the nodes in the original linked list.
        while (original != null) {
            // Set the random pointer of the new node to the random pointer of the current node in the original linked list.
            original.next.random = original.random == null ? null : original.random.next;
            // Move the pointer to the current node in the original linked list to the next node.
            original = original.next.next;
        }
        // Create a dummy node to be the head of the copied linked list.
        Node dummy = new Node(0);
        // Create a pointer to the dummy node.
        Node curr = dummy;
        // Reset the pointer to the head of the original linked list.
        original = head;
        // Iterate over the nodes in the original linked list.
        while (original != null) {
            // Set the next pointer of the current node in the copied linked list to the next pointer of the current node in the original linked list.
            curr.next = original.next;
            // Move the pointer to the current node in the original linked list to the next node.
            original = original.next.next;
            // Move the pointer to the current node in the copied linked list to the next node.
            curr = curr.next;
        }
        // Return the head of the copied linked list.
        return dummy.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            var head = this;
            List<List<Integer>> values = new ArrayList<>();
            while (head != null) {
                List<Integer> value = new ArrayList<>();
                value.add(head.val);
                value.add(head.random == null ? null : head.random.val);
                values.add(value);
                head = head.next;
            }
            return values.toString();
        }
    }

}

