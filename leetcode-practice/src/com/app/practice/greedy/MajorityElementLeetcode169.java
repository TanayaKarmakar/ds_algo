package com.app.practice.greedy;

public class MajorityElementLeetcode169 {
    private static int majorityElement(int[] nums) {
        int mIndx = 0;
        int count = 1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[mIndx]) {
                count++;
            } else {
                count--;
                if(count == 0) {
                    mIndx = i;
                    count = 1;
                }
            }
        }

        count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[mIndx]) {
                count++;
            }
        }

        return count > nums.length / 2 ? nums[mIndx]: Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int ans = majorityElement(nums);

        System.out.println(ans);
    }
}
