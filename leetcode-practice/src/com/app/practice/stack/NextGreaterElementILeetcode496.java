package com.app.practice.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementILeetcode496 {
	private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums2.length; i++) {
			while (!stack.isEmpty() && stack.peek() < nums2[i]) {
				map.put(stack.pop(), nums2[i]);
			}
			stack.push(nums2[i]);
		}

		while (!stack.isEmpty()) {
			map.put(stack.pop(), -1);
		}

		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = map.get(nums1[i]);
		}

		return nums1;
	}

	public static void main(String[] args) {
		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };
		
		nums1 = nextGreaterElement(nums1, nums2);
		
		System.out.println(Arrays.toString(nums1));
	}

}
