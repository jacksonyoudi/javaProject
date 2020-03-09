package com.algorithm.tree;

public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }


    public static void clear(BinaryTreeNode node) {
        if (node != null) {
            clear(node.getLeft());
            clear(node.getRight());
            node = null;
        }
    }

    public void clear() {
        clear(this.root);
    }


    public boolean isEmpty() {
        return root != null;
    }

    public static int height(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int l = height(node.getLeft());
            int r = height(node.getRight());

            return l > r ? (l + 1) : (r + 1);
        }
    }


    public static int size(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.getLeft()) + size(node.getRight());
        }
    }


    public static void preOrder(BinaryTreeNode node) {
        if (node != null) {
            System.out.println(node.getData());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    public static void inOrder(BinaryTreeNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getData());
            inOrder(node.getRight());
        }
    }


    public static void postOrder(BinaryTreeNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.getData());
        }
    }

}
