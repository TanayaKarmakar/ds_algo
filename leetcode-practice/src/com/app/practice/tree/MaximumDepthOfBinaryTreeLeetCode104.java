package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class MaximumDepthOfBinaryTreeLeetCode104 {
    private static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Integer.max(left, right);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(9);
        bt.root.right = new TreeNode(20);
        bt.root.right.left = new TreeNode(15);
        bt.root.right.right = new TreeNode(7);

        int ans = maxDepth(bt.root);

        System.out.println(ans);
    }
}
