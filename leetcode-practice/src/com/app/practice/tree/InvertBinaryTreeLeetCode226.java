package com.app.practice.tree;


import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class InvertBinaryTreeLeetCode226 {
    private static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if(node.left != null)
                q.add(node.left);

            if(node.right != null)
                q.add(node.right);

        }
        return root;
    }

    private static void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            System.out.print(node.val + " ");

            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(4);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(7);
        bt.root.left.left = new TreeNode(1);
        bt.root.left.right = new TreeNode(3);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(9);

        bt.root = invertTree(bt.root);
        levelOrder(bt.root);
    }
}
