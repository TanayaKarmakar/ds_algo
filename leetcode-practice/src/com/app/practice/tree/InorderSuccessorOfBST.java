package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class InorderSuccessorOfBST {
	private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		List<TreeNode> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			TreeNode node = stack.pop();
			res.add(node);
			root = node.right;
		}

		int start = 0;
		int end = res.size() - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (res.get(mid).val == p.val) {
				if (mid == res.size() - 1)
					return null;
				else
					return res.get(mid + 1);
			} else if (res.get(mid).val > p.val)
				end = mid - 1;
			else
				start = mid + 1;
		}

		return null;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(2);
		bt.root.left = new TreeNode(1);
		bt.root.right = new TreeNode(3);
		
		TreeNode ans = inorderSuccessor(bt.root, bt.root.left);
		
		System.out.println(ans);
		
		
	}

}
