package leetcode.common;

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

}
