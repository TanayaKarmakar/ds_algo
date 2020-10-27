package com.app.questions.tree;

import com.app.augustchallenge.BinaryTree.TreeNode;
import com.app.augustchallenge.BinaryTree;

public class MaxDifferenceBetweenNodeAndAncestorLeetcode1026 {
	private static int maxVal = Integer.MIN_VALUE;
	
    public static int maxAncestorDiff(TreeNode root) {
        if(root == null)
            return 0;
        maxVal = Integer.MIN_VALUE;
        maxDiff(root);
        return maxVal;
    }
    
    private static void maxDiff(TreeNode root) {
        if(root == null)
            return;
        maxDiffRec(root, root.left);
        maxDiffRec(root, root.right);
        maxDiff(root.left);
        maxDiff(root.right);
    }
    
    private static void maxDiffRec(TreeNode ancestor, TreeNode node) {
        if(node == null) {
            maxVal = Integer.max(maxVal, 0);
            return;
        }
        maxVal = Integer.max(maxVal, Math.abs(ancestor.val - node.val));
        maxDiffRec(ancestor, node.left);
        maxDiffRec(ancestor, node.right);
    }
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new TreeNode(8);
		bt.root.left = new TreeNode(3);
		bt.root.right = new TreeNode(10);
		bt.root.left.left = new TreeNode(1);
		bt.root.left.right = new TreeNode(6);
		bt.root.left.right.left = new TreeNode(4);
		bt.root.left.right.right = new TreeNode(7);
		bt.root.right.right = new TreeNode(14);
		bt.root.right.right.left = new TreeNode(13);
		
		int ans = maxAncestorDiff(bt.root);
		
		System.out.println(ans);
		

	}

}
