package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00981Test {

    @Test
    void keyValueStoreShouldReturnCorrectValue() {
        Solution00981.TimeMap timeMap = new Solution00981.TimeMap();
        timeMap.set("foo", "bar", 1);
        assertEquals("bar", timeMap.get("foo", 1));
        assertEquals("bar", timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        assertEquals("bar2", timeMap.get("foo", 4));
        assertEquals("bar2", timeMap.get("foo", 5));
    }

    @Test
    void keyValueStoreShouldReturnCorrectValue2() {
        Solution00981.TimeMapListBased timeMap = new Solution00981.TimeMapListBased();
        timeMap.set("foo", "bar", 1);
        assertEquals("bar", timeMap.get("foo", 1));
        assertEquals("bar", timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        assertEquals("bar2", timeMap.get("foo", 4));
        assertEquals("bar2", timeMap.get("foo", 5));
    }

    @Test
    void keyValueStoreShouldReturnEmptyStringForNonExistentKey() {
        Solution00981.TimeMap solution = new Solution00981.TimeMap();
        assertEquals("", solution.get("nonExistentKey", 1));
    }

    @Test
    void keyValueStoreShouldReturnLatestValueForSameTimestamp() {
        Solution00981.TimeMap solution = new Solution00981.TimeMap();
        solution.set("foo", "bar", 1);
        solution.set("foo", "baz", 1);
        assertEquals("baz", solution.get("foo", 1));
    }

    @Test
    void keyValueStoreShouldReturnLatestValueBeforeTimestamp() {
        Solution00981.TimeMap solution = new Solution00981.TimeMap();
        solution.set("foo", "bar", 1);
        solution.set("foo", "baz", 3);
        assertEquals("bar", solution.get("foo", 2));
    }

    @Test
    void keyValueStoreShouldReturnLatestValueBeforeTimestamp2() {
        Solution00981.TimeMap timeMap = new Solution00981.TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        assertEquals("", timeMap.get("love", 5));
        assertEquals("high", timeMap.get("love", 10));
        assertEquals("high", timeMap.get("love", 15));
        assertEquals("low", timeMap.get("love", 20));
        assertEquals("low", timeMap.get("love", 25));
    }

}