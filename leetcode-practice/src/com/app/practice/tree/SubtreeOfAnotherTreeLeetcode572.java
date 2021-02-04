package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;


public class SubtreeOfAnotherTreeLeetcode572 {
    private static boolean isEqual(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        return (s.val == t.val) && isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }

    private static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return false;
        if(isEqual(s, t))
            return true;
        boolean l = isSubtree(s.left, t);
        boolean r = isSubtree(s.right, t);
        return l || r;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(4);
        bt.root.right = new TreeNode(5);
        bt.root.left.left = new TreeNode(1);
        bt.root.left.right = new TreeNode(2);
        bt.root.left.right.left = new TreeNode(0);

        BinaryTree target = new BinaryTree();
        target.root = new TreeNode(4);
        target.root.left = new TreeNode(1);
        target.root.right = new TreeNode(2);

        boolean ans = isSubtree(bt.root, target.root);

        System.out.println(ans);
    }
}
