package com.app.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class BinaryTreeRightSideViewLeetcode199 {
	private static List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightSideViewList = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		
		
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr == null) {
				if(q.peek() != null)
					q.add(null);
				continue;
			}
			
			if(q.peek() == null) {
				rightSideViewList.add(curr.val);
			}
			
			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
		return rightSideViewList;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.right = new TreeNode(5);
		bt.root.right.right = new TreeNode(4);
		
		List<Integer> rightSideViewList = rightSideView(bt.root);
		
		System.out.println(rightSideViewList);

	}

}
