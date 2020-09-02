package com.app.practice.segmenttree;

class NumArray {
	private int[] nums;
	private int n;
	private int[] tree;

	public NumArray(int[] nums) {
		this.nums = nums;
		this.n = nums.length;
		this.tree = new int[4 * n];
		buildTree(this.nums, tree, 1, 0, n - 1);
	}

	public void update(int i, int val) {
		updateTree(nums, tree, 1, 0, n - 1, i, val);
	}

	public int sumRange(int i, int j) {
		return rangeQuery(tree, 1, 0, n - 1, i, j);
	}

	private int rangeQuery(int[] tree, int treeIndx, int start, int end, int left, int right) {
		if (end < left || start > right)
			return 0;
		if (start >= left && end <= right)
			return tree[treeIndx];
		int mid = start + (end - start) / 2;
		int leftChild = rangeQuery(tree, 2 * treeIndx, start, mid, left, right);
		int rightChild = rangeQuery(tree, 2 * treeIndx + 1, mid + 1, end, left, right);
		return (leftChild + rightChild);
	}

	private void updateTree(int[] nums, int[] tree, int treeIndx, int start, int end, int indx, int val) {
		if (start == end) {
			nums[indx] = val;
			tree[treeIndx] = val;
			return;
		}
		int mid = start + (end - start) / 2;
		if (mid >= indx)
			updateTree(nums, tree, 2 * treeIndx, start, mid, indx, val);
		else
			updateTree(nums, tree, 2 * treeIndx + 1, mid + 1, end, indx, val);
		tree[treeIndx] = tree[2 * treeIndx] + tree[2 * treeIndx + 1];
	}

	private void buildTree(int[] nums, int[] tree, int treeIndx, int start, int end) {
		if (start == end) {
			tree[treeIndx] = nums[start];
			return;
		}

		int mid = start + (end - start) / 2;
		buildTree(nums, tree, 2 * treeIndx, start, mid);
		buildTree(nums, tree, 2 * treeIndx + 1, mid + 1, end);
		tree[treeIndx] = tree[2 * treeIndx] + tree[2 * treeIndx + 1];
	}
}

public class RangeSumQueryLeetcode307 {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5 };
		NumArray obj = new NumArray(nums);

		int ans = obj.sumRange(0, 2);
		
		System.out.println(ans);
		
		obj.update(1, 2);
		
		ans = obj.sumRange(0, 2);
		
		System.out.println(ans);
	}

}
