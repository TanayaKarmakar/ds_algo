package practice.com.app.array;

import java.util.Arrays;

public class LeftRotateTheArrayByPosition {
    private static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    private static void rotateArray(int[] nums, int d) {
        int n = nums.length;
        if(d > n) {
            d = d % n;
        }
        reverse(nums, 0, n - 1);
        reverse(nums, 0, n - d - 1);
        reverse(nums, n - d, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int d = 4;

        rotateArray(nums, d);

        System.out.println(Arrays.toString(nums));
    }
}
