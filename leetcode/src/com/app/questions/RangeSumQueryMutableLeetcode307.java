package com.app.questions;

class NumArray {
	private int[] tree;
	private int n;
	private int[] nums;

	public NumArray(int[] nums) {
		int n = nums.length;
		this.n = n;
		this.nums = nums;
		tree = new int[4 * n];
		buildTree(tree, nums, 0, n - 1, 1);
	}

	public void update(int i, int val) {
		updateTree(tree, nums, 0, n - 1, 1, i, val);
	}

	public int sumRange(int i, int j) {
		return query(tree, nums, 0, n - 1, i, j, 1);
	}

	private static int query(int[] tree, int[] nums, int start, int end, int left, int right, int treeIndx) {
		if (end < left || start > right)
			return 0;
		if (start >= left && end <= right)
			return tree[treeIndx];
		int mid = start + (end - start) / 2;
		int ans1 = query(tree, nums, start, mid, left, right, 2 * treeIndx);
		int ans2 = query(tree, nums, mid + 1, end, left, right, 2 * treeIndx + 1);
		return ans1 + ans2;
	}

	private void updateTree(int[] tree, int[] nums, int start, int end, int treeIndx, int indx, int val) {
		if (start == end) {
			nums[indx] = val;
			tree[treeIndx] = val;
			return;
		}
		int mid = start + (end - start) / 2;
		if (mid >= indx)
			updateTree(tree, nums, start, mid, 2 * treeIndx, indx, val);
		else
			updateTree(tree, nums, mid + 1, end, 2 * treeIndx + 1, indx, val);
		tree[treeIndx] = tree[2 * treeIndx] + tree[2 * treeIndx + 1];
	}

	private void buildTree(int[] tree, int[] nums, int start, int end, int treeIndx) {
		if (start == end) {
			tree[treeIndx] = nums[start];
			return;
		}
		int mid = start + (end - start) / 2;
		buildTree(tree, nums, start, mid, 2 * treeIndx);
		buildTree(tree, nums, mid + 1, end, 2 * treeIndx + 1);
		tree[treeIndx] = tree[2 * treeIndx] + tree[2 * treeIndx + 1];
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
