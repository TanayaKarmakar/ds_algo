package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

public class SymmetricTreeLeetCode101 {

    private static boolean isEqual(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        return t1.val == t2.val && isEqual(t1.left, t2.right) && isEqual(t1.right, t2.left);
    }

    private static boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))
            return true;
        return isEqual(root.left, root.right);
    }

    public static void main(String[] args) {
        BinaryTree bt1 = new BinaryTree();
        bt1.root = new TreeNode(1);
        bt1.root.left = new TreeNode(2);
        bt1.root.right = new TreeNode(2);
        bt1.root.left.left = new TreeNode(3);
        bt1.root.left.right = new TreeNode(4);
        bt1.root.right.left = new TreeNode(4);
        bt1.root.right.right = new TreeNode(3);

        boolean ans = isSymmetric(bt1.root);

        System.out.println(ans);
    }
}
