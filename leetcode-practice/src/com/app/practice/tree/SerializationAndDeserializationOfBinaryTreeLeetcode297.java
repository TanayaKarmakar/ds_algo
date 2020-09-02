package com.app.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

class Codec {
	public String serialize(TreeNode root) {
		if(root == null)
			return " ";
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<>();
		
		q.add(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if(curr != null) {
					sb.append(curr.val);
					sb.append(",");
					q.add(curr.left);
					q.add(curr.right);
				} else {
					sb.append("null");
					sb.append(",");
				}
			}
		}
		return sb.toString();
	}
	
	public TreeNode deserialize(String data) {
		if(data.equals(" "))
			return null;
		String[] arr = data.split(",");
		
		TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		int i = 1;
		while(!q.isEmpty() && i < arr.length) {
			TreeNode node = q.poll();
			TreeNode left = arr[i].equals("null") ? null: 
				new TreeNode(Integer.parseInt(arr[i]));
			i++;
			
			TreeNode right = arr[i].equals("null") ? null: 
				new TreeNode(Integer.parseInt(arr[i]));
			i++;
			
			node.left = left;
			node.right = right;
			
			if(left != null)
				q.add(left);
			if(right != null)
				q.add(right);
		}
		
		return root;
	}
}

public class SerializationAndDeserializationOfBinaryTreeLeetcode297 {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(1);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.right.left = new TreeNode(4);
		bt.root.right.right = new TreeNode(5);
		
		Codec codec = new Codec();
		
		String data = codec.serialize(bt.root);
		
		bt.root = codec.deserialize(data);

	}

}
