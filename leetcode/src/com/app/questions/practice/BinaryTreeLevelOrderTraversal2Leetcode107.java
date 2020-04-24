package com.app.questions.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.app.questions.practice.BinaryTree.TreeNode;

public class BinaryTreeLevelOrderTraversal2Leetcode107 {
	private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
        	return res;
        q.add(root);
        q.add(null);
        List<Integer> item = new ArrayList<>();
        res.add(item);
        while(q.size() > 1) {
        	TreeNode node = q.poll();
        	if(node == null) {
        		item = new ArrayList<>();
        		res.add(0, item);
        		q.add(null);
        		continue;
        	}
        	res.get(0).add(node.data);
        	if(node.left != null) {
        		q.add(node.left);
        	}
        	if(node.right != null) {
        		q.add(node.right);
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(3);
		bt.root.left = new TreeNode(9);
		bt.root.right = new TreeNode(20);
		bt.root.right.left = new TreeNode(15);
		bt.root.right.right = new TreeNode(7);
		
		List<List<Integer>> res = levelOrder(bt.root);
		
		System.out.println(res);
		
		bt = new BinaryTree();
		
		res = levelOrder(bt.root);
		
		System.out.println(res);

	}

}
