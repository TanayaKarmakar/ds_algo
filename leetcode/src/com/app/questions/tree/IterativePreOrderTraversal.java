package com.app.questions.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.app.questions.tree.BinaryTree.Node;

public class IterativePreOrderTraversal {
	private static List<Integer> preorderTraversal(Node root) {
		if (root == null)
			return new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();

		stack.push(root);
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			res.add(node.data);

			if (node.right != null) {
				stack.push(node.right);
			}

			if (node.left != null) {
				stack.push(node.left);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);

		List<Integer> res = preorderTraversal(bt.root);

		for (Integer el : res) {
			System.out.print(el + " ");
		}
		System.out.println();
	}

}
