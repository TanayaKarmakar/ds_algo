package practice.com.app.array;

import java.util.LinkedHashSet;
import java.util.Set;


//need to recheck
public class PrintDistinctElementOfEveryWindowOfSizeK {
    private static void printDistinctElement(int[] nums, int k) {
        Set<Integer> set = new LinkedHashSet<>();
        int n = nums.length;
        int left = 0;
        int right = 0;

        while(right < k) {
            right++;
        }

        while(right < nums.length) {
            set.clear();
            for(int i = left; i <= right; i++) {
                set.add(nums[i]);
            }
            System.out.println(set);
            right++;
            left++;
        }

        System.out.println(set);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4,3,3};
        int k = 4;

        printDistinctElement(nums, k);

    }
}
