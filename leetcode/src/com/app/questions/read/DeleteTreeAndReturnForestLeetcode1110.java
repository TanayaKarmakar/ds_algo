package com.app.questions.read;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.app.questions.practice.BinaryTree;
import com.app.questions.practice.BinaryTree.TreeNode;

public class DeleteTreeAndReturnForestLeetcode1110 {
	private static TreeNode removeNodes(TreeNode root, Set<Integer> toDelete, List<TreeNode> nodes) {
		if(root == null)
			return null;
		root.left = removeNodes(root.left, toDelete, nodes);
		root.right = removeNodes(root.right, toDelete, nodes);
		if(toDelete.contains(root.data)) {
			if(root.left != null) {
				nodes.add(root.left);
			}
			
			if(root.right != null) {
				nodes.add(root.right);
			}
			
			return null;
		}
		return root;
	}
	
	private static List<TreeNode> delete(TreeNode root, int[] to_delete) {
		List<TreeNode> nodes = new ArrayList<>();
		Set<Integer> toDelete = new HashSet<>();
		for(int i: to_delete) {
			toDelete.add(i);
		}
		removeNodes(root, toDelete, nodes);
		if(!toDelete.contains(root.data)) {
			nodes.add(root);
		}
		return nodes;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(3);
//		bt.root = new TreeNode(1);
//		bt.root.left = new TreeNode(2);
//		bt.root.right = new TreeNode(3);
//		bt.root.left.left = new TreeNode(4);
//		bt.root.left.right = new TreeNode(5);
//		bt.root.right.left = new TreeNode(6);
//		bt.root.right.right = new TreeNode(7);

		List<TreeNode> nodes = delete(bt.root, new int[] { 2, 3 });
		System.out.println(nodes);
		
	}

}
