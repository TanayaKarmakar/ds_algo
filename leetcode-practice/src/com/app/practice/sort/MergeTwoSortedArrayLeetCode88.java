package com.app.practice.sort;

import java.util.Arrays;

public class MergeTwoSortedArrayLeetCode88 {
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int setIndx = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while(i >= 0 && j >= 0) {
            int val = nums1[i] > nums2[j] ? nums1[i--]: nums2[j--];
            nums1[setIndx--] = val;
        }

        while(j >= 0) {
            nums1[setIndx--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
