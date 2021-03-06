package com.app.practice.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class AllNodesAtDistanceKInBinaryTreeLeetcode863 {
	private static void populateParentChildMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentChildMap) {
		if (root == null)
			return;
		parentChildMap.put(root, parent);
		populateParentChildMap(root.left, root, parentChildMap);
		populateParentChildMap(root.right, root, parentChildMap);
	}

	private static List<Integer> extractNodes(Queue<TreeNode> q) {
		List<Integer> res = new ArrayList<>();

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if(node != null)
				res.add(node.val);
		}

		return res;
	}

	private static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		if (root == null)
			return new ArrayList<>();

		Map<TreeNode, TreeNode> parentChildMap = new HashMap<>();
		populateParentChildMap(root, null, parentChildMap);

		Queue<TreeNode> q = new LinkedList<>();
		Set<TreeNode> visited = new HashSet<>();

		q.add(target);
		visited.add(target);

		int level = 0;

		while (!q.isEmpty()) {
			if (level == K)
				return extractNodes(q);
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null && !visited.contains(node.left)) {
					q.add(node.left);
					visited.add(node.left);
				}

				if (node.right != null && !visited.contains(node.right)) {
					q.add(node.right);
					visited.add(node.right);
				}

				TreeNode parentNode = parentChildMap.get(node);
				if(parentNode != null && !visited.contains(parentNode)) {
					q.add(parentNode);
					visited.add(parentNode);
				}
			}
			level++;
		}

		return new ArrayList<>();
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(5);
		bt.root.right = new TreeNode(1);
		bt.root.left.left = new TreeNode(6);
		bt.root.left.right = new TreeNode(2);
		bt.root.left.right.left = new TreeNode(7);
		bt.root.left.right.right = new TreeNode(4);
		bt.root.right.left = new TreeNode(0);
		bt.root.right.right = new TreeNode(8);
		
		TreeNode target = bt.root.left;
		
		List<Integer> res = distanceK(bt.root, target, 2);
		
		System.out.println(res);

	}

}
