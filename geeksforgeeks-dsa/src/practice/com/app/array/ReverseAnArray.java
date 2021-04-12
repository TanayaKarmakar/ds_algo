package practice.com.app.array;

import java.util.Arrays;

public class ReverseAnArray {
    private static void reverseArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,5,7,2,3,18};

        reverseArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
