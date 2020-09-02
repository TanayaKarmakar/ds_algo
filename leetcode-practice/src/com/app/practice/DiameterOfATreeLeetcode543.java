package com.app.practice;

import com.app.practice.BinaryTree.TreeNode;

class Pair {
	int first;
	int second;
}

public class DiameterOfATreeLeetcode543 {
	private static Pair diameterRec(TreeNode root) {
		if(root == null) {
			Pair pair = new Pair();
			pair.first = 0;
			pair.second = 0;
			return pair;
		}
		Pair l = diameterRec(root.left);
		Pair r = diameterRec(root.right);
		
		int height = 1 + Integer.max(l.first, r.first);
		int option1 = l.first + r.first;
		int option2 = l.second;
		int option3 = r.second;
		int diameter = Integer.max(option1, Integer.max(option2, option3));
		Pair pair = new Pair();
		pair.first = height;
		pair.second = diameter;
		return pair;
	}
	
	private static int diameter(TreeNode root) {
		Pair pair = diameterRec(root);
		return pair.second;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		
		int diameter = diameter(bt.root);
		
		System.out.println(diameter);

	}

}
