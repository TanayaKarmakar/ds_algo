package com.app.binarytree.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class VerticalTraversalMapBasedSolution {
	private static void verticalTraversal(Node root, int hd, TreeMap<Integer, List<Node>> map) {
		if (root == null)
			return;
		if (!map.containsKey(hd)) {
			List<Node> nodeList = new ArrayList<>();
			nodeList.add(root);
			map.put(hd, nodeList);
		} else {
			map.get(hd).add(root);
		}
		verticalTraversal(root.left, hd - 1, map);
		verticalTraversal(root.right, hd + 1, map);

	}

	private static void displayVerticalOrder(Node root) {
		TreeMap<Integer, List<Node>> nodeMap = new TreeMap<>();
		verticalTraversal(root, 0, nodeMap);
		for (Map.Entry<Integer, List<Node>> entry : nodeMap.entrySet()) {
			List<Node> nodeList = entry.getValue();
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

		displayVerticalOrder(bt.root);

	}

}
