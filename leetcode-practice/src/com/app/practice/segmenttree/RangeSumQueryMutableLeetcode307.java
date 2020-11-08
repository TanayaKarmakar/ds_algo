package com.app.practice.segmenttree;

import java.util.Arrays;

class NumArray {
	int[] nums;
	int[] tree;
	int len;

	public NumArray(int[] nums) {
		len = nums.length;
		this.nums = nums;
		tree = new int[4 * len];
		buildTree(nums, tree, 1, 0, len - 1);
		
		System.out.println(Arrays.toString(tree));
	}

	public void update(int i, int val) {
		updateTree(nums, tree, 1, 0, len - 1, i, val);
	}

	public int sumRange(int i, int j) {
		return rangeQuery(tree, 1, 0, len - 1, i, j);
	}

	private int rangeQuery(int[] tree, int treeIndx, int start, int end, int left, int right) {
		if (start > end)
			return 0;
		if (end < left || start > right)
			return 0;
		if (start >= left && end <= right)
			return tree[treeIndx];
		int mid = (start + end) >> 1;
		int leftChild = rangeQuery(tree, 2 * treeIndx, start, mid, left, right);
		int rightChild = rangeQuery(tree, 2 * treeIndx + 1, mid + 1, end, left, right);
		return leftChild + rightChild;
	}

	private void updateTree(int[] nums, int[] tree, int treeIndx, int start, int end, int indx, int val) {
		if (start == end) {
			tree[treeIndx] = val;
			nums[indx] = val;
			return;
		}

		int mid = (start + end) >> 1;
		if (mid >= indx)
			updateTree(nums, tree, 2 * treeIndx, start, mid, indx, val);
		else
			updateTree(nums, tree, 2 * treeIndx + 1, mid + 1, end, indx, val);
		tree[treeIndx] = tree[2 * treeIndx] + tree[2 * treeIndx + 1];
	}

	private void buildTree(int[] nums, int[] tree, int treeIndx, int start, int end) {
		if(start > end)
			return;
		if (start == end) {
			tree[treeIndx] = nums[start];
			return;
		}

		int mid = (start + end) >> 1;
		buildTree(nums, tree, 2 * treeIndx, start, mid);
		buildTree(nums, tree, 2 * treeIndx + 1, mid + 1, end);
		tree[treeIndx] = tree[2 * treeIndx] + tree[2 * treeIndx + 1];
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
