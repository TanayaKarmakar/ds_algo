package com.app.practice.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArraysLeetcode349 {
    private int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
            return intersection(nums2, nums1);
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++)
            set.add(nums1[i]);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        for(Integer el: list) {
            res[i++] = el;
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
