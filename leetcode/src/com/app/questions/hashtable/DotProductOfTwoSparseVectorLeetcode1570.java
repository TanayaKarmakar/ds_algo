package com.app.questions.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class SparseVector {
	int[] nums;

	SparseVector(int[] nums) {
		this.nums = nums;
	}

	// Return the dotProduct of two sparse vectors
	public int dotProduct(SparseVector vec) {
		if (this.nums.length != vec.getNums().length)
			return 0;
		Map<Integer, Integer> map1 = this.compact();
		Map<Integer, Integer> map2 = vec.compact();

		int res = 0;
		Set<Integer> keySet = map1.keySet();
		for (Integer el : keySet) {
			if (map2.containsKey(el)) {
				int val1 = map1.get(el);
				int val2 = map2.get(el);
				res += (val1 * val2);
			}
		}

		return res;
	}

	public int[] getNums() {
		return nums;
	}

	public Map<Integer, Integer> compact() {
		int n = nums.length;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0)
				map.put(i, nums[i]);
		}

		return map;
	}
}

public class DotProductOfTwoSparseVectorLeetcode1570 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 0, 0, 2, 3 };
		int[] nums2 = { 0, 3, 0, 4, 0 };
		SparseVector v1 = new SparseVector(nums1);
		SparseVector v2 = new SparseVector(nums2);
		
		int ans = v1.dotProduct(v2);
		
		System.out.println(ans);

	}

}
