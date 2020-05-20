package com.app.questions.tree;

import com.app.questions.tree.BinaryTree.Node;

public class ClosestBinarySearchTreeValueLeetcode270 {
	private static int closestValue(Node root, double target) {
		if(root == null)
			return 0;
		Node tmp = null;
		double diff = Double.MAX_VALUE;
		while(root != null) {
			double currentDiff = Math.abs(target - root.data);
			if(currentDiff < diff) {
				diff = currentDiff;
				tmp = root;
			}
			if((double)root.data > target) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		
		return tmp.data;
		
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(4);
		bt.root.left = new Node(2);
		bt.root.right = new Node(5);
		bt.root.left.left = new Node(1);
		bt.root.left.right = new Node(3);
		
		double target = 3.714286;
		
		System.out.println("Closest Value - " + closestValue(bt.root, target));

	}

}
