package com.app.questions;

import com.app.questions.BinaryTree.Node;

class Pair {
	public Integer first; // height
	public Integer second; // diameter
}

public class DiameterLeetcode543 {
	private static Pair heightDiameter(Node root) {
		if (root == null) {
			Pair output = new Pair();
			output.first = 0;
			output.second = 0;
			return output;
		}
		Pair lo = heightDiameter(root.left);
		Pair ro = heightDiameter(root.right);
		int height = 1 + Integer.max(lo.first, ro.first);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int diameter = Integer.max(option1, Integer.max(option2, option3));
		Pair output = new Pair();
		output.first = height;
		output.second = diameter;
		return output;
	}

	private static int diameter(Node root) {
		Pair pair = heightDiameter(root);
		return pair.second;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		bt.root.left.right.left = new Node(8);
		bt.root.left.right.right = new Node(9);
		bt.root.left.right.right.left = new Node(10);
		bt.root.left.right.right.right = new Node(11);
		bt.root.right.left = new Node(6);
		bt.root.right.right = new Node(7);
		
		int dia = diameter(bt.root);
		System.out.println(dia);
	}

}
