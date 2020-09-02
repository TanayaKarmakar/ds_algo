package com.app.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class LevelOrderTraversalIILeetcode107 {
	private static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> item = new ArrayList<>();
		if(root == null)
			return res;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			
			if(node == null) {
				res.add(0, item);
				item = new ArrayList<>();
				
				if(q.peek() != null)
					q.add(null);
				continue;
			}
			
			item.add(node.val);
			
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
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);
		
		List<List<Integer>> res = levelOrderBottom(bt.root);
		
		System.out.println(res);

	}

}
