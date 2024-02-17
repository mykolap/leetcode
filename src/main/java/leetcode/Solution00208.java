package leetcode;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * 208. Implement Trie (Prefix Tree)
 * <p>
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys
 * in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * 1. Trie() Initializes the trie object.
 * 2. void insert(String word) Inserts the string word into the trie.
 * 3. boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
 * and false otherwise.
 * 4. boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix
 * prefix, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * <p>
 * Output
 * [null, null, true, false, true, null, true]
 * <p>
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * <p>
 * Constraints:
 * <p>
 * 1. 1 <= word.length, prefix.length <= 2000
 * 2. word and prefix consist only of lowercase English letters.
 * 3. At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */
public class Solution00208 {

    public static class Trie {

        private final TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        // Time: O(m), where m is the key length
        // Space: O(m)
        public void insert(String word) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }

            node.isEndOfWord = true;
        }

        // Time: O(m), where m is the key length
        // Space: O(1)
        public boolean search(String word) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                node = node.children[c - 'a'];
                if (node == null) {
                    return false;
                }
            }

            return node.isEndOfWord;
        }

        // Time: O(m), where m is the key length
        // Space: O(1)
        public boolean startsWith(String prefix) {
            TrieNode node = root;

            for (char c : prefix.toCharArray()) {
                node = node.children[c - 'a'];
                if (node == null) {
                    return false;
                }
            }

            return true;
        }

    }

    private static class TrieNode {
        private static final int ALPHABET_SIZE = 26;
        private final TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        private boolean isEndOfWord;
    }

}
