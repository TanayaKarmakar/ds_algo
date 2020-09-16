package com.app.questions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.app.questions.practice.BinaryTree.TreeNode;

public class InorderSuccessorOfBST {
	private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		List<TreeNode> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (root != null) {
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
			if (res.get(mid).data == p.data) {
				if (mid == res.size() - 1)
					return null;
				else
					return res.get(mid + 1);
			} else if (res.get(mid).data > p.data)
				end = mid - 1;
			else
				start = mid + 1;
		}

		return null;
	}

	public static void main(String[] args) {
	
		
		
	}

}
