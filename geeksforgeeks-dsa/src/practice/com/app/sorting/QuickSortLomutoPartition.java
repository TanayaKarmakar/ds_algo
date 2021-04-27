package practice.com.app.sorting;

import java.util.Arrays;

public class QuickSortLomutoPartition {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;

        for(int j = l; j <= (r - 1); j++) {
            if(nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return (i + 1);
    }

    private static void quickSort(int[] nums, int l, int r) {
        if(l < r) {
            int p = partition(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] nums = {8,4,7,9,3,10,5};

        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }
}
