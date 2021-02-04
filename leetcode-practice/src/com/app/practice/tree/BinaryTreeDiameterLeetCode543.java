package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class BinaryTreeDiameterLeetCode543 {
    private static Pair heightDia(TreeNode root) {
        if(root == null) {
            return new Pair(0, 0);
        }
        Pair l = heightDia(root.left);
        Pair r = heightDia(root.right);

        int option1 = l.first + r.first;
        int option2 = l.second;
        int option3 = r.second;

        int height = 1 + Integer.max(l.first, r.first);
        int diameter = Integer.max(option1, Integer.max(option2, option3));
        return new Pair(height, diameter);
    }

    private static int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        Pair pair = heightDia(root);
        return pair.second;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);

        int ans = diameterOfBinaryTree(bt.root);

        System.out.println(ans);
    }
}
