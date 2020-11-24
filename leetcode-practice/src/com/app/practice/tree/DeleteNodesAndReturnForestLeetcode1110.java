package com.app.practice.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.app.practice.BinaryTree.TreeNode;

public class DeleteNodesAndReturnForestLeetcode1110 {
	private static TreeNode delNodesRec(TreeNode root, Set<Integer> set, List<TreeNode> res) {
		if(root == null)
			return null;
		root.left = delNodesRec(root.left, set, res);
		root.right = delNodesRec(root.right, set, res);
		
		if(set.contains(root.val)) {
			TreeNode left = root.left;
			TreeNode right = root.right;
			
			if(left != null) {
				res.add(left);
			}
			
			if(right != null) {
				res.add(right);
			}
			
			return null;
		}
		return root;
	}
	
	private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		if(root == null)
			return new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for(Integer el: to_delete) {
			set.add(el);
		}
		
		List<TreeNode> res = new ArrayList<>();
		delNodesRec(root, set, res);
		if(!set.contains(root.val)) {
			res.add(root);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
