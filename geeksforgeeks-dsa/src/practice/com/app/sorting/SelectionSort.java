package practice.com.app.sorting;

import java.util.Arrays;

public class SelectionSort {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void sort(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int minInd = i;
            for(int j = (i + 1); j < n; j++) {
                if(nums[minInd] > nums[j])
                    minInd = j;
            }
            swap(nums, i, minInd);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,5,8,20,2,18};

        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
