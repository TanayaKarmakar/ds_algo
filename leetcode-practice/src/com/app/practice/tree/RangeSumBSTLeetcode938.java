package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class RangeSumBSTLeetcode938 {
    private static int sum = 0;

    private static int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        if(root.val > high)
            sum(root.left, low, high);
        else if(root.val < low)
            sum(root.right, low, high);
        else {
            sum(root.left, low, high);
            sum(root.right, low, high);
            sum += root.val;
        }

        return sum;
    }

    private static void sum(TreeNode root, int low, int high) {
        if(root == null)
            return;
        if(root.val >= low && root.val <= high)
            sum += root.val;
        sum(root.left, low, high);
        sum(root.right, low, high);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(10);
        bt.root.left = new TreeNode(5);
        bt.root.right = new TreeNode(15);
        bt.root.left.left = new TreeNode(3);
        bt.root.left.right = new TreeNode(7);
        bt.root.left.left.left = new TreeNode(1);
        bt.root.left.right.left = new TreeNode(6);
        bt.root.right.left = new TreeNode(13);
        bt.root.right.right = new TreeNode(18);

        int low = 6;
        int high = 10;

        int ans = rangeSumBST(bt.root, low, high);
        System.out.println(ans);
    }
}
