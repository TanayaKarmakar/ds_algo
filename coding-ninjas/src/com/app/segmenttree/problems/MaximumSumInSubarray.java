package com.app.segmenttree.problems;

import java.util.Scanner;

class ValueNode {
	int totalSum;
	int maxPrefixSum;
	int maxSuffixSum;
	int maxSubarraySum;
}

public class MaximumSumInSubarray {
	private static ValueNode merge(ValueNode left, ValueNode right) {
		ValueNode finalNode = new ValueNode();
		finalNode.totalSum = left.totalSum + right.totalSum;
		finalNode.maxPrefixSum = Integer.max(left.maxPrefixSum, left.totalSum + right.maxPrefixSum);
		finalNode.maxSuffixSum = Integer.max(right.maxSuffixSum, left.maxSuffixSum + right.totalSum);
		finalNode.maxSubarraySum = Integer.max(left.maxSubarraySum, 
				Integer.max(left.maxSuffixSum + right.maxPrefixSum, right.maxSubarraySum));
		return finalNode;
	}

	private static void buildTree(int[] nums, ValueNode[] tree, int start, int end, int treeIndx) {
		if (start == end) {
			ValueNode vNode = new ValueNode();
			vNode.totalSum = nums[start];
			vNode.maxPrefixSum = nums[start];
			vNode.maxSuffixSum = nums[start];
			vNode.maxSubarraySum = nums[start];
			tree[treeIndx] = vNode;
			return;
		}
		int mid = start + (end - start) / 2;
		buildTree(nums, tree, start, mid, 2 * treeIndx);
		buildTree(nums, tree, mid + 1, end, 2 * treeIndx + 1);
		tree[treeIndx] = merge(tree[2 * treeIndx], tree[2 * treeIndx + 1]);
	}
	
	private static ValueNode query(ValueNode[] tree, int start, int end, int left, int right, int treeIndx) {
		if(end < left || start > right) {
			ValueNode vNode = new ValueNode();
			vNode.maxPrefixSum = -16000;
			vNode.maxSuffixSum = -16000;
			vNode.totalSum = -16000;
			vNode.maxSubarraySum = -16000;
			return vNode;
		}
		if(start >= left && end <= right) {
			return tree[treeIndx];
		}
		int mid = start + (end - start)/2;
		ValueNode leftChild = query(tree, start, mid, left, right, 2 * treeIndx);
		ValueNode rightChild = query(tree, mid + 1, end, left, right, 2 * treeIndx + 1);
		return merge(leftChild, rightChild);
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = scanner.nextInt();
		int[] nums = new int[nDim];

		for (int i = 0; i < nDim; i++) {
			nums[i] = scanner.nextInt();
		}

		ValueNode[] tree = new ValueNode[4 * nDim];
		buildTree(nums, tree, 0, nDim - 1, 1);
		
		int nQuery = scanner.nextInt();
		while(nQuery > 0) {
			int left = scanner.nextInt();
			int right = scanner.nextInt();
			ValueNode ans = query(tree, 0, nDim - 1, left - 1, right - 1,  1);
			System.out.println(ans.maxSubarraySum);
			nQuery--;
		}

		scanner.close();
	}

}
