package com.app.practice.array;

public class RemoveDuplicatesFromSortedArrayLeetcode26 {
    private static int removeDuplicates(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        int len = 1;
        int current = nums[0];

        int i = 1;
        while(i < nums.length) {
            if(nums[i] != current) {
                nums[len] = nums[i];
                current = nums[len++];
            }
            i++;
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int len = removeDuplicates(nums);

        for(int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
