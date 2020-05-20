package com.app.trie.problems;

class TrieNode {
	TrieNode left;
	TrieNode right;
}

public class MaximumXORPair {
	private static void insert(TrieNode head, int n) {
		TrieNode curr = head;
		for (int i = 31; i >= 0; i--) {
			int b = (n >> i) & 1;
			if (b == 0) {
				if (curr.left == null) {
					curr.left = new TrieNode();
				}
				curr = curr.left;
			} else {
				if (curr.right == null) {
					curr.right = new TrieNode();
				}
				curr = curr.right;
			}
		}
	}

	private static int getMaxXORPair(TrieNode head, int[] arr) {
		int n = arr.length;
		TrieNode curr;

		int maxXor = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			curr = head;
			int val = arr[i];
			int currentXor = 0;
			for (int j = 31; j >= 0; j--) {
				int b = (val >> j) & 1;
				if (b == 0) {
					if (curr.right != null) {
						curr = curr.right;
						currentXor += (int) Math.pow(2, j);
					} else {
						curr = curr.left;
					}
				} else {
					if (curr.left != null) {
						curr = curr.left;
						currentXor += (int) Math.pow(2, j);
					} else {
						curr = curr.right;
					}
				}
			}
			maxXor = Integer.max(maxXor, currentXor);
		}
		return maxXor;
	}

	public static void main(String[] args) {
		int[] arr = { 8, 1, 10, 15, 5 };
		TrieNode head = new TrieNode();

		for (int i = 0; i < arr.length; i++) {
			insert(head, arr[i]);
		}

		int maxXor = getMaxXORPair(head, arr);
		System.out.println(maxXor);
	}

}
