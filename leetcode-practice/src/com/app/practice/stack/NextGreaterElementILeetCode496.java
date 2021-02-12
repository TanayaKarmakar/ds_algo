package com.app.practice.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementILeetCode496 {
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        int n = nums2.length;

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i])
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty())
            map.put(stack.pop(), -1);

        int[] res = new int[nums1.length];

        for(int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] res = nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(res));
    }
}
