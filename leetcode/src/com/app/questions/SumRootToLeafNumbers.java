package com.app.questions;

import com.app.questions.BinaryTree.Node;

public class SumRootToLeafNumbers {
	private static int sumRootRec(Node root, int num) {
		if(root == null)
			return 0;
		num = num * 10 + root.data;
		
		if(root.left == null && root.right == null)
			return num;
		
		int n1 = sumRootRec(root.left, num);
		int n2 = sumRootRec(root.right, num);
		
		return n1 + n2;
		
	}
	
	private static int sumRootToLeaf(Node root) {
		return sumRootRec(root, 0);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(4);
		bt.root.left = new Node(9);
		bt.root.right = new Node(0);
		bt.root.left.left = new Node(5);
		bt.root.left.right = new Node(1);
		
		System.out.println(sumRootToLeaf(bt.root));
	}

}
