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

public class AllNodesAtKDistanceLeetcode863 {
	private static void populateNodeParentMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> map) {
		if(root == null)
			return;
		map.put(root, parent);
		populateNodeParentMap(root.left, root, map);
		populateNodeParentMap(root.right, root, map);
	}
	
	private static List<Integer> extractNodes(Queue<TreeNode> q) {
		List<Integer> res = new ArrayList<>();
		for(TreeNode node: q)
			res.add(node.val);
		
		return res;
	}
	
	private static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		if(K == 0) {
			List<Integer> res = new ArrayList<>();
			res.add(target.val);
			return res;
		}
		Map<TreeNode, TreeNode> nodeParentMap = new HashMap<>();
		populateNodeParentMap(root, null, nodeParentMap);
		
		Set<TreeNode> visited = new HashSet<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(target);
		visited.add(target);
		
		int level = 0;
		while(!q.isEmpty()) {
			if(level == K)
				return extractNodes(q);
			
			int size = q.size();
			for(int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				
				if(node.left != null && !visited.contains(node.left)) {
					visited.add(node.left);
					q.add(node.left);
				}
				
				if(node.right != null && !visited.contains(node.right)) {
					visited.add(node.right);
					q.add(node.right);
				}
				
				TreeNode parentNode = nodeParentMap.get(node);
				if(parentNode != null && !visited.contains(parentNode)) {
					visited.add(parentNode);
					q.add(parentNode);
				}
			}
			level++;
		}
		
		return new ArrayList<>();
	}

	public static void main(String[] args) {
		BinaryTree bt2 = new BinaryTree();
		bt2.root = new TreeNode(3);
		bt2.root.left = new TreeNode(5);
		bt2.root.right = new TreeNode(1);
		bt2.root.left.left = new TreeNode(6);
		bt2.root.left.right = new TreeNode(2);
		bt2.root.left.right.left = new TreeNode(7);
		bt2.root.left.right.right = new TreeNode(4);
		bt2.root.right.left = new TreeNode(0);
		bt2.root.right.right = new TreeNode(8);
		
		List<Integer> nodes = distanceK(bt2.root, bt2.root.left, 2);
		
		System.out.println(nodes);

	}
}
