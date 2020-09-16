package com.app.questions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrayLeetcode350 {
	private static int[] intersect1(int[] nums1, int[] nums2) {
		if (nums1.length < nums2.length)
			return intersect(nums2, nums1);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
		}

		int k = 0;
		for (int i = 0; i < nums2.length; i++) {
			int count = map.getOrDefault(nums2[i], 0);
			if (count > 0) {
				nums1[k++] = nums2[i];
				map.put(nums2[i], count - 1);
			}
		}

		return Arrays.copyOfRange(nums1, 0, k);
	}

	private static int[] intersect(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if (m < n) {
			int[] tmp = nums1;
			nums1 = nums2;
			nums2 = tmp;

			int tmpLen = m;
			m = n;
			n = tmpLen;
		}

		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();

		for (int i = 0; i < m; i++) {
			map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
		}

		for (int i = 0; i < n; i++) {
			map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
		}

		List<Integer> res = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
			int val1 = entry.getValue();
			if (map1.containsKey(entry.getKey())) {
				int val2 = map1.get(entry.getKey());
				int min = Integer.min(val1, val2);
				while (min-- > 0) {
					res.add(entry.getKey());
				}
			}
		}

		int[] resArr = new int[res.size()];
		int i = 0;
		for (Integer el : res) {
			resArr[i++] = el;
		}

		return resArr;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 };
		int[] nums2 = { 2, 2 };

		int[] res = intersect(nums1, nums2);

		System.out.println(Arrays.toString(res));
		
		res = intersect1(nums1, nums2);
		
		System.out.println(Arrays.toString(res));
	}

}
