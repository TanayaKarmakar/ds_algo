package com.app.practice.tree;

import com.app.practice.BinaryTree;
import com.app.practice.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalIILeetCode107 {
    private static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        q.add(root);

        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);

                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            result.add(0, list);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(9);
        bt.root.right = new TreeNode(20);
        bt.root.right.left = new TreeNode(15);
        bt.root.right.right = new TreeNode(7);

        List<List<Integer>> list = levelOrderBottom(bt.root);

        System.out.println(list);
    }
}
