package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

class VerticalNode implements Comparable<VerticalNode> {
	TreeNode node;
	int x;
	int level;

	public VerticalNode(TreeNode node, int x, int level) {
		this.node = node;
		this.x = x;
		this.level = level;
	}

	@Override
	public int compareTo(VerticalNode o) {
		if (this.level == o.level)
			return this.node.val - o.node.val;
		return this.level - o.level;
	}
}

public class VerticalOrderTraversalLeetcode987 {
	private static List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Map<Integer, List<Integer>> map = new TreeMap<>();
		PriorityQueue<VerticalNode> pQ = new PriorityQueue<>();

		pQ.add(new VerticalNode(root, 0, 0));
		int level = 0;
		while (!pQ.isEmpty()) {
			int size = pQ.size();
			for (int i = 0; i < size; i++) {
				VerticalNode vNode = pQ.poll();
				if (!map.containsKey(vNode.x)) {
					map.put(vNode.x, new ArrayList<>());
				}
				map.get(vNode.x).add(vNode.node.val);

				if (vNode.node.left != null) {
					pQ.add(new VerticalNode(vNode.node.left, vNode.x - 1, level + 1));
				}

				if (vNode.node.right != null) {
					pQ.add(new VerticalNode(vNode.node.right, vNode.x + 1, level + 1));
				}
			}
			level++;
		}

		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> values = entry.getValue();
			list.add(values);
		}

		return list;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);

		List<List<Integer>> list = verticalTraversal(bt.root);

		System.out.println(list);

	}

}
