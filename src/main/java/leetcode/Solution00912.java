package leetcode;

/**
 * 912. Sort an Array
 * <a href="https://leetcode.com/problems/sort-an-array">Web link</a>
 * Medium
 */

public class Solution00912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return i + 1;
    }

    private void swap(int[] nums, int i, int end) {
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
    }

    public int[] sortArrayCountingSort(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int range = max - min + 1;
        int[] count = new int[range];

        for (int num : nums) {
            count[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < range; i++) {
            int freq = count[i];
            if (freq > 0) {
                int value = i + min;
                while (freq-- > 0) {
                    nums[index++] = value;
                }
            }
        }

        return nums;
    }

}