package practice.com.app.searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSumApproach {
    private static boolean isSumPresent(int[] nums, int sum) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(sum - nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }

    private static boolean isSumPresent1(int[] nums, int sum) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int val = nums[start] + nums[end];
            if(val == sum)
                return true;
            else if(val > sum)
                end--;
            else
                start++;

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,9,2,8,10,11};
        int sum = 100;

        boolean ans = isSumPresent(nums, sum);

        System.out.println(ans);

        ans = isSumPresent1(nums, sum);
        System.out.println(ans);
    }
}
