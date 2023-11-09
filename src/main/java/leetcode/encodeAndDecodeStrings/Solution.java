package leetcode.encodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/encode-and-decode-strings/
 * 271. Encode and Decode Strings
 * <p>
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is
 * decoded back to the original list of strings.
 * <p>
 * Machine 1 (sender) has the function:
 * <p>
 * string encode(vector<string> strs) { // ... your code return encoded_string; } Machine 2 (receiver) has the function:
 * <p>
 * vector<string> decode(string s) { //... your code return strs; }
 * <p>
 * So Machine 1 does:
 * <p>
 * string encoded_string = encode(strs); and Machine 2 does:
 * <p>
 * vector<string> strs2 = decode(encoded_string); strs2 in Machine 2 should be the same as strs in Machine 1.
 * <p>
 * Implement the encode and decode methods.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: dummy_input = ["Hello","World"] Output: ["Hello","World"] Explanation: Machine 1: Codec encoder = new
 * Codec(); String msg = encoder.encode(strs); // send encoded string over the network to machine 2
 * <p>
 * Machine 2: Codec decoder = new Codec(); String[] strs = decoder.decode(msg); // return ["Hello","World"].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200 0 <= strs[i].length <= 200 strs[i] contains any possible characters out of 256 valid ASCII
 * characters. Calls encode() and decode() as many times as needed. You must not implement any functionality of
 * Built-in String library or Built-in Codec library, like
 * <p>
 * String.split(). Note: This is a companion problem to the System Design problem: Design TinyURL.
 */
public class Solution {

    // Time: O(n)
    // Space: O(n)
    public class Codec {

        private static final char SEPARATOR = ';';

        // Encodes a list of strings to a single string.
        public String encode(String[] strs) {
            // Create a string builder.
            StringBuilder sb = new StringBuilder();

            // Iterate over the array.
            for (String str : strs) {
                // Append the length of the string.
                sb.append(str.length());
                // Append a delimiter.
                sb.append(SEPARATOR);
                // Append the string.
                sb.append(str);
            }

            // Return the string.
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public String[] decode(String s) {
            // Create a list of strings.
            List<String> list = new ArrayList<>();

            // Iterate over the string.
            int n = s.length();
            int pointer1 = 0;
            int pointer2 = pointer1 + 1;
            while (pointer2 < n - 1) {
                // Get the length of the string.
                if (s.charAt(pointer2) == SEPARATOR) {
                    int len = Integer.parseInt(s.substring(pointer1, pointer2));
                    String str = s.substring(pointer2 + 1, pointer2 + 1 + len);
                    list.add(str);
                    pointer1 = pointer2 + 1 + len;
                    pointer2 = pointer1 + 1;
                } else {
                    pointer2++;
                }
            }

            // Return the list.
            return list.toArray(new String[0]);
        }
    }

}
