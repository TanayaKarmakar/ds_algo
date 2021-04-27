package practice.com.app.sorting;

import java.util.Arrays;

public class LomutoPartition {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int lomutoPartition(int[] nums, int l, int r) {
        int i = l - 1;
        int pivot = nums[r];

        for(int j = l; j <= (r - 1); j++) {
            if(nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return (i + 1);
    }

    public static void main(String[] args) {
        int[] nums = {10,80,30,90,40,50,70};

        int pivot = lomutoPartition(nums, 0, nums.length - 1);

        System.out.println(pivot);
        System.out.println(Arrays.toString(nums));
    }
}
