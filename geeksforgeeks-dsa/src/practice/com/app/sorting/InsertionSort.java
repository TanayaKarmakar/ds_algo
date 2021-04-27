package practice.com.app.sorting;

import java.util.Arrays;

public class InsertionSort {
    private static void sort(int[] nums) {
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] nums = {20,5,40,60,10,30};

        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
