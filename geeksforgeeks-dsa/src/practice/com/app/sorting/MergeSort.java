package practice.com.app.sorting;

import java.util.Arrays;

public class MergeSort {
    private static void merge(int[] nums, int l, int mid, int r) {
        int[] left = new int[mid - l + 1];
        int[] right = new int[r - mid];

        int k = 0;
        for(int i = l; i <= mid; i++) {
            left[k++] = nums[i];
        }

        k = 0;
        for(int i = mid + 1; i <= r; i++) {
            right[k++] = nums[i];
        }

        int i = 0;
        int j = 0;
        k = l;

        while(i < left.length && j < right.length) {
            if(left[i] < right[j]) {
                nums[k++] = left[i++];
            }else {
                nums[k++] = right[j++];
            }
        }

        while(i < left.length) {
            nums[k++] = left[i++];
        }

        while(j < right.length) {
            nums[k++] = right[j++];
        }
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if(l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,5,30,15,7};
        mergeSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }
}
