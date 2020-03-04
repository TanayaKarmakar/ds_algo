package com.app.questions;

import java.util.ArrayList;
import java.util.List;

import com.app.questions.BinaryTree.Node;

//TBD
public class BSTIterator {
	private List<Integer> nodeList;
	
	public BSTIterator(Node root) {
		nodeList = new ArrayList<>();
		populateList(root);
	}
	
	private void populateList(Node root) {
		if(root != null) {
			populateList(root.left);
			nodeList.add(root.data);
			populateList(root.right);
		}
	}
	
	public boolean hasNext() {
		return nodeList.size() != 0;
	}
	
	public int next() {
		if(hasNext())
			return nodeList.remove(0);
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(7);
		bt.root.left = new Node(3);
		bt.root.right = new Node(15);
		bt.root.right.left = new Node(9);
		bt.root.right.right = new Node(20);
		
		BSTIterator obj = new BSTIterator(bt.root);
		System.out.println(obj.next());
		System.out.println(obj.next());
	}

}
