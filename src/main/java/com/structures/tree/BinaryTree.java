package com.structures.tree;

import com.structures.node.BinaryTreeNode;

public class BinaryTree<T> {

    private BinaryTreeNode<T> root;

    public BinaryTree(T value) {
        root = new BinaryTreeNode<>(value);
        root.setLeftNode(new BinaryTreeNode<>());
        root.setRightNode(new BinaryTreeNode<>());
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }
}