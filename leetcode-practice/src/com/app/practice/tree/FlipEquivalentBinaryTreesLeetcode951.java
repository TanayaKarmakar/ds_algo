package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class FlipEquivalentBinaryTreesLeetcode951 {
	private static boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		return root1.val == root2.val 
				&& ((flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) 
						|| (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)));
	}

	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		bt1.root = new TreeNode(1);
		bt1.root.left = new TreeNode(2);
		bt1.root.right = new TreeNode(3);
		bt1.root.left.left = new TreeNode(4);
		bt1.root.left.right = new TreeNode(5);
		bt1.root.right.left = new TreeNode(6);
		bt1.root.left.right.left = new TreeNode(7);
		bt1.root.left.right.right = new TreeNode(8);
		
		
		BinaryTree bt2 = new BinaryTree();
		bt2.root = new TreeNode(1);
		bt2.root.left = new TreeNode(3);
		bt2.root.right = new TreeNode(2);
		bt2.root.left.right = new TreeNode(6);
		bt2.root.right.left = new TreeNode(4);
		bt2.root.right.right = new TreeNode(5);
		bt2.root.right.right.left = new TreeNode(8);
		bt2.root.right.right.right = new TreeNode(7);
		
		boolean ans = flipEquiv(bt1.root, bt2.root);
		
		System.out.println(ans);

	}

}
