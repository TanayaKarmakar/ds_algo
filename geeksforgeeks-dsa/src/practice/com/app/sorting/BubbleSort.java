package practice.com.app.sorting;

import java.util.Arrays;

public class BubbleSort {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void sort(int[] nums) {
        int n = nums.length - 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                if(nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,8,20,5};

        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
