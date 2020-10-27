package com.app.practice.fenwicktree;

class NumArray {
	int[] BIT;
	int[] nums;
	int size;

	public NumArray(int[] nums) {
		this.nums = nums;
		int n = nums.length;
		size = n + 1;
		BIT = new int[size];
		for (int i = 0; i < n; i++) {
			insert(i + 1, nums[i]);
		}
	}

	public void update(int i, int val) {
		int prev = nums[i];
		nums[i] = val;

		while (i < size) {
			BIT[i] = BIT[i] - prev + val;
			i = i + (i & (-i));
		}

	}

	public int sumRange(int i, int j) {
		return query(j + 1) - query(i);
	}

	private int query(int i) {
		int sum = 0;
		while (i > 0) {
			sum += BIT[i];
			i = i - (i & (-i));
		}
		return sum;
	}

	private void insert(int i, int val) {
		while (i < size) {
			BIT[i] += val;
			i = i + (i & (-i));
		}
	}
}

public class RangeSumQueryMutableLeetcode307 {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5 };
		NumArray obj = new NumArray(nums);
		
		System.out.println(obj.sumRange(0, 2));
		
		obj.update(1, 2);
		
		System.out.println(obj.sumRange(0, 2));
	}

}
