package com.app.questions;

import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}

	@Override
	public int compareTo(Node o) {
		return this.data - o.data;
	}
}

public class MinimumCostTreeFromLeafValues {
	private static boolean isLeaf(Node root) {
		return root.left == null && root.right == null;
	}

	private static int findLargest(Node root, int largest) {
		if (isLeaf(root)) {
			return Integer.max(largest, root.data);
		}
		int lLargest = findLargest(root.left, largest);
		int rLargest = findLargest(root.right, largest);
		return Integer.max(lLargest, rLargest);
	}
	
	private static int mctFromLeafValues(int[] nums) {
		PriorityQueue<Node> pQ = new PriorityQueue<Node>();

		int n = nums.length;

		for (int i = 0; i < n; i++) {
			pQ.add(new Node(nums[i]));
		}

		int sum = 0;
		while (pQ.size() > 1) {
			Node x = pQ.poll(); // left
			Node y = pQ.poll(); // right

			int leftNumber = 0;
			int rightNumber = 0;
			if (isLeaf(x)) {
				leftNumber = x.data;
			} else {
				// find largest leaf from left subtree
				leftNumber = findLargest(x, Integer.MIN_VALUE);
			}

			if (isLeaf(y)) {
				rightNumber = y.data;
			} else {
				// find largest leaf from right subtree
				rightNumber = findLargest(y, Integer.MIN_VALUE);
			}

			int rootNodeData = leftNumber * rightNumber;
			Node root = new Node(rootNodeData);
			root.left = x;
			root.right = y;
			pQ.add(root);
			
			
			sum += rootNodeData;
		}

		System.out.println(pQ.peek().data);
		return sum;
	}

	public static void main(String[] args) {
		int[] nums = { 6, 2, 4 };

		int ans = mctFromLeafValues(nums);
		
		System.out.println(ans);

	}

}
