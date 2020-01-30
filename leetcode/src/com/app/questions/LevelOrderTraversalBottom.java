package com.app.questions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.app.questions.BinaryTree.Node;

public class LevelOrderTraversalBottom {
	private static List<List<Integer>> levelOrderTraversalBottom(Node root) {
		if(root == null)
			return new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		Queue<Node> nodeQ = new LinkedList<>();

		nodeQ.add(root);
		nodeQ.add(null);
		List<Integer> nodes = new ArrayList<>();
		nodes.add(root.data);
		res.add(0, nodes);

		while (nodeQ.size() > 1) {
			Node node = nodeQ.poll();
			if (node == null) {
				nodes = new ArrayList<>();
				Iterator<Node> qItr = nodeQ.iterator();
				while (qItr.hasNext()) {
					nodes.add(qItr.next().data);
				}
				res.add(0, nodes);
				nodeQ.add(null);
				continue;
			}

			if (node.left != null) {
				nodeQ.add(node.left);
			}

			if (node.right != null) {
				nodeQ.add(node.right);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(9);
		bt.root.right = new Node(20);
		bt.root.right.left = new Node(15);
		bt.root.right.right = new Node(7);

		List<List<Integer>> res = levelOrderTraversalBottom(bt.root);

		System.out.println(res);

	}

}
