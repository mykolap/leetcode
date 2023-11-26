package leetcode.timeBasedKeyValueStore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeMapTest {

    @Test
    void keyValueStoreShouldReturnCorrectValue() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        assertEquals("bar", timeMap.get("foo", 1));
        assertEquals("bar", timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        assertEquals("bar2", timeMap.get("foo", 4));
        assertEquals("bar2", timeMap.get("foo", 5));
    }

    @Test
    void keyValueStoreShouldReturnCorrectValue2() {
        TimeMapListBased timeMap = new TimeMapListBased();
        timeMap.set("foo", "bar", 1);
        assertEquals("bar", timeMap.get("foo", 1));
        assertEquals("bar", timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4);
        assertEquals("bar2", timeMap.get("foo", 4));
        assertEquals("bar2", timeMap.get("foo", 5));
    }

    @Test
    void keyValueStoreShouldReturnEmptyStringForNonExistentKey() {
        TimeMap solution = new TimeMap();
        assertEquals("", solution.get("nonExistentKey", 1));
    }

    @Test
    void keyValueStoreShouldReturnLatestValueForSameTimestamp() {
        TimeMap solution = new TimeMap();
        solution.set("foo", "bar", 1);
        solution.set("foo", "baz", 1);
        assertEquals("baz", solution.get("foo", 1));
    }

    @Test
    void keyValueStoreShouldReturnLatestValueBeforeTimestamp() {
        TimeMap solution = new TimeMap();
        solution.set("foo", "bar", 1);
        solution.set("foo", "baz", 3);
        assertEquals("bar", solution.get("foo", 2));
    }

    @Test
    void keyValueStoreShouldReturnLatestValueBeforeTimestamp2() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        assertEquals("", timeMap.get("love", 5));
        assertEquals("high", timeMap.get("love", 10));
        assertEquals("high", timeMap.get("love", 15));
        assertEquals("low", timeMap.get("love", 20));
        assertEquals("low", timeMap.get("love", 25));
    }

}