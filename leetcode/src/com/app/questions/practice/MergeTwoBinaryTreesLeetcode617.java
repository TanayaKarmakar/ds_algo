package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

public class MergeTwoBinaryTreesLeetcode617 {
	private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null)
			return null;
		if(t1 == null || t2 == null) {
			if(t1 == null)
				return t2;
			if(t2 == null)
				return t1;
		}
		t1.data = t1.data + t2.data;
		t1.left = mergeTrees(t1.left, t2.left);
		t2.left = mergeTrees(t1.right, t2.right);
		return t1;
	}

	public static void main(String[] args) {
		

	}

}
