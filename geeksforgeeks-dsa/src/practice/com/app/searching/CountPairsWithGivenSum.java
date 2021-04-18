package practice.com.app.searching;

import java.util.HashSet;
import java.util.Set;

public class CountPairsWithGivenSum {
    private static int countPairs(int[] nums, int sum) {
        Set<Integer> set = new HashSet<>();

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(sum - nums[i]))
                count++;
            set.add(nums[i]);
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
