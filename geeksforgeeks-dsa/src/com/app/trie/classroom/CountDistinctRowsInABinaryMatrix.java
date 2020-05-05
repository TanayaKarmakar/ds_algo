package com.app.trie.classroom;

public class CountDistinctRowsInABinaryMatrix {
	private static boolean insert(TrieNode root, int[][] matrix, int row) {
		boolean flag = false;
		TrieNode curr = root;
		for (int i = 0; i < matrix[0].length; i++) {
			int indx = matrix[row][i];
			if (curr.child[indx] == null) {
				flag = true;
				curr.child[indx] = new TrieNode();
				curr.isEnd = false;
			}
			curr = curr.child[indx];
		}
		curr.isEnd = true;
		return flag;
	}

	private static int countDistinct(int[][] matrix) {
		int m = matrix.length;
		TrieNode root = new TrieNode();

		int count = 0;

		for (int i = 0; i < m; i++) {
			if (insert(root, matrix, i) == true)
				count++;
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 0, 0 }, { 1, 1, 1 }, { 1, 0, 0 }, { 0, 1, 0 } };
		int count = countDistinct(matrix);

		System.out.println("Count - " + count);

		matrix = new int[][] { { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 1, 1, 0, 0 } };
	
		count = countDistinct(matrix);
		System.out.println("Count - " + count);
	}

}
