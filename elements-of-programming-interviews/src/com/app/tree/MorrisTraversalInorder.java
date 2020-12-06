package com.app.tree;

import java.util.ArrayList;
import java.util.List;

import com.app.tree.BinaryTree.TreeNode;

public class MorrisTraversalInorder {
	private static List<Integer> inorderTraversal(TreeNode root) {
		TreeNode tourist = root;
		List<Integer> result = new ArrayList<>();

		while (tourist != null) {
			TreeNode guide = tourist.left;
			if (tourist.left != null) {
				while (guide.right != null && guide.right != tourist) {
					guide = guide.right;
				}
				if (guide.right == null) {
					guide.right = tourist;
					tourist = tourist.left;
				} else {
					guide.right = null;
					result.add(tourist.val);
					tourist = tourist.right;
				}
			} else {
				result.add(tourist.val);
				tourist = tourist.right;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(9);
		bt.root.left = new TreeNode(5);
		bt.root.right = new TreeNode(11);
		bt.root.left.left = new TreeNode(3);
		bt.root.left.right = new TreeNode(7);
		bt.root.left.left.right = new TreeNode(4);
		bt.root.left.right.left = new TreeNode(6);
		bt.root.right.left = new TreeNode(10);
		
		List<Integer> res = inorderTraversal(bt.root);
		
		System.out.println(res);

	}

}
