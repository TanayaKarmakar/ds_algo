package com.app.questions.tree;

import com.app.questions.tree.BinaryTree.Node;

public class SubtreeOfAnotherTree {
	private static boolean isIdentical(Node root, Node target) {
		if(root == null && target == null)
			return true;
		if(root == null || target == null)
			return false;
		return (root.data == target.data) && isIdentical(root.left, target.left)
				&& isIdentical(root.right, target.right);
	}
	
	private static boolean isSubtree(Node root, Node target) {
		if(root == null) 
			return false;
		boolean rootLevel = isIdentical(root, target);
		boolean leftSubtreeLevel = isSubtree(root.left, target);
		boolean rightSubtreeLevel = isSubtree(root.right, target);
		return rootLevel || leftSubtreeLevel || rightSubtreeLevel;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(4);
		bt.root.right = new Node(5);
		bt.root.left.left = new Node(1);
		bt.root.left.right = new Node(2);
		bt.root.left.right.left = new Node(0);
		
		BinaryTree bt1 = new BinaryTree();
		bt1.root = new Node(4);
		bt1.root.left = new Node(1);
		bt1.root.right = new Node(2);
		
		System.out.println(isSubtree(bt.root, bt1.root));
		
		bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(1);
		
		bt1 = new BinaryTree();
		bt1.root = new Node(1);
		
		System.out.println(isSubtree(bt.root, bt1.root));

	}

}
