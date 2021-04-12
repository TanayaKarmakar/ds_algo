package practice.com.app.array;

import java.util.Arrays;

public class LeftRotateArrayByOne {
    private static void rotateByOne(int[] nums) {
        int el = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = el;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        rotateByOne(nums);

        System.out.println(Arrays.toString(nums));
    }
}
