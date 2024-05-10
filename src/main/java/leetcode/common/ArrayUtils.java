package leetcode.common;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayUtils {

    public static int[] stringToIntArray(String str) {
        // Remove the brackets and split the string by comma
        String[] strArray = str.replace("[", "").replace("]", "").split(",");

        // Convert each element to an integer
        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i].trim());
        }

        return intArray;
    }

    public static String stringArrayToString(String[] strArray) {
        return Arrays.stream(strArray).collect(Collectors.joining("\",\"", "[\"", "\"]"));
    }

    public static String intArrayToString(int[] intArray) {
        return Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }

}
