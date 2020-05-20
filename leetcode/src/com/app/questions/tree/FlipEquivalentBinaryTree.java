package com.app.questions.tree;

import com.app.questions.tree.BinaryTree.Node;

public class FlipEquivalentBinaryTree {
	private static boolean flipEquiv(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if(root1.data != root2.data)
			return false;
		
	    return ((flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)))
				|| ((flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)));

	}

	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		bt1.root = new Node(1);
		bt1.root.left = new Node(2);
		bt1.root.right = new Node(3);
		bt1.root.left.left = new Node(4);
		bt1.root.left.right = new Node(5);
		bt1.root.left.right.left = new Node(7);
		bt1.root.left.right.right = new Node(8);
		bt1.root.right.left = new Node(6);
		
		BinaryTree bt2 = new BinaryTree();
		bt2.root = new Node(1);
		bt2.root.left = new Node(3);
		bt2.root.right = new Node(2);
		bt2.root.left.right = new Node(6);
		bt2.root.right.left = new Node(4);
		bt2.root.right.right = new Node(5);
		bt2.root.right.right.left = new Node(8);
		bt2.root.right.right.right = new Node(7);
		
		System.out.println(flipEquiv(bt1.root, bt2.root));

	}

}
