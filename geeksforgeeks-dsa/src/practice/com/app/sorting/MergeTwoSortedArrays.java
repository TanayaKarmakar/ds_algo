package practice.com.app.sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    private static int[] mergeSortedArray(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] result = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                result[k] = nums1[i++];
            } else {
                result[k] = nums2[j++];
            }
            k++;
        }

        while(i < n1) {
            result[k++] = nums1[i++];
        }

        while(j < n2) {
            result[k++] = nums2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {10,15,20};
        int[] nums2 = {5,6,6,15};

        int[] result = mergeSortedArray(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }
}
