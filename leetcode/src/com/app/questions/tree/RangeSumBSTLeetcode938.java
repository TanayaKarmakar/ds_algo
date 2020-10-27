package com.app.questions.tree;

import com.app.augustchallenge.BinaryTree.TreeNode;
import com.app.augustchallenge.BinaryTree;

public class RangeSumBSTLeetcode938 {
	private static int sum = 0;

	private static void rangeSumBSTRec(TreeNode root, int L, int R) {
		if (root == null)
			return;
		if (root.val >= L && root.val <= R)
			sum += root.val;
		//else if (root.val > R)
		rangeSumBSTRec(root.left, L, R);
		//else
		rangeSumBSTRec(root.right, L, R);
	}

	public static int rangeSumBST(TreeNode root, int L, int R) {
		sum = 0;
		rangeSumBSTRec(root, L, R);
		return sum;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(10);
		bt.root.left = new TreeNode(5);
		bt.root.right = new TreeNode(15);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(7);
		bt.root.right.right = new TreeNode(18);

		int ans = rangeSumBST(bt.root, 7, 15);
		System.out.println(ans);

	}

}
