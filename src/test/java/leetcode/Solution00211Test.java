package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Solution00211Test {

    @Test
    void testOperations() {
        Solution00211.WordDictionary wordDictionary = new Solution00211.WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        assertFalse(wordDictionary.search("pad")); // return False
        assertTrue(wordDictionary.search("bad")); // return True
        assertTrue(wordDictionary.search(".ad")); // return True
        assertTrue(wordDictionary.search("b..")); // return True
    }

}