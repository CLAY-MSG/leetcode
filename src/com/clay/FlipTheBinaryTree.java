package com.clay;


import javax.swing.tree.TreeNode;
import java.util.Stack;

/**
 * 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class FlipTheBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(invertTree(root));

    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        preTree(root);
        return root;
    }

    public static void preTree(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null){
            preTree(root.left);
        }
        if(root.right != null){
            preTree(root.right);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
