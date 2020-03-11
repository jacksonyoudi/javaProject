package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left);
            }
            res.add(root.val);
            if (root.right != null) {
                inorderTraversal(root.right);
            }
        }
        return res;
    }
}
