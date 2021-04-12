package practice.com.app.array;

import java.util.Arrays;

public class MoveZerosToEnd {
    private static void moveZeros(int[] nums) {
        int len = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[len] = nums[i];
                if(len != i)
                    nums[i] = 0;
                len++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {8,5,0,10,0,20};

        moveZeros(nums);

        System.out.println(Arrays.toString(nums));

        nums = new int[]{10,20};
        moveZeros(nums);

        System.out.println(Arrays.toString(nums));

        nums = new int[]{0,0,0,10,0};
        moveZeros(nums);

        System.out.println(Arrays.toString(nums));

        nums = new int[]{10,8,0,0,12,0};
        moveZeros(nums);

        System.out.println(Arrays.toString(nums));

    }
}
