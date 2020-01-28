package com.app.binarytree.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

class Pair1 {
	public Node root;
	public int hd;

	public Pair1(Node root, int hd) {
		this.root = root;
		this.hd = hd;
	}
}

public class VerticalTraversalEfficient {
	private static void verticalTraversal(Node root) {
		if (root == null)
			return;

		Map<Integer, List<Node>> map = new HashMap<>();
		Queue<Pair1> nodeQ = new LinkedList<>();
		nodeQ.add(new Pair1(root, 0));
		int minHd = Integer.MAX_VALUE;
		int maxHd = Integer.MIN_VALUE;

		while (!nodeQ.isEmpty()) {
			Pair1 temp = nodeQ.poll();
			int hd = temp.hd;
			Node node = temp.root;

			if (!map.containsKey(hd)) {
				List<Node> nodes = new ArrayList<>();
				nodes.add(node);
				map.put(hd, nodes);
			} else {
				map.get(hd).add(node);
			}

			minHd = Integer.min(minHd, hd);
			maxHd = Integer.max(maxHd, hd);

			if (node.left != null) {
				nodeQ.add(new Pair1(node.left, hd - 1));
			}

			if (node.right != null) {
				nodeQ.add(new Pair1(node.right, hd + 1));
			}
		}

		for (int i = minHd; i <= maxHd; i++) {
			List<Node> nodeList = map.get(i);
			for (Node node : nodeList) {
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		bt.root.right.right.left = new Node(8);
		bt.root.right.right.right = new Node(9);

		verticalTraversal(bt.root);

	}

}
