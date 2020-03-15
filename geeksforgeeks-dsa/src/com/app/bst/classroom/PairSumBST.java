package com.app.bst.classroom;

import java.util.HashSet;
import java.util.Set;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class PairSumBST {
	private static boolean isPairSum(Node root, int sum, Set<Integer> s) {
		if (root == null)
			return false;
		if (isPairSum(root.left, sum, s) == true)
			return true;
		if (s.contains(sum - root.data))
			return true;
		else
			s.add(root.data);
		return isPairSum(root.right, sum, s);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(8);
		bt.root.right = new Node(20);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(9);
		bt.root.right.left = new Node(11);
		bt.root.right.right = new Node(30);
		bt.root.right.right.left = new Node(25);
		
		Set<Integer> set = new HashSet<>();
		
		System.out.println(isPairSum(bt.root, 33, set));

		System.out.println(isPairSum(bt.root, 100, set));
	}

}
