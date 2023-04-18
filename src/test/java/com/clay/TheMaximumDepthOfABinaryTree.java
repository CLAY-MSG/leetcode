package com.clay;

import javax.swing.tree.TreeNode;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class TheMaximumDepthOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15,new TreeNode(99,new TreeNode(101),null),null), new TreeNode(7)));

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if ( root == null){
            return 0;
        }
        return grow(root, 1);
    }
    public static int grow(TreeNode root, int depth) {
        int leftDepth = depth;
        int rightDepth = depth;
        if (root.left == null && root.right == null){
            return depth;
        }
        if (root.left == null){
            rightDepth += grow(root.right, depth);
        }else if (root.right == null){
            leftDepth += grow(root.left, depth);
        }else {
            rightDepth += grow(root.right, depth);
            leftDepth += grow(root.left, depth);
        }
        return Math.max(leftDepth,rightDepth);
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
    }

}


