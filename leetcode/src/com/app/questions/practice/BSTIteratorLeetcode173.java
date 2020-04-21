package com.app.questions.practice;

import java.util.ArrayList;
import java.util.List;

import com.app.questions.practice.BinaryTree.TreeNode;

public class BSTIteratorLeetcode173 {
	private List<Integer> nodes;
	
	public BSTIteratorLeetcode173(TreeNode root) {
		nodes = new ArrayList<>();
		populateTree(root);
	}
	
	public int next() {
		if(!nodes.isEmpty()) {
			int el = nodes.remove(0);
			return el;
		}
		return -1;
	}
	
	public boolean hasNext() {
		if(nodes.isEmpty())
			return false;
		return true;
	}
	
	private void populateTree(TreeNode root) {
		if(root != null) {
			populateTree(root.left);
			nodes.add(root.data);
			populateTree(root.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(7);
		bt.root.left = new TreeNode(3);
		bt.root.right = new TreeNode(15);
		bt.root.right.left = new TreeNode(9);
		bt.root.right.right = new TreeNode(20);
		
		BSTIteratorLeetcode173 obj = new BSTIteratorLeetcode173(bt.root);
		System.out.println(obj.next());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());

	}

}
