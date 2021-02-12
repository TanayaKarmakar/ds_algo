package com.app.practice.bitmagic;

public class SingleNumberLeetCode136 {
    private static int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        int ans = singleNumber(nums);

        System.out.println(ans);
    }
}
