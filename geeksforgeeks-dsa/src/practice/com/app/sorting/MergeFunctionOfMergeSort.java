package practice.com.app.sorting;

import java.util.Arrays;

public class MergeFunctionOfMergeSort {
    private static void merge(int[] nums, int low, int mid, int high) {
        int[] l = new int[mid - low + 1];
        int[] r = new int[high - mid];

        int k = 0;
        for(int i = low; i <= mid; i++) {
            l[k++] = nums[i];
        }

        k = 0;
        for(int i = mid + 1; i <= high; i++) {
            r[k++] = nums[i];
        }

        int i = 0;
        int j = 0;

        k = 0;

        while(i < l.length && j < r.length) {
            if(l[i] < r[j]) {
                nums[k++] = l[i++];
            } else {
                nums[k++] = r[j++];
            }
        }

        while(i < l.length) {
            nums[k++] = l[i++];
        }

        while(j < r.length) {
            nums[k++] = r[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,15,20,11,30};
        int low = 0;
        int mid = 2;
        int high = 4;

        merge(nums, low, mid, high);

        System.out.println(Arrays.toString(nums));
    }
}
