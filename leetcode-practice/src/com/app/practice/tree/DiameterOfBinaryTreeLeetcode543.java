package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

class Pair {
	int first;
	int second;
}

public class DiameterOfBinaryTreeLeetcode543 {
	private static Pair heightDiameter(TreeNode root) {
		if(root == null) {
			Pair pair = new Pair();
			pair.first = 0;
			pair.second = 0;
			return pair;
		}
		
		Pair ld = heightDiameter(root.left);
		Pair rd = heightDiameter(root.right);
		
		int height = 1 + Integer.max(ld.first, rd.first);
		int option1 = ld.second;
		int option2 = rd.second;
		int diameter = Integer.max(height, Integer.max(option1, option2));
		
		Pair newPair = new Pair();
		newPair.first = height;
		newPair.second = diameter;
		return newPair;
	}
	
	private static int diameterOfBinaryTree(TreeNode root) {
		Pair heightDia = heightDiameter(root);
		return heightDia.second;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		
		int diameter = diameterOfBinaryTree(bt.root);
		
		System.out.println(diameter);

	}

}
