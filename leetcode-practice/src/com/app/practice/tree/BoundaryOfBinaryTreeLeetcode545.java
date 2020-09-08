package com.app.practice.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class BoundaryOfBinaryTreeLeetcode545 {
	public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null)
        	return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        result.add(root.val);

        leftBoundary(result, root.left);
        leaves(result, root.left);
        leaves(result, root.right);
        rightBoundary(result, root.right);

        return result;
    }

    private static void leftBoundary(List<Integer> result, TreeNode node) {
    	if (node == null || node.left == null && node.right == null)
    		return;

    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(node);

    	while (!queue.isEmpty()) {
    		TreeNode top = queue.poll();

    		if (top.left == null && top.right == null) 
                continue;
    		
            result.add(top.val);

    		if (top.left != null) {
    			queue.offer(top.left);
    		} else if (top.right != null){
    			queue.offer(top.right);
    		}
    	}
    }

    private static void leaves(List<Integer> result, TreeNode node) {
    	if (node == null)
    		return;

    	Stack<TreeNode> stack = new Stack<>();
    	stack.push(node);

    	while (!stack.isEmpty()) {
    		TreeNode top = stack.pop();

    		if (top.left == null && top.right == null) {
    			result.add(top.val);
    		}

    		if (top.right != null) {
    			stack.push(top.right);
    		}

    		if (top.left != null) {
    			stack.push(top.left);
    		}
    	}
    }

    private static void rightBoundary(List<Integer> result, TreeNode node) {
    	if (node == null)
    		return;
        
        List<Integer> rightResult = new ArrayList<>();
        
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(node);

    	while (!queue.isEmpty()) {
    		TreeNode top = queue.poll();

    		if (top.left == null && top.right == null)
                continue;
            
    		rightResult.add(top.val);

    		if (top.right != null) {
    			queue.offer(top.right);
    		} else if (top.left != null) {
    			queue.offer(top.left);
    		}
    	}
        
        Collections.reverse(rightResult);
        result.addAll(rightResult);
    }

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.left.left = new TreeNode(4);
		bt.root.left.right = new TreeNode(5);
		bt.root.left.right.left = new TreeNode(7);
		bt.root.left.right.right = new TreeNode(8);
		bt.root.right.left = new TreeNode(6);
		bt.root.right.left.left = new TreeNode(9);
		bt.root.right.left.right = new TreeNode(10);

		List<Integer> res = boundaryOfBinaryTree(bt.root);

		System.out.println(res);

	}

}
