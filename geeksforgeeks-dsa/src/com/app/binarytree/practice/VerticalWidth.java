package com.app.binarytree.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.app.binarytree.classroom.BinaryTree;
import com.app.binarytree.classroom.BinaryTree.Node;

public class VerticalWidth {
	static class Pair {
		Node root;
		int hd;
		
		public Pair(Node root, int hd) {
			this.root = root;
			this.hd = hd;
		}
	}
	private static int verticalWidth(Node root) {
		if(root == null)
			return 0;
		Queue<Pair> nodeQ = new LinkedList<>();
		nodeQ.add(new Pair(root, 0));
		int minHd = Integer.MAX_VALUE;
		int maxHd = Integer.MIN_VALUE;
		
		while(!nodeQ.isEmpty()) {
			Pair temp = nodeQ.poll();
			
			Node node = temp.root;
			int hd = temp.hd;
			
			minHd = Integer.min(minHd, hd);
			maxHd = Integer.max(maxHd, hd);
			
			if(node.left != null) {
				nodeQ.add(new Pair(node.left, hd - 1));
			}
			
			if(node.right != null) {
				nodeQ.add(new Pair(node.right, hd + 1));
			}
			
		}
		Set<Integer> numSet = new HashSet<>();
		for(int i = minHd; i <= maxHd; i++) {
			numSet.add(i);
		}
		
		return numSet.size();
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
		
		System.out.println(verticalWidth(bt.root));

	}

}
