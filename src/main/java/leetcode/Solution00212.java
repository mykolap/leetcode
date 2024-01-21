package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. Word Search II
 * https://leetcode.com/problems/word-search-ii
 * <p>
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once in a word.
 * <p>
 * Constraints:
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 10^4
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
public class Solution00212 {

    // Time: O(m * n * 4^k)
    // Space: O(k)
    public List<String> findWords(char[][] board, String[] words) {
        // Build a Trie from the given words
        TrieNode root = buildTrie(words);

        // Initialize a list to store the result
        List<String> result = new ArrayList<>();

        // Iterate over each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // Perform a depth-first search from each cell
                dfs(board, i, j, root, words, result);
            }
        }

        // Return the list of words found on the board
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, String[] words, List<String> result) {
        // Boundary check for board
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        // Get the character at the current board position
        char c = board[i][j];

        // If the character is '#' (indicating it's already visited) or there's no corresponding TrieNode, return
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }

        // Move to the next TrieNode corresponding to the character
        p = p.next[c - 'a'];

        // If the TrieNode has a word index >= 0 (indicating we found a word),
        // add it to the result and set the word index to -1 to avoid duplicates
        if (p.wordIndex >= 0) {
            result.add(words[p.wordIndex]);
            p.wordIndex = -1;   // avoid duplicate
        }

        // Mark the current board position as visited by setting it to '#'
        board[i][j] = '#';

        // Iterate over all four directions
        // Move up
        if (i - 1 >= 0) {
            dfs(board, i - 1, j, p, words, result);
        }

        // Move down
        if (i + 1 < board.length) {
            dfs(board, i + 1, j, p, words, result);
        }

        // Move left
        if (j - 1 >= 0) {
            dfs(board, i, j - 1, p, words, result);
        }

        // Move right
        if (j + 1 < board[0].length) {
            dfs(board, i, j + 1, p, words, result);
        }

        // After the DFS, revert the current board position back to its original character
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        // Create a new TrieNode to serve as the root of the Trie
        TrieNode root = new TrieNode();

        // Iterate over each word in the input array
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            String word = words[wordIndex];
            // Start from the root for each word
            TrieNode p = root;

            // Iterate over each character in the word
            for (char c : word.toCharArray()) {
                // Convert the character to an index. 'a' becomes 0, 'b' becomes 1, etc.
                int i = c - 'a';

                // If the TrieNode for this character does not exist, create a new one
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }

                // Move to the next TrieNode
                p = p.next[i];
            }

            // After all characters of the word have been processed, set the word at the last TrieNode
            p.wordIndex = wordIndex;
        }

        // Return the root of the Trie
        return root;
    }

    private static class TrieNode {
        // An array of TrieNode references, each corresponding to a possible next character in a word.
        // 'a' corresponds to index 0, 'b' to index 1, ..., 'z' to index 25.
        TrieNode[] next = new TrieNode[26];

        // The index of word at this TrieNode, if any. -1 indicates no word ends at this TrieNode.
        int wordIndex = -1;
    }

}