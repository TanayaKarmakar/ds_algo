package com.app.practice;

import java.util.Queue;
import java.util.LinkedList;

import com.app.practice.BinaryTree.TreeNode;

public class SumOfRootToLeafNumbersLeetcode129 {
	private static int sumNumbers(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		q1.add(root);
		q2.add(root.val);
		
		int sum = 0;
		while(!q1.isEmpty()) {
			TreeNode node = q1.poll();
			int num = q2.poll();
			
			if(node.left == null && node.right == null) {
				sum += num;
				continue;
			}
			if(node.left != null) {
				int newNum = (num * 10) + node.left.val;
				q2.add(newNum);
				q1.add(node.left);
			}
			if(node.right != null) {
				int newNum = (num * 10) + node.right.val;
				q2.add(newNum);
				q1.add(node.right);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		int sum = sumNumbers(root);
		
		System.out.println(sum);
		
		root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		
		sum = sumNumbers(root);
		
		System.out.println(sum);

	}

}
