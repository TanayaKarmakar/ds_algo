package com.app.questions.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.app.questions.practice.BinaryTree.TreeNode;

public class DeleteNodesAndReturnForestLeetcode1110Practice {
	private static TreeNode removeNodes(TreeNode root, List<TreeNode> nodes, Set<Integer> toDelete) {
		if(root == null)
			return null;
		root.left = removeNodes(root.left, nodes, toDelete);
		root.right = removeNodes(root.right, nodes, toDelete);
		if(toDelete.contains(root.data)) {
			if(root.left != null)
				nodes.add(root.left);
			if(root.right != null)
				nodes.add(root.right);
			return null;
		}
		return root;
	}
	
	private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> toDelete = new HashSet<>();
		for(int el: to_delete) {
			toDelete.add(el);
		}
		List<TreeNode> nodes = new ArrayList<>();
		removeNodes(root, nodes, toDelete);
		if(!toDelete.contains(root.data)) {
			nodes.add(root);
		}
		return nodes;
	}
	
	private static void preorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		bt.root.right.left = new TreeNode(6);
		bt.root.right.right = new TreeNode(7);
		
		List<TreeNode> nodes = delNodes(bt.root, new int[] {3,5});
		
		for(TreeNode node: nodes) {
			preorder(node);
			System.out.println();
		}

	}

}
