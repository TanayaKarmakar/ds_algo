package com.app.practice.fenwicktree;

class NumArray {
	int[] BIT;
	int size;

	public NumArray(int[] nums) {
		this.size = nums.length + 1;
		this.BIT = new int[size];

		for (int i = 0; i < nums.length; i++) {
			insert(i + 1, nums[i]);
		}
	}

	public void update(int i, int val) {
		BIT[i] = val;
	
	}

	public int sumRange(int i, int j) {
		return query(j + 1) - query(i);
	}
	
	private void insert(int i, int val) {
		while (i < size) {
			BIT[i] += val;
			i = i + (i & (-i));
		}
	}

	private int query(int i) {
		int sum = 0;
		while (i > 0) {
			sum += BIT[i];
			i = i - (i & (-i));
		}
		return sum;
	}
}

public class RangeSumQueryMutableLeetcode307 {

	public static void main(String[] args) {
		NumArray obj = new NumArray(new int[] { 1, 3, 5 });
		
		System.out.println(obj.sumRange(0, 2));
		
		obj.update(1, 2);
		
		System.out.println(obj.sumRange(0, 2));

	}

}
