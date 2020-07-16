package com.app.questions.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.app.questions.practice.BinaryTree;
import com.app.questions.practice.BinaryTree.TreeNode;

class Codec {
	public String serialize(TreeNode root) {
		if(root == null)
			return "";
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new LinkedList<>();
		
		q.add(root);
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if(node != null) {
					sb.append(node.data);
					sb.append(",");
					q.add(node.left);
					q.add(node.right);
				} else {
					sb.append("null,");
				}
			}
		}
		
		return sb.toString();
	}
	
	public TreeNode deserialize(String data) {
		if(data.equals(""))
			return null;
		Queue<TreeNode> q = new LinkedList<>();
		String[] arr = data.split(",");
		
		TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
		int i = 1;
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			TreeNode left = arr[i].equals("null") ? null: new TreeNode(Integer.parseInt(arr[i]));
			i++;
			TreeNode right = arr[i].equals("null") ? null: new TreeNode(Integer.parseInt(arr[i]));
			i++;
			curr.left = left;
			curr.right = right;
			if(left != null)
				q.add(left);
			if(right != null)
				q.add(right);
		}
		return root;
	}
}

public class SerializeAndDeserializeLeetcode297 {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
//		bt.root = new TreeNode(1);
//		bt.root.left = new TreeNode(2);
//		bt.root.right = new TreeNode(3);
//		
//		bt.root.right.left = new TreeNode(4);
//		bt.root.right.right = new TreeNode(5);
		
		bt.root = new TreeNode(5);
		bt.root.left = new TreeNode(2);
		bt.root.right = new TreeNode(3);
		bt.root.right.left = new TreeNode(2);
		bt.root.right.right = new TreeNode(4);
		bt.root.right.left.left = new TreeNode(3);
		bt.root.right.left.right = new TreeNode(1);
		
		
		Codec codec = new Codec();
		String data = codec.serialize(bt.root);
	
		System.out.println(data);

		bt.root = codec.deserialize(data);
	}

}
