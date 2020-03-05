package com.app.questions;

import java.util.ArrayList;
import java.util.List;

import com.app.questions.BinaryTree.Node;

public class KThSmallestElement {
	private static int i = 0;
	
	
	private static void kthSmallestRec(Node root, List<Integer> res) {
		if(root != null) {
			kthSmallestRec(root.left, res);
			res.add(root.data);
			kthSmallestRec(root.right, res);
		}
	}
	
	private static int kThSmallest(Node root, int k) {
		List<Integer> res = new ArrayList<>();
		kthSmallestRec(root, res);
		return res.get(k - 1);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
		bt.root.left = new Node(1);
		bt.root.right = new Node(4);
		bt.root.left.right = new Node(2);
		
		System.out.println("KthSmallest - " + kThSmallest(bt.root, 1));

		bt = new BinaryTree();
		bt.root = new Node(5);
		bt.root.left = new Node(3);
		bt.root.right = new Node(6);
		bt.root.left.left = new Node(2);
		bt.root.left.right = new Node(4);
		bt.root.left.left.left = new Node(1);
		
		System.out.println("KthSmallest - " + kThSmallest(bt.root, 3));
	}

}
