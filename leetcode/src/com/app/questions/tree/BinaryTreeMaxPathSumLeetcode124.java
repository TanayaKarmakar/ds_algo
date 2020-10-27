package com.app.questions.tree;

import com.app.augustchallenge.BinaryTree.TreeNode;
import com.app.augustchallenge.BinaryTree;

public class BinaryTreeMaxPathSumLeetcode124 {
	private static int answer = Integer.MIN_VALUE;
	
	private static int maxPathSumRec(TreeNode root) {
		if(root == null)
			return 0;
		int lPath = maxPathSumRec(root.left);
		int rPath = maxPathSumRec(root.right);
		
		answer = Integer.max(answer, lPath + rPath + root.val);
		return Integer.max(0, root.val + Integer.max(lPath, rPath));
	}
	
	private static int maxPathSum(TreeNode root) {
		if(root == null)
			return 0;
		maxPathSumRec(root);
		return answer;	
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(-10);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);
		
		int ans = maxPathSum(bt.root);
		
		System.out.println(ans);

	}

}
