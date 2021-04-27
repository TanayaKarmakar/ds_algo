package practice.com.app.sorting;

import java.util.Arrays;

public class ChocolateDistributionProblem {
    private static int minDiff(int[] nums, int m) {
        Arrays.sort(nums);

        int diff = nums[m - 1] - nums[0];
        for(int i = 1; (i + m - 1) < nums.length; i++) {
            diff = Integer.min(diff, nums[i + m - 1] - nums[i]);
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] nums = {7,3,2,4,9,12,56};
        int m = 3;

        int ans = minDiff(nums, m);

        System.out.println(ans);
    }
}
