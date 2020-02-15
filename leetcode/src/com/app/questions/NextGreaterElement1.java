package com.app.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class NextGreaterElement1 {
	//leetcode approach
	private static int[] nextGreaterElementLeetcode(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer num : nums2) {
			while (!stack.isEmpty() && stack.peek() < num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}

		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.getOrDefault(nums1[i], -1);
		}
		
		return res;
	}

	private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		List<Integer> list = Arrays.stream(nums2).boxed().collect(Collectors.toList());
		int[] res = new int[nums1.length];

		Arrays.fill(res, -1);
		for (int i = 0; i < nums1.length; i++) {
			int indx = list.indexOf(nums1[i]);
			while (indx < list.size()) {
				if (list.get(indx) > nums1[i]) {
					res[i] = list.get(indx);
					break;
				} else {
					indx++;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };

		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
		
		System.out.println("Leetcode - " + Arrays.toString(nextGreaterElementLeetcode(nums1, nums2)));

		nums1 = new int[] { 2, 4 };
		nums2 = new int[] { 1, 2, 3, 4 };

		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
		
		System.out.println("Leetcode - " + Arrays.toString(nextGreaterElementLeetcode(nums1, nums2)));

		nums1 = new int[] { 2, 1, 3 };
		nums2 = new int[] { 2, 3, 1 };

		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
		
		System.out.println("Leetcode - " + Arrays.toString(nextGreaterElementLeetcode(nums1, nums2)));

	}

}
