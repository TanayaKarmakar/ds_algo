package com.app.questions.practice;

import com.app.questions.practice.BinaryTree.TreeNode;

class Pair {
	int first; //height
	int second; //diameter
}

public class DiameterLeetcode543 {
	private static Pair heightDiameter(TreeNode root) {
		if(root == null) {
			Pair pair = new Pair();
			pair.first = 0;
			pair.second = 0;
			return pair;
		}
		Pair left = heightDiameter(root.left);
		Pair right = heightDiameter(root.right);
		int height = 1 + Integer.max(left.first, right.first);
		int option1 = left.second;
		int option2 = right.second;
		int diameter = Integer.max(height, Integer.max(option1, option2));
		Pair finalResult = new Pair();
		finalResult.first = height;
		finalResult.second = diameter;
		return finalResult;
	}
	
	private static int diameter(TreeNode root) {
		Pair pair = heightDiameter(root);
		return pair.second;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);

		
		int n = diameter(bt.root);
		
		System.out.println("Diameter - " + n);
		
		bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		bt.root.left.left.left = new TreeNode(6);
		bt.root.left.right.right = new TreeNode(7);
		
		n = diameter(bt.root);
		
		System.out.println("Diameter - " + n);
	}

}
