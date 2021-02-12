package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class PathSumLeetcode112 {
    private static boolean pathSum(TreeNode root, int targetSum, int currentSum) {
        if(root == null)
            return false;
        boolean isLeaf = (root.left == null && root.right ==null);
        if(isLeaf) {
            if(currentSum + root.val == targetSum)
                return true;
            else
                return false;
        }
        currentSum += root.val;
        return pathSum(root.left, targetSum, currentSum)
                || pathSum(root.right, targetSum, currentSum);
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, 0);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(5);
        bt.root.left = new TreeNode(4);
        bt.root.right = new TreeNode(8);
        bt.root.left.left = new TreeNode(11);
        bt.root.left.left.left = new TreeNode(7);
        bt.root.left.left.right = new TreeNode(2);
        bt.root.right.left = new TreeNode(13);
        bt.root.right.right = new TreeNode(4);
        bt.root.right.right.right = new TreeNode(1);

        int sum = 22;

        boolean ans = hasPathSum(bt.root, sum);
        System.out.println(ans);

    }
}
