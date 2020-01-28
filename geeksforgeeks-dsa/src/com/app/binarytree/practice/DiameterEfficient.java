package com.app.binarytree.practice;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

class Pair<T, V> {
	public T first;
	public T second;
}

public class DiameterEfficient {
	private static Pair<Integer, Integer> heightDiameter(Node root) {
		if(root == null) {
			Pair<Integer, Integer> output = new Pair<>();
			output.first = 0;
			output.second = 0;
			return output;
		}
		Pair<Integer, Integer> lo = heightDiameter(root.left);
		Pair<Integer, Integer> ro = heightDiameter(root.right);
		int height = 1 + Integer.max(lo.first, ro.first);
		int option1 = lo.first + ro.first;
		int option2 = lo.second;
		int option3 = ro.second;
		int diameter = Integer.max(option1, Integer.max(option2, option3));
		Pair<Integer, Integer> output = new Pair<>();
		output.first = height;
		output.second = diameter;
		return output;
	}
	
	private static int diameter(Node root) {
		Pair<Integer, Integer> output = heightDiameter(root);
		return output.second;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(6);
		bt.root.left.left.left = new Node(8);
		bt.root.left.left.left.left = new Node(10);
		bt.root.left.right.right = new Node(9);
		bt.root.left.right.right.right = new Node(11);
		bt.root.left.right.right.right.right = new Node(12);
		bt.root.right.right = new Node(5);
		
		System.out.println("Diameter - " + diameter(bt.root));

	}

}
