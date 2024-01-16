package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution00380Test {

    @Test
    void testRandomizedSet() {
        Solution00380.RandomizedSet randomSet = new Solution00380.RandomizedSet();
        assertTrue(randomSet.insert(1));
        assertFalse(randomSet.remove(2));
        assertTrue(randomSet.insert(2));
        int random = randomSet.getRandom();
        assertTrue(random == 1 || random == 2);
        assertTrue(randomSet.remove(1));
        assertFalse(randomSet.insert(2));
        assertEquals(2, randomSet.getRandom());
    }

}