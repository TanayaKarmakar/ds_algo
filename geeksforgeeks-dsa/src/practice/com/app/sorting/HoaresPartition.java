package practice.com.app.sorting;

import java.util.Arrays;

public class HoaresPartition {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int partition(int[] nums, int l, int r) {
        int i = l - 1;
        int j = r + 1;

        int pivot = nums[l];

        while(true) {
            do {
                i++;
            } while (nums[i] < pivot);

            do {
                j--;
            } while (nums[j] > pivot);

            if (i >= j)
                return j;
            swap(nums, i, j);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,3,8,4,2,7,1,10};
        int ans = partition(nums, 0, nums.length - 1);

        System.out.println(ans);
        System.out.println(Arrays.toString(nums));
    }
}
