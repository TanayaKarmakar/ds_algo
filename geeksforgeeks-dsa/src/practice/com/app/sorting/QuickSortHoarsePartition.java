package practice.com.app.sorting;

import java.util.Arrays;

public class QuickSortHoarsePartition {
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
            } while(nums[i] < pivot);

            do {
                j--;
            } while(nums[j] > pivot);
            if(i >= j)
                return j;
            swap(nums, i, j);
        }
    }


    private static void quickSort(int[] nums, int l, int r) {
        if(l < r) {
            int p = partition(nums, l, r);
            quickSort(nums, l, p);
            quickSort(nums, p + 1, r);
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {8,4,7,9,3,10,5};

        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));

    }
}
