package com.app.segmenttree.problems;

import java.util.Scanner;

class Node {
	int maximum;
	int sMaximum;
	
	public String toString() {
		return maximum + " : " + sMaximum;
	}
}

public class SegmentTreeMaxPairSum {
	private static Node query(Node[] tree, int start, int end, int treeIndx, int left, int right) {
		if(end < left || start > right) {
			Node invalidNode = new Node();
			invalidNode.maximum = Integer.MIN_VALUE;
			invalidNode.sMaximum = Integer.MIN_VALUE;
			return invalidNode;
		}
		if(start >= left && end <= right)
			return tree[treeIndx];
		int mid = start + (end - start)/2;
		Node ans1 = query(tree, start, mid, 2 * treeIndx, left, right);
		Node ans2 = query(tree, mid + 1, end, 2 * treeIndx + 1, left, right);
		Node finalNode = new Node();
		finalNode.maximum = Integer.max(ans1.maximum, ans2.maximum);
		finalNode.sMaximum = Integer.min(Integer.max(ans1.maximum, ans2.sMaximum),
				Integer.max(ans1.sMaximum, ans2.maximum));
		return finalNode;
	}
	
	private static void updateTree(int[] nums, Node[] tree, int start, int end, int treeIndx, int indx, int value) {
		if(start == end) {
			nums[indx] = value;
			tree[indx].maximum = value;
			return;
		}
		int mid = start + (end - start)/2;
		if(mid >= indx) {
			updateTree(nums, tree, start, mid, 2 * treeIndx, indx, value);
		} else {
			updateTree(nums, tree, mid + 1, end, 2 * treeIndx + 1, indx, value);
		}
		Node left = tree[2 * treeIndx];
		Node right = tree[2 * treeIndx + 1];
		
		tree[treeIndx].maximum = Integer.max(left.maximum, right.maximum);
		tree[treeIndx].sMaximum = Integer.min(Integer.max(left.maximum, right.sMaximum), 
				Integer.max(left.sMaximum, right.maximum));
		
		return;
	}
	
	private static void buildTree(int[] nums, Node[] tree, int start, int end, int treeIndx) {
		if (start == end) {
			Node newNode = new Node();
			newNode.maximum = nums[start];
			newNode.sMaximum = Integer.MIN_VALUE;
			tree[treeIndx] = newNode;
			return;
		}
		int mid = start + (end - start) / 2;
		buildTree(nums, tree, start, mid, 2 * treeIndx);
		buildTree(nums, tree, mid + 1, end, 2 * treeIndx + 1);
		Node left = tree[2 * treeIndx];
		Node right = tree[2 * treeIndx + 1];
		
		
		Node newNode = new Node();
		newNode.maximum = Integer.max(left.maximum, right.maximum);
		newNode.sMaximum = Integer.min(Integer.max(left.maximum, right.sMaximum), 
				Integer.max(left.sMaximum, right.maximum));
		tree[treeIndx] = newNode;
		
		return;
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = scanner.nextInt();
		int[] nums = new int[nDim];

		for (int i = 0; i < nDim; i++) {
			nums[i] = scanner.nextInt();
		}

		Node[] tree = new Node[3 * nDim];
		
		buildTree(nums, tree, 0, nDim - 1, 1);

		int nQueries = scanner.nextInt();
		while (nQueries > 0) {
			String queryType = scanner.next();
			int first = scanner.nextInt();
			int second = scanner.nextInt();

			if (queryType.equals("Q")) {
				Node ans = query(tree, 0, nDim - 1, 1, first - 1, second - 1);
				System.out.println(ans.maximum + ans.sMaximum);
			} else {
				updateTree(nums, tree, 0, nDim - 1, 1, first - 1, second);
			}
			nQueries--;
		}

		scanner.close();
	}

}
