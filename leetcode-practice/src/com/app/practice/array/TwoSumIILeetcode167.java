package com.app.practice.array;

import java.util.Arrays;

public class TwoSumIILeetcode167 {
    private static int[] twoSum(int[] numbers, int target) {
        int end = numbers.length - 1;
        int start = 0;
        while(start < end) {
            if(numbers[start] + numbers[end] == target)
                return new int[] {start + 1, end + 1};
            else if(numbers[start] + numbers[end] > target)
                end--;
            else
                start++;
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
