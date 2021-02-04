package com.app.practice.array;

public class FindPivotIndexLeetCode724 {
    private static int pivotIndex(int[] nums) {
        int right = 0;
        for(int i = 0; i < nums.length; i++) {
            right += nums[i];
        }

        int left = 0;
        for(int i = 0; i < nums.length; i++) {
            right = right - nums[i];
            if(left == right)
                return i;
            left += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};

        System.out.println(pivotIndex(nums));
    }
}
