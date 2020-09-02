package com.app.practice.tree;

import java.util.ArrayList;
import java.util.List;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

class BSTIterator {
	List<Integer> list;
	
	public BSTIterator(TreeNode root) {
		list = new ArrayList<>();
		traverse(root);
	}
	
	public int next() {
		if(hasNext())
			return list.remove(0);
		return Integer.MAX_VALUE;
	}
	
	public boolean hasNext() {
		return list.size() > 0;
	}
	
	private void traverse(TreeNode root) {
		if(root != null) {
			traverse(root.left);
			list.add(root.val);
			traverse(root.right);
		}
	}
}

public class BinarySearchTreeIteratorLeetcode173 {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(7);
		bt.root.left = new TreeNode(3);
		bt.root.right = new TreeNode(15);
		bt.root.right.left = new TreeNode(9);
		bt.root.right.right = new TreeNode(20);
		
		BSTIterator bItr = new BSTIterator(bt.root);
		System.out.println(bItr.next());
		System.out.println(bItr.next());
		System.out.println(bItr.hasNext());
		System.out.println(bItr.next());
		System.out.println(bItr.hasNext());
		System.out.println(bItr.next());
		System.out.println(bItr.hasNext());
		System.out.println(bItr.next());
		System.out.println(bItr.hasNext());
		

	}

}
