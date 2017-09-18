package com.structures.tree;

import com.structures.node.TreeNode;

import java.util.ArrayList;

public class Tree<T> {

    private TreeNode<T> root;

    public Tree(T value) {
        root = new TreeNode<>(value);
        root.setChildren(new ArrayList<>());
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }
}
