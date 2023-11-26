package leetcode.timeBasedKeyValueStore;

import java.util.*;

/**
 * https://leetcode.com/problems/time-based-key-value-store/
 * 981. Time Based Key-Value Store
 * Medium
 * <p>
 * Share Create a timebased key-value store class TimeMap, that supports two
 * operations.
 * <p>
 * 1. set(string key, string value, int timestamp)
 * <p>
 * Stores the key and value, along with the given timestamp. 2. get(string
 * key, int timestamp)
 * <p>
 * Returns a value such that set(key, value, timestamp_prev) was called
 * previously, with timestamp_prev <= timestamp. If there are multiple such
 * values, it returns the one with the largest timestamp_prev. If there are no
 * values, it returns the empty string ("").
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs =
 * [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * Output: [null,null,"bar","bar",null,"bar2","bar2"] Explanation: TimeMap
 * kv; kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along
 * with timestamp = 1 kv.get("foo", 1); // output "bar" kv.get("foo", 3); //
 * output "bar" since there is no value corresponding to foo at timestamp 3 and
 * timestamp 2, then the only value is at timestamp 1 ie "bar" kv.set("foo",
 * "bar2", 4); kv.get("foo", 4); // output "bar2" kv.get("foo", 5); //output
 * "bar2"
 * <p>
 * Example 2:
 * <p>
 * Input: inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs
 * =
 * [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],
 * ["love",20],["love",25]] Output:
 * [null,null,null,"","high","high","low","low"]
 * <p>
 * Constraints:
 * <p>
 * 1 <= key.length, value.length <= 100
 * key and value consist of lowercase English letters and digits.
 * 1 <= timestamp <= 107
 * All the timestamps timestamp of set are strictly increasing.
 * At most 2 * 105 calls will be made to set and get.
 */
public class TimeMap {

    private final Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new TreeMap<>();
    }

    // Time: O(logn)
    // Space: O(1)
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = map.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, value);
        map.put(key, treeMap);
    }

    // Time: O(logn)
    // Space: O(1)
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return "";
        }
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        if (entry != null) {
            return entry.getValue();
        }
        return "";
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

class TimeMapListBased {
    private Map<String, List<Data>> map;

    public TimeMapListBased() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Data> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Data(timestamp, value));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<Data> list = map.get(key);
        if (list == null) {
            return "";
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            final int middleTimestamp = list.get(mid).timestamp;

            if (middleTimestamp == timestamp) {
                return list.get(mid).value;
            }

            if (middleTimestamp < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0) {
            return "";
        }
        return list.get(right).value;
    }

    private static class Data {
        int timestamp;
        String value;

        public Data(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
