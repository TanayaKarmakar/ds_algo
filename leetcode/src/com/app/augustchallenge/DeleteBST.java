package com.app.augustchallenge;

import java.util.LinkedList;
import java.util.Queue;

import com.app.augustchallenge.BinaryTree.TreeNode;

public class DeleteBST {
	private static TreeNode getSucc(TreeNode root) {
		TreeNode curr = root.right;
		while(curr != null && curr.left != null)
			curr = curr.left;
		return curr;
	}
	
	private static TreeNode deleteNode(TreeNode root, int target) {
		if(root == null)
			return null;
		else if(root.val > target)
			root.left =  deleteNode(root.left, target);
		else if(root.val < target)
			root.right = deleteNode(root.right, target);
		else {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else {
				TreeNode succ = getSucc(root);
				root.val = succ.val;
				root.right = deleteNode(root.right, succ.val);
			}
		}
		return root;
	}

	private static void levelOrderTraversal(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.print(node.val + " ");
			
			if(node.left != null)
				q.add(node.left);
			if(node.right != null)
				q.add(node.right);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(3);
		bt.root.right = new TreeNode(6);
		bt.root.left.left = new TreeNode(2);
		bt.root.left.right = new TreeNode(4);
		bt.root.right.right = new TreeNode(7);
		
		bt.root = deleteNode(bt.root, 3);
		
		levelOrderTraversal(bt.root);
	}

}
