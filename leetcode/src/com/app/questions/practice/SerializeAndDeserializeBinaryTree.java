package com.app.questions.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.app.questions.practice.BinaryTree.TreeNode;

public class SerializeAndDeserializeBinaryTree {
	private int preIndx = 0;
	
	private void serialize(TreeNode root, List<String> ser) {
		if(root == null) {
			ser.add("-1");
			return;
		} else {
			ser.add(String.valueOf(root.data));
			serialize(root.left, ser);
			serialize(root.right, ser);
		}
	}
	
	public String serialize(TreeNode root) {
		List<String> ser = new ArrayList<>();
		serialize(root, ser);
		
		return ser.toString();
	}
	
	public TreeNode deserialize(List<String> ser) {
		if(ser.size() == 0 || ser.get(0).equals("-1"))
			return null;
		else {
			int val = Integer.parseInt(ser.get(preIndx).trim());
			TreeNode root = new TreeNode(val);
			ser.remove(0);
			root.left = deserialize(ser);
			root.right = deserialize(ser);
			return root;
		}
	}
	
	public TreeNode deserialize(String data) {
		data = data.replace("[", "");
		data = data.replace("]", "");
		String[] els = data.split(",");
		preIndx = 0;
		List<String> ser = new ArrayList<>();
		for(String el: els) {
			ser.add(el);
		}
		return deserialize(ser);
	}
	
	public void preorder(TreeNode root) {
		if(root != null) {
			if(root.data != -1) {
				System.out.print(root.data + " ");
			}
			
			preorder(root.left);
			preorder(root.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.right.left = new TreeNode(4);
		bt.root.right.right = new TreeNode(5);
		
		SerializeAndDeserializeBinaryTree obj = new SerializeAndDeserializeBinaryTree();
		
		String ser = obj.serialize(bt.root);
		
		System.out.println(ser);
		
		bt.root = obj.deserialize(ser);
		
		obj.preorder(bt.root);
		
		System.out.println();

	}

}
