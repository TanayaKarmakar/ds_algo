package com.app.questions.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.app.augustchallenge.BinaryTree;
import com.app.augustchallenge.BinaryTree.TreeNode;

class VNode {
	TreeNode node;
	int position;
	int level;

	public VNode(TreeNode node, int position, int level) {
		this.node = node;
		this.position = position;
		this.level = level;
	}
}

public class BinaryTreeVerticalOrderTraversalLeetcode314 {
	private static List<List<Integer>> verticalOrder(TreeNode root) {
		if(root == null)
			return new ArrayList<>();
		TreeMap<Integer, List<Integer>> tMap = new TreeMap<>();
		Queue<VNode> q = new LinkedList<>();
		q.add(new VNode(root, 0, 0));

		while (!q.isEmpty()) {
			VNode curr = q.poll();
			TreeNode currNode = curr.node;
			int pos = curr.position;
			int level = curr.level;

			if (!tMap.containsKey(pos)) {
				tMap.put(pos, new ArrayList<>());
			}
			tMap.get(pos).add(currNode.val);

			if (currNode.left != null)
				q.add(new VNode(currNode.left, pos - 1, level + 1));
			if (currNode.right != null)
				q.add(new VNode(currNode.right, pos + 1, level + 1));
		}

		return tMap.values().stream().collect(Collectors.toList());
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(8);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(0);
		bt.root.right.left = new TreeNode(1);
		bt.root.right.right = new TreeNode(7);

		
		List<List<Integer>> res = verticalOrder(bt.root);
		
		System.out.println(res);
	}

}
