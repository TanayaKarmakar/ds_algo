package com.app.questions.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.app.questions.practice.BinaryTree.TreeNode;


public class BinaryTreeRightSideViewLeetcode199 {
	private static List<Integer> rightSideView(TreeNode root) {
		if(root == null)
			return new ArrayList<>();
		if(root.left == null && root.right == null) {
			List<Integer> res = new ArrayList<>();
			res.add(root.data);
			return res;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		List<Integer> res = new ArrayList<>();
		
		while(q.size() > 1) {
			TreeNode node = q.poll();
			if(node == null) {
				q.add(null);
				continue;
			}
			if(q.peek() == null) {
				res.add(node.data);
			}
			if(node.left != null) {
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.right = new TreeNode(5);
		bt.root.right.right = new TreeNode(4);
		
		List<Integer> res = rightSideView(bt.root);
		
		System.out.println(res);

	}

}
