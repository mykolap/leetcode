package leetcode.copyListWithRandomPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 138. Copy List with Random Pointer
 * <p>
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list.
 * <p>
 * The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list
 * such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list,
 * where X.random --> Y, then for the corresponding two nodes x and y in the copied list,
 * x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
 * or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Example 2:
 * <p>
 * <p>
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random is null or is pointing to some node in the linked list.
 */
public class Solution {

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

