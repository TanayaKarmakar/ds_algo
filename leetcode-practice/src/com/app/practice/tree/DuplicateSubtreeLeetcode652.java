package com.app.practice.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class DuplicateSubtreeLeetcode652 {
	private static Map<Integer, Integer> map;
	
	private static StringBuilder findDups(TreeNode root, List<TreeNode> res) {
		if(root == null)
			return new StringBuilder();
		
		StringBuilder sb = findDups(root.left, res).append(".")
				.append(findDups(root.right, res)).append(".")
				.append(root.val);
		
		int hashCode = sb.toString().hashCode();
		int count = map.getOrDefault(hashCode, 0);
		if(count == 2)
			res.add(root);
		
		map.put(hashCode, map.getOrDefault(hashCode, 1) + 1);
		return sb;
	}
	
	private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		map = new HashMap<>();
		
		List<TreeNode> res = new ArrayList<>();
		findDups(root, res);
		
		return res;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.right.left = new TreeNode(2);
		bt.root.right.right = new TreeNode(4);
		bt.root.right.left.left = new TreeNode(4);
		
		List<TreeNode> res = findDuplicateSubtrees(bt.root);
		
		

	}

}
